package com.tjetc.service.entity;

import java.math.BigDecimal;

/**
 * 商品表
 */
public class Product {
    private Integer product_id;
    private String product_name;
    private BigDecimal price;
    private int stock;
    private String gpicture;
    private int category_id;
    private int status_id;
    private String des;
    private int one;
    private int two;

    public Product(Integer product_id,String product_name, BigDecimal price, int stock, String gpicture,  String des,int one,int two) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.stock = stock;
        this.gpicture = gpicture;
        this.des = des;
        this.one=one;
        this.two=two;
    }
    public Product(String product_name, BigDecimal price, int stock, String gpicture,  String des,int one,int two) {
        this.product_name = product_name;
        this.price = price;
        this.stock = stock;
        this.gpicture = gpicture;
        this.des = des;
        this.one=one;
        this.two=two;
    }

    public Product() {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getstock() {
        return stock;
    }

    public void setstock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getgpicture() {
        return gpicture;
    }

    public void setgpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }
}
