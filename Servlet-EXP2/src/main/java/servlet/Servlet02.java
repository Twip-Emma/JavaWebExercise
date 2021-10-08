package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "exp02", value = "/exp02")
public class Servlet02 extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet  开始");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet 销毁");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet 初始化");
    }
}
