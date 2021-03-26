package com.coolapk.market.widget.hotplug;

import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.viewholder.v8.FeedHeaderViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/widget/hotplug/BaseFeedNormalHeaderHotPlug;", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/viewholder/v8/FeedHeaderViewPart;", "Lcom/coolapk/market/model/Feed;", "component", "Landroidx/databinding/DataBindingComponent;", "container", "Landroid/widget/FrameLayout;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "(Landroidx/databinding/DataBindingComponent;Landroid/widget/FrameLayout;Lcom/coolapk/market/widget/hotplug/ViewPartPool;)V", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "shouldShowView", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFeedNormalHeaderHotPlug.kt */
public class BaseFeedNormalHeaderHotPlug extends ViewPartHotPlug<FeedHeaderViewPart, Feed> {
    private final DataBindingComponent component;
    private final FrameLayout container;

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ BaseFeedNormalHeaderHotPlug(DataBindingComponent dataBindingComponent, FrameLayout frameLayout, ViewPartPool viewPartPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataBindingComponent, frameLayout, viewPartPool);
        if ((i & 4) != 0 && (viewPartPool = KotlinExtendKt.getViewPartPool(dataBindingComponent)) == null) {
            viewPartPool = new ViewPartPool();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseFeedNormalHeaderHotPlug(DataBindingComponent dataBindingComponent, FrameLayout frameLayout, ViewPartPool viewPartPool) {
        super(2131558713, viewPartPool, false);
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(frameLayout, "container");
        Intrinsics.checkNotNullParameter(viewPartPool, "viewPartPool");
        this.component = dataBindingComponent;
        this.container = frameLayout;
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowView(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        return !EntityUtils.isFeedArticleNewsType(feed.getEntityTemplate());
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(FeedHeaderViewPart feedHeaderViewPart) {
        Intrinsics.checkNotNullParameter(feedHeaderViewPart, "viewPart");
        ViewExtendsKt.detachFromParent(feedHeaderViewPart.getView());
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public FeedHeaderViewPart createViewPart() {
        FeedHeaderViewPart feedHeaderViewPart = new FeedHeaderViewPart(this.component);
        LayoutInflater from = LayoutInflater.from(this.container.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(container.context)");
        feedHeaderViewPart.createView(from, this.container);
        return feedHeaderViewPart;
    }

    /* access modifiers changed from: protected */
    public void onViewPartLoad(FeedHeaderViewPart feedHeaderViewPart) {
        Intrinsics.checkNotNullParameter(feedHeaderViewPart, "viewPart");
        if (!Intrinsics.areEqual(this.container.getChildAt(0), feedHeaderViewPart.getView())) {
            this.container.removeAllViews();
            this.container.addView(feedHeaderViewPart.getView());
        }
    }

    /* access modifiers changed from: protected */
    public void bindData(FeedHeaderViewPart feedHeaderViewPart, Feed feed) {
        Intrinsics.checkNotNullParameter(feedHeaderViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(feed, "data");
        feedHeaderViewPart.bindToContent(feed);
    }
}
