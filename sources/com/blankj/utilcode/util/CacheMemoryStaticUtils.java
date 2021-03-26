package com.blankj.utilcode.util;

import java.util.Objects;

public final class CacheMemoryStaticUtils {
    private static CacheMemoryUtils sDefaultCacheMemoryUtils;

    public static void setDefaultCacheMemoryUtils(CacheMemoryUtils cacheMemoryUtils) {
        sDefaultCacheMemoryUtils = cacheMemoryUtils;
    }

    public static void put(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, obj, getDefaultCacheMemoryUtils());
    }

    public static void put(String str, Object obj, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, obj, i, getDefaultCacheMemoryUtils());
    }

    public static <T> T get(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) get(str, getDefaultCacheMemoryUtils());
    }

    public static <T> T get(String str, T t) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) get(str, t, getDefaultCacheMemoryUtils());
    }

    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheMemoryUtils());
    }

    public static Object remove(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return remove(str, getDefaultCacheMemoryUtils());
    }

    public static void clear() {
        clear(getDefaultCacheMemoryUtils());
    }

    public static void put(String str, Object obj, CacheMemoryUtils cacheMemoryUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheMemoryUtils.put(str, obj);
    }

    public static void put(String str, Object obj, int i, CacheMemoryUtils cacheMemoryUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheMemoryUtils.put(str, obj, i);
    }

    public static <T> T get(String str, CacheMemoryUtils cacheMemoryUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) cacheMemoryUtils.get(str);
    }

    public static <T> T get(String str, T t, CacheMemoryUtils cacheMemoryUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) cacheMemoryUtils.get(str, t);
    }

    public static int getCacheCount(CacheMemoryUtils cacheMemoryUtils) {
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheMemoryUtils.getCacheCount();
    }

    public static Object remove(String str, CacheMemoryUtils cacheMemoryUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheMemoryUtils.remove(str);
    }

    public static void clear(CacheMemoryUtils cacheMemoryUtils) {
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheMemoryUtils.clear();
    }

    private static CacheMemoryUtils getDefaultCacheMemoryUtils() {
        CacheMemoryUtils cacheMemoryUtils = sDefaultCacheMemoryUtils;
        return cacheMemoryUtils != null ? cacheMemoryUtils : CacheMemoryUtils.getInstance();
    }
}
