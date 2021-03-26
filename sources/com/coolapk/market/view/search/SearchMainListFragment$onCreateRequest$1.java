package com.coolapk.market.view.search;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.HotSearchHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
final class SearchMainListFragment$onCreateRequest$1<T, R> implements Func1<ResponseBody, Result<List<? extends Entity>>> {
    final /* synthetic */ SearchMainListFragment this$0;

    SearchMainListFragment$onCreateRequest$1(SearchMainListFragment searchMainListFragment) {
        this.this$0 = searchMainListFragment;
    }

    public final Result<List<Entity>> call(ResponseBody responseBody) {
        HotSearchHelper hotSearchHelper = HotSearchHelper.INSTANCE;
        String str = this.this$0.getReturnType();
        Intrinsics.checkNotNullExpressionValue(str, "returnType");
        hotSearchHelper.save(str, responseBody.string());
        HotSearchHelper hotSearchHelper2 = HotSearchHelper.INSTANCE;
        String str2 = this.this$0.getReturnType();
        Intrinsics.checkNotNullExpressionValue(str2, "returnType");
        return hotSearchHelper2.getSearchHotEntities(str2);
    }
}
