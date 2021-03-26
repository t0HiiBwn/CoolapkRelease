package com.coolapk.market.widget.view;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FabVerticalMenuLayout.kt */
final class FabVerticalMenuLayout$createSubView$wrapClickListener$1 implements View.OnClickListener {
    final /* synthetic */ View.OnClickListener $clickListener;
    final /* synthetic */ FabVerticalMenuLayout this$0;

    FabVerticalMenuLayout$createSubView$wrapClickListener$1(FabVerticalMenuLayout fabVerticalMenuLayout, View.OnClickListener onClickListener) {
        this.this$0 = fabVerticalMenuLayout;
        this.$clickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.$clickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this.this$0.setExpand(false);
    }
}
