package com.coolapk.market.view.sencondhand;

import android.graphics.Rect;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "invoke", "com/coolapk/market/view/sencondhand/SelectParamsFragment$showDoneButton$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: SelectParamsFragment.kt */
final class SelectParamsFragment$showDoneButton$$inlined$apply$lambda$1 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ FrameLayout $parentView$inlined;
    final /* synthetic */ SelectParamsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectParamsFragment$showDoneButton$$inlined$apply$lambda$1(SelectParamsFragment selectParamsFragment, FrameLayout frameLayout) {
        super(1);
        this.this$0 = selectParamsFragment;
        this.$parentView$inlined = frameLayout;
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
        TextView textView = this.this$0.textView;
        if (textView != null) {
            textView.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16) + rect.bottom);
        }
    }
}
