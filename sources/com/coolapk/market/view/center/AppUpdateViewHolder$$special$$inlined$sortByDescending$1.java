package com.coolapk.market.view.center;

import com.coolapk.market.model.UpgradeInfo;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: Comparisons.kt */
public final class AppUpdateViewHolder$$special$$inlined$sortByDescending$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        T t3 = t2;
        Intrinsics.checkNotNullExpressionValue(t3, "app");
        UpgradeInfo upgradeInfo = t3.getUpgradeInfo();
        Intrinsics.checkNotNull(upgradeInfo);
        Intrinsics.checkNotNullExpressionValue(upgradeInfo, "app.upgradeInfo!!");
        T t4 = t;
        Intrinsics.checkNotNullExpressionValue(t4, "app");
        UpgradeInfo upgradeInfo2 = t4.getUpgradeInfo();
        Intrinsics.checkNotNull(upgradeInfo2);
        Intrinsics.checkNotNullExpressionValue(upgradeInfo2, "app.upgradeInfo!!");
        return ComparisonsKt.compareValues(Long.valueOf(upgradeInfo.getLastUpdate()), Long.valueOf(upgradeInfo2.getLastUpdate()));
    }
}
