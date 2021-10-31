package example20211021;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String card = request.getParameter("card");
        String pass = request.getParameter("pass");

        request.getSession().setAttribute("card", card);
        request.getSession().setAttribute("pass", pass);

        response.sendRedirect("/Servlet_Filter_war/OrderServlet");
        System.out.println("用户：" + card + "登陆了！");
    }
}
