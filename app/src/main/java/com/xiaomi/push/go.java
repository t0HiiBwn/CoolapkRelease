package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;

final class go extends al.b {
    final /* synthetic */ Context a;

    go(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: b */
    public void mo197b() {
        ArrayList arrayList;
        synchronized (gn.a()) {
            arrayList = new ArrayList(gn.a());
            gn.a().clear();
        }
        gn.b(this.a, arrayList);
    }
}
