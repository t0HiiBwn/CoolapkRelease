package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.a;
import com.bytedance.sdk.openadsdk.h.d;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LibNetwork */
public class c implements g {
    private final WeakReference<Context> a;

    public c(Context context) {
        this.a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.g
    public void a(String str, String str2, final Map<String, Object> map, p pVar) {
        str.hashCode();
        int i = (str.equals("GET") || !str.equals("POST")) ? 0 : 1;
        i a2 = i.a();
        new j(i, str2, a2) {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.c.AnonymousClass1 */

            @Override // com.bytedance.sdk.adnet.core.Request
            protected Map<String, String> c() throws a {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
                return hashMap;
            }
        }.build(d.a(com.bytedance.sdk.openadsdk.core.p.a()).d());
        m<String> mVar = null;
        try {
            mVar = a2.get();
        } catch (Throwable unused) {
        }
        a(mVar, pVar);
    }

    @Override // com.ss.android.a.a.a.g
    public void a(String str, final byte[] bArr, final String str2, int i, p pVar) {
        m<String> mVar;
        i a2 = i.a();
        new j(1, str, a2) {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.c.AnonymousClass2 */

            @Override // com.bytedance.sdk.adnet.core.Request
            public byte[] getBody() throws a {
                return bArr;
            }

            @Override // com.bytedance.sdk.adnet.core.Request
            public String getBodyContentType() {
                return str2;
            }
        }.build(d.a(com.bytedance.sdk.openadsdk.core.p.a()).d());
        try {
            mVar = a2.get();
        } catch (Throwable unused) {
            mVar = null;
        }
        a(mVar, pVar);
    }

    private void a(m<String> mVar, p pVar) {
        if (mVar == null || !mVar.a()) {
            boolean isEmpty = true ^ TextUtils.isEmpty(mVar != null && mVar.c != null ? mVar.c.getMessage() : null);
            if (pVar != null) {
                pVar.a(new Exception(isEmpty ? mVar.c.getMessage() : mVar != null ? String.valueOf(mVar.h) : ""));
            }
        } else if (pVar != null) {
            pVar.a((String) mVar.a);
        }
    }
}
