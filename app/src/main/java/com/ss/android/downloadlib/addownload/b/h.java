package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.socialbase.downloader.g.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PackageManagerChecker */
public class h {
    private static volatile h a;

    private h() {
    }

    public static h a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    public void a(int i, int i2, b bVar) {
        if (bVar != null) {
            a a2 = a.a(bVar.s());
            if (a2.a("report_api_hijack", 0) != 0) {
                int i3 = i2 - i;
                if (i > 0 && i3 > a2.a("check_api_hijack_version_code_diff", 500)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("version_code_diff", i3);
                        jSONObject.put("installed_version_code", i2);
                        jSONObject.put("hijack_type", 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    com.ss.android.downloadlib.e.a.a().a("api_hijack", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
                }
            }
        }
    }
}
