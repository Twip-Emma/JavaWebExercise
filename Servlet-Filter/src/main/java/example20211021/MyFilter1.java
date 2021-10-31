package example20211021;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter1" ,value = "/OrderServlet")
public class MyFilter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        Object card = req.getSession().getAttribute("card");
        if(card != null){
            chain.doFilter(request,response);
        }else{
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("/Servlet_Filter_war/login.html");
            System.out.println("未登录的用户尝试前往订单页面，已阻止");
        }
    }
}
