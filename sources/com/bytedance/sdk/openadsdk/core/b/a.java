package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: FrequentCallController */
public class a {
    private static volatile a a;
    private static volatile boolean b;
    private static volatile long c;
    private final Queue<C0040a> d = new LinkedList();
    private Handler e;
    private final h f = p.h();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int k = this.f.k();
        long j = this.f.j();
        if (this.d.size() <= 0 || this.d.size() < k) {
            this.d.offer(new C0040a(currentTimeMillis, str));
        } else {
            long abs = Math.abs(currentTimeMillis - this.d.peek().a);
            if (abs <= j) {
                b(j - abs);
                return true;
            }
            this.d.poll();
            this.d.offer(new C0040a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(c);
        } else {
            a(false);
        }
        return b;
    }

    private synchronized void a(long j) {
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }
        this.e.postDelayed(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.b.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z) {
        b = z;
    }

    public synchronized boolean b() {
        return b;
    }

    private synchronized void b(long j) {
        c = j;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0040a aVar : this.d) {
            if (hashMap.containsKey(aVar.b)) {
                hashMap.put(aVar.b, Integer.valueOf(((Integer) hashMap.get(aVar.b)).intValue() + 1));
            } else {
                hashMap.put(aVar.b, 1);
            }
        }
        int i = Integer.MIN_VALUE;
        str = "";
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i < intValue) {
                str = str2;
                i = intValue;
            }
        }
        return str;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* compiled from: FrequentCallController */
    private static class C0040a {
        private final long a;
        private final String b;

        private C0040a(long j, String str) {
            this.a = j;
            this.b = str;
        }
    }
}
