package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1 implements Flow<T> {
    final /* synthetic */ Function2 $areEquivalent$inlined;
    final /* synthetic */ Flow $this_distinctUntilChangedBy$inlined;

    public FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1(Flow flow, Function2 function2) {
        this.$this_distinctUntilChangedBy$inlined = flow;
        this.$areEquivalent$inlined = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) NullSurrogateKt.NULL;
        Object collect = this.$this_distinctUntilChangedBy$inlined.collect(new FlowCollector<T>() {
            /* class kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                AnonymousClass1 r0;
                int i;
                if (continuation instanceof AnonymousClass1) {
                    r0 = (AnonymousClass1) continuation;
                    if ((r0.label & Integer.MIN_VALUE) != 0) {
                        r0.label -= Integer.MIN_VALUE;
                        Object obj2 = r0.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = r0.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            if (objectRef.element == NullSurrogateKt.NULL || !((Boolean) this.$areEquivalent$inlined.invoke(objectRef.element, obj)).booleanValue()) {
                                objectRef.element = obj;
                                FlowCollector flowCollector = flowCollector;
                                r0.L$0 = this;
                                r0.L$1 = obj;
                                r0.L$2 = r0;
                                r0.L$3 = obj;
                                r0.L$4 = obj;
                                r0.label = 1;
                                if (flowCollector.emit(obj, r0) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else if (i == 1) {
                            Object obj3 = r0.L$4;
                            Object obj4 = r0.L$3;
                            AnonymousClass1 r5 = (AnonymousClass1) r0.L$2;
                            Object obj5 = r0.L$1;
                            AnonymousClass2 r52 = (AnonymousClass2) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }
                r0 = new ContinuationImpl(this, continuation) {
                    /* class kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1.AnonymousClass2.AnonymousClass1 */
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ AnonymousClass2 this$0;

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
                Object obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
