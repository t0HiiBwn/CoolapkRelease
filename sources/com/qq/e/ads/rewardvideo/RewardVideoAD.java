package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class RewardVideoAD implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;
    private RewardVideoADListener a;
    private volatile boolean b;
    private RVADI c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private String g;
    private boolean h;
    private Map<String, String> i;
    private LoadAdParams j;
    private ServerSideVerificationOptions k;
    private DownloadConfirmListener l;

    public static class ADListenerAdapter implements ADListener {
        public static final int EVENT_TYPE_ON_AD_CLICK = 6;
        public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
        public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
        public static final int EVENT_TYPE_ON_AD_LOADED = 1;
        public static final int EVENT_TYPE_ON_AD_SHOW = 3;
        public static final int EVENT_TYPE_ON_ERROR = 9;
        public static final int EVENT_TYPE_ON_REWARD = 5;
        public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
        public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
        private CacheCallback a;
        public RewardVideoADListener adListener;
        private WeakReference<RewardVideoAD> b;

        interface CacheCallback {
            void onCached();

            void onLoaded();
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener, CacheCallback cacheCallback) {
            this.adListener = rewardVideoADListener;
            this.a = cacheCallback;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                    this.adListener.onADLoad();
                    CacheCallback cacheCallback = this.a;
                    if (cacheCallback != null) {
                        cacheCallback.onLoaded();
                        return;
                    }
                    return;
                case 2:
                    CacheCallback cacheCallback2 = this.a;
                    if (cacheCallback2 != null) {
                        cacheCallback2.onCached();
                    }
                    this.adListener.onVideoCached();
                    return;
                case 3:
                    this.adListener.onADShow();
                    return;
                case 4:
                    this.adListener.onADExpose();
                    return;
                case 5:
                    if (aDEvent.getParas().length > 0 && (aDEvent.getParas()[0] instanceof String)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("transId", aDEvent.getParas()[0]);
                        this.adListener.onReward(hashMap);
                        return;
                    }
                    return;
                case 6:
                    if (this.b != null && aDEvent.getParas().length == 1) {
                        Object obj = aDEvent.getParas()[0];
                        if ((obj instanceof String) && this.b.get() != null) {
                            this.b.get().setExt((String) obj);
                        }
                    }
                    this.adListener.onADClick();
                    return;
                case 7:
                    this.adListener.onVideoComplete();
                    return;
                case 8:
                    this.adListener.onADClose();
                    return;
                case 9:
                    if (aDEvent.getParas().length > 0 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void setBase(RewardVideoAD rewardVideoAD) {
            this.b = new WeakReference<>(rewardVideoAD);
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.i = new HashMap();
        this.j = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, rewardVideoADListener, z);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener) {
        this(context, str, str2, rewardVideoADListener, true);
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.i = new HashMap();
        this.j = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, str2, rewardVideoADListener, z);
    }

    /* access modifiers changed from: private */
    public void a(final int i2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.qq.e.ads.rewardvideo.RewardVideoAD.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (RewardVideoAD.this.a != null) {
                    RewardVideoAD.this.a.onError(AdErrorConvertor.formatErrorCode(i2));
                }
            }
        });
    }

    private void a(final Context context, final String str, final String str2, final RewardVideoADListener rewardVideoADListener, final boolean z) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || rewardVideoADListener == null) {
            GDTLogger.e(String.format("RewardVideoAD Constructor params error, context=%s, appID=%s, posID=%s, rewardVideoADListener=%s", context, str, str2, rewardVideoADListener));
            return;
        }
        this.a = rewardVideoADListener;
        this.d = true;
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(4002);
            return;
        }
        this.e = true;
        this.g = str2;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            /* class com.qq.e.ads.rewardvideo.RewardVideoAD.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.qq.e.ads.rewardvideo.RewardVideoAD.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        ADListenerAdapter aDListenerAdapter = new ADListenerAdapter(rewardVideoADListener, new ADListenerAdapter.CacheCallback() {
                                            /* class com.qq.e.ads.rewardvideo.RewardVideoAD.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                            public void onCached() {
                                                RewardVideoAD.this.h = true;
                                            }

                                            @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                            public void onLoaded() {
                                                RewardVideoAD.this.h = false;
                                            }
                                        });
                                        aDListenerAdapter.setBase(RewardVideoAD.this);
                                        RewardVideoAD.this.c = pOFactory.getRewardVideoADDelegate(context, str, str2, aDListenerAdapter);
                                        RewardVideoAD.this.c.setVolumeOn(z);
                                        RewardVideoAD.this.c.setLoadAdParams(RewardVideoAD.this.j);
                                        RewardVideoAD.this.c.setServerSideVerificationOptions(RewardVideoAD.this.k);
                                        RewardVideoAD.this.b = true;
                                        if (RewardVideoAD.this.f) {
                                            RewardVideoAD.this.loadAD();
                                            return;
                                        }
                                        return;
                                    }
                                    RewardVideoAD.this.a(2001);
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Core", th);
                                    RewardVideoAD.this.a(2001);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init Reward Video AD Core", th);
                    }
                }
                RewardVideoAD.this.a(2001);
            }
        });
    }

    public VideoAdValidity checkValidity() {
        RVADI rvadi;
        return hasShown() ? VideoAdValidity.SHOWED : SystemClock.elapsedRealtime() > getExpireTimestamp() - 1000 ? VideoAdValidity.OVERDUE : (this.h || (rvadi = this.c) == null || rvadi.getRewardAdType() != 0) ? VideoAdValidity.VALID : VideoAdValidity.NONE_CACHE;
    }

    public String getAdNetWorkName() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.getAdNetWorkName();
        }
        GDTLogger.e("please invoke getAdNetWorkName method after callback \"onADLoad\" or the ad does not support \"getAdNetWorkName\" ");
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.getApkInfoUrl();
        }
        return null;
    }

    public int getECPM() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.getECPM();
        }
        GDTLogger.e("please invoke getECPM method after callback \"onADLoad\" ");
        return -1;
    }

    public String getECPMLevel() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.getECPMLevel();
        }
        GDTLogger.e("please invoke getECPMLevel method after callback \"onADLoad\" ");
        return null;
    }

    public long getExpireTimestamp() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.getExpireTimestamp();
        }
        GDTLogger.e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
        return 0;
    }

    public Map<String, String> getExts() {
        return this.i;
    }

    public int getRewardAdType() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.getRewardAdType();
        }
        GDTLogger.e("please invoke getRewardAdType method after callback \"onADLoad\" or the ad does not support \"getRewardAdType\" ");
        return 0;
    }

    public int getVideoDuration() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.getVideoDuration();
        }
        GDTLogger.e("please invoke getVideoDuration method after callback \"onADLoad\" or the ad does not support \"getVideoDuration\" ");
        return 0;
    }

    public boolean hasShown() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            return rvadi.hasShown();
        }
        GDTLogger.e("please invoke hasShown method after callback \"onADLoad\" ");
        return false;
    }

    public void loadAD() {
        if (!this.d || !this.e) {
            GDTLogger.e("AD init Params OR Context error, details in logs produced while init RewardVideoAD");
        } else if (!this.b) {
            this.f = true;
        } else {
            RVADI rvadi = this.c;
            if (rvadi != null) {
                rvadi.loadAD();
            } else {
                GDTLogger.e("RewardVideo AD Init error, see more logs");
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.l;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.l = downloadConfirmListener;
        RVADI rvadi = this.c;
        if (rvadi != null) {
            rvadi.setDownloadConfirmListener(this);
        }
    }

    public void setExt(String str) {
        this.i.put("clickUrl", str);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
        RVADI rvadi = this.c;
        if (rvadi != null) {
            rvadi.setLoadAdParams(loadAdParams);
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.k = serverSideVerificationOptions;
        RVADI rvadi = this.c;
        if (rvadi != null) {
            rvadi.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setTag(Map map) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", new JSONObject(map), this.g);
            } catch (Exception e2) {
                GDTLogger.e("NativeUnifiedAD#setTag Exception");
                e2.printStackTrace();
            }
        }
    }

    public void showAD() {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            rvadi.showAD();
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }

    public void showAD(Activity activity) {
        RVADI rvadi = this.c;
        if (rvadi != null) {
            rvadi.showAD(activity);
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }
}
