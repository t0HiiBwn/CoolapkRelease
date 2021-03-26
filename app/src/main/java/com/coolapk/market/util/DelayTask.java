package com.coolapk.market.util;

import android.os.CountDownTimer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/util/DelayTask;", "", "()V", "timerSet", "Ljava/util/HashMap;", "", "Landroid/os/CountDownTimer;", "Lkotlin/collections/HashMap;", "getTimerSet", "()Ljava/util/HashMap;", "addTask", "", "key", "runnable", "Ljava/lang/Runnable;", "delay", "", "clear", "removeTask", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DelayTask.kt */
public final class DelayTask {
    private final HashMap<String, CountDownTimer> timerSet = new HashMap<>();

    public final HashMap<String, CountDownTimer> getTimerSet() {
        return this.timerSet;
    }

    public final void addTask(String str, Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        removeTask(str);
        CountDownTimer start = new DelayTask$addTask$countDownTimer$1(this, runnable, str, j, j, j).start();
        Intrinsics.checkNotNullExpressionValue(start, "countDownTimer");
        this.timerSet.put(str, start);
    }

    public final void removeTask(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        CountDownTimer countDownTimer = this.timerSet.get(str);
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.timerSet.remove(str);
        }
    }

    public final void clear() {
        Collection<CountDownTimer> values = this.timerSet.values();
        Intrinsics.checkNotNullExpressionValue(values, "timerSet.values");
        Iterator<T> it2 = values.iterator();
        while (it2.hasNext()) {
            it2.next().cancel();
        }
    }
}
