package com.coolapk.market.service.action;

import com.coolapk.market.model.PatchInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/model/PatchInfo;", "kotlin.jvm.PlatformType", "it", "", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CheckForUpgradeAction.kt */
final class CheckForUpgradeAction$checkForAll$upgradeInfoList$1<T, R> implements Func1<List<PatchInfo>, Observable<? extends PatchInfo>> {
    public static final CheckForUpgradeAction$checkForAll$upgradeInfoList$1 INSTANCE = new CheckForUpgradeAction$checkForAll$upgradeInfoList$1();

    CheckForUpgradeAction$checkForAll$upgradeInfoList$1() {
    }

    public final Observable<? extends PatchInfo> call(List<PatchInfo> list) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return Observable.from(list);
    }
}
