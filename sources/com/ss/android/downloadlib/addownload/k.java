package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.ss.android.a.a.a.b;
import com.ss.android.a.a.a.c;
import com.ss.android.a.a.a.d;
import com.ss.android.a.a.a.e;
import com.ss.android.a.a.a.f;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.i;
import com.ss.android.a.a.a.j;
import com.ss.android.a.a.a.l;
import com.ss.android.a.a.a.m;
import com.ss.android.a.a.a.o;
import com.ss.android.a.a.a.r;
import com.ss.android.a.a.c.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* compiled from: GlobalInfo */
public class k {
    public static final JSONObject a = new JSONObject();
    public static boolean b = false;
    private static Context c;
    private static f d;
    private static c e;
    private static com.ss.android.a.a.a.k f;
    private static g g;
    private static h h;
    private static i i;
    private static a j;
    private static b k;
    private static com.ss.android.socialbase.appdownloader.c.h l;
    private static d m;
    private static e n;
    private static o o;
    private static j p;
    private static r q;
    private static m r;
    private static l s;

    public static String m() {
        return "1.9.5.1";
    }

    public static boolean s() {
        return false;
    }

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        c = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (c == null && context != null && context.getApplicationContext() != null) {
            c = context.getApplicationContext();
        }
    }

    public static Context a() {
        Context context = c;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void a(f fVar) {
        d = fVar;
    }

    public static void a(com.ss.android.a.a.a.k kVar) {
        f = kVar;
    }

    public static void a(g gVar) {
        g = gVar;
    }

    public static void a(h hVar) {
        h = hVar;
    }

    public static void a(i iVar) {
        i = iVar;
        try {
            com.ss.android.socialbase.appdownloader.d.j().b(v());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(a aVar) {
        j = aVar;
    }

    public static void a(b bVar) {
        k = bVar;
    }

    public static f b() {
        return d;
    }

    public static c c() {
        if (e == null) {
            e = new c() {
                /* class com.ss.android.downloadlib.addownload.k.AnonymousClass1 */

                @Override // com.ss.android.a.a.a.c
                public void a(Context context, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.b bVar) {
                }

                @Override // com.ss.android.a.a.a.c
                public void a(Context context, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.b bVar, String str, String str2) {
                }
            };
        }
        return e;
    }

    public static com.ss.android.a.a.a.k d() {
        if (f == null) {
            f = new com.ss.android.downloadlib.c.a();
        }
        return f;
    }

    public static g e() {
        return g;
    }

    public static h f() {
        if (h == null) {
            h = new com.ss.android.downloadlib.c.b();
        }
        return h;
    }

    public static com.ss.android.socialbase.appdownloader.c.h g() {
        if (l == null) {
            l = new com.ss.android.socialbase.appdownloader.c.h() {
                /* class com.ss.android.downloadlib.addownload.k.AnonymousClass2 */

                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return l;
    }

    public static o h() {
        return o;
    }

    public static JSONObject i() {
        if (i == null) {
            i = new i() {
                /* class com.ss.android.downloadlib.addownload.k.AnonymousClass3 */

                @Override // com.ss.android.a.a.a.i
                public JSONObject a() {
                    return k.a;
                }
            };
        }
        return (JSONObject) com.ss.android.downloadlib.h.k.a((Object[]) new JSONObject[]{i.a(), a});
    }

    public static l j() {
        return s;
    }

    public static b k() {
        return k;
    }

    public static m l() {
        return r;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static d n() {
        return m;
    }

    public static e o() {
        return n;
    }

    public static j p() {
        return p;
    }

    public static r q() {
        return q;
    }

    public static boolean r() {
        if (i().optInt("is_enable_start_install_again") == 1 || s()) {
            return true;
        }
        return false;
    }

    public static long t() {
        long optLong = i().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000;
        }
        return optLong;
    }

    public static long u() {
        long optLong = i().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000;
        }
        return optLong;
    }

    public static String v() {
        try {
            int i2 = a().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + i().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }
}
