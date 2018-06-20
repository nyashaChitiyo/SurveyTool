package com.codel.zw.saint_mobile_go.pojo;

public class OrderPlacementPojo {
    private String txtorderNumber,txtdateOrder,txtPackSize,txtquantity;

    public OrderPlacementPojo(String txtorderNumber, String txtdateOrder, String txtPackSize, String txtquantity) {
        this.txtorderNumber = txtorderNumber;
        this.txtdateOrder = txtdateOrder;
        this.txtPackSize = txtPackSize;
        this.txtquantity = txtquantity;
    }

    public String getTxtorderNumber() {
        return txtorderNumber;
    }

    public void setTxtorderNumber(String txtorderNumber) {
        this.txtorderNumber = txtorderNumber;
    }

    public String getTxtdateOrder() {
        return txtdateOrder;
    }

    public void setTxtdateOrder(String txtdateOrder) {
        this.txtdateOrder = txtdateOrder;
    }

    public String getTxtPackSize() {
        return txtPackSize;
    }

    public void setTxtPackSize(String txtPackSize) {
        this.txtPackSize = txtPackSize;
    }

    public String getTxtquantity() {
        return txtquantity;
    }

    public void setTxtquantity(String txtquantity) {
        this.txtquantity = txtquantity;
    }
}
