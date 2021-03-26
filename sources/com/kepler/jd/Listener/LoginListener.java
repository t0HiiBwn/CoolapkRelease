package com.kepler.jd.Listener;

public interface LoginListener<T> {
    void authFailed(int i);

    void authSuccess(T t);
}
