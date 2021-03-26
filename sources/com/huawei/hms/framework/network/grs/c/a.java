package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

public class a {
    public static String a() {
        return "4.0.2.300";
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.w("AgentUtil", "", e);
            return "";
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0065: APUT  (r6v2 java.lang.Object[]), (5 ??[int, float, short, byte, char]), (r10v1 java.lang.String) */
    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", a());
        }
        String packageName = context.getPackageName();
        String a = a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        Object[] objArr = new Object[6];
        objArr[0] = packageName;
        objArr[1] = a;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return String.format(locale, str5, objArr);
    }

    public static String b(Context context, String str, String str2) {
        return a(context, str, str2);
    }
}
