package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

public interface RVADI {
    String getAdNetWorkName();

    int getECPM();

    String getECPMLevel();

    long getExpireTimestamp();

    int getRewardAdType();

    int getVideoDuration();

    boolean hasShown();

    void loadAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVolumeOn(boolean z);

    void showAD();

    void showAD(Activity activity);
}
