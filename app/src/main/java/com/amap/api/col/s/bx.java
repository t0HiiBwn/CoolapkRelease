package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.bm;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetReuestParam */
public final class bx {
    private static final String a = bs.c("SRFZHZUVZT3BOa0ZiemZRQQ");
    private static final String b = bs.c("FbGJzX3Nkaw");
    private static final String c = bs.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final String d = bs.c("FQU5EU0RLMTA");
    private static final String e = bs.c("FMTAw");
    private static boolean f = false;
    private String g = "";

    public static bm.a a() {
        return new bm.a() {
            /* class com.amap.api.col.s.bx.AnonymousClass1 */
            private bx a = new bx();

            @Override // com.amap.api.col.s.bm.a
            public final cy a(byte[] bArr, Map<String, String> map) {
                return new cr(bArr, map);
            }

            @Override // com.amap.api.col.s.bm.a
            public final String a() {
                return bx.c();
            }

            @Override // com.amap.api.col.s.bm.a
            public final String a(Context context, String str) {
                return bx.a(context, str);
            }

            @Override // com.amap.api.col.s.bm.a
            public final Map<String, String> b() {
                return this.a.b();
            }

            @Override // com.amap.api.col.s.bm.a
            public final String a(String str, String str2, String str3, String str4) {
                return this.a.a(str, str2, str3, str4);
            }
        };
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(bs.c("UY29kZQ")) != 1) {
                return "";
            }
            String optString = new JSONObject(jSONObject.optString(bs.c("FZGF0YQ"))).optString(bs.c("FYWRpdQ"));
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            by.a(optString);
            bt.a(context).a(optString);
            return optString;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final synchronized Map<String, String> b() {
        if (f) {
            return null;
        }
        f = true;
        HashMap hashMap = new HashMap();
        hashMap.put(bs.c("FZW50"), bs.c("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(bs.c("SY2hhbm5lbD0"));
        String str = b;
        sb.append(str);
        sb.append(bs.c("SJmRpdj0"));
        String str2 = d;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(bs.c("FQA"));
        stringBuffer.append(c);
        String a2 = ca.a(stringBuffer.toString());
        sb.append(bs.c("FJnNpZ249"));
        sb.append(a2.toUpperCase(Locale.US));
        sb.append(bs.c("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(bs.c("FaW4"), bv.a(cb.a(sb.toString().getBytes(), a.getBytes())));
        hashMap.put(bs.c("Sa2V5dA"), e);
        return hashMap;
    }

    private String d() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        String a2 = bn.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < a2.length(); i++) {
            stringBuffer.append((char) (a2.charAt(i) - (i % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer2.length() / 2; i2++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i2) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i2)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.g = stringBuffer4;
        return stringBuffer4;
    }

    public final String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bs.c("LdGlk"), str);
            jSONObject.put(bs.c("FZGl1"), str2);
            jSONObject.put(bs.c("AZGl1Mg"), str3);
            jSONObject.put(bs.c("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String a2 = ca.a();
        if (!TextUtils.isEmpty(a2)) {
            String a3 = bv.a(cb.a((jSONObject2 + "\u0000").getBytes(), a2.getBytes()));
            if (!TextUtils.isEmpty(a3)) {
                try {
                    String a4 = bv.a(bz.a(a2.getBytes("utf-8"), bz.a(d())));
                    return bs.c("Fa2V5PQ") + URLEncoder.encode(a4) + bs.c("SJmRhdGE9") + URLEncoder.encode(a3);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String c() {
        return by.a();
    }
}
