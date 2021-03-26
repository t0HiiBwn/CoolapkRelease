package com.bytedance.sdk.openadsdk.i;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.i.b;
import com.bytedance.sdk.openadsdk.i.b.c;
import com.bytedance.sdk.openadsdk.i.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Preloader */
public class d {
    private static volatile d e;
    private volatile int a = 163840;
    private final SparseArray<Map<String, b>> b;
    private final b<Runnable> c;
    private final ExecutorService d;
    private volatile c f;
    private volatile com.bytedance.sdk.openadsdk.i.a.c g;
    private volatile com.bytedance.sdk.openadsdk.i.a.b h;
    private final HashSet<a> i;
    private final b.AbstractC0055b j;
    private volatile c k;
    private volatile c l;
    private volatile String m;
    private volatile boolean n;

    void a(com.bytedance.sdk.openadsdk.i.a.c cVar) {
        this.g = cVar;
    }

    void a(c cVar) {
        this.f = cVar;
    }

    public void a(int i2) {
        if (i2 > 0) {
            this.a = i2;
        }
        if (e.c) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i2);
        }
    }

    private d() {
        SparseArray<Map<String, b>> sparseArray = new SparseArray<>(2);
        this.b = sparseArray;
        this.i = new HashSet<>();
        this.j = new b.AbstractC0055b() {
            /* class com.bytedance.sdk.openadsdk.i.d.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.i.b.AbstractC0055b
            public void a(b bVar) {
                int f = bVar.f();
                synchronized (d.this.b) {
                    Map map = (Map) d.this.b.get(f);
                    if (map != null) {
                        map.remove(bVar.h);
                    }
                }
                if (e.c) {
                    Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.h);
                }
            }
        };
        b<Runnable> bVar = new b<>();
        this.c = bVar;
        ExecutorService a2 = a(bVar);
        this.d = a2;
        bVar.a((ThreadPoolExecutor) a2);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public synchronized void a(long j2, long j3, long j4) {
    }

    c a() {
        return this.k;
    }

    c b() {
        return this.l;
    }

    public static d c() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    void a(boolean z, String str) {
        this.m = str;
        this.n = z;
        if (e.c) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        b bVar = null;
        if (str == null) {
            synchronized (this.i) {
                if (!this.i.isEmpty()) {
                    hashSet2 = new HashSet(this.i);
                    this.i.clear();
                }
            }
            if (hashSet2 != null) {
                Iterator it2 = hashSet2.iterator();
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f);
                    if (e.c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + aVar.d);
                    }
                }
                return;
            }
            return;
        }
        int i2 = e.h;
        if (i2 == 3 || i2 == 2) {
            synchronized (this.b) {
                int size = this.b.size();
                for (int i3 = 0; i3 < size; i3++) {
                    SparseArray<Map<String, b>> sparseArray = this.b;
                    Map<String, b> map = sparseArray.get(sparseArray.keyAt(i3));
                    if (map != null) {
                        Collection<b> values = map.values();
                        if (values != null && !values.isEmpty()) {
                            if (hashSet == null) {
                                hashSet = new HashSet();
                            }
                            hashSet.addAll(values);
                        }
                        map.clear();
                    }
                }
            }
            if (!(hashSet == null || hashSet.isEmpty())) {
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    b bVar2 = (b) it3.next();
                    bVar2.a();
                    if (e.c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar2.g);
                    }
                }
                if (i2 == 3) {
                    synchronized (this.i) {
                        Iterator it4 = hashSet.iterator();
                        while (it4.hasNext()) {
                            a aVar2 = (a) ((b) it4.next()).n;
                            if (aVar2 != null) {
                                this.i.add(aVar2);
                            }
                        }
                    }
                }
            }
        } else if (i2 == 1) {
            synchronized (this.b) {
                Map<String, b> map2 = this.b.get(com.bytedance.sdk.openadsdk.i.b.b.a(z));
                if (map2 != null) {
                    bVar = map2.remove(str);
                }
            }
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void a(boolean z, boolean z2, int i2, String str, String... strArr) {
        a(z, z2, i2, str, null, strArr);
    }

    public void a(boolean z, boolean z2, int i2, String str, Map<String, String> map, String... strArr) {
        String str2;
        if (e.c) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bytedance.sdk.openadsdk.i.a.a aVar = z ? this.h : this.g;
        c cVar = this.f;
        if (aVar == null || cVar == null) {
            if (e.c) {
                Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
            }
        } else if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            int i3 = i2 <= 0 ? this.a : i2;
            if (z2) {
                str2 = str;
            } else {
                str2 = com.bytedance.sdk.openadsdk.i.g.b.a(str);
            }
            File d2 = aVar.d(str2);
            if (d2 == null || d2.length() < ((long) i3)) {
                if (!f.a().a(com.bytedance.sdk.openadsdk.i.b.b.a(z), str2)) {
                    synchronized (this.b) {
                        Map<String, b> map2 = this.b.get(z ? 1 : 0);
                        if (!map2.containsKey(str2)) {
                            a aVar2 = new a(z, z2, i3, str, map, strArr);
                            String str3 = this.m;
                            if (str3 != null) {
                                int i4 = e.h;
                                if (i4 == 3) {
                                    synchronized (this.i) {
                                        this.i.add(aVar2);
                                    }
                                    if (e.c) {
                                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                                    }
                                    return;
                                } else if (i4 == 2) {
                                    if (e.c) {
                                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                                    }
                                    return;
                                } else if (i4 == 1 && this.n == z && str3.equals(str2)) {
                                    if (e.c) {
                                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                                    }
                                    return;
                                }
                            }
                            ArrayList arrayList = null;
                            List<i.b> a2 = com.bytedance.sdk.openadsdk.i.g.d.a(com.bytedance.sdk.openadsdk.i.g.d.a(map));
                            if (a2 != null) {
                                arrayList = new ArrayList(a2.size());
                                int size = a2.size();
                                for (int i5 = 0; i5 < size; i5++) {
                                    i.b bVar = a2.get(i5);
                                    if (bVar != null) {
                                        arrayList.add(new i.b(bVar.a, bVar.b));
                                    }
                                }
                            }
                            b a3 = new b.a().a(aVar).a(cVar).a(str).b(str2).a(new l(com.bytedance.sdk.openadsdk.i.g.d.a(strArr))).a((List<i.b>) arrayList).a(i3).a(this.j).a(aVar2).a();
                            map2.put(str2, a3);
                            this.d.execute(a3);
                        }
                    }
                } else if (e.c) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                }
            } else if (e.c) {
                Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + d2.length() + ", need preload size: " + i3);
            }
        }
    }

    public void a(String str) {
        a(false, false, str);
    }

    public void a(final boolean z, final boolean z2, final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.i.g.d.a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.i.d.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    b bVar;
                    synchronized (d.this.b) {
                        Map map = (Map) d.this.b.get(com.bytedance.sdk.openadsdk.i.b.b.a(z));
                        if (map != null) {
                            bVar = (b) map.remove(z2 ? str : com.bytedance.sdk.openadsdk.i.g.b.a(str));
                        } else {
                            bVar = null;
                        }
                    }
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            });
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.i.g.d.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.i.d.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                ArrayList<b> arrayList = new ArrayList();
                synchronized (d.this.b) {
                    int size = d.this.b.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) d.this.b.get(d.this.b.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.c.clear();
                }
                for (b bVar : arrayList) {
                    bVar.a();
                    if (e.c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    /* compiled from: Preloader */
    private static final class a {
        final boolean a;
        final boolean b;
        final int c;
        final String d;
        final Map<String, String> e;
        final String[] f;

        a(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.a = z;
            this.b = z2;
            this.c = i;
            this.d = str;
            this.e = map;
            this.f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c) {
                return this.d.equals(aVar.d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + this.c) * 31) + this.d.hashCode();
        }
    }

    /* compiled from: Preloader */
    private static final class b<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor a;

        private b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                } else if (threadPoolExecutor != null) {
                    this.a = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.a.getPoolSize();
                int activeCount = this.a.getActiveCount();
                int maximumPoolSize = this.a.getMaximumPoolSize();
                if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                    return offerFirst(t);
                }
                if (e.c) {
                    Log.i("TAG_PROXY_TT", "create new preloader thread");
                }
                return false;
            }
        }
    }

    private static ExecutorService a(final b<Runnable> bVar) {
        int a2 = com.bytedance.sdk.openadsdk.i.g.d.a();
        return new ThreadPoolExecutor(0, a2 < 1 ? 1 : a2 > 4 ? 4 : a2, 60, TimeUnit.SECONDS, bVar, new ThreadFactory() {
            /* class com.bytedance.sdk.openadsdk.i.d.AnonymousClass4 */

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                AnonymousClass1 r0 = new Thread(runnable) {
                    /* class com.bytedance.sdk.openadsdk.i.d.AnonymousClass4.AnonymousClass1 */

                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        super.run();
                    }
                };
                r0.setName("tt_pangle_thread_video_preload_" + r0.getId());
                r0.setDaemon(true);
                if (e.c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + r0.getName());
                }
                return r0;
            }
        }, new RejectedExecutionHandler() {
            /* class com.bytedance.sdk.openadsdk.i.d.AnonymousClass5 */

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    bVar.offerFirst(runnable);
                    if (e.c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
