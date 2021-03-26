package com.ss.android.socialbase.downloader.g;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.i.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DownloadSetting */
public class a {
    private static final g<Integer, a> a = new g<>(16, 16);
    private static final a b = new a(null);
    private static JSONObject c;
    private static JSONObject d;
    private static Boolean e;
    private static boolean f;
    private static a g;
    private final JSONObject h;
    private final JSONObject i;
    private final Boolean j;
    private int k;

    static {
        a();
    }

    public static void a() {
        JSONObject E = b.E();
        boolean z = false;
        f = E.optInt("disable_task_setting", 0) == 1;
        c = E.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = E.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            if (optJSONObject.optInt("default", 0) == 1) {
                z = true;
            }
            bool = Boolean.valueOf(z);
        }
        d = optJSONObject;
        e = bool;
    }

    private a(JSONObject jSONObject) {
        Boolean bool;
        this.h = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || f("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !f("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            jSONObject2 = optJSONObject;
            bool = bool2;
        }
        this.i = jSONObject2;
        this.j = bool;
    }

    public static JSONObject b() {
        return b.E();
    }

    public static void a(String str, boolean z) {
        try {
            if (d == null) {
                d = new JSONObject();
            }
            d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static a c() {
        return b;
    }

    public static a a(int i2) {
        return a(i2, (DownloadInfo) null);
    }

    public static a a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    private static a a(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = g;
        if (aVar2 != null && aVar2.k == i2) {
            return aVar2;
        }
        g<Integer, a> gVar = a;
        synchronized (gVar) {
            aVar = (a) gVar.get(Integer.valueOf(i2));
        }
        if (aVar == null) {
            aVar = downloadInfo == null ? c(i2) : b(downloadInfo);
            synchronized (gVar) {
                gVar.put(Integer.valueOf(i2), aVar);
            }
        }
        aVar.k = i2;
        g = aVar;
        return aVar;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(String str, boolean z) {
        if (this.i != null && !f(str)) {
            if (!this.i.has(str)) {
                Boolean bool = this.j;
                if (bool != null) {
                    return bool.booleanValue();
                }
            } else if (this.i.optInt(str, z) == 1) {
                return true;
            } else {
                return false;
            }
        }
        JSONObject jSONObject = d;
        if (jSONObject != null) {
            if (!jSONObject.has(str)) {
                Boolean bool2 = e;
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
            } else if (d.optInt(str, z ? 1 : 0) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return z;
    }

    public int b(String str) {
        return a(str, 0);
    }

    public int a(String str, int i2) {
        JSONObject jSONObject = this.h;
        if (jSONObject == null || !jSONObject.has(str) || f(str)) {
            return b().optInt(str, i2);
        }
        return this.h.optInt(str, i2);
    }

    public long a(String str, long j2) {
        JSONObject jSONObject = this.h;
        if (jSONObject == null || !jSONObject.has(str) || f(str)) {
            return b().optLong(str, j2);
        }
        return this.h.optLong(str, j2);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.h;
        if (jSONObject == null || !jSONObject.has(str) || f(str)) {
            return b().optDouble(str, d2);
        }
        return this.h.optDouble(str, d2);
    }

    public String c(String str) {
        return a(str, "");
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.h;
        if (jSONObject == null || !jSONObject.has(str) || f(str)) {
            return b().optString(str, str2);
        }
        return this.h.optString(str, str2);
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.h;
        if (jSONObject == null || !jSONObject.has(str) || f(str)) {
            return b().optJSONObject(str);
        }
        return this.h.optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.h;
        if (jSONObject == null || !jSONObject.has(str) || f(str)) {
            return b().optJSONArray(str);
        }
        return this.h.optJSONArray(str);
    }

    public static boolean f(String str) {
        JSONObject jSONObject = c;
        if (jSONObject == null || jSONObject.optInt(str, 0) != 1) {
            return false;
        }
        return true;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f) {
            return b;
        }
        a aVar = g;
        if (aVar != null && aVar.h == jSONObject) {
            return aVar;
        }
        g<Integer, a> gVar = a;
        synchronized (gVar) {
            for (V v : gVar.values()) {
                if (((a) v).h == jSONObject) {
                    g = v;
                    return v;
                }
            }
            a aVar2 = new a(jSONObject);
            g = aVar2;
            return aVar2;
        }
    }

    public static void a(int i2, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f) {
            g<Integer, a> gVar = a;
            synchronized (gVar) {
                a aVar = g;
                if (aVar == null || aVar.h != jSONObject) {
                    aVar = null;
                    Iterator<V> it2 = gVar.values().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        V next = it2.next();
                        if (((a) next).h == jSONObject) {
                            ((a) next).k = i2;
                            aVar = next;
                            break;
                        }
                    }
                    if (aVar == null) {
                        aVar = new a(jSONObject);
                        aVar.k = i2;
                    }
                    g = aVar;
                } else {
                    aVar.k = i2;
                }
                a.put(Integer.valueOf(i2), aVar);
            }
        }
    }

    public static void b(int i2) {
        a aVar = g;
        if (aVar != null && aVar.k == i2) {
            g = null;
        }
        g<Integer, a> gVar = a;
        synchronized (gVar) {
            gVar.remove(Integer.valueOf(i2));
        }
    }

    private static a c(int i2) {
        DownloadInfo downloadInfo;
        if (f) {
            return b;
        }
        Context L = b.L();
        if (L == null || (downloadInfo = Downloader.getInstance(L).getDownloadInfo(i2)) == null) {
            return b;
        }
        return b(downloadInfo);
    }

    private static a b(DownloadInfo downloadInfo) {
        if (f) {
            return b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }
}
