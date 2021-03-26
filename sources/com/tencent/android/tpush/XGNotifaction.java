package com.tencent.android.tpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.tencent.android.tpush.b.e;

/* compiled from: ProGuard */
public class XGNotifaction {
    private int a = 0;
    private Notification b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private Context f = null;
    private String g = null;
    private String h = null;
    private String i = null;

    public XGNotifaction(Context context, int i2, Notification notification, e eVar) {
        if (eVar != null) {
            this.f = context.getApplicationContext();
            this.a = i2;
            this.b = notification;
            this.c = eVar.d();
            this.d = eVar.e();
            this.e = eVar.f();
            this.g = eVar.l().d;
            this.h = eVar.l().f;
            this.i = eVar.l().b;
        }
    }

    public void setNotifyId(int i2) {
        this.a = i2;
    }

    public String toString() {
        return "XGNotifaction [notifyId=" + this.a + ", title=" + this.c + ", content=" + this.d + ", customContent=" + this.e + "]";
    }

    public boolean doNotify() {
        Context context;
        NotificationManager notificationManager;
        if (this.b == null || (context = this.f) == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.notify(this.a, this.b);
        return true;
    }

    public int getNotifyId() {
        return this.a;
    }

    public Notification getNotifaction() {
        return this.b;
    }

    public String getTitle() {
        return this.c;
    }

    public String getContent() {
        return this.d;
    }

    public String getCustomContent() {
        return this.e;
    }

    public String getTargetIntent() {
        return this.g;
    }

    public String getTargetUrl() {
        return this.h;
    }

    public String getTargetActivity() {
        return this.i;
    }
}
