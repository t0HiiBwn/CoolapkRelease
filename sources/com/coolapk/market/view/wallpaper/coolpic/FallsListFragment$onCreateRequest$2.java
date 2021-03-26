package com.coolapk.market.view.wallpaper.coolpic;

import com.amap.api.location.AMapLocation;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "it", "Lcom/amap/api/location/AMapLocation;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FallsListFragment.kt */
final class FallsListFragment$onCreateRequest$2<T, R> implements Func1<AMapLocation, Observable<? extends List<Entity>>> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ int $page;
    final /* synthetic */ FallsListFragment this$0;

    FallsListFragment$onCreateRequest$2(FallsListFragment fallsListFragment, int i, boolean z) {
        this.this$0 = fallsListFragment;
        this.$page = i;
        this.$isRefresh = z;
    }

    public final Observable<? extends List<Entity>> call(AMapLocation aMapLocation) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        FallsListFragment fallsListFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(aMapLocation, "it");
        String cityCode = aMapLocation.getCityCode();
        Intrinsics.checkNotNullExpressionValue(cityCode, "it.cityCode");
        fallsListFragment.setUrl(UriUtils.getSecondhandFilterUrl("", "", "", cityCode));
        DataManager instance = DataManager.getInstance();
        String url = this.this$0.getUrl();
        String str = this.this$0.title;
        String str2 = this.this$0.subTitle;
        int i = this.$page;
        String str3 = null;
        String entityId = (!this.$isRefresh || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this.this$0, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        String entityId2 = (this.$isRefresh || (findLastEntity$default = EntityListFragment.findLastEntity$default(this.this$0, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId();
        Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this.this$0, null, false, 3, null);
        if (findLastEntity$default2 != null) {
            str3 = EntityExtendsKt.getPageContext(findLastEntity$default2);
        }
        return instance.getDataList(url, str, str2, i, entityId, entityId2, str3).map(RxUtils.checkResultToData());
    }
}
