package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.f;

class ei implements ef {
    ei() {
    }

    private void a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = dx.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                dy.a(service.getApplicationContext(), b, 1007, "play with service successfully");
                return;
            }
        }
        dy.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
    }

    private void b(Context context, eb ebVar) {
        String a = ebVar.m287a();
        String b = ebVar.b();
        String d = ebVar.d();
        int a2 = ebVar.a();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dy.a(context, "service", 1008, "argument error");
            } else {
                dy.a(context, d, 1008, "argument error");
            }
        } else if (!f.a(context, a, b)) {
            dy.a(context, d, 1003, "B is not ready");
        } else {
            dy.a(context, d, 1002, "B is ready");
            dy.a(context, d, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b);
                intent.setPackage(a);
                intent.putExtra("awake_info", dx.a(d));
                if (a2 == 1 && !ec.m288a(context)) {
                    dy.a(context, d, 1008, "A not in foreground");
                } else if (context.startService(intent) != null) {
                    dy.a(context, d, 1005, "A is successful");
                    dy.a(context, d, 1006, "The job is finished");
                } else {
                    dy.a(context, d, 1008, "A is fail to help B's service");
                }
            } catch (Exception e) {
                b.a(e);
                dy.a(context, d, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            dy.a(context, "service", 1008, "A receive incorrect message");
        } else {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(Context context, eb ebVar) {
        if (ebVar != null) {
            b(context, ebVar);
        } else {
            dy.a(context, "service", 1008, "A receive incorrect message");
        }
    }
}
