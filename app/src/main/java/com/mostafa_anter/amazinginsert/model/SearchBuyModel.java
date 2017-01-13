package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 02/08/16.
 */
public class SearchBuyModel {
    private String itemRawID;
    private String BrandID;
    private String BrandArName;
    private String BrandEnName;
    private String ModelID;
    private String ModelArName;
    private String ModelEnName;
    private String CityID;
    private String CityarName;
    private String CityenName;
    private String RegionID;
    private String RegionarName;
    private String RegionenName;
    private String StatusID;
    private String price;
    private String EngineCapacity;
    private String ManufacturingYear;
    private String Mileage;
    private String Description;
    private String IsAutomaticTransmission;
    private String IsExchanged;
    private String AdvertiserName;
    private String Address;
    private String Phone;
    private String Phone1;
    private String Phone2;
    private String Website;

    private String ImagePath1;

    private String ImagePath2;
    private String ImagePath3;
    private String ImagePath4;
    private String ImagePath5;
    private String ImagePath6;
    private String ImagePath7;
    private String ImagePath8;
    private String NumberOfView;

    private boolean IsCar;

    private String UserId;
    private boolean IsActive;
    private boolean IsUsed;
    private String CreationDate;

    public String getAdsURL() {
        return AdsURL;
    }

    public void setAdsURL(String adsURL) {
        AdsURL = adsURL;
    }

    private String AdsURL;
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;
    private AccessoriesParameterModel accessoriesParameterModel;

    public SearchBuyModel(){

    }

    public SearchBuyModel(String itemRawID, String brandID, String brandArName,
                          String brandEnName, String modelID, String modelArName,
                          String modelEnName, String cityID, String cityarName,
                          String cityenName, String regionID, String regionarName,
                          String regionenName, String statusID, String price,
                          String engineCapacity, String manufacturingYear,
                          String mileage, String description, String isAutomaticTransmission,
                          String isExchanged, String advertiserName, String address,
                          String phone,String phone1, String phone2 , String website, String imagePath1, String imagePath2, String imagePath3,
                          String imagePath4, String imagePath5, String imagePath6, String imagePath7,
                          String imagePath8, boolean isCar, String userId, boolean isActive,
                          boolean isUsed,String CreationDate ,
                          String numberOfView,
                          AccessoriesParameterModel accessoriesParameterModel, String email, String adsURL) {
        this.itemRawID = itemRawID;
        BrandID = brandID;
        BrandArName = brandArName;
        BrandEnName = brandEnName;
        ModelID = modelID;
        ModelArName = modelArName;
        ModelEnName = modelEnName;
        CityID = cityID;
        CityarName = cityarName;
        CityenName = cityenName;
        RegionID = regionID;
        RegionarName = regionarName;
        RegionenName = regionenName;
        StatusID = statusID;
        this.price = price;
        EngineCapacity = engineCapacity;
        ManufacturingYear = manufacturingYear;
        Mileage = mileage;
        Description = description;
        IsAutomaticTransmission = isAutomaticTransmission;
        IsExchanged = isExchanged;
        AdvertiserName = advertiserName;
        Address = address;
        Phone = phone;
        Phone1 = phone1;
        Phone2= phone2;
        Website = website;
        ImagePath1 = imagePath1;
        ImagePath2 = imagePath2;
        ImagePath3 = imagePath3;
        ImagePath4 = imagePath4;
        ImagePath5 = imagePath5;
        ImagePath6 = imagePath6;
        ImagePath7 = imagePath7;
        ImagePath8 = imagePath8;
        IsCar = isCar;
        UserId = userId;
        IsActive = isActive;
        IsUsed = isUsed;
        NumberOfView = numberOfView;
        this.CreationDate = CreationDate;
        this.accessoriesParameterModel = accessoriesParameterModel;
        Email = email;
        AdsURL = adsURL;
    }
    public String getItemRawID() {
        return itemRawID;
    }
    public void setItemRawID(String itemRawID) {
        this.itemRawID = itemRawID;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String brandID) {
        BrandID = brandID;
    }

    public String getBrandArName() {
        return BrandArName;
    }

    public void setBrandArName(String brandArName) {
        BrandArName = brandArName;
    }

    public String getBrandEnName() {
        return BrandEnName;
    }

    public void setBrandEnName(String brandEnName) {
        BrandEnName = brandEnName;
    }

    public String getModelID() {
        return ModelID;
    }

    public void setModelID(String modelID) {
        ModelID = modelID;
    }

    public String getModelArName() {
        return ModelArName;
    }

    public void setModelArName(String modelArName) {
        ModelArName = modelArName;
    }

    public String getModelEnName() {
        return ModelEnName;
    }

    public void setModelEnName(String modelEnName) {
        ModelEnName = modelEnName;
    }

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String cityID) {
        CityID = cityID;
    }

    public String getCityarName() {
        return CityarName;
    }

    public void setCityarName(String cityarName) {
        CityarName = cityarName;
    }

    public String getCityenName() {
        return CityenName;
    }

    public void setCityenName(String cityenName) {
        CityenName = cityenName;
    }

    public String getRegionID() {
        return RegionID;
    }

    public void setRegionID(String regionID) {
        RegionID = regionID;
    }

    public String getRegionarName() {
        return RegionarName;
    }

    public void setRegionarName(String regionarName) {
        RegionarName = regionarName;
    }

    public String getRegionenName() {
        return RegionenName;
    }

    public void setRegionenName(String regionenName) {
        RegionenName = regionenName;
    }

    public String getStatusID() {
        return StatusID;
    }

    public void setStatusID(String statusID) {
        StatusID = statusID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEngineCapacity() {
        return EngineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    public String getManufacturingYear() {
        return ManufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        ManufacturingYear = manufacturingYear;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String mileage) {
        Mileage = mileage;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String isAutomaticTransmission() {
        return IsAutomaticTransmission;
    }

    public void setAutomaticTransmission(String automaticTransmission) {
        IsAutomaticTransmission = automaticTransmission;
    }

    public String isExchanged() {
        return IsExchanged;
    }

    public void setExchanged(String exchanged) {
        IsExchanged = exchanged;
    }

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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
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

    public String getImagePath5() {
        return ImagePath5;
    }

    public void setImagePath5(String imagePath5) {
        ImagePath5 = imagePath5;
    }

    public String getImagePath6() {
        return ImagePath6;
    }

    public void setImagePath6(String imagePath6) {
        ImagePath6 = imagePath6;
    }

    public String getImagePath7() {
        return ImagePath7;
    }

    public void setImagePath7(String imagePath7) {
        ImagePath7 = imagePath7;
    }

    public String getImagePath8() {
        return ImagePath8;
    }

    public void setImagePath8(String imagePath8) {
        ImagePath8 = imagePath8;
    }

    public boolean isCar() {
        return IsCar;
    }

    public void setCar(boolean car) {
        IsCar = car;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public boolean isUsed() {
        return IsUsed;
    }

    public void setUsed(boolean used) {
        IsUsed = used;
    }

    public AccessoriesParameterModel getAccessoriesParameterModel() {
        return accessoriesParameterModel;
    }

    public void setAccessoriesParameterModel(AccessoriesParameterModel accessoriesParameterModel) {
        this.accessoriesParameterModel = accessoriesParameterModel;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getNumberOfView() {
        return NumberOfView;
    }

    public void setNumberOfView(String numberOfView) {
        NumberOfView = numberOfView;
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

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }
}
