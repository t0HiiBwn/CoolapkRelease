package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class NativeExpressAD extends AbstractAD<NEADI> {
    public static final int EVENT_TYPE_AD_WILL_OPEN_OVERLAY = 20;
    public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSED = 7;
    public static final int EVENT_TYPE_ON_AD_CLOSE_OVERLAY = 10;
    public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
    public static final int EVENT_TYPE_ON_AD_LEFT_APPLICATION = 8;
    public static final int EVENT_TYPE_ON_AD_LOADED = 2;
    public static final int EVENT_TYPE_ON_AD_OPEN_OVERLAY = 9;
    public static final int EVENT_TYPE_ON_NO_AD = 1;
    public static final int EVENT_TYPE_ON_RENDER_FAILED = 3;
    public static final int EVENT_TYPE_ON_RENDER_SUCCESS = 4;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 21;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 16;
    public static final int EVENT_TYPE_ON_VIDEO_ERROR = 17;
    public static final int EVENT_TYPE_ON_VIDEO_INIT = 11;
    public static final int EVENT_TYPE_ON_VIDEO_LOADING = 12;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_CLOSE = 19;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_OPEN = 18;
    public static final int EVENT_TYPE_ON_VIDEO_PAUSE = 15;
    public static final int EVENT_TYPE_ON_VIDEO_READY = 13;
    public static final int EVENT_TYPE_ON_VIDEO_START = 14;
    private volatile int a;
    private volatile int b;
    private List<Integer> c = Collections.synchronizedList(new ArrayList());
    private VideoOption d;
    private ADSize e;
    private NativeExpressADListener f;
    private String g;
    private LoadAdParams h;

    public static class ADListenerAdapter implements ADListener {
        private NativeExpressADListener a;
        private NativeExpressMediaListener b;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    NativeExpressAD.a(this.a, aDEvent);
                    return;
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                    NativeExpressAD.a(this.b, aDEvent);
                    return;
                case 20:
                default:
                    return;
            }
        }
    }

    public interface NativeExpressADListener extends AbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onADOpenOverlay(NativeExpressADView nativeExpressADView);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, aDSize, GDTADManager.getInstance().getAppStatus().getAPPID(), str, nativeExpressADListener);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(nativeExpressADListener, 2003);
    }

    @Deprecated
    public NativeExpressAD(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, aDSize, str, str2, nativeExpressADListener);
    }

    private void a(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || aDSize == null || context == null) {
            GDTLogger.e(String.format("NativeExpressAD Constructor params error, adSize=%s, appid=%s, posId=%s, context=%s", aDSize, str, str2, context));
            a(nativeExpressADListener, 2001);
            return;
        }
        this.e = aDSize;
        this.f = nativeExpressADListener;
        this.g = str2;
        a(context, str, str2, nativeExpressADListener);
    }

    static /* synthetic */ void a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener == null) {
            GDTLogger.i("No DevADListener Bound");
            return;
        }
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                    GDTLogger.e("AdEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                return;
            case 2:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof List)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onADLoaded((List) aDEvent.getParas()[0]);
                return;
            case 3:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 4:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 5:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 6:
                if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParas()[0];
                nativeExpressADListener.onADClicked(nativeExpressADView);
                if (aDEvent.getParas()[1] instanceof String) {
                    nativeExpressADView.ext.put("clickUrl", (String) aDEvent.getParas()[1]);
                    return;
                }
                return;
            case 7:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                ((NativeExpressADView) aDEvent.getParas()[0]).negativeFeedback();
                return;
            case 8:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 9:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 10:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressADListener.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        if (nativeExpressMediaListener == null) {
            GDTLogger.i("No media listener");
            return;
        }
        switch (aDEvent.getType()) {
            case 11:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoInit((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 12:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoLoading((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 13:
                if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView) || !(aDEvent.getParas()[1] instanceof Integer)) {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                } else {
                    nativeExpressMediaListener.onVideoReady((NativeExpressADView) aDEvent.getParas()[0], (long) ((Integer) aDEvent.getParas()[1]).intValue());
                    return;
                }
            case 14:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoStart((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 15:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoPause((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 16:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoComplete((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 17:
                if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView) || !(aDEvent.getParas()[1] instanceof Integer)) {
                    GDTLogger.e("Native express media event paras error!");
                    return;
                } else {
                    nativeExpressMediaListener.onVideoError((NativeExpressADView) aDEvent.getParas()[0], AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                }
            case 18:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoPageOpen((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 19:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoPageClose((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 20:
            default:
                return;
            case 21:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                    return;
                }
                nativeExpressMediaListener.onVideoCached((NativeExpressADView) aDEvent.getParas()[0]);
                return;
        }
    }

    /* Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NEADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate(context, this.e, str, str2, new ADListenerAdapter(this.f));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NEADI neadi) {
        NEADI neadi2 = neadi;
        neadi2.setMinVideoDuration(this.a);
        neadi2.setMaxVideoDuration(this.b);
        VideoOption videoOption = this.d;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.c) {
            for (Integer num : this.c) {
                loadAD(num.intValue());
            }
        }
    }

    public void loadAD(int i) {
        loadAD(i, null);
    }

    public void loadAD(int i, LoadAdParams loadAdParams) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
            return;
        }
        if (loadAdParams != null) {
            setAdParams(loadAdParams);
        }
        if (!b()) {
            synchronized (this.c) {
                this.c.add(Integer.valueOf(i));
            }
            return;
        }
        NEADI neadi = (NEADI) a();
        if (neadi != null) {
            LoadAdParams loadAdParams2 = this.h;
            if (loadAdParams2 != null) {
                neadi.loadAd(i, loadAdParams2);
            } else {
                neadi.loadAd(i);
            }
        } else {
            GDTLogger.e("Native Express AD Init error, see more logs");
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        String passThroughInfoJsonString;
        this.h = loadAdParams;
        if (loadAdParams != null && (passThroughInfoJsonString = loadAdParams.getPassThroughInfoJsonString()) != null && passThroughInfoJsonString.getBytes().length >= 512) {
            GDTLogger.e("NativeExpressAD setAdParams too large ,current size: " + loadAdParams.toString().getBytes().length);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.b = i;
        if (this.b > 0 && this.a > this.b) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        NEADI neadi = (NEADI) a();
        if (neadi != null) {
            neadi.setMaxVideoDuration(this.b);
        }
    }

    public void setMinVideoDuration(int i) {
        this.a = i;
        if (this.b > 0 && this.a > this.b) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        NEADI neadi = (NEADI) a();
        if (neadi != null) {
            neadi.setMinVideoDuration(this.a);
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

    public void setVideoOption(VideoOption videoOption) {
        this.d = videoOption;
        NEADI neadi = (NEADI) a();
        if (neadi != null && videoOption != null) {
            neadi.setVideoOption(videoOption);
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i) {
    }
}
