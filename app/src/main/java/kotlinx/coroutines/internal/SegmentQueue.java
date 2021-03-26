package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\b \u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00028\u00008D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00028\u00008D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/internal/Segment;", "S", "<init>", "()V", "startFrom", "", "id", "getSegment", "(Lkotlinx/coroutines/internal/Segment;J)Lkotlinx/coroutines/internal/Segment;", "getSegmentAndMoveHead", "new", "", "moveHeadForward", "(Lkotlinx/coroutines/internal/Segment;)V", "moveTailForward", "prev", "newSegment", "(JLkotlinx/coroutines/internal/Segment;)Lkotlinx/coroutines/internal/Segment;", "getHead", "()Lkotlinx/coroutines/internal/Segment;", "head", "getTail", "tail", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 1, 16})
/* compiled from: SegmentQueue.kt */
public abstract class SegmentQueue<S extends Segment<S>> {
    private static final AtomicReferenceFieldUpdater _head$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_head");
    private static final AtomicReferenceFieldUpdater _tail$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_tail");
    private volatile Object _head;
    private volatile Object _tail;

    public abstract S newSegment(long j, S s);

    public SegmentQueue() {
        Segment newSegment$default = newSegment$default(this, 0, null, 2, null);
        this._head = newSegment$default;
        this._tail = newSegment$default;
    }

    protected final S getHead() {
        return (S) ((Segment) this._head);
    }

    protected final S getTail() {
        return (S) ((Segment) this._tail);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.internal.SegmentQueue */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Segment newSegment$default(SegmentQueue segmentQueue, long j, Segment segment, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                segment = null;
            }
            return segmentQueue.newSegment(j, segment);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newSegment");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlinx.coroutines.internal.SegmentQueue<S extends kotlinx.coroutines.internal.Segment<S>> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: S extends kotlinx.coroutines.internal.Segment<S> */
    /* JADX WARN: Multi-variable type inference failed */
    protected final S getSegment(S s, long j) {
        while (s.getId() < j) {
            Object next = s.getNext();
            if (next == null) {
                next = newSegment(s.getId() + 1, s);
                if (s.casNext(null, next)) {
                    if (s.getRemoved()) {
                        s.remove();
                    }
                    moveTailForward(next);
                } else {
                    next = s.getNext();
                    if (next == null) {
                        Intrinsics.throwNpe();
                    }
                }
            }
            s = (S) next;
        }
        if (s.getId() != j) {
            return null;
        }
        return s;
    }

    protected final S getSegmentAndMoveHead(S s, long j) {
        if (s.getId() == j) {
            return s;
        }
        S segment = getSegment(s, j);
        if (segment == null) {
            return null;
        }
        moveHeadForward(segment);
        return segment;
    }

    private final void moveHeadForward(S s) {
        Segment segment;
        do {
            segment = (Segment) this._head;
            if (segment.getId() > s.getId()) {
                return;
            }
        } while (!_head$FU.compareAndSet(this, segment, s));
        s.prev = null;
    }

    private final void moveTailForward(S s) {
        Segment segment;
        do {
            segment = (Segment) this._tail;
            if (segment.getId() > s.getId()) {
                return;
            }
        } while (!_tail$FU.compareAndSet(this, segment, s));
    }
}
