package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t) {
        return (T) checkNotNull(t, "Argument must not be null");
    }

    public static <T> T checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static String checkNotEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T checkNotEmpty(T t) {
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }
}
