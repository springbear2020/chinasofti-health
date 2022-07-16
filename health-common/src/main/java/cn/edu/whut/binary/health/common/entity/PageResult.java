package cn.edu.whut.binary.health.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:57 Saturday
 */
public class PageResult implements Serializable {
    private static final long serialVersionUID = -7572673856601832730L;

    /**
     * 总记录数
     */
    private Long total;
    /**
     * 当前页数据
     */
    private List<Object> rows;

    public PageResult(Long total, List<Object> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
