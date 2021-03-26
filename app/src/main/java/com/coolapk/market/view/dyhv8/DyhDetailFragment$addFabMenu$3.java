package com.coolapk.market.view.dyhv8;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhDetailFragment.kt */
final class DyhDetailFragment$addFabMenu$3 implements View.OnClickListener {
    final /* synthetic */ DyhModel $model;
    final /* synthetic */ DyhDetailFragment this$0;

    DyhDetailFragment$addFabMenu$3(DyhDetailFragment dyhDetailFragment, DyhModel dyhModel) {
        this.this$0 = dyhDetailFragment;
        this.$model = dyhModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedUIConfig.Builder uiConfigForQuestion = FeedArgsFactory.uiConfigForQuestion();
        DyhModel dyhModel = this.$model;
        Intrinsics.checkNotNullExpressionValue(dyhModel, "model");
        FeedUIConfig build = FeedArgsFactoryKt.applyDyh(uiConfigForQuestion, dyhModel).build();
        FeedMultiPart.Builder multiPartForQuestion = FeedArgsFactory.multiPartForQuestion();
        DyhModel dyhModel2 = this.$model;
        Intrinsics.checkNotNullExpressionValue(dyhModel2, "model");
        ActionManager.startQuestionTitleV8Activity(this.this$0.getActivity(), build, FeedArgsFactoryKt.applyDyh(multiPartForQuestion, dyhModel2).build());
    }
}
