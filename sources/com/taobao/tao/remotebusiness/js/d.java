package com.taobao.tao.remotebusiness.js;

import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: MtopJSBridge */
final class d implements Runnable {
    private /* synthetic */ int a;
    private /* synthetic */ MtopResponse b;
    private /* synthetic */ Object c;
    private /* synthetic */ MtopJSBridge.a d;

    d(MtopJSBridge.a aVar, int i, MtopResponse mtopResponse, Object obj) {
        this.d = aVar;
        this.a = i;
        this.b = mtopResponse;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.d.a.onSystemError(this.a, this.b, this.c);
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.MtopJSBridge", "do onSystemError callback error.", e);
        }
    }
}
