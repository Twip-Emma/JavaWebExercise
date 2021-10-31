package example20211031;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServletExp4", value = "/LoginServletExp4")
public class LoginServletExp4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String autoLogin = request.getParameter("autoLogin");
        String card = request.getParameter("card");
        String pass = request.getParameter("pass");

        if(request.getSession().getAttribute("auto_save_card") == null) {
            if (card.equals("") || pass.equals("")) {
                response.sendRedirect("/Servlet_Filter_war/loginexp4.html");
                System.out.println("登录信息没写全");
                return;
            }
            if (autoLogin != null) {
                request.getSession().setAttribute("auto_save_card", card);
                request.getSession().setAttribute("auto_save_pass", pass);
                System.out.println("保存信息");
            }
            System.out.println("用户" + card + "登陆了");
            response.sendRedirect("/Servlet_Filter_war/infoexp4.html");
        }else{
            String cardAuto = (String) request.getSession().getAttribute("auto_save_card");
            String passAuto = (String) request.getSession().getAttribute("auto_save_pass");
            System.out.println("用户" + cardAuto + "通过自动登录功能登陆了");
            response.sendRedirect("/Servlet_Filter_war/infoexp4.html");
        }
    }
}
