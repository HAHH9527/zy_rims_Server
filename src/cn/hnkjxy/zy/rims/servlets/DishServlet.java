package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.bean.json.TableDishAndBase64Image;
import cn.hnkjxy.zy.rims.utils.MenuMangerUtils;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author 10248
 */
@WebServlet(name = "DishServlet", urlPatterns = "/Dish")
public class DishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        InputStream inputStream = request.getInputStream();
        String bodyInfo = IOUtils.toString(inputStream, "utf-8");

        System.out.println("收到AddDishPost请求");
        System.out.println(bodyInfo);

        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        TableDishAndBase64Image tableDishAndBase64Image = gson.fromJson(bodyInfo, TableDishAndBase64Image.class);
        int dishId = MenuMangerUtils.addDish(tableDishAndBase64Image);

        if (dishId > 0) {
            out.write("添加成功，菜品id为(" + dishId + ")");
        } else {
            out.write("添加失败");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("收到GetMenu请求");

        PrintWriter out = response.getWriter();

        out.print(MenuMangerUtils.getMenuJson());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        InputStream inputStream = request.getInputStream();
        String bodyInfo = IOUtils.toString(inputStream, "utf-8");

        System.out.println("收到Delete请求");
        System.out.println(bodyInfo);

        PrintWriter out = response.getWriter();
        out.write("得到信息：" + bodyInfo);

    }
}
