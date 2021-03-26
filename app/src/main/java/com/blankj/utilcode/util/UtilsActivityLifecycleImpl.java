package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.Utils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class UtilsActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {
    static final UtilsActivityLifecycleImpl INSTANCE = new UtilsActivityLifecycleImpl();
    private static final Activity STUB = new Activity();
    private final Map<Activity, List<Utils.ActivityLifecycleCallbacks>> mActivityLifecycleCallbacksMap = new ConcurrentHashMap();
    private final LinkedList<Activity> mActivityList = new LinkedList<>();
    private int mConfigCount = 0;
    private int mForegroundCount = 0;
    private boolean mIsBackground = false;
    private final List<Utils.OnAppStatusChangedListener> mStatusListeners = new CopyOnWriteArrayList();

    UtilsActivityLifecycleImpl() {
    }

    void init(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    void unInit(Application application) {
        this.mActivityList.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }

    Activity getTopActivity() {
        for (Activity activity : getActivityList()) {
            if (UtilsBridge.isActivityAlive(activity)) {
                return activity;
            }
        }
        return null;
    }

    List<Activity> getActivityList() {
        if (!this.mActivityList.isEmpty()) {
            return new LinkedList(this.mActivityList);
        }
        this.mActivityList.addAll(getActivitiesByReflect());
        return new LinkedList(this.mActivityList);
    }

    void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        this.mStatusListeners.add(onAppStatusChangedListener);
    }

    void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        this.mStatusListeners.remove(onAppStatusChangedListener);
    }

    void addActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        addActivityLifecycleCallbacks(STUB, activityLifecycleCallbacks);
    }

    void addActivityLifecycleCallbacks(final Activity activity, final Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activity != null && activityLifecycleCallbacks != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    UtilsActivityLifecycleImpl.this.addActivityLifecycleCallbacksInner(activity, activityLifecycleCallbacks);
                }
            });
        }
    }

    boolean isAppForeground() {
        return !this.mIsBackground;
    }

    /* access modifiers changed from: private */
    public void addActivityLifecycleCallbacksInner(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        List<Utils.ActivityLifecycleCallbacks> list = this.mActivityLifecycleCallbacksMap.get(activity);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.mActivityLifecycleCallbacksMap.put(activity, list);
        } else if (list.contains(activityLifecycleCallbacks)) {
            return;
        }
        list.add(activityLifecycleCallbacks);
    }

    void removeActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        removeActivityLifecycleCallbacks(STUB, activityLifecycleCallbacks);
    }

    void removeActivityLifecycleCallbacks(final Activity activity) {
        if (activity != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    UtilsActivityLifecycleImpl.this.mActivityLifecycleCallbacksMap.remove(activity);
                }
            });
        }
    }

    void removeActivityLifecycleCallbacks(final Activity activity, final Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activity != null && activityLifecycleCallbacks != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    UtilsActivityLifecycleImpl.this.removeActivityLifecycleCallbacksInner(activity, activityLifecycleCallbacks);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void removeActivityLifecycleCallbacksInner(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        List<Utils.ActivityLifecycleCallbacks> list = this.mActivityLifecycleCallbacksMap.get(activity);
        if (list != null && !list.isEmpty()) {
            list.remove(activityLifecycleCallbacks);
        }
    }

    private void consumeActivityLifecycleCallbacks(Activity activity, Lifecycle.Event event) {
        consumeLifecycle(activity, event, this.mActivityLifecycleCallbacksMap.get(activity));
        consumeLifecycle(activity, event, this.mActivityLifecycleCallbacksMap.get(STUB));
    }

    private void consumeLifecycle(Activity activity, Lifecycle.Event event, List<Utils.ActivityLifecycleCallbacks> list) {
        if (list != null) {
            for (Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks : list) {
                activityLifecycleCallbacks.onLifecycleChanged(activity, event);
                if (event.equals(Lifecycle.Event.ON_CREATE)) {
                    activityLifecycleCallbacks.onActivityCreated(activity);
                } else if (event.equals(Lifecycle.Event.ON_START)) {
                    activityLifecycleCallbacks.onActivityStarted(activity);
                } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                    activityLifecycleCallbacks.onActivityResumed(activity);
                } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                    activityLifecycleCallbacks.onActivityPaused(activity);
                } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                    activityLifecycleCallbacks.onActivityStopped(activity);
                } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                    activityLifecycleCallbacks.onActivityDestroyed(activity);
                }
            }
            if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                this.mActivityLifecycleCallbacksMap.remove(activity);
            }
        }
    }

    Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(getActivityThread(), new Object[0]);
            if (invoke == null) {
                return null;
            }
            return (Application) invoke;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        LanguageUtils.applyLanguage(activity);
        setAnimatorsEnabled();
        setTopActivity(activity);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (!this.mIsBackground) {
            setTopActivity(activity);
        }
        int i = this.mConfigCount;
        if (i < 0) {
            this.mConfigCount = i + 1;
        } else {
            this.mForegroundCount++;
        }
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setTopActivity(activity);
        if (this.mIsBackground) {
            this.mIsBackground = false;
            postStatus(activity, true);
        }
        processHideSoftInputOnActivityDestroy(activity, false);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.mConfigCount--;
        } else {
            int i = this.mForegroundCount - 1;
            this.mForegroundCount = i;
            if (i <= 0) {
                this.mIsBackground = true;
                postStatus(activity, false);
            }
        }
        processHideSoftInputOnActivityDestroy(activity, true);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mActivityList.remove(activity);
        UtilsBridge.fixSoftInputLeaks(activity);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    private void processHideSoftInputOnActivityDestroy(final Activity activity, boolean z) {
        if (z) {
            try {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } catch (Exception unused) {
            }
        } else {
            final Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                    /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Window window = activity.getWindow();
                            if (window != null) {
                                window.setSoftInputMode(((Integer) tag).intValue());
                            }
                        } catch (Exception unused) {
                        }
                    }
                }, 100);
            }
        }
    }

    private void postStatus(Activity activity, boolean z) {
        if (!this.mStatusListeners.isEmpty()) {
            for (Utils.OnAppStatusChangedListener onAppStatusChangedListener : this.mStatusListeners) {
                if (z) {
                    onAppStatusChangedListener.onForeground(activity);
                } else {
                    onAppStatusChangedListener.onBackground(activity);
                }
            }
        }
    }

    private void setTopActivity(Activity activity) {
        if (!this.mActivityList.contains(activity)) {
            this.mActivityList.addFirst(activity);
        } else if (!this.mActivityList.getFirst().equals(activity)) {
            this.mActivityList.remove(activity);
            this.mActivityList.addFirst(activity);
        }
    }

    private List<Activity> getActivitiesByReflect() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object activityThread = getActivityThread();
            Field declaredField = activityThread.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityThread);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object obj2 : ((Map) obj).values()) {
                Class<?> cls = obj2.getClass();
                Field declaredField2 = cls.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj2);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (!declaredField3.getBoolean(obj2)) {
                        activity = activity2;
                    } else {
                        linkedList.add(activity2);
                    }
                } else {
                    linkedList.add(activity2);
                }
            }
            if (activity != null) {
                linkedList.addFirst(activity);
            }
            return linkedList;
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e.getMessage());
        }
    }

    private Object getActivityThread() {
        Object activityThreadInActivityThreadStaticField = getActivityThreadInActivityThreadStaticField();
        if (activityThreadInActivityThreadStaticField != null) {
            return activityThreadInActivityThreadStaticField;
        }
        return getActivityThreadInActivityThreadStaticMethod();
    }

    private Object getActivityThreadInActivityThreadStaticField() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    private static void setAnimatorsEnabled() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                    declaredField.set(null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}
