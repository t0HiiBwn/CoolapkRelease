package com.coolapk.market.view.main;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/main/AppCategoryFragment;", "Lcom/coolapk/market/view/main/MainCategoryFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppCategoryFragment.kt */
public final class AppCategoryFragment extends MainCategoryFragment {
    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setPresenter(new MainCategoryPresenter(this, "1"));
    }

    @Override // com.coolapk.market.view.main.MainCategoryFragment, com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initData();
    }
}
