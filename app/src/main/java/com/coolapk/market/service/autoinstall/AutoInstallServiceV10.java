package com.coolapk.market.service.autoinstall;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/service/autoinstall/AutoInstallServiceV10;", "Landroid/accessibilityservice/AccessibilityService;", "()V", "canHandlerNext", "", "onAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInterrupt", "onServiceConnected", "onUnbind", "intent", "Landroid/content/Intent;", "shouldHandleInstallProcess", "appName", "", "shouldHandleUninstallProcess", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AutoInstallServiceV10.kt */
public final class AutoInstallServiceV10 extends AccessibilityService {
    private boolean canHandlerNext;

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        AutoInstallUtilKt.autoInstallLogD("onUnbind", new Object[0]);
        return super.onUnbind(intent);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        AutoInstallUtilKt.autoInstallLogD("onInterrupt", new Object[0]);
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        AutoInstallSetting.setInvokeGlobal(DataManager.getInstance().getPreferencesBoolean("global_auto_install_accessibility_service", false));
        AccessibilityServiceInfo serviceInfo = getServiceInfo();
        serviceInfo.eventTypes = 6176;
        serviceInfo.packageNames = new String[]{"com.android.packageinstaller", "com.samsung.android.packageinstaller", "com.google.android.packageinstaller"};
        setServiceInfo(serviceInfo);
        AutoInstallUtilKt.autoInstallLogD("onServiceConnected", new Object[0]);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Intrinsics.checkNotNullParameter(accessibilityEvent, "event");
        AutoInstallUtilKt.autoInstallLogD("onAccessibilityEvent " + accessibilityEvent, new Object[0]);
        String appName = AutoInstallServiceV10Kt.getAppName(this);
        if (appName != null) {
            int eventType = accessibilityEvent.getEventType();
            if (eventType != 32) {
                if ((eventType == 2048 || eventType == 4096) && this.canHandlerNext) {
                    AccessibilityNodeInfo nextButtonNodeInfo = AutoInstallServiceV10Kt.getNextButtonNodeInfo(this, accessibilityEvent);
                    if (nextButtonNodeInfo == null || !AutoInstallUtilKt.performClick(nextButtonNodeInfo)) {
                        AccessibilityNodeInfo installButtonNodeInfo = AutoInstallServiceV10Kt.getInstallButtonNodeInfo(this, accessibilityEvent);
                        if (installButtonNodeInfo == null || !AutoInstallUtilKt.performClick(installButtonNodeInfo)) {
                            AccessibilityNodeInfo doneButtonNodeInfo = AutoInstallServiceV10Kt.getDoneButtonNodeInfo(this, accessibilityEvent);
                            if (doneButtonNodeInfo == null || !AutoInstallUtilKt.performClick(doneButtonNodeInfo)) {
                                AccessibilityNodeInfo uninstallButtonNodeInfo = AutoInstallServiceV10Kt.getUninstallButtonNodeInfo(this, accessibilityEvent);
                                if (uninstallButtonNodeInfo != null && AutoInstallUtilKt.performClick(uninstallButtonNodeInfo)) {
                                    AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击卸载", new Object[0]);
                                    AutoInstallSetting.INSTANCE.removeFromUninstallPackageList(appName);
                                    return;
                                }
                                return;
                            }
                            AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击完成", new Object[0]);
                            AutoInstallSetting.INSTANCE.removeFromInstallPackageList(appName);
                            return;
                        }
                        AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击安装", new Object[0]);
                        return;
                    }
                    AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击下一步", new Object[0]);
                }
            } else if (AutoInstallServiceV10Kt.isInstallProcess(accessibilityEvent)) {
                AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 进入安装流程", new Object[0]);
                if (!shouldHandleInstallProcess(appName)) {
                    AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 不处理该安装流程", new Object[0]);
                    this.canHandlerNext = false;
                    return;
                }
                this.canHandlerNext = true;
                AccessibilityNodeInfo nextButtonNodeInfo2 = AutoInstallServiceV10Kt.getNextButtonNodeInfo(this, null);
                if (nextButtonNodeInfo2 == null || !AutoInstallUtilKt.performClick(nextButtonNodeInfo2)) {
                    AccessibilityNodeInfo installButtonNodeInfo2 = AutoInstallServiceV10Kt.getInstallButtonNodeInfo(this, null);
                    if (installButtonNodeInfo2 == null || !AutoInstallUtilKt.performClick(installButtonNodeInfo2)) {
                        AccessibilityNodeInfo doneButtonNodeInfo2 = AutoInstallServiceV10Kt.getDoneButtonNodeInfo(this, null);
                        if (doneButtonNodeInfo2 != null && AutoInstallUtilKt.performClick(doneButtonNodeInfo2)) {
                            AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击完成", new Object[0]);
                            AutoInstallSetting.INSTANCE.removeFromInstallPackageList(appName);
                            return;
                        }
                        return;
                    }
                    AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击安装", new Object[0]);
                    return;
                }
                AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击下一步", new Object[0]);
            } else if (AutoInstallServiceV10Kt.isUninstallProcess(accessibilityEvent)) {
                AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 进入卸载流程", new Object[0]);
                if (!shouldHandleUninstallProcess(appName)) {
                    AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 不处理该卸载流程", new Object[0]);
                    this.canHandlerNext = false;
                    return;
                }
                this.canHandlerNext = true;
                AccessibilityNodeInfo uninstallButtonNodeInfo2 = AutoInstallServiceV10Kt.getUninstallButtonNodeInfo(this, null);
                if (uninstallButtonNodeInfo2 != null && AutoInstallUtilKt.performClick(uninstallButtonNodeInfo2)) {
                    AutoInstallUtilKt.autoInstallLogD('[' + appName + "] 点击卸载", new Object[0]);
                    AutoInstallSetting.INSTANCE.removeFromUninstallPackageList(appName);
                }
            }
        }
    }

    private final boolean shouldHandleInstallProcess(String str) {
        return AutoInstallSetting.getInvokeGlobal() || AutoInstallSetting.getInstallPackageList().contains(str);
    }

    private final boolean shouldHandleUninstallProcess(String str) {
        return AutoInstallSetting.getInvokeGlobal() || AutoInstallSetting.getUninstallPackageList().contains(str);
    }
}
