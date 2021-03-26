package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleHeaderViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.hotplug.BaseFeedNormalHeaderHotPlug;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u001cH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "dyhHeader", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleHeaderViewPart;", "getDyhHeader", "()Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleHeaderViewPart;", "dyhHeader$delegate", "Lkotlin/Lazy;", "frameLayout", "Landroid/widget/FrameLayout;", "normalHeaderHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseFeedNormalHeaderHotPlug;", "getNormalHeaderHotPlug", "()Lcom/coolapk/market/widget/hotplug/BaseFeedNormalHeaderHotPlug;", "setNormalHeaderHotPlug", "(Lcom/coolapk/market/widget/hotplug/BaseFeedNormalHeaderHotPlug;)V", "smallHeader", "Lcom/coolapk/market/viewholder/v8/FeedSmallHeaderViewPart;", "getSmallHeader", "()Lcom/coolapk/market/viewholder/v8/FeedSmallHeaderViewPart;", "smallHeader$delegate", "bindTo", "", "feed", "Lcom/coolapk/market/model/Feed;", "hideFromWhereView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedIntegratedHeaderViewPart.kt */
public final class FeedIntegratedHeaderViewPart extends ViewPart implements Recyclable {
    public static final Companion Companion = new Companion(null);
    private final DataBindingComponent component;
    private final Lazy dyhHeader$delegate = LazyKt.lazy(new FeedIntegratedHeaderViewPart$dyhHeader$2(this));
    private FrameLayout frameLayout;
    public BaseFeedNormalHeaderHotPlug normalHeaderHotPlug;
    private final Lazy smallHeader$delegate = LazyKt.lazy(new FeedIntegratedHeaderViewPart$smallHeader$2(this));

    private final DyhArticleHeaderViewPart getDyhHeader() {
        return (DyhArticleHeaderViewPart) this.dyhHeader$delegate.getValue();
    }

    private final FeedSmallHeaderViewPart getSmallHeader() {
        return (FeedSmallHeaderViewPart) this.smallHeader$delegate.getValue();
    }

    @JvmStatic
    public static final FeedIntegratedHeaderViewPart newInstance(DataBindingComponent dataBindingComponent, ViewGroup viewGroup) {
        return Companion.newInstance(dataBindingComponent, viewGroup);
    }

    public FeedIntegratedHeaderViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public static final /* synthetic */ FrameLayout access$getFrameLayout$p(FeedIntegratedHeaderViewPart feedIntegratedHeaderViewPart) {
        FrameLayout frameLayout2 = feedIntegratedHeaderViewPart.frameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        return frameLayout2;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedIntegratedHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FeedIntegratedHeaderViewPart newInstance(DataBindingComponent dataBindingComponent, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            FeedIntegratedHeaderViewPart feedIntegratedHeaderViewPart = new FeedIntegratedHeaderViewPart(dataBindingComponent);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            feedIntegratedHeaderViewPart.createView(from, viewGroup);
            return feedIntegratedHeaderViewPart;
        }
    }

    public final BaseFeedNormalHeaderHotPlug getNormalHeaderHotPlug() {
        BaseFeedNormalHeaderHotPlug baseFeedNormalHeaderHotPlug = this.normalHeaderHotPlug;
        if (baseFeedNormalHeaderHotPlug == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalHeaderHotPlug");
        }
        return baseFeedNormalHeaderHotPlug;
    }

    public final void setNormalHeaderHotPlug(BaseFeedNormalHeaderHotPlug baseFeedNormalHeaderHotPlug) {
        Intrinsics.checkNotNullParameter(baseFeedNormalHeaderHotPlug, "<set-?>");
        this.normalHeaderHotPlug = baseFeedNormalHeaderHotPlug;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FrameLayout frameLayout2 = new FrameLayout(layoutInflater.getContext());
        this.frameLayout = frameLayout2;
        DataBindingComponent dataBindingComponent = this.component;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        this.normalHeaderHotPlug = new BaseFeedNormalHeaderHotPlug(dataBindingComponent, frameLayout2, null, 4, null);
        FrameLayout frameLayout3 = this.frameLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        return frameLayout3;
    }

    public final void bindTo(Feed feed) {
        FeedSmallHeaderViewPart feedSmallHeaderViewPart;
        FrameLayout frameLayout2 = this.frameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        if (feed == null) {
            BaseFeedNormalHeaderHotPlug baseFeedNormalHeaderHotPlug = this.normalHeaderHotPlug;
            if (baseFeedNormalHeaderHotPlug == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalHeaderHotPlug");
            }
            baseFeedNormalHeaderHotPlug.onRecycled();
            frameLayout2.removeAllViews();
            return;
        }
        if (Intrinsics.areEqual(feed.getEntityTemplate(), "feedMini") || Intrinsics.areEqual(feed.getEntityTemplate(), "feedMiniCover")) {
            feedSmallHeaderViewPart = getSmallHeader();
        } else if (Intrinsics.areEqual(feed.getEntityTemplate(), "feedByDyhHeader")) {
            feedSmallHeaderViewPart = getDyhHeader();
        } else {
            BaseFeedNormalHeaderHotPlug baseFeedNormalHeaderHotPlug2 = this.normalHeaderHotPlug;
            if (baseFeedNormalHeaderHotPlug2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalHeaderHotPlug");
            }
            baseFeedNormalHeaderHotPlug2.bindTo(feed);
            return;
        }
        feedSmallHeaderViewPart.bindToContent(feed);
        if (frameLayout2.getChildAt(0) != feedSmallHeaderViewPart.getView()) {
            frameLayout2.removeAllViews();
            frameLayout2.addView(feedSmallHeaderViewPart.getView());
        }
    }

    public final void hideFromWhereView() {
        View findViewById;
        FrameLayout frameLayout2 = this.frameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        View childAt = frameLayout2.getChildAt(0);
        if (childAt != null && (findViewById = childAt.findViewById(2131362595)) != null) {
            findViewById.setVisibility(8);
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        BaseFeedNormalHeaderHotPlug baseFeedNormalHeaderHotPlug = this.normalHeaderHotPlug;
        if (baseFeedNormalHeaderHotPlug == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalHeaderHotPlug");
        }
        baseFeedNormalHeaderHotPlug.onRecycled();
    }
}
