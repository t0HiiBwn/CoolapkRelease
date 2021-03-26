package com.coolapk.market.view.collectionList;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: CollectionSelectActivity.kt */
final class CollectionSelectActivity$onCreate$3 implements View.OnClickListener {
    final /* synthetic */ CollectionSelectActivity this$0;

    CollectionSelectActivity$onCreate$3(CollectionSelectActivity collectionSelectActivity) {
        this.this$0 = collectionSelectActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Fragment viewPagerFragment = this.this$0.getViewPagerFragment(0);
        Activity currentActivity = AppHolder.getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity()!!");
        ActionManager.startCollectionListCreateActivityForResult(viewPagerFragment, currentActivity.getLocalClassName(), 424);
    }
}
