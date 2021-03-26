package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;

/* compiled from: ProGuard */
public class PushMd5Pref {
    private PushMd5Pref() {
    }

    private static String a(String str) {
        return Md5.md5(str);
    }

    public static boolean putString(Context context, String str, String str2, boolean z) {
        if (z) {
            try {
                String str3 = (String) MemoryCacheManager.get(str);
                if (str3 != null && str2 != null && str3.equals(str2)) {
                    return true;
                }
                MemoryCacheManager.put(str, str2);
            } catch (Throwable th) {
                Logger.e("PushMd5Pref", "putString", th);
                return false;
            }
        }
        PushPreferences.putString(context, a(str), str2);
        return true;
    }

    public static String getString(Context context, String str, boolean z) {
        if (!z) {
            return PushPreferences.getString(context, a(str), null);
        }
        try {
            String str2 = (String) MemoryCacheManager.get(str);
            if (str2 != null) {
                return str2;
            }
            String string = PushPreferences.getString(context, a(str), null);
            MemoryCacheManager.put(str, string);
            return string;
        } catch (Throwable th) {
            Logger.e("PushMd5Pref", "getString", th);
            return "";
        }
    }

    public static boolean putFloat(Context context, String str, float f) {
        try {
            PushPreferences.putFloat(context, a(str), f);
            return true;
        } catch (Throwable th) {
            Logger.e("PushMd5Pref", "putFloat", th);
            return false;
        }
    }

    public static float getFloat(Context context, String str, float f) {
        try {
            return PushPreferences.getFloat(context, a(str), f);
        } catch (Throwable th) {
            Logger.e("PushMd5Pref", "getFloat", th);
            return 0.0f;
        }
    }

    public static boolean putLong(Context context, String str, long j) {
        try {
            PushPreferences.putLong(context, a(str), j);
            return false;
        } catch (Throwable th) {
            Logger.e("PushMd5Pref", "putLong", th);
            return false;
        }
    }

    public static long getLong(Context context, String str, long j) {
        try {
            return PushPreferences.getLong(context, a(str), j);
        } catch (Throwable th) {
            Logger.e("PushMd5Pref", "getLong", th);
            return 0;
        }
    }

    public static boolean putInt(Context context, String str, int i) {
        try {
            PushPreferences.putInt(context, a(str), i);
            return true;
        } catch (Throwable th) {
            Logger.e("PushMd5Pref", "putInt", th);
            return false;
        }
    }

    public static int getInt(Context context, String str, int i) {
        try {
            return PushPreferences.getInt(context, a(str), i);
        } catch (Throwable th) {
            Logger.e("PushMd5Pref", "getInt", th);
            return 0;
        }
    }
}
