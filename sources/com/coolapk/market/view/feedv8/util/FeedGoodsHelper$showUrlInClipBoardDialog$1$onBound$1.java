package com.coolapk.market.view.feedv8.util;

import android.text.SpannableStringBuilder;
import com.coolapk.market.extend.DrawableExtendsKt;
import com.coolapk.market.extend.DrawableFactory;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/text/SpannableStringBuilder;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showUrlInClipBoardDialog$1$onBound$1 extends Lambda implements Function1<SpannableStringBuilder, Unit> {
    final /* synthetic */ FeedGoods $model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedGoodsHelper$showUrlInClipBoardDialog$1$onBound$1(FeedGoods feedGoods) {
        super(1);
        this.$model = feedGoods;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpannableStringBuilder spannableStringBuilder) {
        invoke(spannableStringBuilder);
        return Unit.INSTANCE;
    }

    public final void invoke(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "$receiver");
        spannableStringBuilder.clear();
        spannableStringBuilder.insert(0, (CharSequence) this.$model.getTitle());
        spannableStringBuilder.insert(0, " ");
        DrawableFactory drawableFactory = DrawableFactory.INSTANCE;
        String mallName = this.$model.getMallName();
        if (mallName == null) {
            mallName = "";
        }
        spannableStringBuilder.insert(0, (CharSequence) DrawableExtendsKt.toSpannable(drawableFactory.createMallIndicator(mallName, NumberExtendsKt.getDp((Number) 16), (int) 4294198070L, 452215606, NumberExtendsKt.getDpf((Number) 4)), '[' + this.$model.getMallName() + ']'));
    }
}
