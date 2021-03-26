package com.coolapk.market.manager;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;
import com.coolapk.market.view.feedv8.SubmitFeedV8Activity;
import com.coolapk.market.view.main.MainActivity;
import com.coolapk.market.view.notification.NotificationActivity;
import com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001eJ\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lcom/coolapk/market/manager/ActivityStackManager;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "activityList", "", "Landroid/app/Activity;", "getActivityList", "()Ljava/util/List;", "activityStacks", "", "bottomActivity", "getBottomActivity", "()Landroid/app/Activity;", "topActivity", "getTopActivity", "callOnActivityCreated", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "callOnActivityDestroyed", "getActivityUnder", "top", "requestTaskId", "", "indexOfInstance", "", "clazz", "Ljava/lang/Class;", "limitActivityCounts", "trimActivityStack", "trimMainActivity", "trimNotificationActivity", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActivityStackManager.kt */
public final class ActivityStackManager {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_STACK_COUNT = 7;
    private final List<Activity> activityStacks = new ArrayList();

    public ActivityStackManager(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksAdapter(this) {
            /* class com.coolapk.market.manager.ActivityStackManager.AnonymousClass1 */
            final /* synthetic */ ActivityStackManager this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0.callOnActivityCreated(activity, bundle);
            }

            @Override // com.coolapk.market.widget.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0.callOnActivityDestroyed(activity);
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/manager/ActivityStackManager$Companion;", "", "()V", "MAX_STACK_COUNT", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ActivityStackManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final List<Activity> getActivityList() {
        return this.activityStacks;
    }

    public final Activity getTopActivity() {
        Activity activity;
        List<Activity> list = this.activityStacks;
        ListIterator<Activity> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                activity = null;
                break;
            }
            activity = listIterator.previous();
            if (!activity.isFinishing()) {
                break;
            }
        }
        return activity;
    }

    public final Activity getBottomActivity() {
        T t;
        Iterator<T> it2 = this.activityStacks.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (!t.isFinishing()) {
                break;
            }
        }
        return t;
    }

    public final int indexOfInstance(Class<? extends Activity> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        int i = 0;
        for (Activity activity : this.activityStacks) {
            if (cls.isAssignableFrom(activity.getClass())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static /* synthetic */ Activity getActivityUnder$default(ActivityStackManager activityStackManager, Activity activity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return activityStackManager.getActivityUnder(activity, z);
    }

    public final Activity getActivityUnder(Activity activity, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(activity, "top");
        Integer valueOf = Integer.valueOf(this.activityStacks.indexOf(activity));
        Activity activity2 = null;
        if (!(valueOf.intValue() >= 1)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        int intValue = valueOf.intValue();
        if (!z) {
            return (Activity) CollectionsKt.getOrNull(this.activityStacks, intValue - 1);
        }
        int taskId = activity.getTaskId();
        List<Activity> subList = this.activityStacks.subList(0, intValue);
        ListIterator<Activity> listIterator = subList.listIterator(subList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Activity previous = listIterator.previous();
            if (previous.getTaskId() == taskId) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                activity2 = previous;
                break;
            }
        }
        return activity2;
    }

    /* access modifiers changed from: private */
    public final void callOnActivityCreated(Activity activity, Bundle bundle) {
        this.activityStacks.add(activity);
        trimActivityStack();
    }

    /* access modifiers changed from: private */
    public final void callOnActivityDestroyed(Activity activity) {
        this.activityStacks.remove(activity);
    }

    private final void trimActivityStack() {
        trimNotificationActivity();
        limitActivityCounts();
    }

    private final void trimMainActivity() {
        int indexOfInstance = indexOfInstance(MainActivity.class);
        if (indexOfInstance > 0) {
            for (T t : this.activityStacks.subList(0, indexOfInstance)) {
                if (!t.isFinishing()) {
                    t.finish();
                    t.overridePendingTransition(0, 0);
                }
            }
        }
    }

    private final void trimNotificationActivity() {
        SparseArray sparseArray = new SparseArray();
        for (T t : this.activityStacks) {
            if (t instanceof NotificationActivity) {
                int intExtra = t.getIntent().getIntExtra("tab", 1);
                Activity activity = (Activity) sparseArray.get(intExtra);
                if (activity != null) {
                    activity.finish();
                }
                sparseArray.put(intExtra, t);
            }
        }
    }

    private final void limitActivityCounts() {
        int i;
        int size;
        int indexOfInstance = indexOfInstance(MainActivity.class);
        if (this.activityStacks.size() > indexOfInstance + 7 && (i = indexOfInstance + 1) <= this.activityStacks.size() - 7) {
            while (true) {
                Activity activity = this.activityStacks.get(i);
                if (!activity.isFinishing() && !(activity instanceof SubmitFeedV8Activity)) {
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
