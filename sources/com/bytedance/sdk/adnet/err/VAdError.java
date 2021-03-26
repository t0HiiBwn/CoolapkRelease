package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.i;

public class VAdError extends Exception {
    private long a;
    public final i networkResponse;

    public VAdError() {
        this.networkResponse = null;
    }

    public VAdError(i iVar) {
        this.networkResponse = iVar;
    }

    public VAdError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VAdError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VAdError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public void setNetworkTimeMs(long j) {
        this.a = j;
    }

    public long getNetworkTimeMs() {
        return this.a;
    }
}
