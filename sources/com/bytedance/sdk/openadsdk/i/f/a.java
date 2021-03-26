package com.bytedance.sdk.openadsdk.i.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.i.a.c;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.i.f;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: VideoCachePreloader */
public class a {
    public static final boolean a = u.c();
    private HashMap<String, Boolean> b;
    private C0056a c;

    /* compiled from: VideoCachePreloader */
    private static class b {
        private static final a a = new a();
    }

    private a() {
        this.b = new HashMap<>();
        b();
    }

    public static a a() {
        return b.a;
    }

    public boolean b() {
        if (this.c != null) {
            return true;
        }
        c c2 = c();
        if (c2 == null) {
            return false;
        }
        e.a(true);
        e.b(true);
        e.a(1);
        f.a().d();
        try {
            C0056a aVar = new C0056a();
            this.c = aVar;
            aVar.setName("tt_pangle_thread_video_cache_preloader");
            this.c.start();
            e.a(c2, p.a());
            d.c().a(30000, 30000, 30000);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(b bVar) {
        if (!b()) {
            return false;
        }
        this.c.a(bVar);
        return true;
    }

    public String b(b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.c);
        return f.a().a(false, z, z ? bVar.c : bVar.a, bVar.a);
    }

    private static c c() {
        IOException e;
        c cVar = null;
        if (!com.bytedance.sdk.openadsdk.i.g.a.d()) {
            return null;
        }
        File file = new File(com.bytedance.sdk.openadsdk.i.g.a.a(com.bytedance.sdk.openadsdk.i.g.a.b(), "cache").getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            c cVar2 = new c(file);
            try {
                cVar2.a(104857600);
                return cVar2;
            } catch (IOException e2) {
                e = e2;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            return cVar;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.f.a$a  reason: collision with other inner class name */
    /* compiled from: VideoCachePreloader */
    class C0056a extends Thread {
        private Queue<C0057a> b = new LinkedBlockingQueue();
        private boolean c = true;
        private final Queue<C0057a> d = new ArrayBlockingQueue(10);
        private Queue<C0057a> e = new LinkedBlockingQueue();

        private void a() {
        }

        private void b() {
        }

        public C0056a() {
        }

        private C0057a a(int i, b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.d.size());
            C0057a poll = this.d.poll();
            if (poll == null) {
                poll = new C0057a();
            }
            poll.a = i;
            poll.f = bVar;
            return poll;
        }

        private void a(C0057a aVar) {
            a();
            aVar.c = null;
            aVar.b = null;
            aVar.a = -1;
            aVar.f = null;
            this.d.offer(aVar);
        }

        private synchronized void b(C0057a aVar) {
            b();
            this.e.add(aVar);
            notify();
        }

        private void c(C0057a aVar) {
            a();
            if (aVar != null) {
                this.b.offer(aVar);
                notify();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.c) {
                synchronized (this) {
                    if (!this.e.isEmpty()) {
                        c();
                    }
                    while (!this.b.isEmpty()) {
                        C0057a poll = this.b.poll();
                        if (poll != null) {
                            int i = poll.a;
                            if (i != 0) {
                                if (i == 1) {
                                    d.c().a(poll.b);
                                } else if (i == 2) {
                                    d.c().d();
                                } else if (i == 3) {
                                    d.c().d();
                                    if (e.c() != null) {
                                        e.c().a();
                                    }
                                    if (e.b() != null) {
                                        e.b().a();
                                    }
                                } else if (i == 4) {
                                    d.c().d();
                                    this.c = false;
                                }
                            } else if (poll.c != null && poll.c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                String[] strArr = poll.c;
                                for (String str : strArr) {
                                    if (com.bytedance.sdk.openadsdk.i.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.e), poll.d, poll.b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            a(poll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        private void c() {
            a();
            while (true) {
                C0057a poll = this.e.poll();
                if (poll != null) {
                    poll.b = poll.f.a;
                    poll.c = new String[]{poll.f.a};
                    poll.d = poll.f.b;
                    poll.e = poll.f.c;
                    if (!TextUtils.isEmpty(poll.f.c)) {
                        poll.b = poll.f.c;
                    }
                    poll.f = null;
                    c(poll);
                } else {
                    return;
                }
            }
        }

        public void a(b bVar) {
            b(a(0, bVar));
        }

        /* renamed from: com.bytedance.sdk.openadsdk.i.f.a$a$a  reason: collision with other inner class name */
        /* compiled from: VideoCachePreloader */
        private class C0057a {
            public int a;
            public String b;
            public String[] c;
            public int d;
            public String e;
            public b f;

            public C0057a() {
            }
        }
    }
}
