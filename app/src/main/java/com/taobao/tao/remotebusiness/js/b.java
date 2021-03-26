package com.taobao.tao.remotebusiness.js;

import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: MtopJSBridge */
final class b implements Runnable {
    private /* synthetic */ int a;
    private /* synthetic */ MtopResponse b;
    private /* synthetic */ BaseOutDo c;
    private /* synthetic */ Object d;
    private /* synthetic */ MtopJSBridge.a e;

    b(MtopJSBridge.a aVar, int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        this.e = aVar;
        this.a = i;
        this.b = mtopResponse;
        this.c = baseOutDo;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.e.a.onSuccess(this.a, this.b, this.c, this.d);
        } catch (Exception e2) {
            TBSdkLog.e("mtopsdk.MtopJSBridge", "do onSuccess callback error.", e2);
        }
    }
}
