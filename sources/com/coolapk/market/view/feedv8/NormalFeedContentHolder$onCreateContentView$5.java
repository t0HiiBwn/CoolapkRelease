package com.coolapk.market.view.feedv8;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: NormalFeedContentHolder.kt */
final class NormalFeedContentHolder$onCreateContentView$5 implements View.OnFocusChangeListener {
    final /* synthetic */ NormalFeedContentHolder this$0;

    NormalFeedContentHolder$onCreateContentView$5(NormalFeedContentHolder normalFeedContentHolder) {
        this.this$0 = normalFeedContentHolder;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            view.post(new Runnable(this) {
                /* class com.coolapk.market.view.feedv8.NormalFeedContentHolder$onCreateContentView$5.AnonymousClass1 */
                final /* synthetic */ NormalFeedContentHolder$onCreateContentView$5 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i;
                    EditText editText = this.this$0.this$0.getBinding$presentation_coolapkAppRelease().editText;
                    Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
                    Editable text = editText.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    Integer valueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) text, "//", 0, false, 6, (Object) null));
                    if (!(valueOf.intValue() >= 0)) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        i = valueOf.intValue();
                    } else {
                        i = text.length();
                    }
                    Selection.setSelection(text, i, i);
                }
            });
        }
    }
}
