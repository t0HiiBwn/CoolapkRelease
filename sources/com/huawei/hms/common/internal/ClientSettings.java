package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

public class ClientSettings {
    private String a;
    private String b;
    private List<Scope> c;
    private String d;
    private List<String> e;
    private String f;
    private SubAppInfo g;
    private WeakReference<Activity> h;
    private boolean i;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = str3;
        this.e = list2;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        setSubAppId(subAppInfo);
    }

    public String getClientPackageName() {
        return this.a;
    }

    public void setClientPackageName(String str) {
        this.a = str;
    }

    public String getClientClassName() {
        return this.b;
    }

    public void setClientClassName(String str) {
        this.b = str;
    }

    public List<Scope> getScopes() {
        return this.c;
    }

    public void setScopes(List<Scope> list) {
        this.c = list;
    }

    public String getAppID() {
        return this.d;
    }

    public void setAppID(String str) {
        this.d = str;
    }

    public SubAppInfo getSubAppID() {
        return this.g;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.g = subAppInfo;
    }

    public List<String> getApiName() {
        return this.e;
    }

    public void setApiName(List<String> list) {
        this.e = list;
    }

    public String getCpID() {
        return this.f;
    }

    public void setCpID(String str) {
        this.f = str;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void setCpActivity(Activity activity) {
        this.h = new WeakReference<>(activity);
        this.i = true;
    }

    public boolean isHasActivity() {
        return this.i;
    }
}
