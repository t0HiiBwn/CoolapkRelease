package com.coolapk.market.view.search;

import android.os.Bundle;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/search/SearchSceneListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "searchType", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchSceneListFragment.kt */
public final class SearchSceneListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SEARCH_TYPE = "SEARCH_TYPE";
    private String searchType;

    @JvmStatic
    public static final SearchSceneListFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/search/SearchSceneListFragment$Companion;", "", "()V", "KEY_SEARCH_TYPE", "", "newInstance", "Lcom/coolapk/market/view/search/SearchSceneListFragment;", "searchType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchSceneListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SearchSceneListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "searchType");
            SearchSceneListFragment searchSceneListFragment = new SearchSceneListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("SEARCH_TYPE", str);
            Unit unit = Unit.INSTANCE;
            searchSceneListFragment.setArguments(bundle);
            return searchSceneListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("SEARCH_TYPE");
        Intrinsics.checkNotNull(string);
        this.searchType = string;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(null, 0);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String str = this.searchType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchType");
        }
        String str2 = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        String entityId2 = (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId();
        Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default2 != null) {
            str2 = EntityExtendsKt.getPageContext(findLastEntity$default2);
        }
        Observable<R> map = instance.suggestSpotSearch(str, i, entityId, entityId2, str2).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }
}
