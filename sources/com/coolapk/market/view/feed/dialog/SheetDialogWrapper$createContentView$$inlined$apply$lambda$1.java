package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/feed/dialog/SheetDialogWrapper$createContentView$2$3$2", "com/coolapk/market/view/feed/dialog/SheetDialogWrapper$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: SheetDialogWrapper.kt */
final class SheetDialogWrapper$createContentView$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ SheetDialogWrapper this$0;

    SheetDialogWrapper$createContentView$$inlined$apply$lambda$1(SheetDialogWrapper sheetDialogWrapper, Activity activity) {
        this.this$0 = sheetDialogWrapper;
        this.$activity$inlined = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.handleSheetResult(SheetResult.Companion.getClose());
    }
}
