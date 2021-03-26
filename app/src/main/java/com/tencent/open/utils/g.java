package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.a.f;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
public class g {
    private static g a;
    private volatile WeakReference<SharedPreferences> b = null;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    public String a(Context context, String str) {
        if (this.b == null || this.b.get() == null) {
            this.b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                f.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.b.get().getString(host, null);
            if (string != null) {
                if (!host.equals(string)) {
                    String replace = str.replace(host, string);
                    f.a("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                    return replace;
                }
            }
            f.a("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e) {
            f.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }
}
