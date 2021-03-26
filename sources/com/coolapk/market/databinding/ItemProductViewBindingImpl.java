package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Product;

public class ItemProductViewBindingImpl extends ItemProductViewBinding {
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
        sparseIntArray.put(2131363478, 7);
        sparseIntArray.put(2131363296, 8);
        sparseIntArray.put(2131363295, 9);
        sparseIntArray.put(2131363208, 10);
        sparseIntArray.put(2131363245, 11);
        sparseIntArray.put(2131363033, 12);
    }

    public ItemProductViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ItemProductViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (ImageView) objArr[2], (LinearLayout) objArr[1], (ImageView) objArr[3], (TextView) objArr[12], (RatingBar) objArr[10], (LinearLayout) objArr[11], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[9], (LinearLayout) objArr[8], (TextView) objArr[7], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        this.maskView.setTag(null);
        this.releaseTimeTitle.setTag(null);
        this.releaseTimeView.setTag(null);
        this.titleView.setTag(null);
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
        if (198 == i) {
            setModel((Product) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemProductViewBinding
    public void setModel(Product product) {
        this.mModel = product;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        boolean z;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Product product = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (product != null) {
                str3 = product.getSquareLogo();
                z = product.isReleased();
                str2 = product.getTitle();
            } else {
                str2 = null;
                str3 = null;
                z = false;
            }
            boolean z2 = !z;
            if (i2 != 0) {
                j |= z2 ? 16 : 8;
            }
            if (!z2) {
                i = 8;
            }
            str = str3;
        } else {
            str2 = null;
            str = null;
        }
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((5 & j) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231702, 0, bool, bool, bool, true, bool, null, null, null, bool, bool, bool, null, bool);
            this.maskView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.iconView, null, 4);
            ThemeBindingAdapters.setTextColor(this.releaseTimeTitle, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.releaseTimeView, "colorAccent");
        }
        if (i3 != 0) {
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, null);
        }
    }
}
