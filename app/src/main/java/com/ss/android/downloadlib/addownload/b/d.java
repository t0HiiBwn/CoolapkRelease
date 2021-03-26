package com.ss.android.downloadlib.addownload.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.h.k;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: InstalledAppManager */
public class d {
    private static volatile d a;
    private static final String[] c = {"com", "android", "ss"};
    private static final int[] d = {3101, 3102, 3103, 3201, 3202, 3203};
    private final LinkedList<a> b = new LinkedList<>();

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(String str) {
        a c2;
        b();
        if (!TextUtils.isEmpty(str) && (c2 = c(str)) != null) {
            synchronized (this.b) {
                this.b.add(c2);
            }
        }
    }

    public void b(String str) {
        b();
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.b) {
                Iterator<a> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next().a)) {
                        it2.remove();
                        return;
                    }
                }
            }
        }
    }

    public a a(b bVar) {
        if (bVar == null) {
            return null;
        }
        b();
        synchronized (this.b) {
            Iterator<a> it2 = this.b.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next.e > bVar.B()) {
                    return next;
                }
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        r7[1] = r11;
     */
    public Pair<a, Integer> b(b bVar) {
        int i;
        a next;
        if (bVar == null) {
            return null;
        }
        try {
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.b.isEmpty()) {
            return null;
        }
        String M = bVar.M();
        String e = bVar.e();
        String I = bVar.I();
        int H = bVar.H();
        int length = d.length;
        a[] aVarArr = new a[length];
        synchronized (this.b) {
            Iterator<a> it2 = this.b.iterator();
            PackageInfo packageInfo = null;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                next = it2.next();
                if (next.e >= bVar.B()) {
                    if (TextUtils.isEmpty(M)) {
                        if (packageInfo == null) {
                            packageInfo = k.a(bVar);
                        }
                        if (packageInfo != null) {
                            try {
                                M = (String) com.ss.android.downloadlib.addownload.k.a().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(M) && !TextUtils.isEmpty(next.d)) {
                        M = M.toLowerCase();
                        if (!M.equals(next.d)) {
                            if (M.contains(next.d) || next.d.contains(M)) {
                                break;
                            }
                        } else {
                            aVarArr[0] = next;
                            break;
                        }
                    }
                    if (TextUtils.isEmpty(e)) {
                        if (packageInfo == null) {
                            packageInfo = k.a(bVar);
                        }
                        if (packageInfo != null) {
                            e = packageInfo.packageName;
                        }
                    }
                    if (!TextUtils.isEmpty(e) && !TextUtils.isEmpty(next.a)) {
                        e = e.toLowerCase();
                        if (e.contains(next.a) || next.a.contains(e)) {
                            break;
                        } else if (aVarArr[3] == null) {
                            if (a(e, next.a)) {
                                aVarArr[3] = next;
                            }
                        }
                    }
                    if (aVarArr[4] == null) {
                        if (TextUtils.isEmpty(I)) {
                            if (packageInfo == null) {
                                packageInfo = k.a(bVar);
                            }
                            if (packageInfo != null) {
                                I = packageInfo.versionName;
                            }
                        }
                        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(next.c)) {
                            I = I.toLowerCase();
                            if (I.equals(next.c)) {
                                aVarArr[4] = next;
                            }
                        }
                        if (aVarArr[5] == null) {
                            if (H <= 0) {
                                if (packageInfo == null) {
                                    packageInfo = k.a(bVar);
                                }
                                if (packageInfo != null) {
                                    H = packageInfo.versionCode;
                                }
                            }
                            if (H == next.b) {
                                aVarArr[5] = next;
                            }
                        }
                    }
                }
            }
            aVarArr[2] = next;
        }
        for (i = 0; i < length; i++) {
            if (aVarArr[i] != null) {
                return new Pair<>(aVarArr[i], Integer.valueOf(d[i]));
            }
        }
        return null;
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.b) {
            Iterator<a> it2 = this.b.iterator();
            while (it2.hasNext() && currentTimeMillis - it2.next().e > 1800000) {
                it2.remove();
            }
        }
    }

    private a c(String str) {
        try {
            PackageManager packageManager = com.ss.android.downloadlib.addownload.k.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new a(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static boolean a(String str, String str2) {
        boolean z;
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (split.length != 0) {
                if (split2.length != 0) {
                    int i = 0;
                    int i2 = 0;
                    for (String str3 : split) {
                        String[] strArr = c;
                        int length = strArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                z = false;
                                break;
                            }
                            String str4 = strArr[i3];
                            if (str4.equals(str3)) {
                                if (i < split2.length && str4.equals(split2[i])) {
                                    i++;
                                }
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        if (!z) {
                            int i4 = i2;
                            int i5 = i;
                            while (i < split2.length) {
                                if (str3.equals(split2[i])) {
                                    if (i == i5) {
                                        i5++;
                                    }
                                    i4++;
                                    if (i4 >= 2) {
                                        return true;
                                    }
                                }
                                i++;
                            }
                            i = i5;
                            i2 = i4;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* compiled from: InstalledAppManager */
    public static class a {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final long e;

        private a(String str, int i, String str2, String str3, long j) {
            this.a = str;
            this.b = i;
            String str4 = null;
            this.c = str2 != null ? str2.toLowerCase() : null;
            this.d = str3 != null ? str3.toLowerCase() : str4;
            this.e = j;
        }
    }
}
