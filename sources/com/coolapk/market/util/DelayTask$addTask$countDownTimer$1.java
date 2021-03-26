package com.coolapk.market.util;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/util/DelayTask$addTask$countDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DelayTask.kt */
public final class DelayTask$addTask$countDownTimer$1 extends CountDownTimer {
    final /* synthetic */ long $delay;
    final /* synthetic */ String $key;
    final /* synthetic */ Runnable $runnable;
    final /* synthetic */ DelayTask this$0;

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelayTask$addTask$countDownTimer$1(DelayTask delayTask, Runnable runnable, String str, long j, long j2, long j3) {
        super(j2, j3);
        this.this$0 = delayTask;
        this.$runnable = runnable;
        this.$key = str;
        this.$delay = j;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.$runnable.run();
        this.this$0.getTimerSet().remove(this.$key);
    }
}
