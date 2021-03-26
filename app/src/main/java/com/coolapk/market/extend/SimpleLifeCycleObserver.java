package com.coolapk.market.extend;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0017J\b\u0010\b\u001a\u00020\u0004H\u0017¨\u0006\t"}, d2 = {"Lcom/coolapk/market/extend/SimpleLifeCycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "onCreate", "", "onDestroy", "onPause", "onResume", "onStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LifeCycleExtends.kt */
public abstract class SimpleLifeCycleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }
}
