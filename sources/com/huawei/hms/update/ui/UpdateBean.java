package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateBean implements Serializable {
    private boolean a;
    private String b;
    private int c;
    private String d;
    private String e;
    private ArrayList f;
    private boolean g = true;

    private static <T> T a(T t) {
        return t;
    }

    boolean a() {
        return ((Boolean) a(Boolean.valueOf(this.a))).booleanValue();
    }

    public void setHmsOrApkUpgrade(boolean z) {
        this.a = z;
    }

    String b() {
        return (String) a(this.b);
    }

    public void setClientPackageName(String str) {
        this.b = str;
    }

    int c() {
        return ((Integer) a(Integer.valueOf(this.c))).intValue();
    }

    public void setClientVersionCode(int i) {
        this.c = i;
    }

    String d() {
        return (String) a(this.d);
    }

    public void setClientAppId(String str) {
        this.d = str;
    }

    public String getClientAppName() {
        return (String) a(this.e);
    }

    public void setClientAppName(String str) {
        this.e = str;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f);
    }

    public void setTypeList(ArrayList arrayList) {
        this.f = arrayList;
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.g))).booleanValue();
    }

    public void setNeedConfirm(boolean z) {
        this.g = z;
    }
}
