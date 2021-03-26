package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.b;
import java.util.HashMap;

public final class dj {
    private static volatile dj a;
    private Context b;
    private HashMap<dl, dm> c;
    private String d;
    private String e;
    private int f;
    private dn g;

    private dj(Context context) {
        HashMap<dl, dm> hashMap = new HashMap<>();
        this.c = hashMap;
        this.b = context;
        hashMap.put(dl.SERVICE_ACTION, new dp());
        this.c.put(dl.SERVICE_COMPONENT, new dq());
        this.c.put(dl.ACTIVITY, new dh());
        this.c.put(dl.PROVIDER, new Cdo());
    }

    public static dj a(Context context) {
        if (a == null) {
            synchronized (dj.class) {
                if (a == null) {
                    a = new dj(context);
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: private */
    public void a(dl dlVar, Context context, di diVar) {
        this.c.get(dlVar).a(context, diVar);
    }

    public static boolean b(Context context) {
        return b.a(context, context.getPackageName());
    }

    public dn a() {
        return this.g;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            df.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        j.a(this.b).a(new dk(this, str, context, str2, str3));
    }

    public void a(dl dlVar, Context context, Intent intent, String str) {
        if (dlVar != null) {
            this.c.get(dlVar).a(context, intent, str);
        } else {
            df.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(dn dnVar) {
        this.g = dnVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(String str, String str2, int i, dn dnVar) {
        a(str);
        b(str2);
        a(i);
        a(dnVar);
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }
}
