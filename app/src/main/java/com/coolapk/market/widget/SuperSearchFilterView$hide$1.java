package com.coolapk.market.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/SuperSearchFilterView$hide$1", "Landroidx/core/view/ViewPropertyAnimatorListenerAdapter;", "onAnimationCancel", "", "view", "Landroid/view/View;", "onAnimationEnd", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchFilterView.kt */
public final class SuperSearchFilterView$hide$1 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ SuperSearchFilterView this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SuperSearchFilterView$hide$1(SuperSearchFilterView superSearchFilterView) {
        this.this$0 = superSearchFilterView;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        this.this$0.setVisibility(4);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        this.this$0.setVisibility(4);
    }
}
