package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class UnifiedInterstitialAD {
    private UIADI a;
    private boolean b;
    private boolean c;
    private boolean d;
    private AtomicInteger e;
    private AtomicInteger f;
    private volatile UnifiedInterstitialMediaListener g;
    private volatile VideoOption h;
    private volatile int i;
    private volatile int j;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, (Map) null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new AtomicInteger(0);
        this.f = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedInterstitialADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, null);
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new AtomicInteger(0);
        this.f = new AtomicInteger(0);
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedInterstitialADListener, map);
    }

    private void a(final Activity activity, final String str, final String str2, final UnifiedInterstitialADListener unifiedInterstitialADListener, final Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedInterstitialADListener == null) {
            GDTLogger.e(String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedInterstitialADListener));
            return;
        }
        this.b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.c = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            /* class com.qq.e.ads.interstitial2.UnifiedInterstitialAD.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.qq.e.ads.interstitial2.UnifiedInterstitialAD.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        UnifiedInterstitialAD.this.a = pOFactory.getUnifiedInterstitialADDelegate(activity, str, str2, unifiedInterstitialADListener);
                                        UnifiedInterstitialAD.this.d = true;
                                        UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, map, str2);
                                        UnifiedInterstitialAD.this.setVideoOption(UnifiedInterstitialAD.this.h);
                                        UnifiedInterstitialAD.this.setMediaListener(UnifiedInterstitialAD.this.g);
                                        UnifiedInterstitialAD.this.setMinVideoDuration(UnifiedInterstitialAD.this.i);
                                        UnifiedInterstitialAD.this.setMaxVideoDuration(UnifiedInterstitialAD.this.j);
                                        while (UnifiedInterstitialAD.this.e.getAndDecrement() > 0) {
                                            UnifiedInterstitialAD.this.loadAD();
                                        }
                                        while (UnifiedInterstitialAD.this.f.getAndDecrement() > 0) {
                                            UnifiedInterstitialAD.this.loadFullScreenAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    UnifiedInterstitialAD.this.d = true;
                                    throw th;
                                }
                                UnifiedInterstitialAD.this.d = true;
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init UnifiedInterstitialAD plugin", th);
                    }
                } else {
                    GDTLogger.e("Fail to init ADManager");
                }
            }
        });
    }

    static /* synthetic */ void a(UnifiedInterstitialAD unifiedInterstitialAD, Map map, String str) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", new JSONObject(map), str);
            } catch (Exception e2) {
                GDTLogger.e("UnifiedInterstitialAD#setTag Exception");
                e2.printStackTrace();
            }
        }
    }

    public void close() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.close();
        }
    }

    public void destroy() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.destory();
        }
    }

    public String getAdNetWorkName() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            return uiadi.getAdNetWorkName();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            return uiadi.getAdPatternType();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdPatternType");
        return 0;
    }

    public int getECPM() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            return uiadi.getECPM();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPM");
        return -1;
    }

    public String getECPMLevel() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            return uiadi.getECPMLevel();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPMLevel");
        return null;
    }

    public Map getExt() {
        try {
            if (this.a != null) {
                return UIADI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("interstitial2 can not get ext");
            return null;
        }
    }

    public boolean isValid() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            return uiadi.isValid();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call isValid");
        return false;
    }

    public void loadAD() {
        if (!this.b || !this.c) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.d) {
            this.e.incrementAndGet();
        } else {
            UIADI uiadi = this.a;
            if (uiadi != null) {
                uiadi.loadAd();
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public void loadFullScreenAD() {
        if (!this.b || !this.c) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.d) {
            this.f.incrementAndGet();
        } else {
            UIADI uiadi = this.a;
            if (uiadi != null) {
                uiadi.loadFullScreenAD();
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public void setMaxVideoDuration(int i2) {
        this.j = i2;
        if (this.j > 0 && this.i > this.j) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.setMaxVideoDuration(i2);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.g = unifiedInterstitialMediaListener;
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.i = i2;
        if (this.j > 0 && this.i > this.j) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.setMinVideoDuration(i2);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.h = videoOption;
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.setVideoOption(videoOption);
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
    }

    public void show() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.show();
        }
    }

    public void show(Activity activity) {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.show(activity);
        }
    }

    public void showAsPopupWindow() {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow();
        }
    }

    public void showAsPopupWindow(Activity activity) {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow(activity);
        }
    }

    public void showFullScreenAD(Activity activity) {
        UIADI uiadi = this.a;
        if (uiadi != null) {
            uiadi.showFullScreenAD(activity);
        }
    }
}
