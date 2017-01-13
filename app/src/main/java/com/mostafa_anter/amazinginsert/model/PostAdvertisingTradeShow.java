package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 22/07/16.
 */
public class PostAdvertisingTradeShow {
    private String CenterName;
    private String Address;
    private String Website;
    private String Phone1;
    private String Phone2;
    private String Description;
    private String ImagePath;
    private String CityId;
    private String AreaId;
    private boolean IsCar;
    private boolean IsNew;
    private boolean IsUsed;
    private boolean IsDisabledAccessible;

    public String getCenterName() {
        return CenterName;
    }

    public void setCenterName(String centerName) {
        CenterName = centerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getPhone1() {
        return Phone1;
    }

    public void setPhone1(String phone1) {
        Phone1 = phone1;
    }

    public String getPhone2() {
        return Phone2;
    }

    public void setPhone2(String phone2) {
        Phone2 = phone2;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        CityId = cityId;
    }

    public String getAreaId() {
        return AreaId;
    }

    public void setAreaId(String areaId) {
        AreaId = areaId;
    }

    public boolean isCar() {
        return IsCar;
    }

    public void setCar(boolean car) {
        IsCar = car;
    }

    public boolean isNew() {
        return IsNew;
    }

    public void setNew(boolean aNew) {
        IsNew = aNew;
    }

    public boolean isUsed() {
        return IsUsed;
    }

    public void setUsed(boolean used) {
        IsUsed = used;
    }

    public boolean isDisabledAccessible() {
        return IsDisabledAccessible;
    }

    public void setDisabledAccessible(boolean disabledAccessible) {
        IsDisabledAccessible = disabledAccessible;
    }
}
