package com.tencent.imsdk;

public enum TIMGroupReceiveMessageOpt {
    ReceiveAndNotify(0),
    NotReceive(1),
    ReceiveNotNotify(2);
    
    private long opt;

    private TIMGroupReceiveMessageOpt(long j) {
        this.opt = j;
    }

    public long getValue() {
        return this.opt;
    }
}
