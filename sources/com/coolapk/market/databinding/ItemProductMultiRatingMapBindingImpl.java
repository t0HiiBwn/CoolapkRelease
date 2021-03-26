package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.RatingBarBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.view.ProductScoreView;

public class ItemProductMultiRatingMapBindingImpl extends ItemProductMultiRatingMapBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362779, 5);
        sparseIntArray.put(2131363211, 6);
        sparseIntArray.put(2131363158, 7);
    }

    public ItemProductMultiRatingMapBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemProductMultiRatingMapBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (LinearLayout) objArr[5], (LinearLayout) objArr[1], (ProductScoreView) objArr[7], (RatingBar) objArr[3], (TextView) objArr[6], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.linearView.setTag(null);
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        this.ratingBar.setTag(null);
        this.scoreView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemProductMultiRatingMapBinding
    public void setModel(Product product) {
        this.mModel = product;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductMultiRatingMapBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Product product = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        float f = 0.0f;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (product != null) {
                f = product.getRatingAverageScore();
            }
            f /= 2.0f;
        }
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.actionView, "colorAccent");
            ViewBindingAdapters.clipView(this.actionView, "capsule", null);
            ViewBindingAdapters.clipView(this.linearView, null, 4);
            ThemeBindingAdapters.setTextColor(this.scoreView, "colorAccent");
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, null);
        }
        if (i != 0) {
            RatingBarBindingAdapter.setRating(this.ratingBar, f);
        }
    }
}
