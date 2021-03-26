package com.coolapk.market.manager;

import android.view.View;
import kotlin.Metadata;
import kotlin.TuplesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: StatisticHelper.kt */
final class StatisticHelper$traceViewExposedEvent$recordFeedRunnable$1 implements Runnable {
    final /* synthetic */ String $actionKey;
    final /* synthetic */ String $category;
    final /* synthetic */ int $runnableKey;
    final /* synthetic */ String $value;
    final /* synthetic */ View $viewRoot;
    final /* synthetic */ StatisticHelper this$0;

    StatisticHelper$traceViewExposedEvent$recordFeedRunnable$1(StatisticHelper statisticHelper, String str, String str2, String str3, View view, int i) {
        this.this$0 = statisticHelper;
        this.$category = str;
        this.$actionKey = str2;
        this.$value = str3;
        this.$viewRoot = view;
        this.$runnableKey = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.recordCustomKVEvent(this.$category, TuplesKt.to(this.$actionKey, this.$value));
        this.$viewRoot.setTag(this.$runnableKey, null);
    }
}
