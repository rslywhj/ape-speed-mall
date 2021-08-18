
package com.tjetc.user.service.impl;

import com.tjetc.user.dao.CartDao;
import com.tjetc.user.dao.impl.CartDaoImpl;
import com.tjetc.user.entity.CartAndPro;
import com.tjetc.user.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();
    @Override
    public List<CartAndPro> findAllCart(Long user_id) {
        return cartDao.selectAllCart(user_id);
    }

    @Override
    public boolean deleteById(Long id) {
        return cartDao.deleteById(id);
    }

    @Override
    public boolean addUpdate(Long id) {
        return cartDao.addById(id);
    }

    @Override
    public boolean updateGoods(Long product_id, int num) {
        Boolean aBoolean = cartDao.delectGoods(product_id, num);
        return aBoolean;
    }

    @Override
    public boolean deleteCart(Long id) {
        Boolean aBoolean = cartDao.deleteCart(id);
        return aBoolean;
    }

    @Override
    public boolean removeById(long id) {
        return cartDao.delById(id);
    }

    @Override
    public boolean delAll(String[] split) {
        return cartDao.delAllById(split);
    }

    @Override
    public boolean addById(CartAndPro cartAndPro) {
        int b = cartDao.selectById(cartAndPro.getUser_id(),cartAndPro.getProduct_id());
        if(b!=0){
            cartAndPro.setNum(b+cartAndPro.getNum());
            boolean b1 = cartDao.addUpdate(cartAndPro);
            return b1;
        }else {
            boolean b2 = cartDao.insertById(cartAndPro);
            return b2;
        }
    }

    @Override
    public int selectByid(Long user_id, Long product_id) {
        return cartDao.selectById(user_id, product_id);
    }


}
