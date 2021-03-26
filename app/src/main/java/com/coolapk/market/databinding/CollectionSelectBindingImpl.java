package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.SlideUpView;
import com.flyco.tablayout.SlidingTabLayout;

public class CollectionSelectBindingImpl extends CollectionSelectBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362146, 3);
        sparseIntArray.put(2131362639, 4);
        sparseIntArray.put(2131362257, 5);
        sparseIntArray.put(2131363481, 6);
        sparseIntArray.put(2131363322, 7);
        sparseIntArray.put(2131363934, 8);
        sparseIntArray.put(2131362306, 9);
        sparseIntArray.put(2131361899, 10);
    }

    public CollectionSelectBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private CollectionSelectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[10], (SlideUpView) objArr[3], (ImageView) objArr[5], (FrameLayout) objArr[9], (TextView) objArr[1], (LinearLayout) objArr[4], (ProgressBar) objArr[2], (DrawSystemBarFrameLayout) objArr[0], (View) objArr[7], (SlidingTabLayout) objArr[6], (ScrollStateViewPager) objArr[8]);
        this.mDirtyFlags = -1;
        this.createView.setTag(null);
        this.loadingView.setTag(null);
        this.mainContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 1) != 0) {
            ThemeBindingAdapters.setTextColor(this.createView, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
        }
    }
}
