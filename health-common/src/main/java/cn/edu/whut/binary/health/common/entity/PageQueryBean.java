package cn.edu.whut.binary.health.common.entity;

import java.io.Serializable;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:00 Saturday
 */
public class PageQueryBean implements Serializable {
    private static final long serialVersionUID = 3906417761607595170L;
    /**
     * 显示的页码数量
     */
    public static final int PAGE_NUMS = 8;

    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 每页的记录数
     */
    private Integer pageSize;
    /**
     * 查询条件
     */
    private String condition;

    public PageQueryBean() {
    }

    public PageQueryBean(Integer currentPage, Integer pageSize, String condition) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.condition = condition;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "PageQueryBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", condition='" + condition + '\'' +
                '}';
    }
}
