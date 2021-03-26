package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: FakeDownloadHeadHttpConnection */
public class c implements g {
    private static final ArrayList<String> e;
    protected final String a;
    protected final long b;
    protected List<com.ss.android.socialbase.downloader.model.c> c;
    protected final Object d = new Object();
    private Map<String, String> f = null;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private g k;

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        e = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.a = str;
        this.c = list;
        this.b = j2;
    }

    public void a() throws Exception {
        if (this.f == null) {
            try {
                this.j = true;
                this.k = b.a(this.a, this.c);
                synchronized (this.d) {
                    if (this.k != null) {
                        HashMap hashMap = new HashMap();
                        this.f = hashMap;
                        a(this.k, hashMap);
                        this.g = this.k.b();
                        this.h = System.currentTimeMillis();
                        this.i = a(this.g);
                    }
                    this.j = false;
                    this.d.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this.d) {
                    if (this.k != null) {
                        HashMap hashMap2 = new HashMap();
                        this.f = hashMap2;
                        a(this.k, hashMap2);
                        this.g = this.k.b();
                        this.h = System.currentTimeMillis();
                        this.i = a(this.g);
                    }
                    this.j = false;
                    this.d.notifyAll();
                    throw th;
                }
            }
        }
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar != null && map != null) {
            Iterator<String> it2 = e.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                map.put(next, gVar.a(next));
            }
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.d) {
            if (this.j && this.f == null) {
                this.d.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f;
        if (map != null) {
            return map.get(str);
        }
        g gVar = this.k;
        if (gVar != null) {
            return gVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.h < b.b;
    }

    public boolean g() {
        return this.j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.c;
    }

    public Map<String, String> i() {
        return this.f;
    }
}
