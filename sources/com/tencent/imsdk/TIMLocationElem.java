package com.tencent.imsdk;

public class TIMLocationElem extends TIMElem {
    private String desc;
    private double latitude;
    private double longitude;

    public TIMLocationElem() {
        this.type = TIMElemType.Location;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }
}
