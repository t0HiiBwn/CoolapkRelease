package com.coolapk.market.event;

import com.coolapk.market.model.Ads;

public class AdsFollowEvent {
    private Ads ads;
    private int result;

    public AdsFollowEvent(Ads ads2, int i) {
        this.ads = ads2;
        this.result = i;
    }

    public Ads getAds() {
        return this.ads;
    }

    public int getResult() {
        return this.result;
    }
}
