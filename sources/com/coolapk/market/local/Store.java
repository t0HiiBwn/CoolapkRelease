package com.coolapk.market.local;

import com.coolapk.market.event.Event;
import org.greenrobot.eventbus.EventBus;

public abstract class Store {
    EventBus bus = EventBus.getDefault();

    public abstract void handleAction(int i, Object obj);

    public void register(Object obj) {
        this.bus.register(obj);
    }

    public void unregister(Object obj) {
        this.bus.unregister(obj);
    }

    protected void postChangeEvent(Event event) {
        this.bus.post(event);
    }
}
