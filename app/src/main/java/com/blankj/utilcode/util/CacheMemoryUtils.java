package com.blankj.utilcode.util;

import androidx.collection.LruCache;
import com.blankj.utilcode.constant.CacheConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class CacheMemoryUtils implements CacheConstants {
    private static final Map<String, CacheMemoryUtils> CACHE_MAP = new HashMap();
    private static final int DEFAULT_MAX_COUNT = 256;
    private final String mCacheKey;
    private final LruCache<String, CacheValue> mMemoryCache;

    public static CacheMemoryUtils getInstance() {
        return getInstance(256);
    }

    public static CacheMemoryUtils getInstance(int i) {
        return getInstance(String.valueOf(i), i);
    }

    public static CacheMemoryUtils getInstance(String str, int i) {
        Map<String, CacheMemoryUtils> map = CACHE_MAP;
        CacheMemoryUtils cacheMemoryUtils = map.get(str);
        if (cacheMemoryUtils == null) {
            synchronized (CacheMemoryUtils.class) {
                cacheMemoryUtils = map.get(str);
                if (cacheMemoryUtils == null) {
                    cacheMemoryUtils = new CacheMemoryUtils(str, new LruCache(i));
                    map.put(str, cacheMemoryUtils);
                }
            }
        }
        return cacheMemoryUtils;
    }

    private CacheMemoryUtils(String str, LruCache<String, CacheValue> lruCache) {
        this.mCacheKey = str;
        this.mMemoryCache = lruCache;
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }

    public void put(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, obj, -1);
    }

    public void put(String str, Object obj, int i) {
        long j;
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (obj != null) {
            if (i < 0) {
                j = -1;
            } else {
                j = System.currentTimeMillis() + ((long) (i * 1000));
            }
            this.mMemoryCache.put(str, new CacheValue(j, obj));
        }
    }

    public <T> T get(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) get(str, null);
    }

    public <T> T get(String str, T t) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        CacheValue cacheValue = this.mMemoryCache.get(str);
        if (cacheValue == null) {
            return t;
        }
        if (cacheValue.dueTime == -1 || cacheValue.dueTime >= System.currentTimeMillis()) {
            return (T) cacheValue.value;
        }
        this.mMemoryCache.remove(str);
        return t;
    }

    public int getCacheCount() {
        return this.mMemoryCache.size();
    }

    public Object remove(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        CacheValue remove = this.mMemoryCache.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.value;
    }

    public void clear() {
        this.mMemoryCache.evictAll();
    }

    private static final class CacheValue {
        long dueTime;
        Object value;

        CacheValue(long j, Object obj) {
            this.dueTime = j;
            this.value = obj;
        }
    }
}
