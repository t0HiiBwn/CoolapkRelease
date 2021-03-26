package com.coolapk.market.view.block;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AddBlockDialog.kt */
final class AddBlockDialog$setupCoolFlowLayout$1 implements View.OnClickListener {
    final /* synthetic */ List $blockItemList;
    final /* synthetic */ DialogFragment $dialog;
    final /* synthetic */ List $initCopy;

    AddBlockDialog$setupCoolFlowLayout$1(List list, List list2, DialogFragment dialogFragment) {
        this.$initCopy = list;
        this.$blockItemList = list2;
        this.$dialog = dialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AddBlockDialog.access$updateBlockNodes(AddBlockDialog.INSTANCE, this.$initCopy, this.$blockItemList);
        this.$dialog.dismiss();
    }
}
