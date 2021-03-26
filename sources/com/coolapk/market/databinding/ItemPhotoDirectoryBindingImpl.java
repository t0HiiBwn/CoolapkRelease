package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.SquareImageView;

public class ItemPhotoDirectoryBindingImpl extends ItemPhotoDirectoryBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final SquareImageView mboundView1;
    private final ImageView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363582, 3);
        sparseIntArray.put(2131363533, 4);
    }

    public ItemPhotoDirectoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemPhotoDirectoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        SquareImageView squareImageView = (SquareImageView) objArr[1];
        this.mboundView1 = squareImageView;
        squareImageView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemPhotoDirectoryBinding
    public void setPath(String str) {
        this.mPath = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(216);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPhotoDirectoryBinding
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
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mPath;
        Boolean bool = this.mSelected;
        int i2 = 0;
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 16 : 8;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
            i = i2;
        } else {
            i = 0;
        }
        if ((5 & j) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str, null, 2131231691, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, true, null, bool2);
        }
        if ((4 & j) != 0) {
            ThemeBindingAdapters.setTintColor(this.mboundView2, "colorAccent");
        }
        if ((j & 6) != 0) {
            this.mboundView2.setVisibility(i);
        }
    }
}
