package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bl;
import com.xiaomi.push.service.bm;
import java.util.HashMap;
import java.util.Map;

public class ha {
    private static volatile ha a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f536a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, hb> f537a = new HashMap();

    private ha(Context context) {
        this.f536a = context;
    }

    public static ha a(Context context) {
        if (context == null) {
            b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (ha.class) {
                if (a == null) {
                    a = new ha(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        hg hgVar = new hg();
        hgVar.d(str3);
        hgVar.c(str4);
        hgVar.a(j);
        hgVar.b(str5);
        hgVar.a(true);
        hgVar.a("push_sdk_channel");
        hgVar.e(str2);
        return a(hgVar, str);
    }

    hb a() {
        hb hbVar = this.f537a.get("UPLOADER_PUSH_CHANNEL");
        if (hbVar != null) {
            return hbVar;
        }
        hb hbVar2 = this.f537a.get("UPLOADER_HTTP");
        if (hbVar2 != null) {
            return hbVar2;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    Map<String, hb> m386a() {
        return this.f537a;
    }

    public void a(hb hbVar, String str) {
        if (hbVar == null) {
            b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m386a().put(str, hbVar);
        }
    }

    public boolean a(hg hgVar, String str) {
        if (TextUtils.isEmpty(str)) {
            b.m41a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (bl.a(hgVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hgVar.d())) {
                hgVar.f(bl.a());
            }
            hgVar.g(str);
            bm.a(this.f536a, hgVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f536a.getPackageName(), this.f536a.getPackageName(), str, str2, j, str3);
    }
}
