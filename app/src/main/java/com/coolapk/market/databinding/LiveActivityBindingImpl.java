package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public class LiveActivityBindingImpl extends LiveActivityBinding {
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
        sparseIntArray.put(2131362067, 1);
        sparseIntArray.put(2131362264, 2);
        sparseIntArray.put(2131363130, 3);
        sparseIntArray.put(2131363588, 4);
        sparseIntArray.put(2131363481, 5);
        sparseIntArray.put(2131363934, 6);
        sparseIntArray.put(2131363137, 7);
        sparseIntArray.put(2131363135, 8);
        sparseIntArray.put(2131363136, 9);
        sparseIntArray.put(2131363912, 10);
    }

    public LiveActivityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private LiveActivityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppBarLayout) objArr[1], (CollapsingToolbarFixLayout) objArr[2], (DrawSystemBarFrameLayout) objArr[0], (FrameLayout) objArr[3], (ImageView) objArr[8], (TextView) objArr[9], (FrameLayout) objArr[7], (TabLayout) objArr[5], (Toolbar) objArr[4], (LinearLayout) objArr[10], (ViewPager) objArr[6]);
        this.mDirtyFlags = -1;
        this.contentView.setTag(null);
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
