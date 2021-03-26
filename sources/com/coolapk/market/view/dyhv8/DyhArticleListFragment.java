package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "listType", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleListFragment.kt */
public final class DyhArticleListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_TYPE = "TYPE";
    private String listType;

    @JvmStatic
    public static final DyhArticleListFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleListFragment$Companion;", "", "()V", "KEY_TYPE", "", "newInstance", "Lcom/coolapk/market/view/dyhv8/DyhArticleListFragment;", "type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DyhArticleListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            DyhArticleListFragment dyhArticleListFragment = new DyhArticleListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("TYPE", str);
            Unit unit = Unit.INSTANCE;
            dyhArticleListFragment.setArguments(bundle);
            return dyhArticleListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("TYPE");
        Intrinsics.checkNotNull(string);
        this.listType = string;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        Entity findLastEntity$default2;
        Entity findFirstEntity$default2;
        String str = this.listType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listType");
        }
        String str2 = null;
        if (str.hashCode() == 525320282 && str.equals("favoriteList")) {
            DataManager instance = DataManager.getInstance();
            String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
            if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
                str2 = findLastEntity$default.getEntityId();
            }
            Observable<R> compose = instance.getFavoriteList("article", i, entityId, str2).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose;
        }
        DataManager instance2 = DataManager.getInstance();
        String entityId2 = (!z || (findFirstEntity$default2 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default2.getEntityId();
        if (!z && (findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
            str2 = findLastEntity$default2.getEntityId();
        }
        Observable<R> compose2 = instance2.getArticleList("", "all", i, entityId2, str2).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose2, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose2;
    }
}
