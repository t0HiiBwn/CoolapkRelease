package com.coolapk.market.view.live;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityConvertUtils;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FakeDanmakuData.kt */
final class FakeDanmakuData$createData$1<V> implements Callable<Result<List<? extends Entity>>> {
    final /* synthetic */ FakeDanmakuData this$0;

    FakeDanmakuData$createData$1(FakeDanmakuData fakeDanmakuData) {
        this.this$0 = fakeDanmakuData;
    }

    /* Return type fixed from 'com.coolapk.market.network.Result<java.util.List<com.coolapk.market.model.Entity>>' to match base method */
    @Override // java.util.concurrent.Callable
    public final Result<List<? extends Entity>> call() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        return EntityConvertUtils.convertEntityList(instance.getGson(), FakeDanmakuData.access$createJson(this.this$0));
    }
}
