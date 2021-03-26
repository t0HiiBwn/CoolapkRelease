package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.internal.SegmentQueue;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u001d2\b\u0012\u0004\u0012\u00020\u000e0\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToQueueAndSuspend", "incPermits", "()I", "", "id", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "prev", "newSegment", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", "release", "()V", "resumeNextFromQueue$kotlinx_coroutines_core", "resumeNextFromQueue", "", "tryAcquire", "()Z", "getAvailablePermits", "availablePermits", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;", "Lkotlinx/coroutines/internal/SegmentQueue;"}, k = 1, mv = {1, 1, 16})
/* compiled from: Semaphore.kt */
final class SemaphoreImpl extends SegmentQueue<SemaphoreSegment> implements Semaphore {
    private static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    private volatile int _availablePermits;
    private volatile long deqIdx;
    volatile long enqIdx;
    private final int permits;

    public static final /* synthetic */ SemaphoreSegment access$getSegment(SemaphoreImpl semaphoreImpl, SemaphoreSegment semaphoreSegment, long j) {
        return (SemaphoreSegment) semaphoreImpl.getSegment(semaphoreSegment, j);
    }

    public static final /* synthetic */ SemaphoreSegment access$getTail$p(SemaphoreImpl semaphoreImpl) {
        return (SemaphoreSegment) semaphoreImpl.getTail();
    }

    public SemaphoreImpl(int i, int i2) {
        this.permits = i;
        boolean z = true;
        if (i > 0) {
            if ((i2 < 0 || i < i2) ? false : z) {
                this._availablePermits = i - i2;
                this.enqIdx = 0;
                this.deqIdx = 0;
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
    }

    public SemaphoreSegment newSegment(long j, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j, semaphoreSegment);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> continuation) {
        if (_availablePermits$FU.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        Object addToQueueAndSuspend = addToQueueAndSuspend(continuation);
        if (addToQueueAndSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return addToQueueAndSuspend;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        if (incPermits() < 0) {
            resumeNextFromQueue$kotlinx_coroutines_core();
        }
    }

    public final void resumeNextFromQueue$kotlinx_coroutines_core() {
        while (true) {
            long andIncrement = deqIdx$FU.getAndIncrement(this);
            SemaphoreSegment semaphoreSegment = (SemaphoreSegment) getSegmentAndMoveHead((SemaphoreSegment) getHead(), andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE));
            if (semaphoreSegment != null) {
                Object andSet = semaphoreSegment.acquirers.getAndSet((int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE)), SemaphoreKt.RESUMED);
                if (andSet != null) {
                    if (andSet != SemaphoreKt.CANCELLED) {
                        Unit unit = Unit.INSTANCE;
                        Result.Companion companion = Result.Companion;
                        ((CancellableContinuation) andSet).resumeWith(Result.m687constructorimpl(unit));
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!_availablePermits$FU.compareAndSet(this, i, i - 1));
        return true;
    }

    public final int incPermits() {
        int i;
        do {
            i = this._availablePermits;
            if (!(i < this.permits)) {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
        } while (!_availablePermits$FU.compareAndSet(this, i, i + 1));
        return i;
    }

    final /* synthetic */ Object addToQueueAndSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        SemaphoreSegment access$getTail$p = access$getTail$p(this);
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        SemaphoreSegment access$getSegment = access$getSegment(this, access$getTail$p, andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE));
        int i = (int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE));
        if (access$getSegment == null || access$getSegment.acquirers.get(i) == SemaphoreKt.RESUMED || !access$getSegment.acquirers.compareAndSet(i, null, cancellableContinuationImpl)) {
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m687constructorimpl(unit));
        } else {
            cancellableContinuationImpl.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(this, access$getSegment, i));
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
