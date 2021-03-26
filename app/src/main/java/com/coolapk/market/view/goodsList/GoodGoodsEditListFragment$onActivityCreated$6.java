package com.coolapk.market.view.goodsList;

import android.text.TextUtils;
import androidx.databinding.Observable;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/goodsList/GoodGoodsEditListFragment$onActivityCreated$6", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
public final class GoodGoodsEditListFragment$onActivityCreated$6 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ GoodGoodsEditListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    GoodGoodsEditListFragment$onActivityCreated$6(GoodGoodsEditListFragment goodGoodsEditListFragment) {
        this.this$0 = goodGoodsEditListFragment;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        if (i == 136 && !TextUtils.isEmpty(this.this$0.viewModel.getGoodsListCover())) {
            DataManager.getInstance().editGoodsList(this.this$0.getFeed().getId(), this.this$0.viewModel.getGoodsShowTitle(), this.this$0.viewModel.getGoodsShowMessage(), this.this$0.viewModel.getCoverUrl()).compose(RxUtils.apiCommonToData()).subscribe(new GoodGoodsEditListFragment$onActivityCreated$6$onPropertyChanged$1(this), new GoodGoodsEditListFragment$onActivityCreated$6$onPropertyChanged$2(this));
        }
    }
}
