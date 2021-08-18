package com.tjetc.service.entity;

import java.math.BigDecimal;

public class OrderManagement {
    /**
     * 订单编号
     */
    private long oid;
    /**
     *收货人
     */
    private String consignee;
    /**
     *用户留言
     */
    private String guest_book;
    /**
     *订单总金额
     */
    private BigDecimal total_amount;
    /**
     *实收金额
     */
    private BigDecimal received_amount;
    /**
     *配送方式
     */
    private String distribution;
    /**
     *下单时间
     */
    private String order_data;
    /**
     *订单状态
     */
    private String state;
    /**
     *申请人
     */
    private String applicant;
    /**
     *申请退款金额
     */
    private BigDecimal refund_amount;
    /**
     *申请时间
     */
    private String apply_data;
    /**
     *退款状态
     */
    private String refund_status;
    /**
     *退款备注
     */
    private String refund_notes;

    public OrderManagement() {
    }

    public OrderManagement(long oid, String consignee, String guest_book, BigDecimal total_amount, BigDecimal received_amount, String distribution, String order_data, String state, String applicant, BigDecimal refund_amount, String apply_data, String refund_status, String refund_notes) {
        this.oid = oid;
        this.consignee = consignee;
        this.guest_book = guest_book;
        this.total_amount = total_amount;
        this.received_amount = received_amount;
        this.distribution = distribution;
        this.order_data = order_data;
        this.state = state;
        this.applicant = applicant;
        this.refund_amount = refund_amount;
        this.apply_data = apply_data;
        this.refund_status = refund_status;
        this.refund_notes = refund_notes;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getGuest_book() {
        return guest_book;
    }

    public void setGuest_book(String guest_book) {
        this.guest_book = guest_book;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public BigDecimal getReceived_amount() {
        return received_amount;
    }

    public void setReceived_amount(BigDecimal received_amount) {
        this.received_amount = received_amount;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getOrder_data() {
        return order_data;
    }

    public void setOrder_data(String order_data) {
        this.order_data = order_data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public BigDecimal getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(BigDecimal refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getApply_data() {
        return apply_data;
    }

    public void setApply_data(String apply_data) {
        this.apply_data = apply_data;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getRefund_notes() {
        return refund_notes;
    }

    public void setRefund_notes(String refund_notes) {
        this.refund_notes = refund_notes;
    }
}
