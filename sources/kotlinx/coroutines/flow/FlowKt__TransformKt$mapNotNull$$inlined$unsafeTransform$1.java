package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$6"}, k = 1, mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1 implements Flow<R> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ Function2 $transform$inlined$1;

    public FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(Flow flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = flow;
        this.$transform$inlined$1 = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector<T>() {
            /* class kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0095  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                AnonymousClass1 r0;
                Object obj2;
                int i;
                FlowCollector flowCollector;
                AnonymousClass2 r8;
                Object obj3;
                AnonymousClass1 r6;
                Object obj4;
                Continuation continuation2;
                Object obj5;
                if (continuation instanceof AnonymousClass1) {
                    r0 = (AnonymousClass1) continuation;
                    if ((r0.label & Integer.MIN_VALUE) != 0) {
                        r0.label -= Integer.MIN_VALUE;
                        obj2 = r0.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = r0.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = r3;
                            AnonymousClass1 r2 = r0;
                            Function2 function2 = this.$transform$inlined$1;
                            r0.L$0 = this;
                            r0.L$1 = obj;
                            r0.L$2 = r0;
                            r0.L$3 = obj;
                            r0.L$4 = r2;
                            r0.L$5 = obj;
                            r0.L$6 = flowCollector2;
                            r0.label = 1;
                            Object invoke = function2.invoke(obj, r0);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r8 = this;
                            obj4 = obj;
                            obj3 = obj4;
                            r6 = r0;
                            flowCollector = flowCollector2;
                            obj2 = invoke;
                            continuation2 = r2;
                            obj5 = obj3;
                        } else if (i == 1) {
                            flowCollector = (FlowCollector) r0.L$6;
                            obj5 = r0.L$5;
                            continuation2 = (Continuation) r0.L$4;
                            obj4 = r0.L$3;
                            r6 = (AnonymousClass1) r0.L$2;
                            obj3 = r0.L$1;
                            r8 = (AnonymousClass2) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                        } else if (i == 2) {
                            Object obj6 = r0.L$7;
                            FlowCollector flowCollector3 = (FlowCollector) r0.L$6;
                            Object obj7 = r0.L$5;
                            Continuation continuation3 = (Continuation) r0.L$4;
                            Object obj8 = r0.L$3;
                            AnonymousClass1 r10 = (AnonymousClass1) r0.L$2;
                            Object obj9 = r0.L$1;
                            AnonymousClass2 r102 = (AnonymousClass2) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        if (obj2 != null) {
                            return Unit.INSTANCE;
                        }
                        r0.L$0 = r8;
                        r0.L$1 = obj3;
                        r0.L$2 = r6;
                        r0.L$3 = obj4;
                        r0.L$4 = continuation2;
                        r0.L$5 = obj5;
                        r0.L$6 = flowCollector;
                        r0.L$7 = obj2;
                        r0.label = 2;
                        if (flowCollector.emit(obj2, r0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                r0 = new ContinuationImpl(this, continuation) {
                    /* class kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1 */
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
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                }
                if (obj2 != null) {
                }
            }

            public Object emit$$forInline(Object obj, Continuation continuation) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {
                    /* class kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1 */
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
                InlineMarker.mark(5);
                FlowCollector flowCollector = r3;
                Object invoke = this.$transform$inlined$1.invoke(obj, continuation);
                if (invoke == null) {
                    return Unit.INSTANCE;
                }
                InlineMarker.mark(0);
                Object emit = flowCollector.emit(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                return emit;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public Object collect$$forInline(final FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.AnonymousClass1 */
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect(null, this);
            }
        };
        InlineMarker.mark(5);
        InlineMarker.mark(0);
        this.$this_unsafeTransform$inlined.collect(new FlowCollector<T>() {
            /* class kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0095  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                AnonymousClass1 r0;
                Object obj2;
                int i;
                FlowCollector flowCollector;
                AnonymousClass2 r8;
                Object obj3;
                AnonymousClass1 r6;
                Object obj4;
                Continuation continuation2;
                Object obj5;
                if (continuation instanceof AnonymousClass1) {
                    r0 = (AnonymousClass1) continuation;
                    if ((r0.label & Integer.MIN_VALUE) != 0) {
                        r0.label -= Integer.MIN_VALUE;
                        obj2 = r0.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = r0.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = flowCollector;
                            AnonymousClass1 r2 = r0;
                            Function2 function2 = this.$transform$inlined$1;
                            r0.L$0 = this;
                            r0.L$1 = obj;
                            r0.L$2 = r0;
                            r0.L$3 = obj;
                            r0.L$4 = r2;
                            r0.L$5 = obj;
                            r0.L$6 = flowCollector2;
                            r0.label = 1;
                            Object invoke = function2.invoke(obj, r0);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r8 = this;
                            obj4 = obj;
                            obj3 = obj4;
                            r6 = r0;
                            flowCollector = flowCollector2;
                            obj2 = invoke;
                            continuation2 = r2;
                            obj5 = obj3;
                        } else if (i == 1) {
                            flowCollector = (FlowCollector) r0.L$6;
                            obj5 = r0.L$5;
                            continuation2 = (Continuation) r0.L$4;
                            obj4 = r0.L$3;
                            r6 = (AnonymousClass1) r0.L$2;
                            obj3 = r0.L$1;
                            r8 = (AnonymousClass2) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                        } else if (i == 2) {
                            Object obj6 = r0.L$7;
                            FlowCollector flowCollector3 = (FlowCollector) r0.L$6;
                            Object obj7 = r0.L$5;
                            Continuation continuation3 = (Continuation) r0.L$4;
                            Object obj8 = r0.L$3;
                            AnonymousClass1 r10 = (AnonymousClass1) r0.L$2;
                            Object obj9 = r0.L$1;
                            AnonymousClass2 r102 = (AnonymousClass2) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        if (obj2 != null) {
                            return Unit.INSTANCE;
                        }
                        r0.L$0 = r8;
                        r0.L$1 = obj3;
                        r0.L$2 = r6;
                        r0.L$3 = obj4;
                        r0.L$4 = continuation2;
                        r0.L$5 = obj5;
                        r0.L$6 = flowCollector;
                        r0.L$7 = obj2;
                        r0.label = 2;
                        if (flowCollector.emit(obj2, r0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                r0 = new ContinuationImpl(this, continuation) {
                    /* class kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1 */
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
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                }
                if (obj2 != null) {
                }
            }

            public Object emit$$forInline(Object obj, Continuation continuation) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {
                    /* class kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1 */
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
                InlineMarker.mark(5);
                FlowCollector flowCollector = flowCollector;
                Object invoke = this.$transform$inlined$1.invoke(obj, continuation);
                if (invoke == null) {
                    return Unit.INSTANCE;
                }
                InlineMarker.mark(0);
                Object emit = flowCollector.emit(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                return emit;
            }
        }, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
