package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {181, 183, 185, 186, 188}, m = "invokeSuspend", n = {"$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
/* compiled from: SharingStarted.kt */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;
    private FlowCollector p$;
    private int p$0;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    public final Continuation<Unit> create(FlowCollector<? super SharingCommand> flowCollector, int i, Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.p$ = flowCollector;
        startedWhileSubscribed$command$1.p$0 = i;
        return startedWhileSubscribed$command$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        return ((StartedWhileSubscribed$command$1) create(flowCollector, num.intValue(), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        int i;
        SharingCommand sharingCommand;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    i = this.I$0;
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i2 == 3) {
                    i = this.I$0;
                    flowCollector3 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j = this.this$0.replayExpiration;
                    this.L$0 = flowCollector3;
                    this.I$0 = i;
                    this.label = 4;
                    if (DelayKt.delay(j, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowCollector2 = flowCollector3;
                    flowCollector = flowCollector2;
                    sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = flowCollector;
                    this.I$0 = i;
                    this.label = 5;
                    if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                } else if (i2 == 4) {
                    i = this.I$0;
                    flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector2;
                    sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = flowCollector;
                    this.I$0 = i;
                    this.label = 5;
                    if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                } else if (i2 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            FlowCollector flowCollector4 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector flowCollector5 = this.p$;
        i = this.p$0;
        if (i > 0) {
            SharingCommand sharingCommand2 = SharingCommand.START;
            this.L$0 = flowCollector5;
            this.I$0 = i;
            this.label = 1;
            if (flowCollector5.emit(sharingCommand2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        long j2 = this.this$0.stopTimeout;
        this.L$0 = flowCollector5;
        this.I$0 = i;
        this.label = 2;
        if (DelayKt.delay(j2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        flowCollector = flowCollector5;
        if (this.this$0.replayExpiration > 0) {
            SharingCommand sharingCommand3 = SharingCommand.STOP;
            this.L$0 = flowCollector;
            this.I$0 = i;
            this.label = 3;
            if (flowCollector.emit(sharingCommand3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector3 = flowCollector;
            j = this.this$0.replayExpiration;
            this.L$0 = flowCollector3;
            this.I$0 = i;
            this.label = 4;
            if (DelayKt.delay(j, this) != coroutine_suspended) {
            }
        }
        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
        this.L$0 = flowCollector;
        this.I$0 = i;
        this.label = 5;
        if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
