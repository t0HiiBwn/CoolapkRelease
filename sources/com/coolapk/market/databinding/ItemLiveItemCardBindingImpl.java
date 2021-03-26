package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Live;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemLiveItemCardBindingImpl extends ItemLiveItemCardBinding {
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
        sparseIntArray.put(2131362329, 2);
        sparseIntArray.put(2131363600, 3);
        sparseIntArray.put(2131363604, 4);
        sparseIntArray.put(2131363451, 5);
        sparseIntArray.put(2131363579, 6);
        sparseIntArray.put(2131363048, 7);
        sparseIntArray.put(2131361877, 8);
    }

    public ItemLiveItemCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemLiveItemCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (CoolapkCardView) objArr[2], (AspectRatioImageView) objArr[1], (FrameLayout) objArr[0], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[4]);
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
        if (185 != i) {
            return false;
        }
        setLive((Live) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemLiveItemCardBinding
    public void setLive(Live live) {
        this.mLive = live;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(185);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Live live = this.mLive;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String picUrl = (i == 0 || live == null) ? null : live.getPicUrl();
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, picUrl, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231707), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, bool, bool, null, bool);
        }
    }
}
