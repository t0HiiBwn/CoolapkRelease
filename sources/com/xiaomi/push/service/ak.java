package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ah;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gs;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.jb;
import com.xiaomi.push.jg;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ak {
    private static AtomicLong a = new AtomicLong(0);
    private static SimpleDateFormat b;
    private static String c;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        b = simpleDateFormat;
        c = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        synchronized (ak.class) {
            String format = b.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(c, format)) {
                a.set(0);
                c = format;
            }
            str = format + "-" + a.incrementAndGet();
        }
        return str;
    }

    public static ArrayList<hi> a(List<gm> list, String str, String str2, int i) {
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else if (list.size() == 0) {
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        } else {
            ArrayList<hi> arrayList = new ArrayList<>();
            gl glVar = new gl();
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                gm gmVar = list.get(i3);
                if (gmVar != null) {
                    int length = ht.a(gmVar).length;
                    if (length > i) {
                        c.d("TinyData is too big, ignore upload request item:" + gmVar.m());
                    } else {
                        if (i2 + length > i) {
                            hi hiVar = new hi("-1", false);
                            hiVar.d(str);
                            hiVar.b(str2);
                            hiVar.c(gs.UploadTinyData.S);
                            hiVar.a(jg.a(ht.a(glVar)));
                            arrayList.add(hiVar);
                            glVar = new gl();
                            i2 = 0;
                        }
                        glVar.a(gmVar);
                        i2 += length;
                    }
                }
            }
            if (glVar.a() != 0) {
                hi hiVar2 = new hi("-1", false);
                hiVar2.d(str);
                hiVar2.b(str2);
                hiVar2.c(gs.UploadTinyData.S);
                hiVar2.a(jg.a(ht.a(glVar)));
                arrayList.add(hiVar2);
            }
            return arrayList;
        }
        c.d(str3);
        return null;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        gm gmVar = new gm();
        gmVar.d(str);
        gmVar.c(str2);
        gmVar.a(j);
        gmVar.b(str3);
        gmVar.a("push_sdk_channel");
        gmVar.g(context.getPackageName());
        gmVar.e(context.getPackageName());
        gmVar.c(true);
        gmVar.b(System.currentTimeMillis());
        gmVar.f(a());
        al.a(context, gmVar);
    }

    public static boolean a(gm gmVar, boolean z) {
        String str;
        if (gmVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(gmVar.a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(gmVar.g)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(gmVar.c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!ah.d(gmVar.g)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (!ah.d(gmVar.c)) {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (gmVar.b == null || gmVar.b.length() <= 10240) {
            return false;
        } else {
            str = "item.data is too large(" + gmVar.b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        }
        c.a(str);
        return true;
    }

    public static boolean a(String str) {
        return !jb.d() || "com.miui.hybrid".equals(str);
    }
}
