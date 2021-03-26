package com.huawei.hms.common.data;

public interface Freezable<T> {
    T freeze();

    boolean isDataValid();
}
