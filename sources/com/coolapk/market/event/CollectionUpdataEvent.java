package com.coolapk.market.event;

import com.coolapk.market.model.Collection;

public class CollectionUpdataEvent {
    public static int CREATE = 0;
    public static int UPDATA = 1;
    private int action;
    private Collection collection;

    public CollectionUpdataEvent(Collection collection2, int i) {
        this.collection = collection2;
        this.action = i;
    }

    public int getAction() {
        return this.action;
    }

    public Collection getCollection() {
        return this.collection;
    }
}
