package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class aq implements Cloneable {
    private static final SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public long a = System.currentTimeMillis();
    public long b;
    public String c;
    public String d;
    public String e;
    public String f;
    String g;

    public abstract aq a(Cursor cursor);

    protected abstract void a(ContentValues contentValues);

    protected abstract void a(JSONObject jSONObject);

    protected abstract String[] a();

    protected abstract aq b(JSONObject jSONObject);

    protected abstract JSONObject b();

    abstract String d();

    public static String a(long j) {
        return h.format(new Date(j));
    }

    final ContentValues b(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        a(contentValues);
        return contentValues;
    }

    final String c() {
        String[] a2 = a();
        if (a2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(d());
        sb.append("(");
        for (int i = 0; i < a2.length; i += 2) {
            sb.append(a2[i]);
            sb.append(" ");
            sb.append(a2[i + 1]);
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", d());
            a(jSONObject);
        } catch (JSONException e2) {
            bo.a(e2);
        }
        return jSONObject;
    }

    final JSONObject f() {
        try {
            this.g = a(this.a);
            return b();
        } catch (JSONException e2) {
            bo.a(e2);
            return null;
        }
    }

    public static aq a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return as.a.get(jSONObject.optString("k_cls", "")).clone().b(jSONObject);
        } catch (Throwable th) {
            bo.a(th);
            return null;
        }
    }

    /* renamed from: g */
    public aq clone() {
        try {
            return (aq) super.clone();
        } catch (CloneNotSupportedException e2) {
            bo.a(e2);
            return null;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        if (!bo.b) {
            return super.toString();
        }
        String d2 = d();
        if (!getClass().getSimpleName().equalsIgnoreCase(d2)) {
            d2 = d2 + ", " + getClass().getSimpleName();
        }
        String str = this.c;
        String str2 = "-";
        if (str != null) {
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            str2 = str;
        }
        return "{" + d2 + ", " + h() + ", " + str2 + ", " + this.a + "}";
    }

    protected String h() {
        return "sid:" + this.c;
    }
}
