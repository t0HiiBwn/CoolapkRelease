package com.coolapk.market.service.autoinstall;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"isTargetText", "Landroid/view/accessibility/AccessibilityNodeInfo;", "service", "Landroid/accessibilityservice/AccessibilityService;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AutoInstallServiceV10.kt */
final class AutoInstallServiceV10Kt$getNextButtonNodeInfo$1 extends Lambda implements Function2<AccessibilityNodeInfo, AccessibilityService, AccessibilityNodeInfo> {
    public static final AutoInstallServiceV10Kt$getNextButtonNodeInfo$1 INSTANCE = new AutoInstallServiceV10Kt$getNextButtonNodeInfo$1();

    AutoInstallServiceV10Kt$getNextButtonNodeInfo$1() {
        super(2);
    }

    public final AccessibilityNodeInfo invoke(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "$this$isTargetText");
        Intrinsics.checkNotNullParameter(accessibilityService, "service");
        if (!StringsKt.equals(AutoInstallUtilKt.getTextString(accessibilityNodeInfo), AutoInstallUtilKt.getBtnTextNext(accessibilityService), true)) {
            return null;
        }
        AutoInstallUtilKt.autoInstallLogD("找到按钮: " + AutoInstallUtilKt.getTextString(accessibilityNodeInfo), new Object[0]);
        return accessibilityNodeInfo;
    }
}
