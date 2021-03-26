package com.coolapk.market.view.feed.reply;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedRatingDetailBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.RatingTagShape;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0016J\u0006\u0010.\u001a\u00020,R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0014\u001a\u0004\b(\u0010)¨\u00060"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedRatingDetailViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedRatingDetailBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "flags", "", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;ILcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "badImageViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getBadImageViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "badImageViewPart$delegate", "Lkotlin/Lazy;", "feed", "Lcom/coolapk/market/model/Feed;", "getFlags", "()I", "generalImageViewPart", "getGeneralImageViewPart", "generalImageViewPart$delegate", "goodImageViewPart", "getGoodImageViewPart", "goodImageViewPart$delegate", "headerViewPart", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "headerViewPart$delegate", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "relativeInfoViewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "getRelativeInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "relativeInfoViewPart$delegate", "bindToContent", "", "data", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedRatingDetailViewHolder.kt */
public final class FeedRatingDetailViewHolder extends GenericBindHolder<ItemFeedRatingDetailBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558720;
    private final Lazy badImageViewPart$delegate;
    private Feed feed;
    private final int flags;
    private final Lazy generalImageViewPart$delegate;
    private final Lazy goodImageViewPart$delegate;
    private final Lazy headerViewPart$delegate;
    private final FeedDetailPresenter presenter;
    private final Lazy relativeInfoViewPart$delegate;

    private final NinePicViewPart getBadImageViewPart() {
        return (NinePicViewPart) this.badImageViewPart$delegate.getValue();
    }

    private final NinePicViewPart getGeneralImageViewPart() {
        return (NinePicViewPart) this.generalImageViewPart$delegate.getValue();
    }

    private final NinePicViewPart getGoodImageViewPart() {
        return (NinePicViewPart) this.goodImageViewPart$delegate.getValue();
    }

    private final FeedFollowableHeaderViewPart getHeaderViewPart() {
        return (FeedFollowableHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final FeedRelativeInfoViewPart getRelativeInfoViewPart() {
        return (FeedRelativeInfoViewPart) this.relativeInfoViewPart$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedRatingDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, itemActionHandler, (i2 & 8) != 0 ? 0 : i, feedDetailPresenter);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedRatingDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.flags = i;
        this.presenter = feedDetailPresenter;
        ItemFeedRatingDetailBinding itemFeedRatingDetailBinding = (ItemFeedRatingDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedRatingDetailBinding, "binding");
        itemFeedRatingDetailBinding.setClick(this);
        ((ItemFeedRatingDetailBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.view.feed.reply.FeedRatingDetailViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedRatingDetailViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                this.this$0.showItemDialog();
                return true;
            }
        });
        this.goodImageViewPart$delegate = LazyKt.lazy(new FeedRatingDetailViewHolder$goodImageViewPart$2(this, dataBindingComponent));
        this.generalImageViewPart$delegate = LazyKt.lazy(new FeedRatingDetailViewHolder$generalImageViewPart$2(this, dataBindingComponent));
        this.badImageViewPart$delegate = LazyKt.lazy(new FeedRatingDetailViewHolder$badImageViewPart$2(this, dataBindingComponent));
        this.headerViewPart$delegate = LazyKt.lazy(new FeedRatingDetailViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.relativeInfoViewPart$delegate = LazyKt.lazy(new FeedRatingDetailViewHolder$relativeInfoViewPart$2(this));
        ((ItemFeedRatingDetailBinding) getBinding()).ratingBar.setProgressBar(NumberExtendsKt.getDp((Number) 22), true);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedRatingDetailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedRatingDetailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        boolean z;
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ItemFeedRatingDetailBinding itemFeedRatingDetailBinding = (ItemFeedRatingDetailBinding) getBinding();
        this.feed = this.presenter.getFeed();
        Intrinsics.checkNotNullExpressionValue(itemFeedRatingDetailBinding, "binding");
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        itemFeedRatingDetailBinding.setModel(feed2);
        TextView textView = itemFeedRatingDetailBinding.goodTagsView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.goodTagsView");
        textView.setBackground(new ShapeDrawable(new RatingTagShape()));
        TextView textView2 = itemFeedRatingDetailBinding.badTagsView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.badTagsView");
        textView2.setBackground(new ShapeDrawable(new RatingTagShape()));
        TextView textView3 = itemFeedRatingDetailBinding.generalTagsView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.generalTagsView");
        textView3.setBackground(new ShapeDrawable(new RatingTagShape()));
        TextView textView4 = itemFeedRatingDetailBinding.ratingTagsView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.ratingTagsView");
        textView4.setBackground(new ShapeDrawable(new RatingTagShape()));
        NinePicViewPart goodImageViewPart = getGoodImageViewPart();
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String commentGoodPic = feed3.getCommentGoodPic();
        String str = "";
        if (commentGoodPic == null) {
            commentGoodPic = str;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = StringsKt.split$default((CharSequence) commentGoodPic, new String[]{","}, false, 0, 6, (Object) null).iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (true ^ StringsKt.isBlank((String) next)) {
                arrayList.add(next);
            }
        }
        goodImageViewPart.bindToContent(arrayList);
        NinePicViewPart badImageViewPart = getBadImageViewPart();
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String commentBadPic = feed4.getCommentBadPic();
        if (commentBadPic == null) {
            commentBadPic = str;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) commentBadPic, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        badImageViewPart.bindToContent(arrayList2);
        NinePicViewPart generalImageViewPart = getGeneralImageViewPart();
        Feed feed5 = this.feed;
        if (feed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String commentGeneralPic = feed5.getCommentGeneralPic();
        if (commentGeneralPic != null) {
            str = commentGeneralPic;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList3.add(obj2);
            }
        }
        generalImageViewPart.bindToContent(arrayList3);
        BadBadRatingBar badBadRatingBar = itemFeedRatingDetailBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        ProductGlobalData productGlobalData = ProductGlobalData.INSTANCE;
        Feed feed6 = this.feed;
        if (feed6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        badBadRatingBar.setRating(productGlobalData.ratingScoreToStartScore(feed6.getRatingScore()));
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar2 = itemFeedRatingDetailBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar2, "binding.ratingBar");
        BadBadRatingBar badBadRatingBar3 = itemFeedRatingDetailBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(badBadRatingBar2, (int) badBadRatingBar3.getRating());
        TextView textView5 = itemFeedRatingDetailBinding.scoreView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.scoreView");
        StringBuilder sb = new StringBuilder();
        Feed feed7 = this.feed;
        if (feed7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        sb.append(EntityExtendsKt.getDisplayRatingScore(feed7));
        sb.append((char) 20998);
        textView5.setText(sb.toString());
        Feed feed8 = this.feed;
        if (feed8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String productStatusText = EntityExtendsKt.getProductStatusText(feed8);
        LinearLayout linearLayout = itemFeedRatingDetailBinding.ownerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.ownerView");
        LinearLayout linearLayout2 = linearLayout;
        String str2 = productStatusText;
        int i = 0;
        if (str2.length() <= 0) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        TextView textView6 = itemFeedRatingDetailBinding.ownerTextView;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.ownerTextView");
        textView6.setText(str2);
        FeedFollowableHeaderViewPart headerViewPart = getHeaderViewPart();
        Feed feed9 = this.feed;
        if (feed9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        headerViewPart.bindToContent(feed9);
        FeedRelativeInfoViewPart relativeInfoViewPart = getRelativeInfoViewPart();
        Feed feed10 = this.feed;
        if (feed10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        relativeInfoViewPart.bindTo(feed10);
        itemFeedRatingDetailBinding.executePendingBindings();
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
}
