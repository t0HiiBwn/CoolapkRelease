package com.qq.e.ads.dfa;

import com.qq.e.comm.util.AdError;

public interface IGDTApkListener {
    void onApkLoad(GDTApk gDTApk);

    void onError(AdError adError);
}
