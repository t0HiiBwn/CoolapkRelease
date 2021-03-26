package com.alibaba.baichuan.trade.common.messagebus;

public abstract class AlibcMessageListener {
    public int eventId;
    public boolean isRunOnUIThread;

    protected AlibcMessageListener(int i, boolean z) {
        this.isRunOnUIThread = z;
        this.eventId = i;
    }

    public abstract void onMessageEvent(int i, Object obj);
}
