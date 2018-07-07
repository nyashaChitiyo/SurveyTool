package com.codel.zw.saint_mobile_go.pojo;

public class OrderPlacementPojo {
    private String orderNumber,PackSize,quantity,dateOrder,deliveryDate;

    public OrderPlacementPojo(String orderNumber, String packSize, String quantity, String dateOrder, String deliveryDate) {
        this.orderNumber = orderNumber;
        PackSize = packSize;
        this.quantity = quantity;
        this.dateOrder = dateOrder;
        this.deliveryDate = deliveryDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPackSize() {
        return PackSize;
    }

    public void setPackSize(String packSize) {
        PackSize = packSize;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
