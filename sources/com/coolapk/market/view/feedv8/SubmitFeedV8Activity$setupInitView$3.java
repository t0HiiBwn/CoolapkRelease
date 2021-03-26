package com.coolapk.market.view.feedv8;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/feedv8/SubmitFeedV8Activity;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$setupInitView$3 extends Lambda implements Function1<SubmitFeedV8Activity, Unit> {
    final /* synthetic */ SubmitFeedV8Activity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitFeedV8Activity$setupInitView$3(SubmitFeedV8Activity submitFeedV8Activity) {
        super(1);
        this.this$0 = submitFeedV8Activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SubmitFeedV8Activity submitFeedV8Activity) {
        invoke(submitFeedV8Activity);
        return Unit.INSTANCE;
    }

    public final void invoke(SubmitFeedV8Activity submitFeedV8Activity) {
        Intrinsics.checkNotNullParameter(submitFeedV8Activity, "it");
        ImageView imageView = SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuShareApp;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.menuShareApp");
        imageView.setVisibility(8);
    }
}
