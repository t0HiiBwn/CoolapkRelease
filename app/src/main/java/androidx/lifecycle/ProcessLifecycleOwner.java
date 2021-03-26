package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;

public class ProcessLifecycleOwner implements LifecycleOwner {
    static final long TIMEOUT_MS = 700;
    private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
    private Runnable mDelayedPauseRunnable = new Runnable() {
        /* class androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner.this.dispatchPauseIfNeeded();
            ProcessLifecycleOwner.this.dispatchStopIfNeeded();
        }
    };
    private Handler mHandler;
    ReportFragment.ActivityInitializationListener mInitializationListener = new ReportFragment.ActivityInitializationListener() {
        /* class androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass2 */

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            ProcessLifecycleOwner.this.activityStarted();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            ProcessLifecycleOwner.this.activityResumed();
        }
    };
    private boolean mPauseSent = true;
    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private boolean mStopSent = true;

    public static LifecycleOwner get() {
        return sInstance;
    }

    static void init(Context context) {
        sInstance.attach(context);
    }

    void activityStarted() {
        int i = this.mStartedCounter + 1;
        this.mStartedCounter = i;
        if (i == 1 && this.mStopSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.mStopSent = false;
        }
    }

    void activityResumed() {
        int i = this.mResumedCounter + 1;
        this.mResumedCounter = i;
        if (i != 1) {
            return;
        }
        if (this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.mPauseSent = false;
            return;
        }
        this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    }

    void activityPaused() {
        int i = this.mResumedCounter - 1;
        this.mResumedCounter = i;
        if (i == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700);
        }
    }

    void activityStopped() {
        this.mStartedCounter--;
        dispatchStopIfNeeded();
    }

    void dispatchPauseIfNeeded() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.mStopSent = true;
        }
    }

    private ProcessLifecycleOwner() {
    }

    void attach(Context context) {
        this.mHandler = new Handler();
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            /* class androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass3 */

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.get(activity).setProcessListener(ProcessLifecycleOwner.this.mInitializationListener);
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner.this.activityPaused();
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner.this.activityStopped();
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
