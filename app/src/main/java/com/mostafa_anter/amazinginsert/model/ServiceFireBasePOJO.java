package com.mostafa_anter.amazinginsert.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by mostafa on 21/07/16.
 */
@IgnoreExtraProperties
public class ServiceFireBasePOJO {
    private String description;
    private String address;
    private String phone;
    private int category;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public ServiceFireBasePOJO(String description, String address, String phone, int category) {
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.category = category;
    }

    public ServiceFireBasePOJO(){

    }


}
