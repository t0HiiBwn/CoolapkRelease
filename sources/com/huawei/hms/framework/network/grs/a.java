package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.b;
import com.huawei.hms.framework.network.grs.b.d;
import com.huawei.hms.framework.network.grs.b.h;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static final String a = "a";
    private GrsBaseInfo b;
    private com.huawei.hms.framework.network.grs.a.a c;
    private h d;

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a aVar, h hVar) {
        this.b = grsBaseInfo;
        this.c = aVar;
        this.d = hVar;
    }

    public static CountryCodeBean a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    private String a(String str, String str2, b bVar, Context context) {
        String a2 = this.c.a(this.b, str, str2, bVar, context);
        if (TextUtils.isEmpty(a2)) {
            return com.huawei.hms.framework.network.grs.local.b.a(context.getPackageName()).a(this.b, str, str2);
        }
        Logger.i(a, "get url from sp is not empty.");
        return a2;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).getJSONObject(str2).getString(str3);
        } catch (JSONException e) {
            Logger.w(a, "Method{getServiceNameUrl} query url from SP occur an JSONException", e);
            return "";
        }
    }

    public static Map<String, Map<String, String>> a(String str) {
        HashMap hashMap = new HashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(a, "isSpExpire jsonValue is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, a(jSONObject.getJSONObject(obj)));
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.w(a, "getServicesUrlsMap occur a JSONException", e);
            return hashMap;
        }
    }

    private Map<String, String> a(String str, b bVar, Context context) {
        Map<String, String> a2 = this.c.a(this.b, str, bVar, context);
        return (a2 == null || a2.isEmpty()) ? com.huawei.hms.framework.network.grs.local.b.a(context.getPackageName()).a(this.b, str) : a2;
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.v(a, "isSpExpire jsonValue is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(str2);
            if (jSONObject == null) {
                Logger.v(a, "getServiceNameUrls jsObject null.");
                return hashMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.w(a, "Method{getServiceNameUrls} query url from SP occur an JSONException", e);
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.w(a, "getServiceUrls occur a JSONException", e);
            return hashMap;
        }
    }

    private void a(final String str, final Map<String, String> map, final IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        this.d.a(this.b, context, new b() {
            /* class com.huawei.hms.framework.network.grs.a.AnonymousClass2 */

            @Override // com.huawei.hms.framework.network.grs.b
            public void a() {
                Map map = map;
                if (map == null || map.isEmpty()) {
                    iQueryUrlsCallBack.onCallBackFail(-3);
                } else {
                    iQueryUrlsCallBack.onCallBackSuccess(map);
                }
            }

            @Override // com.huawei.hms.framework.network.grs.b
            public void a(d dVar) {
                Map<String, String> a2 = a.a(dVar.c(), str);
                if (a2 == null || a2.isEmpty()) {
                    Map map = map;
                    if (map == null || map.isEmpty()) {
                        iQueryUrlsCallBack.onCallBackFail(-5);
                    } else {
                        iQueryUrlsCallBack.onCallBackSuccess(map);
                    }
                } else {
                    iQueryUrlsCallBack.onCallBackSuccess(a2);
                }
            }
        }, str);
    }

    public String a(Context context, String str) {
        d a2 = this.d.a(this.b, context, str);
        return a2 == null ? "" : a2.c();
    }

    public String a(String str, String str2, Context context) {
        b bVar = new b();
        String a2 = a(str, str2, bVar, context);
        if (bVar.a()) {
            Logger.v(a, "get unexpired cache localUrl{%s}", a2);
            return a2;
        }
        String a3 = a(a(context, str), str, str2);
        if (TextUtils.isEmpty(a3)) {
            return a2;
        }
        Logger.i(a, "get url is from remote server");
        return a3;
    }

    public Map<String, String> a(String str, Context context) {
        Map<String, String> a2;
        b bVar = new b();
        Map<String, String> a3 = a(str, bVar, context);
        return (!bVar.a() && (a2 = a(a(context, str), str)) != null && !a2.isEmpty()) ? a2 : a3;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        b bVar = new b();
        Map<String, String> a2 = a(str, bVar, context);
        if (!bVar.a()) {
            a(str, a2, iQueryUrlsCallBack, context);
        } else if (a2 == null || a2.isEmpty()) {
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            iQueryUrlsCallBack.onCallBackSuccess(a2);
        }
    }

    public void a(final String str, final String str2, final IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        b bVar = new b();
        final String a2 = a(str, str2, bVar, context);
        if (!bVar.a()) {
            this.d.a(this.b, context, new b() {
                /* class com.huawei.hms.framework.network.grs.a.AnonymousClass1 */

                @Override // com.huawei.hms.framework.network.grs.b
                public void a() {
                    if (!TextUtils.isEmpty(a2)) {
                        iQueryUrlCallBack.onCallBackSuccess(a2);
                    } else {
                        iQueryUrlCallBack.onCallBackFail(-3);
                    }
                }

                @Override // com.huawei.hms.framework.network.grs.b
                public void a(d dVar) {
                    String a2 = a.a(dVar.c(), str, str2);
                    if (!TextUtils.isEmpty(a2)) {
                        iQueryUrlCallBack.onCallBackSuccess(a2);
                    } else if (!TextUtils.isEmpty(a2)) {
                        iQueryUrlCallBack.onCallBackSuccess(a2);
                    } else {
                        iQueryUrlCallBack.onCallBackFail(-5);
                    }
                }
            }, str);
        } else if (TextUtils.isEmpty(a2)) {
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            iQueryUrlCallBack.onCallBackSuccess(a2);
        }
    }
}
