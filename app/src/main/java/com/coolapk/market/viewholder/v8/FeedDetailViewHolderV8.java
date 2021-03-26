package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedDetailViewV8Binding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.FeedTextUtils;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.feed.reply.FeedDetailPresenter;
import com.coolapk.market.view.feed.reply.FeedFollowableHeaderViewPart;
import com.coolapk.market.viewholder.FeedExtraTypeViewPart;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.StateViewHolder;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.hotplug.BaseRatingHotPlug;
import com.coolapk.market.widget.hotplug.BaseSecondHandHeaderHotPlug;
import com.coolapk.market.widget.hotplug.BaseSecondHandHotPlug;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoModelKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001HB1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0003H\u0016J\u0010\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0006H\u0016J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010F\u001a\u00020>H\u0002J\u0006\u0010G\u001a\u00020>R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b/\u00100R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b8\u00109R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedDetailViewHolderV8;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedDetailViewV8Binding;", "Lcom/coolapk/market/model/HolderItem;", "Lcom/coolapk/market/util/RVStateEventChangedAdapter$IStateViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "flags", "", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;ILcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "extraEntityViewPart", "Lcom/coolapk/market/viewholder/v8/FeedExtraEntityViewPart;", "getExtraEntityViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedExtraEntityViewPart;", "extraEntityViewPart$delegate", "Lkotlin/Lazy;", "extraTypeViewPart", "Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart;", "getExtraTypeViewPart", "()Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart;", "extraTypeViewPart$delegate", "feed", "Lcom/coolapk/market/model/Feed;", "getFlags", "()I", "headerViewPart", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "headerViewPart$delegate", "nineImageViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNineImageViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "nineImageViewPart$delegate", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "ratingHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseRatingHotPlug;", "relativeInfoViewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "getRelativeInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "relativeInfoViewPart$delegate", "secondHandHeaderPlug", "Lcom/coolapk/market/widget/hotplug/BaseSecondHandHeaderHotPlug;", "secondHandInfoPlug", "Lcom/coolapk/market/widget/hotplug/BaseSecondHandHotPlug;", "sourceViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedSourceViewPart;", "getSourceViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedSourceViewPart;", "sourceViewPart$delegate", "videoViewHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "bindToContent", "", "data", "onClick", "view", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "populateFeedExtra", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailViewHolderV8.kt */
public final class FeedDetailViewHolderV8 extends GenericBindHolder<ItemFeedDetailViewV8Binding, HolderItem> implements RVStateEventChangedAdapter.IStateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558696;
    private final Lazy extraEntityViewPart$delegate;
    private final Lazy extraTypeViewPart$delegate;
    private Feed feed;
    private final int flags;
    private final Lazy headerViewPart$delegate;
    private final Lazy nineImageViewPart$delegate;
    private final FeedDetailPresenter presenter;
    private final BaseRatingHotPlug ratingHotPlug;
    private final Lazy relativeInfoViewPart$delegate;
    private final BaseSecondHandHeaderHotPlug secondHandHeaderPlug;
    private final BaseSecondHandHotPlug secondHandInfoPlug;
    private final Lazy sourceViewPart$delegate;
    private final BaseVideoHotPlug videoViewHotPlug;

    private final FeedExtraEntityViewPart getExtraEntityViewPart() {
        return (FeedExtraEntityViewPart) this.extraEntityViewPart$delegate.getValue();
    }

    private final FeedExtraTypeViewPart getExtraTypeViewPart() {
        return (FeedExtraTypeViewPart) this.extraTypeViewPart$delegate.getValue();
    }

    private final FeedFollowableHeaderViewPart getHeaderViewPart() {
        return (FeedFollowableHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final NinePicViewPart getNineImageViewPart() {
        return (NinePicViewPart) this.nineImageViewPart$delegate.getValue();
    }

    private final FeedRelativeInfoViewPart getRelativeInfoViewPart() {
        return (FeedRelativeInfoViewPart) this.relativeInfoViewPart$delegate.getValue();
    }

    private final FeedIntegratedSourceViewPart getSourceViewPart() {
        return (FeedIntegratedSourceViewPart) this.sourceViewPart$delegate.getValue();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedDetailViewHolderV8(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, itemActionHandler, (i2 & 8) != 0 ? 0 : i, feedDetailPresenter);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedDetailViewHolderV8(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.flags = i;
        this.presenter = feedDetailPresenter;
        ItemFeedDetailViewV8Binding itemFeedDetailViewV8Binding = (ItemFeedDetailViewV8Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedDetailViewV8Binding, "binding");
        itemFeedDetailViewV8Binding.setClick(this);
        this.nineImageViewPart$delegate = LazyKt.lazy(new FeedDetailViewHolderV8$nineImageViewPart$2(this, dataBindingComponent));
        this.extraTypeViewPart$delegate = LazyKt.lazy(new FeedDetailViewHolderV8$extraTypeViewPart$2(this, dataBindingComponent));
        this.headerViewPart$delegate = LazyKt.lazy(new FeedDetailViewHolderV8$headerViewPart$2(this, dataBindingComponent));
        this.sourceViewPart$delegate = LazyKt.lazy(new FeedDetailViewHolderV8$sourceViewPart$2(this, dataBindingComponent));
        this.relativeInfoViewPart$delegate = LazyKt.lazy(new FeedDetailViewHolderV8$relativeInfoViewPart$2(this));
        this.extraEntityViewPart$delegate = LazyKt.lazy(new FeedDetailViewHolderV8$extraEntityViewPart$2(this, dataBindingComponent));
        Space space = ((ItemFeedDetailViewV8Binding) getBinding()).videoPlayerSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.videoPlayerSpaceView");
        this.videoViewHotPlug = new BaseVideoHotPlug(space, dataBindingComponent, null, false, 4, null);
        Space space2 = ((ItemFeedDetailViewV8Binding) getBinding()).secondHandInfoSpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.secondHandInfoSpaceView");
        this.secondHandInfoPlug = new BaseSecondHandHotPlug(space2, dataBindingComponent, null, false, 4, null);
        Space space3 = ((ItemFeedDetailViewV8Binding) getBinding()).secondHandHeaderSpaceView;
        Intrinsics.checkNotNullExpressionValue(space3, "binding.secondHandHeaderSpaceView");
        this.secondHandHeaderPlug = new BaseSecondHandHeaderHotPlug(space3, dataBindingComponent, null, false, 4, null);
        Space space4 = ((ItemFeedDetailViewV8Binding) getBinding()).ratingSpaceView;
        Intrinsics.checkNotNullExpressionValue(space4, "binding.ratingSpaceView");
        this.ratingHotPlug = new BaseRatingHotPlug(space4, dataBindingComponent, null, false, 4, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedDetailViewHolderV8$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedDetailViewHolderV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return StateViewHolder.isEventBelongTo(event, feed2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f2, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.getExtraType(), "apk") != false) goto L_0x01f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    public void bindToContent(HolderItem holderItem) {
        Feed feed2;
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ItemFeedDetailViewV8Binding itemFeedDetailViewV8Binding = (ItemFeedDetailViewV8Binding) getBinding();
        this.feed = this.presenter.getFeed();
        Intrinsics.checkNotNullExpressionValue(itemFeedDetailViewV8Binding, "binding");
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        itemFeedDetailViewV8Binding.setModel(feed3);
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        VideoModel videoModel = VideoModelKt.toVideoModel(feed4);
        Feed feed5 = this.feed;
        if (feed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        if (!feed5.isForwardFeed()) {
            NinePicViewPart nineImageViewPart = getNineImageViewPart();
            Feed feed6 = this.feed;
            if (feed6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            nineImageViewPart.bindToContent(EntityExtendsKt.getHtmlPicArray(feed6));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[SecondHand]");
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 36.0f), 0);
        spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[SecondHand]"), 0, spannableStringBuilder.length(), 33);
        Feed feed7 = this.feed;
        if (feed7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        spannableStringBuilder.append((CharSequence) feed7.getMessageTitle());
        Feed feed8 = this.feed;
        if (feed8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        SecondHandInfo secondHandInfo = feed8.getSecondHandInfo();
        boolean z = true;
        int i = 8;
        if (secondHandInfo != null) {
            getNineImageViewPart().setInSecondHand(true);
            TextView textView = itemFeedDetailViewV8Binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(spannableStringBuilder);
            TextView textView2 = itemFeedDetailViewV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleTagView");
            textView2.setVisibility(0);
            boolean z2 = secondHandInfo.getStoreType() == 2;
            TextView textView3 = itemFeedDetailViewV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleTagView");
            textView3.setText(secondHandInfo.getStoreTypeText());
            int colorInt = ResourceUtils.getColorInt(getContext(), 2131100035);
            int colorInt2 = ResourceUtils.getColorInt(getContext(), 2131099687);
            if (!z2) {
                colorInt = colorInt2;
            }
            TextView textView4 = itemFeedDetailViewV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleTagView");
            textView4.setBackground(new ColorDrawable(colorInt));
            ImageView imageView = itemFeedDetailViewV8Binding.imgSellView;
            if (secondHandInfo.isSelled()) {
                i = 0;
            }
            imageView.setVisibility(i);
            imageView.setAlpha(0.1f);
            Feed feed9 = this.feed;
            if (feed9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (feed9.getTargetRow() != null) {
                ImageView imageView2 = itemFeedDetailViewV8Binding.imgSellView;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imgSellView");
                ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(imageView2);
                if (marginParams != null) {
                    marginParams.topMargin = NumberExtendsKt.getDp((Number) 116);
                }
            }
        } else {
            TextView textView5 = itemFeedDetailViewV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleTagView");
            textView5.setText("");
            TextView textView6 = itemFeedDetailViewV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleTagView");
            textView6.setVisibility(8);
            TextView textView7 = itemFeedDetailViewV8Binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
            Feed feed10 = this.feed;
            if (feed10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            textView7.setText(feed10.getMessageTitle());
            FrameLayout frameLayout = itemFeedDetailViewV8Binding.titleContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.titleContainer");
            frameLayout.setVisibility(8);
            ImageView imageView3 = itemFeedDetailViewV8Binding.imgSellView;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.imgSellView");
            imageView3.setVisibility(8);
        }
        BaseRatingHotPlug baseRatingHotPlug = this.ratingHotPlug;
        Feed feed11 = this.feed;
        if (feed11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        baseRatingHotPlug.bindTo(feed11);
        FeedFollowableHeaderViewPart headerViewPart = getHeaderViewPart();
        Feed feed12 = this.feed;
        if (feed12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        headerViewPart.bindToContent(feed12);
        FeedIntegratedSourceViewPart sourceViewPart = getSourceViewPart();
        Feed feed13 = this.feed;
        if (feed13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        sourceViewPart.bindTo(feed13);
        FeedRelativeInfoViewPart relativeInfoViewPart = getRelativeInfoViewPart();
        Feed feed14 = this.feed;
        if (feed14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        relativeInfoViewPart.bindTo(feed14);
        this.videoViewHotPlug.bindTo(videoModel);
        BaseSecondHandHeaderHotPlug baseSecondHandHeaderHotPlug = this.secondHandHeaderPlug;
        Feed feed15 = this.feed;
        if (feed15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        baseSecondHandHeaderHotPlug.bindTo(feed15);
        BaseSecondHandHotPlug baseSecondHandHotPlug = this.secondHandInfoPlug;
        Feed feed16 = this.feed;
        if (feed16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        baseSecondHandHotPlug.bindTo(feed16);
        this.videoViewHotPlug.setOrderKey(getAdapterPosition());
        FeedExtraEntityViewPart extraEntityViewPart = getExtraEntityViewPart();
        Feed feed17 = this.feed;
        if (feed17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        extraEntityViewPart.bindTo(feed17);
        if (videoModel.isValid()) {
            Feed feed18 = this.feed;
            if (feed18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
        }
        populateFeedExtra();
        itemFeedDetailViewV8Binding.textViewContainer.setOnLongClickListener(new FeedDetailViewHolderV8$bindToContent$3(this));
        itemFeedDetailViewV8Binding.cardView.setOnLongClickListener(new FeedDetailViewHolderV8$bindToContent$4(this));
        Feed feed19 = this.feed;
        if (feed19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String pic = feed19.getPic();
        if (pic == null || pic.length() == 0) {
            Feed feed20 = this.feed;
            if (feed20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (!feed20.isForwardFeed()) {
                Feed feed21 = this.feed;
                if (feed21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                String extraTitle = feed21.getExtraTitle();
                if (!(extraTitle == null || extraTitle.length() == 0)) {
                    z = false;
                }
                if (z && !videoModel.isValid()) {
                    TextView textView8 = itemFeedDetailViewV8Binding.textView;
                    Intrinsics.checkNotNullExpressionValue(textView8, "binding.textView");
                    textView8.setMinLines(3);
                    itemFeedDetailViewV8Binding.executePendingBindings();
                    feed2 = this.feed;
                    if (feed2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feed");
                    }
                    if (!feed2.isForwardFeed()) {
                        Feed feed22 = this.feed;
                        if (feed22 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feed");
                        }
                        if (!TextUtils.isEmpty(feed22.getPic())) {
                            TextView textView9 = itemFeedDetailViewV8Binding.textView;
                            Intrinsics.checkNotNullExpressionValue(textView9, "binding.textView");
                            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(textView9.getText());
                            Feed feed23 = this.feed;
                            if (feed23 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feed");
                            }
                            String pic2 = feed23.getPic();
                            Feed feed24 = this.feed;
                            if (feed24 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feed");
                            }
                            ImageUrl create = ImageUrl.create(pic2, feed24.getMiddleSizePic());
                            Intrinsics.checkNotNullExpressionValue(create, "imageUrl");
                            FeedTextUtils.insertPhotoLink(spannableStringBuilder2, create);
                            TextView textView10 = itemFeedDetailViewV8Binding.textView;
                            Intrinsics.checkNotNullExpressionValue(textView10, "binding.textView");
                            textView10.setText(spannableStringBuilder2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        TextView textView11 = itemFeedDetailViewV8Binding.textView;
        Intrinsics.checkNotNullExpressionValue(textView11, "binding.textView");
        textView11.setMinLines(0);
        itemFeedDetailViewV8Binding.executePendingBindings();
        feed2 = this.feed;
        if (feed2 == null) {
        }
        if (!feed2.isForwardFeed()) {
        }
    }

    private final void populateFeedExtra() {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        List<Entity> extraEntities = feed2.getExtraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "feed.extraEntities");
        if (!(!extraEntities.isEmpty())) {
            Feed feed3 = this.feed;
            if (feed3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (Intrinsics.areEqual(feed3.getExtraType(), "apk")) {
                if (!Intrinsics.areEqual(((ItemFeedDetailViewV8Binding) getBinding()).extraApkTypeContainer.getChildAt(0), getExtraTypeViewPart().getView())) {
                    ViewExtendsKt.detachFromParent(getExtraTypeViewPart().getView());
                    ((ItemFeedDetailViewV8Binding) getBinding()).extraApkTypeContainer.addView(getExtraTypeViewPart().getView());
                }
            } else if (!Intrinsics.areEqual(((ItemFeedDetailViewV8Binding) getBinding()).extraTypeContainer.getChildAt(0), getExtraTypeViewPart().getView())) {
                ViewExtendsKt.detachFromParent(getExtraTypeViewPart().getView());
                ((ItemFeedDetailViewV8Binding) getBinding()).extraTypeContainer.addView(getExtraTypeViewPart().getView());
            }
            ViewGroup.LayoutParams layoutParams = getExtraTypeViewPart().getView().getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = NumberExtendsKt.getDp((Number) 12);
                marginLayoutParams.leftMargin = NumberExtendsKt.getDp((Number) 16);
                marginLayoutParams.rightMargin = NumberExtendsKt.getDp((Number) 16);
                marginLayoutParams.bottomMargin = 0;
            }
            FeedExtraTypeViewPart extraTypeViewPart = getExtraTypeViewPart();
            Feed feed4 = this.feed;
            if (feed4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            extraTypeViewPart.bindToContent(feed4);
        }
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
