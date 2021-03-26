package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.model.HolderItem;

public class ItemBlackListBindingImpl extends ItemBlackListBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362200, 3);
        sparseIntArray.put(2131363478, 4);
    }

    public ItemBlackListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemBlackListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (TextView) objArr[2], (SwitchCompat) objArr[4], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.descriptionView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.titleView.setTag(null);
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
        if (147 != i) {
            return false;
        }
        setHolder((HolderItem) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemBlackListBinding
    public void setHolder(HolderItem holderItem) {
        this.mHolder = holderItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(147);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HolderItem holderItem = this.mHolder;
        String str2 = null;
        int i = 0;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (holderItem != null) {
                String string = holderItem.getString();
                str2 = holderItem.getValue();
                str = string;
            } else {
                str = null;
            }
            boolean z = str2 == null;
            if (i2 != 0) {
                j |= z ? 8 : 4;
            }
            if (z) {
                i = 8;
            }
        } else {
            str = null;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.descriptionView, str2);
            this.descriptionView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str);
        }
    }
}
