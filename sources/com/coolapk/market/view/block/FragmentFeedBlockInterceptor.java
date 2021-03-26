package com.coolapk.market.view.block;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u00020\b*\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/block/FragmentFeedBlockInterceptor;", "Lcom/coolapk/market/view/block/FeedBlockSpamInterceptor;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "shouldModify", "", "data", "", "anchorActivity", "Landroid/app/Activity;", "isVisibleToUser", "Landroidx/fragment/app/Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FragmentFeedBlockInterceptor.kt */
public final class FragmentFeedBlockInterceptor extends FeedBlockSpamInterceptor {
    private final EntityListFragment fragment;

    /* JADX WARNING: Illegal instructions before constructor call */
    public FragmentFeedBlockInterceptor(EntityListFragment entityListFragment) {
        super(r0);
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        FragmentActivity requireActivity = entityListFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    public final boolean isVisibleToUser(Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment2, "$this$isVisibleToUser");
        if (fragment2.isVisible() && fragment2.getUserVisibleHint()) {
            Fragment parentFragment = fragment2.getParentFragment();
            Boolean bool = null;
            Boolean valueOf = parentFragment != null ? Boolean.valueOf(isVisibleToUser(parentFragment)) : null;
            if (valueOf == null) {
                valueOf = true;
            }
            if (valueOf.booleanValue()) {
                FragmentActivity activity = fragment2.getActivity();
                if (!(activity instanceof BaseActivity)) {
                    activity = null;
                }
                BaseActivity baseActivity = (BaseActivity) activity;
                if (baseActivity != null) {
                    bool = Boolean.valueOf(baseActivity.isResume());
                }
                if (bool == null) {
                    bool = false;
                }
                if (bool.booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.coolapk.market.view.block.FeedBlockSpamInterceptor, com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public boolean shouldModify(Object obj, Activity activity) {
        Intrinsics.checkNotNullParameter(obj, "data");
        return (obj instanceof Feed) && Intrinsics.areEqual(activity, this.fragment.getActivity()) && isVisibleToUser(this.fragment);
    }
}
