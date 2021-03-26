package com.coolapk.market.view.goods.detail;

import android.graphics.Color;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ColorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "endColor", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
final class GoodsDetailActivity$setupLogoAndBackground$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ GoodsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsDetailActivity$setupLogoAndBackground$1(GoodsDetailActivity goodsDetailActivity) {
        super(2);
        this.this$0 = goodsDetailActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        int i3;
        if (AppHolder.getAppTheme().isDarkTheme()) {
            i3 = Color.parseColor("#99000000");
        } else {
            i3 = Color.parseColor("#33000000");
        }
        this.this$0.getViewModel().setBgColor(ColorUtils.calculateOneColorPlusAnotherColor(i3, i2));
    }
}
