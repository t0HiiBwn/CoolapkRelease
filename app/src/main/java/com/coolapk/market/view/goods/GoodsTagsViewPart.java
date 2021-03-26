package com.coolapk.market.view.goods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Goods;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import com.coolapk.market.widget.view.RelativeInfoView;
import com.coolapk.market.widget.view.SimpleImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsTagsViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "(Lcom/coolapk/market/widget/hotplug/ViewPartPool;)V", "relationRowsToSingleLine", "", "getRelationRowsToSingleLine", "()Z", "setRelationRowsToSingleLine", "(Z)V", "getViewPartPool", "()Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "bindTo", "", "data", "Lcom/coolapk/market/model/Goods;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsTagsViewPart.kt */
public final class GoodsTagsViewPart extends ViewPart {
    public static final Companion Companion = new Companion(null);
    private boolean relationRowsToSingleLine;
    private final ViewPartPool viewPartPool;

    public GoodsTagsViewPart() {
        this(null, 1, null);
    }

    public GoodsTagsViewPart(ViewPartPool viewPartPool2) {
        this.viewPartPool = viewPartPool2;
        this.relationRowsToSingleLine = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoodsTagsViewPart(ViewPartPool viewPartPool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : viewPartPool2);
    }

    public final ViewPartPool getViewPartPool() {
        return this.viewPartPool;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsTagsViewPart$Companion;", "", "()V", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Goods;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsTagsViewPart.kt */
    public static final class Companion {
        public final boolean shouldShowView(Goods goods) {
            Intrinsics.checkNotNullParameter(goods, "data");
            return true;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean getRelationRowsToSingleLine() {
        return this.relationRowsToSingleLine;
    }

    public final void setRelationRowsToSingleLine(boolean z) {
        this.relationRowsToSingleLine = z;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = layoutInflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        RelativeInfoView relativeInfoView = new RelativeInfoView(context);
        ViewPartPool viewPartPool2 = this.viewPartPool;
        if (viewPartPool2 == null) {
            viewPartPool2 = new ViewPartPool();
        }
        relativeInfoView.setViewPartPool(viewPartPool2);
        relativeInfoView.setOnItemClickListener(new GoodsTagsViewPart$onCreateView$1$2(relativeInfoView));
        return relativeInfoView;
    }

    public final void bindTo(Goods goods) {
        Intrinsics.checkNotNullParameter(goods, "data");
        View view = getView();
        if (!(view instanceof RelativeInfoView)) {
            view = null;
        }
        RelativeInfoView relativeInfoView = (RelativeInfoView) view;
        Intrinsics.checkNotNull(relativeInfoView);
        ArrayList arrayList = new ArrayList();
        List<String> tags = goods.getTags();
        Intrinsics.checkNotNullExpressionValue(tags, "targetRow");
        int i = 0;
        int i2 = 0;
        for (T t : tags) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (i2 == 0) {
                Intrinsics.checkNotNullExpressionValue(t2, "item");
                arrayList.add(new RelativeInfoView.RelativeItem(t2, "", "", false, false, "mall_tags"));
            } else {
                Intrinsics.checkNotNullExpressionValue(t2, "item");
                arrayList.add(new RelativeInfoView.RelativeItem(t2, "", "", false, false, "goods_tags"));
            }
            i2 = i3;
        }
        if (this.relationRowsToSingleLine) {
            relativeInfoView.setMaxLines(1);
        } else {
            relativeInfoView.setMaxLines(Integer.MAX_VALUE);
        }
        SimpleImageView simpleImageView = relativeInfoView.getMoreBinding().iconView;
        Intrinsics.checkNotNullExpressionValue(simpleImageView, "relateInfoView.moreBinding.iconView");
        ViewGroup.LayoutParams layoutParams = simpleImageView.getLayoutParams();
        layoutParams.height = ConvertUtils.dp2px(14.0f);
        layoutParams.width = ConvertUtils.dp2px(14.0f);
        relativeInfoView.getMoreBinding().titleView.setTextSize(2, 10.0f);
        LinearLayout linearLayout = relativeInfoView.getMoreBinding().cardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "relateInfoView.moreBinding.cardView");
        linearLayout.getLayoutParams().height = NumberExtendsKt.getDp((Number) 14);
        relativeInfoView.getMoreBinding().cardView.setPadding(NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 2));
        if (arrayList.isEmpty()) {
            i = 8;
        }
        relativeInfoView.setVisibility(i);
        if (!Intrinsics.areEqual(relativeInfoView.getDataItems(), arrayList)) {
            relativeInfoView.setDataItems(arrayList);
            relativeInfoView.notifyDataSetChange();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        this.relationRowsToSingleLine = true;
        View view = getView();
        if (!(view instanceof RelativeInfoView)) {
            view = null;
        }
        RelativeInfoView relativeInfoView = (RelativeInfoView) view;
        Intrinsics.checkNotNull(relativeInfoView);
        relativeInfoView.setDataItems(Collections.emptyList());
        relativeInfoView.notifyDataSetChange();
    }
}
