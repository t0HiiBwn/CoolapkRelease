package kotlinx.coroutines;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {949, 951}, m = "invokeSuspend", n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", "it"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: JobSupport.kt */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    private SequenceScope p$;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, Continuation continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.p$ = (SequenceScope) obj;
        return jobSupport$children$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super ChildJob> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JobSupport$children$1 jobSupport$children$1;
        SequenceScope sequenceScope;
        Object obj2;
        NodeList nodeList;
        LockFreeLinkedListHead lockFreeLinkedListHead;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        NodeList list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = this.p$;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                ChildJob childJob = ((ChildHandleNode) state$kotlinx_coroutines_core).childJob;
                this.L$0 = sequenceScope2;
                this.L$1 = state$kotlinx_coroutines_core;
                this.label = 1;
                if (sequenceScope2.yield(childJob, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                NodeList nodeList2 = list;
                Object next = nodeList2.getNext();
                Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) next;
                sequenceScope = sequenceScope2;
                jobSupport$children$1 = this;
                obj2 = state$kotlinx_coroutines_core;
                lockFreeLinkedListNode = lockFreeLinkedListNode2;
                nodeList = list;
                lockFreeLinkedListHead = nodeList2;
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            SequenceScope sequenceScope3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else if (i == 2) {
            ChildHandleNode childHandleNode = (ChildHandleNode) this.L$5;
            lockFreeLinkedListNode = (LockFreeLinkedListNode) this.L$4;
            lockFreeLinkedListHead = (LockFreeLinkedListHead) this.L$3;
            nodeList = (NodeList) this.L$2;
            obj2 = this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            jobSupport$children$1 = this;
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
            if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                ChildHandleNode childHandleNode2 = (ChildHandleNode) lockFreeLinkedListNode;
                ChildJob childJob2 = childHandleNode2.childJob;
                jobSupport$children$1.L$0 = sequenceScope;
                jobSupport$children$1.L$1 = obj2;
                jobSupport$children$1.L$2 = nodeList;
                jobSupport$children$1.L$3 = lockFreeLinkedListHead;
                jobSupport$children$1.L$4 = lockFreeLinkedListNode;
                jobSupport$children$1.L$5 = childHandleNode2;
                jobSupport$children$1.label = 2;
                if (sequenceScope.yield(childJob2, jobSupport$children$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
            }
        }
        return Unit.INSTANCE;
    }
}
