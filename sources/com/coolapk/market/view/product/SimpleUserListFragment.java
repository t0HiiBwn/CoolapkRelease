package com.coolapk.market.view.product;

import android.os.Bundle;
import com.coolapk.market.model.User;
import com.coolapk.market.view.base.asynclist.ShortAsyncListFragment;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/product/SimpleUserListFragment;", "Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment;", "Lcom/coolapk/market/model/User;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleUserListFragment.kt */
public abstract class SimpleUserListFragment extends ShortAsyncListFragment<User> {
    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558967, 2131231052).create());
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558967).suitedClass(User.class).constructor(new SimpleUserListFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        initData();
        setLoadMoreEnable(true);
        setRefreshEnable(true);
    }
}
