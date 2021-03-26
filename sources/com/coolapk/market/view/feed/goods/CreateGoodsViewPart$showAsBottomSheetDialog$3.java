package com.coolapk.market.view.feed.goods;

import android.graphics.Rect;
import android.widget.LinearLayout;
import com.coolapk.market.databinding.CreateGoodsBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CreateGoodsViewPart.kt */
final class CreateGoodsViewPart$showAsBottomSheetDialog$3 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ CreateGoodsViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateGoodsViewPart$showAsBottomSheetDialog$3(CreateGoodsViewPart createGoodsViewPart) {
        super(1);
        this.this$0 = createGoodsViewPart;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
        invoke(rect);
        return Unit.INSTANCE;
    }

    public final void invoke(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "it");
        LinearLayout linearLayout = ((CreateGoodsBinding) this.this$0.getBinding()).containerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.containerView");
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), rect.bottom);
    }
}
