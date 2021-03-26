package com.coolapk.market.view.goods;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.model.Goods;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.hotplug.ViewPartHotPlug;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0003H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsTagPlug;", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/view/goods/GoodsTagsViewPart;", "Lcom/coolapk/market/model/Goods;", "viewToReplace", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/widget/hotplug/ViewPartPool;)V", "initParent", "Landroid/view/ViewGroup;", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "shouldShowView", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsTagPlug.kt */
public class GoodsTagPlug extends ViewPartHotPlug<GoodsTagsViewPart, Goods> {
    private final DataBindingComponent component;
    private final ViewGroup initParent;
    private final View viewToReplace;

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ GoodsTagPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, viewPartPool);
        if ((i & 4) != 0 && (viewPartPool = KotlinExtendKt.getViewPartPool(dataBindingComponent)) == null) {
            viewPartPool = new ViewPartPool();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsTagPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool) {
        super(2045730352, viewPartPool, false);
        Intrinsics.checkNotNullParameter(view, "viewToReplace");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(viewPartPool, "viewPartPool");
        this.viewToReplace = view;
        this.component = dataBindingComponent;
        ViewParent parent = view.getParent();
        this.initParent = (ViewGroup) (!(parent instanceof ViewGroup) ? null : parent);
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowView(Goods goods) {
        Intrinsics.checkNotNullParameter(goods, "data");
        return GoodsTagsViewPart.Companion.shouldShowView(goods);
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(GoodsTagsViewPart goodsTagsViewPart) {
        Intrinsics.checkNotNullParameter(goodsTagsViewPart, "viewPart");
        ViewUtil.replaceView(goodsTagsViewPart.getView(), this.viewToReplace);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public GoodsTagsViewPart createViewPart() {
        GoodsTagsViewPart goodsTagsViewPart = new GoodsTagsViewPart(getViewPartPool());
        LayoutInflater from = LayoutInflater.from(this.viewToReplace.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewToReplace.context)");
        goodsTagsViewPart.createView(from, this.initParent);
        return goodsTagsViewPart;
    }

    /* access modifiers changed from: protected */
    public void onViewPartLoad(GoodsTagsViewPart goodsTagsViewPart) {
        Intrinsics.checkNotNullParameter(goodsTagsViewPart, "viewPart");
        ViewUtil.replaceView(this.viewToReplace, goodsTagsViewPart.getView());
        ViewGroup.LayoutParams layoutParams = goodsTagsViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ConvertUtils.dp2px(6.0f);
            marginLayoutParams.leftMargin = ConvertUtils.dp2px(8.0f);
            marginLayoutParams.rightMargin = ConvertUtils.dp2px(16.0f);
            marginLayoutParams.bottomMargin = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void bindData(GoodsTagsViewPart goodsTagsViewPart, Goods goods) {
        Intrinsics.checkNotNullParameter(goodsTagsViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(goods, "data");
        goodsTagsViewPart.bindTo(goods);
    }
}
