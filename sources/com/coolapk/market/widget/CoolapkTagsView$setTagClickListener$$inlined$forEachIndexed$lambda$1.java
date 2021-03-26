package com.coolapk.market.widget;

import android.view.View;
import com.coolapk.market.widget.CoolapkTagsView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/widget/CoolapkTagsView$setTagClickListener$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolapkTagsView.kt */
final class CoolapkTagsView$setTagClickListener$$inlined$forEachIndexed$lambda$1 implements View.OnClickListener {
    final /* synthetic */ int $index;
    final /* synthetic */ View $view;
    final /* synthetic */ CoolapkTagsView this$0;

    CoolapkTagsView$setTagClickListener$$inlined$forEachIndexed$lambda$1(int i, View view, CoolapkTagsView coolapkTagsView) {
        this.$index = i;
        this.$view = view;
        this.this$0 = coolapkTagsView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CoolapkTagsView.OnTagClickListener onTagClickListener = this.this$0.onTagClickListener;
        if (onTagClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            int i = this.$index;
            Object tag = this.$view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
            onTagClickListener.onTagClick(view, i, (String) tag);
        }
    }
}
