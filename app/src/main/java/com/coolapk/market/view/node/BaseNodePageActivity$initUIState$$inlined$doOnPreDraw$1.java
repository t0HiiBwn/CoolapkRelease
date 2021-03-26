package com.coolapk.market.view.node;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class BaseNodePageActivity$initUIState$$inlined$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ View $this_doOnPreDraw;
    final /* synthetic */ BaseNodePageActivity this$0;

    public BaseNodePageActivity$initUIState$$inlined$doOnPreDraw$1(View view, BaseNodePageActivity baseNodePageActivity) {
        this.$this_doOnPreDraw = view;
        this.this$0 = baseNodePageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.getBinding$presentation_coolapkAppRelease().mainContent.addOnInsetChangeListener(this.this$0);
        this.this$0.getBinding$presentation_coolapkAppRelease().mainContent.requestApplyInsets();
    }
}
