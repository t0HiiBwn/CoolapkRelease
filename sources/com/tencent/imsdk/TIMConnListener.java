package com.tencent.imsdk;

public interface TIMConnListener {
    void onConnected();

    void onDisconnected(int i, String str);

    void onWifiNeedAuth(String str);
}
