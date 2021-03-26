package com.kk.taurus.playerbase.extension;

public abstract class BaseEventProducer implements EventProducer {
    private ReceiverEventSender mReceiverEventSender;

    void attachSender(ReceiverEventSender receiverEventSender) {
        this.mReceiverEventSender = receiverEventSender;
    }

    @Override // com.kk.taurus.playerbase.extension.EventProducer
    public ReceiverEventSender getSender() {
        return this.mReceiverEventSender;
    }
}
