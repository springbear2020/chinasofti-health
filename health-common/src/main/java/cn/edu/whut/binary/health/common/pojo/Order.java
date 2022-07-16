package cn.edu.whut.binary.health.common.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:46 Saturday
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -2840177885746452783L;

    public static final String ORDER_TYPE_TELEPHONE = "电话预约";
    public static final String ORDER_TYPE_WECHAT = "微信预约";
    public static final String ORDER_STATUS_YES = "已到诊";
    public static final String ORDER_STATUS_NO = "未到诊";

    private Integer id;
    /**
     * 会员 ID
     */
    private Integer memberId;
    /**
     * 预约日期
     */
    private Date orderDate;
    /**
     * 预约类型 电话预约/微信预约
     */
    private String orderType;
    /**
     * 预约状态（是否到诊）
     */
    private String orderStatus;
    /**
     * 体检套餐id
     */
    private Integer setmealId;//

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer memberId, Date orderDate, String orderType, String orderStatus, Integer setmealId) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.setmealId = setmealId;
    }

    public Order(Integer id, Integer memberId, Date orderDate, String orderType, String orderStatus, Integer setmealId) {
        this.id = id;
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.setmealId = setmealId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getSetmealId() {
        return setmealId;
    }

    public void setSetmealId(Integer setmealId) {
        this.setmealId = setmealId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", orderDate=" + orderDate +
                ", orderType='" + orderType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", setmealId=" + setmealId +
                '}';
    }
}
