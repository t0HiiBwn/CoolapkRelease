package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010052\b\u0012\u0004\u0012\u00028\u0000062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u000008B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010\u000fR\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000*8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b3\u0010$\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 4, 0})
/* compiled from: StateFlow.kt */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private volatile Object _state;
    private int sequence;

    public static /* synthetic */ void getValue$annotations() {
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        if (t2 == null) {
            t2 = (T) NullSurrogateKt.NULL;
        }
        return updateState(t, t2);
    }

    private final boolean updateState(Object obj, Object obj2) {
        int i;
        StateFlowSlot[] stateFlowSlotArr;
        int i2;
        StateFlowSlot[] stateFlowSlotArr2;
        StateFlowSlot[] stateFlowSlotArr3 = (StateFlowSlot[]) getSlots();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && (!Intrinsics.areEqual(obj3, obj))) {
                return false;
            }
            if (Intrinsics.areEqual(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i3 = this.sequence;
            if ((i3 & 1) == 0) {
                i = i3 + 1;
                this.sequence = i;
                stateFlowSlotArr = (StateFlowSlot[]) getSlots();
                Unit unit = Unit.INSTANCE;
            } else {
                this.sequence = i3 + 2;
                return true;
            }
        }
        while (true) {
            if (stateFlowSlotArr != null) {
                for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                    if (stateFlowSlot != null) {
                        stateFlowSlot.makePending();
                    }
                }
            }
            synchronized (this) {
                i2 = this.sequence;
                if (i2 == i) {
                    this.sequence = i + 1;
                    return true;
                }
                stateFlowSlotArr2 = (StateFlowSlot[]) getSlots();
                Unit unit2 = Unit.INSTANCE;
            }
            stateFlowSlotArr = stateFlowSlotArr2;
            i = i2;
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r12, r13)) != false) goto L_0x00bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        Object coroutine_suspended;
        int i;
        Throwable th;
        StateFlowImpl<T> stateFlowImpl;
        StateFlowSlot stateFlowSlot;
        Object obj;
        Object obj2;
        FlowCollector<? super T> flowCollector2;
        Job job;
        FlowCollector<? super T> flowCollector3;
        FlowCollector flowCollector4;
        Object obj3;
        if (continuation instanceof StateFlowImpl$collect$1) {
            stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
            if ((stateFlowImpl$collect$1.label & Integer.MIN_VALUE) != 0) {
                stateFlowImpl$collect$1.label -= Integer.MIN_VALUE;
                Object obj4 = stateFlowImpl$collect$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = stateFlowImpl$collect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    stateFlowSlot = (StateFlowSlot) allocateSlot();
                    try {
                        if (flowCollector instanceof SubscribedFlowCollector) {
                            stateFlowImpl$collect$1.L$0 = this;
                            stateFlowImpl$collect$1.L$1 = flowCollector;
                            stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                            stateFlowImpl$collect$1.label = 1;
                            if (((SubscribedFlowCollector) flowCollector).onSubscription(stateFlowImpl$collect$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        stateFlowImpl = this;
                    } catch (Throwable th2) {
                        th = th2;
                        stateFlowImpl = this;
                        stateFlowImpl.freeSlot(stateFlowSlot);
                        throw th;
                    }
                } else if (i == 1) {
                    stateFlowSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                    flowCollector = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                } else if (i == 2) {
                    obj2 = stateFlowImpl$collect$1.L$5;
                    Object obj5 = stateFlowImpl$collect$1.L$4;
                    job = (Job) stateFlowImpl$collect$1.L$3;
                    stateFlowSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    flowCollector3 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    obj = obj2;
                    flowCollector2 = flowCollector3;
                    flowCollector4 = flowCollector2;
                    if (!stateFlowSlot.takePending()) {
                    }
                    obj = stateFlowImpl._state;
                    if (job != null) {
                    }
                    if (obj2 != null) {
                    }
                    if (obj == NullSurrogateKt.NULL) {
                    }
                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                    stateFlowImpl$collect$1.L$1 = flowCollector4;
                    stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                    stateFlowImpl$collect$1.L$3 = job;
                    stateFlowImpl$collect$1.L$4 = obj2;
                    stateFlowImpl$collect$1.L$5 = obj;
                    stateFlowImpl$collect$1.label = 2;
                    if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 3) {
                    Object obj6 = stateFlowImpl$collect$1.L$5;
                    obj2 = stateFlowImpl$collect$1.L$4;
                    job = (Job) stateFlowImpl$collect$1.L$3;
                    stateFlowSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                    FlowCollector flowCollector5 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj4);
                        flowCollector4 = flowCollector5;
                        obj = stateFlowImpl._state;
                        if (job != null) {
                            JobKt.ensureActive(job);
                        }
                        if (obj2 != null) {
                            flowCollector2 = flowCollector4;
                        }
                        obj3 = obj == NullSurrogateKt.NULL ? null : obj;
                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                        stateFlowImpl$collect$1.L$1 = flowCollector4;
                        stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                        stateFlowImpl$collect$1.L$3 = job;
                        stateFlowImpl$collect$1.L$4 = obj2;
                        stateFlowImpl$collect$1.L$5 = obj;
                        stateFlowImpl$collect$1.label = 2;
                        if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) != coroutine_suspended) {
                            obj2 = obj;
                            flowCollector3 = flowCollector4;
                            obj = obj2;
                            flowCollector2 = flowCollector3;
                            flowCollector4 = flowCollector2;
                            if (!stateFlowSlot.takePending()) {
                                stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                stateFlowImpl$collect$1.L$1 = flowCollector2;
                                stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                                stateFlowImpl$collect$1.L$3 = job;
                                stateFlowImpl$collect$1.L$4 = obj2;
                                stateFlowImpl$collect$1.L$5 = obj;
                                stateFlowImpl$collect$1.label = 3;
                                flowCollector4 = flowCollector2;
                                if (stateFlowSlot.awaitPending(stateFlowImpl$collect$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            obj = stateFlowImpl._state;
                            if (job != null) {
                            }
                            if (obj2 != null) {
                            }
                            if (obj == NullSurrogateKt.NULL) {
                            }
                            stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                            stateFlowImpl$collect$1.L$1 = flowCollector4;
                            stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                            stateFlowImpl$collect$1.L$3 = job;
                            stateFlowImpl$collect$1.L$4 = obj2;
                            stateFlowImpl$collect$1.L$5 = obj;
                            stateFlowImpl$collect$1.label = 2;
                            if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector4 = flowCollector;
                job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
                obj2 = null;
                obj = stateFlowImpl._state;
                if (job != null) {
                }
                if (obj2 != null) {
                }
                if (obj == NullSurrogateKt.NULL) {
                }
                stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                stateFlowImpl$collect$1.L$1 = flowCollector4;
                stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                stateFlowImpl$collect$1.L$3 = job;
                stateFlowImpl$collect$1.L$4 = obj2;
                stateFlowImpl$collect$1.L$5 = obj;
                stateFlowImpl$collect$1.label = 2;
                if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        Object obj4 = stateFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = stateFlowImpl$collect$1.label;
        if (i != 0) {
        }
        flowCollector4 = flowCollector;
        job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
        obj2 = null;
        obj = stateFlowImpl._state;
        if (job != null) {
        }
        if (obj2 != null) {
        }
        if (obj == NullSurrogateKt.NULL) {
        }
        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
        stateFlowImpl$collect$1.L$1 = flowCollector4;
        stateFlowImpl$collect$1.L$2 = stateFlowSlot;
        stateFlowImpl$collect$1.L$3 = job;
        stateFlowImpl$collect$1.L$4 = obj2;
        stateFlowImpl$collect$1.L$5 = obj;
        stateFlowImpl$collect$1.label = 2;
        if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int i) {
        return new StateFlowSlot[i];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }
}
