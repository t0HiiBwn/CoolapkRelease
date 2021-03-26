package com.bytedance.sdk.openadsdk.i.e;

import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.IOException;

/* compiled from: NetworkSoureVolleyImpl */
public class d implements b {
    private IHttpStack a;

    public d() {
        IHttpStack a2 = com.bytedance.sdk.openadsdk.h.d.a();
        this.a = a2;
        if (a2 == null) {
            this.a = new j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.b
    public a a(f fVar) throws IOException, VAdError {
        e eVar = new e(fVar.a, fVar.b);
        if (fVar.c != -1) {
            eVar.setRetryPolicy(new e().a((int) fVar.c));
        }
        return new g(this.a.performRequest(eVar, fVar.e), fVar);
    }
}
