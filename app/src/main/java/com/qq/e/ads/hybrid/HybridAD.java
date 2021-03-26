package com.qq.e.ads.hybrid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HybridAD implements HADI {
    private volatile boolean a;
    private volatile boolean b;
    private volatile boolean c;
    private HADI d;
    private HybridADListener e;
    private CountDownLatch f = new CountDownLatch(1);

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), hybridADSetting, hybridADListener);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        hybridADListener.onError(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public HybridAD(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, hybridADSetting, hybridADListener);
    }

    private void a(final Context context, final String str, final HybridADSetting hybridADSetting, final HybridADListener hybridADListener) {
        if (context == null || TextUtils.isEmpty(str) || hybridADListener == null) {
            GDTLogger.e(String.format("HybridAD Constructor params error, context=%s, appID=%s,HybridADListener=%s", context, str, hybridADListener));
            return;
        }
        this.e = hybridADListener;
        this.b = true;
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.c = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            /* class com.qq.e.ads.hybrid.HybridAD.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.qq.e.ads.hybrid.HybridAD.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (pOFactory != null) {
                                    HybridAD.this.d = pOFactory.getHybridAD(hybridADSetting, hybridADListener);
                                    HybridAD.this.a = true;
                                } else {
                                    GDTLogger.e("poFactory is null");
                                    HybridAD.a(HybridAD.this, 2001);
                                }
                                HybridAD.this.f.countDown();
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init HybridAD plugin", th);
                    }
                } else {
                    GDTLogger.e("Fail to init ADManager");
                    HybridAD.a(HybridAD.this, 2001);
                    HybridAD.this.f.countDown();
                }
            }
        });
    }

    static /* synthetic */ void a(HybridAD hybridAD, int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable(2001) {
            /* class com.qq.e.ads.hybrid.HybridAD.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (HybridAD.this.e != null) {
                    HybridAD.this.e.onError(AdErrorConvertor.formatErrorCode(2001));
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        boolean z;
        if (!this.b || !this.c) {
            GDTLogger.e("AD init Params OR Context error, details in logs produced while init HybridAD");
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            GDTLogger.e("HybridAD loadUrl error");
        } else if (this.a) {
            this.d.loadUrl(str);
        } else {
            new Thread(new Runnable() {
                /* class com.qq.e.ads.hybrid.HybridAD.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HybridAD.this.f.await(30, TimeUnit.SECONDS);
                        if (HybridAD.this.a) {
                            HybridAD.this.d.loadUrl(str);
                            return;
                        }
                        GDTLogger.e("delegate init failed ");
                        HybridAD.a(HybridAD.this, 2001);
                    } catch (InterruptedException unused) {
                        GDTLogger.e("buffered loadUrl action timeout");
                        HybridAD.a(HybridAD.this, 2001);
                    }
                }
            }).start();
        }
    }
}
