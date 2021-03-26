package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitExtraViewPart.kt */
final class SubmitExtraViewPart$onRequestVisibility$3 implements View.OnClickListener {
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ SubmitExtraViewPart this$0;

    SubmitExtraViewPart$onRequestVisibility$3(SubmitExtraViewPart submitExtraViewPart, Function0 function0) {
        this.this$0 = submitExtraViewPart;
        this.$dismissAction = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedMultiPart.Builder builder = FeedMultiPart.builder(SubmitExtraViewPart.access$getActivity$p(this.this$0).getMultiPart());
        FeedUIConfig.Builder builder2 = FeedUIConfig.builder(SubmitExtraViewPart.access$getActivity$p(this.this$0).getUiConfig());
        Intrinsics.checkNotNullExpressionValue(view, "it");
        switch (view.getId()) {
            case 2131363964:
                builder.visibleStatus(1);
                builder2.visibleState(1);
                break;
            case 2131363965:
                builder.visibleStatus(-1);
                builder2.visibleState(-1);
                break;
        }
        SubmitFeedV8Activity access$getActivity$p = SubmitExtraViewPart.access$getActivity$p(this.this$0);
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        access$getActivity$p.updateMultiPart(build);
        SubmitFeedV8Activity access$getActivity$p2 = SubmitExtraViewPart.access$getActivity$p(this.this$0);
        FeedUIConfig build2 = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "uiBuilder.build()");
        access$getActivity$p2.updateUIConfig(build2);
        this.$dismissAction.invoke();
        this.this$0.updateVisibilityInfo();
    }
}
