package com.soundcloud.android.crop;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

abstract class MonitoredActivity extends Activity {
    private final ArrayList<LifeCycleListener> listeners = new ArrayList<>();

    public static class LifeCycleAdapter implements LifeCycleListener {
        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityCreated(MonitoredActivity monitoredActivity) {
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(MonitoredActivity monitoredActivity) {
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(MonitoredActivity monitoredActivity) {
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(MonitoredActivity monitoredActivity) {
        }
    }

    public interface LifeCycleListener {
        void onActivityCreated(MonitoredActivity monitoredActivity);

        void onActivityDestroyed(MonitoredActivity monitoredActivity);

        void onActivityStarted(MonitoredActivity monitoredActivity);

        void onActivityStopped(MonitoredActivity monitoredActivity);
    }

    MonitoredActivity() {
    }

    public void addLifeCycleListener(LifeCycleListener lifeCycleListener) {
        if (!this.listeners.contains(lifeCycleListener)) {
            this.listeners.add(lifeCycleListener);
        }
    }

    public void removeLifeCycleListener(LifeCycleListener lifeCycleListener) {
        this.listeners.remove(lifeCycleListener);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<LifeCycleListener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onActivityCreated(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator<LifeCycleListener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onActivityDestroyed(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator<LifeCycleListener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onActivityStarted(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator<LifeCycleListener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onActivityStopped(this);
        }
    }
}
