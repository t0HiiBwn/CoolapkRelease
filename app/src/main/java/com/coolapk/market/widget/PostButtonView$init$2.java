package com.coolapk.market.widget;

import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: PostButtonView.kt */
final class PostButtonView$init$2 implements View.OnClickListener {
    final /* synthetic */ PostButtonView this$0;

    PostButtonView$init$2(PostButtonView postButtonView) {
        this.this$0 = postButtonView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StatisticHelper.Companion.getInstance().recordEvent("V9主界面", "动态入口");
        AppHolder.setWeakValue("EXTRA_BACKGROUND_ACTIVITY", this.this$0.getContext());
        ActionManager.startFeedEntranceV8Activity(this.this$0.getContext());
    }
}
