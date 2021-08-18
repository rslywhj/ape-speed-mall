package com.tjetc.service.entity;

import java.math.BigDecimal;

public class Goods {
    /**
     * 商品ID
     */
    private long gid;
    /**
     * 商品名称
     */
    private String gname;
    /**
     * 商品描述
     */
    private String desc;
    /**
     * 商品图片
     */
    private String gpicture;
    /**
     * 商品价格
     */
    private BigDecimal gprice;
    /**
     * 销量
     */
    private Long sales_volume;
    /**
     * 商品库存
     */
    private Long stock;
    /**
     * 预警库存
     */
    private Long surplus;
    /**
     * 商品状态
     */
    private int gstatus;
    /**
     * 所属分类
     */
    private Long tid;
    /**
     * 是否包邮
     */
    private String express;
    
    public Goods() {
    }
    
    public Goods(long gid, String gname, String desc, String gpicture, BigDecimal gprice, Long sales_volume, Long stock, Long surplus, int gstatus, Long tid, String express) {
        this.gid = gid;
        this.gname = gname;
        this.desc = desc;
        this.gpicture = gpicture;
        this.gprice = gprice;
        this.sales_volume = sales_volume;
        this.stock = stock;
        this.surplus = surplus;
        this.gstatus = gstatus;
        this.tid = tid;
        this.express = express;
    }
    
    public long getGid() {
        return gid;
    }
    
    public void setGid(long gid) {
        this.gid = gid;
    }
    
    public String getGname() {
        return gname;
    }
    
    public void setGname(String gname) {
        this.gname = gname;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getGpicture() {
        return gpicture;
    }
    
    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }
    
    public BigDecimal getGprice() {
        return gprice;
    }
    
    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }
    
    public Long getSales_volume() {
        return sales_volume;
    }
    
    public void setSales_volume(Long sales_volume) {
        this.sales_volume = sales_volume;
    }
    
    public Long getStock() {
        return stock;
    }
    
    public void setStock(Long stock) {
        this.stock = stock;
    }
    
    public Long getSurplus() {
        return surplus;
    }
    
    public void setSurplus(Long surplus) {
        this.surplus = surplus;
    }
    
    public int getGstatus() {
        return gstatus;
    }
    
    public void setGstatus(int gstatus) {
        this.gstatus = gstatus;
    }
    
    public Long getTid() {
        return tid;
    }
    
    public void setTid(Long tid) {
        this.tid = tid;
    }
    
    public String getExpress() {
        return express;
    }
    
    public void setExpress(String express) {
        this.express = express;
    }
}