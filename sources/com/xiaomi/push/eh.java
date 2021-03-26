package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.f;

class eh implements ef {
    eh() {
    }

    private void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                String[] split = str.split("/");
                if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        dy.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String decode = Uri.decode(str2);
                    if (TextUtils.isEmpty(decode)) {
                        dy.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String b = dx.b(decode);
                    if (!TextUtils.isEmpty(b)) {
                        dy.a(context, b, 1007, "play with provider successfully");
                        return;
                    }
                }
            }
            dy.a(context, "provider", 1008, "B get a incorrect message");
        } catch (Exception e) {
            dy.a(context, "provider", 1008, "B meet a exception" + e.getMessage());
        }
    }

    private void b(Context context, eb ebVar) {
        String b = ebVar.b();
        String d = ebVar.d();
        int a = ebVar.a();
        if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dy.a(context, "provider", 1008, "argument error");
            } else {
                dy.a(context, d, 1008, "argument error");
            }
        } else if (!f.b(context, b)) {
            dy.a(context, d, 1003, "B is not ready");
        } else {
            dy.a(context, d, 1002, "B is ready");
            dy.a(context, d, 1004, "A is ready");
            String a2 = dx.a(d);
            try {
                if (TextUtils.isEmpty(a2)) {
                    dy.a(context, d, 1008, "info is empty");
                } else if (a != 1 || ec.m288a(context)) {
                    String type = context.getContentResolver().getType(dx.a(b, a2));
                    if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                        dy.a(context, d, 1008, "A is fail to help B's provider");
                        return;
                    }
                    dy.a(context, d, 1005, "A is successful");
                    dy.a(context, d, 1006, "The job is finished");
                } else {
                    dy.a(context, d, 1008, "A not in foreground");
                }
            } catch (Exception e) {
                b.a(e);
                dy.a(context, d, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.ef
    public void a(Context context, eb ebVar) {
        if (ebVar != null) {
            b(context, ebVar);
        } else {
            dy.a(context, "provider", 1008, "A receive incorrect message");
        }
    }
}
