package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.be;
import com.xiaomi.push.j;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.l;

public class ar {
    private static volatile ar e;
    private final String a = "push_stat_sp";
    private final String b = "upload_time";
    private final String c = "delete_time";
    private final String d = "check_time";
    private Context f;
    private String g;
    private String h;
    private bh i;
    private bi j;
    private j.a k = new as(this);
    private j.a l = new at(this);
    private j.a m = new au(this);

    private ar(Context context) {
        this.f = context;
    }

    public static ar a(Context context) {
        if (e == null) {
            synchronized (ar.class) {
                if (e == null) {
                    e = new ar(context);
                }
            }
        }
        return e;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        iz.a(edit);
    }

    private boolean c() {
        return l.a(this.f).a(gn.StatDataSwitch.a(), true);
    }

    /* access modifiers changed from: private */
    public String d() {
        return this.f.getDatabasePath(av.a).getAbsolutePath();
    }

    public String a() {
        return this.g;
    }

    public void a(be.a aVar) {
        be.a(this.f).a(aVar);
    }

    public void a(gm gmVar) {
        if (c() && ak.a(gmVar.p())) {
            a(ba.a(this.f, d(), gmVar));
        }
    }

    public void a(String str) {
        if (c() && !TextUtils.isEmpty(str)) {
            a(bj.a(this.f, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.i == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.i.a(this.f, str2, str);
        } else {
            this.i.b(this.f, str2, str);
        }
    }

    public String b() {
        return this.h;
    }
}
