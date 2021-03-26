package com.sina.weibo.sdk.network.target;

public abstract class BaseTarget<E> implements Target<E> {
    @Override // com.sina.weibo.sdk.network.target.Target
    public void onError() {
    }

    @Override // com.sina.weibo.sdk.network.target.Target
    public void onRequestDone() {
    }

    @Override // com.sina.weibo.sdk.network.target.Target
    public void onRequestSuccessBg(E e) {
    }

    @Override // com.sina.weibo.sdk.network.target.Target
    public void onStart() {
    }

    @Override // com.sina.weibo.sdk.network.target.Target
    public void onStartBg() {
    }
}
