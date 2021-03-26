package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.bd;

/* renamed from: com.xiaomi.push.do  reason: invalid class name */
class Cdo implements dm {
    Cdo() {
    }

    private void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                String[] split = str.split("/");
                if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        df.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String decode = Uri.decode(str2);
                    if (TextUtils.isEmpty(decode)) {
                        df.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String b = de.b(decode);
                    if (!TextUtils.isEmpty(b)) {
                        df.a(context, b, 1007, "play with provider successfully");
                        return;
                    }
                }
            }
            df.a(context, "provider", 1008, "B get a incorrect message");
        } catch (Exception e) {
            df.a(context, "provider", 1008, "B meet a exception" + e.getMessage());
        }
    }

    private void b(Context context, di diVar) {
        String b = diVar.b();
        String d = diVar.d();
        int e = diVar.e();
        if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                df.a(context, "provider", 1008, "argument error");
            } else {
                df.a(context, d, 1008, "argument error");
            }
        } else if (!bd.b(context, b)) {
            df.a(context, d, 1003, "B is not ready");
        } else {
            df.a(context, d, 1002, "B is ready");
            df.a(context, d, 1004, "A is ready");
            String a = de.a(d);
            try {
                if (TextUtils.isEmpty(a)) {
                    df.a(context, d, 1008, "info is empty");
                } else if (e != 1 || dj.b(context)) {
                    String type = context.getContentResolver().getType(de.a(b, a));
                    if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                        df.a(context, d, 1008, "A is fail to help B's provider");
                        return;
                    }
                    df.a(context, d, 1005, "A is successful");
                    df.a(context, d, 1006, "The job is finished");
                } else {
                    df.a(context, d, 1008, "A not in foreground");
                }
            } catch (Exception e2) {
                c.a(e2);
                df.a(context, d, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.dm
    public void a(Context context, di diVar) {
        if (diVar != null) {
            b(context, diVar);
        } else {
            df.a(context, "provider", 1008, "A receive incorrect message");
        }
    }
}
