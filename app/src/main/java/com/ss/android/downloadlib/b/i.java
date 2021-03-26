package com.ss.android.downloadlib.b;

import android.os.Build;
import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.h.e;
import com.ss.android.socialbase.appdownloader.f.c;

/* compiled from: KllkOptimiseHelper */
public class i {
    public static boolean a(a aVar) {
        if (!c.d() || Build.VERSION.SDK_INT >= 29 || k.k() == null || !k.k().a() || e.a(aVar).b("invoke_app_form_background_switch") != 1 || !aVar.q()) {
            return false;
        }
        return true;
    }
}
