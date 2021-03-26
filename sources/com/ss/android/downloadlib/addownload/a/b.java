package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.b.a;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: AdDownloadDialogSpHelper */
class b {
    b() {
    }

    CopyOnWriteArrayList<a> a(String str, String str2) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = k.a().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    a a = a.a(jSONObject.optJSONObject(keys.next()));
                    if (a != null) {
                        copyOnWriteArrayList.add(a);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    void a(String str, String str2, CopyOnWriteArrayList<a> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                Iterator<a> it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next != null) {
                        jSONObject.put(String.valueOf(next.b), next.a());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            k.a().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
        }
    }

    void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            k.a().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
        }
    }
}
