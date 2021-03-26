package rx.internal.util.unsafe;

import java.util.Objects;

public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i) {
        super(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: rx.internal.util.unsafe.SpscArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        Object[] objArr = this.buffer;
        long j = this.producerIndex;
        long calcElementOffset = calcElementOffset(j);
        if (lvElement(objArr, calcElementOffset) != null) {
            return false;
        }
        soElement(objArr, calcElementOffset, e);
        soProducerIndex(j + 1);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: rx.internal.util.unsafe.SpscArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long j = this.consumerIndex;
        long calcElementOffset = calcElementOffset(j);
        Object[] objArr = this.buffer;
        E e = (E) lvElement(objArr, calcElementOffset);
        if (e == null) {
            return null;
        }
        soElement(objArr, calcElementOffset, null);
        soConsumerIndex(j + 1);
        return e;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
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

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    private void soProducerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j);
    }

    private void soConsumerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }
}
