package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.framework.d;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import java.util.HashSet;
import java.util.Set;

public class b {
    boolean a = false;
    private Set<IInitializeComponent.IInitFinishListener> b = new HashSet();
    private Object c = new Object();
    private String d = null;
    private ISGPluginManager e = null;

    public b() {
    }

    public b(String str) {
        this.d = str;
    }

    /* access modifiers changed from: private */
    public void b() {
        synchronized (this.c) {
            for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.b) {
                iInitFinishListener.onSuccess();
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        synchronized (this.c) {
            for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.b) {
                iInitFinishListener.onError();
            }
        }
    }

    public synchronized int a(Context context, String str, boolean z, boolean z2) throws SecException {
        if (!this.a) {
            if (context != null) {
                d dVar = new d();
                dVar.a(context, this.d, str, z, new Object[0]);
                dVar.getPluginInfo(dVar.getMainPluginName());
                this.e = dVar;
                this.a = true;
            } else {
                throw new SecException(101);
            }
        }
        return !this.a ? 1 : 0;
    }

    public ISGPluginManager a() {
        return this.e;
    }

    public void a(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.c) {
                this.b.add(iInitFinishListener);
            }
        }
    }

    public boolean a(Context context) throws SecException {
        return true;
    }

    public void b(final Context context, final String str, final boolean z, final boolean z2) throws SecException {
        if (context != null) {
            new Thread(new Runnable() {
                /* class com.alibaba.wireless.security.open.initialize.b.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.a(context, str, z, z2);
                        b.this.b();
                    } catch (SecException e2) {
                        e2.printStackTrace();
                        b.this.c();
                    }
                }
            }).start();
            return;
        }
        throw new SecException(101);
    }

    public void b(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.c) {
                this.b.remove(iInitFinishListener);
            }
        }
    }
}
