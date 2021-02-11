package com.enigma.trashbank.models;

import java.util.List;

public class PagedList<T> {
    private List<T> list;
    private Integer currentPage;
    private Integer totalPage;
    private Integer size;
    private Long totalElement;

    public PagedList(List<T> list, Integer currentPage, Integer totalPage, Integer size, Long totalElement) {
        this.list = list;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.size = size;
        this.totalElement = totalElement;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(Long totalElement) {
        this.totalElement = totalElement;
    }
}
