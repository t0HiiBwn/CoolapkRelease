package com.coolapk.market.widget;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
final class FastReturnView$dependentAboveOn$2 implements View.OnLayoutChangeListener {
    final /* synthetic */ View $view;
    final /* synthetic */ FastReturnView this$0;

    FastReturnView$dependentAboveOn$2(FastReturnView fastReturnView, View view) {
        this.this$0 = fastReturnView;
        this.$view = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, final int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.this$0.post(new Runnable(this) {
            /* class com.coolapk.market.widget.FastReturnView$dependentAboveOn$2.AnonymousClass1 */
            final /* synthetic */ FastReturnView$dependentAboveOn$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.this$0.setTranslationY((float) (((i2 - this.this$0.this$0.getTop()) - this.this$0.$view.getHeight()) + (this.this$0.this$0.dependentViewGone ? FastReturnView.MARGIN : 0)));
            }
        });
    }
}
