package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bi;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hm;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.t;
import com.xiaomi.push.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class bl {
    private static String a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f1003a;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f1004a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f1003a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    private static ib a(String str, String str2, hf hfVar) {
        return new ib("-1", false).d(str).b(str2).a(y.a(im.a(hfVar))).c(hm.UploadTinyData.f576a);
    }

    public static synchronized String a() {
        String str;
        synchronized (bl.class) {
            String format = f1003a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(a, format)) {
                f1004a.set(0);
                a = format;
            }
            str = format + "-" + f1004a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
    public static ArrayList<ib> a(List<hg> list, String str, String str2, int i) {
        int i2;
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else if (list.size() == 0) {
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        } else {
            ArrayList<ib> arrayList = new ArrayList<>();
            hf hfVar = new hf();
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                hg hgVar = list.get(i4);
                if (hgVar != null) {
                    if (hgVar.m391a() == null || !hgVar.m391a().containsKey("item_size")) {
                        i2 = 0;
                    } else {
                        String str4 = hgVar.m391a().get("item_size");
                        if (!TextUtils.isEmpty(str4)) {
                            try {
                                i2 = Integer.parseInt(str4);
                            } catch (Exception unused) {
                            }
                            if (hgVar.m391a().size() != 1) {
                                hgVar.a((Map<String, String>) null);
                            } else {
                                hgVar.m391a().remove("item_size");
                            }
                        }
                        i2 = 0;
                        if (hgVar.m391a().size() != 1) {
                        }
                    }
                    if (i2 <= 0) {
                        i2 = im.a(hgVar).length;
                    }
                    if (i2 > i) {
                        b.d("TinyData is too big, ignore upload request item:" + hgVar.d());
                    } else {
                        if (i3 + i2 > i) {
                            arrayList.add(a(str, str2, hfVar));
                            hfVar = new hf();
                            i3 = 0;
                        }
                        hfVar.a(hgVar);
                        i3 += i2;
                    }
                }
            }
            if (hfVar.a() != 0) {
                arrayList.add(a(str, str2, hfVar));
            }
            return arrayList;
        }
        b.d(str3);
        return null;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hg hgVar = new hg();
        hgVar.d(str);
        hgVar.c(str2);
        hgVar.a(j);
        hgVar.b(str3);
        hgVar.a("push_sdk_channel");
        hgVar.g(context.getPackageName());
        hgVar.e(context.getPackageName());
        hgVar.a(true);
        hgVar.b(System.currentTimeMillis());
        hgVar.f(a());
        bm.a(context, hgVar);
    }

    public static boolean a(hg hgVar, boolean z) {
        String str;
        if (hgVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(hgVar.f548a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hgVar.f555d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hgVar.f554c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!bi.m138a(hgVar.f555d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (!bi.m138a(hgVar.f554c)) {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (hgVar.f553b == null || hgVar.f553b.length() <= 10240) {
            return false;
        } else {
            str = "item.data is too large(" + hgVar.f553b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        }
        b.m41a(str);
        return true;
    }

    public static boolean a(String str) {
        return !t.m679b() || "com.miui.hybrid".equals(str);
    }
}
