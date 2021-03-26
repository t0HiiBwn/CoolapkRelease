package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteColorPickerFragment.kt */
final class VoteColorPickerFragment$onCreateDialog$6 implements View.OnLongClickListener {
    final /* synthetic */ VoteColorPickerFragment this$0;

    VoteColorPickerFragment$onCreateDialog$6(VoteColorPickerFragment voteColorPickerFragment) {
        this.this$0 = voteColorPickerFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Toast.show$default(this.this$0.getActivity(), ColorUtils.toColorString(this.this$0.colorAccent), 0, false, 12, null);
        return true;
    }
}
