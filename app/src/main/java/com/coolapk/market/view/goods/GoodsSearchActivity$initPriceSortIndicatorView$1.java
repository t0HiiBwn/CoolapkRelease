package com.coolapk.market.view.goods;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"updateIndicatorPosition", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchActivity.kt */
final class GoodsSearchActivity$initPriceSortIndicatorView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageView $indicatorView;
    final /* synthetic */ TextView $textView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsSearchActivity$initPriceSortIndicatorView$1(TextView textView, ImageView imageView) {
        super(0);
        this.$textView = textView;
        this.$indicatorView = imageView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Rect globalRect = ViewExtendsKt.getGlobalRect(this.$textView);
        if (globalRect != null) {
            ImageView imageView = this.$indicatorView;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            marginLayoutParams2.topMargin = globalRect.top + NumberExtendsKt.getDp((Number) 1);
            marginLayoutParams2.leftMargin = globalRect.right;
            imageView.setLayoutParams(marginLayoutParams);
        }
    }
}
