package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.ai;

public class bk extends ai.a {
    private Context a;

    public bk(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    private boolean mo141a() {
        return a.a(this.a).m43a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo142a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (mo141a()) {
                a.a(this.a).c();
                b.c(this.a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e) {
            b.d("fail to send perf data. " + e);
        }
    }
}
