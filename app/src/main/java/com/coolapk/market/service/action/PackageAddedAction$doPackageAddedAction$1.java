package com.coolapk.market.service.action;

import com.coolapk.market.model.InstallState;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "lhs", "Lcom/coolapk/market/model/InstallState;", "kotlin.jvm.PlatformType", "rhs", "compare"}, k = 3, mv = {1, 4, 2})
/* compiled from: PackageAddedAction.kt */
final class PackageAddedAction$doPackageAddedAction$1<T> implements Comparator<InstallState> {
    public static final PackageAddedAction$doPackageAddedAction$1 INSTANCE = new PackageAddedAction$doPackageAddedAction$1();

    PackageAddedAction$doPackageAddedAction$1() {
    }

    public final int compare(InstallState installState, InstallState installState2) {
        Intrinsics.checkNotNullExpressionValue(installState2, "rhs");
        long startTime = installState2.getStartTime();
        Intrinsics.checkNotNullExpressionValue(installState, "lhs");
        return Long.signum(startTime - installState.getStartTime());
    }
}
