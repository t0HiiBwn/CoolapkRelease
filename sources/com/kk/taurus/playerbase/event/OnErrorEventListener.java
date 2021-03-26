package com.kk.taurus.playerbase.event;

import android.os.Bundle;

public interface OnErrorEventListener {
    public static final int ERROR_EVENT_COMMON = -88011;
    public static final int ERROR_EVENT_DATA_PROVIDER_ERROR = -88000;
    public static final int ERROR_EVENT_IO = -88015;
    public static final int ERROR_EVENT_MALFORMED = -88016;
    public static final int ERROR_EVENT_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = -88014;
    public static final int ERROR_EVENT_SERVER_DIED = -88013;
    public static final int ERROR_EVENT_TIMED_OUT = -88018;
    public static final int ERROR_EVENT_UNKNOWN = -88012;
    public static final int ERROR_EVENT_UNSUPPORTED = -88017;

    void onErrorEvent(int i, Bundle bundle);
}
