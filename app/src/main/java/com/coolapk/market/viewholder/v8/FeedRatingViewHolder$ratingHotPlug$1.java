package com.coolapk.market.viewholder.v8;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.widget.hotplug.BaseRatingHotPlug;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/v8/FeedRatingViewHolder$ratingHotPlug$1", "Lcom/coolapk/market/widget/hotplug/BaseRatingHotPlug;", "onViewPartLoad", "", "viewPart", "Lcom/coolapk/market/viewholder/v8/FeedRatingViewPart;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedRatingViewHolder.kt */
public final class FeedRatingViewHolder$ratingHotPlug$1 extends BaseRatingHotPlug {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedRatingViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedRatingViewHolder$ratingHotPlug$1(FeedRatingViewHolder feedRatingViewHolder, DataBindingComponent dataBindingComponent, View view, DataBindingComponent dataBindingComponent2) {
        super(view, dataBindingComponent2, null, false, 12, null);
        this.this$0 = feedRatingViewHolder;
        this.$component = dataBindingComponent;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.BaseRatingHotPlug
    public void onViewPartLoad(FeedRatingViewPart feedRatingViewPart) {
        Intrinsics.checkNotNullParameter(feedRatingViewPart, "viewPart");
        super.onViewPartLoad(feedRatingViewPart);
        View view = feedRatingViewPart.getView();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = 0;
        view.setLayoutParams(marginLayoutParams);
    }
}
