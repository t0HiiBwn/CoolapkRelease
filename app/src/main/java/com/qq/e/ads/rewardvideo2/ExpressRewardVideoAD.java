package com.qq.e.ads.rewardvideo2;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;

public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> {
    public static final int EVENT_AD_LOAD = 100;
    public static final int EVENT_CLICK = 105;
    public static final int EVENT_CLOSE = 106;
    public static final int EVENT_COMPLETE = 108;
    public static final int EVENT_ERROR = 107;
    public static final int EVENT_EXPOSE = 103;
    public static final int EVENT_REWARD = 104;
    public static final int EVENT_SHOW = 102;
    public static final int EVENT_VIDEO_CACHED = 101;
    private RVADI2 a;
    private boolean b;
    private boolean c = true;
    private ServerSideVerificationOptions d;
    private ExpressRewardVideoAdListener e;

    private static class AdListenerAdapter implements ADListener {
        private ExpressRewardVideoAdListener a;

        AdListenerAdapter(ExpressRewardVideoAdListener expressRewardVideoAdListener) {
            this.a = expressRewardVideoAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.a != null && aDEvent != null) {
                switch (aDEvent.getType()) {
                    case 100:
                        this.a.onAdLoaded();
                        return;
                    case 101:
                        this.a.onVideoCached();
                        return;
                    case 102:
                        this.a.onShow();
                        return;
                    case 103:
                        this.a.onExpose();
                        return;
                    case 104:
                        if (aDEvent.getParas().length > 0 && (aDEvent.getParas()[0] instanceof String)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("transId", aDEvent.getParas()[0]);
                            this.a.onReward(hashMap);
                            return;
                        }
                        return;
                    case 105:
                        this.a.onClick();
                        return;
                    case 106:
                        this.a.onClose();
                        return;
                    case 107:
                        if (aDEvent.getParas().length > 0 && (aDEvent.getParas()[0] instanceof Integer)) {
                            this.a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                            return;
                        }
                        return;
                    case 108:
                        this.a.onVideoComplete();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public ExpressRewardVideoAD(Context context, String str, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this.e = expressRewardVideoAdListener;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(2003);
    }

    public ExpressRewardVideoAD(Context context, String str, String str2, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this.e = expressRewardVideoAdListener;
        a(context, str, str2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.qq.e.ads.LiteAbstractAD
    protected final /* synthetic */ RVADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getExpressRewardVideoADDelegate(context, str, str2, new AdListenerAdapter(this.e));
    }

    @Override // com.qq.e.ads.LiteAbstractAD
    protected final void a(int i) {
        ExpressRewardVideoAdListener expressRewardVideoAdListener = this.e;
        if (expressRewardVideoAdListener != null) {
            expressRewardVideoAdListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.qq.e.ads.LiteAbstractAD
    protected final /* synthetic */ void a(RVADI2 rvadi2) {
        RVADI2 rvadi22 = rvadi2;
        this.a = rvadi22;
        rvadi22.setVolumeOn(this.c);
        this.a.setServerSideVerificationOptions(this.d);
        if (this.b) {
            this.a.loadAD();
            this.b = false;
        }
    }

    public VideoAdValidity checkValidity() {
        boolean z;
        if (hasShown()) {
            return VideoAdValidity.SHOWED;
        }
        if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
            return VideoAdValidity.OVERDUE;
        }
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            z = rvadi2.isVideoCached();
        } else {
            GDTLogger.w("don't call isVideoCached before loading AD success");
            z = false;
        }
        return !z ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
    }

    public void destroy() {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            rvadi2.destroy();
        }
    }

    public String getECPMLevel() {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            return rvadi2.getECPMLevel();
        }
        GDTLogger.w("don't call getECPMLevel before loading AD success");
        return null;
    }

    public long getExpireTimestamp() {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            return rvadi2.getExpireTimestamp();
        }
        GDTLogger.w("don't call getExpireTimestamp before loading AD success");
        return 0;
    }

    public int getVideoDuration() {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            return rvadi2.getVideoDuration();
        }
        GDTLogger.w("don't call getVideoDuration before loading AD success");
        return 0;
    }

    public boolean hasShown() {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            return rvadi2.hasShown();
        }
        GDTLogger.w("don't call hasShown before loading AD success");
        return false;
    }

    public void loadAD() {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            rvadi2.loadAD();
        } else {
            this.b = true;
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            rvadi2.setServerSideVerificationOptions(serverSideVerificationOptions);
        } else {
            this.d = serverSideVerificationOptions;
        }
    }

    public void setVolumeOn(boolean z) {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            rvadi2.setVolumeOn(z);
        } else {
            this.c = z;
        }
    }

    public void showAD(Activity activity) {
        RVADI2 rvadi2 = this.a;
        if (rvadi2 != null) {
            rvadi2.showAD(activity);
        } else {
            GDTLogger.w("don't call showAD before loading AD success");
        }
    }
}
