package com.coolapk.market.view.main;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/main/NewestListFragment;", "Lcom/coolapk/market/view/main/ServiceAppTimeFragment;", "()V", "getTimeDescription", "", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NewestListFragment.kt */
public final class NewestListFragment extends ServiceAppTimeFragment {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.main.ServiceAppTimeFragment
    protected String getTimeDescription(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "serviceApp");
        String updateTimeDescription = DateUtils.getUpdateTimeDescription(getActivity(), Long.valueOf(serviceApp.getPublicUpdate()));
        Intrinsics.checkNotNullExpressionValue(updateTimeDescription, "DateUtils.getUpdateTimeD… serviceApp.publicUpdate)");
        return updateTimeDescription;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String str = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, "apk", null, false, false, 14, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, "apk", false, 2, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> map = instance.getNewestAppList(i, entityId, str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/NewestListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/main/NewestListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NewestListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NewestListFragment newInstance() {
            Bundle bundle = new Bundle();
            NewestListFragment newestListFragment = new NewestListFragment();
            newestListFragment.setArguments(bundle);
            return newestListFragment;
        }
    }
}
