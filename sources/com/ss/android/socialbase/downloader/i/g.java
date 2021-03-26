package com.ss.android.socialbase.downloader.i;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache */
public class g<K, T> extends LinkedHashMap<K, T> {
    private int a;

    public g() {
        this(4, 4);
    }

    public g(int i, int i2) {
        this(i, i2, true);
    }

    public g(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        a(i2);
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.a;
    }
}
