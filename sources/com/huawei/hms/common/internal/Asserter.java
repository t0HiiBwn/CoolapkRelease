package com.huawei.hms.common.internal;

public final class Asserter {
    public static void checkNull(Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException(obj.toString() + " is not null");
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("checked object is null");
        }
    }

    public static void checkNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException(obj2.toString());
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(obj.toString());
        }
    }

    private Asserter() {
        throw new AssertionError("Cannot use constructor to make a new instance");
    }
}
