package com.tjetc.admin.controller.img;

import com.tjetc.admin.common.CommonConstants;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取图片servlet
 */
@WebServlet(urlPatterns = {"*.jpg", "*.png", "*.jpeg", "*.gif"})
public class ImageDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取uri路径 (例如： /my_shop_admin/20210626/1.jpg)
        String requestURI = req.getRequestURI();
        //上下文路径 （例如：/my_shop_admin）
        String contextPath = req.getContextPath();
        //图片url路径 （例如：/20210626/1.jpg）
        String imageUrlPath = requestURI.replace(contextPath, "");
        //图片的后缀名（文件类型）
        String imageSuffix = imageUrlPath.substring(imageUrlPath.lastIndexOf(".") + 1).toLowerCase();
        //图片真实的物理路径 （例如：E:/image/20210626/1.jpg）
        String imageRealPath = CommonConstants.IMG_BASE_PATH + imageUrlPath;
        //实例化文件对象
        File file = new File(imageRealPath);
        //文件不存在返回状态码404
        if (!file.exists()) {
            resp.setStatus(404);
            return;
        }
        //设置响应数据格式
        resp.setContentType("image/" + imageSuffix);
        //输出流
        ServletOutputStream sos = resp.getOutputStream();
        //文件输入流
        FileInputStream fis = new FileInputStream(file);
        //设置缓存
        byte[] buffer = new byte[1024];
        int len;
        //循环读取图片存储到buffer缓存中
        while ((len = fis.read(buffer)) != -1) {
            //输出
            sos.write(buffer, 0, len);
        }
        //关闭流
        fis.close();
        sos.close();
    }
}
