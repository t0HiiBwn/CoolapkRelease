package com.coolapk.market.view.node.app;

import android.view.View;
import android.widget.LinearLayout;
import com.coolapk.market.databinding.AppNodeCommunityHeaderBinding;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class AppNodeCommunityViewPart$onBindToContent$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ AppNodeCommunityViewPart this$0;

    public AppNodeCommunityViewPart$onBindToContent$$inlined$doOnLayout$1(AppNodeCommunityViewPart appNodeCommunityViewPart) {
        this.this$0 = appNodeCommunityViewPart;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.removeOnLayoutChangeListener(this);
        CoolEllipsizeTextView coolEllipsizeTextView = ((AppNodeCommunityHeaderBinding) this.this$0.getBinding()).introduceView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.introduceView");
        if (!coolEllipsizeTextView.isCollapsing()) {
            LinearLayout linearLayout = ((AppNodeCommunityHeaderBinding) this.this$0.getBinding()).introduceActionView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.introduceActionView");
            linearLayout.setVisibility(8);
            ((AppNodeCommunityHeaderBinding) this.this$0.getBinding()).introductionLayout.setOnClickListener(null);
        }
    }
}
