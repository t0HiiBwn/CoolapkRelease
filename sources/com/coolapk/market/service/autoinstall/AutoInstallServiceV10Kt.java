package com.coolapk.market.service.autoinstall;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t*\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\t*\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u000e"}, d2 = {"isInstallProcess", "", "Landroid/view/accessibility/AccessibilityEvent;", "(Landroid/view/accessibility/AccessibilityEvent;)Z", "isUninstallProcess", "getAppName", "", "Landroid/accessibilityservice/AccessibilityService;", "getDoneButtonNodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "event", "getInstallButtonNodeInfo", "getNextButtonNodeInfo", "getUninstallButtonNodeInfo", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: AutoInstallServiceV10.kt */
public final class AutoInstallServiceV10Kt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static final boolean isInstallProcess(AccessibilityEvent accessibilityEvent) {
        Intrinsics.checkNotNullParameter(accessibilityEvent, "$this$isInstallProcess");
        String classNameString = AutoInstallUtilKt.getClassNameString(accessibilityEvent);
        switch (classNameString.hashCode()) {
            case -1510049100:
                return classNameString.equals("android.app.Dialog");
            case -1189358456:
                if (classNameString.equals("com.android.packageinstaller.InstallSuccess")) {
                }
                break;
            case -540946063:
                if (classNameString.equals("com.android.packageinstaller.OppoPackageInstallerActivity")) {
                }
                break;
            case 77378993:
                if (classNameString.equals("com.android.packageinstaller.PackageInstallerActivity")) {
                }
                break;
            case 713346194:
                if (classNameString.equals("com.android.packageinstaller.OPPackageInstallerActivity")) {
                }
                break;
        }
    }

    public static final boolean isUninstallProcess(AccessibilityEvent accessibilityEvent) {
        Intrinsics.checkNotNullParameter(accessibilityEvent, "$this$isUninstallProcess");
        String classNameString = AutoInstallUtilKt.getClassNameString(accessibilityEvent);
        int hashCode = classNameString.hashCode();
        return hashCode == -93394274 ? classNameString.equals("com.android.packageinstaller.UninstallerActivity") : !(hashCode != 1399744852 || !classNameString.equals("com.android.packageinstaller.UninstallerActivity2"));
    }

    public static final String getAppName(AccessibilityService accessibilityService) {
        String str;
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$getAppName");
        AutoInstallServiceV10Kt$getAppName$1 autoInstallServiceV10Kt$getAppName$1 = new AutoInstallServiceV10Kt$getAppName$1(accessibilityService);
        AccessibilityNodeInfo nodeInfoById = AutoInstallUtilKt.getNodeInfoById(accessibilityService, null, "com.android.packageinstaller:id/app_name");
        if (nodeInfoById == null || (str = autoInstallServiceV10Kt$getAppName$1.invoke(nodeInfoById, accessibilityService)) == null) {
            AccessibilityNodeInfo nodeInfoById2 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, null, "android:id/alertTitle");
            str = nodeInfoById2 != null ? autoInstallServiceV10Kt$getAppName$1.invoke(nodeInfoById2, accessibilityService) : null;
        }
        if (str == null) {
            AccessibilityNodeInfo nodeInfoById3 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, null, "com.android.packageinstaller:id/alertTitle");
            str = nodeInfoById3 != null ? autoInstallServiceV10Kt$getAppName$1.invoke(nodeInfoById3, accessibilityService) : null;
        }
        if (str != null) {
            return str;
        }
        AccessibilityNodeInfo nodeInfoById4 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, null, "com.android.packageinstaller:id/uninstall_title");
        if (nodeInfoById4 != null) {
            return autoInstallServiceV10Kt$getAppName$1.invoke(nodeInfoById4, accessibilityService);
        }
        return null;
    }

    public static final AccessibilityNodeInfo getNextButtonNodeInfo(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$getNextButtonNodeInfo");
        AutoInstallServiceV10Kt$getNextButtonNodeInfo$1 autoInstallServiceV10Kt$getNextButtonNodeInfo$1 = AutoInstallServiceV10Kt$getNextButtonNodeInfo$1.INSTANCE;
        AccessibilityNodeInfo nodeInfoById = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "com.android.packageinstaller:id/ok_button");
        if (nodeInfoById != null) {
            return autoInstallServiceV10Kt$getNextButtonNodeInfo$1.invoke(nodeInfoById, accessibilityService);
        }
        return null;
    }

    public static final AccessibilityNodeInfo getInstallButtonNodeInfo(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$getInstallButtonNodeInfo");
        AutoInstallServiceV10Kt$getInstallButtonNodeInfo$1 autoInstallServiceV10Kt$getInstallButtonNodeInfo$1 = AutoInstallServiceV10Kt$getInstallButtonNodeInfo$1.INSTANCE;
        AccessibilityNodeInfo nodeInfoById = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "android:id/button1");
        if (nodeInfoById == null || (accessibilityNodeInfo = autoInstallServiceV10Kt$getInstallButtonNodeInfo$1.invoke(nodeInfoById, accessibilityService)) == null) {
            AccessibilityNodeInfo nodeInfoById2 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "com.android.packageinstaller:id/ok_button");
            accessibilityNodeInfo = nodeInfoById2 != null ? autoInstallServiceV10Kt$getInstallButtonNodeInfo$1.invoke(nodeInfoById2, accessibilityService) : null;
        }
        if (accessibilityNodeInfo == null) {
            AccessibilityNodeInfo nodeInfoById3 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "com.android.packageinstaller:id/right_button");
            accessibilityNodeInfo = nodeInfoById3 != null ? autoInstallServiceV10Kt$getInstallButtonNodeInfo$1.invoke(nodeInfoById3, accessibilityService) : null;
        }
        if (accessibilityNodeInfo != null) {
            return accessibilityNodeInfo;
        }
        AccessibilityNodeInfo nodeInfoById4 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "com.android.packageinstaller:id/left_button");
        if (nodeInfoById4 != null) {
            return autoInstallServiceV10Kt$getInstallButtonNodeInfo$1.invoke(nodeInfoById4, accessibilityService);
        }
        return null;
    }

    public static final AccessibilityNodeInfo getDoneButtonNodeInfo(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo invoke;
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$getDoneButtonNodeInfo");
        AutoInstallServiceV10Kt$getDoneButtonNodeInfo$1 autoInstallServiceV10Kt$getDoneButtonNodeInfo$1 = AutoInstallServiceV10Kt$getDoneButtonNodeInfo$1.INSTANCE;
        AccessibilityNodeInfo nodeInfoById = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "com.android.packageinstaller:id/done_button");
        if (nodeInfoById != null && (invoke = autoInstallServiceV10Kt$getDoneButtonNodeInfo$1.invoke(nodeInfoById, accessibilityService)) != null) {
            return invoke;
        }
        AccessibilityNodeInfo nodeInfoById2 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "android:id/button2");
        if (nodeInfoById2 != null) {
            return autoInstallServiceV10Kt$getDoneButtonNodeInfo$1.invoke(nodeInfoById2, accessibilityService);
        }
        return null;
    }

    public static final AccessibilityNodeInfo getUninstallButtonNodeInfo(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$getUninstallButtonNodeInfo");
        AutoInstallServiceV10Kt$getUninstallButtonNodeInfo$1 autoInstallServiceV10Kt$getUninstallButtonNodeInfo$1 = AutoInstallServiceV10Kt$getUninstallButtonNodeInfo$1.INSTANCE;
        AccessibilityNodeInfo nodeInfoById = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "android:id/button1");
        if (nodeInfoById == null || (accessibilityNodeInfo = autoInstallServiceV10Kt$getUninstallButtonNodeInfo$1.invoke(nodeInfoById, accessibilityService)) == null) {
            AccessibilityNodeInfo nodeInfoById2 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "com.android.packageinstaller:id/ok_button");
            accessibilityNodeInfo = nodeInfoById2 != null ? autoInstallServiceV10Kt$getUninstallButtonNodeInfo$1.invoke(nodeInfoById2, accessibilityService) : null;
        }
        if (accessibilityNodeInfo != null) {
            return accessibilityNodeInfo;
        }
        AccessibilityNodeInfo nodeInfoById3 = AutoInstallUtilKt.getNodeInfoById(accessibilityService, accessibilityEvent, "com.android.packageinstaller:id/positive");
        if (nodeInfoById3 != null) {
            return autoInstallServiceV10Kt$getUninstallButtonNodeInfo$1.invoke(nodeInfoById3, accessibilityService);
        }
        return null;
    }
}
