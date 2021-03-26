package com.coolapk.market.extend;

import android.view.View;
import android.view.ViewParent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u000e\u001a\u00020\tH\u0002J\t\u0010\u000f\u001a\u00020\u0002H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"com/coolapk/market/extend/ViewExtents2Kt$iteratorParent$1", "", "Landroid/view/ViewParent;", "current", "getCurrent", "()Landroid/view/ViewParent;", "setCurrent", "(Landroid/view/ViewParent;)V", "init", "", "getInit", "()Z", "setInit", "(Z)V", "hasNext", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtents2.kt */
public final class ViewExtents2Kt$iteratorParent$1 implements Iterator<ViewParent>, KMappedMarker {
    final /* synthetic */ View $this_iteratorParent;
    private ViewParent current;
    private boolean init;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    ViewExtents2Kt$iteratorParent$1(View view) {
        this.$this_iteratorParent = view;
    }

    public final boolean getInit() {
        return this.init;
    }

    public final void setInit(boolean z) {
        this.init = z;
    }

    public final ViewParent getCurrent() {
        return this.current;
    }

    public final void setCurrent(ViewParent viewParent) {
        this.current = viewParent;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.init) {
            ViewParent viewParent = this.current;
            if ((viewParent != null ? viewParent.getParent() : null) != null) {
                return true;
            }
            return false;
        } else if (this.$this_iteratorParent.getParent() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override // java.util.Iterator
    public ViewParent next() {
        if (!this.init) {
            this.current = this.$this_iteratorParent.getParent();
            this.init = true;
        } else {
            ViewParent viewParent = this.current;
            this.current = viewParent != null ? viewParent.getParent() : null;
        }
        ViewParent viewParent2 = this.current;
        if (viewParent2 != null) {
            return viewParent2;
        }
        throw new IndexOutOfBoundsException();
    }
}
