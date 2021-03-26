package com.coolapk.market.view.center;

import android.os.Bundle;
import com.coolapk.market.event.MyCardUpdateEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0014J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0014¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/center/MyCardListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onMyCardUpdateChange", "event", "Lcom/coolapk/market/event/MyCardUpdateEvent;", "onRegisterCards", "onRequestResponse", "data", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MyCardListFragment.kt */
public final class MyCardListFragment extends EntityListFragment {
    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLoadMoreEnable(false);
        getRecyclerView().setPadding(0, NumberExtendsKt.getDp((Number) -10), 0, NumberExtendsKt.getDp((Number) 24));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558635).constructor(MyCardListFragment$onRegisterCards$1.INSTANCE).suitedEntityType("entity_type_user_card_add").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558980).suitedEntityType("history").constructor(new MyCardListFragment$onRegisterCards$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558960).constructor(MyCardListFragment$onRegisterCards$3.INSTANCE).suitedEntityType("tipsCard").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558639).constructor(MyCardListFragment$onRegisterCards$4.INSTANCE).suitedEntityType("entity_type_user_card_manager").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558839).constructor(MyCardListFragment$onRegisterCards$5.INSTANCE).suitedEntityType("entity_type_user_no_card").build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> flatMap = DataManager.getInstance().loadCardConfig("my_page_card_config").compose(RxUtils.apiCommonToData()).flatMap(MyCardListFragment$onCreateRequest$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(…t(list)\n                }");
        return flatMap;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        getDataList().clear();
        return super.onRequestResponse(z, list);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMyCardUpdateChange(MyCardUpdateEvent myCardUpdateEvent) {
        Intrinsics.checkNotNullParameter(myCardUpdateEvent, "event");
        if (myCardUpdateEvent.getNeedRefrash()) {
            reloadData();
        }
    }
}
