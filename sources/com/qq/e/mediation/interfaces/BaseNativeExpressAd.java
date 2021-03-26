package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

public abstract class BaseNativeExpressAd {
    public static final int DEFAULT_PRIORITY = -1;
    public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
    public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
    public static final int EVENT_TYPE_ON_AD_LOADED = 2;
    public static final int EVENT_TYPE_ON_NO_AD = 1;

    public BaseNativeExpressAd(Context context, ADSize aDSize, String str, String str2) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract void loadAD(int i);

    public abstract void loadAD(int i, LoadAdParams loadAdParams);

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setMaxVideoDuration(int i);

    public abstract void setMinVideoDuration(int i);

    public abstract void setVideoOption(VideoOption videoOption);

    public abstract void setVideoPlayPolicy(int i);
}
