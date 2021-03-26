package rx.internal.util.atomic;

import java.util.Objects;

public final class MpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public MpscLinkedAtomicQueue() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        spConsumerNode(linkedQueueNode);
        xchgProducerNode(linkedQueueNode);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            spConsumerNode(lvNext2);
            return andNullValue;
        } else if (lpConsumerNode == lvProducerNode()) {
            return null;
        } else {
            do {
                lvNext = lpConsumerNode.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            spConsumerNode(lvNext);
            return andNullValue2;
        }
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (lpConsumerNode == lvProducerNode()) {
            return null;
        }
        do {
            lvNext = lpConsumerNode.lvNext();
        } while (lvNext == null);
        return lvNext.lpValue();
    }
}
