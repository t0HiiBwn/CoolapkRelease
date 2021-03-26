package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.downloader.b;

/* compiled from: AppUtils */
public final class g {
    public static int a(String str) {
        if (c(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = b.L().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static a b(String str) {
        try {
            PackageManager packageManager = b.L().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static a a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return new a(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    /* compiled from: AppUtils */
    public static class a {
        private String a;
        private String b;
        private Drawable c;
        private String d;
        private String e;
        private int f;
        private boolean g;

        public Drawable a() {
            return this.c;
        }

        public void a(Drawable drawable) {
            this.c = drawable;
        }

        public boolean b() {
            return this.g;
        }

        public void a(boolean z) {
            this.g = z;
        }

        public String c() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public String d() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String e() {
            return this.d;
        }

        public void c(String str) {
            this.d = str;
        }

        public int f() {
            return this.f;
        }

        public void a(int i) {
            this.f = i;
        }

        public String g() {
            return this.e;
        }

        public void d(String str) {
            this.e = str;
        }

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            b(str2);
            a(drawable);
            a(str);
            c(str3);
            d(str4);
            a(i);
            a(z);
        }

        public String toString() {
            return "{\n  pkg name: " + c() + "\n  app icon: " + a() + "\n  app name: " + d() + "\n  app path: " + e() + "\n  app v name: " + g() + "\n  app v code: " + f() + "\n  is system: " + b() + "}";
        }
    }

    private static boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
