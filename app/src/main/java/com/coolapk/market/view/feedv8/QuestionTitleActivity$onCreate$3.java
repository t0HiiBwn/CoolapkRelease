package com.coolapk.market.view.feedv8;

import android.text.Editable;
import com.coolapk.market.widget.LazyTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lrx/Emitter;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: QuestionTitleActivity.kt */
final class QuestionTitleActivity$onCreate$3<T> implements Action1<Emitter<String>> {
    final /* synthetic */ QuestionTitleActivity this$0;

    QuestionTitleActivity$onCreate$3(QuestionTitleActivity questionTitleActivity) {
        this.this$0 = questionTitleActivity;
    }

    public final void call(final Emitter<String> emitter) {
        QuestionTitleActivity.access$getMBinding$p(this.this$0).editText.addTextChangedListener(new LazyTextWatcher() {
            /* class com.coolapk.market.view.feedv8.QuestionTitleActivity$onCreate$3.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: rx.Emitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "s");
                super.afterTextChanged(editable);
                emitter.onNext(editable.toString());
            }
        });
    }
}
