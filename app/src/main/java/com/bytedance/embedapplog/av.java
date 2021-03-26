package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class av extends aq {
    private boolean h;
    private String i;
    protected String p;

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return "eventv3";
    }

    protected void i() {
    }

    public av(String str, boolean z, String str2) {
        this.i = str;
        this.h = z;
        this.p = str2;
    }

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event", "varchar", "params", "varchar", "is_bav", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        boolean z = false;
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.i = cursor.getString(4);
        this.p = cursor.getString(5);
        if (cursor.getInt(6) == 1) {
            z = true;
        }
        this.h = z;
        this.e = cursor.getString(7);
        this.f = cursor.getString(8);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put("event", this.i);
        if (this.h && this.p == null) {
            try {
                i();
            } catch (JSONException e) {
                bo.a(e);
            }
        }
        contentValues.put("params", this.p);
        contentValues.put("is_bav", Integer.valueOf(this.h ? 1 : 0));
        contentValues.put("ab_version", this.e);
        contentValues.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("user_unique_id", this.d);
        jSONObject.put("event", this.i);
        if (this.h && this.p == null) {
            i();
        }
        jSONObject.put("params", this.p);
        jSONObject.put("is_bav", this.h);
        jSONObject.put("ab_version", this.e);
        jSONObject.put("ab_sdk_version", this.f);
    }

    @Override // com.bytedance.embedapplog.aq
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            jSONObject.put("user_unique_id", this.d);
        }
        jSONObject.put("event", this.i);
        if (this.h) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.p)) {
            jSONObject.put("params", new JSONObject(this.p));
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
        this.d = jSONObject.optString("user_unique_id", null);
        this.i = jSONObject.optString("event", null);
        this.p = jSONObject.optString("params", null);
        this.h = jSONObject.optBoolean("is_bav", false);
        this.e = jSONObject.optString("ab_version", null);
        this.f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected String h() {
        return this.i;
    }

    public String j() {
        return this.i;
    }
}
