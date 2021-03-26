package com.coolapk.market.view.feedv8;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: RatingContentHolderVX1.kt */
final class RatingContentHolderVX1$initPhotoViewsAndAdapters$3 implements Action0 {
    final /* synthetic */ RatingContentHolderVX1 this$0;

    RatingContentHolderVX1$initPhotoViewsAndAdapters$3(RatingContentHolderVX1 ratingContentHolderVX1) {
        this.this$0 = ratingContentHolderVX1;
    }

    @Override // rx.functions.Action0
    public final void call() {
        if (RatingContentHolderVX1.access$getSummaryAdapter$p(this.this$0).getImageUrls().isEmpty()) {
            RecyclerView recyclerView = this.this$0.getBinding$presentation_coolapkAppRelease().summaryRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.summaryRecyclerView");
            recyclerView.setVisibility(8);
            LinearLayout linearLayout = this.this$0.getBinding$presentation_coolapkAppRelease().summaryAddPhotoView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.summaryAddPhotoView");
            linearLayout.setVisibility(0);
            return;
        }
        RecyclerView recyclerView2 = this.this$0.getBinding$presentation_coolapkAppRelease().summaryRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.summaryRecyclerView");
        recyclerView2.setVisibility(0);
        LinearLayout linearLayout2 = this.this$0.getBinding$presentation_coolapkAppRelease().summaryAddPhotoView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.summaryAddPhotoView");
        linearLayout2.setVisibility(8);
    }
}
