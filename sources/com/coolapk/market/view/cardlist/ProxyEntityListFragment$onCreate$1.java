package com.coolapk.market.view.cardlist;

import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.asynclist.NewAsyncListContract;
import com.coolapk.market.view.cardlist.ProxyEntityListFragment;
import com.coolapk.market.view.user.UserFeedListActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "isRefresh", "", "page", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProxyEntityListFragment.kt */
final class ProxyEntityListFragment$onCreate$1<T> implements NewAsyncListContract.RequestProvider<List<? extends Entity>> {
    final /* synthetic */ ProxyEntityListFragment this$0;

    ProxyEntityListFragment$onCreate$1(ProxyEntityListFragment proxyEntityListFragment) {
        this.this$0 = proxyEntityListFragment;
    }

    /* renamed from: invoke */
    public final Observable<List<Entity>> createRequest(boolean z, int i) {
        if (this.this$0.getActivity() instanceof UserFeedListActivity) {
            ProxyEntityListFragment proxyEntityListFragment = this.this$0;
            StringBuilder sb = new StringBuilder();
            sb.append("uid=");
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            sb.append(loginSession.getUid());
            proxyEntityListFragment.setUrlParams(sb.toString());
        }
        ProxyEntityListFragment.RequestProxy access$getRequestProxy$p = ProxyEntityListFragment.access$getRequestProxy$p(this.this$0);
        if (access$getRequestProxy$p == null) {
            return Observable.error(new RuntimeException("setExtraRequestProvider"));
        }
        String str = null;
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this.this$0, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this.this$0, null, false, 3, null);
        if (findLastEntity$default != null) {
            str = findLastEntity$default.getEntityId();
        }
        return access$getRequestProxy$p.onCreateRequest(z, i, entityId, str);
    }
}
