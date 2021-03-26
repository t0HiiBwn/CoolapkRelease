package com.coolapk.market.manager;

import com.tencent.imsdk.v2.V2TIMCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/manager/AppIMManager$joinGroup$2$1", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "onError", "", "code", "", "desc", "", "onSuccess", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppIMManager.kt */
public final class AppIMManager$joinGroup$2$1 implements V2TIMCallback {
    final /* synthetic */ Continuation $cont;

    AppIMManager$joinGroup$2$1(Continuation continuation) {
        this.$cont = continuation;
    }

    @Override // com.tencent.imsdk.v2.V2TIMCallback
    public void onError(int i, String str) {
        Continuation continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m85constructorimpl(ResultKt.createFailure(new AppIMException(-5, "加入群聊失败 " + i + ", " + str))));
    }

    @Override // com.tencent.imsdk.v2.V2TIMCallback
    public void onSuccess() {
        Continuation continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m85constructorimpl(true));
    }
}
