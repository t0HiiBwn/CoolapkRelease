package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.facebook.stetho.common.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

public final class ActivityTracker {
    private static final ActivityTracker sInstance = new ActivityTracker();
    private final ArrayList<WeakReference<Activity>> mActivities;
    private final List<WeakReference<Activity>> mActivitiesUnmodifiable;
    @Nullable
    private AutomaticTracker mAutomaticTracker;
    private final List<Listener> mListeners = new CopyOnWriteArrayList();

    public interface Listener {
        void onActivityAdded(Activity activity);

        void onActivityRemoved(Activity activity);
    }

    public ActivityTracker() {
        ArrayList<WeakReference<Activity>> arrayList = new ArrayList<>();
        this.mActivities = arrayList;
        this.mActivitiesUnmodifiable = Collections.unmodifiableList(arrayList);
    }

    public static ActivityTracker get() {
        return sInstance;
    }

    public void registerListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        this.mListeners.remove(listener);
    }

    public boolean beginTrackingIfPossible(Application application) {
        AutomaticTracker newInstanceIfPossible;
        if (this.mAutomaticTracker != null || (newInstanceIfPossible = AutomaticTracker.newInstanceIfPossible(application, this)) == null) {
            return false;
        }
        newInstanceIfPossible.register();
        this.mAutomaticTracker = newInstanceIfPossible;
        return true;
    }

    public boolean endTracking() {
        AutomaticTracker automaticTracker = this.mAutomaticTracker;
        if (automaticTracker == null) {
            return false;
        }
        automaticTracker.unregister();
        this.mAutomaticTracker = null;
        return true;
    }

    public void add(Activity activity) {
        Util.throwIfNull(activity);
        Util.throwIfNot(Looper.myLooper() == Looper.getMainLooper());
        this.mActivities.add(new WeakReference<>(activity));
        for (Listener listener : this.mListeners) {
            listener.onActivityAdded(activity);
        }
    }

    public void remove(Activity activity) {
        Util.throwIfNull(activity);
        Util.throwIfNot(Looper.myLooper() == Looper.getMainLooper());
        if (removeFromWeakList(this.mActivities, activity)) {
            for (Listener listener : this.mListeners) {
                listener.onActivityRemoved(activity);
            }
        }
    }

    private static <T> boolean removeFromWeakList(ArrayList<WeakReference<T>> arrayList, T t) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).get() == t) {
                arrayList.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<WeakReference<Activity>> getActivitiesView() {
        return this.mActivitiesUnmodifiable;
    }

    @Nullable
    public Activity tryGetTopActivity() {
        if (this.mActivitiesUnmodifiable.isEmpty()) {
            return null;
        }
        for (int size = this.mActivitiesUnmodifiable.size() - 1; size >= 0; size--) {
            Activity activity = this.mActivitiesUnmodifiable.get(size).get();
            if (activity != null) {
                return activity;
            }
        }
        return null;
    }

    private static abstract class AutomaticTracker {
        public abstract void register();

        public abstract void unregister();

        private AutomaticTracker() {
        }

        @Nullable
        public static AutomaticTracker newInstanceIfPossible(Application application, ActivityTracker activityTracker) {
            if (Build.VERSION.SDK_INT >= 14) {
                return new AutomaticTrackerICSAndBeyond(application, activityTracker);
            }
            return null;
        }

        private static class AutomaticTrackerICSAndBeyond extends AutomaticTracker {
            private final Application mApplication;
            private final Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
                /* class com.facebook.stetho.inspector.elements.android.ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.AnonymousClass1 */

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.add(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.remove(activity);
                }
            };
            private final ActivityTracker mTracker;

            public AutomaticTrackerICSAndBeyond(Application application, ActivityTracker activityTracker) {
                super();
                this.mApplication = application;
                this.mTracker = activityTracker;
            }

            @Override // com.facebook.stetho.inspector.elements.android.ActivityTracker.AutomaticTracker
            public void register() {
                this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ActivityTracker.AutomaticTracker
            public void unregister() {
                this.mApplication.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }
        }
    }
}
