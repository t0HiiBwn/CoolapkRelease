package com.xiaomi.push;

import com.xiaomi.push.ai;

class aj extends ai.b {
    final /* synthetic */ ai a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f190a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f191a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(ai aiVar, ai.a aVar, boolean z, String str) {
        super(aVar);
        this.a = aiVar;
        this.f191a = z;
        this.f190a = str;
    }

    @Override // com.xiaomi.push.ai.b
    void a() {
        super.a();
    }

    @Override // com.xiaomi.push.ai.b
    void b() {
        if (!this.f191a) {
            ai.a(this.a).edit().putLong(this.f190a, System.currentTimeMillis()).commit();
        }
    }
}
