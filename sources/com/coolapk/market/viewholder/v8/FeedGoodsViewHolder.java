package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedGoodsBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoodsAction;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.cardlist.EntityDataHelper;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPartKt;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.hotplug.BaseHotReplyHotPlug;
import com.coolapk.market.widget.view.BadBadRatingBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0002\u0019\u001c\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001#B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016R\u000e\u0010\n\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006$"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedGoodsViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedGoodsBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "feed", "goodsInfoViewPart", "Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "getGoodsInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "goodsInfoViewPart$delegate", "Lkotlin/Lazy;", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "hotReplyHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseHotReplyHotPlug;", "nineImageHotPlug", "com/coolapk/market/viewholder/v8/FeedGoodsViewHolder$nineImageHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedGoodsViewHolder$nineImageHotPlug$1;", "relativeInfoHotPlug", "com/coolapk/market/viewholder/v8/FeedGoodsViewHolder$relativeInfoHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedGoodsViewHolder$relativeInfoHotPlug$1;", "bindToContent", "", "onClick", "view", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsViewHolder.kt */
public final class FeedGoodsViewHolder extends GenericBindHolder<ItemFeedGoodsBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558709;
    private Feed feed;
    private final Lazy goodsInfoViewPart$delegate;
    private final Lazy headerViewPart$delegate;
    private final BaseHotReplyHotPlug hotReplyHotPlug;
    private final FeedGoodsViewHolder$nineImageHotPlug$1 nineImageHotPlug;
    private final FeedGoodsViewHolder$relativeInfoHotPlug$1 relativeInfoHotPlug;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public final FeedGoodsInfoViewPart getGoodsInfoViewPart() {
        return (FeedGoodsInfoViewPart) this.goodsInfoViewPart$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getFeed$p(FeedGoodsViewHolder feedGoodsViewHolder) {
        Feed feed2 = feedGoodsViewHolder.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedGoodsViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemFeedGoodsBinding itemFeedGoodsBinding = (ItemFeedGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedGoodsBinding, "binding");
        itemFeedGoodsBinding.setClick(this);
        itemFeedGoodsBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.FeedGoodsViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedGoodsViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed access$getFeed$p = FeedGoodsViewHolder.access$getFeed$p(this.this$0);
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(access$getFeed$p, context);
                return true;
            }
        });
        itemFeedGoodsBinding.ratingBar.setHeartShapeProgressBar(NumberExtendsKt.getDp((Number) 22));
        this.headerViewPart$delegate = LazyKt.lazy(new FeedGoodsViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.goodsInfoViewPart$delegate = LazyKt.lazy(new FeedGoodsViewHolder$goodsInfoViewPart$2(this, dataBindingComponent));
        Space space = ((ItemFeedGoodsBinding) getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        this.nineImageHotPlug = new FeedGoodsViewHolder$nineImageHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        Space space2 = ((ItemFeedGoodsBinding) getBinding()).hotReplySpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.hotReplySpaceView");
        this.hotReplyHotPlug = new BaseHotReplyHotPlug(space2, dataBindingComponent, null, false, 12, null);
        Space space3 = ((ItemFeedGoodsBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space3, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new FeedGoodsViewHolder$relativeInfoHotPlug$1(this, dataBindingComponent, space3, dataBindingComponent);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedGoodsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedGoodsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed2) {
        EntityDataHelper entityDataHelper$presentation_coolapkAppRelease;
        Intrinsics.checkNotNullParameter(feed2, "feed");
        ItemFeedGoodsBinding itemFeedGoodsBinding = (ItemFeedGoodsBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedGoodsBinding, "binding");
        itemFeedGoodsBinding.setModel(feed2);
        this.nineImageHotPlug.bindTo(EntityExtendsKt.getHtmlPicArray(feed2));
        this.hotReplyHotPlug.bindTo(feed2);
        getHeaderViewPart().bindTo(feed2);
        this.relativeInfoHotPlug.bindTo(feed2);
        getGoodsInfoViewPart().bindToContent(FeedGoodsInfoViewPartKt.toGoodsSimpleInfo(feed2));
        itemFeedGoodsBinding.executePendingBindings();
        FeedGoodsAction goodsAction = feed2.getGoodsAction();
        if (goodsAction == null) {
            goodsAction = FeedGoodsAction.EMPTY;
        }
        TextView textView = itemFeedGoodsBinding.buyTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.buyTextView");
        Intrinsics.checkNotNullExpressionValue(goodsAction, "goodsAction");
        textView.setText(goodsAction.getWishBuyStatus() == 1 ? "买过" : "想买");
        itemFeedGoodsBinding.buyView.setBackgroundColor((int) (goodsAction.getWishBuyStatus() == 1 ? 4280391411L : 4294198070L));
        BadBadRatingBar badBadRatingBar = itemFeedGoodsBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        badBadRatingBar.setRating((float) goodsAction.getStar());
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar2 = itemFeedGoodsBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar2, "binding.ratingBar");
        BadBadRatingBar badBadRatingBar3 = itemFeedGoodsBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(badBadRatingBar2, (int) badBadRatingBar3.getRating());
        RatingContentHelper ratingContentHelper2 = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar4 = itemFeedGoodsBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar4, "binding.ratingBar");
        ratingContentHelper2.setRatingBarBackgroundGreyColor(badBadRatingBar4);
        DataBindingComponent component = getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "component");
        EntityListFragment entityListFragment = KotlinExtendKt.getEntityListFragment(component);
        EntityDataHelper.FeedAssistData feedAssistData = null;
        EntityDataHelper.BaseAssistData obtainAssistData = (entityListFragment == null || (entityDataHelper$presentation_coolapkAppRelease = entityListFragment.getEntityDataHelper$presentation_coolapkAppRelease()) == null) ? null : entityDataHelper$presentation_coolapkAppRelease.obtainAssistData(feed2);
        if (obtainAssistData instanceof EntityDataHelper.FeedAssistData) {
            feedAssistData = obtainAssistData;
        }
        EntityDataHelper.FeedAssistData feedAssistData2 = feedAssistData;
        if (feedAssistData2 != null) {
            TextView textView2 = itemFeedGoodsBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            textView2.setText(feedAssistData2.getBriefMessage());
            TextView textView3 = itemFeedGoodsBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.textView");
            ViewExtendsKt.makeSpanClickable(textView3);
        } else {
            TextView textView4 = itemFeedGoodsBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.textView");
            String message = feed2.getMessage();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886718));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
            Unit unit = Unit.INSTANCE;
            ViewExtendsKt.setBriefMessage(textView4, 90, message, spannableStringBuilder);
        }
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedGoodsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed2.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362205) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FeedUriAction.Companion companion = FeedUriAction.Companion;
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        ActionManagerCompat.startActivityByUrl$default(context, companion.buildUrl(feed2), null, null, 12, null);
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.nineImageHotPlug.onRecycled();
        this.hotReplyHotPlug.onRecycled();
        this.relativeInfoHotPlug.onRecycled();
    }
}
