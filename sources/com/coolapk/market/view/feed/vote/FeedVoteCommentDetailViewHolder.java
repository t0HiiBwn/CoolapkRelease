package com.coolapk.market.view.feed.vote;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedVoteCommentDetailBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.reply.FeedDetailPresenter;
import com.coolapk.market.view.feed.reply.FeedFollowableHeaderViewPart;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u001c\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003H\u0016J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020+H\u0002R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b'\u0010(¨\u00061"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteCommentDetailViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedVoteCommentDetailBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "flags", "", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;ILcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed", "()Lcom/coolapk/market/model/Feed;", "getFlags", "()I", "headerViewPart", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "nineImageHotPlug", "com/coolapk/market/view/feed/vote/FeedVoteCommentDetailViewHolder$nineImageHotPlug$1", "Lcom/coolapk/market/view/feed/vote/FeedVoteCommentDetailViewHolder$nineImageHotPlug$1;", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "relativeInfoViewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "getRelativeInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "relativeInfoViewPart$delegate", "voteDetailViewPart", "Lcom/coolapk/market/view/feed/vote/VoteCommentDetailViewPart;", "getVoteDetailViewPart", "()Lcom/coolapk/market/view/feed/vote/VoteCommentDetailViewPart;", "voteDetailViewPart$delegate", "bindToContent", "", "data", "onClick", "view", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteCommentDetailViewHolder.kt */
public final class FeedVoteCommentDetailViewHolder extends GenericBindHolder<ItemFeedVoteCommentDetailBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558744;
    private final int flags;
    private final Lazy headerViewPart$delegate;
    private final FeedVoteCommentDetailViewHolder$nineImageHotPlug$1 nineImageHotPlug;
    private final FeedDetailPresenter presenter;
    private final Lazy relativeInfoViewPart$delegate;
    private final Lazy voteDetailViewPart$delegate;

    private final FeedFollowableHeaderViewPart getHeaderViewPart() {
        return (FeedFollowableHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final FeedRelativeInfoViewPart getRelativeInfoViewPart() {
        return (FeedRelativeInfoViewPart) this.relativeInfoViewPart$delegate.getValue();
    }

    private final VoteCommentDetailViewPart getVoteDetailViewPart() {
        return (VoteCommentDetailViewPart) this.voteDetailViewPart$delegate.getValue();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedVoteCommentDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, itemActionHandler, (i2 & 8) != 0 ? 0 : i, feedDetailPresenter);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedVoteCommentDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.flags = i;
        this.presenter = feedDetailPresenter;
        ItemFeedVoteCommentDetailBinding itemFeedVoteCommentDetailBinding = (ItemFeedVoteCommentDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteCommentDetailBinding, "binding");
        itemFeedVoteCommentDetailBinding.setClick(this);
        Space space = ((ItemFeedVoteCommentDetailBinding) getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        this.nineImageHotPlug = new FeedVoteCommentDetailViewHolder$nineImageHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        this.headerViewPart$delegate = LazyKt.lazy(new FeedVoteCommentDetailViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.relativeInfoViewPart$delegate = LazyKt.lazy(new FeedVoteCommentDetailViewHolder$relativeInfoViewPart$2(this));
        this.voteDetailViewPart$delegate = LazyKt.lazy(new FeedVoteCommentDetailViewHolder$voteDetailViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteCommentDetailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteCommentDetailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Feed getFeed() {
        return this.presenter.getFeed();
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ItemFeedVoteCommentDetailBinding itemFeedVoteCommentDetailBinding = (ItemFeedVoteCommentDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteCommentDetailBinding, "binding");
        itemFeedVoteCommentDetailBinding.setModel(getFeed());
        getHeaderViewPart().bindToContent(getFeed());
        getRelativeInfoViewPart().bindTo(getFeed());
        getVoteDetailViewPart().bindToContent(getFeed());
        this.nineImageHotPlug.bindTo(EntityExtendsKt.getHtmlPicArray(getFeed()));
        itemFeedVoteCommentDetailBinding.textViewContainer.setOnLongClickListener(new FeedVoteCommentDetailViewHolder$bindToContent$1(this));
        itemFeedVoteCommentDetailBinding.cardView.setOnLongClickListener(new FeedVoteCommentDetailViewHolder$bindToContent$2(this));
        itemFeedVoteCommentDetailBinding.executePendingBindings();
    }

    /* access modifiers changed from: private */
    public final void showItemDialog() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            EntityExtendsKt.showItemDialog(getFeed(), activityNullable);
        }
    }
}
