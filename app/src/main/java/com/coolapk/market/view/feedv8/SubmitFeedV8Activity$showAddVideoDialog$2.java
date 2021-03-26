package com.coolapk.market.view.feedv8;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.databinding.SubmitFeedAddVideoItemDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$showAddVideoDialog$2 implements View.OnClickListener {
    final /* synthetic */ SubmitFeedAddVideoItemDialogBinding $binding;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ SubmitFeedV8Activity this$0;

    SubmitFeedV8Activity$showAddVideoDialog$2(SubmitFeedV8Activity submitFeedV8Activity, AlertDialog alertDialog, SubmitFeedAddVideoItemDialogBinding submitFeedAddVideoItemDialogBinding) {
        this.this$0 = submitFeedV8Activity;
        this.$dialog = alertDialog;
        this.$binding = submitFeedAddVideoItemDialogBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
        EditText editText = this.$binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        this.this$0.loadVideoInfo(editText.getText().toString());
    }
}
