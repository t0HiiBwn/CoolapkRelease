package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;

final class i implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ d f155a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f156a;

    i(String str, Context context, d dVar) {
        this.f156a = str;
        this.a = context;
        this.f155a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (!TextUtils.isEmpty(this.f156a)) {
            String[] split = this.f156a.split("~");
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
                c.a("ASSEMBLE_PUSH : receive correct token");
                h.d(this.a, this.f155a, str);
                h.m71a(this.a);
                return;
            }
            c.a("ASSEMBLE_PUSH : receive incorrect token");
        }
    }
}
