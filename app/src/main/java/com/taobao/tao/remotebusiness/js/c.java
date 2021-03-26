package com.taobao.tao.remotebusiness.js;

import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: MtopJSBridge */
final class c implements Runnable {
    private /* synthetic */ int a;
    private /* synthetic */ MtopResponse b;
    private /* synthetic */ Object c;
    private /* synthetic */ MtopJSBridge.a d;

    c(MtopJSBridge.a aVar, int i, MtopResponse mtopResponse, Object obj) {
        this.d = aVar;
        this.a = i;
        this.b = mtopResponse;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.d.a.onError(this.a, this.b, this.c);
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.MtopJSBridge", "do onError callback error.", e);
        }
    }
}
