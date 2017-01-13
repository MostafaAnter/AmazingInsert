package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 22/07/16.
 */
public class PostAdvertisingAccessory {
    private String AdvertiserName;
    private String Address;
    private String Phone1;
    private String Phone2;
    private String Description;
    private String ImagePath1;
    private String ImagePath2;
    private String ImagePath3;
    private String ImagePath4;
    private String CityId;
    private String AreaId;
    private boolean IsApproved;
    private boolean IsCar;
    private boolean IsPersonal;

    public String getAdvertiserName() {
        return AdvertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        AdvertiserName = advertiserName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public String getImagePath1() {
        return ImagePath1;
    }

    public void setImagePath1(String imagePath1) {
        ImagePath1 = imagePath1;
    }

    public String getImagePath2() {
        return ImagePath2;
    }

    public void setImagePath2(String imagePath2) {
        ImagePath2 = imagePath2;
    }

    public String getImagePath3() {
        return ImagePath3;
    }

    public void setImagePath3(String imagePath3) {
        ImagePath3 = imagePath3;
    }

    public String getImagePath4() {
        return ImagePath4;
    }

    public void setImagePath4(String imagePath4) {
        ImagePath4 = imagePath4;
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

    public boolean isApproved() {
        return IsApproved;
    }

    public void setApproved(boolean approved) {
        IsApproved = approved;
    }

    public boolean isCar() {
        return IsCar;
    }

    public void setCar(boolean car) {
        IsCar = car;
    }

    public boolean isPersonal() {
        return IsPersonal;
    }

    public void setPersonal(boolean personal) {
        IsPersonal = personal;
    }
}
