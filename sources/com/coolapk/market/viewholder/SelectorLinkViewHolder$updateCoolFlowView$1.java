package com.coolapk.market.viewholder;

import android.view.View;
import com.coolapk.market.widget.CoolFlowLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SelectorLinkViewHolder.kt */
final class SelectorLinkViewHolder$updateCoolFlowView$1 extends Lambda implements Function1<View, Boolean> {
    public static final SelectorLinkViewHolder$updateCoolFlowView$1 INSTANCE = new SelectorLinkViewHolder$updateCoolFlowView$1();

    SelectorLinkViewHolder$updateCoolFlowView$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(View view) {
        return Boolean.valueOf(invoke(view));
    }

    public final boolean invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        if (!(view instanceof CoolFlowLayout)) {
            return false;
        }
        CoolFlowLayout coolFlowLayout = (CoolFlowLayout) view;
        coolFlowLayout.setAdapter(coolFlowLayout.getAdapter());
        return true;
    }
}
