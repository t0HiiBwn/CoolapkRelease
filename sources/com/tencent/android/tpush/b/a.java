package com.tencent.android.tpush.b;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Md5;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class a {
    protected JSONObject a = null;
    protected String b = null;
    protected String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;

    public abstract int b();

    protected abstract void c();

    protected a(String str) {
        this.b = str;
    }

    public void a() {
        String optString;
        try {
            this.a = new JSONObject(this.b);
        } catch (Throwable unused) {
            try {
                this.a = new JSONObject(this.b.substring(1));
            } catch (Throwable unused2) {
                try {
                    this.a = new JSONObject(this.b.substring(2));
                } catch (Throwable unused3) {
                    try {
                        this.a = new JSONObject(this.b.substring(3));
                    } catch (Throwable unused4) {
                        TLogger.d("BaseMessageHolder", "unexpected for decode");
                    }
                }
            }
        }
        try {
            if (!this.a.isNull("title")) {
                this.d = this.a.getString("title");
            }
            if (!this.a.isNull("content")) {
                this.e = this.a.getString("content");
            }
            if (!this.a.isNull("custom_content") && (optString = this.a.optString("custom_content", "")) != null && !optString.trim().equals("{}")) {
                this.f = optString;
            }
            if (!this.a.isNull("accept_time")) {
                this.g = this.a.optString("accept_time", "");
            }
        } catch (Throwable unused5) {
            TLogger.d("BaseMessageHolder", "unexpected for decode");
        }
        c();
        this.c = Md5.md5(this.b).toUpperCase();
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        return "BaseMessageHolder [msgJson=" + this.a + ", msgJsonStr=" + this.b + ", title=" + this.d + ", content=" + this.e + ", customContent=" + this.f + ", acceptTime=" + this.g + "]";
    }
}
