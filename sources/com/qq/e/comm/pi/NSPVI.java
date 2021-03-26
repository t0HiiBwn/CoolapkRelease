package com.qq.e.comm.pi;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

public interface NSPVI extends ApkDownloadComplianceInterface {
    public static final Map<String, String> ext = new HashMap();

    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    String getECPMLevel();

    Bitmap getZoomOutBitmap();

    void preload();

    void setAdListener(ADListener aDListener);

    void setAdLogoMargin(int i, int i2);

    void setFetchDelay(int i);

    void setFloatView(View view);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setPreloadView(View view);

    void setSkipView(View view);

    void setSupportZoomOut(boolean z);

    void showAd(ViewGroup viewGroup);

    void zoomOutAnimationFinish();
}
