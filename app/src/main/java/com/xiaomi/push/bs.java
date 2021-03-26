package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.xiaomi.push.ce;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.bl;

public class bs {
    private static volatile bs a;

    /* renamed from: a  reason: collision with other field name */
    private Context f238a;

    /* renamed from: a  reason: collision with other field name */
    private ai.a f239a = new bt(this);

    /* renamed from: a  reason: collision with other field name */
    private ch f240a;

    /* renamed from: a  reason: collision with other field name */
    private ci f241a;

    /* renamed from: a  reason: collision with other field name */
    private final String f242a = "push_stat_sp";
    private ai.a b = new bu(this);

    /* renamed from: b  reason: collision with other field name */
    private final String f243b = "upload_time";
    private ai.a c = new bv(this);

    /* renamed from: c  reason: collision with other field name */
    private final String f244c = "delete_time";
    private final String d = "check_time";
    private String e;
    private String f;

    private bs(Context context) {
        this.f238a = context;
    }

    public static bs a(Context context) {
        if (a == null) {
            synchronized (bs.class) {
                if (a == null) {
                    a = new bs(context);
                }
            }
        }
        return a;
    }

    private boolean a() {
        return an.a(this.f238a).a(hh.StatDataSwitch.a(), true);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f238a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    private String c() {
        return this.f238a.getDatabasePath(bw.f246a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m149a() {
        return this.e;
    }

    public void a(ce.a aVar) {
        ce.a(this.f238a).a(aVar);
    }

    public void a(hg hgVar) {
        if (a() && bl.a(hgVar.e())) {
            a(cb.a(this.f238a, c(), hgVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cj.a(this.f238a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f240a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f240a.a(this.f238a, str2, str);
        } else {
            this.f240a.b(this.f238a, str2, str);
        }
    }

    public String b() {
        return this.f;
    }
}
