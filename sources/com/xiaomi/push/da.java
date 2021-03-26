package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

public class da extends cw {
    private SharedPreferences a;

    public da(Context context, int i) {
        super(context, i);
        this.a = context.getSharedPreferences("mipush_extra", 0);
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 9;
    }

    @Override // com.xiaomi.push.cw
    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.cw
    public gk c() {
        return gk.TopApp;
    }
}
