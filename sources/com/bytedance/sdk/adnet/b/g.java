package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import java.io.UnsupportedEncodingException;

/* compiled from: JsonRequest */
public abstract class g<T> extends Request<T> {
    private static final String c = String.format("application/json; charset=%s", "utf-8");
    private final Object d = new Object();
    private m.a<T> e;
    private final String f;

    @Override // com.bytedance.sdk.adnet.core.Request
    protected abstract m<T> a(i iVar);

    public g(int i, String str, String str2, m.a<T> aVar) {
        super(i, str, aVar);
        this.e = aVar;
        this.f = str2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.d) {
            this.e = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<T> mVar) {
        m.a<T> aVar;
        synchronized (this.d) {
            aVar = this.e;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            String str = this.f;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            o.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f, "utf-8");
            return null;
        }
    }
}
