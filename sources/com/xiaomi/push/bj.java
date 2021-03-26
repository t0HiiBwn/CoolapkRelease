package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

public class bj {
    private static SimpleDateFormat a;
    private static String b;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        a = simpleDateFormat;
        b = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gm a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gm gmVar = new gm();
        gmVar.d("category_push_stat");
        gmVar.a("push_sdk_stat_channel");
        gmVar.a(1);
        gmVar.b(str);
        gmVar.c(true);
        gmVar.b(System.currentTimeMillis());
        gmVar.g(ar.a(context).a());
        gmVar.e("com.xiaomi.xmsf");
        gmVar.f("");
        gmVar.c("push_stat");
        return gmVar;
    }
}
