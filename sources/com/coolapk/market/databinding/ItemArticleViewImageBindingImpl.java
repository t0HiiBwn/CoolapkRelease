package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import com.coolapk.market.widget.view.ScalingImageView;

public class ItemArticleViewImageBindingImpl extends ItemArticleViewImageBinding {
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
        sparseIntArray.put(2131363160, 4);
        sparseIntArray.put(2131362382, 5);
    }

    public ItemArticleViewImageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemArticleViewImageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (ScalingImageView) objArr[1], (TextView) objArr[3], (FrameLayout) objArr[2], (LinearLayout) objArr[0], (ImageLoadProgressBar) objArr[4]);
        this.mDirtyFlags = -1;
        this.ivCover.setTag(null);
        this.longPicText.setTag(null);
        this.longPicTextContainer.setTag(null);
        this.lvTop.setTag(null);
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
            String str = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.ivCover, str, null, 0, 0, bool, bool, bool, bool, bool, str, null, null, bool, true, bool, null, bool);
            ViewBindingAdapters.clipView(this.ivCover, str, 2);
            ThemeBindingAdapters.setTextColor(this.longPicText, "colorAccent");
            ViewBindingAdapters.clipView(this.longPicTextContainer, str, 2);
        }
    }
}
