package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.utils.MenuMangerUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author 10248
 */
@WebServlet(name = "WebAppStartServlet", urlPatterns = "/WebAppStartServlet", loadOnStartup = 0)
public class WebAppStartServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init WebAppStartServlet");
        MenuMangerUtils.updateMenu();
    }
}
