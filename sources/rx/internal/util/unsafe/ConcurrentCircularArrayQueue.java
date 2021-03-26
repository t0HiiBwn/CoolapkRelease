package rx.internal.util.unsafe;

import java.util.Iterator;

public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    protected static final int BUFFER_PAD = 32;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    protected static final int SPARSE_SHIFT;
    protected final E[] buffer;
    protected final long mask;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        SPARSE_SHIFT = intValue;
        int arrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = intValue + 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = (long) (UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class) + (32 << (REF_ELEMENT_SHIFT - intValue)));
    }

    public ConcurrentCircularArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = (long) (roundToPowerOfTwo - 1);
        this.buffer = (E[]) new Object[((roundToPowerOfTwo << SPARSE_SHIFT) + 64)];
    }

    protected final long calcElementOffset(long j) {
        return calcElementOffset(j, this.mask);
    }

    protected final long calcElementOffset(long j, long j2) {
        return REF_ARRAY_BASE + ((j & j2) << REF_ELEMENT_SHIFT);
    }

    protected final void spElement(long j, E e) {
        spElement(this.buffer, j, e);
    }

    protected final void spElement(E[] eArr, long j, E e) {
        UnsafeAccess.UNSAFE.putObject(eArr, j, e);
    }

    protected final void soElement(long j, E e) {
        soElement(this.buffer, j, e);
    }

    protected final void soElement(E[] eArr, long j, E e) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j, e);
    }

    protected final E lpElement(long j) {
        return lpElement(this.buffer, j);
    }

    protected final E lpElement(E[] eArr, long j) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j);
    }

    protected final E lvElement(long j) {
        return lvElement(this.buffer, j);
    }

    protected final E lvElement(E[] eArr, long j) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}
