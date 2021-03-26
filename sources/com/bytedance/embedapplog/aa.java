package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class aa {
    private static final String[] f = {"channel", "package", "app_version"};
    private boolean a;
    private final Context b;
    private final z c;
    private JSONObject d;
    private final ArrayList<u> e = new ArrayList<>(32);
    private final SharedPreferences g;
    private int h = 0;

    public aa(Context context, z zVar) {
        this.b = context;
        this.c = zVar;
        this.g = zVar.e();
        this.d = new JSONObject();
        bw.a(context);
    }

    public JSONObject a() {
        if (this.a) {
            return r();
        }
        return null;
    }

    public JSONObject b() {
        JSONObject a2 = a();
        if (a2 != null) {
            try {
                String a3 = bw.a(a2.optJSONObject("oaid"));
                if (!TextUtils.isEmpty(a3)) {
                    JSONObject jSONObject = new JSONObject();
                    bp.b(jSONObject, a2);
                    jSONObject.put("oaid", a3);
                    return jSONObject;
                }
            } catch (Exception e2) {
                bo.a(e2);
            }
        }
        return a2;
    }

    public <T> T a(String str, T t) {
        T t2;
        JSONObject r = r();
        if (r == null || (t2 = (T) r.opt(str)) == null) {
            t2 = null;
        }
        return t2 == null ? t : t2;
    }

    private JSONObject r() {
        return this.d;
    }

    public int c() {
        int optInt = this.a ? r().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && optInt == -1; i++) {
            e();
            optInt = this.a ? r().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    public String d() {
        String optString = this.a ? r().optString("app_version", null) : null;
        for (int i = 0; i < 3 && optString == null; i++) {
            e();
            optString = this.a ? r().optString("app_version", null) : null;
        }
        return optString;
    }

    public boolean e() {
        synchronized (this.e) {
            if (this.e.size() == 0) {
                this.e.add(new v());
                this.e.add(new x(this.b));
                this.e.add(new y(this.b, this.c));
                this.e.add(new ab(this.b));
                this.e.add(new ad(this.b));
                this.e.add(new ae(this.b, this.c));
                this.e.add(new af(this.b));
                this.e.add(new ah(this.b));
                this.e.add(new ai(this.b, this.c));
                this.e.add(new aj());
                this.e.add(new ak(this.c));
                this.e.add(new al(this.b));
                this.e.add(new am(this.b));
                this.e.add(new an(this.b, this.c));
                this.e.add(new s(this.b, this.c));
                this.e.add(new ag(this.b, this.c));
                this.e.add(new w(this.b, this.c));
            }
        }
        JSONObject r = r();
        JSONObject jSONObject = new JSONObject();
        bp.b(jSONObject, r);
        Iterator<u> it2 = this.e.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it2.hasNext()) {
            u next = it2.next();
            if (!next.a || next.c || a(next)) {
                try {
                    next.a = next.a(jSONObject);
                } catch (JSONException e2) {
                    bo.a(e2);
                } catch (SecurityException e3) {
                    if (!next.b) {
                        i++;
                        bo.b("loadHeader, " + this.h, e3);
                        if (!next.a && this.h > 10) {
                            next.a = true;
                        }
                    }
                }
                if (!next.a && !next.b) {
                    i2++;
                }
            }
            z &= next.a || next.b;
        }
        if (z) {
            String[] strArr = f;
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(strArr[i3]));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException unused) {
                }
            }
        }
        this.d = jSONObject;
        this.a = z;
        if (bo.b) {
            bo.a("loadHeader, " + this.a + ", " + this.h + ", " + this.d.toString(), null);
        } else {
            bo.d("loadHeader, " + this.a + ", " + this.h, null);
        }
        if (i > 0 && i == i2) {
            this.h++;
            if (o() != 0) {
                this.h += 10;
            }
        }
        if (this.a) {
            AppLog.getDataObserver().onIdLoaded(g(), j(), k());
        }
        return this.a;
    }

    private boolean a(u uVar) {
        boolean z = !this.c.r() && uVar.d;
        if (bo.b) {
            bo.a("needSyncFromSub " + uVar + " " + z, null);
        }
        return z;
    }

    public void a(JSONObject jSONObject) {
        this.c.c(jSONObject);
        b(jSONObject);
    }

    private synchronized void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            bo.b("null abconfig", null);
            return;
        }
        String optString = r().optString("ab_version");
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> keys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                        } catch (JSONException e2) {
                            bo.a(e2);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            b("ab_version", a(hashSet));
        }
    }

    private String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it2 = set.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = r().optJSONObject("custom");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e2) {
                bo.a(e2);
            }
        }
        if (b("custom", jSONObject)) {
            this.c.b(jSONObject);
        }
    }

    public String f() {
        return r().optString("user_unique_id", "");
    }

    public String g() {
        return r().optString("device_id", "");
    }

    public String h() {
        return r().optString("aid", "");
    }

    public String i() {
        return r().optString("udid", "");
    }

    public String j() {
        return r().optString("install_id", "");
    }

    public String k() {
        return r().optString("ssid", "");
    }

    public String l() {
        return r().optString("user_unique_id", "");
    }

    public String m() {
        return r().optString("clientudid", "");
    }

    public String n() {
        return r().optString("openudid", "");
    }

    public void a(String str) {
        if (b("ab_sdk_version", str)) {
            this.c.a(str);
        }
    }

    public void b(String str) {
        if (b("user_agent", str)) {
            this.c.d(str);
        }
    }

    public void c(String str) {
        if (b("user_unique_id", str)) {
            this.c.b(str);
        }
    }

    private boolean b(String str, Object obj) {
        boolean z;
        Object opt = r().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.d;
                    JSONObject jSONObject2 = new JSONObject();
                    bp.b(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.d = jSONObject2;
                } catch (JSONException e2) {
                    bo.a(e2);
                }
            }
            z = true;
        }
        bo.a("updateHeader, " + str + ", " + opt + ", " + obj, null);
        return z;
    }

    static void a(JSONObject jSONObject, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    static boolean d(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            } else if (str.charAt(i) != '0') {
                break;
            } else {
                i++;
            }
        }
        return !z;
    }

    public int o() {
        String optString = r().optString("device_id", "");
        r().optString("install_id", "");
        if (e(optString)) {
            return this.g.getInt("version_code", 0) == r().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long p() {
        return r().optLong("register_time", 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ed A[ADDED_TO_REGION] */
    public boolean a(JSONObject jSONObject, String str, String str2, String str3) {
        JSONException e2;
        boolean z;
        boolean z2;
        if (bo.b) {
            bo.a("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean e3 = e(str);
        boolean e4 = e(str2);
        try {
            boolean e5 = e(str3);
            int i = this.g.getInt("version_code", 0);
            try {
                int optInt = r().optInt("version_code", 0);
                SharedPreferences.Editor edit = this.g.edit();
                if (i != optInt) {
                    edit.putInt("version_code", optInt);
                }
                if (e3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    edit.putLong("register_time", currentTimeMillis);
                    b("register_time", Long.valueOf(currentTimeMillis));
                } else if (!e3) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("response", jSONObject);
                    AppLog.onEventV3("tt_fetch_did_error", jSONObject2);
                }
                String optString = r().optString("device_id", "");
                if (!e3 || !b("device_id", str)) {
                    z = false;
                } else {
                    edit.putString("device_id", str);
                    z = true;
                }
                String optString2 = r().optString("install_id", "");
                if (e4 && b("install_id", str2)) {
                    edit.putString("install_id", str2);
                    z = true;
                }
                String optString3 = r().optString("ssid", "");
                if (!e5 || !b("ssid", str3)) {
                    z2 = z;
                } else {
                    edit.putString("ssid", str3);
                    z2 = true;
                }
                AppLog.getDataObserver().onRemoteIdGet(z2, optString, str, optString2, str2, optString3, str3);
                edit.apply();
            } catch (JSONException e6) {
                e2 = e6;
                bo.a(e2);
                if (!e3) {
                }
            }
        } catch (JSONException e7) {
            e2 = e7;
            bo.a(e2);
            if (!e3) {
            }
        }
        return !e3 && e4;
    }

    public synchronized void f(String str) {
        String optString = r().optString("ab_version");
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split(",");
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    if (bo.b) {
                        bo.a("addExposedVid ready added " + optString, null);
                    }
                    return;
                }
            }
            str = optString + "," + str;
        }
        b("ab_version", str);
        this.c.e(str);
        if (bo.b) {
            bo.a("addExposedVid " + str, null);
        }
    }

    public String q() {
        return r().optString("ab_sdk_version", "");
    }
}
