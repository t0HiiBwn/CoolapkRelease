package com.coolapk.market.view.appmanager;

import com.coolapk.market.model.MobileApp;
import java.text.Collator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.functions.Func2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "lhs", "Lcom/coolapk/market/model/MobileApp;", "rhs", "call", "(Lcom/coolapk/market/model/MobileApp;Lcom/coolapk/market/model/MobileApp;)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 2})
/* compiled from: MobileAppPresenter.kt */
final class MobileAppPresenter$onCreateRequest$4<T1, T2, R> implements Func2<MobileApp, MobileApp, Integer> {
    final /* synthetic */ MobileAppPresenter this$0;

    MobileAppPresenter$onCreateRequest$4(MobileAppPresenter mobileAppPresenter) {
        this.this$0 = mobileAppPresenter;
    }

    public final Integer call(MobileApp mobileApp, MobileApp mobileApp2) {
        int i;
        int i2 = this.this$0.sortBy;
        if (i2 == 0) {
            Collator collator = this.this$0.collator;
            Intrinsics.checkNotNullExpressionValue(mobileApp, "lhs");
            String appName = mobileApp.getAppName();
            Intrinsics.checkNotNullExpressionValue(appName, "lhs.appName");
            Objects.requireNonNull(appName, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt.trim((CharSequence) appName).toString();
            Intrinsics.checkNotNullExpressionValue(mobileApp2, "rhs");
            String appName2 = mobileApp2.getAppName();
            Intrinsics.checkNotNullExpressionValue(appName2, "rhs.appName");
            Objects.requireNonNull(appName2, "null cannot be cast to non-null type kotlin.CharSequence");
            i = collator.compare(obj, StringsKt.trim((CharSequence) appName2).toString());
        } else if (i2 == 1) {
            Intrinsics.checkNotNullExpressionValue(mobileApp2, "rhs");
            long firstInstallTime = mobileApp2.getFirstInstallTime();
            Intrinsics.checkNotNullExpressionValue(mobileApp, "lhs");
            i = Long.signum(firstInstallTime - mobileApp.getFirstInstallTime());
        } else if (i2 == 2) {
            Intrinsics.checkNotNullExpressionValue(mobileApp2, "rhs");
            long lastUpdateTime = mobileApp2.getLastUpdateTime();
            Intrinsics.checkNotNullExpressionValue(mobileApp, "lhs");
            i = Long.signum(lastUpdateTime - mobileApp.getLastUpdateTime());
        } else if (i2 != 3) {
            i = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(mobileApp2, "rhs");
            long apkLength = mobileApp2.getApkLength();
            Intrinsics.checkNotNullExpressionValue(mobileApp, "lhs");
            i = Long.signum(apkLength - mobileApp.getApkLength());
        }
        if (i == 0) {
            Intrinsics.checkNotNullExpressionValue(mobileApp, "lhs");
            String packageName = mobileApp.getPackageName();
            Intrinsics.checkNotNullExpressionValue(mobileApp2, "rhs");
            String packageName2 = mobileApp2.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "rhs.packageName");
            i = packageName.compareTo(packageName2);
        }
        return Integer.valueOf(i);
    }
}
