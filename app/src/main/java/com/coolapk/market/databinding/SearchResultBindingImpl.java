package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public class SearchResultBindingImpl extends SearchResultBinding {
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
        sparseIntArray.put(2131363934, 2);
        sparseIntArray.put(2131363303, 3);
        sparseIntArray.put(2131363004, 4);
        sparseIntArray.put(2131363007, 5);
        sparseIntArray.put(2131363316, 6);
        sparseIntArray.put(2131363157, 7);
        sparseIntArray.put(2131363155, 8);
        sparseIntArray.put(2131363304, 9);
        sparseIntArray.put(2131363311, 10);
        sparseIntArray.put(2131363490, 11);
    }

    public SearchResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private SearchResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppBarLayout) objArr[1], (DrawSystemBarFrameLayout) objArr[0], (FrameLayout) objArr[4], (ImageView) objArr[5], (ImageView) objArr[8], (FrameLayout) objArr[7], (LinearLayout) objArr[3], (FrameLayout) objArr[9], (ImageView) objArr[10], (TextView) objArr[6], (TabLayout) objArr[11], (ScrollStateViewPager) objArr[2]);
        this.mDirtyFlags = -1;
        this.appBar.setTag(null);
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
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
        }
    }
}
