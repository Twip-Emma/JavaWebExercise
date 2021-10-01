package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CharacterServlet", value = "/CharacterServlet")
public class CharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));
        response.getWriter().print("你的用户名是<br/>" + request.getParameter("name") + "通行证是<br>" + request.getParameter("password"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
