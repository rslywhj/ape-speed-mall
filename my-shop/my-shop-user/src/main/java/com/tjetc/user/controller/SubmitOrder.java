package com.tjetc.user.controller;

import com.google.gson.Gson;
import com.tjetc.user.dao.CartOderDao;
import com.tjetc.user.dao.impl.CartOrderDaoImpl;
import com.tjetc.user.entity.BuyShop;
import com.tjetc.user.entity.CartAndPro;
import com.tjetc.user.entity.User;
import com.tjetc.user.service.CartService;
import com.tjetc.user.service.UserShopService;
import com.tjetc.user.service.impl.CartServiceImpl;
import com.tjetc.user.service.impl.UserShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(urlPatterns = {"/submitOrder"})
public class SubmitOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigDecimal a=new BigDecimal(0);
        UserShopService userShopService= new UserShopServiceImpl();
        CartOderDao cartOderDao= new CartOrderDaoImpl();
        CartService cartService = new CartServiceImpl();
        //buyShop.getConsignee(),buyShop.getVid(),buyShop.getGuest_book(),buyShop.getTotal_amount(),,buyShop.getDistribution(),orderTime,buyShop.getAddress_id()};
        User user = (User) req.getSession().getAttribute("user");
        Long user_id = user.getId();
        //减少商品库存
        //req.getParameterMap()
        String consignee = req.getParameter("consignee");
        String gid = req.getParameter("gid");
        String[] s1=gid.split(",");
        for(int i=0;i<s1.length;i++){
            //循环输出结果
            long l = Long. parseLong(s1[i]);
            List<CartAndPro> list = cartOderDao.SelectPrice(user_id,l);
            for (CartAndPro cartAndPro : list) {
                BigDecimal num = BigDecimal.valueOf(cartAndPro.getNum());
                BigDecimal price = cartAndPro.getPrice();
                BigDecimal total_amount= num.multiply(price);
                boolean b = cartService.updateGoods(l, cartAndPro.getNum());
                boolean b1 = cartService.deleteCart(l);
                a=total_amount.add(a);
            }
        }
        //3、获取参数
        String guest_book = req.getParameter("guest_book");
        String distribution = req.getParameter("distribution");
        String address_id = req.getParameter("address_id");
        BuyShop buyShop = new BuyShop(consignee, user_id, guest_book,a, distribution, address_id);

        //4、调用方法
        Long aLong = userShopService.UserBuyShop(buyShop);
        Gson gson = new Gson();
        String json = gson.toJson(aLong);
        //5、返回json数据格式（因为前端使用ajax技术，所以后端不能跳转）
        //但不要跳转，跳转页面交给前端，后端只负责提供数据
        if (json!=null){
            resp.getWriter().write(json);
        }else {
            resp.getWriter().write("false");
        }
    }
}

