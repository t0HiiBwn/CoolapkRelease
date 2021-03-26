package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

public class cj {
    private static String a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f266a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f266a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hg a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hg hgVar = new hg();
        hgVar.d("category_push_stat");
        hgVar.a("push_sdk_stat_channel");
        hgVar.a(1);
        hgVar.b(str);
        hgVar.a(true);
        hgVar.b(System.currentTimeMillis());
        hgVar.g(bs.a(context).m149a());
        hgVar.e("com.xiaomi.xmsf");
        hgVar.f("");
        hgVar.c("push_stat");
        return hgVar;
    }
}
