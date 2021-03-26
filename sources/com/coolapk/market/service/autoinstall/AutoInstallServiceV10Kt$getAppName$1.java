package com.coolapk.market.service.autoinstall;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"fixIfNeed", "", "Landroid/view/accessibility/AccessibilityNodeInfo;", "service", "Landroid/accessibilityservice/AccessibilityService;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AutoInstallServiceV10.kt */
final class AutoInstallServiceV10Kt$getAppName$1 extends Lambda implements Function2<AccessibilityNodeInfo, AccessibilityService, String> {
    final /* synthetic */ AccessibilityService $this_getAppName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoInstallServiceV10Kt$getAppName$1(AccessibilityService accessibilityService) {
        super(2);
        this.$this_getAppName = accessibilityService;
    }

    public final String invoke(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService) {
        String textString;
        String replace$default;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "$this$fixIfNeed");
        Intrinsics.checkNotNullParameter(accessibilityService, "service");
        if (!Intrinsics.areEqual(AutoInstallUtilKt.getTextString(accessibilityNodeInfo), AutoInstallUtilKt.getTextUninstallTitle(accessibilityService))) {
            return AutoInstallUtilKt.getTextString(accessibilityNodeInfo);
        }
        AutoInstallUtilKt.autoInstallLogD("不是我们想要的标题，继续找", new Object[0]);
        AccessibilityNodeInfo uninstallButtonNodeInfo = AutoInstallServiceV10Kt.getUninstallButtonNodeInfo(this.$this_getAppName, null);
        if (uninstallButtonNodeInfo == null || (textString = AutoInstallUtilKt.getTextString(uninstallButtonNodeInfo)) == null || (replace$default = StringsKt.replace$default(textString, AutoInstallUtilKt.getBtnTextUninstall(accessibilityService), "", false, 4, (Object) null)) == null) {
            return null;
        }
        Objects.requireNonNull(replace$default, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt.trim((CharSequence) replace$default).toString();
    }
}
