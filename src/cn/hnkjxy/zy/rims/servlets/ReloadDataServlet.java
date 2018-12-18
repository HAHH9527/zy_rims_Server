package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.utils.MenuMangerUtils;
import cn.hnkjxy.zy.rims.utils.OrderMangerUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 10248
 */
@WebServlet(name = "ReloadDataServlet", urlPatterns = "/ReloadData", loadOnStartup = 0)
public class ReloadDataServlet extends HttpServlet {

    @Override
    public void init() {
        MenuMangerUtils.updateMenu();
        OrderMangerUtils.updateOrderList();
        System.out.println("init Data");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("ReloadData");

        MenuMangerUtils.updateMenu();
        OrderMangerUtils.updateOrderList();

        PrintWriter out = response.getWriter();
        out.write("刷新成功");

    }
}
