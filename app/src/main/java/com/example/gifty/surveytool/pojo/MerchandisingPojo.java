package com.example.gifty.surveytool.pojo;

public class MerchandisingPojo {
    String projectname, fullname, phonenumber, email, brandAmbassador, client,locations, outlet, branchmanagement;

    public MerchandisingPojo(){
        super();
    }

    public MerchandisingPojo(WarehouseStock stock,String projectname, String fullname, String phonenumber, String email, String brandAmbassador, String client, String locations, String outlet, String branchmanagement) {
        this.projectname = projectname;
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.brandAmbassador = brandAmbassador;
        this.client = client;
        this.locations = locations;
        this.outlet = outlet;
        this.branchmanagement = branchmanagement;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrandAmbassador() {
        return brandAmbassador;
    }

    public void setBrandAmbassador(String brandAmbassador) {
        this.brandAmbassador = brandAmbassador;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public String getBranchmanagement() {
        return branchmanagement;
    }

    public void setBranchmanagement(String branchmanagement) {
        this.branchmanagement = branchmanagement;
    }
}