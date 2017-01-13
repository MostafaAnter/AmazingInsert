package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 06/08/16.
 */
public class SearchFavModel {
    private String FavoritID;

    public String getFavoritID() {
        return FavoritID;
    }

    public void setFavoritID(String favoritID) {
        FavoritID = favoritID;
    }

    private String ID;
    private String IsCar;
    private String Title;
    private String Address;
    private String ImagePath;
    private String CreationDate;
    private String TypeId;

    public String getNumberOfView() {
        return NumberOfView;
    }

    public void setNumberOfView(String numberOfView) {
        NumberOfView = numberOfView;
    }

    private String NumberOfView;

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    private boolean IsActive;

    public SearchFavModel(String favoritID, String ID, String isCar, String title,
                          String address, String imagePath,
                          String creationDate, String typeId, String NumberOfView,
                          boolean isActive) {
        FavoritID = favoritID;
        this.ID = ID;
        IsCar = isCar;
        Title = title;
        Address = address;
        ImagePath = imagePath;
        CreationDate = creationDate;
        TypeId = typeId;
        this.NumberOfView = NumberOfView;
        this.IsActive = isActive;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIsCar() {
        return IsCar;
    }

    public void setIsCar(String isCar) {
        IsCar = isCar;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public String getTypeId() {
        return TypeId;
    }

    public void setTypeId(String typeId) {
        TypeId = typeId;
    }
}
