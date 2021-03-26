package com.coolapk.market.service.action;

import com.coolapk.market.model.PatchInfo;
import com.coolapk.market.model.UpgradeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/UpgradeInfo;", "kotlin.jvm.PlatformType", "patchInfo", "Lcom/coolapk/market/model/PatchInfo;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CheckForUpgradeAction.kt */
final class CheckForUpgradeAction$checkForAll$upgradeInfoList$2<T, R> implements Func1<PatchInfo, UpgradeInfo> {
    public static final CheckForUpgradeAction$checkForAll$upgradeInfoList$2 INSTANCE = new CheckForUpgradeAction$checkForAll$upgradeInfoList$2();

    CheckForUpgradeAction$checkForAll$upgradeInfoList$2() {
    }

    public final UpgradeInfo call(PatchInfo patchInfo) {
        UpgradeInfo.Builder newBuilder = UpgradeInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(patchInfo, "patchInfo");
        return newBuilder.packageName(patchInfo.getPackageName()).apkId(patchInfo.getApkId()).displayVersionName(patchInfo.getDisplayVersionName()).versionName(patchInfo.getVersionName()).versionCode(patchInfo.getVersionCode()).apkSize(patchInfo.getApkSize()).lastUpdate(patchInfo.getLastUpdate()).changeLog(patchInfo.getChangeLog()).logo(patchInfo.getLogo()).patchKey(patchInfo.getPatchKey()).patchSize(patchInfo.getPatchSize()).patchLength(patchInfo.getPatchLength()).patchMd5(patchInfo.getPatchMd5()).extraAnalysisData(patchInfo.getExtraAnalysisData()).extraFlag(patchInfo.getExtraFlag()).build();
    }
}
