package com.coolapk.market.view.feedv8;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.databinding.SubmitFeedAddMoreItemDialogBinding;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$showShareDialog$3 implements View.OnClickListener {
    final /* synthetic */ SubmitFeedAddMoreItemDialogBinding $binding;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ int $typeId;
    final /* synthetic */ SubmitFeedV8Activity this$0;

    SubmitFeedV8Activity$showShareDialog$3(SubmitFeedV8Activity submitFeedV8Activity, AlertDialog alertDialog, SubmitFeedAddMoreItemDialogBinding submitFeedAddMoreItemDialogBinding, int i) {
        this.this$0 = submitFeedV8Activity;
        this.$dialog = alertDialog;
        this.$binding = submitFeedAddMoreItemDialogBinding;
        this.$typeId = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
        EditText editText = this.$binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        switch (this.$typeId) {
            case 2131362181:
                this.this$0.loadShareInfo(obj);
                return;
            case 2131362182:
                Toast.show$default(this.this$0.getActivity(), "还不支持哟", 0, false, 12, null);
                return;
            case 2131362183:
                this.this$0.loadVideoInfo(obj);
                return;
            default:
                return;
        }
    }
}
