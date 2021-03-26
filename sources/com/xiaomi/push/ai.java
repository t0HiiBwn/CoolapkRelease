package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.b.b.b;
import com.xiaomi.push.j;

public class ai extends j.a {
    private Context a;

    public ai(Context context) {
        this.a = context;
    }

    private boolean b() {
        return b.a(this.a).a().c();
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 100886;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                c.c(this.a.getPackageName() + " begin upload event");
                b.a(this.a).c();
            }
        } catch (Exception e) {
            c.a(e);
        }
    }
}
