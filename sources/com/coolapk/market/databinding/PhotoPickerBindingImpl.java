package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.google.android.material.appbar.AppBarLayout;

public class PhotoPickerBindingImpl extends PhotoPickerBinding {
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
        sparseIntArray.put(2131363235, 1);
        sparseIntArray.put(2131362069, 2);
        sparseIntArray.put(2131363610, 3);
        sparseIntArray.put(2131362409, 4);
        sparseIntArray.put(2131362153, 5);
        sparseIntArray.put(2131362133, 6);
        sparseIntArray.put(2131363551, 7);
        sparseIntArray.put(2131362718, 8);
        sparseIntArray.put(2131362494, 9);
        sparseIntArray.put(2131362876, 10);
        sparseIntArray.put(2131362423, 11);
    }

    public PhotoPickerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private PhotoPickerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppBarLayout) objArr[2], (LinearLayout) objArr[6], (LinearLayout) objArr[5], (DrawSystemBarFrameLayout) objArr[0], (RelativeLayout) objArr[4], (View) objArr[11], (ImageView) objArr[9], (ImageView) objArr[8], (ListView) objArr[10], (RecyclerView) objArr[1], (TextView) objArr[7], (Toolbar) objArr[3]);
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
