package com.coolapk.market.view.feed.pick;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeRecommendPickerActivity.kt */
final class NodeRecommendPickerActivity$setupToolbar$3<T> implements Action1<String> {
    final /* synthetic */ NodeRecommendPickerActivity this$0;

    NodeRecommendPickerActivity$setupToolbar$3(NodeRecommendPickerActivity nodeRecommendPickerActivity) {
        this.this$0 = nodeRecommendPickerActivity;
    }

    public final void call(String str) {
        NodeRecommendPickerActivity nodeRecommendPickerActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(str, "it");
        nodeRecommendPickerActivity.inputKeywords(str);
    }
}
