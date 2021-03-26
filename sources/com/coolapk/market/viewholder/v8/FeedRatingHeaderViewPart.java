package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedRatingHeaderBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0014J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedRatingHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedRatingHeaderBinding;", "Lcom/coolapk/market/model/Feed;", "dataBindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getDataBindingComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedRatingHeaderViewPart.kt */
public final class FeedRatingHeaderViewPart extends BindingViewPart<ItemFeedRatingHeaderBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558714;
    private final DataBindingComponent dataBindingComponent;
    private Feed feed;

    public FeedRatingHeaderViewPart(DataBindingComponent dataBindingComponent2) {
        Intrinsics.checkNotNullParameter(dataBindingComponent2, "dataBindingComponent");
        this.dataBindingComponent = dataBindingComponent2;
    }

    public final DataBindingComponent getDataBindingComponent() {
        return this.dataBindingComponent;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedRatingHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedRatingHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedRatingHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558714, viewGroup, false, this.dataBindingComponent);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…se, dataBindingComponent)");
        return (ItemFeedRatingHeaderBinding) inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedRatingHeaderViewPart) feed2);
        this.feed = feed2;
        RatingBar ratingBar = ((ItemFeedRatingHeaderBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(feed2.getRatingScore()));
        TextView textView = ((ItemFeedRatingHeaderBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreView");
        textView.setText(getContext().getString(2131886989, EntityExtendsKt.getDisplayRatingScore(feed2)));
        ((ItemFeedRatingHeaderBinding) getBinding()).setClick(this);
        ((ItemFeedRatingHeaderBinding) getBinding()).setModel(feed2);
        ((ItemFeedRatingHeaderBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131362970) {
            showItemDialog();
        } else if (id != 2131363877) {
            super.onClick(view);
        } else {
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            String uid = feed2.getUid();
            Feed feed3 = this.feed;
            if (feed3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            ActionManager.startUserSpaceActivity(view, uid, feed3.getUserAvatar());
        }
    }

    private final void showItemDialog() {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        EntityExtendsKt.showItemDialog(feed2, getContext());
    }
}
