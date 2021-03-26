package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.elements.android.window.WindowRootViewCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class ApplicationDescriptor extends AbstractChainedDescriptor<Application> {
    private final ActivityTracker mActivityTracker = ActivityTracker.get();
    private final Map<Application, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());

    ApplicationDescriptor() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.facebook.stetho.common.Accumulator] */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    protected /* bridge */ /* synthetic */ void onGetChildren(Application application, Accumulator accumulator) {
        onGetChildren(application, (Accumulator<Object>) accumulator);
    }

    private ElementContext getContext(Application application) {
        return this.mElementToContextMap.get(application);
    }

    /* access modifiers changed from: protected */
    public void onHook(Application application) {
        ElementContext elementContext = new ElementContext();
        elementContext.hook(application);
        this.mElementToContextMap.put(application, elementContext);
    }

    /* access modifiers changed from: protected */
    public void onUnhook(Application application) {
        this.mElementToContextMap.remove(application).unhook();
    }

    /* access modifiers changed from: protected */
    public NodeType onGetNodeType(Application application) {
        return NodeType.ELEMENT_NODE;
    }

    protected void onGetChildren(Application application, Accumulator<Object> accumulator) {
        List<WeakReference<Activity>> activitiesList = getContext(application).getActivitiesList();
        for (int size = activitiesList.size() - 1; size >= 0; size--) {
            Activity activity = activitiesList.get(size).get();
            if (activity != null) {
                accumulator.store(activity);
            }
        }
        storeWindowIfNeeded(application, accumulator, activitiesList);
    }

    private void storeWindowIfNeeded(Application application, Accumulator<Object> accumulator, List<WeakReference<Activity>> list) {
        for (View view : WindowRootViewCompat.get(application).getRootViews()) {
            if (!isDecorViewOfActivity(view, list)) {
                accumulator.store(view);
            }
        }
    }

    private static boolean isDecorViewOfActivity(View view, List<WeakReference<Activity>> list) {
        Util.throwIfNull(list);
        for (WeakReference<Activity> weakReference : list) {
            Activity activity = weakReference.get();
            if (activity != null && activity.getWindow().getDecorView() == view) {
                return true;
            }
        }
        return false;
    }

    private class ElementContext {
        private Application mElement;
        private final ActivityTracker.Listener mListener = new ActivityTracker.Listener() {
            /* class com.facebook.stetho.inspector.elements.android.ApplicationDescriptor.ElementContext.AnonymousClass1 */

            @Override // com.facebook.stetho.inspector.elements.android.ActivityTracker.Listener
            public void onActivityAdded(Activity activity) {
            }

            @Override // com.facebook.stetho.inspector.elements.android.ActivityTracker.Listener
            public void onActivityRemoved(Activity activity) {
            }
        };

        public ElementContext() {
        }

        public void hook(Application application) {
            this.mElement = application;
            ApplicationDescriptor.this.mActivityTracker.registerListener(this.mListener);
        }

        public void unhook() {
            ApplicationDescriptor.this.mActivityTracker.unregisterListener(this.mListener);
            this.mElement = null;
        }

        public List<WeakReference<Activity>> getActivitiesList() {
            return ApplicationDescriptor.this.mActivityTracker.getActivitiesView();
        }
    }
}
