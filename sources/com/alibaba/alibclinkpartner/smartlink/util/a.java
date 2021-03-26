package com.alibaba.alibclinkpartner.smartlink.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import com.alibaba.alibclinkpartner.smartlink.data.MAtrixAppData;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {
    private static String a = "android.permission.READ_PHONE_STATE";

    public static int a(String str, String str2) {
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return i;
            }
            str = str.substring(indexOf + str2.length());
            i++;
        }
    }

    public static String a(Activity activity) {
        String str;
        if (activity == null) {
            return "unKnown";
        }
        try {
            if (Build.VERSION.SDK_INT < 22) {
                Iterator<ActivityManager.RunningTaskInfo> it2 = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(2).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str = "";
                        break;
                    }
                    ActivityManager.RunningTaskInfo next = it2.next();
                    if (!next.baseActivity.getPackageName().equals(activity.getPackageName())) {
                        str = next.baseActivity.getPackageName();
                        break;
                    }
                }
            } else {
                str = b(activity);
            }
            return str;
        } catch (Exception unused) {
            return "unKnown";
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (ActivityCompat.checkSelfPermission(context, a) == 0) {
                return telephonyManager.getDeviceId();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static List<String> a(MAtrixAppData mAtrixAppData) {
        ArrayList arrayList = new ArrayList();
        if (!(mAtrixAppData == null || mAtrixAppData.appinfo == null)) {
            Map<String, MatrixAppInfoDetail> map = mAtrixAppData.appinfo;
            for (String str : map.keySet()) {
                arrayList.add(map.get(str).packageName);
            }
        }
        return arrayList;
    }

    private static String b(Activity activity) {
        try {
            Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            return (String) declaredField.get(activity);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context.getApplicationInfo().processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
