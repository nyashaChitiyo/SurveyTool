package com.example.gifty.surveytool.pojo;

public class ShopFloorClosingStock {
    private String brand,pack_size,quantities;

    public ShopFloorClosingStock(String brand, String pack_size, String quantities) {
        this.brand = brand;
        this.pack_size = pack_size;
        this.quantities = quantities;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPack_size() {
        return pack_size;
    }

    public void setPack_size(String pack_size) {
        this.pack_size = pack_size;
    }

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }
}
