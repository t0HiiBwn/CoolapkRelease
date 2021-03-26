package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;

public abstract class AbstractAD<T extends ADI> {
    private volatile boolean a = false;
    private volatile boolean b = false;
    private T c;
    private BrowserType d;
    private DownAPPConfirmPolicy e;

    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    protected final T a() {
        return this.c;
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2);

    protected final void a(final Context context, final String str, final String str2, final BasicADListener basicADListener) {
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
            a(basicADListener, 4002);
            return;
        }
        this.b = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            /* class com.qq.e.ads.AbstractAD.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                AbstractAD abstractAD;
                BasicADListener basicADListener;
                int i;
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.qq.e.ads.AbstractAD.AnonymousClass1.AnonymousClass1 */

                            /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: com.qq.e.ads.AbstractAD */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        AbstractAD.this.c = AbstractAD.this.a(context, pOFactory, str, str2);
                                        AbstractAD.this.a = true;
                                        if (AbstractAD.this.d != null) {
                                            AbstractAD.this.setBrowserType(AbstractAD.this.d);
                                        }
                                        if (AbstractAD.this.e != null) {
                                            AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.e);
                                        }
                                        AbstractAD.this.a((AbstractAD) AbstractAD.this.c);
                                        return;
                                    }
                                    AbstractAD.this.a = true;
                                    AbstractAD.this.a(basicADListener, 200102);
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Core", th);
                                    AbstractAD.this.a = true;
                                    AbstractAD.this.a(basicADListener, 2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init plugin", th);
                        abstractAD = AbstractAD.this;
                        basicADListener = basicADListener;
                        i = 200102;
                    }
                } else {
                    GDTLogger.e("Fail to init ADManager");
                    abstractAD = AbstractAD.this;
                    basicADListener = basicADListener;
                    i = 200101;
                    abstractAD.a(basicADListener, i);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(final BasicADListener basicADListener, final int i) {
        if (basicADListener == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            basicADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.qq.e.ads.AbstractAD.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    BasicADListener basicADListener = basicADListener;
                    if (basicADListener != null) {
                        basicADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
                    }
                }
            });
        }
    }

    protected abstract void a(T t);

    protected final boolean b() {
        return this.a;
    }

    protected final boolean c() {
        return this.b;
    }

    public void setBrowserType(BrowserType browserType) {
        this.d = browserType;
        T t = this.c;
        if (t != null && browserType != null) {
            t.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.e = downAPPConfirmPolicy;
        T t = this.c;
        if (t != null && downAPPConfirmPolicy != null) {
            t.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
