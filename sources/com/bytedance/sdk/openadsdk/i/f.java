package com.bytedance.sdk.openadsdk.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.i.a.b;
import com.bytedance.sdk.openadsdk.i.b.c;
import com.bytedance.sdk.openadsdk.i.g;
import com.bytedance.sdk.openadsdk.i.g.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProxyServer */
public class f {
    private static volatile f d;
    private volatile ServerSocket a;
    private volatile int b;
    private final AtomicInteger c = new AtomicInteger(0);
    private volatile c e;
    private volatile com.bytedance.sdk.openadsdk.i.a.c f;
    private volatile b g;
    private final SparseArray<Set<g>> h;
    private final g.c i;
    private volatile c j;
    private volatile c k;
    private final Runnable l;
    private final AtomicBoolean m;

    /* access modifiers changed from: private */
    public static void b(String str, String str2) {
    }

    boolean a(int i2, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.h) {
            Set<g> set = this.h.get(i2);
            if (set != null) {
                for (g gVar : set) {
                    if (gVar != null && str.equals(gVar.h)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static f a() {
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    d = new f();
                }
            }
        }
        return d;
    }

    private f() {
        SparseArray<Set<g>> sparseArray = new SparseArray<>(2);
        this.h = sparseArray;
        this.i = new g.c() {
            /* class com.bytedance.sdk.openadsdk.i.f.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.i.g.c
            public void a(g gVar) {
                synchronized (f.this.h) {
                    Set set = (Set) f.this.h.get(gVar.f());
                    if (set != null) {
                        set.add(gVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.g.c
            public void b(g gVar) {
                if (e.c) {
                    Log.d("TAG_PROXY_ProxyServer", "afterExecute, ProxyTask: " + gVar);
                }
                int f = gVar.f();
                synchronized (f.this.h) {
                    Set set = (Set) f.this.h.get(f);
                    if (set != null) {
                        set.remove(gVar);
                    }
                }
            }
        };
        this.l = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.i.f.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i = 0;
                    f.this.a = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
                    f fVar = f.this;
                    fVar.b = fVar.a.getLocalPort();
                    if (f.this.b == -1) {
                        f.b("socket not bound", "");
                        f.this.e();
                        return;
                    }
                    j.a("127.0.0.1", f.this.b);
                    if (f.this.g() && f.this.c.compareAndSet(0, 1)) {
                        if (e.c) {
                            Log.i("TAG_PROXY_ProxyServer", "proxy server start!");
                        }
                        while (f.this.c.get() == 1) {
                            try {
                                try {
                                    Socket accept = f.this.a.accept();
                                    c cVar = f.this.e;
                                    if (cVar != null) {
                                        e.a(new g.a().a(cVar).a(accept).a(f.this.i).a(), 10);
                                    } else {
                                        d.a(accept);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    f.b("accept error", Log.getStackTraceString(e));
                                    i++;
                                    if (i > 3) {
                                        break;
                                    }
                                }
                            } catch (Throwable th) {
                                String stackTraceString = Log.getStackTraceString(th);
                                Log.e("TAG_PROXY_ProxyServer", "proxy server crashed!  " + stackTraceString);
                                f.b("error", stackTraceString);
                            }
                        }
                        if (e.c) {
                            Log.i("TAG_PROXY_ProxyServer", "proxy server closed!");
                        }
                        f.this.e();
                    }
                } catch (IOException e2) {
                    if (e.c) {
                        Log.e("TAG_PROXY_ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e2));
                    }
                    f.b("create ServerSocket error", Log.getStackTraceString(e2));
                    f.this.e();
                }
            }
        };
        this.m = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    c b() {
        return this.j;
    }

    c c() {
        return this.k;
    }

    void a(c cVar) {
        this.e = cVar;
    }

    void a(com.bytedance.sdk.openadsdk.i.a.c cVar) {
        this.f = cVar;
    }

    public String a(boolean z, boolean z2, String str, String... strArr) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            b("url", "url is empty");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            b("key", "key is empty");
            return strArr[0];
        } else if (this.e == null) {
            b("db", "VideoProxyDB is null");
            return strArr[0];
        } else {
            if ((z ? this.g : this.f) == null) {
                b("cache", "Cache is null");
                return strArr[0];
            }
            int i2 = this.c.get();
            if (i2 != 1) {
                b("state", "ProxyServer is not running, " + i2);
                return strArr[0];
            }
            List<String> a2 = d.a(strArr);
            if (a2 == null) {
                b("url", "url not start with http/https");
                return strArr[0];
            }
            if (z2) {
                str2 = str;
            } else {
                str2 = com.bytedance.sdk.openadsdk.i.g.b.a(str);
            }
            String a3 = i.a(str, str2, a2);
            if (a3 == null) {
                b("url", "combine proxy url error");
                return strArr[0];
            } else if (z) {
                return "http://127.0.0.1:" + this.b + "?f=1&" + a3;
            } else {
                return "http://127.0.0.1:" + this.b + "?" + a3;
            }
        }
    }

    public void d() {
        if (this.m.compareAndSet(false, true)) {
            Thread thread = new Thread(this.l);
            thread.setName("tt_pangle_thread_proxy_server");
            thread.start();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.c.compareAndSet(1, 2) || this.c.compareAndSet(0, 2)) {
            d.a(this.a);
            f();
        }
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.h) {
            int size = this.h.size();
            for (int i2 = 0; i2 < size; i2++) {
                SparseArray<Set<g>> sparseArray = this.h;
                Set<g> set = sparseArray.get(sparseArray.keyAt(i2));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((g) it2.next()).a();
        }
    }

    /* access modifiers changed from: private */
    public boolean g() {
        final com.bytedance.sdk.openadsdk.j.f fVar = new com.bytedance.sdk.openadsdk.j.f(new a("127.0.0.1", this.b), 5, 1);
        e.a().execute(new com.bytedance.sdk.openadsdk.j.g() {
            /* class com.bytedance.sdk.openadsdk.i.f.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                u.b("TTExecutor", "pingTest.....run");
                fVar.run();
            }
        });
        h();
        try {
            if (!((Boolean) fVar.get()).booleanValue()) {
                Log.e("TAG_PROXY_ProxyServer", "Ping error");
                b("ping error", "");
                e();
                return false;
            }
            if (e.c) {
                Log.i("TAG_PROXY_ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            b("ping error", Log.getStackTraceString(th));
            e();
            return false;
        }
    }

    /* compiled from: ProxyServer */
    private static final class a implements Callable<Boolean> {
        private final String a;
        private final int b;

        a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* renamed from: a */
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.a, this.b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(d.a));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        d.a(socket);
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        f.b("ping error", Log.getStackTraceString(th));
                        d.a(socket);
                        return false;
                    } catch (Throwable th3) {
                        d.a(socket);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                socket = null;
                th = th4;
                th.printStackTrace();
                f.b("ping error", Log.getStackTraceString(th));
                d.a(socket);
                return false;
            }
            d.a(socket);
            return false;
        }
    }

    private void h() {
        Socket socket = null;
        try {
            socket = this.a.accept();
            socket.setSoTimeout(2000);
            if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("OK\n".getBytes(d.a));
                outputStream.flush();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            b("ping error", Log.getStackTraceString(e2));
        } catch (Throwable th) {
            d.a((Socket) null);
            throw th;
        }
        d.a(socket);
    }
}
