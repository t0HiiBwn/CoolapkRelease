package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ec;
import com.xiaomi.push.hh;
import com.xiaomi.push.service.an;

final class p extends an.a {
    final /* synthetic */ Context a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(int i, String str, Context context) {
        super(i, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.an.a
    protected void onCallback() {
        ec.a(this.a).a(an.a(this.a).a(hh.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
