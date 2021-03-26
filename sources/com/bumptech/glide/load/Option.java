package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = new CacheKeyUpdater<Object>() {
        /* class com.bumptech.glide.load.Option.AnonymousClass1 */

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public static <T> Option<T> memory(String str) {
        return new Option<>(str, null, emptyUpdater());
    }

    public static <T> Option<T> memory(String str, T t) {
        return new Option<>(str, t, emptyUpdater());
    }

    public static <T> Option<T> disk(String str, CacheKeyUpdater<T> cacheKeyUpdater2) {
        return new Option<>(str, null, cacheKeyUpdater2);
    }

    public static <T> Option<T> disk(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater2) {
        return new Option<>(str, t, cacheKeyUpdater2);
    }

    private Option(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater2) {
        this.key = Preconditions.checkNotEmpty(str);
        this.defaultValue = t;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater2);
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public void update(T t, MessageDigest messageDigest) {
        this.cacheKeyUpdater.update(getKeyBytes(), t, messageDigest);
    }

    private byte[] getKeyBytes() {
        if (this.keyBytes == null) {
            this.keyBytes = this.key.getBytes(Key.CHARSET);
        }
        return this.keyBytes;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.key.equals(((Option) obj).key);
        }
        return false;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return (CacheKeyUpdater<T>) EMPTY_UPDATER;
    }

    public String toString() {
        return "Option{key='" + this.key + "'}";
    }
}
