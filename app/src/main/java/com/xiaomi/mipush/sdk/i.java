package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

final class i implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ d f173a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f174a;

    i(String str, Context context, d dVar) {
        this.f174a = str;
        this.a = context;
        this.f173a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (!TextUtils.isEmpty(this.f174a)) {
            String[] split = this.f174a.split("~");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = "";
                    break;
                }
                String str2 = split[i];
                if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                    str = str2.substring(str2.indexOf(":") + 1);
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                b.m41a("ASSEMBLE_PUSH : receive correct token");
                h.d(this.a, this.f173a, str);
                h.m92a(this.a);
                return;
            }
            b.m41a("ASSEMBLE_PUSH : receive incorrect token");
        }
    }
}
