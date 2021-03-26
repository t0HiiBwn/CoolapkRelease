package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class at extends aq {
    private String h;
    private String i;
    private String j;
    private String k;

    /* renamed from: l  reason: collision with root package name */
    private long f1257l;
    private long m;

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return "event";
    }

    public at(String str, String str2, String str3, long j2, long j3, String str4) {
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.f1257l = j2;
        this.m = j3;
        this.k = str4;
    }

    at() {
    }

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "category", "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", "label", "varchar", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.h = cursor.getString(4);
        this.i = cursor.getString(5);
        this.f1257l = (long) cursor.getInt(6);
        this.m = (long) cursor.getInt(7);
        this.k = cursor.getString(8);
        this.j = cursor.getString(9);
        this.e = cursor.getString(10);
        this.f = cursor.getString(11);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put("category", this.h);
        contentValues.put("tag", this.i);
        contentValues.put("value", Long.valueOf(this.f1257l));
        contentValues.put("ext_value", Long.valueOf(this.m));
        contentValues.put("params", this.k);
        contentValues.put("label", this.j);
        contentValues.put("ab_version", this.e);
        contentValues.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("user_unique_id", this.d);
        jSONObject.put("category", this.h);
        jSONObject.put("tag", this.i);
        jSONObject.put("value", this.f1257l);
        jSONObject.put("ext_value", this.m);
        jSONObject.put("params", this.k);
        jSONObject.put("label", this.j);
        jSONObject.put("ab_version", this.e);
        jSONObject.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.aq
    protected JSONObject b() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.k) ? new JSONObject(this.k) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            jSONObject.put("user_unique_id", this.d);
        }
        jSONObject.put("category", this.h);
        jSONObject.put("tag", this.i);
        jSONObject.put("value", this.f1257l);
        jSONObject.put("ext_value", this.m);
        jSONObject.put("label", this.j);
        jSONObject.put("datetime", this.g);
        if (!TextUtils.isEmpty(this.e)) {
            jSONObject.put("ab_version", this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("ab_sdk_version", this.f);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.aq
    protected aq b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0);
        this.b = jSONObject.optLong("tea_event_index", 0);
        this.c = jSONObject.optString("session_id", null);
        this.d = jSONObject.optString("user_unique_id", null);
        this.h = jSONObject.optString("category", null);
        this.i = jSONObject.optString("tag", null);
        this.f1257l = jSONObject.optLong("value", 0);
        this.m = jSONObject.optLong("ext_value", 0);
        this.k = jSONObject.optString("params", null);
        this.j = jSONObject.optString("label", null);
        this.e = jSONObject.optString("ab_version", null);
        this.f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected String h() {
        return "" + this.i + ", " + this.j;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }
}
