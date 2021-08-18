package com.tjetc.service.common.model;

/**
 * 分页查询结果
 *
 * @param <T>
 */
public class AdminPageResult<T> {
    //0 代表成功，1代表失败,-1代表登录过期
    private int state;
    //失败信息
    private String message;
    //下面的数据 是datatable需要的属性
    //draw 是接收并直接返回的值，通常不用更改
    private int draw;
    //记录总数
    private long recordsTotal;
    //过滤后的总数
    private long recordsFiltered;
    //返回的数据
    private T data;

    public AdminPageResult(int state, String message, long totalCount, T data) {
        this.state = state;
        this.message = message;
        this.recordsTotal = totalCount;
        this.recordsFiltered = totalCount;
        this.data = data;
    }

    public AdminPageResult(int state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public int getDraw() {
        return draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public T getData() {
        return data;
    }
}
