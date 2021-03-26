package com.coolapk.market.view.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextView.kt */
public final class ContactPickActivityV9$setupHeader$$inlined$doAfterTextChanged$1 implements TextWatcher {
    final /* synthetic */ ContactPickActivityV9 this$0;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public ContactPickActivityV9$setupHeader$$inlined$doAfterTextChanged$1(ContactPickActivityV9 contactPickActivityV9) {
        this.this$0 = contactPickActivityV9;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        FrameLayout frameLayout = ContactPickActivityV9.access$getBinding$p(this.this$0).searchHeader.qrOrClearButton;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.searchHeader.qrOrClearButton");
        int i2 = 8;
        if (editable != null) {
            if (editable.length() > 0) {
                i = 0;
                frameLayout.setVisibility(i);
                LinearLayout linearLayout = ContactPickActivityV9.access$getBinding$p(this.this$0).searchPopupLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchPopupLayout");
                if (editable != null) {
                    if (editable.length() > 0) {
                        i2 = 0;
                    }
                }
                linearLayout.setVisibility(i2);
            }
        }
        i = 8;
        frameLayout.setVisibility(i);
        LinearLayout linearLayout = ContactPickActivityV9.access$getBinding$p(this.this$0).searchPopupLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchPopupLayout");
        if (editable != null) {
        }
        linearLayout.setVisibility(i2);
    }
}
