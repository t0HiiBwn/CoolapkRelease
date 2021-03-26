package rx.internal.util.unsafe;

import java.util.Iterator;
import java.util.Objects;

public class SpscUnboundedArrayQueue<E> extends SpscUnboundedArrayQueueConsumerField<E> implements QueueProgressIndicators {
    private static final long C_INDEX_OFFSET;
    private static final Object HAS_NEXT = new Object();
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final long P_INDEX_OFFSET;
    private static final long REF_ARRAY_BASE = ((long) UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class));
    private static final int REF_ELEMENT_SHIFT;

    static {
        int arrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        try {
            P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(SpscUnboundedArrayQueueProducerFields.class.getDeclaredField("producerIndex"));
            try {
                C_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(SpscUnboundedArrayQueueConsumerField.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e) {
                InternalError internalError = new InternalError();
                internalError.initCause(e);
                throw internalError;
            }
        } catch (NoSuchFieldException e2) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e2);
            throw internalError2;
        }
    }

    public SpscUnboundedArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        long j = (long) (roundToPowerOfTwo - 1);
        Object[] objArr = new Object[(roundToPowerOfTwo + 1)];
        this.producerBuffer = objArr;
        this.producerMask = j;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = objArr;
        this.consumerMask = j;
        this.producerLookAhead = j - 1;
        soProducerIndex(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public final boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        Object[] objArr = this.producerBuffer;
        long j = this.producerIndex;
        long j2 = this.producerMask;
        long calcWrappedOffset = calcWrappedOffset(j, j2);
        if (j < this.producerLookAhead) {
            return writeToQueue(objArr, e, j, calcWrappedOffset);
        }
        long j3 = ((long) this.producerLookAheadStep) + j;
        if (lvElement(objArr, calcWrappedOffset(j3, j2)) == null) {
            this.producerLookAhead = j3 - 1;
            return writeToQueue(objArr, e, j, calcWrappedOffset);
        } else if (lvElement(objArr, calcWrappedOffset(1 + j, j2)) != null) {
            return writeToQueue(objArr, e, j, calcWrappedOffset);
        } else {
            resize(objArr, j, calcWrappedOffset, e, j2);
            return true;
        }
    }

    private boolean writeToQueue(E[] eArr, E e, long j, long j2) {
        soElement(eArr, j2, e);
        soProducerIndex(j + 1);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void resize(E[] eArr, long j, long j2, E e, long j3) {
        Object[] objArr = new Object[eArr.length];
        this.producerBuffer = objArr;
        this.producerLookAhead = (j3 + j) - 1;
        soElement(objArr, j2, e);
        soNext(eArr, objArr);
        soElement(eArr, j2, HAS_NEXT);
        soProducerIndex(j + 1);
    }

    private void soNext(E[] eArr, E[] eArr2) {
        soElement(eArr, calcDirectOffset((long) (eArr.length - 1)), eArr2);
    }

    private E[] lvNext(E[] eArr) {
        return (E[]) ((Object[]) lvElement(eArr, calcDirectOffset((long) (eArr.length - 1))));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public final E poll() {
        Object[] objArr = this.consumerBuffer;
        long j = this.consumerIndex;
        long j2 = this.consumerMask;
        long calcWrappedOffset = calcWrappedOffset(j, j2);
        E e = (E) lvElement(objArr, calcWrappedOffset);
        boolean z = e == HAS_NEXT;
        if (e != null && !z) {
            soElement(objArr, calcWrappedOffset, null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return (E) newBufferPoll(lvNext(objArr), j, j2);
        } else {
            return null;
        }
    }

    private E newBufferPoll(E[] eArr, long j, long j2) {
        this.consumerBuffer = eArr;
        long calcWrappedOffset = calcWrappedOffset(j, j2);
        E e = (E) lvElement(eArr, calcWrappedOffset);
        if (e == null) {
            return null;
        }
        soElement(eArr, calcWrappedOffset, null);
        soConsumerIndex(j + 1);
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: rx.internal.util.unsafe.SpscUnboundedArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public final E peek() {
        Object[] objArr = this.consumerBuffer;
        long j = this.consumerIndex;
        long j2 = this.consumerMask;
        E e = (E) lvElement(objArr, calcWrappedOffset(j, j2));
        return e == HAS_NEXT ? (E) newBufferPeek(lvNext(objArr), j, j2) : e;
    }

    private E newBufferPeek(E[] eArr, long j, long j2) {
        this.consumerBuffer = eArr;
        return (E) lvElement(eArr, calcWrappedOffset(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    private void adjustLookAheadStep(int i) {
        this.producerLookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    private void soProducerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j);
    }

    private void soConsumerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }

    private static long calcWrappedOffset(long j, long j2) {
        return calcDirectOffset(j & j2);
    }

    private static long calcDirectOffset(long j) {
        return REF_ARRAY_BASE + (j << REF_ELEMENT_SHIFT);
    }

    private static void soElement(Object[] objArr, long j, Object obj) {
        UnsafeAccess.UNSAFE.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object lvElement(E[] eArr, long j) {
        return UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j);
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }
}
