package com.coolapk.market.view.feed.article;

import com.coolapk.market.model.Entity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFragmentPresenter.kt */
final class ArticleFragmentPresenter$urlEntityMap$2 extends Lambda implements Function0<Map<String, ? extends Entity>> {
    final /* synthetic */ ArticleFragmentPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFragmentPresenter$urlEntityMap$2(ArticleFragmentPresenter articleFragmentPresenter) {
        super(0);
        this.this$0 = articleFragmentPresenter;
    }

    /* Return type fixed from 'java.util.Map<java.lang.String, com.coolapk.market.model.Entity>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends Entity> invoke() {
        List<Entity> extraEntities = this.this$0.getFeed().getExtraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "feed.extraEntities");
        List<Entity> list = extraEntities;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (T t : list) {
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            String url = t2.getUrl();
            if (url == null) {
                url = "";
            }
            linkedHashMap.put(url, t);
        }
        return linkedHashMap;
    }
}
