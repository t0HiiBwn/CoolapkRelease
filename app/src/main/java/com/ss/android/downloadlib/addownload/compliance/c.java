package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.b.b;
import com.ss.android.socialbase.downloader.i.g;

/* compiled from: AppInfoCache */
public class c extends g<Long, b> {

    /* compiled from: AppInfoCache */
    private static class a {
        private static c a = new c();
    }

    public static c a() {
        return a.a;
    }

    private c() {
        super(16, 16);
    }

    public void a(b bVar) {
        if (bVar != null) {
            put(Long.valueOf(bVar.a()), bVar);
        }
    }

    public b a(long j, long j2) {
        return (b) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public b a(long j) {
        return (b) get(Long.valueOf(j));
    }
}
