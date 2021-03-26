package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: ProGuard */
public class DeviceInfo {
    private BuildInfo a = new BuildInfo();
    private ScreenInfo b;

    public DeviceInfo(Context context) {
        this.b = new ScreenInfo(context);
    }

    public String toString() {
        return "DeviceInfo{buildInfo=" + this.a + ", screenInfo=" + this.b + '}';
    }

    /* compiled from: ProGuard */
    private class BuildInfo {
        private String b = Build.BRAND;
        private String c = Build.MODEL;
        private String d = Build.VERSION.RELEASE;
        private int e = Build.VERSION.SDK_INT;
        private String f = Locale.getDefault().getLanguage();
        private String g = TimeZone.getDefault().getID();

        BuildInfo() {
        }

        public String toString() {
            return "BuildInfo{brand='" + this.b + "', model='" + this.c + "', systemVersion='" + this.d + "', sdkVersion=" + this.e + ", language='" + this.f + "', timezone='" + this.g + "'}";
        }
    }

    /* compiled from: ProGuard */
    private class ScreenInfo {
        private int b;
        private int c;

        ScreenInfo(Context context) {
            this.b = a(context);
            this.c = b(context);
        }

        public String toString() {
            return "ScreenInfo{width=" + this.b + ", height=" + this.c + '}';
        }

        private int a(Context context) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }

        private int b(Context context) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
    }
}
