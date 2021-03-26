package com.coolapk.market.view.center;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CenterUserMenuPresenter.kt */
public final class CenterUserMenuPresenterKt {
    public static final boolean isAppType(String str) {
        return Intrinsics.areEqual(str, "TYPE_ALBUM") || Intrinsics.areEqual(str, "TYPE_APP_MANAGER") || Intrinsics.areEqual(str, "TYPE_BACKUP");
    }
}
