package com.amap.api.col.s;

import com.amap.api.col.s.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: RequestCacheWorker */
class ae {
    private boolean a = true;
    private long b = 86400;
    private int c = 10;
    private long d = 0;
    private final LinkedHashMap<ad.b, Object> e = new LinkedHashMap<>();
    private final Object f = new Object();
    private final LinkedHashMap<ad.b, Object> g = new LinkedHashMap<>();
    private final Object h = new Object();
    private ArrayList<String> i = new ArrayList<>();

    public ae(String... strArr) {
        a(strArr);
    }

    private void a(String... strArr) {
        this.d = System.currentTimeMillis();
        this.e.clear();
        this.i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.i.add(str);
            }
        }
    }

    protected boolean a(LinkedHashMap<ad.b, Object> linkedHashMap, ad.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    protected Object b(LinkedHashMap<ad.b, Object> linkedHashMap, ad.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    protected Object c(LinkedHashMap<ad.b, Object> linkedHashMap, ad.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }

    public final ad.c a(ad.b bVar) {
        if (!this.a || bVar == null || !b(bVar)) {
            return null;
        }
        a();
        synchronized (this.f) {
            if (a(this.e, bVar)) {
                return new ad.c(b(this.e, bVar), true);
            }
        }
        synchronized (this.h) {
            if (a(this.g, bVar)) {
                while (!a(this.e, bVar) && a(this.g, bVar)) {
                    try {
                        this.h.wait(1000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                this.g.put(bVar, null);
            }
        }
        return new ad.c(b(this.e, bVar), false);
    }

    public final void a(ad.b bVar, Object obj) {
        if (this.a && bVar != null && b(bVar)) {
            synchronized (this.f) {
                int size = this.e.size();
                if (size > 0 && size >= this.c) {
                    ad.b bVar2 = null;
                    Iterator<ad.b> it2 = this.e.keySet().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            ad.b next = it2.next();
                            if (next != null) {
                                bVar2 = next;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    c(this.e, bVar2);
                }
                a();
                this.e.put(bVar, obj);
            }
            synchronized (this.h) {
                c(this.g, bVar);
                this.h.notify();
            }
        }
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.d) / 1000 > this.b) {
            this.e.clear();
            this.d = currentTimeMillis;
        }
    }

    public final boolean b(ad.b bVar) {
        if (!(bVar == null || bVar.a == null)) {
            Iterator<String> it2 = this.i.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next != null && bVar.a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(ad.a aVar) {
        if (aVar != null) {
            this.a = aVar.a();
            this.b = aVar.b();
            this.c = aVar.c();
        }
    }
}
