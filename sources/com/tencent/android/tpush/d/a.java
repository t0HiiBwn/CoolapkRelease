package com.tencent.android.tpush.d;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ProGuard */
public class a {
    private static final String[] a = {"com.tencent.android.tpush.otherpush.mipush.impl.OtherPushImpl", "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl"};
    private static int b = -2;
    private static String c = null;

    public static boolean a(Context context) {
        if (b == -2) {
            int i = 0;
            while (true) {
                String[] strArr = a;
                if (i >= strArr.length) {
                    b = -1;
                    break;
                }
                try {
                    Class.forName(strArr[i]);
                    if (a(context, strArr[i])) {
                        b = i;
                        c = strArr[i];
                        return true;
                    }
                    i++;
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        if (b > -1) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        try {
            TLogger.ii("OtherPush", "checkDevice pushClassName" + str);
            Class<?> cls = Class.forName(str);
            return ((Boolean) cls.getMethod("checkDevice", Context.class).invoke(cls, context)).booleanValue();
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            TLogger.ee("OtherPush", "checkDevice Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
            return false;
        } catch (Throwable th) {
            TLogger.ee("OtherPush", "checkDevice Error, are you import otherpush package? " + th);
            return false;
        }
    }

    public static void b(Context context, String str) {
        a(context, str, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
    }

    private static void a(Context context, String str, String str2) {
        try {
            Class<?> cls = Class.forName(str2);
            cls.getMethod("setAppid", Context.class, String.class).invoke(cls, context, str);
        } catch (Throwable th) {
            TLogger.ww("OtherPush", "setAppid Error, are you import otherpush package? " + th);
        }
    }
}
