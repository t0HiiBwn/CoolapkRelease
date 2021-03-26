package rx.internal.util.unsafe;

import java.util.Objects;
import rx.internal.util.atomic.LinkedQueueNode;

public final class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        spProducerNode(new LinkedQueueNode<>());
        spConsumerNode(this.producerNode);
        this.consumerNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        this.producerNode.soNext(linkedQueueNode);
        this.producerNode = linkedQueueNode;
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        this.consumerNode = lvNext;
        return andNullValue;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }
}
