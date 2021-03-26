package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.constants.LoadAdParams;

public interface NEADI extends ADI {
    void loadAd(int i);

    void loadAd(int i, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i);
}
