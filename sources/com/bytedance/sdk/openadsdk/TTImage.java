package com.bytedance.sdk.openadsdk;

public class TTImage {
    private int a;
    private int b;
    private String c;
    private double d = 0.0d;

    public TTImage(int i, int i2, String str, double d2) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = d2;
    }

    public int getHeight() {
        return this.a;
    }

    public int getWidth() {
        return this.b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public double getDuration() {
        return this.d;
    }

    public boolean isValid() {
        String str;
        return this.a > 0 && this.b > 0 && (str = this.c) != null && str.length() > 0;
    }
}
