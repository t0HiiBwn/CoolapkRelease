package com.coolapk.market.view.search;

import android.view.View;
import android.widget.AutoCompleteTextView;
import com.coolapk.market.manager.StatisticHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchActivity.kt */
final class SuperSearchActivity$onCreate$2 implements View.OnClickListener {
    final /* synthetic */ SuperSearchActivity this$0;

    SuperSearchActivity$onCreate$2(SuperSearchActivity superSearchActivity) {
        this.this$0 = superSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StatisticHelper.Companion.getInstance().recordEvent("V9搜索界面", "搜索按钮");
        SuperSearchActivity superSearchActivity = this.this$0;
        AutoCompleteTextView autoCompleteTextView = SuperSearchActivity.access$getBinding$p(superSearchActivity).searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
        superSearchActivity.inputKeyword(autoCompleteTextView.getText().toString());
    }
}
