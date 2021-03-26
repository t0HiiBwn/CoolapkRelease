package com.coolapk.market.util;

public class ErrorUtils {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Throwable */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Throwable> T getThrowable(Class<T> cls, Throwable th) {
        if (th == 0) {
            return null;
        }
        if (cls.isInstance(th)) {
            return th;
        }
        if (th.getCause() != null) {
            return (T) getThrowable(cls, th.getCause());
        }
        return null;
    }
}
