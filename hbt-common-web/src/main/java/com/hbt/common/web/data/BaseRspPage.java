package com.hbt.common.web.data;

import java.util.List;

public class BaseRspPage<T, A> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Integer nextPage;
    private Long total;
    private List<T> data;

    public BaseRspPage(Integer pageNum, Integer pageSize, Integer totalPage, Integer nextPage, Long total, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.nextPage = nextPage;
        this.total = total;
        this.data = data;
    }
}
