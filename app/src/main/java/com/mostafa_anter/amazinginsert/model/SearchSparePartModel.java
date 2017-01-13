package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 22/07/16.
 */
public class SearchSparePartModel {
    public SearchSparePartModel(){

    }

    public String getItemRawID() {
        return itemRawID;
    }

    public void setItemRawID(String itemRawID) {
        this.itemRawID = itemRawID;
    }

    private String itemRawID;
    private String AdvertiserName;
    private String Address;
    private String Phone1;
    private String Phone2;
    private String Description;
    private String ImagePath1;
    private String ImagePath2;
    private String ImagePath3;
    private String ImagePath4;
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
    private String IsEngine;
    private String IsBody;
    private String IsKey;
    private String IsGlass;
    private String IsElectricity;
    private String IsSuspensions;
    private String IsTires;
    private String IsOther;
    private String IsCar;
    private String IsUsed;
    private String IsPersonal;
    private String Rate1;
    private String Rate2;
    private String Rate3;
    private String Rate4;
    private String Rate5;
    private String AdTotalRate;

    public String getAdTotalRate() {
        return AdTotalRate;
    }

    public void setAdTotalRate(String adTotalRate) {
        AdTotalRate = adTotalRate;
    }

    public String getRate1() {
        return Rate1;
    }

    public void setRate1(String rate1) {
        Rate1 = rate1;
    }

    public String getRate2() {
        return Rate2;
    }

    public void setRate2(String rate2) {
        Rate2 = rate2;
    }

    public String getRate3() {
        return Rate3;
    }

    public void setRate3(String rate3) {
        Rate3 = rate3;
    }

    public String getRate4() {
        return Rate4;
    }

    public void setRate4(String rate4) {
        Rate4 = rate4;
    }

    public String getRate5() {
        return Rate5;
    }

    public void setRate5(String rate5) {
        Rate5 = rate5;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

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

    public String getIsShop() {
        return IsShop;
    }

    public void setIsShop(String isShop) {
        IsShop = isShop;
    }

    private String IsShop;
    private String ManufacturingYear;
    private String CreationDate;
    private String NumberOfView;

    public String getNumberOfView() {
        return NumberOfView;
    }

    public void setNumberOfView(String numberOfView) {
        NumberOfView = numberOfView;
    }

    public SearchSparePartModel(String itemRawID, String advertiserName, String address,
                                String phone1, String phone2, String description,
                                String imagePath1, String imagePath2, String imagePath3,
                                String imagePath4, String brandID, String brandArName,
                                String brandEnName, String modelID, String modelArName,
                                String modelEnName, String cityID, String cityarName,
                                String cityenName, String regionID, String regionarName,
                                String regionenName, String isEngine, String isBody,
                                String isKey, String isGlass, String isElectricity,
                                String isSuspensions, String isTires, String isOther,
                                String isCar, String isUsed,
                                String isPersonal,
                                String manufacturingYear, String creationDate,
                                String numberOfView, String email, String adsURL, String userId,
                                String rate1, String rate2, String rate3, String rate4, String rate5, String adTotalRate) {
        this.itemRawID = itemRawID;
        AdvertiserName = advertiserName;
        Address = address;
        Phone1 = phone1;
        Phone2 = phone2;
        Description = description;
        ImagePath1 = imagePath1;
        ImagePath2 = imagePath2;
        ImagePath3 = imagePath3;
        ImagePath4 = imagePath4;
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
        IsEngine = isEngine;
        IsBody = isBody;
        IsKey = isKey;
        IsGlass = isGlass;
        IsElectricity = isElectricity;
        IsSuspensions = isSuspensions;
        IsTires = isTires;
        IsOther = isOther;
        IsCar = isCar;
        IsUsed = isUsed;
        IsPersonal = isPersonal;
        ManufacturingYear = manufacturingYear;
        CreationDate = creationDate;
        NumberOfView = numberOfView;
        Email = email;
        this.userId = userId;
        AdsURL = adsURL;
        Rate1 = rate1;
        Rate2 = rate2;
        Rate3 = rate3;
        Rate4 = rate4;
        Rate5 = rate5;
        AdTotalRate = adTotalRate;
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

    public String getIsEngine() {
        return IsEngine;
    }

    public void setIsEngine(String isEngine) {
        IsEngine = isEngine;
    }

    public String getIsBody() {
        return IsBody;
    }

    public void setIsBody(String isBody) {
        IsBody = isBody;
    }

    public String getIsKey() {
        return IsKey;
    }

    public void setIsKey(String isKey) {
        IsKey = isKey;
    }

    public String getIsGlass() {
        return IsGlass;
    }

    public void setIsGlass(String isGlass) {
        IsGlass = isGlass;
    }

    public String getIsElectricity() {
        return IsElectricity;
    }

    public void setIsElectricity(String isElectricity) {
        IsElectricity = isElectricity;
    }

    public String getIsSuspensions() {
        return IsSuspensions;
    }

    public void setIsSuspensions(String isSuspensions) {
        IsSuspensions = isSuspensions;
    }

    public String getIsTires() {
        return IsTires;
    }

    public void setIsTires(String isTires) {
        IsTires = isTires;
    }

    public String getIsOther() {
        return IsOther;
    }

    public void setIsOther(String isOther) {
        IsOther = isOther;
    }

    public String getIsCar() {
        return IsCar;
    }

    public void setIsCar(String isCar) {
        IsCar = isCar;
    }

    public String getIsUsed() {
        return IsUsed;
    }

    public void setIsUsed(String isUsed) {
        IsUsed = isUsed;
    }

    public String getIsPersonal() {
        return IsPersonal;
    }

    public void setIsPersonal(String isPersonal) {
        IsPersonal = isPersonal;
    }

    public String getManufacturingYear() {
        return ManufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        ManufacturingYear = manufacturingYear;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }
}
