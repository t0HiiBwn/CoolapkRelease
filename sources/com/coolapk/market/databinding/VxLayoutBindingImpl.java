package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.coolapk.market.widget.view.VXNestedScrollView;
import com.coolapk.market.widget.view.VXProxyFloatingView;

public class VxLayoutBindingImpl extends VxLayoutBinding {
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
        sparseIntArray.put(2131363009, 1);
        sparseIntArray.put(2131362103, 2);
        sparseIntArray.put(2131362084, 3);
        sparseIntArray.put(2131362575, 4);
        sparseIntArray.put(2131362316, 5);
        sparseIntArray.put(2131363480, 6);
        sparseIntArray.put(2131363490, 7);
        sparseIntArray.put(2131363934, 8);
    }

    public VxLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private VxLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[3], (IgnoreInsetFrameLayout) objArr[2], (LinearLayout) objArr[5], (VXProxyFloatingView) objArr[4], (DrawSystemBarFrameLayout) objArr[0], (VXNestedScrollView) objArr[1], (NestedScrollView) objArr[6], (TabLayout) objArr[7], (ScrollStateViewPager) objArr[8]);
        this.mDirtyFlags = -1;
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
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
