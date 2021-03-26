package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.Gift;

public class ItemGiftItemBindingImpl extends ItemGiftItemBinding {
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
        sparseIntArray.put(2131363571, 3);
        sparseIntArray.put(2131362612, 4);
        sparseIntArray.put(2131362617, 5);
        sparseIntArray.put(2131363147, 6);
        sparseIntArray.put(2131362611, 7);
    }

    public ItemGiftItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemGiftItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[2], (ImageView) objArr[1], (ProgressBar) objArr[5], (LinearLayout) objArr[0], (TextView) objArr[6], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.giftGetText.setTag(null);
        this.giftLogoView.setTag(null);
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
        if (131 != i) {
            return false;
        }
        setGift((Gift) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGiftItemBinding
    public void setGift(Gift gift) {
        this.mGift = gift;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.giftGetText, "colorAccent");
            String str = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.giftLogoView, str, null, 0, 0, bool, bool, bool, bool, bool, str, null, null, true, bool, bool, null, bool);
        }
    }
}
