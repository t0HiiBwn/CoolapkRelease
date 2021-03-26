package com.coolapk.market.view.contact;

import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ContactPickActivityV9.kt */
final class ContactPickActivityV9$onCreate$2 implements Runnable {
    final /* synthetic */ ContactPickActivityV9 this$0;

    ContactPickActivityV9$onCreate$2(ContactPickActivityV9 contactPickActivityV9) {
        this.this$0 = contactPickActivityV9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.this$0.isFinishing()) {
            UiUtils.openKeyboard(ContactPickActivityV9.access$getBinding$p(this.this$0).searchHeader.searchText);
        }
    }
}
