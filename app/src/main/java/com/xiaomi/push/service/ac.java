package com.xiaomi.push.service;

import com.xiaomi.push.ai;

final class ac extends ai.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f936a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f937a;

    ac(String str, al alVar, int i) {
        this.f937a = str;
        this.f936a = alVar;
        this.a = i;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return this.f937a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f936a.a(this.a);
    }
}
