package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.google.android.material.appbar.AppBarLayout;

public class UserPickBindingImpl extends UserPickBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"fab"}, new int[]{3}, new int[]{2131558549});
        includedLayouts.setIncludes(1, new String[]{"search_back_header"}, new int[]{2}, new int[]{2131559122});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363307, 4);
        sparseIntArray.put(2131363315, 5);
        sparseIntArray.put(2131363314, 6);
    }

    public UserPickBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private UserPickBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AppBarLayout) objArr[1], (FabBinding) objArr[3], (CoordinatorLayout) objArr[0], (FrameLayout) objArr[4], (SearchBackHeaderBinding) objArr[2], (FrameLayout) objArr[6], (LinearLayout) objArr[5]);
        this.mDirtyFlags = -1;
        this.appBar.setTag(null);
        setContainedBinding(this.fab);
        this.mainContent.setTag(null);
        setContainedBinding(this.searchHeader);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.searchHeader.invalidateAll();
        this.fab.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.searchHeader.hasPendingBindings() && !this.fab.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.searchHeader.setLifecycleOwner(lifecycleOwner);
        this.fab.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeFab((FabBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeSearchHeader((SearchBackHeaderBinding) obj, i2);
    }

    private boolean onChangeFab(FabBinding fabBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSearchHeader(SearchBackHeaderBinding searchBackHeaderBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
        }
        executeBindingsOn(this.searchHeader);
        executeBindingsOn(this.fab);
    }
}
