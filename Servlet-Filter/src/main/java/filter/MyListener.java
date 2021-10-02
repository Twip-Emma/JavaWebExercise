package filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletContextListener, HttpSessionListener, ServletRequestListener{
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext 对象被创建了");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext 被销毁了");
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequest 被创建了");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequest 被销毁了");
    }

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSession 被创建了");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSession 被销毁了");
    }
}
