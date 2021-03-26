package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.g.c.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AdEventDispatcher */
public class b<T extends i> {
    private g<T> a;
    private Handler b;
    private AtomicBoolean c;

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar) {
        this.a = new g<>(eVar, qVar, bVar, aVar);
        this.c = new AtomicBoolean(false);
    }

    public b(e<T> eVar, q<T> qVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.a = gVar;
        this.c = new AtomicBoolean(false);
    }

    b() {
    }

    public synchronized void a() {
        AtomicBoolean atomicBoolean = this.c;
        if ((atomicBoolean == null || !atomicBoolean.get()) && this.a.getLooper() == null) {
            AtomicBoolean atomicBoolean2 = this.c;
            if (atomicBoolean2 != null && !atomicBoolean2.get()) {
                this.a.start();
                Handler handler = new Handler(this.a.getLooper(), this.a);
                this.b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.b.sendMessage(obtainMessage);
                this.c.set(true);
            }
        }
    }

    public void b() {
        this.c.set(false);
        this.a.quit();
        this.b.removeCallbacksAndMessages(null);
    }

    public void a(T t) {
        if (this.c.get()) {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.b.sendMessage(obtainMessage);
        }
    }

    public static a c() {
        return a.e();
    }

    public static C0036b d() {
        return C0036b.e();
    }

    /* compiled from: AdEventDispatcher */
    private static class a extends b<a> {
        private static volatile a a;

        public void a(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        public static a e() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.b$b  reason: collision with other inner class name */
    /* compiled from: AdEventDispatcher */
    private static class C0036b extends b<c.a> {
        private static volatile C0036b a;

        public void a(c.a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        public static C0036b e() {
            if (a == null) {
                synchronized (C0036b.class) {
                    if (a == null) {
                        a = new C0036b();
                    }
                }
            }
            return a;
        }

        C0036b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }
}
