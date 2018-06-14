package com.codel.zw.saint_mobile_go.pojo;

public class SalesOrderTakingPojo {
    private String orderBrand,orderAmntRcvd,orderTpacksize,orderTquantity;

    public SalesOrderTakingPojo(String orderBrand, String orderAmntRcvd, String orderTpacksize, String orderTquantity) {
        this.orderBrand = orderBrand;
        this.orderAmntRcvd = orderAmntRcvd;
        this.orderTpacksize = orderTpacksize;
        this.orderTquantity = orderTquantity;
    }

    public String getOrderBrand() {
        return orderBrand;
    }

    public void setOrderBrand(String orderBrand) {
        this.orderBrand = orderBrand;
    }

    public String getOrderAmntRcvd() {
        return orderAmntRcvd;
    }

    public void setOrderAmntRcvd(String orderAmntRcvd) {
        this.orderAmntRcvd = orderAmntRcvd;
    }

    public String getOrderTpacksize() {
        return orderTpacksize;
    }

    public void setOrderTpacksize(String orderTpacksize) {
        this.orderTpacksize = orderTpacksize;
    }

    public String getOrderTquantity() {
        return orderTquantity;
    }

    public void setOrderTquantity(String orderTquantity) {
        this.orderTquantity = orderTquantity;
    }
}
