package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public abstract class v implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private File f1053a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f1054a;

    private v(Context context, File file) {
        this.a = context;
        this.f1053a = file;
    }

    /* synthetic */ v(Context context, File file, w wVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new w(context, file, runnable).run();
    }

    protected abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = null;
        try {
            if (this.f1053a == null) {
                this.f1053a = new File(this.a.getFilesDir(), "default_locker");
            }
            uVar = u.a(this.a, this.f1053a);
            Runnable runnable = this.f1054a;
            if (runnable != null) {
                runnable.run();
            }
            a(this.a);
            if (uVar == null) {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                uVar.a();
            }
            throw th;
        }
        uVar.a();
    }
}
