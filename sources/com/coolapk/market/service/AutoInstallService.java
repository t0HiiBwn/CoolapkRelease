package com.coolapk.market.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.coolapk.market.manager.DataManager;
import java.util.ArrayList;
import java.util.List;

public class AutoInstallService extends AccessibilityService {
    private static final String CLASS_NAME_APP_ALERT_DIALOG = "android.app.AlertDialog";
    private static final String CLASS_NAME_GOOGLE_PACKAGE_INSTALLER = "com.google.android.packageinstaller";
    private static final String CLASS_NAME_LENOVO_SAFECENTER = "com.lenovo.safecenter";
    private static final String CLASS_NAME_PACKAGE_INSTALLER = "com.android.packageinstaller";
    private static final String CLASS_NAME_PACKAGE_INSTALLER_ACTIVITY = "com.android.packageinstaller.PackageInstallerActivity";
    private static final String CLASS_NAME_PACKAGE_INSTALLER_PERMSEDITOR = "com.android.packageinstaller.PackageInstallerPermsEditor";
    private static final String CLASS_NAME_PACKAGE_INSTALLER_PROGRESS = "com.android.packageinstaller.InstallAppProgress";
    private static final String CLASS_NAME_PACKAGE_UNINSTALLER_ACTIVITY = "com.android.packageinstaller.UninstallerActivity";
    private static final String CLASS_NAME_PACKAGE_UNINSTALLER_PROGRESS = "com.android.packageinstaller.UninstallAppProgress";
    private static final String CLASS_NAME_SAMSUNG_PACKAGE_INSTALLER = "com.samsung.android.packageinstaller";
    private static final String CLASS_NAME_WIDGET_BUTTON = "android.widget.Button";
    private static final String CLASS_NAME_WIDGET_LISTVIEW = "android.widget.ListView";
    private static final String CLASS_NAME_WIDGET_TEXTVIEW = "android.widget.TextView";
    private static boolean INVOKE_ENABLED;
    private static boolean INVOKE_GLOBAL;
    private static List<String> mInstallPackageList = new ArrayList();
    private static List<String> mUninstallPackageList = new ArrayList();
    private long lastPerformBackTime = -1;

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        INVOKE_GLOBAL = DataManager.getInstance().getPreferencesBoolean("global_auto_install_accessibility_service", false);
        AccessibilityServiceInfo serviceInfo = getServiceInfo();
        serviceInfo.packageNames = new String[]{"com.google.android.packageinstaller", "com.android.packageinstaller", "com.lenovo.safecenter", "com.samsung.android.packageinstaller"};
        setServiceInfo(serviceInfo);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (INVOKE_ENABLED || INVOKE_GLOBAL) {
            try {
                onEventProcess(accessibilityEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onEventProcess(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getSource() != null) {
            String charSequence = accessibilityEvent.getPackageName().toString();
            String charSequence2 = accessibilityEvent.getClassName().toString();
            String trim = accessibilityEvent.getSource().getText() == null ? "" : accessibilityEvent.getSource().getText().toString().trim();
            charSequence.hashCode();
            char c = 65535;
            switch (charSequence.hashCode()) {
                case -1486017904:
                    if (charSequence.equals("com.lenovo.safecenter")) {
                        c = 0;
                        break;
                    }
                    break;
                case -472626718:
                    if (charSequence.equals("com.samsung.android.packageinstaller")) {
                        c = 1;
                        break;
                    }
                    break;
                case 307846473:
                    if (charSequence.equals("com.google.android.packageinstaller")) {
                        c = 2;
                        break;
                    }
                    break;
                case 394871662:
                    if (charSequence.equals("com.android.packageinstaller")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (isAppInstallEvent(charSequence2, trim)) {
                        onAppInstall();
                        return;
                    } else if (hasNodeInfoByText(2131886622)) {
                        onAppInstalled();
                        return;
                    } else if (hasNodeInfoByText(2131886625)) {
                        onAppUninstalled();
                        return;
                    } else if (hasNodeInfoByText(2131886623)) {
                        onAppUninstall();
                        return;
                    } else {
                        return;
                    }
                case 1:
                case 2:
                case 3:
                    if (isAppInstalledEvent(null, trim)) {
                        onAppInstalled();
                        return;
                    } else if (isAppInstallEvent(charSequence2, trim)) {
                        onAppInstall();
                        return;
                    } else if (isAppUninstalledEvent()) {
                        onAppUninstalled();
                        return;
                    } else if (isAppUninstallEvent(charSequence2, trim)) {
                        onAppUninstall();
                        return;
                    } else if (isAppReplaceEvent(charSequence2, trim)) {
                        onAppReplaceEvent();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private boolean isAppReplaceEvent(String str, String str2) {
        return str2.contains(getString(2131886331)) || hasNodeInfoByText(2131886331);
    }

    private void onAppReplaceEvent() {
        findAndClickNode(2131886292);
    }

    private boolean isAppInstallEvent(String str, String str2) {
        return str.equalsIgnoreCase("com.android.packageinstaller.PackageInstallerActivity") || str2.contains(getString(2131886289)) || hasIdenticalNodeInfoByText(2131886289);
    }

    private void onAppInstall() {
        if (INVOKE_GLOBAL || getValidNodeInfo(mInstallPackageList) != null) {
            findAndClickNode(2131886289, 2131886292, 2131886285, 2131886291);
        }
    }

    private boolean isAppInstalledEvent(String str, String str2) {
        return str2.equalsIgnoreCase(getString(2131886293)) || str2.equalsIgnoreCase(getString(2131886294)) || str2.contains(getString(2131886620)) || str2.contains(getString(2131886621)) || str2.contains(getString(2131886622)) || hasNodeInfoByText(2131886620) || hasNodeInfoByText(2131886621) || hasNodeInfoByText(2131886622);
    }

    private void onAppInstalled() {
        AccessibilityNodeInfo accessibilityNodeInfo;
        if (!INVOKE_GLOBAL) {
            accessibilityNodeInfo = getValidNodeInfo(mInstallPackageList);
            if (accessibilityNodeInfo == null) {
                return;
            }
        } else {
            accessibilityNodeInfo = null;
        }
        boolean findAndClickNode = findAndClickNode(2131886292, 2131886288, 2131886286, 2131886290);
        if (!findAndClickNode) {
            findAndClickNode = findAndPerformBack(2131886294, 2131886293);
        }
        if (findAndClickNode && mInstallPackageList != null && accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null) {
            mInstallPackageList.remove(accessibilityNodeInfo.getText().toString());
        }
    }

    private boolean isAppUninstallEvent(String str, String str2) {
        return str.equalsIgnoreCase("com.android.packageinstaller.UninstallerActivity") || str2.contains(getString(2131886623)) || str.equalsIgnoreCase("android.app.AlertDialog") || hasNodeInfoByText(2131886623);
    }

    private void onAppUninstall() {
        if (INVOKE_GLOBAL || getValidNodeInfo(mUninstallPackageList) != null) {
            findAndClickNode(2131886295, 2131886292);
        }
    }

    private boolean isAppUninstalledEvent() {
        return hasNodeInfoByText(2131886625, 2131886626, 2131886627);
    }

    private void onAppUninstalled() {
        AccessibilityNodeInfo accessibilityNodeInfo;
        if (!INVOKE_GLOBAL) {
            accessibilityNodeInfo = getValidNodeInfo(mInstallPackageList);
            if (accessibilityNodeInfo == null) {
                return;
            }
        } else {
            accessibilityNodeInfo = null;
        }
        if (findAndClickNode(2131886290, 2131886292) && mUninstallPackageList != null && accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null) {
            mUninstallPackageList.remove(accessibilityNodeInfo.getText().toString());
        }
    }

    private void processAlertDialogEvent(AccessibilityEvent accessibilityEvent, String str) {
        AccessibilityNodeInfo nodeInfoByText = getNodeInfoByText(accessibilityEvent, "android.widget.Button", str);
        if (nodeInfoByText != null) {
            performClick(nodeInfoByText);
        }
    }

    private void processAlertDialogEvent(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo nodeInfoByText = getNodeInfoByText(accessibilityEvent, "android.widget.Button", 2131886292);
        if (nodeInfoByText != null) {
            performClick(nodeInfoByText);
        }
    }

    private boolean hasIdenticalNodeInfoByText(int i) {
        return hasIdenticalNodeInfoByText(getString(i));
    }

    private boolean hasIdenticalNodeInfoByText(String str) {
        return getNodeInfoByText(null, null, str) != null;
    }

    private boolean hasNodeInfoByText(int... iArr) {
        for (int i : iArr) {
            if (hasNodeInfoByText(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNodeInfoByText(int i) {
        return hasNodeInfoByText(getString(i));
    }

    private boolean hasNodeInfoByText(String str) {
        return hasNodeInfoByText(null, str);
    }

    private boolean hasNodeInfoByText(AccessibilityEvent accessibilityEvent, String str) {
        if (accessibilityEvent == null || accessibilityEvent.getSource() == null) {
            List<AccessibilityNodeInfo> list = null;
            AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
            if (rootInActiveWindow != null) {
                list = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
                rootInActiveWindow.recycle();
            }
            if (list == null || list.size() <= 0) {
                return false;
            }
            return true;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = accessibilityEvent.getSource().findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText == null || findAccessibilityNodeInfosByText.size() <= 0) {
            return false;
        }
        return true;
    }

    private AccessibilityNodeInfo getValidNodeInfo(List<String> list) {
        if (list != null && list.size() > 0) {
            for (String str : list) {
                AccessibilityNodeInfo nodeInfoByText = getNodeInfoByText((AccessibilityEvent) null, "android.widget.TextView", str);
                if (nodeInfoByText != null) {
                    return nodeInfoByText;
                }
            }
        }
        return null;
    }

    private boolean performClick(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo != null && accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.performAction(16);
    }

    private boolean performBack() {
        boolean performGlobalAction = System.currentTimeMillis() - this.lastPerformBackTime > 500 ? performGlobalAction(1) : false;
        if (performGlobalAction) {
            this.lastPerformBackTime = System.currentTimeMillis();
        }
        return performGlobalAction;
    }

    private boolean findAndClickNode(int... iArr) {
        for (int i : iArr) {
            if (performClick(getNodeInfoByText(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean findAndPerformBack(int... iArr) {
        boolean z = false;
        for (int i : iArr) {
            AccessibilityNodeInfo nodeInfoByText = getNodeInfoByText(i);
            if (nodeInfoByText != null && nodeInfoByText.isEnabled()) {
                z = performBack();
                nodeInfoByText.recycle();
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private AccessibilityNodeInfo getNodeInfoByText(AccessibilityEvent accessibilityEvent, String str, String str2) {
        List<AccessibilityNodeInfo> list;
        if (accessibilityEvent == null || accessibilityEvent.getSource() == null) {
            AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
            list = rootInActiveWindow != null ? rootInActiveWindow.findAccessibilityNodeInfosByText(str2) : null;
        } else {
            list = accessibilityEvent.getSource().findAccessibilityNodeInfosByText(str2);
        }
        if (list != null && list.size() > 0) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : list) {
                String charSequence = accessibilityNodeInfo.getText() == null ? "" : accessibilityNodeInfo.getText().toString();
                if ((str == null || accessibilityNodeInfo.getClassName().equals(str)) && charSequence.equalsIgnoreCase(str2)) {
                    return accessibilityNodeInfo;
                }
                accessibilityNodeInfo.recycle();
            }
        }
        return null;
    }

    private AccessibilityNodeInfo getNodeInfoByText(AccessibilityEvent accessibilityEvent, String str, int i) {
        return getNodeInfoByText(accessibilityEvent, str, getString(i));
    }

    private AccessibilityNodeInfo getNodeInfoByText(String str) {
        return getNodeInfoByText((AccessibilityEvent) null, (String) null, str);
    }

    private AccessibilityNodeInfo getNodeInfoByText(int i) {
        return getNodeInfoByText((AccessibilityEvent) null, (String) null, i);
    }

    public static void invokeInstallApplication(String str) {
        INVOKE_ENABLED = true;
        if (str != null && !mInstallPackageList.contains(str)) {
            mInstallPackageList.add(str);
        }
    }

    public static void invokeUninstallApplication(String str) {
        INVOKE_ENABLED = true;
        if (str != null && !mUninstallPackageList.contains(str)) {
            mUninstallPackageList.add(str);
        }
    }

    public static void reset() {
        INVOKE_ENABLED = false;
        List<String> list = mInstallPackageList;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = mUninstallPackageList;
        if (list2 != null) {
            list2.clear();
        }
    }

    public static boolean isInvokeGlobal() {
        return INVOKE_GLOBAL;
    }

    public static void setInvokeGlobal(boolean z) {
        INVOKE_GLOBAL = z;
    }
}
