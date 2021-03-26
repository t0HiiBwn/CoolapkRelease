package com.coolapk.market.util;

import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J'\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f\"\u00020\u0001¢\u0006\u0002\u0010\u0010R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/TraceUtils;", "", "()V", "startTime", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getStartTime", "()Ljava/util/HashMap;", "beginTrace", "", "tag", "endTrace", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TraceUtils.kt */
public final class TraceUtils {
    public static final TraceUtils INSTANCE = new TraceUtils();
    private static final HashMap<String, Long> startTime = new HashMap<>();

    private TraceUtils() {
    }

    public final HashMap<String, Long> getStartTime() {
        return startTime;
    }

    public final void beginTrace(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        startTime.put(str, Long.valueOf(System.nanoTime()));
    }

    public final void endTrace(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(objArr, "args");
        Long l = startTime.get(str);
        if (l == null) {
            l = 0L;
        }
        Intrinsics.checkNotNullExpressionValue(l, "startTime.get(tag) ?: 0");
        long longValue = l.longValue();
        Log.d(str, " cost " + ((System.nanoTime() - longValue) / ((long) 1000)) + " us, args: " + Arrays.toString(objArr));
    }
}
