package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dj;
import com.xiaomi.push.gn;
import com.xiaomi.push.service.l;

final class p extends l.a {
    final /* synthetic */ Context a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(int i, String str, Context context) {
        super(i, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.l.a
    protected void onCallback() {
        dj.a(this.a).a(l.a(this.a).a(gn.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
