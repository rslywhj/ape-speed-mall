package com.tjetc.service.service.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.dao.ProductDao;
import com.tjetc.service.dao.impl.ProductDaoImpl;
import com.tjetc.service.entity.Category;
import com.tjetc.service.entity.First;
import com.tjetc.service.entity.Product;
import com.tjetc.service.entity.Second;
import com.tjetc.service.service.ProductService;

import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();


    @Override
    public AdminPageResult<Product> listWarningProduct(int start, int pageSize, int num) {
        return productDao.selectWarning(start,pageSize,num);
    }

    @Override
    public AdminPageResult<Category> listCategory(int start, int pageSize) {
        return productDao.selectCategory(start,pageSize);
    }


    @Override

    public boolean addCategory(String first_name, String second_name) {
        int fid = productDao.insertFist_level(first_name);

        int sid = productDao.insertSecond_level(second_name);
        boolean bl = productDao.insertCategory(fid, sid);
        return bl;
    }

    @Override
    public AdminPageResult<First> listFirst() {
        return productDao.selectFirst();
    }

    @Override
    public AdminPageResult<Second> listSecond(int first_id) {
        return productDao.selectSecond(first_id);
    }
    


    @Override
    public AdminPageResult<Product> page(int pageNo, int pageSize) {
        return productDao.selectPage(pageNo, pageSize);
    }

    @Override
    public boolean soldOut(Integer product_id) {
        return productDao.soldOut(product_id);

    }

    @Override
    public AdminPageResult<Product> pageWare(int pageNo, int pageSize) {
        return productDao.selectSoldOutPage(pageNo, pageSize);
    }

    @Override
    public boolean putaway(Integer product_id) {
        return productDao.putaway(product_id);
    }

    @Override
    public Map<Integer, Long> findCount() {
        Map<Integer, Long> map = productDao.findCount();
        if (map!=null){
            return map;
        }else {
            map.put(1,0L);
            map.put(2,0L);
        }
        return map;
    }

    @Override
    public boolean addProduct(Product product) {
            Boolean aBoolean = productDao.addProduct(product);
            return aBoolean;
    }

    @Override
    public boolean productCount(String product_name) {
        Long count = productDao.productCount(product_name);
        if (count == 0) {   //如果没有商品，返回false
            return false;
        }
        return true;       //代表商品已存在
    }

    @Override
    public boolean allStores() {
        return productDao.allStores();

    }
}
