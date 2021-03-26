package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/widget/SlidingTabLayoutCompat;", "Lcom/flyco/tablayout/SlidingTabLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onPageChangeListeners", "Ljava/util/ArrayList;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "addOnPageChangeListener", "", "listener", "clearOnPageChangeListeners", "onPageScrollStateChanged", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "removeOnPageChangeListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SlidingTabLayoutCompat.kt */
public final class SlidingTabLayoutCompat extends SlidingTabLayout {
    private ArrayList<ViewPager.OnPageChangeListener> onPageChangeListeners;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SlidingTabLayoutCompat(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingTabLayoutCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onPageChangeListeners = new ArrayList<>();
    }

    @Override // com.flyco.tablayout.SlidingTabLayout, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        super.onPageScrollStateChanged(i);
        Iterator<T> it2 = this.onPageChangeListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPageScrollStateChanged(i);
        }
    }

    @Override // com.flyco.tablayout.SlidingTabLayout, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        super.onPageScrolled(i, f, i2);
        Iterator<T> it2 = this.onPageChangeListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPageScrolled(i, f, i2);
        }
    }

    @Override // com.flyco.tablayout.SlidingTabLayout, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        Iterator<T> it2 = this.onPageChangeListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPageSelected(i);
        }
    }

    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Intrinsics.checkNotNullParameter(onPageChangeListener, "listener");
        this.onPageChangeListeners.add(onPageChangeListener);
    }

    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Intrinsics.checkNotNullParameter(onPageChangeListener, "listener");
        this.onPageChangeListeners.remove(onPageChangeListener);
    }

    public final void clearOnPageChangeListeners() {
        this.onPageChangeListeners.clear();
    }
}
