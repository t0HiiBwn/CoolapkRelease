package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* compiled from: Collect.kt */
public final class CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<T> {
    final /* synthetic */ CombineKt$combineInternal$2.AnonymousClass1 this$0;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 r0;
        Object coroutine_suspended;
        int i;
        Object obj2;
        CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1;
        AnonymousClass1 r2;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj3 = r0.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    r2 = r0;
                    Channel channel = r19;
                    IndexedValue indexedValue = new IndexedValue(r5, obj);
                    r0.L$0 = this;
                    r0.L$1 = obj;
                    r0.L$2 = r2;
                    r0.L$3 = obj;
                    r0.label = 1;
                    if (channel.send(indexedValue, r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = this;
                    obj2 = obj;
                } else if (i == 1) {
                    Object obj4 = r0.L$3;
                    r2 = (Continuation) r0.L$2;
                    Object obj5 = r0.L$1;
                    combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = (CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1) r0.L$0;
                    ResultKt.throwOnFailure(obj3);
                    obj2 = obj4;
                    obj = obj5;
                } else if (i == 2) {
                    Object obj6 = r0.L$3;
                    Continuation continuation2 = (Continuation) r0.L$2;
                    Object obj7 = r0.L$1;
                    CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$12 = (CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1) r0.L$0;
                    ResultKt.throwOnFailure(obj3);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r0.L$0 = combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1;
                r0.L$1 = obj;
                r0.L$2 = r2;
                r0.L$3 = obj2;
                r0.label = 2;
                if (YieldKt.yield(r0) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        };
        Object obj3 = r0.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        if (i != 0) {
        }
        r0.L$0 = combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1;
        r0.L$1 = obj;
        r0.L$2 = r2;
        r0.L$3 = obj2;
        r0.label = 2;
        if (YieldKt.yield(r0) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(CombineKt$combineInternal$2.AnonymousClass1 r1) {
        this.this$0 = r1;
    }
}
