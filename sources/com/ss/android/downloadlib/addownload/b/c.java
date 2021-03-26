package com.ss.android.downloadlib.addownload.b;

import org.json.JSONObject;

/* compiled from: DownloadInstallInfo */
public class c {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    private int d = a;
    private long e = 0;
    private JSONObject f = null;
    private int g = 0;
    private String h = "";
    private String i = "";

    public boolean a() {
        return this.d == b;
    }

    public int b() {
        return this.g;
    }

    public c a(int i2) {
        this.d = i2;
        return this;
    }

    public c b(int i2) {
        this.g = i2;
        return this;
    }
}
