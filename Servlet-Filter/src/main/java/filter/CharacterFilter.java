package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter(filterName = "CharacterFilter",value = "/xxx")
public class CharacterFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        request.setCharacterEncoding("utf-8");
        String requestContextType = getRequestContextType(req);
        if(requestContextType.equals("json")){
            response.setContentType("application/json;charset=utf-8");
        }else {
            response.setContentType("text/html;charset=utf-8");
        }
        CharacterRequest characterRequest = new CharacterRequest(req);
        chain.doFilter(characterRequest, resp);
    }

    private String getRequestContextType(HttpServletRequest request){
        String requestAccept = request.getHeader("accept");
        String contentType = "text/html";


        if (requestAccept != null) {
            if (requestAccept.contains("application/json") || requestAccept.contains("text/javascript")
                    || requestAccept.contains("text/json")) {
                contentType = "application/json";
            }
        }

        if (contentType.equals("text/html")) {
            return "html";
        } else if (contentType.equals("application/json")) {
            return "json";
        } else {
            return "json";
        }
    }
}

class CharacterRequest extends HttpServletRequestWrapper{
    private HttpServletRequest httpServletRequest;

    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.httpServletRequest = request;
    }

    public String getParameter(String name){
        String parameter = super.getParameter(name);
        if(parameter == null){
            return null;
        }

        String method = super.getMethod();
        if("get".equalsIgnoreCase(method)){
            try {
                parameter = new String(parameter.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }
        }
        return parameter;
    }
}

