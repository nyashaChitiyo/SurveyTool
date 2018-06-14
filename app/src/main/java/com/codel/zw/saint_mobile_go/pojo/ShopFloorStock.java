package com.codel.zw.saint_mobile_go.pojo;

public class ShopFloorStock {
    private String brand,packSize,quantity,breakages,qtyOfBreakages;

    public ShopFloorStock(String brand, String packSize, String quantity, String breakages, String qtyOfBreakages) {
        this.brand = brand;
        this.packSize = packSize;
        this.quantity = quantity;
        this.breakages = breakages;
        this.qtyOfBreakages = qtyOfBreakages;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBreakages() {
        return breakages;
    }

    public void setBreakages(String breakages) {
        this.breakages = breakages;
    }

    public String getQtyOfBreakages() {
        return qtyOfBreakages;
    }

    public void setQtyOfBreakages(String qtyOfBreakages) {
        this.qtyOfBreakages = qtyOfBreakages;
    }
}
