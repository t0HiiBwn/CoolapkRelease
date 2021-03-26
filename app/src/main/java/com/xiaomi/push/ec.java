package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.ab;
import java.util.HashMap;

public final class ec {
    private static volatile ec a;

    /* renamed from: a  reason: collision with other field name */
    private int f391a;

    /* renamed from: a  reason: collision with other field name */
    private Context f392a;

    /* renamed from: a  reason: collision with other field name */
    private eg f393a;

    /* renamed from: a  reason: collision with other field name */
    private String f394a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<ee, ef> f395a;
    private String b;

    private ec(Context context) {
        HashMap<ee, ef> hashMap = new HashMap<>();
        this.f395a = hashMap;
        this.f392a = context;
        hashMap.put(ee.SERVICE_ACTION, new ei());
        this.f395a.put(ee.SERVICE_COMPONENT, new ej());
        this.f395a.put(ee.ACTIVITY, new ea());
        this.f395a.put(ee.PROVIDER, new eh());
    }

    public static ec a(Context context) {
        if (a == null) {
            synchronized (ec.class) {
                if (a == null) {
                    a = new ec(context);
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: private */
    public void a(ee eeVar, Context context, eb ebVar) {
        this.f395a.get(eeVar).a(context, ebVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m288a(Context context) {
        return ab.m606a(context, context.getPackageName());
    }

    public int a() {
        return this.f391a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eg m289a() {
        return this.f393a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m290a() {
        return this.f394a;
    }

    public void a(int i) {
        this.f391a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            dy.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f392a).a(new ed(this, str, context, str2, str3));
    }

    public void a(ee eeVar, Context context, Intent intent, String str) {
        if (eeVar != null) {
            this.f395a.get(eeVar).a(context, intent, str);
        } else {
            dy.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eg egVar) {
        this.f393a = egVar;
    }

    public void a(String str) {
        this.f394a = str;
    }

    public void a(String str, String str2, int i, eg egVar) {
        a(str);
        b(str2);
        a(i);
        a(egVar);
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }
}
