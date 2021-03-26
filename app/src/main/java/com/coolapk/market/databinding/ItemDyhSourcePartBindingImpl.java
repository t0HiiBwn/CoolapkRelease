package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public class ItemDyhSourcePartBindingImpl extends ItemDyhSourcePartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362643, 1);
        sparseIntArray.put(2131362306, 2);
        sparseIntArray.put(2131363397, 3);
    }

    public ItemDyhSourcePartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemDyhSourcePartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[2], (FrameLayout) objArr[1], (LinearLayout) objArr[0], (Space) objArr[3]);
        this.mDirtyFlags = -1;
        this.sourceContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
    public boolean setVariable(int i, Object obj) {
        if (197 != i) {
            return false;
        }
        setModel((DyhViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyhSourcePartBinding
    public void setModel(DyhViewModel dyhViewModel) {
        this.mModel = dyhViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((DyhViewModel) obj, i2);
    }

    private boolean onChangeModel(DyhViewModel dyhViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
