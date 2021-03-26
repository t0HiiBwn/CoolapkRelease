package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

final class cn<SERVICE, RESULT> {
    private final CountDownLatch a = new CountDownLatch(1);
    private final Intent b;
    private final b<SERVICE, RESULT> c;
    private final Context d;

    interface b<T, RESULT> {
        RESULT a(T t);

        T b(IBinder iBinder);
    }

    cn(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.d = context;
        this.b = intent;
        this.c = bVar;
    }

    RESULT a() {
        Throwable th;
        a aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        try {
            aVar = new a(this.a, this.c);
            this.d.bindService(this.b, aVar, 1);
            this.a.await();
            try {
                RESULT a2 = this.c.a(aVar.a);
                a(aVar);
                return a2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    a(aVar);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
            th.printStackTrace();
            return null;
        }
    }

    private void a(cn<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class a implements ServiceConnection {
        SERVICE a;
        private final CountDownLatch c;
        private final b<SERVICE, RESULT> d;

        a(CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.c = countDownLatch;
            this.d = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = ce.a;
            bx.b(str, "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.a = this.d.b(iBinder);
                try {
                    this.c.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    this.c.countDown();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            String str = ce.a;
            bx.b(str, "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.c.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
