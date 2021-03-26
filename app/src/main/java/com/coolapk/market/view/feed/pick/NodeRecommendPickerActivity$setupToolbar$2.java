package com.coolapk.market.view.feed.pick;

import com.coolapk.market.databinding.SearchBackHeaderBinding;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeRecommendPickerActivity.kt */
final class NodeRecommendPickerActivity$setupToolbar$2 implements Runnable {
    final /* synthetic */ SearchHeaderViewPart $searchViewPart;
    final /* synthetic */ NodeRecommendPickerActivity this$0;

    NodeRecommendPickerActivity$setupToolbar$2(NodeRecommendPickerActivity nodeRecommendPickerActivity, SearchHeaderViewPart searchHeaderViewPart) {
        this.this$0 = nodeRecommendPickerActivity;
        this.$searchViewPart = searchHeaderViewPart;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseActivity activity = this.this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        if (!activity.isFinishing()) {
            UiUtils.openKeyboard(((SearchBackHeaderBinding) this.$searchViewPart.getBinding()).searchText);
        }
    }
}
