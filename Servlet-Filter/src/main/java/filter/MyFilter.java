package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "MyFilter", value = "/MyServlet-")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化时会调用，可以用来配置一些初始化参数
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //用于拦截用户请求，如果和当前过滤器的拦截路径匹配，该方法会被调用
        PrintWriter writer = servletResponse.getWriter();
        writer.print("Hello MyFilter");
    }

    @Override
    public void destroy() {
        //过滤器对象在销毁时自动调用
    }
}
