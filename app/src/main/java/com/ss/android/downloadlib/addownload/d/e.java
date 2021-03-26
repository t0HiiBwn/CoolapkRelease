package com.ss.android.downloadlib.addownload.d;

import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.e.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MistakeClickInterceptor */
public class e implements d {
    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(b bVar, int i, c cVar) {
        if (bVar == null || !b(bVar.s())) {
            return false;
        }
        if (System.currentTimeMillis() - bVar.S() > a(bVar.s())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a.a().a("pause_optimise", jSONObject, (com.ss.android.downloadad.a.b.a) bVar);
        return true;
    }

    private long a(int i) {
        return (long) com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_mistake_click_interval", 300);
    }

    private boolean b(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }
}
