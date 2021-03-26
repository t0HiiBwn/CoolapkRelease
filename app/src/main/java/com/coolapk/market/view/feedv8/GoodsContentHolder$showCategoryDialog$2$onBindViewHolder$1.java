package com.coolapk.market.view.feedv8;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.FeedGoodsCategory;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"updateBg", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FeedGoodsCategory $data;
    final /* synthetic */ FrameLayout $frameLayout;
    final /* synthetic */ TextView $textView;
    final /* synthetic */ GoodsContentHolder$showCategoryDialog$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$1(GoodsContentHolder$showCategoryDialog$2 goodsContentHolder$showCategoryDialog$2, FeedGoodsCategory feedGoodsCategory, TextView textView, FrameLayout frameLayout) {
        super(0);
        this.this$0 = goodsContentHolder$showCategoryDialog$2;
        this.$data = feedGoodsCategory;
        this.$textView = textView;
        this.$frameLayout = frameLayout;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        int i;
        T t = this.this$0.$tempSelectId.element;
        int intValue = t != null ? t.intValue() : this.this$0.$selectId.element;
        FeedGoodsCategory feedGoodsCategory = this.$data;
        Intrinsics.checkNotNullExpressionValue(feedGoodsCategory, "data");
        if (intValue == ((int) feedGoodsCategory.getId())) {
            this.$textView.setTextColor(-1);
        } else {
            this.$textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        }
        FeedGoodsCategory feedGoodsCategory2 = this.$data;
        Intrinsics.checkNotNullExpressionValue(feedGoodsCategory2, "data");
        if (intValue == ((int) feedGoodsCategory2.getId())) {
            i = AppHolder.getAppTheme().getColorAccent();
        } else {
            i = ResourceUtils.resolveData(this.this$0.this$0.getActivity(), 2130968793);
        }
        this.$frameLayout.setBackground(ShapeUtils.createActionCornerBg(this.this$0.$context, i, 4, 4, 4, 4));
    }
}
