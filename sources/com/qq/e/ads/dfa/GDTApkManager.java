package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class GDTApkManager {
    private DFA a;
    private boolean b = false;
    private boolean c = false;
    private AtomicInteger d = new AtomicInteger(0);
    private Context e;

    public GDTApkManager(final Context context, final IGDTApkListener iGDTApkListener) {
        String str;
        if (GDTADManager.getInstance().isInitialized()) {
            final String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
            if (StringUtil.isEmpty(appid) || context == null || iGDTApkListener == null) {
                str = String.format("GDTApkManager Constructor params error, appid=%s,context=%s,listener=%s", appid, context, iGDTApkListener);
            } else if (!a.a(context)) {
                str = "Required Activity/Service/Permission Not Declared in AndroidManifest.xml";
            } else {
                this.b = true;
                this.e = context;
                GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
                    /* class com.qq.e.ads.dfa.GDTApkManager.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        if (GDTADManager.getInstance().initWith(context, appid)) {
                            try {
                                final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    /* class com.qq.e.ads.dfa.GDTApkManager.AnonymousClass1.AnonymousClass1 */

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (pOFactory != null) {
                                                GDTApkManager.this.a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                                GDTApkManager.this.c = true;
                                                while (GDTApkManager.this.d.getAndDecrement() > 0) {
                                                    GDTApkManager.this.loadGDTApk();
                                                }
                                            }
                                        } catch (Throwable th) {
                                            GDTApkManager.this.c = true;
                                            throw th;
                                        }
                                        GDTApkManager.this.c = true;
                                    }
                                });
                            } catch (Throwable th) {
                                GDTLogger.e("Exception while init UnifiedBannerView plugin", th);
                            }
                        } else {
                            GDTLogger.e("Fail to init ADManager");
                        }
                    }
                });
                return;
            }
        } else {
            str = "SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化";
        }
        GDTLogger.e(str);
    }

    public final void loadGDTApk() {
        if (!this.b) {
            GDTLogger.e("GDTApkManager init Context error,See More logs while new GDTApkManager");
        } else if (!this.c) {
            this.d.incrementAndGet();
        } else {
            DFA dfa = this.a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.a;
        if (dfa != null) {
            dfa.startInstall(this.e, gDTApk);
        }
    }
}
