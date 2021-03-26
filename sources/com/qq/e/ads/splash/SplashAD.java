package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONObject;

public final class SplashAD {
    public static final int EVENT_TYPE_AD_CLICKED = 4;
    public static final int EVENT_TYPE_AD_DISMISSED = 1;
    public static final int EVENT_TYPE_AD_EXPOSURE = 6;
    public static final int EVENT_TYPE_AD_LOADED = 7;
    public static final int EVENT_TYPE_AD_PRESENT = 3;
    public static final int EVENT_TYPE_AD_TICK = 5;
    public static final int EVENT_TYPE_AD_ZOOM_OUT = 8;
    public static final int EVENT_TYPE_AD_ZOOM_OUT_PLAY_FINISH = 9;
    public static final int EVENT_TYPE_NO_AD = 2;
    private volatile NSPVI a;
    private volatile ViewGroup b;
    private volatile SplashADListener c;
    private volatile LoadAdParams d;
    private volatile boolean e;
    private volatile boolean f;
    private int g;
    private int h;
    private volatile View i;

    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (SplashAD.this.c == null) {
                GDTLogger.e("SplashADListener == null");
                return;
            }
            Object[] paras = aDEvent.getParas();
            switch (aDEvent.getType()) {
                case 1:
                    SplashAD.this.c.onADDismissed();
                    return;
                case 2:
                    if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                        GDTLogger.e("Splash onNoAD event get params error.");
                        return;
                    } else {
                        SplashAD.this.c.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                        return;
                    }
                case 3:
                    SplashAD.this.c.onADPresent();
                    return;
                case 4:
                    SplashAD.this.c.onADClicked();
                    return;
                case 5:
                    if (paras.length != 1 || !(paras[0] instanceof Long)) {
                        GDTLogger.e("Splash onADTick event get param error.");
                        return;
                    } else {
                        SplashAD.this.c.onADTick(((Long) paras[0]).longValue());
                        return;
                    }
                case 6:
                    SplashAD.this.c.onADExposure();
                    return;
                case 7:
                    if (paras.length != 1 || !(paras[0] instanceof Long)) {
                        GDTLogger.e("Splash onADLoaded event get param error.");
                        return;
                    } else {
                        SplashAD.this.c.onADLoaded(((Long) paras[0]).longValue());
                        return;
                    }
                case 8:
                    if (SplashAD.this.c instanceof SplashADZoomOutListener) {
                        ((SplashADZoomOutListener) SplashAD.this.c).onZoomOut();
                        return;
                    }
                    return;
                case 9:
                    if (SplashAD.this.c instanceof SplashADZoomOutListener) {
                        ((SplashADZoomOutListener) SplashAD.this.c).onZoomOutPlayFinish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2) {
        this(context, view, str, splashADListener, i2, (View) null);
    }

    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2, View view2) {
        this(context, view, str, splashADListener, i2, (Map) null, view2);
    }

    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i2, Map map, View view2) {
        this.e = false;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, view, GDTADManager.getInstance().getAppStatus().getAPPID(), str, splashADListener, i2, map, view2);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(splashADListener, 2003);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2) {
        this(context, view, str, str2, splashADListener, i2, (View) null);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, View view2) {
        this(context, view, str, str2, splashADListener, i2, null, view2);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i2, Map map, View view2) {
        this.e = false;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, view, str, str2, splashADListener, i2, map, view2);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2) {
        this(context, (View) null, str, splashADListener, i2);
    }

    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener) {
        this(context, str, str2, splashADListener, 0);
    }

    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener, int i2) {
        this(context, (View) null, str, str2, splashADListener, i2);
    }

    private void a(final Context context, final View view, final String str, final String str2, final SplashADListener splashADListener, final int i2, final Map map, final View view2) {
        this.c = splashADListener;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", str, str2, context));
            a(splashADListener, 2001);
        } else if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(splashADListener, 4002);
        } else {
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
                /* class com.qq.e.ads.splash.SplashAD.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.qq.e.ads.splash.SplashAD.AnonymousClass1.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            SplashAD.this.a = pOFactory.getNativeSplashAdView(context, str, str2);
                                            if (SplashAD.this.a != null) {
                                                if (SplashAD.this.d != null) {
                                                    SplashAD.this.a.setLoadAdParams(SplashAD.this.d);
                                                }
                                                SplashAD.a(SplashAD.this, map, str2);
                                                SplashAD.this.a.setFetchDelay(i2);
                                                SplashAD.this.a.setAdListener(new ADListenerAdapter(SplashAD.this, (byte) 0));
                                                SplashAD.this.a.setSkipView(view);
                                                SplashAD.this.a.setFloatView(view2);
                                                SplashAD.this.a.setAdLogoMargin(SplashAD.this.g, SplashAD.this.h);
                                                SplashAD.this.a.setPreloadView(SplashAD.this.i);
                                                if ((splashADListener instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) splashADListener).isSupportZoomOut()) {
                                                    SplashAD.this.a.setSupportZoomOut(true);
                                                }
                                                if (SplashAD.this.b != null) {
                                                    SplashAD.this.fetchAndShowIn(SplashAD.this.b);
                                                }
                                                if (SplashAD.this.e) {
                                                    SplashAD.this.a.preload();
                                                    SplashAD.this.e = false;
                                                }
                                                if (SplashAD.this.f) {
                                                    SplashAD.this.a.fetchAdOnly();
                                                    SplashAD.this.f = false;
                                                    return;
                                                }
                                                return;
                                            }
                                            GDTLogger.e("SplashAdView created by factory return null");
                                            SplashAD.this.a(splashADListener, 200103);
                                            return;
                                        }
                                        GDTLogger.e("factory return null");
                                        SplashAD.this.a(splashADListener, 200103);
                                    } catch (Throwable th) {
                                        GDTLogger.e("Unknown Exception", th);
                                        SplashAD.this.a(splashADListener, 6000);
                                    }
                                }
                            });
                        } catch (c e2) {
                            GDTLogger.e("Fail to init splash plugin", e2);
                            SplashAD.this.a(splashADListener, 200102);
                        } catch (Throwable th) {
                            GDTLogger.e("Unknown Exception", th);
                            SplashAD.this.a(splashADListener, 6000);
                        }
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(SplashAD splashAD, Map map, String str) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", new JSONObject(map), str);
            } catch (Exception e2) {
                GDTLogger.e("SplashAD#setTag Exception");
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final SplashADListener splashADListener, final int i2) {
        if (splashADListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.qq.e.ads.splash.SplashAD.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    splashADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
                }
            });
        }
    }

    public final void fetchAdOnly() {
        if (this.a != null) {
            GDTLogger.e("splashAD fetchAdOnly");
            this.a.fetchAdOnly();
            return;
        }
        this.f = true;
    }

    public final void fetchAndShowIn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("SplashAD fetchAndShowIn params null ");
            a(this.c, 2001);
        } else if (this.a != null) {
            this.a.fetchAndShowIn(viewGroup);
        } else {
            this.b = viewGroup;
        }
    }

    public final String getAdNetWorkName() {
        if (this.a != null) {
            return this.a.getAdNetWorkName();
        }
        GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    public final String getECPMLevel() {
        if (this.a != null) {
            return this.a.getECPMLevel();
        }
        GDTLogger.e("The ad does not support \"getECPMLevel\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    public final Map getExt() {
        try {
            return NSPVI.ext;
        } catch (Exception e2) {
            GDTLogger.e("splash ad can not get extra");
            e2.printStackTrace();
            return null;
        }
    }

    public final Bitmap getZoomOutBitmap() {
        if (this.a != null) {
            return this.a.getZoomOutBitmap();
        }
        return null;
    }

    public final void preLoad() {
        if (this.a != null) {
            this.a.preload();
        } else {
            this.e = true;
        }
    }

    public final void setAdLogoMargin(int i2, int i3) {
        this.g = i2;
        this.h = i3;
    }

    public final void setLoadAdParams(LoadAdParams loadAdParams) {
        if (this.a != null) {
            this.a.setLoadAdParams(loadAdParams);
        } else {
            this.d = loadAdParams;
        }
    }

    public final void setPreloadView(View view) {
        if (this.a != null) {
            this.a.setPreloadView(view);
        } else {
            this.i = view;
        }
    }

    public final void showAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("SplashAD showAd params null ");
            a(this.c, 2001);
        } else if (this.a != null) {
            this.a.showAd(viewGroup);
        } else {
            this.b = viewGroup;
        }
    }

    public final void zoomOutAnimationFinish() {
        if (this.a != null) {
            this.a.zoomOutAnimationFinish();
        }
    }
}
