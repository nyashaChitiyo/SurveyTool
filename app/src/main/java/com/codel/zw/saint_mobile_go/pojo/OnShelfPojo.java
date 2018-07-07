package com.codel.zw.saint_mobile_go.pojo;

public class OnShelfPojo {
    private String Shelf_Share_Percentages,Competitor_SKU_Selling_Price,Own_SKU_Selling_Price,Competitor_POSM,Own_POSM,Competitor_Specials;

    public OnShelfPojo(String shelf_Share_Percentages, String competitor_SKU_Selling_Price, String own_SKU_Selling_Price, String competitor_POSM, String own_POSM, String competitor_Specials) {
        Shelf_Share_Percentages = shelf_Share_Percentages;
        Competitor_SKU_Selling_Price = competitor_SKU_Selling_Price;
        Own_SKU_Selling_Price = own_SKU_Selling_Price;
        Competitor_POSM = competitor_POSM;
        Own_POSM = own_POSM;
        Competitor_Specials = competitor_Specials;
    }

    public String getShelf_Share_Percentages() {
        return Shelf_Share_Percentages;
    }

    public void setShelf_Share_Percentages(String shelf_Share_Percentages) {
        Shelf_Share_Percentages = shelf_Share_Percentages;
    }

    public String getCompetitor_SKU_Selling_Price() {
        return Competitor_SKU_Selling_Price;
    }

    public void setCompetitor_SKU_Selling_Price(String competitor_SKU_Selling_Price) {
        Competitor_SKU_Selling_Price = competitor_SKU_Selling_Price;
    }

    public String getOwn_SKU_Selling_Price() {
        return Own_SKU_Selling_Price;
    }

    public void setOwn_SKU_Selling_Price(String own_SKU_Selling_Price) {
        Own_SKU_Selling_Price = own_SKU_Selling_Price;
    }

    public String getCompetitor_POSM() {
        return Competitor_POSM;
    }

    public void setCompetitor_POSM(String competitor_POSM) {
        Competitor_POSM = competitor_POSM;
    }

    public String getOwn_POSM() {
        return Own_POSM;
    }

    public void setOwn_POSM(String own_POSM) {
        Own_POSM = own_POSM;
    }

    public String getCompetitor_Specials() {
        return Competitor_Specials;
    }

    public void setCompetitor_Specials(String competitor_Specials) {
        Competitor_Specials = competitor_Specials;
    }
}
