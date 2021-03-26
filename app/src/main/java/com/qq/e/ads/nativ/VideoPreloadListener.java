package com.qq.e.ads.nativ;

public interface VideoPreloadListener {
    void onVideoCacheFailed(int i, String str);

    void onVideoCached();
}
