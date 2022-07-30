package cn.edu.whut.binary.health.common.pojo;


import cn.edu.whut.binary.health.common.poi.annotation.ExcelColumnName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:49 Saturday
 */
public class OrderSetting implements Serializable {
    private static final long serialVersionUID = -3951857524748863364L;

    private Integer id;
    /**
     * 预约设置日期
     */
    @ExcelColumnName("日期")
    private Date orderDate;
    /**
     * 可预约人数
     */
    @ExcelColumnName("可预约人数")
    private Integer number;
    /**
     * 已预约人数
     */
    private Integer reservations;

    public OrderSetting() {
    }

    public OrderSetting(Integer id, Date orderDate, Integer number, Integer reservations) {
        this.id = id;
        this.orderDate = orderDate;
        this.number = number;
        this.reservations = reservations;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getReservations() {
        return reservations;
    }

    public void setReservations(Integer reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "OrderSetting{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", number=" + number +
                ", reservations=" + reservations +
                '}';
    }
}
