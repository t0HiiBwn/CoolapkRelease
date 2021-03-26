package com.coolapk.market.view.node.app;

import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.databinding.TopicNodePageBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$stateEventChangedAdapter$1$notifyEventChanged$1 implements Runnable {
    final /* synthetic */ TopicNodePageBinding $binding;

    AppNodeFragment$stateEventChangedAdapter$1$notifyEventChanged$1(TopicNodePageBinding topicNodePageBinding) {
        this.$binding = topicNodePageBinding;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toolbar toolbar = this.$binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        ViewExtendsKt.resetTintColor(toolbar);
    }
}
