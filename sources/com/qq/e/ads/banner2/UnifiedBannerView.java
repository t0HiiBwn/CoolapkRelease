package com.qq.e.ads.banner2;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class UnifiedBannerView extends FrameLayout {
    private UBVI a;
    private boolean b;
    private boolean c;
    private boolean d;
    private DownAPPConfirmPolicy e;
    private AtomicInteger f;
    private int g;
    private LoadAdParams h;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, (Map) null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.b = false;
        this.c = false;
        this.d = false;
        this.f = new AtomicInteger(0);
        this.g = 30;
        this.h = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedBannerADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, null);
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.b = false;
        this.c = false;
        this.d = false;
        this.f = new AtomicInteger(0);
        this.g = 30;
        this.h = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedBannerADListener, map);
    }

    private void a(final Activity activity, final String str, final String str2, final UnifiedBannerADListener unifiedBannerADListener, final Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedBannerADListener == null) {
            GDTLogger.e(String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedBannerADListener));
            return;
        }
        this.b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.c = true;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            /* class com.qq.e.ads.banner2.UnifiedBannerView.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.qq.e.ads.banner2.UnifiedBannerView.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        UnifiedBannerView.this.a = pOFactory.getUnifiedBannerViewDelegate(UnifiedBannerView.this, activity, str, str2, unifiedBannerADListener);
                                        UnifiedBannerView.this.d = true;
                                        UnifiedBannerView.a(UnifiedBannerView.this, map, str2);
                                        if (UnifiedBannerView.this.e != null) {
                                            UnifiedBannerView.this.setDownConfirmPolicy(UnifiedBannerView.this.e);
                                        }
                                        UnifiedBannerView.this.setRefresh(UnifiedBannerView.this.g);
                                        UnifiedBannerView.this.setLoadAdParams(UnifiedBannerView.this.h);
                                        while (UnifiedBannerView.this.f.getAndDecrement() > 0) {
                                            UnifiedBannerView.this.loadAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    UnifiedBannerView.this.d = true;
                                    throw th;
                                }
                                UnifiedBannerView.this.d = true;
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
    }

    static /* synthetic */ void a(UnifiedBannerView unifiedBannerView, Map map, String str) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", new JSONObject(map), str);
            } catch (Exception e2) {
                GDTLogger.e("UnifiedBanner#setTag Exception");
                e2.printStackTrace();
            }
        }
    }

    public void destroy() {
        UBVI ubvi = this.a;
        if (ubvi != null) {
            ubvi.destroy();
        }
    }

    public Map getExt() {
        try {
            if (this.a != null) {
                return UBVI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("banner2 can not get ext");
            return null;
        }
    }

    public void loadAD() {
        if (!this.b || !this.c) {
            GDTLogger.e("UnifiedBannerView init Paras OR Context error,See More logs while new BannerView");
        } else if (!this.d) {
            this.f.incrementAndGet();
        } else {
            UBVI ubvi = this.a;
            if (ubvi != null) {
                ubvi.fetchAd();
            } else {
                GDTLogger.e("UnifiedBannerView Init error,See More Logs");
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        UBVI ubvi = this.a;
        if (ubvi != null) {
            ubvi.onWindowFocusChanged(z);
        }
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        UBVI ubvi;
        this.e = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy != null && (ubvi = this.a) != null) {
            ubvi.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.h = loadAdParams;
        UBVI ubvi = this.a;
        if (ubvi != null) {
            ubvi.setLoadAdParams(loadAdParams);
        }
    }

    public void setRefresh(int i) {
        this.g = i;
        UBVI ubvi = this.a;
        if (ubvi != null) {
            ubvi.setRefresh(i);
        }
    }
}
