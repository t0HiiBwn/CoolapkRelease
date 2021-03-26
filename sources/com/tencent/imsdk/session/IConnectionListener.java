package com.tencent.imsdk.session;

public interface IConnectionListener {
    void onConnectFailed(int i, String str);

    void onConnected();

    void onConnecting();

    void onDisconnected(int i, String str);

    void onWifiNeedAuth(String str);
}
