package com.hjq.permissions;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseBooleanArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;

public final class PermissionFragment extends Fragment {
    private static final String PERMISSION_GROUP = "permission_group";
    private static final String REQUEST_CODE = "request_code";
    private static SparseBooleanArray sRequestCodes = new SparseBooleanArray();
    private OnPermissionCallback mCallBack;
    private boolean mDangerousRequest;
    private boolean mSpecialRequest;

    public static void beginRequest(FragmentActivity fragmentActivity, ArrayList<String> arrayList, OnPermissionCallback onPermissionCallback) {
        int randomRequestCode;
        PermissionFragment permissionFragment = new PermissionFragment();
        Bundle bundle = new Bundle();
        do {
            randomRequestCode = PermissionUtils.getRandomRequestCode();
        } while (sRequestCodes.get(randomRequestCode));
        sRequestCodes.put(randomRequestCode, true);
        bundle.putInt("request_code", randomRequestCode);
        bundle.putStringArrayList("permission_group", arrayList);
        permissionFragment.setArguments(bundle);
        permissionFragment.setRetainInstance(true);
        permissionFragment.setCallBack(onPermissionCallback);
        addFragment(fragmentActivity.getSupportFragmentManager(), permissionFragment);
    }

    public static void addFragment(FragmentManager fragmentManager, Fragment fragment) {
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().add(fragment, fragment.toString()).commitAllowingStateLoss();
        }
    }

    public static void removeFragment(FragmentManager fragmentManager, Fragment fragment) {
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    public void setCallBack(OnPermissionCallback onPermissionCallback) {
        this.mCallBack = onPermissionCallback;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCallBack = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mSpecialRequest) {
            this.mSpecialRequest = true;
            if (this.mCallBack == null) {
                removeFragment(getFragmentManager(), this);
            } else {
                requestSpecialPermission();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.getStringArrayList("permission_group");
     */
    public void requestDangerousPermission() {
        final ArrayList<String> stringArrayList;
        Bundle arguments = getArguments();
        if (arguments != null && stringArrayList != null && stringArrayList.size() != 0) {
            ArrayList arrayList = null;
            if (PermissionUtils.isAndroid10() && stringArrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                arrayList = new ArrayList();
                if (stringArrayList.contains("android.permission.ACCESS_COARSE_LOCATION") && !PermissionUtils.isGrantedPermission(getActivity(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                }
                if (stringArrayList.contains("android.permission.ACCESS_FINE_LOCATION") && !PermissionUtils.isGrantedPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                requestPermissions((String[]) stringArrayList.toArray(new String[(stringArrayList.size() - 1)]), getArguments().getInt("request_code"));
                return;
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                beginRequest(activity, arrayList, new OnPermissionCallback() {
                    /* class com.hjq.permissions.PermissionFragment.AnonymousClass1 */

                    @Override // com.hjq.permissions.OnPermissionCallback
                    public void onGranted(List<String> list, boolean z) {
                        Bundle arguments;
                        if (z && PermissionFragment.this.isAdded() && (arguments = PermissionFragment.this.getArguments()) != null) {
                            PermissionFragment permissionFragment = PermissionFragment.this;
                            ArrayList arrayList = stringArrayList;
                            permissionFragment.requestPermissions((String[]) arrayList.toArray(new String[(arrayList.size() - 1)]), arguments.getInt("request_code"));
                        }
                    }

                    @Override // com.hjq.permissions.OnPermissionCallback
                    public void onDenied(List<String> list, boolean z) {
                        Bundle arguments;
                        if (PermissionFragment.this.isAdded() && (arguments = PermissionFragment.this.getArguments()) != null) {
                            PermissionFragment permissionFragment = PermissionFragment.this;
                            ArrayList arrayList = stringArrayList;
                            permissionFragment.requestPermissions((String[]) arrayList.toArray(new String[(arrayList.size() - 1)]), arguments.getInt("request_code"));
                        }
                    }
                });
            }
        }
    }

    public void requestSpecialPermission() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<String> stringArrayList = arguments.getStringArrayList("permission_group");
            boolean z = false;
            if (PermissionUtils.containsSpecialPermission(stringArrayList)) {
                if (stringArrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE") && !PermissionUtils.isGrantedStoragePermission(getActivity()) && PermissionUtils.isAndroid11()) {
                    startActivityForResult(PermissionSettingPage.getStoragePermissionIntent(getActivity()), getArguments().getInt("request_code"));
                    z = true;
                }
                if (stringArrayList.contains("android.permission.REQUEST_INSTALL_PACKAGES") && !PermissionUtils.isGrantedInstallPermission(getActivity())) {
                    startActivityForResult(PermissionSettingPage.getInstallPermissionIntent(getActivity()), getArguments().getInt("request_code"));
                    z = true;
                }
                if (stringArrayList.contains("android.permission.SYSTEM_ALERT_WINDOW") && !PermissionUtils.isGrantedWindowPermission(getActivity())) {
                    startActivityForResult(PermissionSettingPage.getWindowPermissionIntent(getActivity()), getArguments().getInt("request_code"));
                    z = true;
                }
                if (stringArrayList.contains("android.permission.ACCESS_NOTIFICATION_POLICY") && !PermissionUtils.isGrantedNotifyPermission(getActivity())) {
                    startActivityForResult(PermissionSettingPage.getNotifyPermissionIntent(getActivity()), getArguments().getInt("request_code"));
                    z = true;
                }
                if (stringArrayList.contains("android.permission.WRITE_SETTINGS") && !PermissionUtils.isGrantedSettingPermission(getActivity())) {
                    startActivityForResult(PermissionSettingPage.getSettingPermissionIntent(getActivity()), getArguments().getInt("request_code"));
                    z = true;
                }
            }
            if (!z) {
                requestDangerousPermission();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Bundle arguments = getArguments();
        if (arguments != null && i == arguments.getInt("request_code")) {
            OnPermissionCallback onPermissionCallback = this.mCallBack;
            this.mCallBack = null;
            if (onPermissionCallback != null) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String str = strArr[i2];
                    if (PermissionUtils.isSpecialPermission(str)) {
                        iArr[i2] = PermissionUtils.getPermissionStatus(getActivity(), str);
                    } else if (PermissionUtils.isAndroid11() && "android.permission.ACCESS_BACKGROUND_LOCATION".equals(str)) {
                        iArr[i2] = PermissionUtils.getPermissionStatus(getActivity(), str);
                    } else if (PermissionUtils.isAndroid10() || (!"android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) && !"android.permission.ACTIVITY_RECOGNITION".equals(str) && !"android.permission.ACCESS_MEDIA_LOCATION".equals(str))) {
                        if (!PermissionUtils.isAndroid9() && "android.permission.ACCEPT_HANDOVER".equals(str)) {
                            iArr[i2] = PermissionUtils.getPermissionStatus(getActivity(), str);
                        }
                        if (!PermissionUtils.isAndroid8() && ("android.permission.ANSWER_PHONE_CALLS".equals(str) || "android.permission.READ_PHONE_NUMBERS".equals(str))) {
                            iArr[i2] = PermissionUtils.getPermissionStatus(getActivity(), str);
                        }
                    } else {
                        iArr[i2] = PermissionUtils.getPermissionStatus(getActivity(), str);
                    }
                }
                sRequestCodes.delete(i);
                removeFragment(getFragmentManager(), this);
                List<String> grantedPermissions = PermissionUtils.getGrantedPermissions(strArr, iArr);
                if (grantedPermissions.size() == strArr.length) {
                    onPermissionCallback.onGranted(grantedPermissions, true);
                    return;
                }
                List<String> deniedPermissions = PermissionUtils.getDeniedPermissions(strArr, iArr);
                onPermissionCallback.onDenied(deniedPermissions, PermissionUtils.isPermissionPermanentDenied(getActivity(), deniedPermissions));
                if (!grantedPermissions.isEmpty()) {
                    onPermissionCallback.onGranted(grantedPermissions, false);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle arguments = getArguments();
        if (arguments != null && !this.mDangerousRequest && i == arguments.getInt("request_code")) {
            this.mDangerousRequest = true;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.hjq.permissions.PermissionFragment.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (PermissionFragment.this.isAdded()) {
                        PermissionFragment.this.requestDangerousPermission();
                    }
                }
            }, 300);
        }
    }
}
