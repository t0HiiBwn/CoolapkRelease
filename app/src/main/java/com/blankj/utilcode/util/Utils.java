package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.ThreadUtils;
import java.util.Objects;

public final class Utils {
    private static Application sApp;

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Func1<Ret, Par> {
        Ret call(Par par);
    }

    public interface OnAppStatusChangedListener {
        void onBackground(Activity activity);

        void onForeground(Activity activity);
    }

    public interface Supplier<T> {
        T get();
    }

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void init(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = sApp;
        if (application2 == null) {
            sApp = application;
            UtilsBridge.init(application);
            UtilsBridge.preLoad();
        } else if (!application2.equals(application)) {
            UtilsBridge.unInit(sApp);
            sApp = application;
            UtilsBridge.init(application);
        }
    }

    public static Application getApp() {
        Application application = sApp;
        if (application != null) {
            return application;
        }
        init(UtilsBridge.getApplicationByReflect());
        Objects.requireNonNull(sApp, "reflect failed.");
        Log.i("Utils", UtilsBridge.getCurrentProcessName() + " reflect app success.");
        return sApp;
    }

    public static abstract class Task<Result> extends ThreadUtils.SimpleTask<Result> {
        private Consumer<Result> mConsumer;

        public Task(Consumer<Result> consumer) {
            this.mConsumer = consumer;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(Result result) {
            Consumer<Result> consumer = this.mConsumer;
            if (consumer != null) {
                consumer.accept(result);
            }
        }
    }

    public static class ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onActivityStarted(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onActivityResumed(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onActivityPaused(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onActivityStopped(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onActivityDestroyed(Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void onLifecycleChanged(Activity activity, Lifecycle.Event event) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
    }
}
