package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

public final class XXPermissions {
    public static final int REQUEST_CODE = 1024;
    private static Boolean sDebugMode;
    private FragmentActivity mActivity;
    private List<String> mPermissions;

    public static XXPermissions with(FragmentActivity fragmentActivity) {
        return new XXPermissions(fragmentActivity);
    }

    public static XXPermissions with(Context context) {
        return with(PermissionUtils.getFragmentActivity(context));
    }

    public static XXPermissions with(Fragment fragment) {
        return with(fragment.getActivity());
    }

    public static void setDebugMode(boolean z) {
        sDebugMode = Boolean.valueOf(z);
    }

    private XXPermissions(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    public XXPermissions permission(String... strArr) {
        List<String> list = this.mPermissions;
        if (list == null) {
            this.mPermissions = PermissionUtils.asArrayList(strArr);
        } else {
            list.addAll(PermissionUtils.asArrayList(strArr));
        }
        return this;
    }

    public XXPermissions permission(String[]... strArr) {
        if (this.mPermissions == null) {
            int i = 0;
            for (String[] strArr2 : strArr) {
                i += strArr2.length;
            }
            this.mPermissions = new ArrayList(i);
        }
        for (String[] strArr3 : strArr) {
            this.mPermissions.addAll(PermissionUtils.asArrayList(strArr3));
        }
        return this;
    }

    public XXPermissions permission(List<String> list) {
        List<String> list2 = this.mPermissions;
        if (list2 == null) {
            this.mPermissions = list;
        } else {
            list2.addAll(list);
        }
        return this;
    }

    public void request(OnPermissionCallback onPermissionCallback) {
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            if (Build.VERSION.SDK_INT < 17 || !this.mActivity.isDestroyed()) {
                List<String> list = this.mPermissions;
                if (list == null || list.isEmpty()) {
                    throw new IllegalArgumentException("The requested permission cannot be empty");
                }
                if (sDebugMode == null) {
                    sDebugMode = Boolean.valueOf(PermissionUtils.isDebugMode(this.mActivity));
                }
                PermissionUtils.optimizeDeprecatedPermission(this.mPermissions);
                if (sDebugMode.booleanValue()) {
                    PermissionUtils.checkTargetSdkVersion(this.mActivity, this.mPermissions);
                    PermissionUtils.checkPermissionManifest(this.mActivity, this.mPermissions);
                }
                if (!PermissionUtils.isGrantedPermission(this.mActivity, this.mPermissions)) {
                    PermissionFragment.beginRequest(this.mActivity, new ArrayList(this.mPermissions), onPermissionCallback);
                } else if (onPermissionCallback != null) {
                    onPermissionCallback.onGranted(this.mPermissions, true);
                }
            }
        }
    }

    public static boolean isGrantedPermission(Context context, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return isGrantedPermission(context, PermissionUtils.getManifestPermissions(context));
        }
        return isGrantedPermission(context, PermissionUtils.asArrayList(strArr));
    }

    public static boolean isGrantedPermission(Context context, List<String> list) {
        return PermissionUtils.isGrantedPermission(context, list);
    }

    public static boolean isGrantedPermission(Context context, String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            arrayList.addAll(PermissionUtils.asArrayList(strArr2));
        }
        return PermissionUtils.isGrantedPermission(context, arrayList);
    }

    public static void startApplicationDetails(Context context) {
        FragmentActivity fragmentActivity = PermissionUtils.getFragmentActivity(context);
        if (fragmentActivity != null) {
            startApplicationDetails((Activity) fragmentActivity);
            return;
        }
        Intent applicationDetailsIntent = PermissionSettingPage.getApplicationDetailsIntent(context);
        applicationDetailsIntent.addFlags(268435456);
        context.startActivity(applicationDetailsIntent);
    }

    public static void startApplicationDetails(Activity activity) {
        activity.startActivityForResult(PermissionSettingPage.getApplicationDetailsIntent(activity), 1024);
    }

    public static void startApplicationDetails(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            fragment.startActivityForResult(PermissionSettingPage.getApplicationDetailsIntent(activity), 1024);
        }
    }

    public static void startPermissionActivity(Context context, String... strArr) {
        startPermissionActivity(context, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(Context context, List<String> list) {
        FragmentActivity fragmentActivity = PermissionUtils.getFragmentActivity(context);
        if (fragmentActivity != null) {
            startPermissionActivity((Activity) fragmentActivity, list);
            return;
        }
        Intent smartPermissionIntent = PermissionSettingPage.getSmartPermissionIntent(context, list);
        smartPermissionIntent.addFlags(268435456);
        context.startActivity(smartPermissionIntent);
    }

    public static void startPermissionActivity(Activity activity, String... strArr) {
        startPermissionActivity(activity, (List<String>) PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(Activity activity, List<String> list) {
        activity.startActivityForResult(PermissionSettingPage.getSmartPermissionIntent(activity, list), 1024);
    }

    public static void startPermissionActivity(Fragment fragment, String... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(Fragment fragment, List<String> list) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            fragment.startActivityForResult(PermissionSettingPage.getSmartPermissionIntent(activity, list), 1024);
        }
    }
}
