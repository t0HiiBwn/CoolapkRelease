package com.bytedance.tea.crash.upload;

import org.json.JSONObject;

/* compiled from: Response */
public class f {
    private final int a;
    private String b;
    private JSONObject c;

    public f(int i) {
        this.a = i;
    }

    public f(int i, Throwable th) {
        this.a = i;
        if (th != null) {
            this.b = th.getMessage();
        }
    }

    public f(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public f(int i, JSONObject jSONObject) {
        this.a = i;
        this.c = jSONObject;
    }

    public boolean a() {
        return this.a == 0;
    }
}
