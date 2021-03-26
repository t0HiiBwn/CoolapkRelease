package com.blankj.utilcode.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DebouncingUtils {
    private static final int CACHE_SIZE = 64;
    private static final long DEBOUNCING_DEFAULT_VALUE = 1000;
    private static final Map<String, Long> KEY_MILLIS_MAP = new ConcurrentHashMap(64);

    private DebouncingUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isValid(View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isValid(view, 1000);
    }

    public static boolean isValid(View view, long j) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isValid(String.valueOf(view.hashCode()), j);
    }

    public static boolean isValid(String str, long j) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        } else if (j >= 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            clearIfNecessary(elapsedRealtime);
            Map<String, Long> map = KEY_MILLIS_MAP;
            Long l = map.get(str);
            if (l != null && elapsedRealtime < l.longValue()) {
                return false;
            }
            map.put(str, Long.valueOf(elapsedRealtime + j));
            return true;
        } else {
            throw new IllegalArgumentException("The duration is less than 0.");
        }
    }

    private static void clearIfNecessary(long j) {
        Map<String, Long> map = KEY_MILLIS_MAP;
        if (map.size() >= 64) {
            Iterator<Map.Entry<String, Long>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                if (j >= it2.next().getValue().longValue()) {
                    it2.remove();
                }
            }
        }
    }
}
