package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "getAvailablePermits", "()I", "availablePermits", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;"}, k = 1, mv = {1, 4, 0})
/* compiled from: Semaphore.kt */
final class SemaphoreImpl implements Semaphore {
    static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    private static final AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    volatile int _availablePermits;
    private volatile long deqIdx = 0;
    private volatile long enqIdx = 0;
    private volatile Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    private volatile Object tail;

    public SemaphoreImpl(int i, int i2) {
        this.permits = i;
        boolean z = true;
        if (i > 0) {
            if ((i2 < 0 || i < i2) ? false : z) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0, null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = i - i2;
                this.onCancellationRelease = new SemaphoreImpl$onCancellationRelease$1(this);
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
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
        Object acquireSlowPath = acquireSlowPath(continuation);
        if (acquireSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return acquireSlowPath;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* access modifiers changed from: private */
    public final boolean addAcquireToQueue(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object obj;
        boolean z;
        boolean z2;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) this.tail;
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        long j = andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE);
        do {
            SemaphoreSegment semaphoreSegment2 = semaphoreSegment;
            while (true) {
                if (semaphoreSegment2.getId() >= j && !semaphoreSegment2.getRemoved()) {
                    obj = SegmentOrClosed.m1438constructorimpl(semaphoreSegment2);
                    break;
                }
                Object nextOrClosed = semaphoreSegment2.getNextOrClosed();
                if (nextOrClosed == ConcurrentLinkedListKt.CLOSED) {
                    obj = SegmentOrClosed.m1438constructorimpl(ConcurrentLinkedListKt.CLOSED);
                    break;
                }
                SemaphoreSegment semaphoreSegment3 = (Segment) ((ConcurrentLinkedListNode) nextOrClosed);
                if (semaphoreSegment3 == null) {
                    semaphoreSegment3 = SemaphoreKt.createSegment(semaphoreSegment2.getId() + 1, semaphoreSegment2);
                    if (semaphoreSegment2.trySetNext(semaphoreSegment3)) {
                        if (semaphoreSegment2.getRemoved()) {
                            semaphoreSegment2.remove();
                        }
                    }
                }
                semaphoreSegment2 = semaphoreSegment3;
            }
            z = true;
            if (SegmentOrClosed.m1443isClosedimpl(obj)) {
                break;
            }
            Segment r8 = SegmentOrClosed.m1441getSegmentimpl(obj);
            while (true) {
                Segment segment = (Segment) this.tail;
                if (segment.getId() >= r8.getId()) {
                    break;
                } else if (!r8.tryIncPointers$kotlinx_coroutines_core()) {
                    z2 = false;
                    continue;
                    break;
                } else if (tail$FU.compareAndSet(this, segment, r8)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (r8.decPointers$kotlinx_coroutines_core()) {
                    r8.remove();
                }
            }
            z2 = true;
            continue;
        } while (!z2);
        SemaphoreSegment semaphoreSegment4 = (SemaphoreSegment) SegmentOrClosed.m1441getSegmentimpl(obj);
        int i = (int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE));
        if (semaphoreSegment4.acquirers.compareAndSet(i, null, cancellableContinuation)) {
            cancellableContinuation.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(semaphoreSegment4, i));
            return true;
        }
        if (semaphoreSegment4.acquirers.compareAndSet(i, SemaphoreKt.PERMIT, SemaphoreKt.TAKEN)) {
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m85constructorimpl(unit));
            return true;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (semaphoreSegment4.acquirers.get(i) != SemaphoreKt.BROKEN) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0075, code lost:
        continue;
     */
    private final boolean tryResumeNextFromQueue() {
        Object obj;
        int i;
        boolean z;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) this.head;
        long andIncrement = deqIdx$FU.getAndIncrement(this);
        long j = andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE);
        do {
            SemaphoreSegment semaphoreSegment2 = semaphoreSegment;
            while (true) {
                if (semaphoreSegment2.getId() >= j && !semaphoreSegment2.getRemoved()) {
                    obj = SegmentOrClosed.m1438constructorimpl(semaphoreSegment2);
                    break;
                }
                Object nextOrClosed = semaphoreSegment2.getNextOrClosed();
                if (nextOrClosed == ConcurrentLinkedListKt.CLOSED) {
                    obj = SegmentOrClosed.m1438constructorimpl(ConcurrentLinkedListKt.CLOSED);
                    break;
                }
                SemaphoreSegment semaphoreSegment3 = (Segment) ((ConcurrentLinkedListNode) nextOrClosed);
                if (semaphoreSegment3 == null) {
                    semaphoreSegment3 = SemaphoreKt.createSegment(semaphoreSegment2.getId() + 1, semaphoreSegment2);
                    if (semaphoreSegment2.trySetNext(semaphoreSegment3)) {
                        if (semaphoreSegment2.getRemoved()) {
                            semaphoreSegment2.remove();
                        }
                    }
                }
                semaphoreSegment2 = semaphoreSegment3;
            }
            if (SegmentOrClosed.m1443isClosedimpl(obj)) {
                break;
            }
            Segment r6 = SegmentOrClosed.m1441getSegmentimpl(obj);
            while (true) {
                Segment segment = (Segment) this.head;
                if (segment.getId() >= r6.getId()) {
                    break;
                } else if (!r6.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    continue;
                    break;
                } else if (head$FU.compareAndSet(this, segment, r6)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (r6.decPointers$kotlinx_coroutines_core()) {
                    r6.remove();
                }
            }
        } while (!z);
        SemaphoreSegment semaphoreSegment4 = (SemaphoreSegment) SegmentOrClosed.m1441getSegmentimpl(obj);
        semaphoreSegment4.cleanPrev();
        if (semaphoreSegment4.getId() > j) {
            return false;
        }
        int i2 = (int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE));
        Object andSet = semaphoreSegment4.acquirers.getAndSet(i2, SemaphoreKt.PERMIT);
        if (andSet == null) {
            int i3 = SemaphoreKt.MAX_SPIN_CYCLES;
            for (i = 0; i < i3; i++) {
                if (semaphoreSegment4.acquirers.get(i2) == SemaphoreKt.TAKEN) {
                    return true;
                }
            }
            return !semaphoreSegment4.acquirers.compareAndSet(i2, SemaphoreKt.PERMIT, SemaphoreKt.BROKEN);
        } else if (andSet == SemaphoreKt.CANCELLED) {
            return false;
        } else {
            return tryResumeAcquire((CancellableContinuation) andSet);
        }
    }

    private final boolean tryResumeAcquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
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

    final /* synthetic */ Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        while (true) {
            if (!addAcquireToQueue(cancellableContinuationImpl)) {
                if (_availablePermits$FU.getAndDecrement(this) > 0) {
                    Unit unit = Unit.INSTANCE;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m85constructorimpl(unit));
                    break;
                }
            } else {
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        while (true) {
            int i = this._availablePermits;
            if (i < this.permits) {
                if (_availablePermits$FU.compareAndSet(this, i, i + 1) && (i >= 0 || tryResumeNextFromQueue())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
        }
    }
}
