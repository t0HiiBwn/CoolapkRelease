package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedLayoutV8Binding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.FeedTextUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.cardlist.EntityDataHelper;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.StateViewHolder;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.MainSpareHandler;
import com.coolapk.market.widget.hotplug.BaseFeedArticleSourceHotPlug;
import com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug;
import com.coolapk.market.widget.hotplug.BaseHotReplyHotPlug;
import com.coolapk.market.widget.hotplug.BaseRatingDataHotPlug;
import com.coolapk.market.widget.hotplug.BaseRatingHotPlug;
import com.coolapk.market.widget.hotplug.BaseSecondHandHeaderHotPlug;
import com.coolapk.market.widget.hotplug.BaseSourceHotPlug;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import com.coolapk.market.widget.video.VideoModelKt;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0014!\b\u0016\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001<B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u00101\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0006\u00103\u001a\u000202J\b\u00104\u001a\u000202H\u0002J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u000202H\u0016J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedViewHolderV8;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedLayoutV8Binding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/util/RVStateEventChangedAdapter$IStateViewHolder;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "extraEntityViewPart", "Lcom/coolapk/market/viewholder/v8/FeedExtraEntityViewPart;", "getExtraEntityViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedExtraEntityViewPart;", "extraEntityViewPart$delegate", "Lkotlin/Lazy;", "extraTypeHotPlug", "com/coolapk/market/viewholder/v8/FeedViewHolderV8$extraTypeHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedViewHolderV8$extraTypeHotPlug$1;", "feed", "feedArticleSourcePlug", "Lcom/coolapk/market/widget/hotplug/BaseFeedArticleSourceHotPlug;", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "hotReplyHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseHotReplyHotPlug;", "nineImageHotPlug", "com/coolapk/market/viewholder/v8/FeedViewHolderV8$nineImageHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedViewHolderV8$nineImageHotPlug$1;", "ratingDataHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseRatingDataHotPlug;", "ratingHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseRatingHotPlug;", "relativeInfoHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseFeedRelativeHotPlug;", "secondHandHeaderPlug", "Lcom/coolapk/market/widget/hotplug/BaseSecondHandHeaderHotPlug;", "sourceHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseSourceHotPlug;", "videoViewHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "bindToContent", "", "hideFromWhereView", "initViewParts", "onClick", "view", "onRecycled", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedViewHolderV8.kt */
public class FeedViewHolderV8 extends GenericBindHolder<ItemFeedLayoutV8Binding, Feed> implements RVStateEventChangedAdapter.IStateViewHolder, Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558715;
    private final Lazy extraEntityViewPart$delegate;
    private final FeedViewHolderV8$extraTypeHotPlug$1 extraTypeHotPlug;
    private Feed feed;
    private final BaseFeedArticleSourceHotPlug feedArticleSourcePlug;
    private final Lazy headerViewPart$delegate;
    private final BaseHotReplyHotPlug hotReplyHotPlug;
    private final FeedViewHolderV8$nineImageHotPlug$1 nineImageHotPlug;
    private final BaseRatingDataHotPlug ratingDataHotPlug;
    private final BaseRatingHotPlug ratingHotPlug;
    private final BaseFeedRelativeHotPlug relativeInfoHotPlug;
    private final BaseSecondHandHeaderHotPlug secondHandHeaderPlug;
    private final BaseSourceHotPlug sourceHotPlug;
    private final BaseVideoHotPlug videoViewHotPlug;
    private final ViewPartPool viewPartPool;

    private final FeedExtraEntityViewPart getExtraEntityViewPart() {
        return (FeedExtraEntityViewPart) this.extraEntityViewPart$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getFeed$p(FeedViewHolderV8 feedViewHolderV8) {
        Feed feed2 = feedViewHolderV8.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedViewHolderV8(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ViewPartPool viewPartPool2 = KotlinExtendKt.getViewPartPool(dataBindingComponent);
        viewPartPool2 = viewPartPool2 == null ? new ViewPartPool() : viewPartPool2;
        this.viewPartPool = viewPartPool2;
        ItemFeedLayoutV8Binding itemFeedLayoutV8Binding = (ItemFeedLayoutV8Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedLayoutV8Binding, "binding");
        itemFeedLayoutV8Binding.setClick(this);
        itemFeedLayoutV8Binding.setTransformer(new CircleTransform(false, 0, 3, null));
        itemFeedLayoutV8Binding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.FeedViewHolderV8.AnonymousClass1 */
            final /* synthetic */ FeedViewHolderV8 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed access$getFeed$p = FeedViewHolderV8.access$getFeed$p(this.this$0);
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(access$getFeed$p, context);
                return true;
            }
        });
        initViewParts();
        Space space = ((ItemFeedLayoutV8Binding) getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        this.nineImageHotPlug = new FeedViewHolderV8$nineImageHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        Space space2 = ((ItemFeedLayoutV8Binding) getBinding()).hotReplySpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.hotReplySpaceView");
        this.hotReplyHotPlug = new BaseHotReplyHotPlug(space2, dataBindingComponent, null, false, 12, null);
        Space space3 = ((ItemFeedLayoutV8Binding) getBinding()).secondHandHeaderSpaceView;
        Intrinsics.checkNotNullExpressionValue(space3, "binding.secondHandHeaderSpaceView");
        this.secondHandHeaderPlug = new BaseSecondHandHeaderHotPlug(space3, dataBindingComponent, null, false, 12, null);
        Space space4 = ((ItemFeedLayoutV8Binding) getBinding()).articleSourceSpaceView;
        Intrinsics.checkNotNullExpressionValue(space4, "binding.articleSourceSpaceView");
        this.feedArticleSourcePlug = new BaseFeedArticleSourceHotPlug(space4, dataBindingComponent, null, false, 12, null);
        this.extraTypeHotPlug = new FeedViewHolderV8$extraTypeHotPlug$1(this, dataBindingComponent, 2131558705, viewPartPool2);
        this.headerViewPart$delegate = LazyKt.lazy(new FeedViewHolderV8$headerViewPart$2(this, dataBindingComponent));
        Space space5 = ((ItemFeedLayoutV8Binding) getBinding()).sourceSpaceView;
        Intrinsics.checkNotNullExpressionValue(space5, "binding.sourceSpaceView");
        this.sourceHotPlug = new BaseSourceHotPlug(space5, dataBindingComponent, null, 4, null);
        Space space6 = ((ItemFeedLayoutV8Binding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space6, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new BaseFeedRelativeHotPlug(space6, dataBindingComponent, null, false, 12, null);
        Space space7 = ((ItemFeedLayoutV8Binding) getBinding()).videoPlayerSpaceView;
        Intrinsics.checkNotNullExpressionValue(space7, "binding.videoPlayerSpaceView");
        this.videoViewHotPlug = new BaseVideoHotPlug(space7, dataBindingComponent, null, false, 12, null);
        Space space8 = ((ItemFeedLayoutV8Binding) getBinding()).ratingSpaceView;
        Intrinsics.checkNotNullExpressionValue(space8, "binding.ratingSpaceView");
        this.ratingHotPlug = new BaseRatingHotPlug(space8, dataBindingComponent, null, false, 12, null);
        Space space9 = ((ItemFeedLayoutV8Binding) getBinding()).ratingDataSpaceView;
        Intrinsics.checkNotNullExpressionValue(space9, "binding.ratingDataSpaceView");
        this.ratingDataHotPlug = new BaseRatingDataHotPlug(space9, dataBindingComponent, null, false, 12, null);
        this.extraEntityViewPart$delegate = LazyKt.lazy(new FeedViewHolderV8$extraEntityViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedViewHolderV8$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedViewHolderV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void initViewParts() {
        MainSpareHandler.Companion.getSInstance().post(new FeedViewHolderV8$initViewParts$1(this));
    }

    @Override // com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return StateViewHolder.isEventBelongTo(event, feed2);
    }

    public void bindToContent(Feed feed2) {
        EntityDataHelper entityDataHelper$presentation_coolapkAppRelease;
        Intrinsics.checkNotNullParameter(feed2, "feed");
        ItemFeedLayoutV8Binding itemFeedLayoutV8Binding = (ItemFeedLayoutV8Binding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedLayoutV8Binding, "binding");
        itemFeedLayoutV8Binding.setModel(feed2);
        FrameLayout frameLayout = itemFeedLayoutV8Binding.titleContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.titleContainer");
        FrameLayout frameLayout2 = frameLayout;
        String messageTitle = feed2.getMessageTitle();
        boolean z = true;
        int i = 8;
        frameLayout2.setVisibility(messageTitle == null || StringsKt.isBlank(messageTitle) ? 8 : 0);
        if (feed2.isSecondHand()) {
            SecondHandInfo secondHandInfo = feed2.getSecondHandInfo();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[SecondHand]");
            ColorDrawable colorDrawable = new ColorDrawable(0);
            colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 38.0f), 0);
            spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[SecondHand]"), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) feed2.getMessageTitle());
            TextView textView = itemFeedLayoutV8Binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(spannableStringBuilder);
            TextView textView2 = itemFeedLayoutV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleTagView");
            textView2.setVisibility(0);
            Intrinsics.checkNotNull(secondHandInfo);
            if (secondHandInfo.getStoreType() != 2) {
                z = false;
            }
            TextView textView3 = itemFeedLayoutV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleTagView");
            textView3.setText(secondHandInfo.getStoreTypeText());
            int colorInt = ResourceUtils.getColorInt(getContext(), 2131100040);
            int colorInt2 = ResourceUtils.getColorInt(getContext(), 2131099687);
            if (!z) {
                colorInt = colorInt2;
            }
            TextView textView4 = itemFeedLayoutV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleTagView");
            textView4.setBackground(new ColorDrawable(colorInt));
            ImageView imageView = itemFeedLayoutV8Binding.imgSellView;
            SecondHandInfo secondHandInfo2 = feed2.getSecondHandInfo();
            Intrinsics.checkNotNull(secondHandInfo2);
            Intrinsics.checkNotNullExpressionValue(secondHandInfo2, "feed.secondHandInfo!!");
            imageView.setVisibility(secondHandInfo2.isSelled() ? 0 : 8);
            imageView.setAlpha(0.1f);
            if (secondHandInfo.isSelled()) {
                i = 0;
            }
            imageView.setVisibility(i);
            imageView.setAlpha(0.1f);
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imgSellView.appl…lpha = 0.1f\n            }");
        } else {
            TextView textView5 = itemFeedLayoutV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleTagView");
            textView5.setText("");
            TextView textView6 = itemFeedLayoutV8Binding.titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleTagView");
            textView6.setVisibility(8);
            TextView textView7 = itemFeedLayoutV8Binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
            textView7.setText(feed2.getMessageTitle());
            ImageView imageView2 = itemFeedLayoutV8Binding.imgSellView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imgSellView");
            imageView2.setVisibility(8);
        }
        if (feed2.isForwardFeed()) {
            FeedViewHolderV8$nineImageHotPlug$1 feedViewHolderV8$nineImageHotPlug$1 = this.nineImageHotPlug;
            List emptyList = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
            feedViewHolderV8$nineImageHotPlug$1.bindTo(emptyList);
        } else {
            this.nineImageHotPlug.bindTo(EntityExtendsKt.getHtmlPicArray(feed2));
        }
        this.hotReplyHotPlug.bindTo(feed2);
        getHeaderViewPart().bindTo(feed2);
        this.sourceHotPlug.bindTo(feed2);
        this.relativeInfoHotPlug.bindTo(feed2);
        this.extraTypeHotPlug.bindTo(feed2);
        this.secondHandHeaderPlug.bindTo(feed2);
        this.videoViewHotPlug.bindTo(VideoModelKt.toVideoModel(feed2));
        this.videoViewHotPlug.setOrderKey(getAdapterPosition());
        this.ratingHotPlug.bindTo(feed2);
        this.ratingDataHotPlug.bindTo(feed2);
        this.feedArticleSourcePlug.bindTo(feed2);
        getExtraEntityViewPart().bindTo(feed2);
        itemFeedLayoutV8Binding.executePendingBindings();
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
            TextView textView8 = itemFeedLayoutV8Binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.textView");
            textView8.setText(feedAssistData2.getBriefMessage());
            TextView textView9 = itemFeedLayoutV8Binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView9, "binding.textView");
            ViewExtendsKt.makeSpanClickable(textView9);
        } else {
            TextView textView10 = itemFeedLayoutV8Binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView10, "binding.textView");
            String message = feed2.getMessage();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getContext().getString(2131886718));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder2.length(), 33);
            Unit unit = Unit.INSTANCE;
            ViewExtendsKt.setBriefMessage(textView10, 90, message, spannableStringBuilder2);
        }
        if (feed2.isForwardFeed() && !TextUtils.isEmpty(feed2.getPic())) {
            TextView textView11 = itemFeedLayoutV8Binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView11, "binding.textView");
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(textView11.getText());
            ImageUrl create = ImageUrl.create(feed2.getPic(), feed2.getMiddleSizePic());
            Intrinsics.checkNotNullExpressionValue(create, "imageUrl");
            FeedTextUtils.insertPhotoLink(spannableStringBuilder3, create);
            TextView textView12 = itemFeedLayoutV8Binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView12, "binding.textView");
            textView12.setText(spannableStringBuilder3);
        }
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedLayoutV8Binding.getRoot();
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

    public final void hideFromWhereView() {
        getHeaderViewPart().hideFromWhereView();
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.nineImageHotPlug.onRecycled();
        this.hotReplyHotPlug.onRecycled();
        this.extraTypeHotPlug.onRecycled();
        this.sourceHotPlug.onRecycled();
        this.relativeInfoHotPlug.onRecycled();
        this.videoViewHotPlug.onRecycled();
        this.secondHandHeaderPlug.onRecycled();
        this.ratingHotPlug.onRecycled();
        this.feedArticleSourcePlug.onRecycled();
        this.ratingDataHotPlug.onRecycled();
    }
}
