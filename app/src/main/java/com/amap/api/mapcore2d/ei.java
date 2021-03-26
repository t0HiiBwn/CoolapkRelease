package com.amap.api.mapcore2d;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseLoader */
abstract class ei extends ClassLoader {
    protected final Context a;
    protected final Map<String, Class<?>> b = new HashMap();
    protected DexFile c = null;
    volatile boolean d = true;
    protected da e;
    protected String f;
    protected volatile boolean g = false;
    protected volatile boolean h = false;

    public ei(Context context, da daVar, boolean z) {
        super(context.getClassLoader());
        this.a = context;
        this.e = daVar;
    }

    public boolean a() {
        return this.c != null;
    }

    protected void b() {
        try {
            synchronized (this.b) {
                this.b.clear();
            }
            if (this.c != null) {
                if (this.h) {
                    synchronized (this.c) {
                        this.c.wait();
                    }
                }
                this.g = true;
                this.c.close();
            }
        } catch (Throwable th) {
            eh.a(th, "BaseLoader", "releaseDexFile()");
        }
    }
}
