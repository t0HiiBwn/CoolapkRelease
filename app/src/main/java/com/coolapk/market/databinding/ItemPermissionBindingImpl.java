package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.model.PermissionItem;

public class ItemPermissionBindingImpl extends ItemPermissionBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemPermissionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemPermissionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.descriptionView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.nameView.setTag(null);
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
        if (217 != i) {
            return false;
        }
        setPermission((PermissionItem) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemPermissionBinding
    public void setPermission(PermissionItem permissionItem) {
        this.mPermission = permissionItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(217);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PermissionItem permissionItem = this.mPermission;
        int i = 0;
        CharSequence charSequence2 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (permissionItem != null) {
                CharSequence label = permissionItem.label();
                charSequence2 = permissionItem.description();
                charSequence = label;
            } else {
                charSequence = null;
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence2);
            if (i2 != 0) {
                j |= isEmpty ? 8 : 4;
            }
            if (isEmpty) {
                i = 8;
            }
        } else {
            charSequence = null;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.descriptionView, charSequence2);
            this.descriptionView.setVisibility(i);
            TextViewBindingAdapter.setText(this.nameView, charSequence);
        }
    }
}
