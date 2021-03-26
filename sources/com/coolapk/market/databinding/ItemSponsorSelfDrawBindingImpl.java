package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.widget.NativeAdContainer;

public class ItemSponsorSelfDrawBindingImpl extends ItemSponsorSelfDrawBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"item_relative_child"}, new int[]{6}, new int[]{2131558903});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363016, 7);
        sparseIntArray.put(2131362262, 8);
        sparseIntArray.put(2131363632, 9);
        sparseIntArray.put(2131362382, 10);
        sparseIntArray.put(2131362925, 11);
        sparseIntArray.put(2131363745, 12);
        sparseIntArray.put(2131362309, 13);
        sparseIntArray.put(2131362313, 14);
        sparseIntArray.put(2131362314, 15);
        sparseIntArray.put(2131362315, 16);
    }

    public ItemSponsorSelfDrawBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private ItemSponsorSelfDrawBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[3], (ImageView) objArr[8], (LinearLayout) objArr[13], (ImageView) objArr[14], (ImageView) objArr[15], (ImageView) objArr[16], (ImageView) objArr[5], (MaxWidthFrameLayout) objArr[4], (CoolapkCardView) objArr[0], (TextView) objArr[10], (LinearLayout) objArr[1], (MediaView) objArr[11], (NativeAdContainer) objArr[7], (ItemRelativeChildBinding) objArr[6], (ImageView) objArr[2], (TextView) objArr[9], (FrameLayout) objArr[12]);
        this.mDirtyFlags = -1;
        this.adTextView.setTag(null);
        this.contentImageView.setTag(null);
        this.contentView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.itemView.setTag(null);
        setContainedBinding(this.relativeView);
        this.topImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.relativeView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.relativeView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (50 != i) {
            return false;
        }
        setClick((View.OnClickListener) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSponsorSelfDrawBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.relativeView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeRelativeView((ItemRelativeChildBinding) obj, i2);
    }

    private boolean onChangeRelativeView(ItemRelativeChildBinding itemRelativeChildBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 4) != 0) {
            String str = null;
            ViewBindingAdapters.clipView(this.adTextView, str, 2);
            ViewBindingAdapters.clipView(this.contentImageView, str, 8);
            ViewBindingAdapters.clipView(this.contentView, str, 8);
            ViewBindingAdapters.clipView(this.topImageView, "oval", null);
        }
        executeBindingsOn(this.relativeView);
    }
}
