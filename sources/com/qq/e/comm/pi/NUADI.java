package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

public interface NUADI extends ADI {
    String getAdNetWorkName();

    void loadData(int i);

    void loadData(int i, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVastClassName(String str);

    @Deprecated
    void setVideoADContainerRender(int i);

    @Deprecated
    void setVideoPlayPolicy(int i);
}
