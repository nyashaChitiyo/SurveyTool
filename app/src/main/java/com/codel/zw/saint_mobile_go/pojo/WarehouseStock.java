package com.codel.zw.saint_mobile_go.pojo;

public class WarehouseStock {
    private String brand,packSize,quantities,breakages,qtyOfbreakages;

    public WarehouseStock(String brand, String packSize, String quantities, String breakages, String qtyOfbreakages) {
        this.brand = brand;
        this.packSize = packSize;
        this.quantities = quantities;
        this.breakages = breakages;
        this.qtyOfbreakages = qtyOfbreakages;
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

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }

    public String getBreakages() {
        return breakages;
    }

    public void setBreakages(String breakages) {
        this.breakages = breakages;
    }

    public String getQtyOfbreakages() {
        return qtyOfbreakages;
    }

    public void setQtyOfbreakages(String qtyOfbreakages) {
        this.qtyOfbreakages = qtyOfbreakages;
    }
}
