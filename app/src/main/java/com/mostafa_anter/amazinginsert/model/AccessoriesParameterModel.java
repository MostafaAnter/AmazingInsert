package com.mostafa_anter.amazinginsert.model;

/**
 * Created by mostafa on 20/07/16.
 */
public class AccessoriesParameterModel {
    private boolean AirConditioner;
    private boolean ElectricWindows;
    private boolean RoofHatch;
    private boolean ABS;
    private boolean CentralLock;
    private boolean EBD;
    private boolean Alarm;
    private boolean CruiseControl;
    private boolean PowerSteering;
    private boolean AirBag;
    private boolean Radio;

    public AccessoriesParameterModel(){

    }

    public AccessoriesParameterModel(boolean airConditioner, boolean electricWindows, boolean roofHatch, boolean ABS, boolean centralLock, boolean EBD, boolean alarm, boolean cruiseControl, boolean powerSteering, boolean airBag, boolean radio) {
        AirConditioner = airConditioner;
        ElectricWindows = electricWindows;
        RoofHatch = roofHatch;
        this.ABS = ABS;
        CentralLock = centralLock;
        this.EBD = EBD;
        Alarm = alarm;
        CruiseControl = cruiseControl;
        PowerSteering = powerSteering;
        AirBag = airBag;
        Radio = radio;
    }

    public boolean isAirConditioner() {
        return AirConditioner;
    }

    public void setAirConditioner(boolean airConditioner) {
        AirConditioner = airConditioner;
    }

    public boolean isElectricWindows() {
        return ElectricWindows;
    }

    public void setElectricWindows(boolean electricWindows) {
        ElectricWindows = electricWindows;
    }

    public boolean isRoofHatch() {
        return RoofHatch;
    }

    public void setRoofHatch(boolean roofHatch) {
        RoofHatch = roofHatch;
    }

    public boolean isABS() {
        return ABS;
    }

    public void setABS(boolean ABS) {
        this.ABS = ABS;
    }

    public boolean isCentralLock() {
        return CentralLock;
    }

    public void setCentralLock(boolean centralLock) {
        CentralLock = centralLock;
    }

    public boolean isEBD() {
        return EBD;
    }

    public void setEBD(boolean EBD) {
        this.EBD = EBD;
    }

    public boolean isAlarm() {
        return Alarm;
    }

    public void setAlarm(boolean alarm) {
        Alarm = alarm;
    }

    public boolean isCruiseControl() {
        return CruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        CruiseControl = cruiseControl;
    }

    public boolean isPowerSteering() {
        return PowerSteering;
    }

    public void setPowerSteering(boolean powerSteering) {
        PowerSteering = powerSteering;
    }

    public boolean isAirBag() {
        return AirBag;
    }

    public void setAirBag(boolean airBag) {
        AirBag = airBag;
    }

    public boolean isRadio() {
        return Radio;
    }

    public void setRadio(boolean radio) {
        Radio = radio;
    }
}
