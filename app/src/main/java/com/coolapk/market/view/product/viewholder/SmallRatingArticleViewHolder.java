package com.coolapk.market.view.product.viewholder;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemProductSmallRatingArticleBinding;
import com.coolapk.market.event.FeedEventRequester;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/SmallRatingArticleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProductSmallRatingArticleBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "onClick", "view", "setLikeState", "isLike", "", "likeNum", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SmallRatingArticleViewHolder.kt */
public final class SmallRatingArticleViewHolder extends GenericBindHolder<ItemProductSmallRatingArticleBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558879;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallRatingArticleViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemProductSmallRatingArticleBinding itemProductSmallRatingArticleBinding = (ItemProductSmallRatingArticleBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductSmallRatingArticleBinding, "binding");
        itemProductSmallRatingArticleBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/SmallRatingArticleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SmallRatingArticleViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        ItemProductSmallRatingArticleBinding itemProductSmallRatingArticleBinding = (ItemProductSmallRatingArticleBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductSmallRatingArticleBinding, "binding");
        itemProductSmallRatingArticleBinding.setModel(feed);
        ((ItemProductSmallRatingArticleBinding) getBinding()).executePendingBindings();
        RatingBar ratingBar = ((ItemProductSmallRatingArticleBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(feed.getRatingScore()));
        RatingBar ratingBar2 = ((ItemProductSmallRatingArticleBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar2, "binding.ratingBar");
        boolean z = false;
        ratingBar2.setVisibility(0);
        TextView textView = ((ItemProductSmallRatingArticleBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreView");
        textView.setText(EntityExtendsKt.getDisplayRatingScore(feed));
        CoolEllipsizeTextView coolEllipsizeTextView = ((ItemProductSmallRatingArticleBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
        String message = feed.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "data.message");
        ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 3, message);
        ((ItemProductSmallRatingArticleBinding) getBinding()).itemView.setOnLongClickListener(new SmallRatingArticleViewHolder$bindToContent$1(this, feed));
        UserAction userAction = feed.getUserAction();
        if (userAction != null && userAction.getLike() == 1) {
            z = true;
        }
        setLikeState(z, feed.getLikeNum());
    }

    private final void setLikeState(boolean z, int i) {
        TextView textView = ((ItemProductSmallRatingArticleBinding) getBinding()).likeNum;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.likeNum");
        textView.setText(i > 0 ? String.valueOf(i) : "");
        ((ItemProductSmallRatingArticleBinding) getBinding()).likeNum.setTextColor(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099891));
        ((ItemProductSmallRatingArticleBinding) getBinding()).likeIcon.setImageResource(z ? 2131689495 : 2131689494);
        ((ItemProductSmallRatingArticleBinding) getBinding()).likeIcon.setColorFilter(z ? AppHolder.getAppTheme().getColorAccent() : ResourceUtils.getColorInt(getContext(), 2131099891));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemProductSmallRatingArticleBinding itemProductSmallRatingArticleBinding = (ItemProductSmallRatingArticleBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductSmallRatingArticleBinding, "binding");
        Feed model = itemProductSmallRatingArticleBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            switch (view.getId()) {
                case 2131362291:
                    ActionManager.startFeedCommentActivity(UiUtils.getActivity(getContext()), model.getId(), model.getUserName());
                    return;
                case 2131362768:
                    ActionManager.startFeedDetailActivity(UiUtils.getActivity(getContext()), model, null, 0);
                    return;
                case 2131362851:
                    FeedEventRequester feedEventRequester = FeedEventRequester.INSTANCE;
                    String id = model.getId();
                    if (id == null) {
                        id = "";
                    }
                    UserAction userAction = model.getUserAction();
                    FeedEventRequester.requestLike$default(feedEventRequester, id, userAction == null || userAction.getLike() != 1, 0, null, null, 24, null);
                    return;
                case 2131363877:
                    ActionManager.startUserSpaceActivity(view, model.getUid(), model.getUserAvatar());
                    return;
                default:
                    super.onClick(view);
                    return;
            }
        }
    }
}
