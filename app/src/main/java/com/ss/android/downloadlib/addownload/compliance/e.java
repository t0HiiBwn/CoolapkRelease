package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.e.a;
import org.json.JSONObject;

/* compiled from: EventSender */
class e {
    public static void a(String str, long j) {
        com.ss.android.downloadlib.addownload.b.e e = f.a().e(j);
        if (!e.w()) {
            e.c.a(str);
            a.a().a("lp_app_dialog_click", e);
        }
    }

    public static void b(String str, long j) {
        a(str, null, j);
    }

    public static void a(String str, JSONObject jSONObject, long j) {
        a.a().a(str, jSONObject, (com.ss.android.downloadad.a.b.a) f.a().e(j));
    }

    public static void a(String str, com.ss.android.downloadlib.addownload.b.e eVar) {
        a.a().a(str, eVar);
    }

    public static void a(int i, com.ss.android.downloadlib.addownload.b.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        a.a().a("lp_compliance_error", jSONObject, (com.ss.android.downloadad.a.b.a) eVar);
    }

    public static void a(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        a.a().a("lp_compliance_error", jSONObject, (com.ss.android.downloadad.a.b.a) f.a().e(j));
    }
}
