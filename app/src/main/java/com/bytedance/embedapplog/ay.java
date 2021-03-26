package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

public class ay extends aq {
    public long h;
    public String i;
    public String j;
    public int k;

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return "page";
    }

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer"};
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.j = cursor.getString(4);
        this.i = cursor.getString(5);
        this.h = cursor.getLong(6);
        this.k = cursor.getInt(7);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put("page_key", this.j);
        contentValues.put("refer_page_key", this.i);
        contentValues.put("duration", Long.valueOf(this.h));
        contentValues.put("is_back", Integer.valueOf(this.k));
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        jSONObject.put("page_key", this.j);
        jSONObject.put("refer_page_key", this.i);
        jSONObject.put("duration", this.h);
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("session_id", this.c);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("is_back", this.k);
    }

    @Override // com.bytedance.embedapplog.aq
    protected aq b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0);
        this.b = jSONObject.optLong("tea_event_index", 0);
        this.c = jSONObject.optString("session_id", null);
        this.j = jSONObject.optString("page_key", null);
        this.i = jSONObject.optString("refer_page_key", null);
        this.h = jSONObject.optLong("duration", 0);
        this.k = jSONObject.optInt("is_back", 0);
        return this;
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", k());
        jSONObject.put("datetime", this.g);
        return jSONObject;
    }

    private JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.j);
        jSONObject.put("refer_page_key", this.i);
        jSONObject.put("is_back", this.k);
        return jSONObject;
    }

    public boolean i() {
        return this.h == -1;
    }

    public boolean j() {
        return this.j.contains(":");
    }

    @Override // com.bytedance.embedapplog.aq
    protected String h() {
        return super.h() + " name:" + this.j + " duration:" + this.h;
    }
}
