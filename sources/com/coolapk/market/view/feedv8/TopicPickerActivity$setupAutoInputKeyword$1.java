package com.coolapk.market.view.feedv8;

import android.text.Editable;
import android.widget.ImageView;
import com.coolapk.market.widget.LazyTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lrx/Emitter;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicPickerActivity.kt */
final class TopicPickerActivity$setupAutoInputKeyword$1<T> implements Action1<Emitter<String>> {
    final /* synthetic */ TopicPickerActivity this$0;

    TopicPickerActivity$setupAutoInputKeyword$1(TopicPickerActivity topicPickerActivity) {
        this.this$0 = topicPickerActivity;
    }

    public final void call(final Emitter<String> emitter) {
        TopicPickerActivity.access$getBinding$p(this.this$0).searchHeader.searchText.addTextChangedListener(new LazyTextWatcher(this) {
            /* class com.coolapk.market.view.feedv8.TopicPickerActivity$setupAutoInputKeyword$1.AnonymousClass1 */
            final /* synthetic */ TopicPickerActivity$setupAutoInputKeyword$1 this$0;

            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: rx.Emitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "editable");
                ImageView imageView = TopicPickerActivity.access$getBinding$p(this.this$0.this$0).searchHeader.clearButton;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchHeader.clearButton");
                int i = 0;
                if (!(editable.length() > 0)) {
                    i = 8;
                }
                imageView.setVisibility(i);
                emitter.onNext(editable.toString());
            }
        });
    }
}
