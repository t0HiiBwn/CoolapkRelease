package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;

public interface RVADI2 extends ApkDownloadComplianceInterface {
    void destroy();

    String getECPMLevel();

    long getExpireTimestamp();

    int getVideoDuration();

    boolean hasShown();

    boolean isVideoCached();

    void loadAD();

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVolumeOn(boolean z);

    void showAD(Activity activity);
}
