package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.view.ControlGifImageView;
import com.coolapk.market.widget.view.DividerLineView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;

public class ItemFeedImageBindingImpl extends ItemFeedImageBinding {
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
        sparseIntArray.put(2131362617, 2);
        sparseIntArray.put(2131363160, 3);
        sparseIntArray.put(2131362423, 4);
    }

    public ItemFeedImageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemFeedImageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (DividerLineView) objArr[4], (FrameLayout) objArr[0], (TextView) objArr[2], (ControlGifImageView) objArr[1], (ImageLoadProgressBar) objArr[3]);
        this.mDirtyFlags = -1;
        this.frameView.setTag(null);
        this.imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (130 == i) {
            setGifImage((String) obj);
        } else if (160 != i) {
            return false;
        } else {
            setImgUrl((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedImageBinding
    public void setGifImage(String str) {
        this.mGifImage = str;
    }

    @Override // com.coolapk.market.databinding.ItemFeedImageBinding
    public void setImgUrl(String str) {
        this.mImgUrl = str;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.imageView, null, 8);
        }
    }
}
