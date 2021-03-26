package rx.android.schedulers;

import android.os.Handler;
import java.util.Objects;
import rx.Scheduler;

@Deprecated
public final class HandlerScheduler extends LooperScheduler {
    @Override // rx.android.schedulers.LooperScheduler, rx.Scheduler
    public /* bridge */ /* synthetic */ Scheduler.Worker createWorker() {
        return super.createWorker();
    }

    @Deprecated
    public static HandlerScheduler from(Handler handler) {
        Objects.requireNonNull(handler, "handler == null");
        return new HandlerScheduler(handler);
    }

    private HandlerScheduler(Handler handler) {
        super(handler);
    }
}
