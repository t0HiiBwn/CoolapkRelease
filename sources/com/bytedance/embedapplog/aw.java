package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class aw extends aq {
    public int h;
    public String i;
    boolean j;
    volatile boolean k;

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return "launch";
    }

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "ver_name", "varchar", "ver_code", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.i = cursor.getString(3);
        this.h = cursor.getInt(4);
        this.e = cursor.getString(5);
        this.f = cursor.getString(6);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.c);
        contentValues.put("ver_name", this.i);
        contentValues.put("ver_code", Integer.valueOf(this.h));
        contentValues.put("ab_version", this.e);
        contentValues.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("ab_version", this.e);
        jSONObject.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.aq
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        boolean z = this.j;
        if (z) {
            jSONObject.put("is_background", z);
        }
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
        this.e = jSONObject.optString("ab_version", null);
        this.f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }
}
