package com.coolapk.market.view.feedv8;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.ColorPickerDialog;
import com.coolapk.market.widget.ColorPickerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteColorPickerFragment.kt */
final class VoteColorPickerFragment$onCreateDialog$3 implements View.OnClickListener {
    final /* synthetic */ VoteColorPickerFragment this$0;

    VoteColorPickerFragment$onCreateDialog$3(VoteColorPickerFragment voteColorPickerFragment) {
        this.this$0 = voteColorPickerFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
        colorPickerDialog.setInitColor(VoteColorPickerFragment.access$getColorPrimary$p(this.this$0));
        colorPickerDialog.setOuterListener(new ColorPickerView.OnColorChooseListener(this) {
            /* class com.coolapk.market.view.feedv8.VoteColorPickerFragment$onCreateDialog$3.AnonymousClass1 */
            final /* synthetic */ VoteColorPickerFragment$onCreateDialog$3 this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.ColorPickerView.OnColorChooseListener
            public final void onColorChoose(int i) {
                VoteColorPickerFragment.access$setColorPrimary$p(this.this$0.this$0, i);
                UiUtils.tintBackground(VoteColorPickerFragment.access$getBinding$p(this.this$0.this$0).colorView1, i);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        colorPickerDialog.show(childFragmentManager, (String) null);
    }
}
