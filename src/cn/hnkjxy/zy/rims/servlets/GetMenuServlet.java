package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableDishEntity;
import cn.hnkjxy.zy.rims.datebase.dao.DishDao;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 10248
 */
@WebServlet(name = "GetMenuServlet", urlPatterns = "/GetMenu")
public class GetMenuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("收到GetMenu请求");

        DishDao dao = new DishDao();

        List<TableDishEntity> tableDishEntityList = dao.getMenu();

        Gson gson = new Gson();

        String menuJson = gson.toJson(tableDishEntityList);

        PrintWriter out = response.getWriter();

        out.print(menuJson);
    }

}
