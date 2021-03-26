package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.view.FollowStyleTextView;

public class ItemProductSeriesVerticalBindingImpl extends ItemProductSeriesVerticalBinding {
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
        sparseIntArray.put(2131363460, 5);
    }

    public ItemProductSeriesVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemProductSeriesVerticalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FollowStyleTextView) objArr[4], (ImageView) objArr[1], (LinearLayout) objArr[0], (ImageView) objArr[2], (TextView) objArr[5], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        this.maskView.setTag(null);
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
        if (197 == i) {
            setModel((Product) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesVerticalBinding
    public void setModel(Product product) {
        this.mModel = product;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesVerticalBinding
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
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionButton, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
        }
        if ((j & 5) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231691, 0, bool2, bool2, bool2, true, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            this.maskView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if ((j & 4) != 0) {
            String str4 = null;
            ViewBindingAdapters.clipView(this.iconView, str4, 4);
            ViewBindingAdapters.clipView(this.itemView, str4, 8);
        }
    }
}
