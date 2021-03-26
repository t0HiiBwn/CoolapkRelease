package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.m;
import java.util.ArrayList;

final class ft extends m.b {
    final /* synthetic */ Context a;

    ft(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.m.b
    public void b() {
        ArrayList arrayList;
        synchronized (fs.d) {
            arrayList = new ArrayList(fs.e);
            fs.e.clear();
        }
        fs.b(this.a, arrayList);
    }
}
