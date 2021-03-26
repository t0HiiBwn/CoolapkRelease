package com.tencent.open.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
public class a extends i implements Handler.Callback {
    private b a;
    private FileWriter b;
    private File c;
    private char[] d;
    private volatile g e;
    private volatile g f;
    private volatile g g;
    private volatile g h;
    private volatile boolean i;
    private HandlerThread j;
    private Handler k;

    public a(b bVar) {
        this(c.b, true, h.a, bVar);
    }

    public a(int i2, boolean z, h hVar, b bVar) {
        super(i2, z, hVar);
        this.i = false;
        a(bVar);
        this.e = new g();
        this.f = new g();
        this.g = this.e;
        this.h = this.f;
        this.d = new char[bVar.d()];
        g();
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.j = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (this.j.isAlive() && this.j.getLooper() != null) {
            this.k = new Handler(this.j.getLooper(), this);
        }
    }

    public void a() {
        if (this.k.hasMessages(1024)) {
            this.k.removeMessages(1024);
        }
        this.k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.j.quit();
    }

    @Override // com.tencent.open.a.i
    protected void a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        a(e().a(i2, thread, j2, str, str2, th));
    }

    protected void a(String str) {
        this.g.a(str);
        if (this.g.a() >= c().d()) {
            a();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.i) {
            this.i = true;
            i();
            try {
                this.h.a(g(), this.d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.h.b();
                throw th;
            }
            this.h.b();
            this.i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.c)) || (this.b == null && a2 != null)) {
            this.c = a2;
            h();
            try {
                this.b = new FileWriter(this.c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.b;
    }

    private void h() {
        try {
            FileWriter fileWriter = this.b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.g == this.e) {
                this.g = this.f;
                this.h = this.e;
            } else {
                this.g = this.e;
                this.h = this.f;
            }
        }
    }

    public b c() {
        return this.a;
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
