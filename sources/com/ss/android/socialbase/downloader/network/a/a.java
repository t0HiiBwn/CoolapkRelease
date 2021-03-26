package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadConnectionPool */
public class a {
    protected int a;
    private final Map<String, c> b;
    private final Map<String, d> c;

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$a  reason: collision with other inner class name */
    /* compiled from: DownloadConnectionPool */
    private static final class C0124a {
        private static final a a = new a();
    }

    void a(String str, c cVar) {
        synchronized (this.b) {
            this.b.put(str, cVar);
        }
    }

    void a(int i) {
        this.a = i;
    }

    public c a(String str, List<c> list) {
        c remove;
        synchronized (this.b) {
            remove = this.b.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (e.a(remove.h(), list)) {
            try {
                remove.d();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (remove.f() && remove.e()) {
                return remove;
            }
        }
        try {
            remove.c();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(String str) {
        c cVar = this.b.get(str);
        if (cVar == null) {
            return false;
        }
        if (cVar.g()) {
            return true;
        }
        if (!cVar.f() || !cVar.e()) {
            return false;
        }
        return true;
    }

    public d b(String str, List<c> list) {
        d remove;
        synchronized (this.c) {
            remove = this.c.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (e.a(remove.f(), list)) {
            try {
                remove.e();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (remove.h() && remove.g()) {
                return remove;
            }
        }
        try {
            remove.d();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static a a() {
        return C0124a.a;
    }

    private a() {
        this.b = new HashMap();
        this.c = new LinkedHashMap(3);
        this.a = 3;
    }
}
