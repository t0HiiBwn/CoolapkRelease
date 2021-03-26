package rx.internal.util.unsafe;

import java.util.Objects;

public final class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
    public SpmcArrayQueue(int i) {
        super(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: rx.internal.util.unsafe.SpmcArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        Object[] objArr = this.buffer;
        long j = this.mask;
        long lvProducerIndex = lvProducerIndex();
        long calcElementOffset = calcElementOffset(lvProducerIndex);
        if (lvElement(objArr, calcElementOffset) != null) {
            if (lvProducerIndex - lvConsumerIndex() > j) {
                return false;
            }
            do {
            } while (lvElement(objArr, calcElementOffset) != null);
        }
        spElement(objArr, calcElementOffset, e);
        soTail(lvProducerIndex + 1);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: rx.internal.util.unsafe.SpmcArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long lvConsumerIndex;
        long lvProducerIndexCache = lvProducerIndexCache();
        do {
            lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex >= lvProducerIndexCache) {
                long lvProducerIndex = lvProducerIndex();
                if (lvConsumerIndex >= lvProducerIndex) {
                    return null;
                }
                svProducerIndexCache(lvProducerIndex);
            }
        } while (!casHead(lvConsumerIndex, 1 + lvConsumerIndex));
        long calcElementOffset = calcElementOffset(lvConsumerIndex);
        Object[] objArr = this.buffer;
        E e = (E) lpElement(objArr, calcElementOffset);
        soElement(objArr, calcElementOffset, null);
        return e;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        E lvElement;
        long lvProducerIndexCache = lvProducerIndexCache();
        do {
            long lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex >= lvProducerIndexCache) {
                long lvProducerIndex = lvProducerIndex();
                if (lvConsumerIndex >= lvProducerIndex) {
                    return null;
                }
                svProducerIndexCache(lvProducerIndex);
            }
            lvElement = lvElement(calcElementOffset(lvConsumerIndex));
        } while (lvElement == null);
        return lvElement;
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
        return lvConsumerIndex() == lvProducerIndex();
    }
}
