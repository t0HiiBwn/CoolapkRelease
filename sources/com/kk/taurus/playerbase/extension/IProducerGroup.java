package com.kk.taurus.playerbase.extension;

public interface IProducerGroup {
    void addEventProducer(BaseEventProducer baseEventProducer);

    void destroy();

    boolean removeEventProducer(BaseEventProducer baseEventProducer);
}
