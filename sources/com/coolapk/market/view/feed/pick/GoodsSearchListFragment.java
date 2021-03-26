package com.coolapk.market.view.feed.pick;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Goods;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

/* compiled from: GoodsSearchListFragment.kt */
public final class GoodsSearchListFragment extends GoodsCouponSearchListFragment {
    public static final Companion Companion = new Companion(null);

    /* compiled from: GoodsSearchListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GoodsSearchListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3);
        }

        public final GoodsSearchListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "keywords");
            Intrinsics.checkNotNullParameter(str2, "sortName");
            GoodsSearchListFragment goodsSearchListFragment = new GoodsSearchListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("keyword", str);
            bundle.putString("sort", str3);
            bundle.putString("sort_name", str2);
            Unit unit = Unit.INSTANCE;
            goodsSearchListFragment.setArguments(bundle);
            return goodsSearchListFragment;
        }
    }

    @Override // com.coolapk.market.view.feed.pick.GoodsCouponSearchListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558762).suitedEntityType("pear_goods").constructor(new GoodsSearchListFragment$onActivityCreated$1(this)).doAfterBind(new GoodsSearchListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
    }

    public final void convertPearGoodsToFeedGoods(Goods goods) {
        String goodsUrl = goods.getGoodsUrl();
        DialogUtil dialogUtil = DialogUtil.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        DataManager.getInstance().addGoods(goodsUrl).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new GoodsSearchListFragment$convertPearGoodsToFeedGoods$1(DialogUtil.showProgressDialog$default(dialogUtil, requireActivity, "正在添加...", false, 4, null))).subscribe((Subscriber<? super R>) new GoodsSearchListFragment$convertPearGoodsToFeedGoods$2(this));
    }

    @Override // com.coolapk.market.view.feed.pick.GoodsCouponSearchListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String keywords = getKeywords();
        String sortName = getSortName();
        String sort = getSort();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.goodsSearch(keywords, sortName, sort, 0, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }
}
