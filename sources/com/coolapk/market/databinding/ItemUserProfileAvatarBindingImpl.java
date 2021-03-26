package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.HolderItem;

public class ItemUserProfileAvatarBindingImpl extends ItemUserProfileAvatarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final TextView mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemUserProfileAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemUserProfileAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2]);
        this.mDirtyFlags = -1;
        this.iconView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
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
        if (148 != i) {
            return false;
        }
        setHolderItem((HolderItem) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUserProfileAvatarBinding
    public void setHolderItem(HolderItem holderItem) {
        this.mHolderItem = holderItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(148);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HolderItem holderItem = this.mHolderItem;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        String string = (i == 0 || holderItem == null) ? null : holderItem.getString();
        if ((j & 2) != 0) {
            String str = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 0, 0, bool, bool, bool, bool, bool, str, null, null, bool, bool, true, null, bool);
            ViewBindingAdapters.clipView(this.iconView, str, 24);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, string);
        }
    }
}
