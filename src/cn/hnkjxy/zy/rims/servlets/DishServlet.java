package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.bean.json.TableDishAndBase64Image;
import cn.hnkjxy.zy.rims.utils.MenuMangerUtils;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

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
        String body = IOUtils.toString(inputStream, "utf-8");

        PrintWriter out = response.getWriter();

        TableDishAndBase64Image tableDishAndBase64Image = new Gson().fromJson(body, TableDishAndBase64Image.class);

        //判断是更新还是新增
        if (tableDishAndBase64Image.getDishId() > 0) {
            if (MenuMangerUtils.updateDish(tableDishAndBase64Image)) {
                out.write("更新成功");
            } else {
                out.write("更新失败");
            }
        } else {
            int dishId = MenuMangerUtils.addDish(tableDishAndBase64Image);
            if (dishId > 0) {
                out.write("添加成功，菜品id为(" + dishId + ")");
            } else {
                out.write("添加失败");
            }
        }

//        ReturnStatusJson returnStatusJson;
//        //判断是更新还是新增
//        if (tableDishAndBase64Image.getDishId() > 0) {
//            if (MenuMangerUtils.updateDish(tableDishAndBase64Image)) {
//                returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_UPDATE_TRUE, "菜品修改成功");
//            } else {
//                returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_UPDATE_FALSE, "菜品修改失败");
//            }
//        } else {
//            int dishId = MenuMangerUtils.addDish(tableDishAndBase64Image);
//            if (dishId > 0) {
//                returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_ADD_TRUE, "添加菜品成功，菜品id为(" + dishId + ")");
//            } else {
//                returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_ADD_FALSE, "添加菜品失败");
//            }
//        }
//        String outMsg = new Gson().toJson(returnStatusJson);
//        PrintWriter out = response.getWriter();
//        out.write(outMsg);
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

//        ReturnStatusJson returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_LIST, MenuMangerUtils.getMenuJson());
//        String outMsg = new Gson().toJson(returnStatusJson);
//        PrintWriter out = response.getWriter();
//        out.print(outMsg);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        InputStream inputStream = request.getInputStream();
        String body = IOUtils.toString(inputStream, "utf-8");

        System.out.println("收到Delete请求");
        System.out.println(body);
        PrintWriter out = response.getWriter();

        try {
            int dishId = Integer.parseInt(body);
            if (MenuMangerUtils.deleteDish(dishId)) {
                out.write("删除成功");
            } else {
                out.write("删除失败");
            }
        } catch (Exception e) {
            out.write("删除失败");
            e.printStackTrace();
        }

//        ReturnStatusJson returnStatusJson;
//        try {
//            int dishId = Integer.parseInt(body);
//            if (MenuMangerUtils.deleteDish(dishId)) {
//                returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_DELETE_TRUE, "删除成功");
//            } else {
//                returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_DELETE_FALSE, "删除失败");
//            }
//        } catch (Exception e) {
//            returnStatusJson = new ReturnStatusJson(ReturnStatus.DISH_DELETE_FALSE, "删除失败");
//            e.printStackTrace();
//        }
//        String outMsg = new Gson().toJson(returnStatusJson);
//        PrintWriter out = response.getWriter();
//        out.print(outMsg);
    }
}
