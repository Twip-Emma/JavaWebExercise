package example20211101;

import javax.servlet.*;
import javax.servlet.FilterChain;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "MyFilter3",urlPatterns = "/FilterChain")
public class MyFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter3拦截器触发了");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
