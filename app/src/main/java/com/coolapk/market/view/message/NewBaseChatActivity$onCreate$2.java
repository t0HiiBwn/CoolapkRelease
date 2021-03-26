package com.coolapk.market.view.message;

import android.text.Editable;
import com.coolapk.market.view.message.NewBaseChatActivity;
import com.coolapk.market.widget.LazyTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/message/NewBaseChatActivity$onCreate$2", "Lcom/coolapk/market/widget/LazyTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NewBaseChatActivity.kt */
public final class NewBaseChatActivity$onCreate$2 extends LazyTextWatcher {
    final /* synthetic */ NewBaseChatActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NewBaseChatActivity$onCreate$2(NewBaseChatActivity newBaseChatActivity) {
        this.this$0 = newBaseChatActivity;
    }

    @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        NewBaseChatActivity.ViewMode viewMode = this.this$0.getViewMode();
        Intrinsics.checkNotNull(viewMode);
        viewMode.setEditing(editable.length() > 0);
    }
}
