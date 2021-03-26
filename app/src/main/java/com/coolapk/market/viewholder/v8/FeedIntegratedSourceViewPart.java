package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleSourceViewPart;
import com.coolapk.market.viewholder.FeedSourceDeletedViewPart;
import com.coolapk.market.viewholder.FeedSourceViewPart;
import com.coolapk.market.viewholder.SecondHandFeedSourceViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.iview.ViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedIntegratedSourceViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "deletedSource", "Lcom/coolapk/market/viewholder/FeedSourceDeletedViewPart;", "dyhSource", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleSourceViewPart;", "feedSource", "Lcom/coolapk/market/viewholder/FeedSourceViewPart;", "frameLayout", "Landroid/widget/FrameLayout;", "secondHandFeedSource", "Lcom/coolapk/market/viewholder/SecondHandFeedSourceViewPart;", "bindTo", "", "feed", "Lcom/coolapk/market/model/Feed;", "initDeleteSource", "initDyhSource", "initFeedSource", "initSecondHandFeedSource", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedIntegratedSourceViewPart.kt */
public final class FeedIntegratedSourceViewPart extends ViewPart implements Recyclable {
    public static final Companion Companion = new Companion(null);
    private final DataBindingComponent component;
    private FeedSourceDeletedViewPart deletedSource;
    private DyhArticleSourceViewPart dyhSource;
    private FeedSourceViewPart feedSource;
    private FrameLayout frameLayout;
    private SecondHandFeedSourceViewPart secondHandFeedSource;

    @JvmStatic
    public static final FeedIntegratedSourceViewPart newInstance(DataBindingComponent dataBindingComponent, ViewGroup viewGroup) {
        return Companion.newInstance(dataBindingComponent, viewGroup);
    }

    public FeedIntegratedSourceViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public static final /* synthetic */ FeedSourceDeletedViewPart access$getDeletedSource$p(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        FeedSourceDeletedViewPart feedSourceDeletedViewPart = feedIntegratedSourceViewPart.deletedSource;
        if (feedSourceDeletedViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
        }
        return feedSourceDeletedViewPart;
    }

    public static final /* synthetic */ DyhArticleSourceViewPart access$getDyhSource$p(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        DyhArticleSourceViewPart dyhArticleSourceViewPart = feedIntegratedSourceViewPart.dyhSource;
        if (dyhArticleSourceViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhSource");
        }
        return dyhArticleSourceViewPart;
    }

    public static final /* synthetic */ FeedSourceViewPart access$getFeedSource$p(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        FeedSourceViewPart feedSourceViewPart = feedIntegratedSourceViewPart.feedSource;
        if (feedSourceViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedSource");
        }
        return feedSourceViewPart;
    }

    public static final /* synthetic */ SecondHandFeedSourceViewPart access$getSecondHandFeedSource$p(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        SecondHandFeedSourceViewPart secondHandFeedSourceViewPart = feedIntegratedSourceViewPart.secondHandFeedSource;
        if (secondHandFeedSourceViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondHandFeedSource");
        }
        return secondHandFeedSourceViewPart;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedIntegratedSourceViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedSourceViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "viewGroup", "Landroid/view/ViewGroup;", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedIntegratedSourceViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FeedIntegratedSourceViewPart newInstance(DataBindingComponent dataBindingComponent, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            FeedIntegratedSourceViewPart feedIntegratedSourceViewPart = new FeedIntegratedSourceViewPart(dataBindingComponent);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            feedIntegratedSourceViewPart.createView(from, viewGroup);
            return feedIntegratedSourceViewPart;
        }

        public final boolean shouldShowView(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "data");
            return feed.isForwardFeed();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FrameLayout frameLayout2 = new FrameLayout(layoutInflater.getContext());
        this.frameLayout = frameLayout2;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        return frameLayout2;
    }

    private final void initFeedSource() {
        if (this.feedSource == null) {
            FeedSourceViewPart.Companion companion = FeedSourceViewPart.Companion;
            FrameLayout frameLayout2 = this.frameLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            }
            FeedSourceViewPart newInstance = companion.newInstance(frameLayout2, this.component);
            ViewGroup.LayoutParams layoutParams = newInstance.getView().getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.bottomMargin = 0;
            }
            Unit unit = Unit.INSTANCE;
            this.feedSource = newInstance;
        }
    }

    private final void initSecondHandFeedSource() {
        if (this.secondHandFeedSource == null) {
            SecondHandFeedSourceViewPart.Companion companion = SecondHandFeedSourceViewPart.Companion;
            FrameLayout frameLayout2 = this.frameLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            }
            SecondHandFeedSourceViewPart newInstance = companion.newInstance(frameLayout2, this.component);
            ViewGroup.LayoutParams layoutParams = newInstance.getView().getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.bottomMargin = 0;
            }
            Unit unit = Unit.INSTANCE;
            this.secondHandFeedSource = newInstance;
        }
    }

    private final void initDyhSource() {
        if (this.dyhSource == null) {
            DyhArticleSourceViewPart.Companion companion = DyhArticleSourceViewPart.Companion;
            FrameLayout frameLayout2 = this.frameLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            }
            DyhArticleSourceViewPart newInstance = companion.newInstance(frameLayout2, this.component);
            ViewGroup.LayoutParams layoutParams = newInstance.getView().getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.bottomMargin = 0;
            }
            Unit unit = Unit.INSTANCE;
            this.dyhSource = newInstance;
        }
    }

    private final void initDeleteSource() {
        if (this.deletedSource == null) {
            FeedSourceDeletedViewPart.Companion companion = FeedSourceDeletedViewPart.Companion;
            FrameLayout frameLayout2 = this.frameLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            }
            FeedSourceDeletedViewPart newInstance = companion.newInstance(frameLayout2, this.component);
            ViewGroup.LayoutParams layoutParams = newInstance.getView().getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.bottomMargin = 0;
            }
            Unit unit = Unit.INSTANCE;
            this.deletedSource = newInstance;
        }
    }

    public final void bindTo(Feed feed) {
        FeedSourceDeletedViewPart feedSourceDeletedViewPart;
        FrameLayout frameLayout2 = this.frameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        }
        if (feed == null || !feed.isForwardFeed()) {
            frameLayout2.removeAllViews();
            frameLayout2.setVisibility(8);
            return;
        }
        String forwardSourceType = feed.getForwardSourceType();
        if (forwardSourceType == null || forwardSourceType.length() == 0) {
            initDeleteSource();
            FeedSourceDeletedViewPart feedSourceDeletedViewPart2 = this.deletedSource;
            if (feedSourceDeletedViewPart2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
            }
            feedSourceDeletedViewPart2.setDeletedHint();
            FeedSourceDeletedViewPart feedSourceDeletedViewPart3 = this.deletedSource;
            if (feedSourceDeletedViewPart3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
            }
            feedSourceDeletedViewPart = feedSourceDeletedViewPart3;
        } else if (Intrinsics.areEqual(feed.getForwardSourceType(), "feed")) {
            Feed forwardSourceFeed = feed.getForwardSourceFeed();
            if (forwardSourceFeed == null) {
                initDeleteSource();
                FeedSourceDeletedViewPart feedSourceDeletedViewPart4 = this.deletedSource;
                if (feedSourceDeletedViewPart4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
                }
                feedSourceDeletedViewPart4.setDeletedHint();
                FeedSourceDeletedViewPart feedSourceDeletedViewPart5 = this.deletedSource;
                if (feedSourceDeletedViewPart5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
                }
                feedSourceDeletedViewPart = feedSourceDeletedViewPart5;
            } else if (forwardSourceFeed.isSecondHand()) {
                initSecondHandFeedSource();
                SecondHandFeedSourceViewPart secondHandFeedSourceViewPart = this.secondHandFeedSource;
                if (secondHandFeedSourceViewPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("secondHandFeedSource");
                }
                secondHandFeedSourceViewPart.bindToContent(forwardSourceFeed);
                SecondHandFeedSourceViewPart secondHandFeedSourceViewPart2 = this.secondHandFeedSource;
                if (secondHandFeedSourceViewPart2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("secondHandFeedSource");
                }
                feedSourceDeletedViewPart = secondHandFeedSourceViewPart2;
            } else {
                initFeedSource();
                FeedSourceViewPart feedSourceViewPart = this.feedSource;
                if (feedSourceViewPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedSource");
                }
                feedSourceViewPart.bindToContent(forwardSourceFeed);
                FeedSourceViewPart feedSourceViewPart2 = this.feedSource;
                if (feedSourceViewPart2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedSource");
                }
                feedSourceDeletedViewPart = feedSourceViewPart2;
            }
        } else if (Intrinsics.areEqual(feed.getForwardSourceType(), "article")) {
            DyhArticle forwardSourceArticle = feed.getForwardSourceArticle();
            if (forwardSourceArticle != null) {
                initDyhSource();
                DyhArticleSourceViewPart dyhArticleSourceViewPart = this.dyhSource;
                if (dyhArticleSourceViewPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dyhSource");
                }
                dyhArticleSourceViewPart.bindToContent(forwardSourceArticle);
                DyhArticleSourceViewPart dyhArticleSourceViewPart2 = this.dyhSource;
                if (dyhArticleSourceViewPart2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dyhSource");
                }
                feedSourceDeletedViewPart = dyhArticleSourceViewPart2;
            } else {
                initDeleteSource();
                FeedSourceDeletedViewPart feedSourceDeletedViewPart6 = this.deletedSource;
                if (feedSourceDeletedViewPart6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
                }
                feedSourceDeletedViewPart6.setDeletedHint();
                FeedSourceDeletedViewPart feedSourceDeletedViewPart7 = this.deletedSource;
                if (feedSourceDeletedViewPart7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
                }
                feedSourceDeletedViewPart = feedSourceDeletedViewPart7;
            }
        } else {
            initDeleteSource();
            FeedSourceDeletedViewPart feedSourceDeletedViewPart8 = this.deletedSource;
            if (feedSourceDeletedViewPart8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
            }
            feedSourceDeletedViewPart8.setUpdateHint();
            FeedSourceDeletedViewPart feedSourceDeletedViewPart9 = this.deletedSource;
            if (feedSourceDeletedViewPart9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deletedSource");
            }
            feedSourceDeletedViewPart = feedSourceDeletedViewPart9;
        }
        if (frameLayout2.getChildAt(0) != feedSourceDeletedViewPart.getView()) {
            frameLayout2.removeAllViews();
            frameLayout2.addView(feedSourceDeletedViewPart.getView());
            frameLayout2.setVisibility(0);
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        if (this.feedSource != null) {
            FeedSourceViewPart feedSourceViewPart = this.feedSource;
            if (feedSourceViewPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedSource");
            }
            feedSourceViewPart.onRecycled();
        }
    }
}
