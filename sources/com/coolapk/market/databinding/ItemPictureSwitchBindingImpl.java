package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class ItemPictureSwitchBindingImpl extends ItemPictureSwitchBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final HorizontalScrollView mboundView0;

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
        sparseIntArray.put(2131362251, 5);
        sparseIntArray.put(2131362252, 6);
        sparseIntArray.put(2131362254, 7);
        sparseIntArray.put(2131362255, 8);
    }

    public ItemPictureSwitchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemPictureSwitchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[5], (LinearLayout) objArr[6], (LinearLayout) objArr[7], (LinearLayout) objArr[8], (CheckedTextView) objArr[1], (CheckedTextView) objArr[2], (CheckedTextView) objArr[3], (CheckedTextView) objArr[4]);
        this.mDirtyFlags = -1;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) objArr[0];
        this.mboundView0 = horizontalScrollView;
        horizontalScrollView.setTag(null);
        this.textView1.setTag(null);
        this.textView2.setTag(null);
        this.textView4.setTag(null);
        this.textView5.setTag(null);
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
            ThemeBindingAdapters.setBackgroundTint(this.textView1, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView2, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView4, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView5, "colorAccent");
        }
    }
}
