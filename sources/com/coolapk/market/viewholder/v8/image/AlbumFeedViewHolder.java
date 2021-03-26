package com.coolapk.market.viewholder.v8.image;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedAlbumLayoutBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/AlbumFeedViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedAlbumLayoutBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "bindToContent", "", "hideInfoView", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumFeedViewHolder.kt */
public final class AlbumFeedViewHolder extends GenericBindHolder<ItemFeedAlbumLayoutBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558691;
    private Feed feed;
    private final Lazy headerViewPart$delegate;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumFeedViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.headerViewPart$delegate = LazyKt.lazy(new AlbumFeedViewHolder$headerViewPart$2(this, dataBindingComponent));
        ItemFeedAlbumLayoutBinding itemFeedAlbumLayoutBinding = (ItemFeedAlbumLayoutBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedAlbumLayoutBinding, "binding");
        itemFeedAlbumLayoutBinding.setClick(this);
        ItemFeedAlbumLayoutBinding itemFeedAlbumLayoutBinding2 = (ItemFeedAlbumLayoutBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedAlbumLayoutBinding2, "binding");
        itemFeedAlbumLayoutBinding2.setTransformer(new CircleTransform(false, 0, 3, null));
        ((ItemFeedAlbumLayoutBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.image.AlbumFeedViewHolder.AnonymousClass1 */
            final /* synthetic */ AlbumFeedViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed feed = this.this$0.feed;
                if (feed == null) {
                    return true;
                }
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(feed, context);
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/AlbumFeedViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumFeedViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.feed = feed2;
        ItemFeedAlbumLayoutBinding itemFeedAlbumLayoutBinding = (ItemFeedAlbumLayoutBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedAlbumLayoutBinding, "binding");
        itemFeedAlbumLayoutBinding.setModel(feed2);
        getHeaderViewPart().bindTo(feed2);
        CoolEllipsizeTextView coolEllipsizeTextView = itemFeedAlbumLayoutBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
        String messageTitle = feed2.getMessageTitle();
        if (messageTitle == null) {
            messageTitle = "";
        }
        ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 2, messageTitle);
        TextView textView = itemFeedAlbumLayoutBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        String message = feed2.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "feed.message");
        String replace = new Regex("[\\n\\r]").replace(message, " ");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886656));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
        Unit unit = Unit.INSTANCE;
        ViewExtendsKt.setBriefMessage(textView, 75, replace, spannableStringBuilder);
        itemFeedAlbumLayoutBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed2 = this.feed;
        if (feed2 == null) {
            return;
        }
        if (view.getId() != 2131362200) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed2), null, null, 12, null);
    }

    public final void hideInfoView() {
        getHeaderViewPart().hideFromWhereView();
    }
}
