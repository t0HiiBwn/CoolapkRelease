package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/cardlist/ProxyEntityListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "requestProxy", "Lcom/coolapk/market/view/cardlist/ProxyEntityListFragment$RequestProxy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "setRequestProxy", "proxy", "Companion", "RequestProxy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProxyEntityListFragment.kt */
public final class ProxyEntityListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private RequestProxy requestProxy;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/cardlist/ProxyEntityListFragment$RequestProxy;", "", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "firstItem", "", "lastItem", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProxyEntityListFragment.kt */
    public interface RequestProxy {
        Observable<List<Entity>> onCreateRequest(boolean z, int i, String str, String str2);
    }

    @JvmStatic
    public static final ProxyEntityListFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/cardlist/ProxyEntityListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/cardlist/ProxyEntityListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProxyEntityListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ProxyEntityListFragment newInstance() {
            return new ProxyEntityListFragment();
        }
    }

    public final void setRequestProxy(RequestProxy requestProxy2) {
        Intrinsics.checkNotNullParameter(requestProxy2, "proxy");
        this.requestProxy = requestProxy2;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.requestProxy == null) {
            setExtraRequestProvider(null);
        } else {
            setExtraRequestProvider(new ProxyEntityListFragment$onCreate$1(this));
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<List<Entity>> error = Observable.error(new RuntimeException("setExtraRequestProvider"));
        Intrinsics.checkNotNullExpressionValue(error, "Observable.error(Runtime…etExtraRequestProvider\"))");
        return error;
    }
}
