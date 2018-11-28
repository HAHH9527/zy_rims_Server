package cn.hnkjxy.zy.rims.servlets;

import cn.hnkjxy.zy.rims.bean.datebase.entity.TableOrderEntity;
import cn.hnkjxy.zy.rims.utils.OrderMangerUtils;
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
@WebServlet(name = "OrderServlet", urlPatterns = "/Order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        InputStream inputStream = request.getInputStream();
        String body = IOUtils.toString(inputStream, "utf-8");

        TableOrderEntity tableOrderEntity = new Gson().fromJson(body, TableOrderEntity.class);

        PrintWriter out = response.getWriter();

        //判断是更新还是新增
        if (tableOrderEntity.getOrderId() > 0) {

        } else {
            int orderId = OrderMangerUtils.newOrder(tableOrderEntity);
            if (orderId != -1) {
                out.write("新增订单成功,订单id为(" + orderId + ")");
            } else {
                out.write("新增订单失败");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("收到GetMenu请求");

        PrintWriter out = response.getWriter();

        out.print(OrderMangerUtils.getWaitingOrderListJson());
    }
}
