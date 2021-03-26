package com.kepler.sdk;

import android.content.Context;
import com.kepler.jd.login.KeplerApiManager;
import java.net.MalformedURLException;
import java.net.URL;

public class al {
    public static final String a = KeplerApiManager.getKeplerVersion();
    private static Context c;
    private ai b = new ai();

    static class a {
        static final al a = new al();
    }

    public static al a() {
        return a.a;
    }

    al() {
    }

    public al a(Context context, String str, String str2) {
        aj.a(context);
        if (context == null) {
            throw new IllegalArgumentException("valid context is required");
        } else if (!a(str)) {
            throw new IllegalArgumentException("valid serverURL is required");
        } else if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("valid appKey is required");
        } else {
            this.b.b(str);
            this.b.a(str2);
            c = context;
            this.b.a(context);
            return this;
        }
    }

    public synchronized void b() {
        c();
    }

    void c() {
        this.b.b();
    }

    public static boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }
}
