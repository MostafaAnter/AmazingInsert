package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 20/06/16.
 */
public class Governorate {
    private String id;
    private String countryID;
    private String arName;
    private String enName;

    public Governorate(String id, String countryID, String arName, String enName) {
        this.id = id;
        this.countryID = countryID;
        this.arName = arName;
        this.enName = enName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }
}
