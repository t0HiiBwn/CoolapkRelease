package com.coolapk.market.view.dyhv8;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhIncludActivity.kt */
final class DyhIncludActivity$initSearch$3 implements TextView.OnEditorActionListener {
    final /* synthetic */ DyhIncludActivity this$0;

    DyhIncludActivity$initSearch$3(DyhIncludActivity dyhIncludActivity) {
        this.this$0 = dyhIncludActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        DyhIncludActivity dyhIncludActivity = this.this$0;
        EditText editText = DyhIncludActivity.access$getBinding$p(dyhIncludActivity).editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        dyhIncludActivity.searchKey(editText.getText().toString());
        return true;
    }
}
