package com.coolapk.market.view.feed.dialog;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SheetDialogWrapper.kt */
final class SheetDialogWrapper$showDialog$1 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ SheetDialogWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SheetDialogWrapper$showDialog$1(SheetDialogWrapper sheetDialogWrapper) {
        super(1);
        this.this$0 = sheetDialogWrapper;
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
        TextView access$getCancelTextView$p = SheetDialogWrapper.access$getCancelTextView$p(this.this$0);
        access$getCancelTextView$p.setPadding(access$getCancelTextView$p.getPaddingLeft(), access$getCancelTextView$p.getPaddingTop(), access$getCancelTextView$p.getPaddingRight(), rect.bottom);
        TextView access$getCancelTextView$p2 = SheetDialogWrapper.access$getCancelTextView$p(this.this$0);
        ViewGroup.LayoutParams layoutParams = access$getCancelTextView$p2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = NumberExtendsKt.getDp((Number) 52) + rect.bottom;
            access$getCancelTextView$p2.setLayoutParams(layoutParams);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
