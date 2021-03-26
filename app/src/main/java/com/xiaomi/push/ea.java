package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.f;

class ea implements ef {
    ea() {
    }

    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = dx.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                dy.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
                return;
            }
        }
        dy.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
    }

    private void b(Context context, eb ebVar) {
        String a = ebVar.m287a();
        String b = ebVar.b();
        String d = ebVar.d();
        int a2 = ebVar.a();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dy.a(context, "activity", 1008, "argument error");
            } else {
                dy.a(context, d, 1008, "argument error");
            }
        } else if (!f.b(context, a, b)) {
            dy.a(context, d, 1003, "B is not ready");
        } else {
            dy.a(context, d, 1002, "B is ready");
            dy.a(context, d, 1004, "A is ready");
            Intent intent = new Intent(b);
            intent.setPackage(a);
            intent.putExtra("awake_info", dx.a(d));
            intent.addFlags(276824064);
            intent.setAction(b);
            if (a2 == 1) {
                try {
                    if (!ec.m288a(context)) {
                        dy.a(context, d, 1008, "A not in foreground");
                        return;
                    }
                } catch (Exception e) {
                    b.a(e);
                    dy.a(context, d, 1008, "A meet a exception when help B's activity");
                    return;
                }
            }
            context.startActivity(intent);
            dy.a(context, d, 1005, "A is successful");
            dy.a(context, d, 1006, "The job is finished");
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            dy.a(context, "activity", 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(Context context, eb ebVar) {
        if (ebVar != null) {
            b(context, ebVar);
        } else {
            dy.a(context, "activity", 1008, "A receive incorrect message");
        }
    }
}
