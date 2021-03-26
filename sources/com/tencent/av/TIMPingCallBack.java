package com.tencent.av;

import java.util.List;

public interface TIMPingCallBack {
    void onError(int i, String str);

    void onFinish();

    void onProgress(ServerInfo serverInfo, int i, int i2);

    void onStart(List<ServerInfo> list);

    void onSuccess(PingResult pingResult);
}
