package com.coolapk.market.view.video;

import android.view.View;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserKeyInputFragment.kt */
final class UserKeyInputFragment$onActivityCreated$1 implements View.OnClickListener {
    final /* synthetic */ String $type;
    final /* synthetic */ UserKeyInputFragment this$0;

    UserKeyInputFragment$onActivityCreated$1(UserKeyInputFragment userKeyInputFragment, String str) {
        this.this$0 = userKeyInputFragment;
        this.$type = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText = UserKeyInputFragment.access$getBinding$p(this.this$0).editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        this.this$0.checkInputKeyAndType(editText.getText().toString(), this.$type);
    }
}
