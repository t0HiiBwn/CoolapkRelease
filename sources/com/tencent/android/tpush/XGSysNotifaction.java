package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Intent;

/* compiled from: ProGuard */
public class XGSysNotifaction {
    private int a;
    private Notification b;
    private String c;
    private Intent d;
    private int e;
    private Object f;

    public XGSysNotifaction(String str, int i, Notification notification, Intent intent, int i2, Object obj) {
        this.c = str;
        this.a = i;
        this.b = notification;
        this.d = intent;
        this.e = i2;
        this.f = obj;
    }

    public String getAppPkg() {
        return this.c;
    }

    public int getNotifyId() {
        return this.a;
    }

    public Notification getNotifaction() {
        return this.b;
    }

    public Intent getPendintIntent() {
        return this.d;
    }

    public int getPendintIntentFlag() {
        return this.e;
    }

    public Object getNotificationChannle() {
        return this.f;
    }
}
