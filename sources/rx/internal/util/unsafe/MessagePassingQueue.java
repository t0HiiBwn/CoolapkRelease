package rx.internal.util.unsafe;

public interface MessagePassingQueue<M> {
    @Override // java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    boolean isEmpty();

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    boolean offer(M m);

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    M peek();

    @Override // rx.internal.util.unsafe.MessagePassingQueue
    M poll();

    @Override // java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    int size();
}
