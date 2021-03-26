package com.coolapk.market.view.search;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onDoubleClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchResultActivity.kt */
final class SuperSearchResultActivity$setTabLayoutDoubleClickListener$1 implements ViewUtil.OnDoubleClickListener {
    final /* synthetic */ SuperSearchResultActivity this$0;

    SuperSearchResultActivity$setTabLayoutDoubleClickListener$1(SuperSearchResultActivity superSearchResultActivity) {
        this.this$0 = superSearchResultActivity;
    }

    @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
    public final boolean onDoubleClick(View view) {
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        int indexOfChild = ((ViewGroup) parent).indexOfChild(view);
        ScrollStateViewPager scrollStateViewPager = SuperSearchResultActivity.access$getBinding$p(this.this$0).viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        if (scrollStateViewPager.getCurrentItem() != indexOfChild) {
            return false;
        }
        Fragment viewPagerFragment = this.this$0.getViewPagerFragment(indexOfChild);
        if (!(viewPagerFragment instanceof ScrollableFragment) || !viewPagerFragment.isVisible()) {
            return false;
        }
        ((ScrollableFragment) viewPagerFragment).scrollToTop(true);
        return true;
    }
}
