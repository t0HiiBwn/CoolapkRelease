package com.kk.taurus.playerbase.extension;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ProducerGroup implements IProducerGroup {
    private List<BaseEventProducer> mEventProducers = new CopyOnWriteArrayList();
    private ReceiverEventSender mEventSender;

    public ProducerGroup(ReceiverEventSender receiverEventSender) {
        this.mEventSender = receiverEventSender;
    }

    @Override // com.kk.taurus.playerbase.extension.IProducerGroup
    public void addEventProducer(BaseEventProducer baseEventProducer) {
        if (!this.mEventProducers.contains(baseEventProducer)) {
            baseEventProducer.attachSender(this.mEventSender);
            this.mEventProducers.add(baseEventProducer);
            baseEventProducer.onAdded();
        }
    }

    @Override // com.kk.taurus.playerbase.extension.IProducerGroup
    public boolean removeEventProducer(BaseEventProducer baseEventProducer) {
        boolean remove = this.mEventProducers.remove(baseEventProducer);
        if (baseEventProducer != null) {
            baseEventProducer.onRemoved();
            baseEventProducer.attachSender(null);
        }
        return remove;
    }

    @Override // com.kk.taurus.playerbase.extension.IProducerGroup
    public void destroy() {
        for (BaseEventProducer baseEventProducer : this.mEventProducers) {
            baseEventProducer.onRemoved();
            baseEventProducer.destroy();
            baseEventProducer.attachSender(null);
        }
        this.mEventProducers.clear();
    }
}
