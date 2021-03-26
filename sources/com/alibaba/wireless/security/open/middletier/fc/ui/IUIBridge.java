package com.alibaba.wireless.security.open.middletier.fc.ui;

import java.util.HashMap;

public interface IUIBridge {
    public static final int UI_CANCEL = 4;
    public static final int UI_FAIL = 2;
    public static final int UI_SUCCESS = 1;
    public static final int UI_TIMEOUT = 8;

    void addUIItem(long j, Object obj);

    void clearTimeoutItem(long j);

    void removeUIItem(long j);

    void sendUIResult(long j, int i, HashMap hashMap);
}
