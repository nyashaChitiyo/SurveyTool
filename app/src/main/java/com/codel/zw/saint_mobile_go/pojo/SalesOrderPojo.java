package com.codel.zw.saint_mobile_go.pojo;

public class SalesOrderPojo {
    private String orderNumber,date,orderPackSize,orderQty;

    public SalesOrderPojo(String orderNumber, String date, String orderPackSize, String orderQty) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.orderPackSize = orderPackSize;
        this.orderQty = orderQty;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderPackSize() {
        return orderPackSize;
    }

    public void setOrderPackSize(String orderPackSize) {
        this.orderPackSize = orderPackSize;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }
}
