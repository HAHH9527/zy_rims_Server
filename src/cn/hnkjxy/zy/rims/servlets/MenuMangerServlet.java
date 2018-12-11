package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.utils.MenuMangerUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 10248
 */
@WebServlet(name = "MenuMangerServlet", urlPatterns = "/MenuManger", loadOnStartup = 0)
public class MenuMangerServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init MenuMangerServlet");
        MenuMangerUtils.updateMenu();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        MenuMangerUtils.updateMenu();

        PrintWriter out = response.getWriter();

        out.write("刷新成功");
    }

}
