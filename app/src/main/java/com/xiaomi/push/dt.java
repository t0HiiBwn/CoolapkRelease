package com.xiaomi.push;

import android.content.Context;

public class dt extends ds {
    public dt(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.ds, com.xiaomi.push.ai.a
    /* renamed from: a */
    public he mo141a() {
        return he.Storage;
    }

    @Override // com.xiaomi.push.ds, com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo208a() {
        return "23";
    }

    @Override // com.xiaomi.push.ds
    public String b() {
        return "ram:" + i.m468a() + ",rom:" + i.m472b() + "|ramOriginal:" + i.m474c() + ",romOriginal:" + i.d();
    }
}
