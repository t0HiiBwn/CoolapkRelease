package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.bd;

class dp implements dm {
    dp() {
    }

    private void a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = de.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                df.a(service.getApplicationContext(), b, 1007, "play with service successfully");
                return;
            }
        }
        df.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
    }

    private void b(Context context, di diVar) {
        String a = diVar.a();
        String b = diVar.b();
        String d = diVar.d();
        int e = diVar.e();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                df.a(context, "service", 1008, "argument error");
            } else {
                df.a(context, d, 1008, "argument error");
            }
        } else if (!bd.a(context, a, b)) {
            df.a(context, d, 1003, "B is not ready");
        } else {
            df.a(context, d, 1002, "B is ready");
            df.a(context, d, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b);
                intent.setPackage(a);
                intent.putExtra("awake_info", de.a(d));
                if (e == 1 && !dj.b(context)) {
                    df.a(context, d, 1008, "A not in foreground");
                } else if (context.startService(intent) != null) {
                    df.a(context, d, 1005, "A is successful");
                    df.a(context, d, 1006, "The job is finished");
                } else {
                    df.a(context, d, 1008, "A is fail to help B's service");
                }
            } catch (Exception e2) {
                c.a(e2);
                df.a(context, d, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            df.a(context, "service", 1008, "A receive incorrect message");
        } else {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, di diVar) {
        if (diVar != null) {
            b(context, diVar);
        } else {
            df.a(context, "service", 1008, "A receive incorrect message");
        }
    }
}
