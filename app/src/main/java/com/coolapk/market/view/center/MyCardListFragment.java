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
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

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
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558629).constructor(MyCardListFragment$onRegisterCards$1.INSTANCE).suitedEntityType("entity_type_user_card_add").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558973).suitedEntityType("history").constructor(new MyCardListFragment$onRegisterCards$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558953).constructor(MyCardListFragment$onRegisterCards$3.INSTANCE).suitedEntityType("tipsCard").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558633).constructor(MyCardListFragment$onRegisterCards$4.INSTANCE).suitedEntityType("entity_type_user_card_manager").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558832).constructor(MyCardListFragment$onRegisterCards$5.INSTANCE).suitedEntityType("entity_type_user_no_card").build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> flatMap = DataManager.getInstance().loadCardConfig("my_page_card_config").compose(RxUtils.apiCommonToData()).flatMap(MyCardListFragment$onCreateRequest$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(…t(list)\n                }");
        return flatMap;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        getDataList().clear();
        return super.onRequestResponse(z, list);
    }

    public final void onMyCardUpdateChange(MyCardUpdateEvent myCardUpdateEvent) {
        Intrinsics.checkNotNullParameter(myCardUpdateEvent, "event");
        if (myCardUpdateEvent.getNeedRefrash()) {
            reloadData();
        }
    }
}
