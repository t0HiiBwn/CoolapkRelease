package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Map;
import org.json.JSONObject;

public final class bw {
    private static final String a = (bw.class.getSimpleName() + "#");
    private static bs<ce> b = new bs<ce>() {
        /* class com.bytedance.embedapplog.bw.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public ce a(Object... objArr) {
            return new ce((Context) objArr[0]);
        }
    };

    public static void a(Context context) {
        b.b(context).a();
    }

    public static String a(SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String a2 = bu.a(sharedPreferences);
        bx.b("TrackerDr", a + "getCdid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return a2;
    }

    public static Map<String, String> a(Context context, SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, String> a2 = b.b(context).a(100);
        bx.b("TrackerDr", a + "getOaid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return a2;
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void a(IOaidObserver iOaidObserver) {
        ce.a(iOaidObserver);
    }
}
