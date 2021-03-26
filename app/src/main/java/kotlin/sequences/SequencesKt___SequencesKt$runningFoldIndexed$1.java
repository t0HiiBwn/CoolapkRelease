package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2109, 2114}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* compiled from: _Sequences.kt */
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function3 $operation;
    final /* synthetic */ Sequence $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFoldIndexed$1(Sequence sequence, Object obj, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_runningFoldIndexed = sequence;
        this.$initial = obj;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$this_runningFoldIndexed, this.$initial, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        SequenceScope sequenceScope;
        Iterator it2;
        Object obj2;
        SequenceScope sequenceScope2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope2 = (SequenceScope) this.L$0;
            Object obj3 = this.$initial;
            this.L$0 = sequenceScope2;
            this.label = 1;
            if (sequenceScope2.yield(obj3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            int i3 = this.I$0;
            it2 = (Iterator) this.L$2;
            Object obj4 = this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            obj2 = obj4;
            while (it2.hasNext()) {
                Object next = it2.next();
                Function3 function3 = this.$operation;
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object invoke = function3.invoke(Boxing.boxInt(i), obj2, next);
                this.L$0 = sequenceScope;
                this.L$1 = invoke;
                this.L$2 = it2;
                this.I$0 = i4;
                this.label = 2;
                if (sequenceScope.yield(invoke, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = invoke;
                i = i4;
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = 0;
        sequenceScope = sequenceScope2;
        obj2 = this.$initial;
        it2 = this.$this_runningFoldIndexed.iterator();
        while (it2.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
