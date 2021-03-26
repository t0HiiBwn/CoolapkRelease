package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2"}, k = 1, mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__MergeKt$flatMapMerge$$inlined$map$1 implements Flow<Flow<? extends R>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ Function2 $transform$inlined$1;

    public FlowKt__MergeKt$flatMapMerge$$inlined$map$1(Flow flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = flow;
        this.$transform$inlined$1 = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector<T>() {
            /* class kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x00ab A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                AnonymousClass1 r0;
                Object obj2;
                Object coroutine_suspended;
                int i;
                FlowCollector flowCollector;
                AnonymousClass2 r9;
                Object obj3;
                AnonymousClass1 r7;
                Object obj4;
                AnonymousClass1 r5;
                Object obj5;
                FlowCollector flowCollector2;
                if (continuation instanceof AnonymousClass1) {
                    r0 = (AnonymousClass1) continuation;
                    if ((r0.label & Integer.MIN_VALUE) != 0) {
                        r0.label -= Integer.MIN_VALUE;
                        obj2 = r0.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = r0.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector3 = flowCollector;
                            Function2 function2 = this.$transform$inlined$1;
                            r0.L$0 = this;
                            r0.L$1 = obj;
                            r0.L$2 = r0;
                            r0.L$3 = obj;
                            r0.L$4 = r0;
                            r0.L$5 = obj;
                            r0.L$6 = flowCollector3;
                            r0.L$7 = flowCollector3;
                            r0.label = 1;
                            Object invoke = function2.invoke(obj, r0);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r9 = this;
                            obj5 = obj;
                            obj4 = obj5;
                            obj3 = obj4;
                            flowCollector = flowCollector3;
                            r5 = r0;
                            r7 = r5;
                            obj2 = invoke;
                            flowCollector2 = flowCollector;
                        } else if (i == 1) {
                            flowCollector = (FlowCollector) r0.L$7;
                            flowCollector2 = (FlowCollector) r0.L$6;
                            obj5 = r0.L$5;
                            r5 = (AnonymousClass1) r0.L$4;
                            obj4 = r0.L$3;
                            r7 = (AnonymousClass1) r0.L$2;
                            obj3 = r0.L$1;
                            r9 = (AnonymousClass2) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                        } else if (i == 2) {
                            FlowCollector flowCollector4 = (FlowCollector) r0.L$6;
                            Object obj6 = r0.L$5;
                            AnonymousClass1 r11 = (AnonymousClass1) r0.L$4;
                            Object obj7 = r0.L$3;
                            AnonymousClass1 r112 = (AnonymousClass1) r0.L$2;
                            Object obj8 = r0.L$1;
                            AnonymousClass2 r113 = (AnonymousClass2) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r0.L$0 = r9;
                        r0.L$1 = obj3;
                        r0.L$2 = r7;
                        r0.L$3 = obj4;
                        r0.L$4 = r5;
                        r0.L$5 = obj5;
                        r0.L$6 = flowCollector2;
                        r0.label = 2;
                        if (flowCollector.emit(obj2, r0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                r0 = new ContinuationImpl(this, continuation) {
                    /* class kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1 */
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
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
                obj2 = r0.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                }
                r0.L$0 = r9;
                r0.L$1 = obj3;
                r0.L$2 = r7;
                r0.L$3 = obj4;
                r0.L$4 = r5;
                r0.L$5 = obj5;
                r0.L$6 = flowCollector2;
                r0.label = 2;
                if (flowCollector.emit(obj2, r0) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
