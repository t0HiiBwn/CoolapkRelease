package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscAtomicArrayQueue<E> extends AtomicReferenceArrayQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    @Override // rx.internal.util.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // rx.internal.util.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public SpscAtomicArrayQueue(int i) {
        super(i);
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        long j = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j, i);
        if (j >= this.producerLookAhead) {
            long j2 = ((long) this.lookAheadStep) + j;
            if (lvElement(atomicReferenceArray, calcElementOffset(j2, i)) == null) {
                this.producerLookAhead = j2;
            } else if (lvElement(atomicReferenceArray, calcElementOffset) != null) {
                return false;
            }
        }
        soElement(atomicReferenceArray, calcElementOffset, e);
        soProducerIndex(j + 1);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E lvElement = lvElement(atomicReferenceArray, calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(j + 1);
        return lvElement;
    }

    @Override // java.util.Queue
    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
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

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }
}
