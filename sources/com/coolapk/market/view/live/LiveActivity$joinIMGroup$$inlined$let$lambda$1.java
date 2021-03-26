package com.coolapk.market.view.live;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.AppIMManager;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/coolapk/market/view/live/LiveActivity$joinIMGroup$1$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.coolapk.market.view.live.LiveActivity$joinIMGroup$1$1", f = "LiveActivity.kt", i = {}, l = {734}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LiveActivity.kt */
final class LiveActivity$joinIMGroup$$inlined$let$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $groupId;
    int label;
    final /* synthetic */ LiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveActivity$joinIMGroup$$inlined$let$lambda$1(String str, Continuation continuation, LiveActivity liveActivity) {
        super(2, continuation);
        this.$groupId = str;
        this.this$0 = liveActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new LiveActivity$joinIMGroup$$inlined$let$lambda$1(this.$groupId, continuation, this.this$0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LiveActivity$joinIMGroup$$inlined$let$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppIMManager appIMManager = AppHolder.getAppIMManager();
            String str = this.$groupId;
            Intrinsics.checkNotNullExpressionValue(str, "groupId");
            this.label = 1;
            if (appIMManager.joinLiveGroup(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.show$default(this.this$0, e.getMessage(), 0, false, 12, null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
