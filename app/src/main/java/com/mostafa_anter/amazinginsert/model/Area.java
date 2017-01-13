package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 20/06/16.
 */
public class Area {
    private String id;
    private String CityID;
    private String arName;
    private String enName;

    public Area(String id, String cityID, String arName, String enName) {
        this.id = id;
        CityID = cityID;
        this.arName = arName;
        this.enName = enName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String cityID) {
        CityID = cityID;
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
