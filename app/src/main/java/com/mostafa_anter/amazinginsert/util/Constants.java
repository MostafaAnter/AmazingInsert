package com.mostafa_anter.amazinginsert.util;

import com.mostafa_anter.amazinginsert.BuildConfig;

/**
 * Created by mostafa on 14/04/16.
 */
public class Constants {
    // use it in Log
    public static final String LOGTAG = "MAKDebug";

    public static final String WEB_API_KEY = "AIzaSyDajiBu0mlQfeJA5d2StTAeBPK60NNpfh0";

    //check where you come from
    public static final String COMMINGFROM = "comingFrom";
    public static final String CONTACT = "contact";
    public static final String CONVERSATION = "conversation";
    public static final String GROUPS = "groups";
    public static final String CHAT_PAGE = "chat_page";
    public static final String HOME = "home_page";
    public static final String HAS_NOTIFICATION = "has_notification";

    // flag for edit check
    public static final String EDIT_FLAG = "edit_flag";

    /**
     * Constants related to locations in Firebase, such as the name of the node
     */
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_LOCATION_SERVICES = "services";
    public static final String FIREBASE_LOCATION_ROOMS = "rooms";
    public static final String FIREBASE_LOCATION_MESSAGES = "messages";
    public static final String FIREBASE_LOCATION_MESSAGES_SEEN_LIST = "messages_seen_users_liset";
    public static final String FIREBASE_LOCATION_GEOFIRE = "_users_geofire";
    public static final String FIREBASE_CARS_SERVICES_LOCATION_GEOFIRE = "_cars_services_geofire";
    public static final String FIREBASE_MOTORCYCLES_SERVICES_LOCATION_GEOFIRE = "_motorcycles_services_geofire";

    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";
    public static final String FIREBASE_PROPERTY_NAME = "name";
    public static final String FIREBASE_PROPERTY_PHONE = "phone";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String FIREBASE_PROPERTY_AVATAR = "avatarUrl";
    public static final String FIREBASE_PROPERTY_STATUS = "status";

    public static final String FIREBASE_PROPERTY_MEMBERS = "members";


    /**
     * status property
     */
    public static final int STATUS_PROPERTY_AVAILABLE = 0;
    public static final int STATUS_PROPERTY_BUSY = 1;
    public static final int STATUS_PROPERTY_NOTVAILABLE = 2;



    /**
     * Constants for Firebase URL
     */
    public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String FIREBASE_URL_ROOMS = FIREBASE_URL + "/" + FIREBASE_LOCATION_ROOMS;
    public static final String FIREBASE_URL_MESSAGES = FIREBASE_URL + "/" + FIREBASE_LOCATION_MESSAGES;
    public static final String FIREBASE_URL_GEOFIRE = FIREBASE_URL + "/" + FIREBASE_LOCATION_GEOFIRE;
    public static final String FIREBASE_URL_CARS_SERVICES_GEOFIRE = FIREBASE_URL + "/" + FIREBASE_CARS_SERVICES_LOCATION_GEOFIRE;
    public static final String FIREBASE_URL_MOTORCYCLES_SERVICES_GEOFIRE = FIREBASE_URL + "/" + FIREBASE_MOTORCYCLES_SERVICES_LOCATION_GEOFIRE;
    public static final String FIREBASE_URL_SERVICES = FIREBASE_URL + "/" + FIREBASE_LOCATION_SERVICES;

    /**
    * this section belong user preference
    */
    public static final String PREFERENCE_USER_EMAIL =  "email";
    public static final String PREFERENCE_USER_NAME =  "name";
    public static final String PREFERENCE_USER_STATUS = "status";
    public static final String PREFERENCE_USER_LOCATION_TRACKER_STATE = "location_tracker";
    public static final String PREFERENCE_FIRST_TIME_OPEN_APP_STATE = "firstTimeState";
    public static final String PREFERENCE_LANGUAGE = "language";
    public static final String PREFERENCE_NOTIFICATION_STATE = "notification_state";
    public static final String PREFERENCE_FIRST_TIME_OPEN_CONTACT = "firstTimeLoadContact";


    /**
     * this section for save user data from Mak api as his Token
     */
    public static final String TOKEN = "user_token";


    /**
     * this section for search extra
     */
    public static final String EXACT_FROM = "from";
    public static final String BRANDID = "brandid";
    public static final String MODELID = "modelid";
    public static final String CITYID = "cityid";
    public static final String REGIONID = "regionid";
    public static final String PRICE_FROM = "price_from";
    public static final String PRICE_TO = "price_to";
    public static final String ENGINECAPACITY_FROM = "enginecapacity_from";
    public static final String ENGINECAPACITY_TO = "enginecapacity_to";
    public static final String ISAUTOMATICTRANSMISSION = "isautomatictransmission";
    public static final String ISEXCHANGED = "isexchanged";
    public static final String MANUFACTURINGYEARFROM = "manufacturingYearFrom";
    public static final String MANUFACTURINGYEARTO = "manufacturingYearTo";
    public static final String ISENGINE = "IsEngine";
    public static final String ISBODY = "IsBody";
    public static final String ISKEY = "IsKey";
    public static final String ISGLASS = "IsGlass";
    public static final String ISELECTRICITY = "IsElectricity";
    public static final String ISSUSPENSIONS = "IsSuspensions";
    public static final String ISTIRES = "IsTires";
    public static final String ISOTHER = "IsOther";
    public static final String ISPERSONAL = "IsPersonal";
    public static final String ISSHOP = "IsShop";
    public static final String ISUSED = "is_used";
    public static final String ISNEW = "is_new";
    public static final String ISDISABLEDACCESSIBLE = "IsDisabledAccessible";

    // for jobs
   public  static final String IsMaintenanceManager = "IsMaintenanceManager";
   public  static final String IsExhibitionManager = "IsExhibitionManager";
   public  static final String IsMechanicalEngineer = "IsMechanicalEngineer";
   public  static final String IsElectricEngineer = "IsElectricEngineer";
   public  static final String IsMechanical = "IsMechanical";
   public  static final String IsElectrician = "IsElectrician";
   public  static final String IsSuspensionsTechnician = "IsSuspensionsTechnician";
   public  static final String IsPlumber = "IsPlumber";
   public  static final String IsTechnicianPaints = "IsTechnicianPaints";
   public  static final String IsMarketingAndSales = "IsMarketingAndSales";
   public  static final String IsDriver = "IsDriver";
   public  static final String IsOther = "IsOther";

    public  static final String ADDID = "AddID";
    public static final String TYPEID = "type_id";



}
