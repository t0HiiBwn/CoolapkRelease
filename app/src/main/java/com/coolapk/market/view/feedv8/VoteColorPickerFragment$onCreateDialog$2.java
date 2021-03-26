package com.coolapk.market.view.feedv8;

import android.app.Dialog;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteColorPickerFragment.kt */
final class VoteColorPickerFragment$onCreateDialog$2 implements View.OnClickListener {
    final /* synthetic */ VoteColorPickerFragment this$0;

    VoteColorPickerFragment$onCreateDialog$2(VoteColorPickerFragment voteColorPickerFragment) {
        this.this$0 = voteColorPickerFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 access$getOnClick$p = VoteColorPickerFragment.access$getOnClick$p(this.this$0);
        if (access$getOnClick$p != null) {
            Unit unit = (Unit) access$getOnClick$p.invoke(Integer.valueOf(VoteColorPickerFragment.access$getColorPrimary$p(this.this$0)), Integer.valueOf(VoteColorPickerFragment.access$getColorAccent$p(this.this$0)));
        }
        Dialog dialog = this.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
