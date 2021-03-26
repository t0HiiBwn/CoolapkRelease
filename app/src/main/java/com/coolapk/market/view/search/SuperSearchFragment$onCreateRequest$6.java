package com.coolapk.market.view.search;

import com.amap.api.location.AMapLocation;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "it", "Lcom/amap/api/location/AMapLocation;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onCreateRequest$6<T, R> implements Func1<AMapLocation, Observable<? extends List<Entity>>> {
    final /* synthetic */ Ref.ObjectRef $exchange;
    final /* synthetic */ boolean $hasLink;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ int $page;
    final /* synthetic */ SuperSearchFragment this$0;

    SuperSearchFragment$onCreateRequest$6(SuperSearchFragment superSearchFragment, boolean z, Ref.ObjectRef objectRef, int i, boolean z2) {
        this.this$0 = superSearchFragment;
        this.$hasLink = z;
        this.$exchange = objectRef;
        this.$page = i;
        this.$isRefresh = z2;
    }

    public final Observable<? extends List<Entity>> call(AMapLocation aMapLocation) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String dealType = SuperSearchFragment.access$getViewModel$p(this.this$0).getDealType();
        String secondHandSort = SuperSearchFragment.access$getViewModel$p(this.this$0).getSecondHandSort();
        String str = this.this$0.keyword;
        Intrinsics.checkNotNullExpressionValue(aMapLocation, "it");
        String cityCode = aMapLocation.getCityCode();
        boolean z = this.$hasLink;
        T t = this.$exchange.element;
        int i = this.$page;
        String str2 = null;
        String entityId = (!this.$isRefresh || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this.this$0, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!this.$isRefresh && (findLastEntity$default = EntityListFragment.findLastEntity$default(this.this$0, null, false, 3, null)) != null) {
            str2 = findLastEntity$default.getEntityId();
        }
        return instance.secondHandSearch(dealType, secondHandSort, str, cityCode, z, t, i, entityId, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new Action0(this) {
            /* class com.coolapk.market.view.search.SuperSearchFragment$onCreateRequest$6.AnonymousClass1 */
            final /* synthetic */ SuperSearchFragment$onCreateRequest$6 this$0;

            {
                this.this$0 = r1;
            }

            @Override // rx.functions.Action0
            public final void call() {
                if (this.this$0.this$0.shouldLoadMore) {
                    this.this$0.this$0.shouldLoadMore = false;
                    this.this$0.this$0.loadMore(true);
                }
            }
        });
    }
}
