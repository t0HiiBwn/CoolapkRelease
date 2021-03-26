package com.coolapk.market.view.message;

import android.view.View;
import android.widget.CheckBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$onShowDelView$1 implements View.OnClickListener {
    final /* synthetic */ NewMessageListFragment this$0;

    NewMessageListFragment$onShowDelView$1(NewMessageListFragment newMessageListFragment) {
        this.this$0 = newMessageListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CheckBox checkBox = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0).checkBox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "messageSelectViewBinding.checkBox");
        CheckBox checkBox2 = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0).checkBox;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "messageSelectViewBinding.checkBox");
        checkBox.setChecked(!checkBox2.isChecked());
    }
}
