package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Live;

public class ItemLiveImageTextCardBindingImpl extends ItemLiveImageTextCardBinding {
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
        sparseIntArray.put(2131362323, 2);
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131363582, 4);
        sparseIntArray.put(2131363034, 5);
        sparseIntArray.put(2131361876, 6);
    }

    public ItemLiveImageTextCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemLiveImageTextCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (CoolapkCardView) objArr[2], (ImageView) objArr[1], (FrameLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[4]);
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
        if (184 != i) {
            return false;
        }
        setLive((Live) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemLiveImageTextCardBinding
    public void setLive(Live live) {
        this.mLive = live;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(184);
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
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        String picUrl = (i == 0 || live == null) ? null : live.getPicUrl();
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, picUrl, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231696), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, bool, bool, null, bool);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.imageView, null, 8);
        }
    }
}
