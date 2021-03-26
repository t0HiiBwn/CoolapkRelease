package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

public abstract class LiteAbstractAD<T> {
    private T a;

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2);

    protected abstract void a(int i);

    protected final void a(final Context context, final String str, final String str2) {
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
            a(4002);
            return;
        }
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            /* class com.qq.e.ads.LiteAbstractAD.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                LiteAbstractAD liteAbstractAD;
                int i;
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.qq.e.ads.LiteAbstractAD.AnonymousClass1.AnonymousClass1 */

                            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.qq.e.ads.LiteAbstractAD */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        LiteAbstractAD.this.a = LiteAbstractAD.this.a(context, pOFactory, str, str2);
                                        LiteAbstractAD.this.a((LiteAbstractAD) LiteAbstractAD.this.a);
                                        return;
                                    }
                                    LiteAbstractAD.this.a(200102);
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Core", th);
                                    LiteAbstractAD.this.a(2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init plugin", th);
                        liteAbstractAD = LiteAbstractAD.this;
                        i = 200102;
                    }
                } else {
                    GDTLogger.e("Fail to init ADManager");
                    liteAbstractAD = LiteAbstractAD.this;
                    i = 200101;
                    liteAbstractAD.a(i);
                }
            }
        });
    }

    protected abstract void a(T t);
}
