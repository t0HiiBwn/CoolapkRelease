package com.tencent.imsdk;

public interface TIMUserStatusListener {
    void onForceOffline();

    void onUserSigExpired();
}
