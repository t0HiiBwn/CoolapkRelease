package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.al;
import java.util.HashMap;
import java.util.Map;

public class gg {
    private static volatile gg a;
    private final Context b;
    private Map<String, gh> c = new HashMap();

    private gg(Context context) {
        this.b = context;
    }

    public static gg a(Context context) {
        if (context == null) {
            c.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (gg.class) {
                if (a == null) {
                    a = new gg(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        gm gmVar = new gm();
        gmVar.d(str3);
        gmVar.c(str4);
        gmVar.a(j);
        gmVar.b(str5);
        gmVar.c(true);
        gmVar.a("push_sdk_channel");
        gmVar.e(str2);
        return a(gmVar, str);
    }

    gh a() {
        gh ghVar = this.c.get("UPLOADER_PUSH_CHANNEL");
        if (ghVar != null) {
            return ghVar;
        }
        gh ghVar2 = this.c.get("UPLOADER_HTTP");
        if (ghVar2 != null) {
            return ghVar2;
        }
        return null;
    }

    public void a(gh ghVar, String str) {
        if (ghVar == null) {
            c.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            c.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            b().put(str, ghVar);
        }
    }

    public boolean a(gm gmVar, String str) {
        if (TextUtils.isEmpty(str)) {
            c.a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (ak.a(gmVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(gmVar.m())) {
                gmVar.f(ak.a());
            }
            gmVar.g(str);
            al.a(this.b, gmVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.b.getPackageName(), this.b.getPackageName(), str, str2, j, str3);
    }

    Map<String, gh> b() {
        return this.c;
    }
}
