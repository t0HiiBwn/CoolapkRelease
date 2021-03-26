package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.view.View;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedRatingBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.hotplug.BaseHotReplyHotPlug;
import com.coolapk.market.widget.hotplug.BaseRatingDataHotPlug;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0003\u0014\u0019\u001c\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001#B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016R\u000e\u0010\n\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006$"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedRatingViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedRatingBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "hotReplyHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseHotReplyHotPlug;", "nineImageHotPlug", "com/coolapk/market/viewholder/v8/FeedRatingViewHolder$nineImageHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedRatingViewHolder$nineImageHotPlug$1;", "ratingDataHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseRatingDataHotPlug;", "ratingHotPlug", "com/coolapk/market/viewholder/v8/FeedRatingViewHolder$ratingHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedRatingViewHolder$ratingHotPlug$1;", "relativeInfoHotPlug", "com/coolapk/market/viewholder/v8/FeedRatingViewHolder$relativeInfoHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedRatingViewHolder$relativeInfoHotPlug$1;", "bindToContent", "", "onClick", "view", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedRatingViewHolder.kt */
public final class FeedRatingViewHolder extends GenericBindHolder<ItemFeedRatingBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558718;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final BaseHotReplyHotPlug hotReplyHotPlug;
    private final FeedRatingViewHolder$nineImageHotPlug$1 nineImageHotPlug;
    private final BaseRatingDataHotPlug ratingDataHotPlug;
    private final FeedRatingViewHolder$ratingHotPlug$1 ratingHotPlug;
    private final FeedRatingViewHolder$relativeInfoHotPlug$1 relativeInfoHotPlug;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getFeed$p(FeedRatingViewHolder feedRatingViewHolder) {
        Feed feed2 = feedRatingViewHolder.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedRatingViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemFeedRatingBinding itemFeedRatingBinding = (ItemFeedRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedRatingBinding, "binding");
        itemFeedRatingBinding.setClick(this);
        itemFeedRatingBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.FeedRatingViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedRatingViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed access$getFeed$p = FeedRatingViewHolder.access$getFeed$p(this.this$0);
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(access$getFeed$p, context);
                return true;
            }
        });
        Space space = ((ItemFeedRatingBinding) getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        this.nineImageHotPlug = new FeedRatingViewHolder$nineImageHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        Space space2 = ((ItemFeedRatingBinding) getBinding()).hotReplySpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.hotReplySpaceView");
        this.hotReplyHotPlug = new BaseHotReplyHotPlug(space2, dataBindingComponent, null, false, 12, null);
        this.headerViewPart$delegate = LazyKt.lazy(new FeedRatingViewHolder$headerViewPart$2(this, dataBindingComponent));
        Space space3 = ((ItemFeedRatingBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space3, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new FeedRatingViewHolder$relativeInfoHotPlug$1(this, dataBindingComponent, space3, dataBindingComponent);
        Space space4 = ((ItemFeedRatingBinding) getBinding()).ratingSpaceView;
        Intrinsics.checkNotNullExpressionValue(space4, "binding.ratingSpaceView");
        this.ratingHotPlug = new FeedRatingViewHolder$ratingHotPlug$1(this, dataBindingComponent, space4, dataBindingComponent);
        Space space5 = ((ItemFeedRatingBinding) getBinding()).ratingDataSpaceView;
        Intrinsics.checkNotNullExpressionValue(space5, "binding.ratingDataSpaceView");
        this.ratingDataHotPlug = new BaseRatingDataHotPlug(space5, dataBindingComponent, null, false, 12, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedRatingViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedRatingViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        ItemFeedRatingBinding itemFeedRatingBinding = (ItemFeedRatingBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedRatingBinding, "binding");
        itemFeedRatingBinding.setModel(feed2);
        this.nineImageHotPlug.bindTo(EntityExtendsKt.getHtmlPicArray(feed2));
        this.hotReplyHotPlug.bindTo(feed2);
        getHeaderViewPart().bindTo(feed2);
        this.relativeInfoHotPlug.bindTo(feed2);
        this.ratingDataHotPlug.bindTo(feed2);
        this.ratingHotPlug.bindTo(feed2);
        itemFeedRatingBinding.executePendingBindings();
        CoolEllipsizeTextView coolEllipsizeTextView = itemFeedRatingBinding.goodTextView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.goodTextView");
        String commentGood = feed2.getCommentGood();
        String str = "";
        if (commentGood == null) {
            commentGood = str;
        }
        ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 2, commentGood);
        CoolEllipsizeTextView coolEllipsizeTextView2 = itemFeedRatingBinding.badTextView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.badTextView");
        String commentBad = feed2.getCommentBad();
        if (commentBad == null) {
            commentBad = str;
        }
        ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView2, 2, commentBad);
        CoolEllipsizeTextView coolEllipsizeTextView3 = itemFeedRatingBinding.generalTextView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView3, "binding.generalTextView");
        String commentGeneral = feed2.getCommentGeneral();
        if (commentGeneral != null) {
            str = commentGeneral;
        }
        ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView3, 2, str);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedRatingBinding.getRoot();
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
        this.ratingDataHotPlug.onRecycled();
        this.ratingHotPlug.onRecycled();
    }
}
