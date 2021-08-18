package com.tjetc.service.common.model;

import java.util.List;

public class PageResult<T> {
    /**
     * 数据总条数
     */
    private long totalCount;

    /**
     * 分页查询的数据集合
     */
    private List<T> list;

    /**
     * 前一页页码
     */
    private int prevPage;

    /**
     * 后一页页码
     */
    private int nextPage;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 当前页页码
     */
    private int pageNo;

    /**
     * 每页数量
     */
    private int pageSize;

    public PageResult(int pageNo, int pageSize, long totalCount, List<T> list) {
        this.totalCount = totalCount;
        this.list = list;
        this.pageNo = pageNo;
        this.pageSize = pageSize;

        //计算前一页页码
        this.prevPage = pageNo > 1 ? pageNo - 1 : 1;
        //计算 totalCount%pageSize 的余数
        int remainder = (int) totalCount % pageSize;
        // 计算 pageSize/pageSize 的商值
        int div = (int) totalCount / pageSize;
        //计算总页数
        this.pageCount = remainder > 0 ? (div + 1) : div;
        //计算后一页页码
        this.nextPage = pageNo < pageCount ? (pageNo + 1) : pageCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }
}
