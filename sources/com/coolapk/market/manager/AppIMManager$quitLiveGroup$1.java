package com.coolapk.market.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, d2 = {"quitLiveGroup", "", "groupId", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.coolapk.market.manager.AppIMManager", f = "AppIMManager.kt", i = {0, 0}, l = {187}, m = "quitLiveGroup", n = {"this", "groupId"}, s = {"L$0", "L$1"})
/* compiled from: AppIMManager.kt */
final class AppIMManager$quitLiveGroup$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppIMManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppIMManager$quitLiveGroup$1(AppIMManager appIMManager, Continuation continuation) {
        super(continuation);
        this.this$0 = appIMManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.quitLiveGroup(null, this);
    }
}
