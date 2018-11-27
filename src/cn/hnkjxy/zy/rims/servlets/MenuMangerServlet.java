package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.utils.MenuMangerUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 10248
 */
@WebServlet(name = "MenuMangerServlet", urlPatterns = "/MenuManger", loadOnStartup = 0)
public class MenuMangerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init MenuMangerServlet");
        MenuMangerUtils.updateMenu();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        MenuMangerUtils.updateMenu();
    }
}
