package com.coolapk.market.service.autoinstall;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.coolapk.market.util.LogUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u001a'\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00012\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020<0;\"\u00020<¢\u0006\u0002\u0010=\u001a'\u0010>\u001a\u0002082\u0006\u00109\u001a\u00020\u00012\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020<0;\"\u00020<¢\u0006\u0002\u0010=\u001a'\u0010?\u001a\u0002082\u0006\u00109\u001a\u00020\u00012\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020<0;\"\u00020<¢\u0006\u0002\u0010=\u001a\u001e\u0010@\u001a\u0004\u0018\u00010**\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010\u001a2\u0006\u0010B\u001a\u00020\u0001\u001a\n\u0010C\u001a\u00020D*\u00020*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004\"\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004\"\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004\"\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\"\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c\"\u0015\u0010\u001f\u001a\u00020\u0001*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b \u0010\u001c\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004\"\u0015\u0010#\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b$\u0010\u0004\"\u0015\u0010%\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b&\u0010\u0004\"\u0015\u0010'\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u0004\"\u0015\u0010)\u001a\u00020\u0001*\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0015\u0010-\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010\u0004\"\u0015\u0010/\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u0010\u0004\"\u0015\u00101\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b2\u0010\u0004\"\u0015\u00103\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\u0004\"\u0015\u00105\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b6\u0010\u0004¨\u0006E"}, d2 = {"btnTextAllowOnce", "", "Landroid/accessibilityservice/AccessibilityService;", "getBtnTextAllowOnce", "(Landroid/accessibilityservice/AccessibilityService;)Ljava/lang/String;", "btnTextComplete", "getBtnTextComplete", "btnTextContinueInstall", "getBtnTextContinueInstall", "btnTextDone", "getBtnTextDone", "btnTextInstall", "getBtnTextInstall", "btnTextKnow", "getBtnTextKnow", "btnTextNext", "getBtnTextNext", "btnTextOk", "getBtnTextOk", "btnTextOpen", "getBtnTextOpen", "btnTextRun", "getBtnTextRun", "btnTextUninstall", "getBtnTextUninstall", "classNameString", "Landroid/view/accessibility/AccessibilityEvent;", "getClassNameString", "(Landroid/view/accessibility/AccessibilityEvent;)Ljava/lang/String;", "packageNameString", "getPackageNameString", "sourceTextString", "getSourceTextString", "textDialogReplaceTitle", "getTextDialogReplaceTitle", "textInstalled", "getTextInstalled", "textInstalled2", "getTextInstalled2", "textInstalled3", "getTextInstalled3", "textString", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getTextString", "(Landroid/view/accessibility/AccessibilityNodeInfo;)Ljava/lang/String;", "textUninstall", "getTextUninstall", "textUninstallTitle", "getTextUninstallTitle", "textUninstalled", "getTextUninstalled", "textUninstalled2", "getTextUninstalled2", "textUninstalled3", "getTextUninstalled3", "autoInstallLogD", "", "message", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "autoInstallLogI", "autoInstallLogW", "getNodeInfoById", "event", "id", "performClick", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: AutoInstallUtil.kt */
public final class AutoInstallUtilKt {
    public static final void autoInstallLogD(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(objArr, "args");
        LogUtils.d(str, Arrays.copyOf(objArr, objArr.length));
    }

    public static final void autoInstallLogI(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(objArr, "args");
        LogUtils.i(str, Arrays.copyOf(objArr, objArr.length));
    }

    public static final void autoInstallLogW(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(objArr, "args");
        LogUtils.w(str, Arrays.copyOf(objArr, objArr.length));
    }

    public static final String getTextString(AccessibilityNodeInfo accessibilityNodeInfo) {
        String obj;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "$this$textString");
        CharSequence text = accessibilityNodeInfo.getText();
        return (text == null || (obj = text.toString()) == null) ? "" : obj;
    }

    public static final String getPackageNameString(AccessibilityEvent accessibilityEvent) {
        String obj;
        Intrinsics.checkNotNullParameter(accessibilityEvent, "$this$packageNameString");
        CharSequence packageName = accessibilityEvent.getPackageName();
        return (packageName == null || (obj = packageName.toString()) == null) ? "" : obj;
    }

    public static final String getClassNameString(AccessibilityEvent accessibilityEvent) {
        String obj;
        Intrinsics.checkNotNullParameter(accessibilityEvent, "$this$classNameString");
        CharSequence className = accessibilityEvent.getClassName();
        return (className == null || (obj = className.toString()) == null) ? "" : obj;
    }

    public static final String getSourceTextString(AccessibilityEvent accessibilityEvent) {
        CharSequence text;
        String obj;
        Intrinsics.checkNotNullParameter(accessibilityEvent, "$this$sourceTextString");
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (!(source == null || (text = source.getText()) == null || (obj = text.toString()) == null)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj2 = StringsKt.trim((CharSequence) obj).toString();
            if (obj2 != null) {
                return obj2;
            }
        }
        return "";
    }

    public static final String getBtnTextInstall(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextInstall");
        String string = accessibilityService.getString(2131886289);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.btn_accessibility_install)");
        return string;
    }

    public static final String getBtnTextContinueInstall(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextContinueInstall");
        String string = accessibilityService.getString(2131886287);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…ibility_continue_install)");
        return string;
    }

    public static final String getBtnTextOk(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextOk");
        String string = accessibilityService.getString(2131886292);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.btn_accessibility_ok)");
        return string;
    }

    public static final String getBtnTextAllowOnce(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextAllowOnce");
        String string = accessibilityService.getString(2131886285);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…accessibility_allow_once)");
        return string;
    }

    public static final String getBtnTextNext(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextNext");
        String string = accessibilityService.getString(2131886291);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.btn_accessibility_next)");
        return string;
    }

    public static final String getBtnTextOpen(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextOpen");
        String string = accessibilityService.getString(2131886293);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.btn_accessibility_open)");
        return string;
    }

    public static final String getBtnTextRun(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextRun");
        String string = accessibilityService.getString(2131886294);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.btn_accessibility_run)");
        return string;
    }

    public static final String getTextInstalled(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textInstalled");
        String string = accessibilityService.getString(2131886620);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…_accessibility_installed)");
        return string;
    }

    public static final String getTextInstalled2(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textInstalled2");
        String string = accessibilityService.getString(2131886621);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…accessibility_installed2)");
        return string;
    }

    public static final String getTextInstalled3(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textInstalled3");
        String string = accessibilityService.getString(2131886622);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…accessibility_installed3)");
        return string;
    }

    public static final String getBtnTextDone(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextDone");
        String string = accessibilityService.getString(2131886288);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.btn_accessibility_done)");
        return string;
    }

    public static final String getBtnTextComplete(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextComplete");
        String string = accessibilityService.getString(2131886286);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…n_accessibility_complete)");
        return string;
    }

    public static final String getBtnTextKnow(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextKnow");
        String string = accessibilityService.getString(2131886290);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.btn_accessibility_know)");
        return string;
    }

    public static final String getTextUninstall(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textUninstall");
        String string = accessibilityService.getString(2131886623);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…_accessibility_uninstall)");
        return string;
    }

    public static final String getBtnTextUninstall(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$btnTextUninstall");
        String string = accessibilityService.getString(2131886295);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…_accessibility_uninstall)");
        return string;
    }

    public static final String getTextUninstalled(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textUninstalled");
        String string = accessibilityService.getString(2131886625);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…ccessibility_uninstalled)");
        return string;
    }

    public static final String getTextUninstalled2(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textUninstalled2");
        String string = accessibilityService.getString(2131886626);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…cessibility_uninstalled2)");
        return string;
    }

    public static final String getTextUninstalled3(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textUninstalled3");
        String string = accessibilityService.getString(2131886627);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…cessibility_uninstalled3)");
        return string;
    }

    public static final String getTextDialogReplaceTitle(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textDialogReplaceTitle");
        String string = accessibilityService.getString(2131886331);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…essibility_replace_title)");
        return string;
    }

    public static final String getTextUninstallTitle(AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$textUninstallTitle");
        String string = accessibilityService.getString(2131886624);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(R.string.…sibility_uninstall_title)");
        return string;
    }

    public static final AccessibilityNodeInfo getNodeInfoById(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent, String str) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        Intrinsics.checkNotNullParameter(accessibilityService, "$this$getNodeInfoById");
        Intrinsics.checkNotNullParameter(str, "id");
        List<AccessibilityNodeInfo> list = null;
        if (accessibilityEvent != null) {
            AccessibilityNodeInfo source = accessibilityEvent.getSource();
            list = source != null ? source.findAccessibilityNodeInfosByViewId(str) : null;
        }
        List<AccessibilityNodeInfo> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
            list = rootInActiveWindow != null ? rootInActiveWindow.findAccessibilityNodeInfosByViewId(str) : null;
        }
        if (list == null || (accessibilityNodeInfo = (AccessibilityNodeInfo) CollectionsKt.firstOrNull((List<? extends Object>) list)) == null) {
            return null;
        }
        autoInstallLogD("找到节点: " + str, new Object[0]);
        return accessibilityNodeInfo;
    }

    public static final boolean performClick(AccessibilityNodeInfo accessibilityNodeInfo) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "$this$performClick");
        return accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.performAction(16);
    }
}
