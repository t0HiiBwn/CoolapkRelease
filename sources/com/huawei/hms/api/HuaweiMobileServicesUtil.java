package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;

public abstract class HuaweiMobileServicesUtil {
    public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return "";
    }

    public static int isHuaweiMobileServicesAvailable(Context context, int i) {
        Checker.checkNonNull(context, "context must not be null.");
        if (Build.VERSION.SDK_INT < 16) {
            return 21;
        }
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        String hMSPackageName = HMSPackageManager.getInstance(context).getHMSPackageName();
        HMSLog.i("HuaweiMobileServicesUtil", "hmsPackageName is " + hMSPackageName);
        PackageManagerHelper.PackageStates packageStates = packageManagerHelper.getPackageStates(hMSPackageName);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates)) {
            HMSLog.i("HuaweiMobileServicesUtil", "HMS is not installed");
            return 1;
        } else if (PackageManagerHelper.PackageStates.DISABLED.equals(packageStates)) {
            HMSLog.i("HuaweiMobileServicesUtil", "HMS is disabled");
            return 3;
        } else {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(HMSPackageManager.getInstance(context).getHMSPackageStates())) {
                String packageSignature = packageManagerHelper.getPackageSignature(hMSPackageName);
                if (!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(packageSignature) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature)) {
                    return 9;
                }
            }
            int hmsVersionCode = HMSPackageManager.getInstance(context).getHmsVersionCode();
            HMSLog.i("HuaweiMobileServicesUtil", "connect versionCode:" + hmsVersionCode);
            if (!HMSPackageManager.getInstance(context).isApkUpdateNecessary(i)) {
                return 0;
            }
            HMSLog.i("HuaweiMobileServicesUtil", "The current version does not meet the minimum version requirements");
            return 2;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(HMSPackageManager.getInstance(context).getHMSPackageName());
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(HMSPackageManager.getInstance(context).getHMSPackageName(), 2);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(activity, i, i2, null);
    }

    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }

    public static String getErrorString(int i) {
        return HuaweiApiAvailability.getInstance().getErrorString(i);
    }

    public static int isHuaweiMobileServicesAvailable(Context context) {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
    }

    public static boolean isUserRecoverableError(int i) {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(i);
    }

    public static boolean popupErrDlgFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, i2, onCancelListener);
    }

    public static boolean popupErrDlgFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, fragment, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, i2, null);
    }

    public static void showErrorNotification(int i, Context context) {
        HuaweiApiAvailability.getInstance().showErrorNotification(context, i);
    }

    public static void setApplication(Application application) {
        ActivityMgr.INST.init(application);
    }
}
