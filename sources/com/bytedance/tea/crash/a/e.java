package com.bytedance.tea.crash.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.tea.crash.g.a;
import com.bytedance.tea.crash.g.m;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ANRUtils */
public class e {
    public static JSONObject a(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", m.a(stackTrace));
        return jSONObject;
    }

    static String a(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo a = a.a(context, i);
        if (a == null || Process.myPid() != a.pid) {
            return null;
        }
        return b.a(a);
    }
}
