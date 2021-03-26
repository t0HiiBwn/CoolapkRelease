package com.coolapk.market.widget.hotplug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.FeedRatingDataViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/widget/hotplug/BaseRatingDataHotPlug;", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/viewholder/v8/FeedRatingDataViewPart;", "Lcom/coolapk/market/model/Feed;", "viewToReplace", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "useListPadding", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/widget/hotplug/ViewPartPool;Z)V", "initParent", "Landroid/view/ViewGroup;", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "shouldShowView", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseRatingDataHotPlug.kt */
public class BaseRatingDataHotPlug extends ViewPartHotPlug<FeedRatingDataViewPart, Feed> {
    private final DataBindingComponent component;
    private final ViewGroup initParent;
    private final View viewToReplace;

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ BaseRatingDataHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, viewPartPool, (i & 8) != 0 ? true : z);
        if ((i & 4) != 0 && (viewPartPool = KotlinExtendKt.getViewPartPool(dataBindingComponent)) == null) {
            viewPartPool = new ViewPartPool();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRatingDataHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, boolean z) {
        super(-1669288010, viewPartPool, z);
        Intrinsics.checkNotNullParameter(view, "viewToReplace");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(viewPartPool, "viewPartPool");
        this.viewToReplace = view;
        this.component = dataBindingComponent;
        ViewParent parent = view.getParent();
        this.initParent = (ViewGroup) (!(parent instanceof ViewGroup) ? null : parent);
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowView(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        return FeedRatingDataViewPart.Companion.shouldShowView(feed);
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(FeedRatingDataViewPart feedRatingDataViewPart) {
        Intrinsics.checkNotNullParameter(feedRatingDataViewPart, "viewPart");
        ViewUtil.replaceView(feedRatingDataViewPart.getView(), this.viewToReplace);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public FeedRatingDataViewPart createViewPart() {
        FeedRatingDataViewPart feedRatingDataViewPart = new FeedRatingDataViewPart(this.component);
        LayoutInflater from = LayoutInflater.from(this.viewToReplace.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewToReplace.context)");
        feedRatingDataViewPart.createView(from, this.initParent);
        return feedRatingDataViewPart;
    }

    /* access modifiers changed from: protected */
    public void onViewPartLoad(FeedRatingDataViewPart feedRatingDataViewPart) {
        Intrinsics.checkNotNullParameter(feedRatingDataViewPart, "viewPart");
        ViewUtil.replaceView(this.viewToReplace, feedRatingDataViewPart.getView());
        ViewGroup.LayoutParams layoutParams = feedRatingDataViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = NumberExtendsKt.getDp((Number) 12);
            marginLayoutParams.leftMargin = getAssumedPadding();
            marginLayoutParams.rightMargin = getAssumedPadding();
            marginLayoutParams.bottomMargin = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void bindData(FeedRatingDataViewPart feedRatingDataViewPart, Feed feed) {
        Intrinsics.checkNotNullParameter(feedRatingDataViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(feed, "data");
        feedRatingDataViewPart.bindToContent(feed);
    }
}
