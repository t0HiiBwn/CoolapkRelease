package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.util.Log;

/* compiled from: AbsDevicePlan */
public abstract class a implements e {
    protected final Context a;
    protected final com.ss.android.socialbase.downloader.g.a b;
    protected final String c;

    public a(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        this.a = context;
        this.b = aVar;
        this.c = str;
    }

    public boolean a() {
        if (this.a == null) {
            return false;
        }
        try {
            if (b().resolveActivity(this.a.getPackageManager()) != null) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
    }
}
