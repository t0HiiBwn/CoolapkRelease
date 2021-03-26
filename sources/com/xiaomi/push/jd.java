package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public abstract class jd implements Runnable {
    private Context a;
    private File b;
    private Runnable c;

    private jd(Context context, File file) {
        this.a = context;
        this.b = file;
    }

    /* synthetic */ jd(Context context, File file, je jeVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new je(context, file, runnable).run();
    }

    protected abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        jc jcVar = null;
        try {
            if (this.b == null) {
                this.b = new File(this.a.getFilesDir(), "default_locker");
            }
            jcVar = jc.a(this.a, this.b);
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
            a(this.a);
            if (jcVar == null) {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                jcVar.a();
            }
            throw th;
        }
        jcVar.a();
    }
}
