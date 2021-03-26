package com.coolapk.market.widget.hotplug;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.FeedIntegratedSourceViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0003H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/widget/hotplug/BaseSourceHotPlug;", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedSourceViewPart;", "Lcom/coolapk/market/model/Feed;", "viewToReplace", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/widget/hotplug/ViewPartPool;)V", "initParent", "Landroid/view/ViewGroup;", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "shouldShowView", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseSourceHotPlug.kt */
public class BaseSourceHotPlug extends ViewPartHotPlug<FeedIntegratedSourceViewPart, Feed> {
    private final DataBindingComponent component;
    private final ViewGroup initParent;
    private final View viewToReplace;

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ BaseSourceHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, viewPartPool);
        if ((i & 4) != 0 && (viewPartPool = KotlinExtendKt.getViewPartPool(dataBindingComponent)) == null) {
            viewPartPool = new ViewPartPool();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseSourceHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool) {
        super(-1879591971, viewPartPool, false);
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
        return FeedIntegratedSourceViewPart.Companion.shouldShowView(feed);
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        Intrinsics.checkNotNullParameter(feedIntegratedSourceViewPart, "viewPart");
        ViewUtil.replaceView(feedIntegratedSourceViewPart.getView(), this.viewToReplace);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public FeedIntegratedSourceViewPart createViewPart() {
        FeedIntegratedSourceViewPart.Companion companion = FeedIntegratedSourceViewPart.Companion;
        DataBindingComponent dataBindingComponent = this.component;
        ViewGroup viewGroup = this.initParent;
        Intrinsics.checkNotNull(viewGroup);
        return companion.newInstance(dataBindingComponent, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewPartLoad(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart) {
        Intrinsics.checkNotNullParameter(feedIntegratedSourceViewPart, "viewPart");
        ViewUtil.replaceView(this.viewToReplace, feedIntegratedSourceViewPart.getView());
        ViewGroup.LayoutParams layoutParams = feedIntegratedSourceViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = NumberExtendsKt.getDp((Number) 12);
            marginLayoutParams.leftMargin = NumberExtendsKt.getDp((Number) 12);
            marginLayoutParams.rightMargin = NumberExtendsKt.getDp((Number) 12);
            marginLayoutParams.bottomMargin = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void bindData(FeedIntegratedSourceViewPart feedIntegratedSourceViewPart, Feed feed) {
        Intrinsics.checkNotNullParameter(feedIntegratedSourceViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(feed, "data");
        feedIntegratedSourceViewPart.bindTo(feed);
    }
}
