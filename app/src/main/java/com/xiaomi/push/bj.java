package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.ai;

public class bj extends ai.a {
    private Context a;

    public bj(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    private boolean mo141a() {
        return a.a(this.a).m43a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo141a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (mo141a()) {
                b.c(this.a.getPackageName() + " begin upload event");
                a.a(this.a).m45b();
            }
        } catch (Exception e) {
            b.a(e);
        }
    }
}
