package com.coolapk.market.view.feed.dialog;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SheetDialogWrapper.kt */
final class SheetDialogWrapper$handleSheetResult$2 implements View.OnClickListener {
    final /* synthetic */ SheetDialogWrapper this$0;

    SheetDialogWrapper$handleSheetResult$2(SheetDialogWrapper sheetDialogWrapper) {
        this.this$0 = sheetDialogWrapper;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.handleSheetResult(SheetResult.Companion.getClose());
    }
}
