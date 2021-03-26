package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

abstract class BaseLinkedAtomicQueue<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> consumerNode = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> producerNode = new AtomicReference<>();

    protected final LinkedQueueNode<E> lvProducerNode() {
        return this.producerNode.get();
    }

    protected final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode.get();
    }

    protected final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        return this.producerNode.getAndSet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> lvConsumerNode() {
        return this.consumerNode.get();
    }

    protected final LinkedQueueNode<E> lpConsumerNode() {
        return this.consumerNode.get();
    }

    protected final void spConsumerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> lvConsumerNode = lvConsumerNode();
        LinkedQueueNode<E> lvProducerNode = lvProducerNode();
        int i = 0;
        while (lvConsumerNode != lvProducerNode && i < Integer.MAX_VALUE) {
            do {
                lvNext = lvConsumerNode.lvNext();
            } while (lvNext == null);
            i++;
            lvConsumerNode = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }
}
