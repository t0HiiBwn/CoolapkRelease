package com.coolapk.market.view.feed.pick;

import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.coolapk.market.databinding.SearchBackHeaderBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchHeaderViewPart.kt */
final class SearchHeaderViewPart$onViewCreated$2 implements View.OnClickListener {
    final /* synthetic */ SearchHeaderViewPart this$0;

    SearchHeaderViewPart$onViewCreated$2(SearchHeaderViewPart searchHeaderViewPart) {
        this.this$0 = searchHeaderViewPart;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AutoCompleteTextView autoCompleteTextView = ((SearchBackHeaderBinding) this.this$0.getBinding()).searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchText");
        Editable text = autoCompleteTextView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "binding.searchText.text");
        if (text.length() > 0) {
            AutoCompleteTextView autoCompleteTextView2 = ((SearchBackHeaderBinding) this.this$0.getBinding()).searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView2, "binding.searchText");
            autoCompleteTextView2.getText().clear();
        }
    }
}
