package com.coolapk.market.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.ActivityPauseEvent;
import com.coolapk.market.event.ActivityResumeEvent;
import com.coolapk.market.event.ApplicationVisibleEvent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0007J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/util/ActivityLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "configCount", "", "foregroundCount", "isBackground", "", "statusListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/coolapk/market/util/OnAppStatusChangedListener;", "addOnAppStatusChangedListener", "", "listener", "isAppForeground", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "bundle", "onActivityStarted", "onActivityStopped", "postStatus", "isForeground", "register", "context", "Landroid/app/Application;", "removeOnAppStatusChangedListener", "unregister", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActivityLifecycle.kt */
public final class ActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private int configCount;
    private int foregroundCount;
    private boolean isBackground = true;
    private final CopyOnWriteArrayList<OnAppStatusChangedListener> statusListeners = new CopyOnWriteArrayList<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    public final void register(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        application.registerActivityLifecycleCallbacks(this);
    }

    public final void unregister(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public final void addOnAppStatusChangedListener(OnAppStatusChangedListener onAppStatusChangedListener) {
        Intrinsics.checkNotNullParameter(onAppStatusChangedListener, "listener");
        this.statusListeners.add(onAppStatusChangedListener);
    }

    public final void removeOnAppStatusChangedListener(OnAppStatusChangedListener onAppStatusChangedListener) {
        Intrinsics.checkNotNullParameter(onAppStatusChangedListener, "listener");
        this.statusListeners.remove(onAppStatusChangedListener);
    }

    public final boolean isAppForeground() {
        return !this.isBackground;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = this.configCount;
        if (i < 0) {
            this.configCount = i + 1;
        } else {
            this.foregroundCount++;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isBackground) {
            this.isBackground = false;
            postStatus(activity, true);
        }
        AppHolder.getInstance().setCurrentActivity(activity);
        EventBus.getDefault().post(new ActivityResumeEvent(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        EventBus.getDefault().post(new ActivityPauseEvent(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity.isChangingConfigurations()) {
            this.configCount--;
            return;
        }
        int i = this.foregroundCount - 1;
        this.foregroundCount = i;
        if (i <= 0) {
            this.isBackground = true;
            postStatus(activity, false);
        }
    }

    private final void postStatus(Activity activity, boolean z) {
        Iterator<OnAppStatusChangedListener> it2 = this.statusListeners.iterator();
        while (it2.hasNext()) {
            OnAppStatusChangedListener next = it2.next();
            if (z) {
                next.onForeground(activity);
            } else {
                next.onBackground(activity);
            }
            EventBus.getDefault().post(new ApplicationVisibleEvent(z));
        }
    }
}
