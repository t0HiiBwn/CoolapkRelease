package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitExtraViewPart.kt */
final class SubmitExtraViewPart$Companion$fillRelativeInfoViewIntoLayout$listener$1 implements View.OnClickListener {
    final /* synthetic */ Context $activity;
    final /* synthetic */ FeedUIConfig $uiConfig;

    SubmitExtraViewPart$Companion$fillRelativeInfoViewIntoLayout$listener$1(Context context, FeedUIConfig feedUIConfig) {
        this.$activity = context;
        this.$uiConfig = feedUIConfig;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.$activity;
        Intrinsics.checkNotNullExpressionValue(context, "activity");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if ((activityNullable instanceof SubmitFeedV8Activity) && !this.$uiConfig.fromPhoneBaToSecondHand() && Intrinsics.areEqual(((SubmitFeedV8Activity) activityNullable).getMultiPart().type(), "ershou")) {
            ActionManager.startProductBrandListInErshouActivity(activityNullable, 2, 2323);
        }
    }
}
