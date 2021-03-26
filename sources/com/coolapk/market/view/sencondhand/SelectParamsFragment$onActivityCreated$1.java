package com.coolapk.market.view.sencondhand;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SelectParamsFragment.kt */
final class SelectParamsFragment$onActivityCreated$1 extends Lambda implements Function1<Rect, Unit> {
    final /* synthetic */ SelectParamsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectParamsFragment$onActivityCreated$1(SelectParamsFragment selectParamsFragment) {
        super(1);
        this.this$0 = selectParamsFragment;
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
        RecyclerView recyclerView = this.this$0.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 52) + rect.top, NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16) + rect.bottom);
        }
    }
}
