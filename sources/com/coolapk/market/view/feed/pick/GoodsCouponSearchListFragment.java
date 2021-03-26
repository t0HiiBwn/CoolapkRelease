package com.coolapk.market.view.feed.pick;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/feed/pick/GoodsCouponSearchListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "keywords", "", "getKeywords", "()Ljava/lang/String;", "sort", "getSort", "sortName", "getSortName", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onSaveInstanceState", "outState", "resetSort", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsSearchListFragment.kt */
public class GoodsCouponSearchListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_KEY_SORT = "sort";
    public static final String EXTRA_KEY_SORT_NAME = "sort_name";
    public static final String EXTRA_KEY_WORD = "keyword";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/pick/GoodsCouponSearchListFragment$Companion;", "", "()V", "EXTRA_KEY_SORT", "", "EXTRA_KEY_SORT_NAME", "EXTRA_KEY_WORD", "newInstance", "Lcom/coolapk/market/view/feed/pick/GoodsCouponSearchListFragment;", "keywords", "sortName", "sort", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsSearchListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GoodsCouponSearchListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3);
        }

        public final GoodsCouponSearchListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "keywords");
            Intrinsics.checkNotNullParameter(str2, "sortName");
            GoodsCouponSearchListFragment goodsCouponSearchListFragment = new GoodsCouponSearchListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("keyword", str);
            bundle.putString("sort", str3);
            bundle.putString("sort_name", str2);
            Unit unit = Unit.INSTANCE;
            goodsCouponSearchListFragment.setArguments(bundle);
            return goodsCouponSearchListFragment;
        }
    }

    public final String getKeywords() {
        return requireArguments().getString("keyword");
    }

    public final String getSort() {
        return requireArguments().getString("sort");
    }

    public final String getSortName() {
        return requireArguments().getString("sort_name");
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            Object obj = bundle.get("F_ID");
            if (!Intrinsics.areEqual(obj, getKeywords() + '|' + getSort() + '|' + getSortName())) {
                getDataList().clear();
                setPage(1);
                reloadData(true);
            }
        }
    }

    public final void resetSort(String str) {
        requireArguments().putString("sort", str);
        getDataList().clear();
        setPage(1);
        reloadData(true);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String keywords = getKeywords();
        String sortName = getSortName();
        String sort = getSort();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.goodsSearch(keywords, sortName, sort, 1, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString("F_ID", getKeywords() + '|' + getSort() + '|' + getSortName());
    }
}
