package com.coolapk.market.view.cardlist;

import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.util.LogUtils;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainV8ListFragment.kt */
final class UpgradeCardViewHolder$bindTo$2 implements Runnable {
    final /* synthetic */ UpgradeCardViewHolder this$0;

    UpgradeCardViewHolder$bindTo$2(UpgradeCardViewHolder upgradeCardViewHolder) {
        this.this$0 = upgradeCardViewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataBindingComponent component = this.this$0.getComponent();
        if (component instanceof FragmentBindingComponent) {
            LogUtils.d("因为没有数据，所以删除UpgradeCard", new Object[0]);
            Fragment fragment = (Fragment) ((FragmentBindingComponent) component).getContainer();
            Objects.requireNonNull(fragment, "null cannot be cast to non-null type com.coolapk.market.view.cardlist.MainV8ListFragment");
            ((MainV8ListFragment) fragment).removeUpgradeCard();
        }
    }
}
