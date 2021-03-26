package com.coolapk.market.util;

import java.util.Objects;

public class CommonUtils {
    public static <T> T checkNotNull(T t) {
        return (T) checkNotNull(t, null);
    }

    public static <T> T checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
