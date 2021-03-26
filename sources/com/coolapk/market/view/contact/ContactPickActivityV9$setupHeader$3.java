package com.coolapk.market.view.contact;

import android.view.View;
import android.widget.AutoCompleteTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ContactPickActivityV9.kt */
final class ContactPickActivityV9$setupHeader$3 implements View.OnClickListener {
    final /* synthetic */ ContactPickActivityV9 this$0;

    ContactPickActivityV9$setupHeader$3(ContactPickActivityV9 contactPickActivityV9) {
        this.this$0 = contactPickActivityV9;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ContactPickActivityV9 contactPickActivityV9 = this.this$0;
        AutoCompleteTextView autoCompleteTextView = ContactPickActivityV9.access$getBinding$p(contactPickActivityV9).searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
        contactPickActivityV9.inputKeyword(autoCompleteTextView.getText().toString());
    }
}
