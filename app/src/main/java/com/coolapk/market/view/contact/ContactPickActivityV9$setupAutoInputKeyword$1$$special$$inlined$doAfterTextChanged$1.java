package com.coolapk.market.view.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextView.kt */
public final class ContactPickActivityV9$setupAutoInputKeyword$1$$special$$inlined$doAfterTextChanged$1 implements TextWatcher {
    final /* synthetic */ Emitter $ob$inlined;
    final /* synthetic */ ContactPickActivityV9$setupAutoInputKeyword$1 this$0;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public ContactPickActivityV9$setupAutoInputKeyword$1$$special$$inlined$doAfterTextChanged$1(ContactPickActivityV9$setupAutoInputKeyword$1 contactPickActivityV9$setupAutoInputKeyword$1, Emitter emitter) {
        this.this$0 = contactPickActivityV9$setupAutoInputKeyword$1;
        this.$ob$inlined = emitter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if ((r5.length() > 0) == true) goto L_0x0026;
     */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ImageView imageView = ContactPickActivityV9.access$getBinding$p(this.this$0.this$0).searchHeader.clearButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchHeader.clearButton");
        int i = 0;
        if (editable != null) {
        }
        i = 8;
        imageView.setVisibility(i);
        this.$ob$inlined.onNext(String.valueOf(editable));
    }
}
