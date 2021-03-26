package com.coolapk.market.util;

import android.view.View;
import android.view.ViewParent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
final class DialogUtil$showBottomSheetDialog$2 implements Runnable {
    final /* synthetic */ View $view;

    DialogUtil$showBottomSheetDialog$2(View view) {
        this.$view = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewParent parent = this.$view.getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        if (view != null) {
            view.setBackground(null);
        }
    }
}
