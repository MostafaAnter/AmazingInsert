package com.mostafa_anter.amazinginsert.parsers;

import com.mostafa_anter.amazinginsert.model.AccessoriesParameterModel;
import com.mostafa_anter.amazinginsert.model.Area;
import com.mostafa_anter.amazinginsert.model.Brand;
import com.mostafa_anter.amazinginsert.model.Governorate;
import com.mostafa_anter.amazinginsert.model.Model;
import com.mostafa_anter.amazinginsert.model.SearchBuyModel;
import com.mostafa_anter.amazinginsert.model.SearchFavModel;
import com.mostafa_anter.amazinginsert.model.SearchJobModel;
import com.mostafa_anter.amazinginsert.model.SearchMaintenanceModel;
import com.mostafa_anter.amazinginsert.model.SearchSparePartModel;
import com.mostafa_anter.amazinginsert.model.SearchTradeShowModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mostafa on 06/06/16.
 */
public class JsonParser {

    public static List<Brand> parseBrandFeed(String feed) {
        try {
            JSONArray jsonMoviesArray = new JSONArray(feed);
            List<Brand> brandList = new ArrayList<>();
            for (int i = 0; i < jsonMoviesArray.length(); i++) {
                JSONObject jsonObject = jsonMoviesArray.getJSONObject(i);
                String id = jsonObject.optString("ID");
                String arName = jsonObject.optString("ArName");
                String enName = jsonObject.optString("EnName");
                boolean isMoto = jsonObject.optBoolean("IsMoto");
                brandList.add(new Brand(id, arName, enName, isMoto));
            }
            return brandList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<Model> parseModelFeed(String feed) {
        try {
            JSONArray jsonMoviesArray = new JSONArray(feed);
            List<Model> modelList = new ArrayList<>();
            for (int i = 0; i < jsonMoviesArray.length(); i++) {
                JSONObject jsonObject = jsonMoviesArray.getJSONObject(i);
                String id = jsonObject.optString("ID");
                String BrandID = jsonObject.optString("BrandID");
                String arName = jsonObject.optString("ArName");
                String enName = jsonObject.optString("EnName");
                boolean isMoto = jsonObject.optBoolean("IsMoto");
                modelList.add(new Model(id, BrandID, arName, enName, isMoto));
            }
            return modelList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<Governorate> parseGovernorateFeed(String feed) {
        try {
            JSONArray jsonMoviesArray = new JSONArray(feed);
            List<Governorate> governorateList = new ArrayList<>();
            for (int i = 0; i < jsonMoviesArray.length(); i++) {
                JSONObject jsonObject = jsonMoviesArray.getJSONObject(i);
                String id = jsonObject.optString("ID");
                String countryID = jsonObject.optString("CountryID");
                String arName = jsonObject.optString("ArName");
                String enName = jsonObject.optString("EnName");
                governorateList.add(new Governorate(id, countryID, arName, enName));
            }
            return governorateList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<Area> parseAreaFeed(String feed) {
        try {
            JSONArray jsonMoviesArray = new JSONArray(feed);
            List<Area> areaList = new ArrayList<>();
            for (int i = 0; i < jsonMoviesArray.length(); i++) {
                JSONObject jsonObject = jsonMoviesArray.getJSONObject(i);
                String id = jsonObject.optString("ID");
                String CityID = jsonObject.optString("CityID");
                String arName = jsonObject.optString("ArName");
                String enName = jsonObject.optString("EnName");
                areaList.add(new Area(id, CityID, arName, enName));
            }
            return areaList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<SearchBuyModel> parseBuyResults(String feed) {
        try {
            JSONObject rootObject = new JSONObject(feed);
            JSONArray jsonItemsArray = rootObject.optJSONArray("Data");
            List<SearchBuyModel> itemList = new ArrayList<>();
            for (int i = 0; i < jsonItemsArray.length(); i++) {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);

                String itemRawID = jsonObject.optString("ID");
                JSONObject brandObject = jsonObject.optJSONObject("Brand");
                String BrandID = null;
                String BrandArName = null;
                String BrandEnName = null;
                if (brandObject != null) {
                    BrandID = brandObject.optString("ID");
                    BrandArName = brandObject.optString("ArName");
                    BrandEnName = brandObject.optString("EnName");
                }
                JSONObject modelObject = jsonObject.optJSONObject("Model");
                String ModelID = null;
                String ModelArName = null;
                String ModelEnName = null;
                if (modelObject != null) {
                    ModelID = modelObject.optString("ID");
                    ModelArName = modelObject.optString("ArName");
                    ModelEnName = modelObject.optString("EnName");
                }
                JSONObject cityObject = jsonObject.optJSONObject("City");
                String CityID = null;
                String CityarName = null;
                String CityenName = null;
                if (cityObject != null) {
                    CityID = cityObject.optString("ID");
                    CityarName = cityObject.optString("ArName");
                    CityenName = cityObject.optString("EnName");
                }
                JSONObject regionObject = jsonObject.optJSONObject("Region");
                String RegionID = null;
                String RegionarName = null;
                String RegionEnName = null;
                if (regionObject != null) {
                    RegionID = regionObject.optString("ID");
                    RegionarName = regionObject.optString("ArName");
                    RegionEnName = regionObject.optString("EnName");
                }
                String StatusID = jsonObject.optString("StatusID");
                String price = jsonObject.optString("price");
                String EngineCapacity = jsonObject.optString("EngineCapacity");
                String ManufacturingYear = jsonObject.optString("ManufacturingYear");
                String Mileage = jsonObject.optString("Mileage");
                String Description = jsonObject.optString("Description");
                String IsAutomaticTransmission = jsonObject.optString("IsAutomaticTransmission");
                String IsExchanged = jsonObject.optString("IsExchanged");
                String AdvertiserName = jsonObject.optString("AdvertiserName");
                String Address = jsonObject.optString("Address");
                String Phone = jsonObject.optString("Phone");
                String ImagePath1 = jsonObject.optString("ImagePath1");
                String ImagePath2 = jsonObject.optString("ImagePath2");
                String ImagePath3 = jsonObject.optString("ImagePath3");
                String ImagePath4 = jsonObject.optString("ImagePath4");
                String ImagePath5 = jsonObject.optString("ImagePath5");
                String ImagePath6 = jsonObject.optString("ImagePath6");
                String ImagePath7 = jsonObject.optString("ImagePath7");
                String ImagePath8 = jsonObject.optString("ImagePath8");
                boolean IsCar = jsonObject.optBoolean("IsCar");
                String UserId = jsonObject.optString("UserId");
                boolean IsActive = jsonObject.optBoolean("IsActive");
                boolean IsUsed = jsonObject.optBoolean("IsUsed");
                String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");

                itemList.add(new SearchBuyModel(itemRawID, BrandID, BrandArName, BrandEnName,
                        ModelID, ModelArName, ModelEnName, CityID, CityarName, CityenName,
                        RegionID, RegionarName, RegionEnName, StatusID, price, EngineCapacity,
                        ManufacturingYear, Mileage, Description, IsAutomaticTransmission, IsExchanged,
                        AdvertiserName, Address, Phone, null, null, null, ImagePath1, ImagePath2, ImagePath3,
                        ImagePath4, ImagePath5, ImagePath6, ImagePath7, ImagePath8, IsCar, UserId, IsActive,
                        IsUsed, CreationDate, null, null, null, null));
            }
            return itemList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<SearchMaintenanceModel> parseMaintenanceResults(String feed) {
        try {
            JSONObject rootObject = new JSONObject(feed);
            JSONArray jsonItemsArray = rootObject.optJSONArray("Data");
            List<SearchMaintenanceModel> itemList = new ArrayList<>();
            for (int i = 0; i < jsonItemsArray.length(); i++) {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);

                String itemRawID = jsonObject.optString("ID");

                JSONObject brandObject = jsonObject.optJSONObject("Brand");
                String BrandID = null;
                String BrandArName = null;
                String BrandEnName = null;
                if (brandObject != null) {
                    BrandID = brandObject.optString("ID");
                    BrandArName = brandObject.optString("ArName");
                    BrandEnName = brandObject.optString("EnName");
                }

                JSONObject cityObject = jsonObject.optJSONObject("City");
                String CityID = null;
                String CityarName = null;
                String CityenName = null;
                if (cityObject != null) {
                    CityID = cityObject.optString("ID");
                    CityarName = cityObject.optString("ArName");
                    CityenName = cityObject.optString("EnName");
                }

                JSONObject regionObject = jsonObject.optJSONObject("Region");
                String RegionID = null;
                String RegionarName = null;
                String RegionEnName = null;
                if (regionObject != null) {
                    RegionID = regionObject.optString("ID");
                    RegionarName = regionObject.optString("ArName");
                    RegionEnName = regionObject.optString("EnName");
                }

                String CenterName = jsonObject.optString("CenterName");
                String Address = jsonObject.optString("Address");
                String Phone1 = jsonObject.optString("Phone1");
                String Phone2 = jsonObject.optString("Phone2");
                String Website = jsonObject.optString("Website");
                String Description = jsonObject.optString("Description");
                String ImagePath = jsonObject.optString("ImagePath");
                String IsCar = jsonObject.optString("IsCar");
                String UserId = jsonObject.optString("UserId");
                String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
                String Rate1 = jsonObject.optString("Rate1");
                String Rate2 = jsonObject.optString("Rate2");
                String Rate3 = jsonObject.optString("Rate3");
                String Rate4 = jsonObject.optString("Rate4");
                String Rate5 = jsonObject.optString("Rate5");
                String AdTotalRate = jsonObject.optString("AdTotalRate");
                String IsEngine = jsonObject.optString("IsEngine");
                String IsBody = jsonObject.optString("IsBody");
                String IsKey = jsonObject.optString("IsKey");
                String IsGlass = jsonObject.optString("IsGlass");
                String IsElectricity = jsonObject.optString("IsElectricity");
                String IsSuspensions = jsonObject.optString("IsSuspensions");
                String IsTires = jsonObject.optString("IsTires");
                String IsOther = jsonObject.optString("IsOther");

                itemList.add(new SearchMaintenanceModel(itemRawID, CenterName, Address, Phone1, Phone2, Website, Description, ImagePath,
                        BrandID, BrandArName, BrandEnName, CityID, CityarName, CityenName,
                        RegionID, RegionarName, RegionEnName, IsEngine, IsBody, IsKey, IsGlass,
                        IsElectricity, IsSuspensions, IsTires, IsOther, null, IsCar,
                        CreationDate, null, Rate1, Rate2, Rate3, Rate4, Rate5,AdTotalRate, null, null, UserId));
            }
            return itemList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }


    public static List<SearchSparePartModel> parseSparePartsResults(String feed) {
        try {
            JSONObject rootObject = new JSONObject(feed);
            JSONArray jsonItemsArray = rootObject.optJSONArray("Data");
            List<SearchSparePartModel> itemList = new ArrayList<>();
            for (int i = 0; i < jsonItemsArray.length(); i++) {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);
                String itemRawID = jsonObject.optString("ID");
                if (itemRawID.isEmpty() || itemRawID == null) {
                    itemRawID = jsonObject.optString("Id");
                }

                JSONObject brandObject = jsonObject.optJSONObject("Brand");
                String BrandID = null;
                String BrandArName = null;
                String BrandEnName = null;
                if (brandObject != null) {
                    BrandID = brandObject.optString("ID");
                    BrandArName = brandObject.optString("ArName");
                    BrandEnName = brandObject.optString("EnName");
                }
                JSONObject modelObject = jsonObject.optJSONObject("Model");
                String ModelID = null;
                String ModelArName = null;
                String ModelEnName = null;
                if (modelObject != null) {
                    ModelID = modelObject.optString("ID");
                    ModelArName = modelObject.optString("ArName");
                    ModelEnName = modelObject.optString("EnName");
                }
                JSONObject cityObject = jsonObject.optJSONObject("City");
                String CityID = null;
                String CityarName = null;
                String CityenName = null;
                if (cityObject != null) {
                    CityID = cityObject.optString("ID");
                    CityarName = cityObject.optString("ArName");
                    CityenName = cityObject.optString("EnName");
                }
                JSONObject regionObject = jsonObject.optJSONObject("Region");
                String RegionID = null;
                String RegionarName = null;
                String RegionEnName = null;
                if (regionObject != null) {
                    RegionID = regionObject.optString("ID");
                    RegionarName = regionObject.optString("ArName");
                    RegionEnName = regionObject.optString("EnName");
                }

                String AdvertiserName = jsonObject.optString("AdvertiserName");
                String Address = jsonObject.optString("Address");
                String Phone1 = jsonObject.optString("Phone1");
                String Phone2 = jsonObject.optString("Phone2");

                String Description = jsonObject.optString("Description");
                String ImagePath1 = jsonObject.optString("ImagePath1");
                String ImagePath2 = jsonObject.optString("ImagePath2");
                String ImagePath3 = jsonObject.optString("ImagePath3");
                String ImagePath4 = jsonObject.optString("ImagePath4");

                String IsCar = jsonObject.optString("IsCar");
                String UserId = jsonObject.optString("UserId");
                String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
                String IsPersonal = jsonObject.optString("IsPersonal");
                String IsEngine = jsonObject.optString("IsEngine");
                String IsBody = jsonObject.optString("IsBody");
                String IsKey = jsonObject.optString("IsKey");
                String IsGlass = jsonObject.optString("IsGlass");
                String IsElectricity = jsonObject.optString("IsElectricity");
                String IsSuspensions = jsonObject.optString("IsSuspensions");
                String IsTires = jsonObject.optString("IsTires");
                String IsOther = jsonObject.optString("IsOther");
                String Rate1 = jsonObject.optString("Rate1");
                String Rate2 = jsonObject.optString("Rate2");
                String Rate3 = jsonObject.optString("Rate3");
                String Rate4 = jsonObject.optString("Rate4");
                String Rate5 = jsonObject.optString("Rate5");
                String AdTotalRate = jsonObject.optString("AdTotalRate");

                itemList.add(new SearchSparePartModel(itemRawID, AdvertiserName, Address, Phone1, Phone2,
                        Description, ImagePath1, ImagePath2, ImagePath3, ImagePath4, BrandID, BrandArName,
                        BrandEnName, ModelID, ModelArName, ModelEnName, CityID, CityarName, CityenName,
                        RegionID, RegionarName, RegionEnName, IsEngine, IsBody, IsKey, IsGlass, IsElectricity,
                        IsSuspensions, IsTires, IsOther, IsCar, null, IsPersonal,
                        null, CreationDate, null, null, null, UserId, Rate1, Rate2, Rate3,
                        Rate4,Rate5, AdTotalRate));
            }
            return itemList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<SearchTradeShowModel> parseTradeShowResults(String feed) {
        try {
            JSONObject rootObject = new JSONObject(feed);
            JSONArray jsonItemsArray = rootObject.optJSONArray("Data");
            List<SearchTradeShowModel> itemList = new ArrayList<>();
            for (int i = 0; i < jsonItemsArray.length(); i++) {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);
                String itemRawID = jsonObject.optString("ID");

                JSONObject cityObject = jsonObject.optJSONObject("City");
                String CityID = null;
                String CityarName = null;
                String CityenName = null;
                if (cityObject != null) {
                    CityID = cityObject.optString("ID");
                    CityarName = cityObject.optString("ArName");
                    CityenName = cityObject.optString("EnName");
                }
                JSONObject regionObject = jsonObject.optJSONObject("Region");
                String RegionID = null;
                String RegionarName = null;
                String RegionEnName = null;
                if (regionObject != null) {
                    RegionID = regionObject.optString("ID");
                    RegionarName = regionObject.optString("ArName");
                    RegionEnName = regionObject.optString("EnName");
                }

                String CenterName = jsonObject.optString("CenterName");
                String Address = jsonObject.optString("Address");
                String Website = jsonObject.optString("Website");
                String Phone1 = jsonObject.optString("Phone1");
                String Phone2 = jsonObject.optString("Phone2");

                String Description = jsonObject.optString("Description");
                String ImagePath = jsonObject.optString("ImagePath");


                String IsCar = jsonObject.optString("IsCar");
                String UserId = jsonObject.optString("UserId");
                String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
                String IsDisabledAccessible = jsonObject.optString("IsDisabledAccessible");
                String IsNew = jsonObject.optString("IsNew");
                String IsUsed = jsonObject.optString("IsUsed");

                itemList.add(new SearchTradeShowModel(itemRawID, CenterName, Address, Website, Phone1,
                        Phone2, Description, ImagePath, CityID, CityarName, CityenName,
                        RegionID, RegionarName, RegionEnName, IsCar, IsNew, IsUsed, IsDisabledAccessible,
                        CreationDate, null, null, null, null, null,null ,null, null, null, UserId));
            }
            return itemList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<SearchJobModel> parseJobResults(String feed) {
        try {
            JSONObject rootObject = new JSONObject(feed);
            JSONArray jsonItemsArray = rootObject.optJSONArray("Data");
            List<SearchJobModel> itemList = new ArrayList<>();
            for (int i = 0; i < jsonItemsArray.length(); i++) {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);
                String itemRawID = jsonObject.optString("ID");
                if (itemRawID.isEmpty() || itemRawID == null) {
                    itemRawID = jsonObject.optString("Id");
                }

                JSONObject cityObject = jsonObject.optJSONObject("City");
                String CityID = null;
                String CityarName = null;
                String CityenName = null;
                if (cityObject != null) {
                    CityID = cityObject.optString("ID");
                    CityarName = cityObject.optString("ArName");
                    CityenName = cityObject.optString("EnName");
                }
                JSONObject regionObject = jsonObject.optJSONObject("Region");
                String RegionID = null;
                String RegionarName = null;
                String RegionenName = null;
                if (regionObject != null) {
                    RegionID = regionObject.optString("ID");
                    RegionarName = regionObject.optString("ArName");
                    RegionenName = regionObject.optString("EnName");
                }


                String AdvertiserTitle = jsonObject.optString("AdvertiserTitle");
                String AdvertiserName = jsonObject.optString("AdvertiserName");
                String Address = jsonObject.optString("Address");
                String Website = jsonObject.optString("Website");
                String Phone1 = jsonObject.optString("Phone1");
                String Phone2 = jsonObject.optString("Phone2");
                String UserId = jsonObject.optString("UserId");
                String Description = jsonObject.optString("Description");
                String ImagePath = jsonObject.optString("ImagePath");
                String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
                String IsMaintenanceManager = jsonObject.optString("IsMaintenanceManager");
                String IsExhibitionManager = jsonObject.optString("IsExhibitionManager");
                String IsMechanicalEngineer = jsonObject.optString("IsMechanicalEngineer");
                String IsElectricEngineer = jsonObject.optString("IsElectricEngineer");
                String IsMechanical = jsonObject.optString("IsMechanical");
                String IsElectrician = jsonObject.optString("IsElectrician");
                String IsSuspensionsTechnician = jsonObject.optString("IsSuspensionsTechnician");
                String IsPlumber = jsonObject.optString("IsPlumber");
                String IsTechnicianPaints = jsonObject.optString("IsTechnicianPaints");
                String IsMarketingAndSales = jsonObject.optString("IsMarketingAndSales");
                String IsDriver = jsonObject.optString("IsDriver");
                String IsOther = jsonObject.optString("IsOther");


                itemList.add(new SearchJobModel(itemRawID, CityID, CityarName, CityenName, RegionID,
                        RegionarName, RegionenName, AdvertiserTitle, AdvertiserName, Address,
                        Website, Phone1, Phone2, Description, ImagePath, CreationDate, IsMaintenanceManager,
                        IsExhibitionManager, IsMechanicalEngineer, IsElectricEngineer, IsMechanical,
                        IsElectrician, IsSuspensionsTechnician, IsPlumber, IsTechnicianPaints, IsMarketingAndSales,
                        IsDriver, IsOther, null, null, null,UserId ));
            }
            return itemList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static List<SearchFavModel> parseMyFavResults(String feed) {
        try {
            JSONObject rootObject = new JSONObject(feed);
            JSONArray jsonItemsArray = rootObject.optJSONArray("Data");
            List<SearchFavModel> itemList = new ArrayList<>();
            for (int i = 0; i < jsonItemsArray.length(); i++) {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);

                String ID = jsonObject.optString("ID");
                String FavoritID = jsonObject.optString("FavoritID");
                String IsCar = jsonObject.optString("IsCar");
                boolean IsActive = jsonObject.optBoolean("IsActive");
                String Title = jsonObject.optString("Title");
                String Address = jsonObject.optString("Address");
                String ImagePath = jsonObject.optString("ImagePath");
                String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
                String TypeId = jsonObject.optString("TypeId");
                String NumberOfView = jsonObject.optString("NumberOfView");

                itemList.add(new SearchFavModel(FavoritID, ID, IsCar, Title,
                        Address, ImagePath, CreationDate, TypeId, NumberOfView, IsActive));
            }
            return itemList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static SearchBuyModel parseBuyDetail(String feed) {
        try {
            JSONObject jsonObject = new JSONObject(feed);

            String itemRawID = jsonObject.optString("ID");
            JSONObject brandObject = jsonObject.optJSONObject("Brand");
            String BrandID = null;
            String BrandArName = null;
            String BrandEnName = null;
            if (brandObject != null) {
                BrandID = brandObject.optString("ID");
                BrandArName = brandObject.optString("ArName");
                BrandEnName = brandObject.optString("EnName");
            }
            JSONObject modelObject = jsonObject.optJSONObject("Model");
            String ModelID = null;
            String ModelArName = null;
            String ModelEnName = null;
            if (modelObject != null) {
                ModelID = modelObject.optString("ID");
                ModelArName = modelObject.optString("ArName");
                ModelEnName = modelObject.optString("EnName");
            }
            JSONObject cityObject = jsonObject.optJSONObject("City");
            String CityID = null;
            String CityarName = null;
            String CityenName = null;
            if (cityObject != null) {
                CityID = cityObject.optString("ID");
                CityarName = cityObject.optString("ArName");
                CityenName = cityObject.optString("EnName");
            }
            JSONObject regionObject = jsonObject.optJSONObject("Region");
            String RegionID = null;
            String RegionarName = null;
            String RegionEnName = null;
            if (regionObject != null) {
                RegionID = regionObject.optString("ID");
                RegionarName = regionObject.optString("ArName");
                RegionEnName = regionObject.optString("EnName");
            }
            String StatusID = jsonObject.optString("StatusID");
            String price = jsonObject.optString("price");
            String EngineCapacity = jsonObject.optString("EngineCapacity");
            String ManufacturingYear = jsonObject.optString("ManufacturingYear");
            String Mileage = jsonObject.optString("Mileage");
            String Description = jsonObject.optString("Description");
            String IsAutomaticTransmission = jsonObject.optString("IsAutomaticTransmission");
            String IsExchanged = jsonObject.optString("IsExchanged");
            String AdvertiserName = jsonObject.optString("AdvertiserName");
            String Address = jsonObject.optString("Address");
            String Phone = jsonObject.optString("Phone");
            String AdsURL = jsonObject.optString("AdsURL");
            String Email = jsonObject.optString("Email");
            String Phone1 = jsonObject.optString("Phone1");
            String Phone2 = jsonObject.optString("Phone2");
            String Website = jsonObject.optString("Website");
            String ImagePath1 = jsonObject.optString("ImagePath1");
            String ImagePath2 = jsonObject.optString("ImagePath2");
            String ImagePath3 = jsonObject.optString("ImagePath3");
            String ImagePath4 = jsonObject.optString("ImagePath4");
            String ImagePath5 = jsonObject.optString("ImagePath5");
            String ImagePath6 = jsonObject.optString("ImagePath6");
            String ImagePath7 = jsonObject.optString("ImagePath7");
            String ImagePath8 = jsonObject.optString("ImagePath8");
            boolean IsCar = jsonObject.optBoolean("IsCar");
            String UserId = jsonObject.optString("UserId");
            boolean IsActive = jsonObject.optBoolean("IsActive");
            boolean IsUsed = jsonObject.optBoolean("IsUsed");
            String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
            String NumberOfView = jsonObject.optString("NumberOfView");

            JSONArray jsonAccessoryArray = jsonObject.optJSONArray("Accessories");
            boolean AirConditioner = false;
            boolean ElectricWindows = false;
            boolean RoofHatch = false;
            boolean ABS = false;
            boolean CentralLock = false;
            boolean EBD = false;
            boolean Alarm = false;
            boolean CruiseControl = false;
            boolean PowerSteering = false;
            boolean AirBag = false;
            boolean Radio = false;
            if (jsonAccessoryArray != null && jsonAccessoryArray.length() > 0) {
                JSONObject jsonObject1 = jsonAccessoryArray.getJSONObject(0);
                AirConditioner = jsonObject1.optBoolean("AirConditioner");
                ElectricWindows = jsonObject1.optBoolean("ElectricWindows");
                RoofHatch = jsonObject1.optBoolean("RoofHatch");
                ABS = jsonObject1.optBoolean("ABS");
                CentralLock = jsonObject1.optBoolean("CentralLock");
                EBD = jsonObject1.optBoolean("EBD");
                Alarm = jsonObject1.optBoolean("Alarm");
                CruiseControl = jsonObject1.optBoolean("CruiseControl");
                PowerSteering = jsonObject1.optBoolean("PowerSteering");
                AirBag = jsonObject1.optBoolean("AirBag");
                Radio = jsonObject1.optBoolean("Radio");
            }

            AccessoriesParameterModel accessoriesParameterModel =
                    new AccessoriesParameterModel(AirConditioner, ElectricWindows,
                            RoofHatch, ABS, CentralLock, EBD, Alarm, CruiseControl,
                            PowerSteering, AirBag, Radio);


            return new SearchBuyModel(itemRawID, BrandID, BrandArName, BrandEnName,
                    ModelID, ModelArName, ModelEnName, CityID, CityarName, CityenName,
                    RegionID, RegionarName, RegionEnName, StatusID, price, EngineCapacity,
                    ManufacturingYear, Mileage, Description, IsAutomaticTransmission, IsExchanged,
                    AdvertiserName, Address, Phone, Phone1, Phone2, Website, ImagePath1, ImagePath2, ImagePath3,
                    ImagePath4, ImagePath5, ImagePath6, ImagePath7, ImagePath8, IsCar, UserId, IsActive,
                    IsUsed, CreationDate, NumberOfView, accessoriesParameterModel, Email, AdsURL);


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static SearchMaintenanceModel parseMaintenanceDetail(String feed) {
        try {

            JSONObject jsonObject = new JSONObject(feed);

            String itemRawID = jsonObject.optString("ID");

            JSONObject brandObject = jsonObject.optJSONObject("Brand");
            String BrandID = null;
            String BrandArName = null;
            String BrandEnName = null;
            if (brandObject != null) {
                BrandID = brandObject.optString("ID");
                BrandArName = brandObject.optString("ArName");
                BrandEnName = brandObject.optString("EnName");
            }

            JSONObject cityObject = jsonObject.optJSONObject("City");
            String CityID = null;
            String CityarName = null;
            String CityenName = null;
            if (cityObject != null) {
                CityID = cityObject.optString("ID");
                CityarName = cityObject.optString("ArName");
                CityenName = cityObject.optString("EnName");
            }

            JSONObject regionObject = jsonObject.optJSONObject("Region");
            String RegionID = null;
            String RegionarName = null;
            String RegionEnName = null;
            if (regionObject != null) {
                RegionID = regionObject.optString("ID");
                RegionarName = regionObject.optString("ArName");
                RegionEnName = regionObject.optString("EnName");
            }

            String CenterName = jsonObject.optString("CenterName");
            String Address = jsonObject.optString("Address");
            String Phone1 = jsonObject.optString("Phone1");
            String Phone2 = jsonObject.optString("Phone2");
            String Website = jsonObject.optString("Website");
            String Description = jsonObject.optString("Description");
            String ImagePath = jsonObject.optString("ImagePath");
            String IsCar = jsonObject.optString("IsCar");
            String UserId = jsonObject.optString("UserId");
            String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
            String NumberOfView = jsonObject.optString("NumberOfView");
            String AdsURL = jsonObject.optString("AdsURL");
            String Email = jsonObject.optString("Email");
            String Rate1 = jsonObject.optString("Rate1");
            String Rate2 = jsonObject.optString("Rate2");
            String Rate3 = jsonObject.optString("Rate3");
            String Rate4 = jsonObject.optString("Rate4");
            String Rate5 = jsonObject.optString("Rate5");
            String AdTotalRate = jsonObject.optString("AdTotalRate");
            String IsEngine = jsonObject.optString("IsEngine");
            String IsBody = jsonObject.optString("IsBody");
            String IsKey = jsonObject.optString("IsKey");
            String IsGlass = jsonObject.optString("IsGlass");
            String IsElectricity = jsonObject.optString("IsElectricity");
            String IsSuspensions = jsonObject.optString("IsSuspensions");
            String IsTires = jsonObject.optString("IsTires");
            String IsOther = jsonObject.optString("IsOther");

            return (new SearchMaintenanceModel(itemRawID, CenterName, Address, Phone1, Phone2, Website, Description, ImagePath,
                    BrandID, BrandArName, BrandEnName, CityID, CityarName, CityenName,
                    RegionID, RegionarName, RegionEnName, IsEngine, IsBody, IsKey, IsGlass,
                    IsElectricity, IsSuspensions, IsTires, IsOther, null, IsCar,
                    CreationDate, NumberOfView, Rate1, Rate2, Rate3, Rate4, Rate5,AdTotalRate, Email, AdsURL, UserId));


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static SearchSparePartModel parseSparePartsDetail(String feed) {
        try {

            JSONObject jsonObject = new JSONObject(feed);
            String itemRawID = jsonObject.optString("ID");
            JSONObject brandObject = jsonObject.optJSONObject("Brand");
            String BrandID = null;
            String BrandArName = null;
            String BrandEnName = null;
            if (brandObject != null) {
                BrandID = brandObject.optString("ID");
                BrandArName = brandObject.optString("ArName");
                BrandEnName = brandObject.optString("EnName");
            }
            JSONObject modelObject = jsonObject.optJSONObject("Model");
            String ModelID = null;
            String ModelArName = null;
            String ModelEnName = null;
            if (modelObject != null) {
                ModelID = modelObject.optString("ID");
                ModelArName = modelObject.optString("ArName");
                ModelEnName = modelObject.optString("EnName");
            }
            JSONObject cityObject = jsonObject.optJSONObject("City");
            String CityID = null;
            String CityarName = null;
            String CityenName = null;
            if (cityObject != null) {
                CityID = cityObject.optString("ID");
                CityarName = cityObject.optString("ArName");
                CityenName = cityObject.optString("EnName");
            }
            JSONObject regionObject = jsonObject.optJSONObject("Region");
            String RegionID = null;
            String RegionarName = null;
            String RegionEnName = null;
            if (regionObject != null) {
                RegionID = regionObject.optString("ID");
                RegionarName = regionObject.optString("ArName");
                RegionEnName = regionObject.optString("EnName");
            }

            String AdvertiserName = jsonObject.optString("AdvertiserName");
            String Address = jsonObject.optString("Address");
            String Phone1 = jsonObject.optString("Phone1");
            String Phone2 = jsonObject.optString("Phone2");

            String Description = jsonObject.optString("Description");
            String ImagePath1 = jsonObject.optString("ImagePath1");
            String ImagePath2 = jsonObject.optString("ImagePath2");
            String ImagePath3 = jsonObject.optString("ImagePath3");
            String ImagePath4 = jsonObject.optString("ImagePath4");

            String AdsURL = jsonObject.optString("AdsURL");
            String Email = jsonObject.optString("Email");
            String IsCar = jsonObject.optString("IsCar");
            String UserId = jsonObject.optString("UserId");
            String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
            String IsPersonal = jsonObject.optString("IsPersonal");
            String IsEngine = jsonObject.optString("IsEngine");
            String IsBody = jsonObject.optString("IsBody");
            String IsKey = jsonObject.optString("IsKey");
            String IsGlass = jsonObject.optString("IsGlass");
            String IsElectricity = jsonObject.optString("IsElectricity");
            String IsSuspensions = jsonObject.optString("IsSuspensions");
            String IsTires = jsonObject.optString("IsTires");
            String IsOther = jsonObject.optString("IsOther");
            String NumberOfView = jsonObject.optString("NumberOfView");
            String Rate1 = jsonObject.optString("Rate1");
            String Rate2 = jsonObject.optString("Rate2");
            String Rate3 = jsonObject.optString("Rate3");
            String Rate4 = jsonObject.optString("Rate4");
            String Rate5 = jsonObject.optString("Rate5");
            String AdTotalRate = jsonObject.optString("AdTotalRate");

            return (new SearchSparePartModel(itemRawID, AdvertiserName, Address, Phone1, Phone2,
                    Description, ImagePath1, ImagePath2, ImagePath3, ImagePath4, BrandID, BrandArName,
                    BrandEnName, ModelID, ModelArName, ModelEnName, CityID, CityarName, CityenName,
                    RegionID, RegionarName, RegionEnName, IsEngine, IsBody, IsKey, IsGlass, IsElectricity,
                    IsSuspensions, IsTires, IsOther, IsCar, null, IsPersonal, null
                    , CreationDate, NumberOfView, Email, AdsURL, UserId,
                    Rate1, Rate2, Rate3, Rate4, Rate5, AdTotalRate));


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static SearchTradeShowModel parseTradeShowDetails(String feed) {
        try {

            JSONObject jsonObject = new JSONObject(feed);
            String itemRawID = jsonObject.optString("ID");

            JSONObject cityObject = jsonObject.optJSONObject("City");
            String CityID = null;
            String CityarName = null;
            String CityenName = null;
            if (cityObject != null) {
                CityID = cityObject.optString("ID");
                CityarName = cityObject.optString("ArName");
                CityenName = cityObject.optString("EnName");
            }
            JSONObject regionObject = jsonObject.optJSONObject("Region");
            String RegionID = null;
            String RegionarName = null;
            String RegionEnName = null;
            if (regionObject != null) {
                RegionID = regionObject.optString("ID");
                RegionarName = regionObject.optString("ArName");
                RegionEnName = regionObject.optString("EnName");
            }

            String CenterName = jsonObject.optString("CenterName");
            String Address = jsonObject.optString("Address");
            String Website = jsonObject.optString("Website");
            String Phone1 = jsonObject.optString("Phone1");
            String Phone2 = jsonObject.optString("Phone2");

            String Description = jsonObject.optString("Description");
            String ImagePath = jsonObject.optString("ImagePath");

            String AdsURL = jsonObject.optString("AdsURL");
            String Email = jsonObject.optString("Email");
            String IsCar = jsonObject.optString("IsCar");
            String UserId = jsonObject.optString("UserId");
            String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
            String IsDisabledAccessible = jsonObject.optString("IsDisabledAccessible");
            String IsNew = jsonObject.optString("IsNew");
            String IsUsed = jsonObject.optString("IsUsed");
            String NumberOfView = jsonObject.optString("NumberOfView");
            String Rate1 = jsonObject.optString("Rate1");
            String Rate2 = jsonObject.optString("Rate2");
            String Rate3 = jsonObject.optString("Rate3");
            String Rate4 = jsonObject.optString("Rate4");
            String Rate5 = jsonObject.optString("Rate5");
            String AdTotalRate = jsonObject.optString("AdTotalRate");

            return (new SearchTradeShowModel(itemRawID, CenterName, Address, Website, Phone1,
                    Phone2, Description, ImagePath, CityID, CityarName, CityenName,
                    RegionID, RegionarName, RegionEnName, IsCar, IsNew, IsUsed, IsDisabledAccessible,
                    CreationDate, NumberOfView, Rate1, Rate2, Rate3,
                    Rate4, Rate5 ,AdTotalRate, Email, AdsURL, UserId));

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static SearchJobModel parseJobDetail(String feed) {
        try {

            JSONObject jsonObject = new JSONObject(feed);
            String itemRawID = jsonObject.optString("ID");

            JSONObject cityObject = jsonObject.optJSONObject("City");
            String CityID = null;
            String CityarName = null;
            String CityenName = null;
            if (cityObject != null) {
                CityID = cityObject.optString("ID");
                CityarName = cityObject.optString("ArName");
                CityenName = cityObject.optString("EnName");
            }
            JSONObject regionObject = jsonObject.optJSONObject("Region");
            String RegionID = null;
            String RegionarName = null;
            String RegionenName = null;
            if (regionObject != null) {
                RegionID = regionObject.optString("ID");
                RegionarName = regionObject.optString("ArName");
                RegionenName = regionObject.optString("EnName");
            }


            String AdsURL = jsonObject.optString("AdsURL");
            String Email = jsonObject.optString("Email");
            String UserId = jsonObject.optString("UserId");
            String AdvertiserTitle = jsonObject.optString("AdvertiserTitle");
            String AdvertiserName = jsonObject.optString("AdvertiserName");
            String Address = jsonObject.optString("Address");
            String Website = jsonObject.optString("Website");
            String Phone1 = jsonObject.optString("Phone1");
            String Phone2 = jsonObject.optString("Phone2");
            String Description = jsonObject.optString("Description");
            String ImagePath = jsonObject.optString("ImagePath");
            String CreationDate = (jsonObject.optString("CreationDate")).replace("T", " ");
            String IsMaintenanceManager = jsonObject.optString("IsMaintenanceManager");
            String IsExhibitionManager = jsonObject.optString("IsExhibitionManager");
            String IsMechanicalEngineer = jsonObject.optString("IsMechanicalEngineer");
            String IsElectricEngineer = jsonObject.optString("IsElectricEngineer");
            String IsMechanical = jsonObject.optString("IsMechanical");
            String IsElectrician = jsonObject.optString("IsElectrician");
            String IsSuspensionsTechnician = jsonObject.optString("IsSuspensionsTechnician");
            String IsPlumber = jsonObject.optString("IsPlumber");
            String IsTechnicianPaints = jsonObject.optString("IsTechnicianPaints");
            String IsMarketingAndSales = jsonObject.optString("IsMarketingAndSales");
            String IsDriver = jsonObject.optString("IsDriver");
            String IsOther = jsonObject.optString("IsOther");
            String NumberOfView = jsonObject.optString("NumberOfView");


            return (new SearchJobModel(itemRawID, CityID, CityarName, CityenName, RegionID,
                    RegionarName, RegionenName, AdvertiserTitle, AdvertiserName, Address,
                    Website, Phone1, Phone2, Description, ImagePath, CreationDate, IsMaintenanceManager,
                    IsExhibitionManager, IsMechanicalEngineer, IsElectricEngineer, IsMechanical,
                    IsElectrician, IsSuspensionsTechnician, IsPlumber, IsTechnicianPaints, IsMarketingAndSales,
                    IsDriver, IsOther, NumberOfView, Email, AdsURL, UserId));


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }
}
