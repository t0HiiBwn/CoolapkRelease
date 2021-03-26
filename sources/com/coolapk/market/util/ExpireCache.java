package com.coolapk.market.util;

import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0001J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0005RB\u0010\u0003\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u0004j\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/util/ExpireCache;", "", "()V", "hashMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "getOrNull", "T", "key", "expireMill", "(Ljava/lang/String;J)Ljava/lang/Object;", "getOrPut", "block", "Lkotlin/Function0;", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "put", "", "result", "remove", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ExpireCache.kt */
public final class ExpireCache {
    public static final ExpireCache INSTANCE = new ExpireCache();
    private static final HashMap<String, Pair<Long, Object>> hashMap = new HashMap<>();

    private ExpireCache() {
    }

    public final <T> T getOrPut(String str, long j, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function0, "block");
        HashMap<String, Pair<Long, Object>> hashMap2 = hashMap;
        Pair<Long, Object> pair = hashMap2.get(str);
        if (pair != null && System.currentTimeMillis() - j <= pair.getFirst().longValue()) {
            return (T) pair.getSecond();
        }
        T t = (T) function0.invoke();
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Objects.requireNonNull(t, "null cannot be cast to non-null type kotlin.Any");
        hashMap2.put(str, TuplesKt.to(valueOf, t));
        return t;
    }

    public final <T> T getOrNull(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        Pair<Long, Object> pair = hashMap.get(str);
        if (pair == null || System.currentTimeMillis() - j > pair.getFirst().longValue()) {
            return null;
        }
        return (T) pair.getSecond();
    }

    public final void put(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "result");
        hashMap.put(str, TuplesKt.to(Long.valueOf(System.currentTimeMillis()), obj));
    }

    public final void remove(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        hashMap.remove(str);
    }
}
