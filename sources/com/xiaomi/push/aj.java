package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.b.b.b;
import com.xiaomi.push.j;

public class aj extends j.a {
    private Context a;

    public aj(Context context) {
        this.a = context;
    }

    private boolean b() {
        return b.a(this.a).a().d();
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 100887;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                b.a(this.a).d();
                c.c(this.a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e) {
            c.a(e);
        }
    }
}
