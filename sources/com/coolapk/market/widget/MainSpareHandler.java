package com.coolapk.market.widget;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Display;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.coolapk.market.AppHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/widget/MainSpareHandler;", "Ljava/lang/Runnable;", "()V", "callback", "com/coolapk/market/widget/MainSpareHandler$callback$1", "Lcom/coolapk/market/widget/MainSpareHandler$callback$1;", "dataList", "", "frameIntervalNano", "", "hadPostMessage", "", "handler", "Landroid/os/Handler;", "currentUptimeNano", "getFrameInterval", "view", "Landroid/view/View;", "post", "r", "recheckRunnableAfterNextFrame", "", "removeCallbacks", "repostAllRunnableToRealHandler", "run", "runPendingActions", "drawTimeNano", "currentTimeNano", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainSpareHandler.kt */
public final class MainSpareHandler implements Runnable {
    public static final Companion Companion = new Companion(null);
    private static final MainSpareHandler sInstance = new MainSpareHandler();
    private final MainSpareHandler$callback$1 callback = new MainSpareHandler$callback$1(this, 0);
    private final List<Runnable> dataList = new ArrayList();
    private long frameIntervalNano;
    private boolean hadPostMessage;
    private final Handler handler = new Handler();

    private MainSpareHandler() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/MainSpareHandler$Companion;", "", "()V", "sInstance", "Lcom/coolapk/market/widget/MainSpareHandler;", "getSInstance", "()Lcom/coolapk/market/widget/MainSpareHandler;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainSpareHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainSpareHandler getSInstance() {
            return MainSpareHandler.sInstance;
        }
    }

    public final boolean post(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "r");
        this.dataList.add(runnable);
        recheckRunnableAfterNextFrame();
        return true;
    }

    public final void removeCallbacks(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "r");
        if (!this.dataList.remove(runnable)) {
            this.handler.removeCallbacks(runnable);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Window window;
        this.hadPostMessage = false;
        if (!this.dataList.isEmpty()) {
            Activity currentActivity = AppHolder.getCurrentActivity();
            View decorView = (currentActivity == null || (window = currentActivity.getWindow()) == null) ? null : window.getDecorView();
            if (decorView != null) {
                long drawingTime = decorView.getDrawingTime();
                if (drawingTime > 0) {
                    if (this.frameIntervalNano == 0) {
                        this.frameIntervalNano = getFrameInterval(decorView);
                    }
                    long nanos = TimeUnit.MILLISECONDS.toNanos(drawingTime);
                    long currentUptimeNano = currentUptimeNano();
                    if (currentUptimeNano - nanos < this.frameIntervalNano) {
                        runPendingActions(nanos, currentUptimeNano);
                        return;
                    }
                }
            }
            repostAllRunnableToRealHandler();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r3 >= 30.0f) goto L_0x0013;
     */
    private final long getFrameInterval(View view) {
        float f;
        Display display = ViewCompat.getDisplay(view);
        if (display != null) {
            f = display.getRefreshRate();
        }
        f = 60.0f;
        return (long) (((float) 1000000000) / f);
    }

    private final void repostAllRunnableToRealHandler() {
        Iterator<T> it2 = this.dataList.iterator();
        while (it2.hasNext()) {
            this.handler.post(it2.next());
        }
        this.dataList.clear();
    }

    private final void runPendingActions(long j, long j2) {
        long j3 = j + ((this.frameIntervalNano / ((long) 4)) * ((long) 3));
        while (j3 > j2) {
            if (!this.dataList.isEmpty()) {
                Runnable remove = this.dataList.remove(0);
                if (remove instanceof PausableTask) {
                    this.callback.setDeadlineNano(j3);
                    PausableTask pausableTask = (PausableTask) remove;
                    pausableTask.setCallback$presentation_coolapkAppRelease(this.callback);
                    remove.run();
                    pausableTask.setCallback$presentation_coolapkAppRelease(null);
                } else {
                    remove.run();
                }
                j2 = currentUptimeNano();
            } else {
                return;
            }
        }
        if (!this.dataList.isEmpty()) {
            recheckRunnableAfterNextFrame();
        }
    }

    private final void recheckRunnableAfterNextFrame() {
        if (!this.hadPostMessage) {
            this.handler.postDelayed(this, 4);
            this.hadPostMessage = true;
        }
    }

    /* access modifiers changed from: private */
    public final long currentUptimeNano() {
        return TimeUnit.MILLISECONDS.toNanos(SystemClock.uptimeMillis());
    }
}
