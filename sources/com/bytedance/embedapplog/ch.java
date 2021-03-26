package com.bytedance.embedapplog;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class ch {
    final String a;
    final String b;
    final Boolean c;
    final Long d;
    final Long e;
    final Integer f;
    final Long g;

    ch(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.a = str;
        this.b = str2;
        this.c = bool;
        this.d = l;
        this.e = l2;
        this.f = num;
        this.g = l3;
    }

    public String toString() {
        return b().toString();
    }

    Map<String, String> a() {
        HashMap hashMap = new HashMap();
        ce.a(hashMap, "id", this.a);
        ce.a(hashMap, "req_id", this.b);
        ce.a(hashMap, "is_track_limited", String.valueOf(this.c));
        ce.a(hashMap, "take_ms", String.valueOf(this.d));
        ce.a(hashMap, "time", String.valueOf(this.e));
        ce.a(hashMap, "query_times", String.valueOf(this.f));
        ce.a(hashMap, "hw_id_version_code", String.valueOf(this.g));
        return hashMap;
    }

    JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        ce.a(jSONObject, "id", this.a);
        ce.a(jSONObject, "req_id", this.b);
        ce.a(jSONObject, "is_track_limited", this.c);
        ce.a(jSONObject, "take_ms", this.d);
        ce.a(jSONObject, "time", this.e);
        ce.a(jSONObject, "query_times", this.f);
        ce.a(jSONObject, "hw_id_version_code", this.g);
        return jSONObject;
    }

    static ch a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new ch(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1)) : null);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
