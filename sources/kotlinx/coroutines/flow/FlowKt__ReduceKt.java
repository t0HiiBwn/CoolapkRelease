package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001ay\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\f\u001a\u0002H\u000b2H\b\u0004\u0010\r\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000eHHø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001as\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015\"\b\b\u0001\u0010\u0001*\u0002H\u0015*\b\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\r\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a!\u0010\u0018\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a'\u0010\u0019\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00010\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"first", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reduce", "S", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 16}, xs = "kotlinx/coroutines/flow/FlowKt")
/* compiled from: Reduce.kt */
final /* synthetic */ class FlowKt__ReduceKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <S, T extends S> Object reduce(Flow<? extends T> flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, Continuation<? super S> continuation) {
        FlowKt__ReduceKt$reduce$1 flowKt__ReduceKt$reduce$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$reduce$1) {
            flowKt__ReduceKt$reduce$1 = (FlowKt__ReduceKt$reduce$1) continuation;
            if ((flowKt__ReduceKt$reduce$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$reduce$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$reduce$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$reduce$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    flowKt__ReduceKt$reduce$1.L$0 = flow;
                    flowKt__ReduceKt$reduce$1.L$1 = function3;
                    flowKt__ReduceKt$reduce$1.L$2 = objectRef2;
                    flowKt__ReduceKt$reduce$1.L$3 = flow;
                    flowKt__ReduceKt$reduce$1.label = 1;
                    if (flow.collect(new FlowKt__ReduceKt$reduce$$inlined$collect$1(objectRef2, function3), flowKt__ReduceKt$reduce$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ReduceKt$reduce$1.L$3;
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$reduce$1.L$2;
                    Function3 function32 = (Function3) flowKt__ReduceKt$reduce$1.L$1;
                    Flow flow3 = (Flow) flowKt__ReduceKt$reduce$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                    return objectRef.element;
                }
                throw new NoSuchElementException("Empty flow can't be reduced");
            }
        }
        flowKt__ReduceKt$reduce$1 = new FlowKt__ReduceKt$reduce$1(continuation);
        Object obj = flowKt__ReduceKt$reduce$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$reduce$1.label;
        if (i != 0) {
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T, R> Object fold(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        FlowKt__ReduceKt$fold$1 flowKt__ReduceKt$fold$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$fold$1) {
            flowKt__ReduceKt$fold$1 = (FlowKt__ReduceKt$fold$1) continuation;
            if ((flowKt__ReduceKt$fold$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$fold$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$fold$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$fold$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = r;
                    flowKt__ReduceKt$fold$1.L$0 = flow;
                    flowKt__ReduceKt$fold$1.L$1 = r;
                    flowKt__ReduceKt$fold$1.L$2 = function3;
                    flowKt__ReduceKt$fold$1.L$3 = objectRef2;
                    flowKt__ReduceKt$fold$1.L$4 = flow;
                    flowKt__ReduceKt$fold$1.label = 1;
                    if (flow.collect(new FlowKt__ReduceKt$fold$$inlined$collect$1(objectRef2, function3), flowKt__ReduceKt$fold$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ReduceKt$fold$1.L$4;
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$fold$1.L$3;
                    Function3 function32 = (Function3) flowKt__ReduceKt$fold$1.L$2;
                    Object obj2 = flowKt__ReduceKt$fold$1.L$1;
                    Flow flow3 = (Flow) flowKt__ReduceKt$fold$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$fold$1 = new FlowKt__ReduceKt$fold$1(continuation);
        Object obj = flowKt__ReduceKt$fold$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$fold$1.label;
        if (i != 0) {
        }
        return objectRef.element;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static final Object fold$$forInline(Flow flow, Object obj, Function3 function3, Continuation continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = obj;
        InlineMarker.mark(0);
        flow.collect(new FlowKt__ReduceKt$fold$$inlined$collect$1(objectRef, function3), continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return objectRef.element;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object single(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$single$1 flowKt__ReduceKt$single$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$single$1) {
            flowKt__ReduceKt$single$1 = (FlowKt__ReduceKt$single$1) continuation;
            if ((flowKt__ReduceKt$single$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$single$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$single$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$single$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    flowKt__ReduceKt$single$1.L$0 = flow;
                    flowKt__ReduceKt$single$1.L$1 = objectRef2;
                    flowKt__ReduceKt$single$1.L$2 = flow;
                    flowKt__ReduceKt$single$1.label = 1;
                    if (flow.collect(new FlowKt__ReduceKt$single$$inlined$collect$1(objectRef2), flowKt__ReduceKt$single$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ReduceKt$single$1.L$2;
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$single$1.L$1;
                    Flow flow3 = (Flow) flowKt__ReduceKt$single$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                    return objectRef.element;
                }
                throw new NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$single$1 = new FlowKt__ReduceKt$single$1(continuation);
        Object obj = flowKt__ReduceKt$single$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$single$1.label;
        if (i != 0) {
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object singleOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$singleOrNull$1 flowKt__ReduceKt$singleOrNull$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$singleOrNull$1) {
            flowKt__ReduceKt$singleOrNull$1 = (FlowKt__ReduceKt$singleOrNull$1) continuation;
            if ((flowKt__ReduceKt$singleOrNull$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$singleOrNull$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$singleOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$singleOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = null;
                    flowKt__ReduceKt$singleOrNull$1.L$0 = flow;
                    flowKt__ReduceKt$singleOrNull$1.L$1 = objectRef2;
                    flowKt__ReduceKt$singleOrNull$1.L$2 = flow;
                    flowKt__ReduceKt$singleOrNull$1.label = 1;
                    if (flow.collect(new FlowKt__ReduceKt$singleOrNull$$inlined$collect$1(objectRef2), flowKt__ReduceKt$singleOrNull$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ReduceKt$singleOrNull$1.L$2;
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$singleOrNull$1.L$1;
                    Flow flow3 = (Flow) flowKt__ReduceKt$singleOrNull$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$singleOrNull$1 = new FlowKt__ReduceKt$singleOrNull$1(continuation);
        Object obj = flowKt__ReduceKt$singleOrNull$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$singleOrNull$1.label;
        if (i != 0) {
        }
        return objectRef.element;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object first(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$1 flowKt__ReduceKt$first$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$first$1) {
            flowKt__ReduceKt$first$1 = (FlowKt__ReduceKt$first$1) continuation;
            if ((flowKt__ReduceKt$first$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$first$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    try {
                        flowKt__ReduceKt$first$1.L$0 = flow;
                        flowKt__ReduceKt$first$1.L$1 = objectRef2;
                        flowKt__ReduceKt$first$1.L$2 = flow;
                        flowKt__ReduceKt$first$1.label = 1;
                        if (flow.collect(new FlowKt__ReduceKt$first$$inlined$collect$1(objectRef2), flowKt__ReduceKt$first$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (AbortFlowException unused) {
                    }
                    objectRef = objectRef2;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ReduceKt$first$1.L$2;
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$first$1.L$1;
                    Flow flow3 = (Flow) flowKt__ReduceKt$first$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException unused2) {
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                    return objectRef.element;
                }
                throw new NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuation);
        Object obj = flowKt__ReduceKt$first$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$first$1.label;
        if (i != 0) {
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object first(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$3 flowKt__ReduceKt$first$3;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$first$3) {
            flowKt__ReduceKt$first$3 = (FlowKt__ReduceKt$first$3) continuation;
            if ((flowKt__ReduceKt$first$3.label & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$3.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$first$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    try {
                        flowKt__ReduceKt$first$3.L$0 = flow;
                        flowKt__ReduceKt$first$3.L$1 = function2;
                        flowKt__ReduceKt$first$3.L$2 = objectRef2;
                        flowKt__ReduceKt$first$3.L$3 = flow;
                        flowKt__ReduceKt$first$3.label = 1;
                        if (flow.collect(new FlowKt__ReduceKt$first$$inlined$collect$2(function2, objectRef2), flowKt__ReduceKt$first$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (AbortFlowException unused) {
                    }
                    objectRef = objectRef2;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ReduceKt$first$3.L$3;
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$first$3.L$2;
                    function2 = (Function2) flowKt__ReduceKt$first$3.L$1;
                    Flow flow3 = (Flow) flowKt__ReduceKt$first$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException unused2) {
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                    return objectRef.element;
                }
                throw new NoSuchElementException("Expected at least one element matching the predicate " + function2);
            }
        }
        flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuation);
        Object obj = flowKt__ReduceKt$first$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$first$3.label;
        if (i != 0) {
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
        }
    }
}
