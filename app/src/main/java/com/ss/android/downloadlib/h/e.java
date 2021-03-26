package com.ss.android.downloadlib.h;

import com.ss.android.a.a.b.c;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.g.a;
import org.json.JSONObject;

/* compiled from: DownloadSettingUtils */
public class e {
    public static JSONObject a() {
        return k.i().optJSONObject("ad");
    }

    public static JSONObject a(c cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.t()) {
            return a();
        }
        return cVar.p();
    }

    public static a b(c cVar) {
        return a.a(a(cVar));
    }

    public static a a(com.ss.android.downloadad.a.b.a aVar) {
        if (aVar == null) {
            return a.c();
        }
        if (aVar.s() != 0) {
            return a.a(aVar.s());
        }
        if (aVar.c()) {
            return a.a(a());
        }
        if (aVar.r() != null) {
            return a.a(aVar.r());
        }
        return a.c();
    }

    public static int a(a aVar) {
        return aVar.a("external_storage_permission_path_type", 0);
    }

    public static int c(c cVar) {
        return a(b(cVar));
    }

    public static boolean b(com.ss.android.downloadad.a.b.a aVar) {
        if (a(aVar).a("pause_reserve_on_wifi", 0) != 1 || !aVar.q()) {
            return false;
        }
        return true;
    }

    public static double a(int i) {
        return a.a(i).a("clean_min_install_size", 0.0d);
    }

    public static long b(int i) {
        return a.a(i).a("storage_min_size", 0L);
    }

    public static long c(int i) {
        return a.a(i).a("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean d(int i) {
        return a.a(i).a("clean_fetch_apk_switch", 0) == 1;
    }

    public static boolean e(int i) {
        return a.a(i).a("clean_space_before_download_switch", 0) == 1;
    }

    public static boolean f(int i) {
        return a.a(i).a("clean_space_switch", 0) == 1;
    }

    public static boolean g(int i) {
        return a.a(i).a("clean_app_cache_dir", 0) == 1;
    }

    public static boolean b(a aVar) {
        return aVar != null && aVar.a("kllk_need_rename_apk", 0) == 1;
    }
}
