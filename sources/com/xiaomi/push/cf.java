package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.m;

class cf extends m.b {
    final /* synthetic */ ce a;

    cf(ce ceVar) {
        this.a = ceVar;
    }

    @Override // com.xiaomi.push.m.b
    public void b() {
        if (!ce.g.isEmpty()) {
            try {
                if (!b.d()) {
                    Log.w(this.a.d, "SDCard is unavailable.");
                } else {
                    this.a.b();
                }
            } catch (Exception e) {
                Log.e(this.a.d, "", e);
            }
        }
    }
}
