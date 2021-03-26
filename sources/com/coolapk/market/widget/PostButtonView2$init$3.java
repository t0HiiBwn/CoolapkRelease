package com.coolapk.market.widget;

import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: PostButtonView2.kt */
final class PostButtonView2$init$3 implements View.OnClickListener {
    final /* synthetic */ PostButtonView2 this$0;

    PostButtonView2$init$3(PostButtonView2 postButtonView2) {
        this.this$0 = postButtonView2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StatisticHelper.Companion.getInstance().recordPlusClickEvent("打开加号");
        AppHolder.setWeakValue("EXTRA_BACKGROUND_ACTIVITY", this.this$0.getContext());
        ActionManager.startFeedEntranceV8Activity(this.this$0.getContext());
    }
}
