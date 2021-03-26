package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.bd;

class dh implements dm {
    dh() {
    }

    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = de.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                df.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
                return;
            }
        }
        df.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
    }

    private void b(Context context, di diVar) {
        String a = diVar.a();
        String b = diVar.b();
        String d = diVar.d();
        int e = diVar.e();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                df.a(context, "activity", 1008, "argument error");
            } else {
                df.a(context, d, 1008, "argument error");
            }
        } else if (!bd.b(context, a, b)) {
            df.a(context, d, 1003, "B is not ready");
        } else {
            df.a(context, d, 1002, "B is ready");
            df.a(context, d, 1004, "A is ready");
            Intent intent = new Intent(b);
            intent.setPackage(a);
            intent.putExtra("awake_info", de.a(d));
            intent.addFlags(276824064);
            intent.setAction(b);
            if (e == 1) {
                try {
                    if (!dj.b(context)) {
                        df.a(context, d, 1008, "A not in foreground");
                        return;
                    }
                } catch (Exception e2) {
                    c.a(e2);
                    df.a(context, d, 1008, "A meet a exception when help B's activity");
                    return;
                }
            }
            context.startActivity(intent);
            df.a(context, d, 1005, "A is successful");
            df.a(context, d, 1006, "The job is finished");
        }
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            df.a(context, "activity", 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, di diVar) {
        if (diVar != null) {
            b(context, diVar);
        } else {
            df.a(context, "activity", 1008, "A receive incorrect message");
        }
    }
}
