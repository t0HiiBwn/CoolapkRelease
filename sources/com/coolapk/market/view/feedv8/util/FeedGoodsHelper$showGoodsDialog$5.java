package com.coolapk.market.view.feedv8.util;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showGoodsDialog$5 implements View.OnClickListener {
    final /* synthetic */ Ref.ObjectRef $cancelCallback;

    FeedGoodsHelper$showGoodsDialog$5(Ref.ObjectRef objectRef) {
        this.$cancelCallback = objectRef;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        T t = this.$cancelCallback.element;
        if (t != null) {
            Unit unit = (Unit) t.invoke();
        }
    }
}
