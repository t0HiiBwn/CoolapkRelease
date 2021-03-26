package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.widget.SquareImageView;

public class ItemPhotoPickerBindingImpl extends ItemPhotoPickerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final SquareImageView mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363139, 3);
        sparseIntArray.put(2131362222, 4);
    }

    public ItemPhotoPickerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemPhotoPickerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0], (FrameLayout) objArr[4], (ImageView) objArr[2], (FrameLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        SquareImageView squareImageView = (SquareImageView) objArr[1];
        this.mboundView1 = squareImageView;
        squareImageView.setTag(null);
        this.pickView.setTag(null);
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
        if (216 == i) {
            setPath((String) obj);
        } else if (241 != i) {
            return false;
        } else {
            setSelected((Boolean) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemPhotoPickerBinding
    public void setPath(String str) {
        this.mPath = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(216);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPhotoPickerBinding
    public void setSelected(Boolean bool) {
        this.mSelected = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(241);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int i = 0;
        String str = this.mPath;
        Boolean bool = this.mSelected;
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                if (safeUnbox) {
                    j3 = j | 16;
                    j2 = 64;
                } else {
                    j3 = j | 8;
                    j2 = 32;
                }
                j = j3 | j2;
            }
            drawable = AppCompatResources.getDrawable(this.pickView.getContext(), safeUnbox ? 2131231808 : 2131231809);
            i = safeUnbox ? 1711276032 : 570425344;
        } else {
            drawable = null;
        }
        if ((6 & j) != 0) {
            if (getBuildSdkInt() >= 23) {
                this.mboundView1.setForeground(Converters.convertColorToDrawable(i));
            }
            ImageViewBindingAdapter.setImageDrawable(this.pickView, drawable);
        }
        if ((j & 5) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str, null, 2131231691, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, true, null, bool2);
        }
    }
}
