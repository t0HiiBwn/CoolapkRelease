package com.kk.taurus.playerbase.extension;

public interface EventProducer {
    void destroy();

    ReceiverEventSender getSender();

    void onAdded();

    void onRemoved();
}
