package com.codel.zw.saint_mobile_go.pojo;

public class SalesrepsPojo {
    private String brand,packsize,quantity,price;

    public SalesrepsPojo(String brand, String packsize, String quantity, String price) {
        this.brand = brand;
        this.packsize = packsize;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPacksize() {
        return packsize;
    }

    public void setPacksize(String packsize) {
        this.packsize = packsize;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
