package com.coolapk.market.view.goods;

import android.os.Bundle;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/goods/MyGoodsListFragment;", "Lcom/coolapk/market/view/main/DataListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MyGoodsTabListActivity.kt */
public final class MyGoodsListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/goods/MyGoodsListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/main/DataListFragment;", "action", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MyGoodsTabListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DataListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "action");
            MyGoodsListFragment myGoodsListFragment = new MyGoodsListFragment();
            myGoodsListFragment.setArguments(DataListFragment.Companion.createArguments$default(DataListFragment.Companion, str, null, null, 0, 14, null));
            return myGoodsListFragment;
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558882).constructor(new MyGoodsListFragment$onActivityCreated$1(this)).suitedMethod(MyGoodsListFragment$onActivityCreated$2.INSTANCE).build(), -1);
    }
}
