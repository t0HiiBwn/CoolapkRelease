package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONArray;
import org.json.JSONObject;

public class ax extends aq {
    public byte[] h;
    int i;
    public int j;
    private JSONArray k;
    private JSONArray l;
    private aw m;
    private JSONArray n;
    private ba o;
    private JSONObject p;
    private JSONArray q;

    @Override // com.bytedance.embedapplog.aq
    String d() {
        return "pack";
    }

    void a(long j2, JSONObject jSONObject, aw awVar, ba baVar, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        this.a = j2;
        this.p = jSONObject;
        this.m = awVar;
        this.o = baVar;
        this.n = jSONArray;
        this.k = jSONArray2;
        this.l = jSONArray3;
        this.q = jSONArray4;
    }

    @Override // com.bytedance.embedapplog.aq
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "_data", "blob", "_fail", "integer", "_full", "integer"};
    }

    @Override // com.bytedance.embedapplog.aq
    public aq a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.h = cursor.getBlob(1);
        this.i = cursor.getInt(2);
        this.p = null;
        this.m = null;
        this.o = null;
        this.n = null;
        this.k = null;
        this.l = null;
        this.q = null;
        return this;
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", AppLog.toEncryptByte(f().toString()));
    }

    @Override // com.bytedance.embedapplog.aq
    protected void a(JSONObject jSONObject) {
        bo.a(null);
    }

    @Override // com.bytedance.embedapplog.aq
    protected JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.p);
        jSONObject.put("time_sync", ao.a);
        if (this.m != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.m.f());
            jSONObject.put("launch", jSONArray);
        }
        ba baVar = this.o;
        int i2 = 0;
        if (baVar != null) {
            JSONObject f = baVar.f();
            JSONArray jSONArray2 = this.n;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            for (int i3 = 0; i3 < length; i3++) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.n.optString(i3)).optString("params"));
                jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
            }
            if (length > 0) {
                f.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(f);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.k;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.k);
        }
        JSONArray jSONArray7 = this.n;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        if (this.l == null) {
            this.l = this.n;
        } else if (length3 > 0) {
            for (int i4 = 0; i4 < length3; i4++) {
                this.l.put(this.n.get(i4));
            }
        }
        JSONArray jSONArray8 = this.l;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.l);
        }
        JSONArray jSONArray9 = this.q;
        if (jSONArray9 != null) {
            i2 = jSONArray9.length();
        }
        if (i2 > 0) {
            jSONObject.put("log_data", this.q);
        }
        StringBuilder sb = new StringBuilder("wP {");
        Object obj = this.m;
        if (obj == null) {
            obj = "la";
        }
        sb.append(obj);
        sb.append(", ");
        Object obj2 = this.o;
        if (obj2 == null) {
            obj2 = "te";
        }
        sb.append(obj2);
        sb.append(", p: ");
        sb.append(length3);
        sb.append(", v1: ");
        sb.append(length2);
        sb.append(", v3: ");
        sb.append(length4);
        sb.append("}");
        sb.append(", m: ");
        sb.append(i2);
        sb.append("}");
        bo.d(sb.toString(), null);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.aq
    protected aq b(JSONObject jSONObject) {
        bo.a(null);
        return null;
    }
}
