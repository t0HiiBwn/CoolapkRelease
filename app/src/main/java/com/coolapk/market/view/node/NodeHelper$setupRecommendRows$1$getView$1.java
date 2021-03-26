package com.coolapk.market.view.node;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.NewHeadLine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
final class NodeHelper$setupRecommendRows$1$getView$1 implements View.OnClickListener {
    final /* synthetic */ NewHeadLine $headline;
    final /* synthetic */ NodeHelper$setupRecommendRows$1 this$0;

    NodeHelper$setupRecommendRows$1$getView$1(NodeHelper$setupRecommendRows$1 nodeHelper$setupRecommendRows$1, NewHeadLine newHeadLine) {
        this.this$0 = nodeHelper$setupRecommendRows$1;
        this.$headline = newHeadLine;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl(context, this.$headline.getUrl(), this.$headline.getTitle(), this.$headline.getSubTitle());
    }
}
