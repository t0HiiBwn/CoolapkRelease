package com.coolapk.market.view.message;

import android.widget.AutoCompleteTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "ob", "Lrx/Emitter;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: RecentContactsActivity.kt */
final class RecentContactsActivity$setupAutoInputKeyword$1<T> implements Action1<Emitter<String>> {
    final /* synthetic */ RecentContactsActivity this$0;

    RecentContactsActivity$setupAutoInputKeyword$1(RecentContactsActivity recentContactsActivity) {
        this.this$0 = recentContactsActivity;
    }

    public final void call(Emitter<String> emitter) {
        AutoCompleteTextView autoCompleteTextView = RecentContactsActivity.access$getBinding$p(this.this$0).searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
        autoCompleteTextView.addTextChangedListener(new RecentContactsActivity$setupAutoInputKeyword$1$$special$$inlined$doAfterTextChanged$1(this, emitter));
    }
}
