package com.amap.api.mapcore2d;

/* compiled from: DexDownloadItem */
public class ea {
    protected String a;
    String b;
    String c;
    String d;
    String e;
    int f;
    int g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;

    public ea(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, false, z);
    }

    public ea(String str, String str2, String str3, boolean z, boolean z2) {
        this.i = false;
        this.j = false;
        this.k = true;
        this.a = str;
        this.h = str2;
        this.i = z;
        this.k = z2;
        try {
            String[] split = str.split("/");
            int length = split.length;
            if (length > 1) {
                String str4 = split[length - 1];
                this.b = str4;
                String[] split2 = str4.split("_");
                this.c = split2[0];
                this.d = split2[2];
                this.e = split2[1];
                this.f = Integer.parseInt(split2[3]);
                this.g = Integer.parseInt(split2[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            eh.a(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    String a() {
        return this.a;
    }

    public String b() {
        return this.h;
    }

    String c() {
        return this.d;
    }

    public boolean d() {
        return this.i;
    }

    public boolean e() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public boolean f() {
        return this.k;
    }
}
