package com.coolapk.market.event;

import com.coolapk.market.model.Gift;

public class GiftDelEvent {
    private Gift gift;

    public GiftDelEvent(Gift gift2) {
        this.gift = gift2;
    }

    public Gift getGift() {
        return this.gift;
    }
}
