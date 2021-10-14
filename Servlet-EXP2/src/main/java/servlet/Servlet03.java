package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "exp03", value = "/exp03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null && session.getAttribute("token")!=null){
            response.sendRedirect("/Servlet_EXP2_war/error.html");
        }

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        session.setAttribute("username",username);
        String password = request.getParameter("password");
        String nowTime = new Date().toString();
        String token = nowTime + username + password;
        session.setAttribute("token", token);

        response.getWriter().print("欢迎您，" + username);

        System.out.println("用户" + username + "登陆了，密码是：" + password);
    }
}
