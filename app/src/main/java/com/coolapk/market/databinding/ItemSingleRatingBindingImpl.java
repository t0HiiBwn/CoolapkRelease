package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemSingleRatingBindingImpl extends ItemSingleRatingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363280, 3);
        sparseIntArray.put(2131363194, 4);
    }

    public ItemSingleRatingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemSingleRatingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (BadBadRatingBar) objArr[4], (TextView) objArr[3], (RoundedImageView) objArr[1]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        this.userAvatarView.setTag(null);
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
        if (189 == i) {
            setLogo((String) obj);
        } else if (43 != i) {
            return false;
        } else {
            setBuyStatus(((Integer) obj).intValue());
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSingleRatingBinding
    public void setLogo(String str) {
        this.mLogo = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(189);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemSingleRatingBinding
    public void setBuyStatus(int i) {
        this.mBuyStatus = i;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(43);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mLogo;
        int i = this.mBuyStatus;
        int i2 = 0;
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            if (i3 != 0) {
                j |= z ? 16 : 8;
            }
            if (!z) {
                i2 = 8;
            }
        }
        if ((6 & j) != 0) {
            this.mboundView2.setVisibility(i2);
        }
        if ((4 & j) != 0) {
            ViewBindingAdapters.clipView(this.mboundView2, null, 3);
        }
        if ((j & 5) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        }
    }
}
