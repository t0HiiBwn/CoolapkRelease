package rx.internal.util.atomic;

import java.util.Objects;

public final class SpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public SpscLinkedAtomicQueue() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        spProducerNode(linkedQueueNode);
        spConsumerNode(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        lpProducerNode().soNext(linkedQueueNode);
        spProducerNode(linkedQueueNode);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = lpConsumerNode().lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        spConsumerNode(lvNext);
        return andNullValue;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = lpConsumerNode().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }
}
