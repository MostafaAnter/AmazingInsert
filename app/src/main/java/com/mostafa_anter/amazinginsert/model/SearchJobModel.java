package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 05/08/16.
 */
public class SearchJobModel {
    private String itemRawID;
    private String CityID;
    private String CityarName;
    private String CityenName;
    private String RegionID;
    private String RegionarName;
    private String RegionenName;
    private String AdvertiserTitle;
    private String AdvertiserName;
    private String Address;
    private String Website;
    private String Phone1;
    private String Phone2;
    private String Description;
    private String ImagePath;
    private String CreationDate;

    private String IsMaintenanceManager;
    private String IsExhibitionManager;
    private String IsMechanicalEngineer;
    private String IsElectricEngineer;
    private String IsMechanical;
    private String IsElectrician;
    private String IsSuspensionsTechnician;
    private String IsPlumber;
    private String IsTechnicianPaints;
    private String IsMarketingAndSales;
    private String IsDriver;
    private String IsOther;
    private String NumberOfView;

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

    public SearchJobModel(){

    }

    public SearchJobModel(String itemRawID, String cityID, String cityarName,
                          String cityenName, String regionID, String regionarName,
                          String regionenName, String advertiserTitle, String advertiserName,
                          String address, String website, String phone1, String phone2, String description,
                          String imagePath, String creationDate, String isMaintenanceManager, String isExhibitionManager,
                          String isMechanicalEngineer, String isElectricEngineer, String isMechanical, String isElectrician,
                          String isSuspensionsTechnician, String isPlumber, String isTechnicianPaints, String isMarketingAndSales,
                          String isDriver, String isOther,
                          String numberOfView, String email,
                          String adsURL, String userId) {
        this.itemRawID = itemRawID;
        CityID = cityID;
        CityarName = cityarName;
        CityenName = cityenName;
        RegionID = regionID;
        RegionarName = regionarName;
        RegionenName = regionenName;
        AdvertiserTitle = advertiserTitle;
        AdvertiserName = advertiserName;
        Address = address;
        Website = website;
        Phone1 = phone1;
        Phone2 = phone2;
        Description = description;
        ImagePath = imagePath;
        CreationDate = creationDate;
        IsMaintenanceManager = isMaintenanceManager;
        IsExhibitionManager = isExhibitionManager;
        IsMechanicalEngineer = isMechanicalEngineer;
        IsElectricEngineer = isElectricEngineer;
        IsMechanical = isMechanical;
        IsElectrician = isElectrician;
        this.userId = userId;
        IsSuspensionsTechnician = isSuspensionsTechnician;
        IsPlumber = isPlumber;
        IsTechnicianPaints = isTechnicianPaints;
        IsMarketingAndSales = isMarketingAndSales;
        IsDriver = isDriver;
        IsOther = isOther;
        NumberOfView = numberOfView;
        Email = email;
        AdsURL = adsURL;
    }

    public String getItemRawID() {
        return itemRawID;
    }

    public void setItemRawID(String itemRawID) {
        this.itemRawID = itemRawID;
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

    public String getAdvertiserTitle() {
        return AdvertiserTitle;
    }

    public void setAdvertiserTitle(String advertiserTitle) {
        AdvertiserTitle = advertiserTitle;
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

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getIsMaintenanceManager() {
        return IsMaintenanceManager;
    }

    public void setIsMaintenanceManager(String isMaintenanceManager) {
        IsMaintenanceManager = isMaintenanceManager;
    }

    public String getIsExhibitionManager() {
        return IsExhibitionManager;
    }

    public void setIsExhibitionManager(String isExhibitionManager) {
        IsExhibitionManager = isExhibitionManager;
    }

    public String getIsMechanicalEngineer() {
        return IsMechanicalEngineer;
    }

    public void setIsMechanicalEngineer(String isMechanicalEngineer) {
        IsMechanicalEngineer = isMechanicalEngineer;
    }

    public String getIsElectricEngineer() {
        return IsElectricEngineer;
    }

    public void setIsElectricEngineer(String isElectricEngineer) {
        IsElectricEngineer = isElectricEngineer;
    }

    public String getIsMechanical() {
        return IsMechanical;
    }

    public void setIsMechanical(String isMechanical) {
        IsMechanical = isMechanical;
    }

    public String getIsElectrician() {
        return IsElectrician;
    }

    public void setIsElectrician(String isElectrician) {
        IsElectrician = isElectrician;
    }

    public String getIsSuspensionsTechnician() {
        return IsSuspensionsTechnician;
    }

    public void setIsSuspensionsTechnician(String isSuspensionsTechnician) {
        IsSuspensionsTechnician = isSuspensionsTechnician;
    }

    public String getIsPlumber() {
        return IsPlumber;
    }

    public void setIsPlumber(String isPlumber) {
        IsPlumber = isPlumber;
    }

    public String getIsTechnicianPaints() {
        return IsTechnicianPaints;
    }

    public void setIsTechnicianPaints(String isTechnicianPaints) {
        IsTechnicianPaints = isTechnicianPaints;
    }

    public String getIsMarketingAndSales() {
        return IsMarketingAndSales;
    }

    public void setIsMarketingAndSales(String isMarketingAndSales) {
        IsMarketingAndSales = isMarketingAndSales;
    }

    public String getIsDriver() {
        return IsDriver;
    }

    public void setIsDriver(String isDriver) {
        IsDriver = isDriver;
    }

    public String getIsOther() {
        return IsOther;
    }

    public void setIsOther(String isOther) {
        IsOther = isOther;
    }
}
