package com.xiaomi.push;

import android.content.Context;

public class cz extends cw {
    public cz(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 23;
    }

    @Override // com.xiaomi.push.cw
    public String b() {
        return "ram:" + gw.c() + ",rom:" + gw.e() + "|ramOriginal:" + gw.f() + ",romOriginal:" + gw.g();
    }

    @Override // com.xiaomi.push.cw
    public gk c() {
        return gk.Storage;
    }
}
