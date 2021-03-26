package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedDiscoveryDetailBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.view.feed.reply.FeedDetailPresenter;
import com.coolapk.market.view.feed.reply.FeedFollowableHeaderViewPart;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0006\u0010*\u001a\u00020&R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lcom/coolapk/market/viewholder/v8/DiscoveryDetailViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedDiscoveryDetailBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "flags", "", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;ILcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "feed", "Lcom/coolapk/market/model/Feed;", "getFlags", "()I", "headerViewPart", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "imageViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getImageViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "imageViewPart$delegate", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "relativeInfoViewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "getRelativeInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "relativeInfoViewPart$delegate", "bindToContent", "", "data", "onClick", "view", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DiscoveryDetailViewHolder.kt */
public final class DiscoveryDetailViewHolder extends GenericBindHolder<ItemFeedDiscoveryDetailBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558704;
    private Feed feed;
    private final int flags;
    private final Lazy headerViewPart$delegate;
    private final Lazy imageViewPart$delegate;
    private final FeedDetailPresenter presenter;
    private final Lazy relativeInfoViewPart$delegate;

    private final FeedFollowableHeaderViewPart getHeaderViewPart() {
        return (FeedFollowableHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final NinePicViewPart getImageViewPart() {
        return (NinePicViewPart) this.imageViewPart$delegate.getValue();
    }

    private final FeedRelativeInfoViewPart getRelativeInfoViewPart() {
        return (FeedRelativeInfoViewPart) this.relativeInfoViewPart$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DiscoveryDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, itemActionHandler, (i2 & 8) != 0 ? 0 : i, feedDetailPresenter);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiscoveryDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.flags = i;
        this.presenter = feedDetailPresenter;
        ItemFeedDiscoveryDetailBinding itemFeedDiscoveryDetailBinding = (ItemFeedDiscoveryDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedDiscoveryDetailBinding, "binding");
        itemFeedDiscoveryDetailBinding.setClick(this);
        this.headerViewPart$delegate = LazyKt.lazy(new DiscoveryDetailViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.relativeInfoViewPart$delegate = LazyKt.lazy(new DiscoveryDetailViewHolder$relativeInfoViewPart$2(this));
        this.imageViewPart$delegate = LazyKt.lazy(new DiscoveryDetailViewHolder$imageViewPart$2(this, dataBindingComponent, view));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/DiscoveryDetailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DiscoveryDetailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ItemFeedDiscoveryDetailBinding itemFeedDiscoveryDetailBinding = (ItemFeedDiscoveryDetailBinding) getBinding();
        this.feed = this.presenter.getFeed();
        Intrinsics.checkNotNullExpressionValue(itemFeedDiscoveryDetailBinding, "binding");
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        itemFeedDiscoveryDetailBinding.setModel(feed2);
        FeedFollowableHeaderViewPart headerViewPart = getHeaderViewPart();
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        headerViewPart.bindToContent(feed3);
        FeedRelativeInfoViewPart relativeInfoViewPart = getRelativeInfoViewPart();
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        relativeInfoViewPart.bindTo(feed4);
        Feed feed5 = this.feed;
        if (feed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        if (feed5.getPicArray().size() >= 3) {
            getImageViewPart().setMaxShowCount(3);
        } else {
            getImageViewPart().setMaxShowCount(1);
        }
        NinePicViewPart imageViewPart = getImageViewPart();
        Feed feed6 = this.feed;
        if (feed6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        List<String> picArray = feed6.getPicArray();
        Intrinsics.checkNotNullExpressionValue(picArray, "feed.picArray");
        imageViewPart.bindToContent(picArray);
        itemFeedDiscoveryDetailBinding.textViewContainer.setOnLongClickListener(new DiscoveryDetailViewHolder$bindToContent$1(this));
        itemFeedDiscoveryDetailBinding.cardView.setOnLongClickListener(new DiscoveryDetailViewHolder$bindToContent$2(this));
        itemFeedDiscoveryDetailBinding.executePendingBindings();
    }

    public final void showItemDialog() {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EntityExtendsKt.showItemDialog(feed2, context);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == 2131361877 || id == 2131362745) {
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (FeedUtils.isDiscoveryType(feed2.getFeedType())) {
                Feed feed3 = this.feed;
                if (feed3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                if (feed3.isIncludedDiscoveryFeed()) {
                    Context context = getContext();
                    Feed feed4 = this.feed;
                    if (feed4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feed");
                    }
                    ActionManager.startAppViewActivity(context, feed4.getPackageName());
                    return;
                }
                Context context2 = getContext();
                StringBuilder sb = new StringBuilder();
                sb.append("https://www.coolapk.com");
                Feed feed5 = this.feed;
                if (feed5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                String extraLinkUrl = feed5.getExtraLinkUrl();
                Intrinsics.checkNotNull(extraLinkUrl);
                sb.append(extraLinkUrl);
                String sb2 = sb.toString();
                Feed feed6 = this.feed;
                if (feed6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                String extraInfo = feed6.getExtraInfo();
                Feed feed7 = this.feed;
                if (feed7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                ActionManager.startExternalMarketByName(context2, sb2, extraInfo, feed7.getExtraKey());
                return;
            }
            return;
        }
        super.onClick(view);
    }
}
