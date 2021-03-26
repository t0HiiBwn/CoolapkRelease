package com.coolapk.market.view.base;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/base/PropertyChangeAware;", "", "()V", "changeSupport", "Ljava/beans/PropertyChangeSupport;", "getChangeSupport", "()Ljava/beans/PropertyChangeSupport;", "addPropertyChangeListener", "", "listener", "Ljava/beans/PropertyChangeListener;", "removePropertyChangeListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PropertyChangeAware.kt */
public class PropertyChangeAware {
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    protected final PropertyChangeSupport getChangeSupport() {
        return this.changeSupport;
    }

    public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        Intrinsics.checkNotNullParameter(propertyChangeListener, "listener");
        this.changeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        Intrinsics.checkNotNullParameter(propertyChangeListener, "listener");
        this.changeSupport.removePropertyChangeListener(propertyChangeListener);
    }
}
