package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {
    private final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    protected int getSize(Y y) {
        return 1;
    }

    protected void onItemEvicted(T t, Y y) {
    }

    public LruCache(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f >= 0.0f) {
            this.maxSize = (long) Math.round(((float) this.initialMaxSize) * f);
            evict();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    protected synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    public synchronized Y get(T t) {
        return this.cache.get(t);
    }

    public synchronized Y put(T t, Y y) {
        long size = (long) getSize(y);
        if (size >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += size;
        }
        Y put = this.cache.put(t, y);
        if (put != null) {
            this.currentSize -= (long) getSize(put);
            if (!put.equals(y)) {
                onItemEvicted(t, put);
            }
        }
        evict();
        return put;
    }

    public synchronized Y remove(T t) {
        Y remove;
        remove = this.cache.remove(t);
        if (remove != null) {
            this.currentSize -= (long) getSize(remove);
        }
        return remove;
    }

    public void clearMemory() {
        trimToSize(0);
    }

    protected synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator<Map.Entry<T, Y>> it2 = this.cache.entrySet().iterator();
            Map.Entry<T, Y> next = it2.next();
            Y value = next.getValue();
            this.currentSize -= (long) getSize(value);
            T key = next.getKey();
            it2.remove();
            onItemEvicted(key, value);
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }
}
