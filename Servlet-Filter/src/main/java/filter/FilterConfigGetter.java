package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "FilterConfigGetter",value = "/MyServlet")
public class FilterConfigGetter implements Filter {
    FilterConfig fc;
    public void init(FilterConfig config) throws ServletException {
        this.fc = config;// 获取FilterConfig对象
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String initParameter = fc.getInitParameter("encoding");
        System.out.println("encoding初始化参数是：" + initParameter);
        chain.doFilter(request, response);
    }
}
