package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.bd;

class dq implements dm {
    dq() {
    }

    private void a(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                df.a(service.getApplicationContext(), "service", 1007, "old version message");
            } else if (!TextUtils.isEmpty(stringExtra2)) {
                String b = de.b(stringExtra2);
                boolean isEmpty = TextUtils.isEmpty(b);
                Context applicationContext = service.getApplicationContext();
                if (!isEmpty) {
                    df.a(applicationContext, b, 1007, "old version message ");
                } else {
                    df.a(applicationContext, "service", 1008, "B get a incorrect message");
                }
            } else {
                df.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                df.a(context, "service", 1008, "argument error");
            } else {
                df.a(context, str3, 1008, "argument error");
            }
        } else if (!bd.a(context, str)) {
            df.a(context, str3, 1003, "B is not ready");
        } else {
            df.a(context, str3, 1002, "B is ready");
            df.a(context, str3, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", de.a(str3));
                if (context.startService(intent) != null) {
                    df.a(context, str3, 1005, "A is successful");
                    df.a(context, str3, 1006, "The job is finished");
                    return;
                }
                df.a(context, str3, 1008, "A is fail to help B's service");
            } catch (Exception e) {
                c.a(e);
                df.a(context, str3, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, Intent intent, String str) {
        if (context != null && (context instanceof Service)) {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, di diVar) {
        if (diVar != null) {
            a(context, diVar.a(), diVar.c(), diVar.d());
        }
    }
}
