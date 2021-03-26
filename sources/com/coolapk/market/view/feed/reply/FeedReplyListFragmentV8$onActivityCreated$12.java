package com.coolapk.market.view.feed.reply;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$onActivityCreated$12<T> implements Observer<Integer> {
    final /* synthetic */ Ref.BooleanRef $ignoreFirst;
    final /* synthetic */ FeedReplyListFragmentV8 this$0;

    FeedReplyListFragmentV8$onActivityCreated$12(FeedReplyListFragmentV8 feedReplyListFragmentV8, Ref.BooleanRef booleanRef) {
        this.this$0 = feedReplyListFragmentV8;
        this.$ignoreFirst = booleanRef;
    }

    public final void onChanged(Integer num) {
        if (!this.$ignoreFirst.element) {
            FeedReplyListFragmentV8 feedReplyListFragmentV8 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(num, "it");
            feedReplyListFragmentV8.updateDataTypeChange(num.intValue());
        }
    }
}
