package cn.hnkjxy.zy.rims.servlets;

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
@WebServlet(name = "OrderMangerServlet", urlPatterns = "/OrderManger", loadOnStartup = 0)
public class OrderMangerServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init OrderMangerServlet");
        OrderMangerUtils.updateOrderList();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        OrderMangerUtils.updateOrderList();

        PrintWriter out = response.getWriter();

        out.write("刷新成功");
    }

}
