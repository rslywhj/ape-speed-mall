package com.tjetc.service.service;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.Category;
import com.tjetc.service.entity.First;
import com.tjetc.service.entity.Product;
import com.tjetc.service.entity.Second;

import java.util.Map;

public interface ProductService {

    AdminPageResult<Product> listWarningProduct(int start,int pageSize,int num);
    AdminPageResult<Category>listCategory(int start, int pageSize);
    boolean addCategory(String first_name,String second_name);
    AdminPageResult<First>listFirst();
    AdminPageResult<Second>listSecond(int first_id);



    /**
     *  分页查询product
     * @param pageNo    页码
     * @param pageSize  每页数量
     * @return
     */
    AdminPageResult<Product> page(int pageNo,int pageSize);

    /**
     * 下架商品
     * @param product_id
     * @return
     */
    boolean soldOut(Integer product_id);

    /**
     * 分页查询仓库 -- status_id = 0
     * @param pageNo
     * @param pageSize
     * @return
     */
    AdminPageResult<Product> pageWare(int pageNo,int pageSize);

    /**
     * 上架商品
     * @param product_id
     * @return
     */
    boolean putaway(Integer product_id);


    Map<Integer,Long> findCount();

    /**
     * 添加商品
     */
    boolean addProduct(Product product);
    /**
     * 查询商品是否存在
     * 
     */
    boolean productCount(String product_name);

    /**
     * 全部上架
     *
     * @return
     */
    boolean allStores();
}
