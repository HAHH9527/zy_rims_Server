package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;
import cn.hnkjxy.zy.rims.utils.OrderMangerUtils;
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
@WebServlet(name = "CheckServlet", urlPatterns = "/Check")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        InputStream inputStream = request.getInputStream();
        String body = IOUtils.toString(inputStream, "utf-8");
        System.out.println(body);

        PrintWriter out = response.getWriter();

        try {
            TableOrderEntity tableOrderEntity = new Gson().fromJson(body, TableOrderEntity.class);
            if (OrderMangerUtils.checkOrder(tableOrderEntity)) {
                out.write("true");
            } else {
                out.write("false");
            }
        } catch (Exception e) {
            out.write("false");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        String orderIdStr = request.getParameter("orderId");

        try {
            int orderId = Integer.valueOf(orderIdStr);
            out.write(OrderMangerUtils.getOrderToCheck(orderId));
        } catch (Exception e) {
            out.write("ERROR");
            e.printStackTrace();
        }
    }

}
