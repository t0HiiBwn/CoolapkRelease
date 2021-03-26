package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class AGCUtils {
    public static String getAppId(Context context) {
        if (a(context)) {
            return a(context, "client/app_id");
        }
        String str = null;
        try {
            str = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return b(context);
    }

    public static String getCpId(Context context) {
        if (a(context)) {
            return a(context, "client/cp_id");
        }
        String str = null;
        try {
            str = AGConnectServicesConfig.fromContext(context).getString("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return c(context);
    }

    private static boolean a(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    private static String a(Context context, String str) {
        String str2;
        AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("agconnect-services.json");
            fromContext.overlayWith(inputStream);
            str2 = fromContext.getString(str);
            IOUtils.closeQuietly(inputStream);
        } catch (IOException e) {
            HMSLog.e("AGCUtils", "Get " + str + " failed: " + e);
        } catch (NullPointerException e2) {
            HMSLog.e("AGCUtils", "Get " + str + " with AGConnectServicesConfig failed: " + e2);
        } catch (Throwable th) {
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        HMSLog.e("AGCUtils", "The " + str + " is null.");
        return "";
        IOUtils.closeQuietly(inputStream);
        str2 = "";
        if (TextUtils.isEmpty(str2)) {
        }
    }

    private static String b(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("com.huawei.hms.client.appid")) == null) {
                HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        }
    }

    private static String c(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("com.huawei.hms.client.cpid")) == null) {
                HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        }
    }
}
