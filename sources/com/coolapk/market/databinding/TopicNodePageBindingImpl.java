package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.ShapedImageView;
import com.coolapk.market.widget.view.TabLayout;
import com.coolapk.market.widget.view.VXNestedScrollView;
import com.coolapk.market.widget.view.VXProxyFloatingView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TopicNodePageBindingImpl extends TopicNodePageBinding {
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
        sparseIntArray.put(2131363009, 3);
        sparseIntArray.put(2131362103, 4);
        sparseIntArray.put(2131362084, 5);
        sparseIntArray.put(2131362067, 6);
        sparseIntArray.put(2131363588, 7);
        sparseIntArray.put(2131363591, 8);
        sparseIntArray.put(2131362575, 9);
        sparseIntArray.put(2131362316, 10);
        sparseIntArray.put(2131363482, 11);
        sparseIntArray.put(2131363480, 12);
        sparseIntArray.put(2131363490, 13);
        sparseIntArray.put(2131362416, 14);
        sparseIntArray.put(2131363934, 15);
        sparseIntArray.put(2131362880, 16);
        sparseIntArray.put(2131362881, 17);
        sparseIntArray.put(2131362656, 18);
    }

    public TopicNodePageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private TopicNodePageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[6], (FrameLayout) objArr[5], (FrameLayout) objArr[4], (LinearLayout) objArr[10], (View) objArr[14], (FloatingActionButton) objArr[1], (VXProxyFloatingView) objArr[9], (TextView) objArr[18], (FrameLayout) objArr[16], (ShapedImageView) objArr[17], (ProgressBar) objArr[2], (DrawSystemBarFrameLayout) objArr[0], (VXNestedScrollView) objArr[3], (NestedScrollView) objArr[12], (FrameLayout) objArr[11], (TabLayout) objArr[13], (Toolbar) objArr[7], (FrameLayout) objArr[8], (ScrollStateViewPager) objArr[15]);
        this.mDirtyFlags = -1;
        this.floatingButton.setTag(null);
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
            ThemeBindingAdapters.setBackgroundTint(this.floatingButton, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
        }
    }
}
