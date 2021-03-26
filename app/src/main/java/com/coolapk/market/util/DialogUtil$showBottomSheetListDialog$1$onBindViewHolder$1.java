package com.coolapk.market.util;

import android.view.View;
import com.coolapk.market.util.DialogUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
final class DialogUtil$showBottomSheetListDialog$1$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ DialogUtil.DialogItemData $data;
    final /* synthetic */ DialogUtil$showBottomSheetListDialog$1 this$0;

    DialogUtil$showBottomSheetListDialog$1$onBindViewHolder$1(DialogUtil$showBottomSheetListDialog$1 dialogUtil$showBottomSheetListDialog$1, DialogUtil.DialogItemData dialogItemData) {
        this.this$0 = dialogUtil$showBottomSheetListDialog$1;
        this.$data = dialogItemData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.$onItemCheck.invoke(this.$data);
        this.this$0.$dismissAction.invoke();
    }
}
