package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ProductPostViewBindingImpl extends ProductPostViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ProductPostViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ProductPostViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1], (LinearLayout) objArr[2], (LinearLayout) objArr[3], (LinearLayout) objArr[4], (LinearLayout) objArr[5], (LinearLayout) objArr[6], (LinearLayout) objArr[7], (FrameLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.bgView.setTag(null);
        this.itemView1.setTag(null);
        this.itemView2.setTag(null);
        this.itemView3.setTag(null);
        this.itemView4.setTag(null);
        this.itemView6.setTag(null);
        this.itemView7.setTag(null);
        this.parentView.setTag(null);
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
        if (50 != i) {
            return false;
        }
        setClick((View.OnClickListener) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ProductPostViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.bgView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView1, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView2, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView3, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView4, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView6, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView7, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.parentView, onClickListener, bool);
        }
    }
}
