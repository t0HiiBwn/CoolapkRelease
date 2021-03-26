package com.coolapk.market.event;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class ActivityPauseEvent {
    private WeakReference<Activity> activity;

    public ActivityPauseEvent(Activity activity2) {
        this.activity = new WeakReference<>(activity2);
    }

    public boolean isSameActivity(Activity activity2) {
        Activity activity3 = this.activity.get();
        return activity3 != null && activity3 == activity2;
    }
}
