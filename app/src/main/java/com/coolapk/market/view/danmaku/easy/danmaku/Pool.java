package com.coolapk.market.view.danmaku.easy.danmaku;

public interface Pool<T> {
    int count();

    T get();

    void release();

    void setMaxSize(int i);
}
