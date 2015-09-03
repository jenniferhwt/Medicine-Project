package com.rippletec.medicine.bean;

/**
 * @author Liuyi 
 * 页面Bean对象
 */
public class PageBean {

    // 当前页数
    public int currentPage;

    // 下一页
    public int nextPage;

    // 上一页
    public int lastPage;

    // 页面起始位置
    public int offset;

    // 页面条目数
    public int pageSize;

    public PageBean(int offset, int pageSize) {
	super();
	this.offset = offset;
	this.pageSize = pageSize;
    }

    public PageBean(int currentPage, int nextPage, int lastPage, int offset,
	    int pageSize) {
	super();
	this.currentPage = currentPage;
	this.nextPage = nextPage;
	this.lastPage = lastPage;
	this.offset = offset;
	this.pageSize = pageSize;
    }

    @Override
    public String toString() {
	return "PageBean [currentPage=" + currentPage + ", nextPage="
		+ nextPage + ", lastPage=" + lastPage + ", offset=" + offset
		+ ", maxSize=" + pageSize + "]";
    }

    public int getCurrentPage() {
	return currentPage;
    }

    public int getNextPage() {
	return nextPage;
    }

    public int getLastPage() {
	return lastPage;
    }

    public int getOffset() {
	return offset;
    }

    public int getMaxSize() {
	return pageSize;
    }

    public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
    }

    public void setNextPage(int nextPage) {
	this.nextPage = nextPage;
    }

    public void setLastPage(int lastPage) {
	this.lastPage = lastPage;
    }

    public void setOffset(int offset) {
	this.offset = offset;
    }

    public void setMaxSize(int pageSize) {
	this.pageSize = pageSize;
    }

}
