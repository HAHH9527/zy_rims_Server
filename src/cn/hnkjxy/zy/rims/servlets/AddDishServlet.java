package cn.hnkjxy.zy.rims.servlets;

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
@WebServlet(name = "AddDishServlet", urlPatterns = "/AddDish")
public class AddDishServlet extends HttpServlet {
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
        out.write("入参信息：" + bodyInfo);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("收到AddDishGet请求");

        PrintWriter out = response.getWriter();
        String title = "GET访问";
        // 处理中文
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "Get访问" +
                "</body></html>");
    }
}