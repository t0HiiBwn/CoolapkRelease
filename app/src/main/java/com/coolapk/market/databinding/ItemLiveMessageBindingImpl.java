package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.hanks.htextview.rainbow.RainbowTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemLiveMessageBindingImpl extends ItemLiveMessageBinding {
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
        sparseIntArray.put(2131362095, 2);
        sparseIntArray.put(2131362931, 3);
        sparseIntArray.put(2131362647, 4);
        sparseIntArray.put(2131363558, 5);
        sparseIntArray.put(2131363179, 6);
        sparseIntArray.put(2131362933, 7);
        sparseIntArray.put(2131363016, 8);
        sparseIntArray.put(2131363392, 9);
        sparseIntArray.put(2131363389, 10);
    }

    public ItemLiveMessageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemLiveMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundedImageView) objArr[2], (TableLayout) objArr[4], (LinearLayout) objArr[0], (LinearLayout) objArr[3], (TextView) objArr[7], (TextView) objArr[1], (Space) objArr[8], (RainbowTextView) objArr[6], (TextView) objArr[10], (LinearLayout) objArr[9], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        this.nameView.setTag(null);
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
            ThemeBindingAdapters.setTextColor(this.nameView, "colorAccent");
        }
    }
}
