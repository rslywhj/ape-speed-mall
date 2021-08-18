package com.tjetc.admin.controller.porduct;

import com.tjetc.admin.common.CommonConstants;
import com.tjetc.admin.model.JsonResult;
import com.tjetc.service.entity.Product;
import com.tjetc.service.service.ProductService;
import com.tjetc.service.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet("/addProductServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024 * 1024 * 1024, fileSizeThreshold = 1024 * 1024)
//开启对上传文件的支持
public class AddProductServlet extends HttpServlet {


    ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String image_address = null;

        //上传图片
        //获取文件的请求参数file，返回对象是Part
        Part part = request.getPart("file");
        JsonResult jsonResult = null;
        //判断part是否空或者大小为0，不为空或者大小不为继续操作
        if (part != null && part.getSize() > 0) {
            //根据part对象获取上传文件的名称
            String fileName = part.getSubmittedFileName();
            int lastIndexOf = fileName.lastIndexOf(".");
            //获取文件后缀名
            String suffix = fileName.substring(lastIndexOf + 1).toLowerCase();
            String imageBasePath = CommonConstants.IMG_BASE_PATH;
            //获取配置上传图片的类型数组（配置使用逗号分割的字符串）
            String[] strImageUploadTypes = CommonConstants.IMG_UPLOAD_TYPE.split(",");
            //获上传图片的类型数组转换成集合
            List<String> imageUploadTypes = Arrays.asList(strImageUploadTypes);
            //判断上传图片的类型是否符合要求
            if (imageUploadTypes.contains(suffix)) {
                //获取当前日期字符串 如：20210626
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
                String strDate = df.format(LocalDate.now());

                //获取保存文件的路径
                //根据保存的文件路径创建File对象，判断File对象是否存在，不存在创建文件夹
                File file = new File(CommonConstants.IMG_BASE_PATH + "/" + strDate);
                if (!file.exists()) {
                    //创建目录
                    file.mkdirs();
                }

                //拼接图片的url路径（新名称，不能重复，否则会有覆盖的风险） 文件夹是日期 20210626  uuid
                String imageUrlPath = strDate + "/" + UUID.randomUUID().toString().replace("-", "") + "." + suffix;
                //利用part.write()把上传的文件写入磁盘中 例如：D:/image/20210701/312313jjkj.jpg
                part.write(imageBasePath + "/" + imageUrlPath);

                //上下文路径 （例如：/my_shop_admin）
                String contextPath = request.getContextPath();

                image_address  = "http://192.168.60.32:8080"+"/my_shop_user"+"/img/"+imageUrlPath;

                //响应数据，上传成功
                jsonResult = new JsonResult(0, "上传成功", imageUrlPath);

                //添加商品
                String product_name = request.getParameter("product_name");
                BigDecimal price =BigDecimal.valueOf(Double.valueOf(request.getParameter("price")));
                String strNum = request.getParameter("num");
                Integer stock = Integer.parseInt(strNum);
                String  strCid= request.getParameter("first_id");
                Integer category_id = Integer.parseInt(strCid);
                String strTid = request.getParameter("second_id");
                Integer tid = Integer.parseInt(strTid);
                String des = request.getParameter("des");
                Product product = new Product(product_name,price,stock,image_address,des,category_id,tid);


                boolean bl1 = productService.productCount(product_name);
                session.setAttribute("bl1",bl1);

                if (bl1){  //代表商品已经存在，不能添加
                    request.getRequestDispatcher("admin/addProduct.jsp").forward(request,response);
                }else {     //代表商品不存在，可以添加
                    boolean bl2 = productService.addProduct(product);
                    if (bl2){    //如果添加成功，跳到仓库
                        request.getRequestDispatcher("admin/listing.jsp").forward(request,response);
                    }
                }

            } else {
                jsonResult = new JsonResult(0, "文件格式不正确,只能上传" + CommonConstants.IMG_UPLOAD_TYPE + "文件", null);
                response.getWriter().write("");
            }
        } else {
            jsonResult = new JsonResult(0, "没有上传的文件", null);
        }

//        response.getWriter().write(JSONObject.toJSONString(jsonResult));







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
