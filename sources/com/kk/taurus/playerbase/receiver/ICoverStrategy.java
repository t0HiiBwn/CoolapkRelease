package com.kk.taurus.playerbase.receiver;

import android.view.ViewGroup;

public interface ICoverStrategy {
    void addCover(BaseCover baseCover);

    ViewGroup getContainerView();

    int getCoverCount();

    boolean isContainsCover(BaseCover baseCover);

    void removeAllCovers();

    void removeCover(BaseCover baseCover);
}
