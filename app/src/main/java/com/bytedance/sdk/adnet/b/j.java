package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.b;
import java.io.UnsupportedEncodingException;

/* compiled from: StringRequest */
public class j extends Request<String> {
    private final Object c = new Object();
    private m.a<String> d;

    public j(int i, String str, m.a<String> aVar) {
        super(i, str, aVar);
        this.d = aVar;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<String> mVar) {
        m.a<String> aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected m<String> a(i iVar) {
        String str;
        try {
            str = new String(iVar.b, b.a(iVar.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(iVar.b);
        }
        return m.a(str, b.a(iVar));
    }
}
