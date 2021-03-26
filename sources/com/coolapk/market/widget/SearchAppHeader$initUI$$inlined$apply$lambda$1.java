package com.coolapk.market.widget;

import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/widget/SearchAppHeader$initUI$6$3"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchAppHeader.kt */
final class SearchAppHeader$initUI$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ FrameLayout $this_apply;
    final /* synthetic */ SearchAppHeader this$0;

    SearchAppHeader$initUI$$inlined$apply$lambda$1(FrameLayout frameLayout, SearchAppHeader searchAppHeader) {
        this.$this_apply = frameLayout;
        this.this$0 = searchAppHeader;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StatisticHelper.Companion.getInstance().recordEvent("V9主界面", "搜索条");
        ActionManager.startSearchActivity(this.$this_apply.getContext(), null, this.this$0.searchHintKeyword);
    }
}
