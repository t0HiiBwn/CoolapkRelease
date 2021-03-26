package com.tencent.msdk.dns.base.a;

import android.os.Build;
import android.util.ArrayMap;
import android.util.ArraySet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: CollectionCompat */
public final class a {
    public static <K, V> Map<K, V> a() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new ArrayMap();
        }
        return new HashMap();
    }

    public static <K, V> Map<K, V> a(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new ArrayMap(i);
        }
        return new HashMap(i);
    }

    public static <E> Set<E> b() {
        if (Build.VERSION.SDK_INT >= 23) {
            return new ArraySet();
        }
        return new HashSet();
    }

    public static <E> Set<E> b(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return new ArraySet(i);
        }
        return new HashSet(i);
    }
}
