package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;
import java.util.List;

public abstract class BaseNativeUnifiedAd {
    public static final int CALLBACK_CLICK = 3;
    public static final int CALLBACK_IMPRESSION = 4;
    public static final int CALLBACK_LOADED = 1;
    public static final int CALLBACK_NO_AD = 2;
    public static final int DEFAULT_PRIORITY = -1;

    public BaseNativeUnifiedAd(Context context, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract void loadData(int i);

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setBrowserType(int i);

    public abstract void setCategories(List<String> list);

    public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    public abstract void setMaxVideoDuration(int i);

    public abstract void setMinVideoDuration(int i);
}
