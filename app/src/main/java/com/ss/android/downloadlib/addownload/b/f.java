package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.g;
import com.ss.android.downloadlib.d;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: ModelManager */
public class f {
    private volatile boolean a;
    private final ConcurrentHashMap<Long, c> b;
    private final ConcurrentHashMap<Long, b> c;
    private final ConcurrentHashMap<Long, com.ss.android.a.a.b.a> d;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.b> e;

    /* compiled from: ModelManager */
    private static class a {
        private static f a = new f();
    }

    public static f a() {
        return a.a;
    }

    private f() {
        this.a = false;
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
    }

    public void b() {
        d.a().a((Runnable) new Runnable() {
            /* class com.ss.android.downloadlib.addownload.b.f.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.a) {
                    synchronized (f.class) {
                        if (!f.this.a) {
                            f.this.e.putAll(i.a().b());
                            f.this.a = true;
                        }
                    }
                }
            }
        }, true);
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.b.put(Long.valueOf(cVar.d()), cVar);
            if (cVar.x() != null) {
                cVar.x().a(cVar.d());
                cVar.x().d(cVar.v());
            }
        }
    }

    public void a(long j, b bVar) {
        if (bVar != null) {
            this.c.put(Long.valueOf(j), bVar);
        }
    }

    public void a(long j, com.ss.android.a.a.b.a aVar) {
        if (aVar != null) {
            this.d.put(Long.valueOf(j), aVar);
        }
    }

    public synchronized void a(com.ss.android.downloadad.a.b.b bVar) {
        if (bVar != null) {
            this.e.put(Long.valueOf(bVar.b()), bVar);
            i.a().a(bVar);
        }
    }

    public c a(long j) {
        return this.b.get(Long.valueOf(j));
    }

    public b b(long j) {
        return this.c.get(Long.valueOf(j));
    }

    public com.ss.android.a.a.b.a c(long j) {
        return this.d.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.a.b.b d(long j) {
        return this.e.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.b> c() {
        return this.e;
    }

    public com.ss.android.downloadad.a.b.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.a.b.b bVar : this.e.values()) {
            if (bVar != null && str.equals(bVar.e())) {
                return bVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.a.b.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.a.b.b bVar : this.e.values()) {
            if (bVar != null && str.equals(bVar.a())) {
                return bVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.a.b.b a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long a2 = k.a(new JSONObject(downloadInfo.getExtra()), "extra");
                if (a2 > 0) {
                    for (com.ss.android.downloadad.a.b.b bVar : this.e.values()) {
                        if (bVar != null) {
                            if (bVar.b() == a2) {
                                return bVar;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.a.b.b bVar2 : this.e.values()) {
            if (bVar2 != null && bVar2.s() == downloadInfo.getId()) {
                return bVar2;
            }
        }
        for (com.ss.android.downloadad.a.b.b bVar3 : this.e.values()) {
            if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                return bVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.a.b.b a(int i) {
        for (com.ss.android.downloadad.a.b.b bVar : this.e.values()) {
            if (bVar != null && bVar.s() == i) {
                return bVar;
            }
        }
        return null;
    }

    public e e(long j) {
        e eVar = new e();
        eVar.a = j;
        eVar.b = a(j);
        eVar.c = b(j);
        if (eVar.c == null) {
            eVar.c = new g();
        }
        eVar.d = c(j);
        if (eVar.d == null) {
            eVar.d = new com.ss.android.a.a.b.f();
        }
        return eVar;
    }

    public void f(long j) {
        this.b.remove(Long.valueOf(j));
        this.c.remove(Long.valueOf(j));
        this.d.remove(Long.valueOf(j));
    }

    public Map<Long, com.ss.android.downloadad.a.b.b> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.a.b.b bVar : this.e.values()) {
                if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                    bVar.b(str2);
                    hashMap.put(Long.valueOf(bVar.b()), bVar);
                }
            }
        }
        return hashMap;
    }

    public void b(String str, String str2) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            for (c cVar : this.b.values()) {
                if ((cVar instanceof com.ss.android.downloadad.a.a.c) && TextUtils.equals(cVar.a(), str)) {
                    ((com.ss.android.downloadad.a.a.c) cVar).b(str2);
                }
            }
        }
    }

    public synchronized void a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l2 : list) {
            long longValue = l2.longValue();
            arrayList.add(String.valueOf(longValue));
            this.e.remove(Long.valueOf(longValue));
        }
        i.a().a((List<String>) arrayList);
    }
}
