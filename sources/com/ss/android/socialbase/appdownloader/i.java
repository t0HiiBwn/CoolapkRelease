package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.downloader.b;

/* compiled from: ResourceUtils */
public class i {
    public static int a(String str) {
        try {
            return b.L().getResources().getIdentifier(str, "layout", b.L().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(String str) {
        return a(b.L(), str);
    }

    public static int c(String str) {
        try {
            return a(str, b.L().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(String str, String str2) {
        try {
            return b.L().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int d(String str) {
        try {
            return b.L().getResources().getIdentifier(str, "style", b.L().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int e(String str) {
        try {
            return b.L().getResources().getIdentifier(str, "id", b.L().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return b.L().getResources().getIdentifier(str, "color", b.L().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(String str, String str2) {
        try {
            return b.L().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
