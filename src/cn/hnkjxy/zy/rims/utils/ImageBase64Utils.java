package cn.hnkjxy.zy.rims.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 图片Base64互转工具类
 *
 * @author 10248
 */
public class ImageBase64Utils {
    final private static String imgPath = "./img/dish_img/";

    /**
     * 本地图片转换成base64字符串
     *
     * @param imgFile 图片本地路径
     * @return Base64字符串
     */
    public static String base64ImageReadByLocal(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in;

        //文件名加上图片路径
        imgFile += imgPath;

        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        //返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

//    /**
//     * 在线图片转换成base64字符串
//     *
//     * @param imgURL 图片线上路径
//     * @return Base64字符串
//     */
//    public static String imageToBase64ByOnline(String imgURL) {
//        ByteArrayOutputStream data = new ByteArrayOutputStream();
//        try {
//            // 创建URL
//            URL url = new URL(imgURL);
//            byte[] by = new byte[1024];
//            // 创建链接
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(5000);
//            InputStream is = conn.getInputStream();
//            // 将内容读取内存中
//            int len = -1;
//            while ((len = is.read(by)) != -1) {
//                data.write(by, 0, len);
//            }
//            // 关闭流
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 对字节数组Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data.toByteArray());
//    }

    /**
     * base64字符串转换成图片
     *
     * @param imgStr      base64字符串
     * @param imgFilePath 图片存放路径
     */
    public static boolean base64ImageSaveToLocal(String imgStr, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片

        //文件名加上图片路径
        imgFilePath += imgPath;

        //判断图像数据为空
        if (imgStr == null || "".equals(imgStr)) {
            return false;
        }

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}

