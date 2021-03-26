package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class ba extends aq {
    public long h;
    long i;

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return null;
    }

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        bo.a(null);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        bo.a(null);
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        bo.a(null);
    }

    @Override // com.bytedance.embedapplog.aq
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("stop_timestamp", this.i);
        jSONObject.put("duration", this.h / 1000);
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
        bo.a(null);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected String h() {
        return super.h() + " duration:" + this.h;
    }
}
