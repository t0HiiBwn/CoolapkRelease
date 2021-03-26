package com.coolapk.market.event;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class ActivityResumeEvent {
    private WeakReference<Activity> activity;

    public ActivityResumeEvent(Activity activity2) {
        this.activity = new WeakReference<>(activity2);
    }

    public boolean isSameActivity(Activity activity2) {
        Activity activity3 = this.activity.get();
        return activity3 != null && activity3 == activity2;
    }
}
