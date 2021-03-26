package com.coolapk.market.view.dyhv8;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhDetailFragment.kt */
final class DyhDetailFragment$addFabMenu$4 implements View.OnLongClickListener {
    final /* synthetic */ DyhDetailFragment this$0;

    DyhDetailFragment$addFabMenu$4(DyhDetailFragment dyhDetailFragment) {
        this.this$0 = dyhDetailFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ActionManager.startNewFeedV8Activity(this.this$0.getActivity());
        return true;
    }
}
