package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushSelfShowMessage */
public class o {
    private String A = "";
    private int B;
    private String C = "";
    private String D;
    private String E = "";
    private String a = "";
    private int b;
    private String c;
    private String d;
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q = "";
    private String r;
    private String s;
    private int t = r.STYLE_DEFAULT.ordinal();
    private String u = "";
    private String v = "";
    private String w = "";
    private int x = 0;
    private int y = 0;
    private String z;

    public o(byte[] bArr, byte[] bArr2) {
        this.r = new String(bArr, ab.a);
        this.s = new String(bArr2, ab.a);
    }

    public String a() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.e);
        return this.e;
    }

    public boolean b() {
        try {
            if (TextUtils.isEmpty(this.r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.r);
            a(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject("msgContent");
            if (jSONObject2 == null) {
                HMSLog.i("PushSelfShowLog", "msgObj == null");
                return false;
            } else if (!b(jSONObject2)) {
                return false;
            } else {
                this.f = jSONObject2.optString("dispPkgName");
                c(jSONObject2);
                this.B = jSONObject2.optInt("notifyId", -1);
                this.C = jSONObject2.optString("data");
                return d(jSONObject2);
            }
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e2) {
            HMSLog.d("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    private void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("group");
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.a);
        this.x = jSONObject.optInt("autoCancel", 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.x);
        this.y = jSONObject.optInt("visibility", 0);
        this.z = jSONObject.optString("when");
        this.A = jSONObject.optString("tag");
    }

    private boolean b(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("msgId")) {
            Object obj = jSONObject.get("msgId");
            if (obj instanceof String) {
                this.e = (String) obj;
                return true;
            } else if (!(obj instanceof Integer)) {
                return true;
            } else {
                this.e = String.valueOf(((Integer) obj).intValue());
                return true;
            }
        } else {
            HMSLog.i("PushSelfShowLog", "msgId == null");
            return false;
        }
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append("0");
            }
            sb.append(string);
            this.d = sb.toString();
        }
    }

    private boolean d(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (!jSONObject.has("psContent") || (jSONObject2 = jSONObject.getJSONObject("psContent")) == null) {
            return false;
        }
        this.g = jSONObject2.getString("cmd");
        this.h = jSONObject2.optString("content");
        this.i = jSONObject2.optString("notifyIcon");
        this.j = jSONObject2.optString("notifyTitle");
        this.k = jSONObject2.optString("notifySummary");
        this.D = jSONObject2.optString("ticker");
        if ((!jSONObject2.has("notifyDetail") || k(jSONObject2)) && jSONObject2.has("param")) {
            return e(jSONObject2);
        }
        return false;
    }

    private boolean e(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("param");
            if (jSONObject2.has("autoClear")) {
                this.b = jSONObject2.getInt("autoClear");
            } else {
                this.b = 0;
            }
            if (!"app".equals(this.g)) {
                if (!"cosa".equals(this.g)) {
                    if ("url".equals(this.g)) {
                        g(jSONObject2);
                        return true;
                    } else if (!"rp".equals(this.g)) {
                        return true;
                    } else {
                        h(jSONObject2);
                        return true;
                    }
                }
            }
            f(jSONObject2);
            return true;
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", e2);
            return false;
        }
    }

    private boolean f(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("acn")) {
            this.m = jSONObject.getString("acn");
        }
        if (jSONObject.has("intentUri")) {
            this.c = jSONObject.getString("intentUri");
        }
        if (jSONObject.has("appPackageName")) {
            this.l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean g(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.n = jSONObject.getString("url");
            if (jSONObject.has("appPackageName")) {
                this.l = jSONObject.getString("appPackageName");
            }
            if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
                return true;
            }
            this.o = jSONObject.getString("rpl");
            this.p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    private boolean h(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.o = jSONObject.getString("rpl");
        this.p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.q = jSONObject.getString("rpct");
        return true;
    }

    public byte[] c() {
        try {
            return i(a(j(z()), y())).toString().getBytes(ab.a);
        } catch (JSONException e2) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e2);
            return new byte[0];
        }
    }

    private JSONObject i(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("msgContent", jSONObject);
        jSONObject2.put("group", this.a);
        jSONObject2.put("tag", this.A);
        jSONObject2.put("autoCancel", this.x);
        jSONObject2.put("visibility", this.y);
        jSONObject2.put("when", this.z);
        return jSONObject2;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f);
        jSONObject3.put("msgId", this.e);
        jSONObject3.put("ap", this.d);
        jSONObject3.put("notifyId", this.B);
        jSONObject3.put("psContent", jSONObject);
        jSONObject3.put("notifyDetail", jSONObject2);
        jSONObject3.put("ticker", this.D);
        jSONObject3.put("data", this.C);
        return jSONObject3;
    }

    private JSONObject j(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cmd", this.g);
        jSONObject2.put("content", this.h);
        jSONObject2.put("notifyIcon", this.i);
        jSONObject2.put("notifyTitle", this.j);
        jSONObject2.put("notifySummary", this.k);
        jSONObject2.put("param", jSONObject);
        return jSONObject2;
    }

    private JSONObject y() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.t);
        jSONObject.put("bigTitle", this.u);
        jSONObject.put("bigContent", this.v);
        jSONObject.put("bigPic", this.w);
        return jSONObject;
    }

    private JSONObject z() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.b);
        jSONObject.put("url", this.n);
        jSONObject.put("rpl", this.o);
        jSONObject.put("rpt", this.p);
        jSONObject.put("rpct", this.q);
        jSONObject.put("appPackageName", this.l);
        jSONObject.put("acn", this.m);
        jSONObject.put("intentUri", this.c);
        return jSONObject;
    }

    private boolean k(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("notifyDetail");
            if (jSONObject2 == null) {
                return false;
            }
            if (jSONObject2.has("style")) {
                this.t = jSONObject2.getInt("style");
            }
            this.u = jSONObject2.optString("bigTitle");
            this.v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e2) {
            HMSLog.i("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    public byte[] d() {
        return this.s.getBytes(ab.a);
    }

    public String e() {
        return this.a;
    }

    public int f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.f;
    }

    public String j() {
        return this.g;
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.j;
    }

    public String m() {
        return this.l;
    }

    public String n() {
        return this.m;
    }

    public int o() {
        return this.t;
    }

    public String p() {
        return this.k;
    }

    public String q() {
        return this.u;
    }

    public String r() {
        return this.v;
    }

    public int s() {
        return this.x;
    }

    public String t() {
        return this.A;
    }

    public int u() {
        return this.B;
    }

    public void a(int i2) {
        this.B = i2;
    }

    public String v() {
        return this.D;
    }

    public String w() {
        if (this.x == 1) {
            return a();
        }
        return String.valueOf(System.currentTimeMillis());
    }

    public String x() {
        return this.E;
    }
}
