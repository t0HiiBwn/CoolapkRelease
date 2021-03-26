package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

public interface UBVI extends ApkDownloadComplianceInterface {
    public static final Map<String, String> ext = new HashMap();

    void destroy();

    void fetchAd();

    void onWindowFocusChanged(boolean z);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setRefresh(int i);
}
