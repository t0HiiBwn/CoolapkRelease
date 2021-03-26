package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.view.ControlGifImageView;
import com.coolapk.market.widget.view.DividerView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public class ItemProductMediaBindingImpl extends ItemProductMediaBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363940, 2);
        sparseIntArray.put(2131362423, 3);
    }

    public ItemProductMediaBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemProductMediaBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (DividerView) objArr[3], (ControlGifImageView) objArr[1], (MaxWidthFrameLayout) objArr[0], (FrameLayout) objArr[2]);
        this.mDirtyFlags = -1;
        this.imageView.setTag(null);
        this.itemView.setTag(null);
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
        if (160 != i) {
            return false;
        }
        setImgUrl((String) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemProductMediaBinding
    public void setImgUrl(String str) {
        this.mImgUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(160);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mImgUrl;
        int i = 0;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            boolean z = str == null;
            if (i2 != 0) {
                j |= z ? 8 : 4;
            }
            if (z) {
                i = 4;
            }
        }
        if ((3 & j) != 0) {
            this.imageView.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str, null, 2131231702, 0, bool, bool, bool, true, bool, null, null, null, bool, true, bool, null, bool);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.imageView, null, 2);
        }
    }
}
