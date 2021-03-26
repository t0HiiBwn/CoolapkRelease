package com.qq.e.ads.nativ.express2;

public interface AdEventListener {
    public static final int EVENT_CLICK = 101;
    public static final int EVENT_CLOSE = 105;
    public static final int EVENT_IMPRESSION = 102;
    public static final int EVENT_RENDER_FAIL = 104;
    public static final int EVENT_RENDER_SUCCESS = 103;

    void onAdClosed();

    void onClick();

    void onExposed();

    void onRenderFail();

    void onRenderSuccess();
}
