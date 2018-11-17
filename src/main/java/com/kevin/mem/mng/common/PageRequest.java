package com.kevin.mem.mng.common;

public class PageRequest<T>{
    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int DEFAULT_PAGE_INDEX = 1;
    public static final int MAX_PAGE_SIZE = 500;
    private int pageIndex = 1;
    private int pageSize = 20;
    private boolean queryCount = true;
    private int start;
    private T model;

    public PageRequest() {
    }

    public T getModel() {
        return this.model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public int getPageIndex() {
        return this.pageIndex <= 0 ? 1 : this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex <= 0 ? 1 : pageIndex;
    }

    public int getPageSize() {
        return this.pageSize > 0 && this.pageSize <= 500 ? this.pageSize : 20;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 20 : pageSize;
    }

    public int getStartPos() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }

    public boolean isQueryCount() {
        return this.queryCount;
    }

    public void setQueryCount(boolean queryCount) {
        this.queryCount = queryCount;
    }

    public boolean getQueryCount() {
        return this.queryCount;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
