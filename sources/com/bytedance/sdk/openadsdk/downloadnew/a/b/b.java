package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.ss.android.downloadad.a.a.a;
import com.ss.android.downloadad.a.a.b;
import com.ss.android.downloadad.a.a.c;
import org.json.JSONObject;

/* compiled from: LibModelFactory */
public class b {
    public static c.a a(String str, String str2, l lVar, JSONObject jSONObject) {
        if (lVar == null) {
            return new c.a();
        }
        if (TextUtils.isEmpty(str)) {
            return new c.a();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str2).b(jSONObject).a(lVar).b());
        } catch (Exception unused) {
        }
        c.a a = new c.a().a(Long.valueOf(lVar.ag()).longValue()).c(lVar.U() == null ? null : lVar.U().a()).b(i.d().l()).d(!i.d().l()).a(lVar.aj()).a(jSONObject2).d(str).a(true);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            a.c(true);
        }
        if (lVar.ai() != null) {
            com.ss.android.a.a.c.b bVar = new com.ss.android.a.a.c.b();
            bVar.a(Long.valueOf(lVar.ag()).longValue());
            bVar.b(lVar.ai().a());
            bVar.c(lVar.ad());
            if (lVar.ai().c() != 2 || l.c(lVar)) {
                if (lVar.ai().c() == 1) {
                    bVar.a(lVar.ai().b());
                } else {
                    bVar.a(lVar.W());
                }
            }
            a.a(bVar);
        }
        return a;
    }

    public static c.a a(String str, l lVar, JSONObject jSONObject) {
        if (lVar == null) {
            return new c.a();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str).b(jSONObject).a(lVar).b());
        } catch (Exception unused) {
        }
        c.a a = new c.a().a(Double.valueOf(lVar.ag()).longValue()).c(lVar.U() == null ? null : lVar.U().a()).b(i.d().l()).d(!i.d().l()).a(lVar.aj()).a(jSONObject2).a(true);
        com.bytedance.sdk.openadsdk.core.d.b ah = lVar.ah();
        if (ah != null) {
            a.d(ah.b()).e(ah.c()).b(ah.d());
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            a.c(true);
        }
        if (lVar.ai() != null) {
            com.ss.android.a.a.c.b bVar = new com.ss.android.a.a.c.b();
            bVar.a(Long.valueOf(lVar.ag()).longValue());
            bVar.b(lVar.ai().a());
            bVar.c(lVar.ad());
            if (lVar.ai().c() != 2 || l.c(lVar)) {
                if (lVar.ai().c() == 1) {
                    bVar.a(lVar.ai().b());
                } else {
                    bVar.a(lVar.W());
                }
            }
            a.a(bVar);
        }
        return a;
    }

    public static a.C0090a a(l lVar) {
        int i;
        int G = lVar == null ? 1 : lVar.G();
        if (lVar == null) {
            i = 0;
        } else {
            i = lVar.H();
        }
        if (lVar != null && !TextUtils.isEmpty(lVar.au())) {
            i = 2;
        }
        return new a.C0090a().a(G).b(i).a(true).b(false).a(lVar);
    }

    public static b.a a(l lVar, String str) {
        return new b.a().a(str).b(str).c("click_start").e("click_continue").d("click_pause").h("download_failed").f("click_install").a(true).c(false);
    }
}
