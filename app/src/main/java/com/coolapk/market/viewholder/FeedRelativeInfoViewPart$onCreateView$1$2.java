package com.coolapk.market.viewholder;

import android.content.Context;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.widget.view.RelativeInfoView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Lcom/coolapk/market/widget/view/RelativeInfoView$RelativeItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedRelativeInfoViewPart.kt */
final class FeedRelativeInfoViewPart$onCreateView$1$2 extends Lambda implements Function1<RelativeInfoView.RelativeItem, Unit> {
    final /* synthetic */ RelativeInfoView $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedRelativeInfoViewPart$onCreateView$1$2(RelativeInfoView relativeInfoView) {
        super(1);
        this.$this_apply = relativeInfoView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RelativeInfoView.RelativeItem relativeItem) {
        invoke(relativeItem);
        return Unit.INSTANCE;
    }

    public final void invoke(RelativeInfoView.RelativeItem relativeItem) {
        Intrinsics.checkNotNullParameter(relativeItem, "item");
        if (relativeItem.getUrl().length() > 0) {
            Context context = this.$this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl$default(context, relativeItem.getUrl(), relativeItem.getTitle(), null, 8, null);
        } else if (Intrinsics.areEqual(relativeItem, RelativeInfoView.Companion.getMoreItem())) {
            this.$this_apply.toggleMaxLine();
        }
    }
}
