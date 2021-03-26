package com.coolapk.market.view.feed.pick;

import android.view.View;
import android.widget.AutoCompleteTextView;
import com.coolapk.market.databinding.SearchBackHeaderBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchHeaderViewPart.kt */
final class SearchHeaderViewPart$onViewCreated$3 implements View.OnClickListener {
    final /* synthetic */ SearchHeaderViewPart this$0;

    SearchHeaderViewPart$onViewCreated$3(SearchHeaderViewPart searchHeaderViewPart) {
        this.this$0 = searchHeaderViewPart;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<String, Unit> onKeyWords = this.this$0.getOnKeyWords();
        if (onKeyWords != null) {
            AutoCompleteTextView autoCompleteTextView = ((SearchBackHeaderBinding) this.this$0.getBinding()).searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchText");
            onKeyWords.invoke(autoCompleteTextView.getText().toString());
        }
    }
}
