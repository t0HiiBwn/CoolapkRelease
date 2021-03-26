package com.hjq.permissions;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.fragment.app.FragmentActivity;
import com.hjq.permissions.Permission;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class PermissionUtils {
    PermissionUtils() {
    }

    static boolean isAndroid11() {
        return Build.VERSION.SDK_INT >= 30;
    }

    static boolean isAndroid10() {
        return Build.VERSION.SDK_INT >= 29;
    }

    static boolean isAndroid9() {
        return Build.VERSION.SDK_INT >= 28;
    }

    static boolean isAndroid8() {
        return Build.VERSION.SDK_INT >= 26;
    }

    static boolean isAndroid7() {
        return Build.VERSION.SDK_INT >= 24;
    }

    static boolean isAndroid6() {
        return Build.VERSION.SDK_INT >= 23;
    }

    static List<String> getManifestPermissions(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                return asArrayList(strArr);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    static boolean isGrantedStoragePermission(Context context) {
        if (isAndroid11()) {
            return Environment.isExternalStorageManager();
        }
        return XXPermissions.isGrantedPermission(context, Permission.Group.STORAGE);
    }

    static boolean isGrantedInstallPermission(Context context) {
        if (isAndroid8()) {
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    static boolean isGrantedWindowPermission(Context context) {
        if (isAndroid6()) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    static boolean isGrantedNotifyPermission(Context context) {
        if (isAndroid7()) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        if (!isAndroid6()) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            if (((Integer) appOpsManager.getClass().getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0) {
                return true;
            }
            return false;
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    static boolean isGrantedSettingPermission(Context context) {
        if (isAndroid6()) {
            return Settings.System.canWrite(context);
        }
        return true;
    }

    static boolean containsSpecialPermission(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (isSpecialPermission(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isSpecialPermission(String str) {
        return "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str) || "android.permission.REQUEST_INSTALL_PACKAGES".equals(str) || "android.permission.SYSTEM_ALERT_WINDOW".equals(str) || "android.permission.ACCESS_NOTIFICATION_POLICY".equals(str) || "android.permission.WRITE_SETTINGS".equals(str);
    }

    static boolean isGrantedPermission(Context context, List<String> list) {
        if (!isAndroid6()) {
            return true;
        }
        for (String str : list) {
            if (!isGrantedPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    static boolean isGrantedPermission(Context context, String str) {
        if (!isAndroid6()) {
            return true;
        }
        if ("android.permission.MANAGE_EXTERNAL_STORAGE".equals(str)) {
            return isGrantedStoragePermission(context);
        }
        if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str)) {
            return isGrantedInstallPermission(context);
        }
        if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str)) {
            return isGrantedWindowPermission(context);
        }
        if ("android.permission.ACCESS_NOTIFICATION_POLICY".equals(str)) {
            return isGrantedNotifyPermission(context);
        }
        if ("android.permission.WRITE_SETTINGS".equals(str)) {
            return isGrantedSettingPermission(context);
        }
        if (!isAndroid10()) {
            if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) || "android.permission.ACCESS_MEDIA_LOCATION".equals(str)) {
                return true;
            }
            if ("android.permission.ACTIVITY_RECOGNITION".equals(str)) {
                if (context.checkSelfPermission("android.permission.BODY_SENSORS") == 0) {
                    return true;
                }
                return false;
            }
        }
        if (!isAndroid9() && "android.permission.ACCEPT_HANDOVER".equals(str)) {
            return true;
        }
        if (!isAndroid8()) {
            if ("android.permission.ANSWER_PHONE_CALLS".equals(str)) {
                if (context.checkSelfPermission("android.permission.PROCESS_OUTGOING_CALLS") == 0) {
                    return true;
                }
                return false;
            } else if ("android.permission.READ_PHONE_NUMBERS".equals(str)) {
                if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                    return true;
                }
                return false;
            }
        }
        if (context.checkSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    static int getPermissionStatus(Context context, String str) {
        return isGrantedPermission(context, str) ? 0 : -1;
    }

    static boolean isPermissionPermanentDenied(Activity activity, List<String> list) {
        for (String str : list) {
            if (isPermissionPermanentDenied(activity, str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (!isAndroid6() || isSpecialPermission(str)) {
            return false;
        }
        if (!isAndroid10()) {
            if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) || "android.permission.ACCESS_MEDIA_LOCATION".equals(str)) {
                return false;
            }
            if ("android.permission.ACTIVITY_RECOGNITION".equals(str)) {
                if (activity.checkSelfPermission("android.permission.BODY_SENSORS") != -1 || activity.shouldShowRequestPermissionRationale(str)) {
                    return false;
                }
                return true;
            }
        }
        if (!isAndroid9() && "android.permission.ACCEPT_HANDOVER".equals(str)) {
            return false;
        }
        if (!isAndroid8()) {
            if ("android.permission.ANSWER_PHONE_CALLS".equals(str)) {
                if (activity.checkSelfPermission("android.permission.PROCESS_OUTGOING_CALLS") != -1 || activity.shouldShowRequestPermissionRationale(str)) {
                    return false;
                }
                return true;
            } else if ("android.permission.READ_PHONE_NUMBERS".equals(str)) {
                if (activity.checkSelfPermission("android.permission.READ_PHONE_STATE") != -1 || activity.shouldShowRequestPermissionRationale(str)) {
                    return false;
                }
                return true;
            }
        }
        if (activity.checkSelfPermission(str) != -1 || activity.shouldShowRequestPermissionRationale(str)) {
            return false;
        }
        return true;
    }

    static List<String> getDeniedPermissions(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == -1) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    static List<String> getGrantedPermissions(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    static void optimizeDeprecatedPermission(List<String> list) {
        if (list.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
            if (list.contains("android.permission.READ_EXTERNAL_STORAGE") || list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("Please do not apply for these two permissions dynamically");
            } else if (!isAndroid11()) {
                list.add("android.permission.READ_EXTERNAL_STORAGE");
                list.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }
        if (list.contains("android.permission.ANSWER_PHONE_CALLS")) {
            if (list.contains("android.permission.PROCESS_OUTGOING_CALLS")) {
                throw new IllegalArgumentException("Please do not apply for these two permissions dynamically");
            } else if (!isAndroid10() && !list.contains("android.permission.PROCESS_OUTGOING_CALLS")) {
                list.add("android.permission.PROCESS_OUTGOING_CALLS");
            }
        }
        if (list.contains("android.permission.ACTIVITY_RECOGNITION") && !isAndroid10() && !list.contains("android.permission.BODY_SENSORS")) {
            list.add("android.permission.BODY_SENSORS");
        }
    }

    static boolean areActivityIntent(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    static boolean isDebugMode(Context context) {
        return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    static <T> ArrayList<T> asArrayList(T... tArr) {
        if (tArr == null) {
            return null;
        }
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    static void checkPermissionManifest(Activity activity, List<String> list) {
        List<String> manifestPermissions = getManifestPermissions(activity);
        if (manifestPermissions == null || manifestPermissions.isEmpty()) {
            throw new ManifestException();
        }
        int i = Build.VERSION.SDK_INT >= 24 ? activity.getApplicationInfo().minSdkVersion : 23;
        for (String str : list) {
            if (i < 30 && "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str)) {
                if (!manifestPermissions.contains("android.permission.READ_EXTERNAL_STORAGE")) {
                    throw new ManifestException("android.permission.READ_EXTERNAL_STORAGE");
                } else if (!manifestPermissions.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    throw new ManifestException("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
            if (i >= 29 || !"android.permission.ACTIVITY_RECOGNITION".equals(str) || manifestPermissions.contains("android.permission.BODY_SENSORS")) {
                if (i < 26) {
                    if ("android.permission.ANSWER_PHONE_CALLS".equals(str) && !manifestPermissions.contains("android.permission.PROCESS_OUTGOING_CALLS")) {
                        throw new ManifestException("android.permission.PROCESS_OUTGOING_CALLS");
                    } else if ("android.permission.READ_PHONE_NUMBERS".equals(str) && !manifestPermissions.contains("android.permission.READ_PHONE_STATE")) {
                        throw new ManifestException("android.permission.READ_PHONE_STATE");
                    }
                }
                if (!"android.permission.ACCESS_NOTIFICATION_POLICY".equals(str) && !manifestPermissions.contains(str)) {
                    throw new ManifestException(str);
                }
            } else {
                throw new ManifestException("android.permission.BODY_SENSORS");
            }
        }
    }

    static void checkTargetSdkVersion(Context context, List<String> list) {
        int i;
        if (list.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
            i = 30;
        } else if (list.contains("android.permission.ACCEPT_HANDOVER")) {
            i = 28;
        } else {
            i = (list.contains("android.permission.ACCESS_BACKGROUND_LOCATION") || list.contains("android.permission.ACTIVITY_RECOGNITION") || list.contains("android.permission.ACCESS_MEDIA_LOCATION")) ? 29 : (list.contains("android.permission.REQUEST_INSTALL_PACKAGES") || list.contains("android.permission.ANSWER_PHONE_CALLS") || list.contains("android.permission.READ_PHONE_NUMBERS")) ? 26 : 23;
        }
        if (context.getApplicationInfo().targetSdkVersion < i) {
            throw new RuntimeException("The targetSdkVersion SDK must be " + i + " or more");
        }
    }

    static int getRandomRequestCode() {
        return new Random().nextInt((int) Math.pow(2.0d, 16.0d));
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0007  */
    static FragmentActivity getFragmentActivity(Context context) {
        while (!(context instanceof FragmentActivity)) {
            if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
            while (!(context instanceof FragmentActivity)) {
            }
        }
        return (FragmentActivity) context;
    }
}
