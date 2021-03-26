package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;

public class AppPhotoThumbnailBindingImpl extends AppPhotoThumbnailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public AppPhotoThumbnailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, sIncludes, sViewsWithIds));
    }

    private AppPhotoThumbnailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[0]);
        this.mDirtyFlags = -1;
        this.image.setTag(null);
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
        if (212 == i) {
            setOnImageLoad((OnImageLoadListener) obj);
        } else if (291 != i) {
            return false;
        } else {
            setUrl((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AppPhotoThumbnailBinding
    public void setOnImageLoad(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoad = onImageLoadListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(212);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AppPhotoThumbnailBinding
    public void setUrl(String str) {
        this.mUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(291);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        OnImageLoadListener onImageLoadListener = this.mOnImageLoad;
        String str = this.mUrl;
        if ((j & 7) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.image, str, null, 2131231691, 2131231691, bool, bool, bool, bool, bool, null, onImageLoadListener, null, bool, true, bool, null, bool);
        }
    }
}
