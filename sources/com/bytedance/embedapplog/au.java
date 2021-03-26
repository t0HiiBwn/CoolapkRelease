package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

public class au extends aq {
    private String h;
    private String i;

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return "event_misc";
    }

    public au(String str, JSONObject jSONObject) {
        this.i = str;
        this.h = jSONObject.toString();
    }

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "params", "varchar", "log_type", "varchar"};
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.h = cursor.getString(4);
        this.i = cursor.getString(5);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put("params", this.h);
        contentValues.put("log_type", this.i);
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("user_unique_id", this.d);
        jSONObject.put("params", this.h);
        jSONObject.put("log_type", this.i);
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
        jSONObject.put("log_type", this.i);
        try {
            JSONObject jSONObject2 = new JSONObject(this.h);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    bo.b("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            bo.c("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.aq
    protected aq b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0);
        this.b = jSONObject.optLong("tea_event_index", 0);
        this.c = jSONObject.optString("session_id", null);
        this.d = jSONObject.optString("user_unique_id", null);
        this.h = jSONObject.optString("params", null);
        this.i = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected String h() {
        return "param:" + this.h + " logType:" + this.i;
    }
}
