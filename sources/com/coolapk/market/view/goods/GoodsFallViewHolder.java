package com.coolapk.market.view.goods;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemGoodsFallBinding;
import com.coolapk.market.event.FeedEventRequester;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoodsAction;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsFallViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodsFallBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "feed", "onClick", "view", "setLikeState", "parentView", "Landroid/view/ViewGroup;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsFallViewHolder.kt */
public final class GoodsFallViewHolder extends GenericBindHolder<ItemGoodsFallBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558763;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsFallViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ((ItemGoodsFallBinding) getBinding()).itemView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.view.goods.GoodsFallViewHolder.AnonymousClass1 */
            final /* synthetic */ GoodsFallViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                ItemGoodsFallBinding itemGoodsFallBinding = (ItemGoodsFallBinding) this.this$0.getBinding();
                Intrinsics.checkNotNullExpressionValue(itemGoodsFallBinding, "binding");
                Feed model = itemGoodsFallBinding.getModel();
                if (model == null) {
                    return true;
                }
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(model, context);
                return true;
            }
        });
        ItemGoodsFallBinding itemGoodsFallBinding = (ItemGoodsFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsFallBinding, "binding");
        itemGoodsFallBinding.setClick(this);
        ((ItemGoodsFallBinding) getBinding()).ratingBar.setHeartShapeProgressBar(NumberExtendsKt.getDp((Number) 18));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsFallViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsFallViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed) {
        float f;
        Intrinsics.checkNotNullParameter(feed, "feed");
        ItemGoodsFallBinding itemGoodsFallBinding = (ItemGoodsFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsFallBinding, "binding");
        itemGoodsFallBinding.setModel(feed);
        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(feed.getThumbnailPic());
        float f2 = 1.0f;
        if (size != null) {
            Intrinsics.checkNotNullExpressionValue(size, "it");
            f = ((float) size.getWidth()) / ((float) size.getHeight());
        } else {
            f = 1.0f;
        }
        if (f <= 1.0f) {
            f2 = f < 0.75f ? 0.75f : f;
        }
        ((ItemGoodsFallBinding) getBinding()).imageContainer.setAspectRatio(f2);
        ItemGoodsFallBinding itemGoodsFallBinding2 = (ItemGoodsFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsFallBinding2, "binding");
        ImageArgs.Companion companion = ImageArgs.Companion;
        String pic = feed.getPic();
        if (pic == null) {
            pic = "";
        }
        itemGoodsFallBinding2.setImageUrl(companion.smartThumbnailProvider(pic));
        ((ItemGoodsFallBinding) getBinding()).executePendingBindings();
        FeedGoodsAction goodsAction = feed.getGoodsAction();
        if (goodsAction == null) {
            goodsAction = FeedGoodsAction.EMPTY;
        }
        TextView textView = ((ItemGoodsFallBinding) getBinding()).buyTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.buyTextView");
        Intrinsics.checkNotNullExpressionValue(goodsAction, "goodsAction");
        textView.setText(goodsAction.getWishBuyStatus() == 1 ? "买过" : "想买");
        TextView textView2 = ((ItemGoodsFallBinding) getBinding()).buyTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.buyTextView");
        textView2.setBackground(new ColorDrawable((int) (goodsAction.getWishBuyStatus() == 1 ? 4280391411L : 4294198070L)));
        BadBadRatingBar badBadRatingBar = ((ItemGoodsFallBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        badBadRatingBar.setRating((float) goodsAction.getStar());
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar2 = ((ItemGoodsFallBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar2, "binding.ratingBar");
        BadBadRatingBar badBadRatingBar3 = ((ItemGoodsFallBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(badBadRatingBar2, (int) badBadRatingBar3.getRating());
        RatingContentHelper ratingContentHelper2 = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar4 = ((ItemGoodsFallBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar4, "binding.ratingBar");
        ratingContentHelper2.setRatingBarBackgroundGreyColor(badBadRatingBar4);
        CoolEllipsizeTextView coolEllipsizeTextView = ((ItemGoodsFallBinding) getBinding()).messageView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.messageView");
        String message = feed.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "feed.message");
        ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 4, message);
        LinearLayout linearLayout = ((ItemGoodsFallBinding) getBinding()).imgUpView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.imgUpView");
        setLikeState(feed, linearLayout);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemGoodsFallBinding itemGoodsFallBinding3 = (ItemGoodsFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsFallBinding3, "binding");
        View root = itemGoodsFallBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, "瀑布流好物");
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        ItemGoodsFallBinding itemGoodsFallBinding = (ItemGoodsFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsFallBinding, "binding");
        Feed model = itemGoodsFallBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            if (valueOf != null && valueOf.intValue() == 2131362779) {
                ActionManager.startFeedDetailActivity(getContext(), model.getId(), (String) null);
            } else if (valueOf != null && valueOf.intValue() == 2131363911) {
                ActionManager.startUserSpaceActivity(getContext(), model.getUid());
            } else if (valueOf != null && valueOf.intValue() == 2131362734) {
                FeedEventRequester feedEventRequester = FeedEventRequester.INSTANCE;
                String id = model.getId();
                Intrinsics.checkNotNull(id);
                Intrinsics.checkNotNullExpressionValue(id, "feed.id!!");
                UserAction userAction = model.getUserAction();
                FeedEventRequester.requestLike$default(feedEventRequester, id, userAction == null || userAction.getLike() != 1, 0, null, null, 24, null);
            } else {
                super.onClick(view);
            }
        }
    }

    private final void setLikeState(Feed feed, ViewGroup viewGroup) {
        if (feed != null) {
            boolean z = false;
            View childAt = viewGroup.getChildAt(0);
            TextView textView = null;
            if (!(childAt instanceof ImageView)) {
                childAt = null;
            }
            ImageView imageView = (ImageView) childAt;
            Intrinsics.checkNotNull(imageView);
            View childAt2 = viewGroup.getChildAt(1);
            if (childAt2 instanceof TextView) {
                textView = childAt2;
            }
            TextView textView2 = textView;
            Intrinsics.checkNotNull(textView2);
            if (feed.getUserAction() != null) {
                UserAction userAction = feed.getUserAction();
                Intrinsics.checkNotNull(userAction);
                Intrinsics.checkNotNullExpressionValue(userAction, "feed.userAction!!");
                if (userAction.getLike() > 0) {
                    z = true;
                }
            }
            if (z) {
                imageView.setImageResource(2131689495);
                imageView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
                textView2.setTextColor(AppHolder.getAppTheme().getColorAccent());
                return;
            }
            imageView.setImageResource(2131689494);
            imageView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getTextColorSecondary()));
            textView2.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        }
    }
}
