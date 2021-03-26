package com.alibaba.alibclinkpartner.smartlink;

import android.content.Context;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;

final class d implements Runnable {
    final /* synthetic */ Context a;

    d(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALSLConfigration.updateSmartLinkData(this.a, ALSLContext.instance().appkey);
    }
}
