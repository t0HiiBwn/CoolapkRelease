package com.coolapk.market.view.search;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.util.HotSearchHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/search/SearchMainListFragment$onCreateRequest$4", "Lcom/coolapk/market/app/EmptySubscriber;", "Lokhttp3/ResponseBody;", "onNext", "", "body", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
public final class SearchMainListFragment$onCreateRequest$4 extends EmptySubscriber<ResponseBody> {
    final /* synthetic */ SearchMainListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SearchMainListFragment$onCreateRequest$4(SearchMainListFragment searchMainListFragment) {
        this.this$0 = searchMainListFragment;
    }

    public void onNext(ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "body");
        HotSearchHelper hotSearchHelper = HotSearchHelper.INSTANCE;
        String str = this.this$0.getReturnType();
        Intrinsics.checkNotNullExpressionValue(str, "returnType");
        hotSearchHelper.save(str, responseBody.string());
    }
}
