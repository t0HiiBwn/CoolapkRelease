package com.coolapk.market.util;

import java.util.Collection;

public class CollectionUtils {
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static int safeSize(Collection collection) {
        if (isEmpty(collection)) {
            return 0;
        }
        return collection.size();
    }

    public static boolean equalSize(Collection collection, Collection collection2) {
        return safeSize(collection) == safeSize(collection2);
    }
}
