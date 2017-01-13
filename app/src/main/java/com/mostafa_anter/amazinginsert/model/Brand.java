package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 18/06/16.
 */
public class Brand {

    private String id;
    private String arName;
    private String enName;
    private boolean isMoto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isMoto() {
        return isMoto;
    }

    public void setMoto(boolean moto) {
        isMoto = moto;
    }

    public Brand(String id, String arName, String enName, boolean isMoto) {
        this.id = id;
        this.arName = arName;
        this.enName = enName;
        this.isMoto = isMoto;
    }

    public Brand(){

    }


}
