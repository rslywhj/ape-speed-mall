package com.tjetc.user.entity;

import java.math.BigDecimal;

public class Goods {
    /**
     * 商品名称
     */
    private String product_name;
    /**
     * 商品图片地址
     */
    private String image;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品库存
     */
    private int stock;
    /**
     * 商品描述
     */
    private String des;
   

    public Goods() {
    }
    
    public Goods(String product_name, String image, BigDecimal price, int stock, String des) {
        this.product_name = product_name;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.des = des;
    }
    
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
}
