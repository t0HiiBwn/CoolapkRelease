package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemActionSheetDialogBindingImpl extends ItemActionSheetDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView2;

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
        sparseIntArray.put(2131362672, 4);
        sparseIntArray.put(2131363582, 5);
        sparseIntArray.put(2131363249, 6);
    }

    public ItemActionSheetDialogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemActionSheetDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (FrameLayout) objArr[1], (ImageView) objArr[4], (View) objArr[6], (RelativeLayout) objArr[0], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.bandageTextView.setTag(null);
        this.expandView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        this.rootView.setTag(null);
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
            String str = null;
            ViewBindingAdapters.clipView(this.bandageTextView, str, 4);
            ViewBindingAdapters.clipView(this.expandView, str, Double.valueOf(4.5d));
            ViewBindingAdapters.clipView(this.mboundView2, str, 4);
        }
    }
}
