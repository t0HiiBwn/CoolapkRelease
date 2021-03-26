package com.coolapk.market.widget;

import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchAppHeader.kt */
final class SearchAppHeader$initUI$7$3 implements View.OnClickListener {
    final /* synthetic */ FrameLayout $this_apply;

    SearchAppHeader$initUI$7$3(FrameLayout frameLayout) {
        this.$this_apply = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startV8SettingsActivity(this.$this_apply.getContext());
    }
}
