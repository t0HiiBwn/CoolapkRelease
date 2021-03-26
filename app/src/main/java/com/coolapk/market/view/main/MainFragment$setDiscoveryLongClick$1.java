package com.coolapk.market.view.main;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$setDiscoveryLongClick$1 implements View.OnLongClickListener {
    final /* synthetic */ MainFragment this$0;

    MainFragment$setDiscoveryLongClick$1(MainFragment mainFragment) {
        this.this$0 = mainFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.this$0.latestPosition != this.this$0.index(PageName.DISCOVERY)) {
            return false;
        }
        Fragment lastFragment = this.this$0.getLastFragment();
        if (!(lastFragment instanceof DiscoveryFragmentV11)) {
            lastFragment = null;
        }
        DiscoveryFragmentV11 discoveryFragmentV11 = (DiscoveryFragmentV11) lastFragment;
        if (discoveryFragmentV11 == null) {
            return true;
        }
        discoveryFragmentV11.showHomeTabSelector();
        return true;
    }
}
