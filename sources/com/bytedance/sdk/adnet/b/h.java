package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.b;
import com.bytedance.sdk.adnet.err.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* compiled from: JsonStringRequest */
public class h extends g<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(int i, String str, JSONObject jSONObject, m.a<String> aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    protected m<String> a(i iVar) {
        try {
            return m.a(new String(iVar.b, b.a(iVar.c, "utf-8")), b.a(iVar));
        } catch (UnsupportedEncodingException e) {
            return m.a(new e(e));
        }
    }
}
