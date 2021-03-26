package com.bumptech.glide.request;

public interface Request {
    void begin();

    void clear();

    boolean isAnyResourceSet();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(Request request);

    boolean isRunning();

    void pause();
}
