package com.bytedance.sdk.openadsdk.e.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.e.a.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PermissionConfig */
class u {
    private final Map<String, List<b>> a = new ConcurrentHashMap();
    private final LruCache<String, c> b;
    private final k.a c;
    private final String d;
    private volatile boolean e = false;

    /* compiled from: PermissionConfig */
    static final class c {
        w a = w.PUBLIC;
        Set<String> b = new HashSet();
        Set<String> c = new HashSet();

        c() {
        }
    }

    u(String str, int i, k.a aVar, final Executor executor, JSONObject jSONObject) {
        this.d = str;
        if (i <= 0) {
            this.b = new LruCache<>(16);
        } else {
            this.b = new LruCache<>(i);
        }
        this.c = aVar;
        if (jSONObject == null) {
            aVar.a(d(str), new k.a.AbstractC0051a() {
                /* class com.bytedance.sdk.openadsdk.e.a.u.AnonymousClass1 */
            });
        } else {
            a(jSONObject);
        }
    }

    void a(JSONObject jSONObject) {
        b(jSONObject);
        this.c.a(d(this.d), jSONObject.toString());
    }

    c a(String str, Set<String> set) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        c cVar = new c();
        if (authority == null || authority.isEmpty()) {
            cVar.a = w.PUBLIC;
            return cVar;
        }
        for (String str2 : set) {
            if (!authority.equals(str2)) {
                if (authority.endsWith("." + str2)) {
                }
            }
            cVar.a = w.PRIVATE;
            return cVar;
        }
        c cVar2 = this.b.get(builder);
        if (cVar2 != null) {
            return cVar2;
        }
        return a(builder);
    }

    private void b(JSONObject jSONObject) {
        this.a.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.a.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(c(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e2) {
            i.b("Parse configurations failed, response: " + jSONObject.toString(), e2);
        }
        this.e = true;
    }

    private c a(String str) throws a {
        c cVar = new c();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String b2 = b(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || b2 == null) {
            cVar.a = w.PUBLIC;
            return cVar;
        }
        List<b> c2 = c(b2);
        if (c2 == null) {
            return cVar;
        }
        for (b bVar : c2) {
            if (bVar.a.matcher(str).find()) {
                if (bVar.b.compareTo(cVar.a) >= 0) {
                    cVar.a = bVar.b;
                }
                cVar.b.addAll(bVar.c);
                cVar.c.addAll(bVar.d);
            }
        }
        this.b.put(str, cVar);
        return cVar;
    }

    /* compiled from: PermissionConfig */
    static class a extends IllegalStateException {
        a(String str) {
            super(str);
        }
    }

    private static String b(String str) {
        String[] split;
        int length;
        if (str == null || (length = (split = str.split("[.]")).length) < 2) {
            return null;
        }
        if (length == 2) {
            return str;
        }
        return split[length - 2] + "." + split[length - 1];
    }

    private List<b> c(String str) throws a {
        if (this.e) {
            return this.a.get(str);
        }
        throw new a("Permission config is outdated!");
    }

    private static b c(JSONObject jSONObject) throws JSONException {
        b bVar = new b();
        bVar.a = Pattern.compile(jSONObject.getString("pattern"));
        bVar.b = w.a(jSONObject.getString("group"));
        bVar.c = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                bVar.c.add(optJSONArray.getString(i));
            }
        }
        bVar.d = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                bVar.d.add(optJSONArray2.getString(i2));
            }
        }
        return bVar;
    }

    private static String d(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig." + str;
    }

    /* compiled from: PermissionConfig */
    private static final class b {
        Pattern a;
        w b;
        List<String> c;
        List<String> d;

        private b() {
        }
    }
}
