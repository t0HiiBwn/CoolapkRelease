package com.loc;

/* compiled from: AmapLocation */
public class db {
    public String a;
    public long b = 0;
    public long c = 0;
    public double d = 0.0d;
    public double e = 0.0d;
    public double f = 0.0d;
    public float g = 0.0f;
    public float h = 0.0f;
    public float i = 0.0f;
    public boolean j = false;

    public db(String str) {
        this.a = str;
    }

    public final double a(db dbVar) {
        if (dbVar == null) {
            return 0.0d;
        }
        double d2 = this.e;
        double d3 = this.d;
        double d4 = dbVar.e;
        double d5 = dbVar.d;
        double d6 = (((90.0d - d3) * 21412.0d) / 90.0d) + 6356725.0d;
        double cos = ((d4 * 0.01745329238474369d) - (d2 * 0.01745329238474369d)) * Math.cos((3.1415927410125732d * d3) / 180.0d) * d6;
        double d7 = ((d5 * 0.01745329238474369d) - (d3 * 0.01745329238474369d)) * d6;
        return Math.pow((cos * cos) + (d7 * d7), 0.5d);
    }
}
