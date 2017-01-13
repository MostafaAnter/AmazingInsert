package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 05/08/16.
 */
public class SearchTradeShowModel {
    private String itemRawID;
    private String CenterName;
    private String Address;
    private String Website;
    private String Phone1;
    private String Phone2;
    private String Description;
    private String ImagePath;
    private String CityID;
    private String CityarName;
    private String CityenName;
    private String RegionID;
    private String RegionarName;
    private String RegionenName;
    private String IsCar;
    private String IsNew;
    private String IsUsed;
    private String IsDisabledAccessible;
    private String CreationDate;
    private String NumberOfView;
    private String Rate1;
    private String Rate2;
    private String Rate3;
    private String Rate4;
    private String Rate5;

    public String getAdTotalRate() {
        return AdTotalRate;
    }

    public void setAdTotalRate(String adTotalRate) {
        AdTotalRate = adTotalRate;
    }

    private String AdTotalRate;

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
    public String getNumberOfView() {
        return NumberOfView;
    }

    public void setNumberOfView(String numberOfView) {
        NumberOfView = numberOfView;
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

    public SearchTradeShowModel(){

    }

    public SearchTradeShowModel(String itemRawID,
                                String centerName,
                                String address,
                                String website, String phone1, String phone2,
                                String description, String imagePath, String cityID,
                                String cityarName, String cityenName, String regionID,
                                String regionarName, String regionenName, String isCar,
                                String isNew, String isUsed,
                                String isDisabledAccessible, String creationDate,
                                String numberOfView, String rate1, String rate2,
                                String rate3, String rate4,
                                String rate5, String adTotalRate,
                                String email, String adsURL, String userId) {
        this.itemRawID = itemRawID;
        CenterName = centerName;
        Address = address;
        Website = website;
        Phone1 = phone1;
        Phone2 = phone2;
        Description = description;
        ImagePath = imagePath;
        CityID = cityID;
        CityarName = cityarName;
        CityenName = cityenName;
        RegionID = regionID;
        RegionarName = regionarName;
        RegionenName = regionenName;
        IsCar = isCar;
        IsNew = isNew;
        IsUsed = isUsed;
        IsDisabledAccessible = isDisabledAccessible;
        CreationDate = creationDate;
        NumberOfView = numberOfView;
        Rate1 = rate1;
        Rate2 = rate2;
        Rate3 = rate3;
        Rate4 = rate4;
        Rate5 = rate5;
        AdTotalRate = adTotalRate;
        Email = email;
        AdsURL = adsURL;
        this.userId = userId;
    }

    public String getItemRawID() {
        return itemRawID;
    }

    public void setItemRawID(String itemRawID) {
        this.itemRawID = itemRawID;
    }

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

    public String getIsCar() {
        return IsCar;
    }

    public void setIsCar(String isCar) {
        IsCar = isCar;
    }

    public String getIsNew() {
        return IsNew;
    }

    public void setIsNew(String isNew) {
        IsNew = isNew;
    }

    public String getIsUsed() {
        return IsUsed;
    }

    public void setIsUsed(String isUsed) {
        IsUsed = isUsed;
    }

    public String getIsDisabledAccessible() {
        return IsDisabledAccessible;
    }

    public void setIsDisabledAccessible(String isDisabledAccessible) {
        IsDisabledAccessible = isDisabledAccessible;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }
}
