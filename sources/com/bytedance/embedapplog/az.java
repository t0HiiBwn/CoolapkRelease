package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONObject;

public class az extends aq {
    static String h = "succEvent";
    public int i;
    private String j;
    private int k;
    private String l;
    private int m;
    private long n;

    az() {
    }

    public az(String str, String str2, int i2) {
        this.k = 1;
        this.i = AppLog.getSuccRate();
        this.j = str;
        this.l = str2;
        this.m = i2;
        this.n = bn.a();
    }

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event_name", "varchar", "is_monitor", "integer", "bav_monitor_rate", "integer", "monitor_status", "varchar", "monitor_num", "integer", "date", "integer"};
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getString(2);
        this.d = cursor.getString(3);
        this.j = cursor.getString(4);
        this.k = cursor.getInt(5);
        this.i = cursor.getInt(6);
        this.l = cursor.getString(7);
        this.m = cursor.getInt(8);
        this.n = cursor.getLong(9);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.c);
        contentValues.put("user_unique_id", this.d);
        contentValues.put("event_name", this.j);
        contentValues.put("is_monitor", Integer.valueOf(this.k));
        contentValues.put("bav_monitor_rate", Integer.valueOf(this.i));
        contentValues.put("monitor_status", this.l);
        contentValues.put("monitor_num", Integer.valueOf(this.m));
        contentValues.put("date", Long.valueOf(this.n));
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.c);
        jSONObject.put("user_unique_id", this.d);
        jSONObject.put("event_name", this.j);
        jSONObject.put("is_monitor", this.k);
        jSONObject.put("bav_monitor_rate", this.i);
        jSONObject.put("monitor_status", this.l);
        jSONObject.put("monitor_num", this.m);
        jSONObject.put("date", this.n);
    }

    @Override // com.bytedance.embedapplog.aq
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event_name", this.j);
        jSONObject.put("is_monitor", this.k);
        jSONObject.put("bav_monitor_rate", this.i);
        jSONObject.put("monitor_status", this.l);
        jSONObject.put("monitor_num", this.m);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.aq
    protected aq b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0);
        this.b = jSONObject.optLong("tea_event_index", 0);
        this.c = jSONObject.optString("session_id", null);
        this.d = jSONObject.optString("user_unique_id", null);
        this.j = jSONObject.optString("event_name", null);
        this.k = jSONObject.optInt("is_monitor", 0);
        this.i = jSONObject.optInt("bav_monitor_rate", 0);
        this.l = jSONObject.optString("monitor_status", null);
        this.m = jSONObject.optInt("monitor_num", 0);
        this.n = jSONObject.optLong("date", 0);
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return h;
    }
}
