package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedRatingViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0014J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0014¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedRatingViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedRatingViewBinding;", "Lcom/coolapk/market/model/Feed;", "()V", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedRatingViewPart.kt */
public final class FeedRatingViewPart extends BindingViewPart<ItemFeedRatingViewBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558722;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedRatingViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "shouldShowView", "", "feed", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedRatingViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldShowView(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            return Intrinsics.areEqual(feed.getFeedType(), "rating");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedRatingViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558722, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemFeedRatingViewBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        super.onBindToContent((FeedRatingViewPart) feed);
        RatingBar ratingBar = ((ItemFeedRatingViewBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(feed.getRatingScore()));
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        RatingBar ratingBar2 = ((ItemFeedRatingViewBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar2, "binding.ratingBar");
        RatingBar ratingBar3 = ((ItemFeedRatingViewBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(ratingBar2, (int) ratingBar3.getRating());
        TextView textView = ((ItemFeedRatingViewBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreView");
        textView.setText(EntityExtendsKt.getDisplayRatingScore(feed) + (char) 20998);
        ((ItemFeedRatingViewBinding) getBinding()).executePendingBindings();
        String productStatusText = EntityExtendsKt.getProductStatusText(feed);
        LinearLayout linearLayout = ((ItemFeedRatingViewBinding) getBinding()).ownerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.ownerView");
        LinearLayout linearLayout2 = linearLayout;
        String str = productStatusText;
        int i = 0;
        if (!(str.length() > 0)) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        TextView textView2 = ((ItemFeedRatingViewBinding) getBinding()).ownerTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ownerTextView");
        textView2.setText(str);
    }
}
