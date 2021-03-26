package com.coolapk.market.view.dyhv8;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhIncludActivity.kt */
final class DyhIncludActivity$setupAutoInputKeyword$3<T> implements Action1<String> {
    final /* synthetic */ DyhIncludActivity this$0;

    DyhIncludActivity$setupAutoInputKeyword$3(DyhIncludActivity dyhIncludActivity) {
        this.this$0 = dyhIncludActivity;
    }

    public final void call(String str) {
        if (!this.this$0.isFinishing()) {
            DyhIncludActivity dyhIncludActivity = this.this$0;
            Intrinsics.checkNotNullExpressionValue(str, "it");
            dyhIncludActivity.searchKey(str);
        }
    }
}
