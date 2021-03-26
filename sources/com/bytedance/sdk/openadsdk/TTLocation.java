package com.bytedance.sdk.openadsdk;

public class TTLocation {
    private double a = 0.0d;
    private double b = 0.0d;

    public TTLocation(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public double getLatitude() {
        return this.a;
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLongitude(double d) {
        this.b = d;
    }
}
