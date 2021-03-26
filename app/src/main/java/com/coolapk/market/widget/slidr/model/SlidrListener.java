package com.coolapk.market.widget.slidr.model;

public interface SlidrListener {
    void onSlideChange(float f);

    void onSlideClosed();

    void onSlideOpened();

    void onSlideStateChanged(int i);
}
