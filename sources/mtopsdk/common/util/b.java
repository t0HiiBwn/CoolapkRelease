package mtopsdk.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: ConfigStoreManager */
public class b {
    private static volatile b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        if (context == null || StringUtils.isBlank(str) || StringUtils.isBlank(str3)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            if (StringUtils.isNotBlank(str2)) {
                edit.putString(str2 + str3, str4);
            } else {
                edit.putString(str3, str4);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
            return true;
        } catch (Exception unused) {
            if (!TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                return false;
            }
            TBSdkLog.w("mtopsdk.ConfigStoreManager", "[saveConfigItem] saveConfigItem error,store=" + str + ",keyprefix=" + str2 + ",key=" + str3);
            return false;
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        if (context == null || StringUtils.isBlank(str) || StringUtils.isBlank(str3)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (!StringUtils.isNotBlank(str2)) {
                return sharedPreferences.getString(str3, null);
            }
            return sharedPreferences.getString(str2 + str3, null);
        } catch (Exception unused) {
            if (!TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                return null;
            }
            TBSdkLog.w("mtopsdk.ConfigStoreManager", "[getConfigItem] getConfigItem error,store=" + str + ",keyprefix=" + str2 + ",key=" + str3);
            return null;
        }
    }
}
