package com.coolapk.market.view.dyhv8;

import android.text.Editable;
import android.widget.ImageView;
import com.coolapk.market.widget.LazyTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lrx/Emitter;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhIncludActivity.kt */
final class DyhIncludActivity$setupAutoInputKeyword$2<T> implements Action1<Emitter<String>> {
    final /* synthetic */ DyhIncludActivity this$0;

    DyhIncludActivity$setupAutoInputKeyword$2(DyhIncludActivity dyhIncludActivity) {
        this.this$0 = dyhIncludActivity;
    }

    public final void call(final Emitter<String> emitter) {
        DyhIncludActivity.access$getBinding$p(this.this$0).editText.addTextChangedListener(new LazyTextWatcher(this) {
            /* class com.coolapk.market.view.dyhv8.DyhIncludActivity$setupAutoInputKeyword$2.AnonymousClass1 */
            final /* synthetic */ DyhIncludActivity$setupAutoInputKeyword$2 this$0;

            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: rx.Emitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "editable");
                ImageView imageView = DyhIncludActivity.access$getBinding$p(this.this$0.this$0).clearButton;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.clearButton");
                Editable editable2 = editable;
                boolean z = true;
                imageView.setVisibility(editable2.length() > 0 ? 0 : 8);
                DyhIncludActivity dyhIncludActivity = this.this$0.this$0;
                if (editable2.length() <= 0) {
                    z = false;
                }
                dyhIncludActivity.isSearch = z;
                emitter.onNext(editable.toString());
            }
        });
    }
}
