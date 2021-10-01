package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@WebFilter(filterName = "CharacterFilter",value = "*")
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
        response.setContentType("text/html;charset=utf-8");
        CharacterRequest characterRequest = new CharacterRequest(req);
        chain.doFilter(characterRequest, resp);
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

