package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.b;
import com.bytedance.sdk.adnet.err.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonObjectRequest */
public class f extends g<JSONObject> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(int i, String str, JSONObject jSONObject, m.a<JSONObject> aVar) {
        this(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    public f(int i, String str, String str2, m.a<JSONObject> aVar) {
        super(i, str, str2, aVar);
    }

    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    protected m<JSONObject> a(i iVar) {
        try {
            return m.a(new JSONObject(new String(iVar.b, b.a(iVar.c, "utf-8"))), b.a(iVar));
        } catch (UnsupportedEncodingException e) {
            return m.a(new e(e));
        } catch (JSONException e2) {
            return m.a(new e(e2));
        }
    }
}
