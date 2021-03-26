package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.percentlayout.widget.PercentFrameLayout;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.ScaleImageView;

public class ItemRatingCardBindingImpl extends ItemRatingCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final PercentFrameLayout mboundView10;
    private final PercentFrameLayout mboundView2;
    private final PercentFrameLayout mboundView4;
    private final PercentFrameLayout mboundView6;
    private final PercentFrameLayout mboundView8;

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
        sparseIntArray.put(2131363295, 12);
        sparseIntArray.put(2131363208, 13);
        sparseIntArray.put(2131363211, 14);
        sparseIntArray.put(2131363227, 15);
        sparseIntArray.put(2131363206, 16);
        sparseIntArray.put(2131363205, 17);
        sparseIntArray.put(2131363204, 18);
        sparseIntArray.put(2131363203, 19);
        sparseIntArray.put(2131363202, 20);
    }

    public ItemRatingCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private ItemRatingCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (ScaleImageView) objArr[1], (TextView) objArr[20], (TextView) objArr[19], (TextView) objArr[18], (TextView) objArr[17], (TextView) objArr[16], (RatingBar) objArr[13], (TextView) objArr[14], (ImageView) objArr[11], (ImageView) objArr[9], (ImageView) objArr[7], (ImageView) objArr[5], (ImageView) objArr[3], (TableLayout) objArr[15], (TextView) objArr[12]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        this.logoView.setTag(null);
        PercentFrameLayout percentFrameLayout = (PercentFrameLayout) objArr[10];
        this.mboundView10 = percentFrameLayout;
        percentFrameLayout.setTag(null);
        PercentFrameLayout percentFrameLayout2 = (PercentFrameLayout) objArr[2];
        this.mboundView2 = percentFrameLayout2;
        percentFrameLayout2.setTag(null);
        PercentFrameLayout percentFrameLayout3 = (PercentFrameLayout) objArr[4];
        this.mboundView4 = percentFrameLayout3;
        percentFrameLayout3.setTag(null);
        PercentFrameLayout percentFrameLayout4 = (PercentFrameLayout) objArr[6];
        this.mboundView6 = percentFrameLayout4;
        percentFrameLayout4.setTag(null);
        PercentFrameLayout percentFrameLayout5 = (PercentFrameLayout) objArr[8];
        this.mboundView8 = percentFrameLayout5;
        percentFrameLayout5.setTag(null);
        this.ratingImageView1.setTag(null);
        this.ratingImageView2.setTag(null);
        this.ratingImageView3.setTag(null);
        this.ratingImageView4.setTag(null);
        this.ratingImageView5.setTag(null);
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
            ThemeBindingAdapters.setTintColor(this.logoView, "colorAccent");
            String str = null;
            ViewBindingAdapters.clipView(this.mboundView10, str, 4);
            ViewBindingAdapters.clipView(this.mboundView2, str, 4);
            ViewBindingAdapters.clipView(this.mboundView4, str, 4);
            ViewBindingAdapters.clipView(this.mboundView6, str, 4);
            ViewBindingAdapters.clipView(this.mboundView8, str, 4);
            ViewBindingAdapters.clipView(this.ratingImageView1, str, 4);
            ViewBindingAdapters.clipView(this.ratingImageView2, str, 4);
            ViewBindingAdapters.clipView(this.ratingImageView3, str, 4);
            ViewBindingAdapters.clipView(this.ratingImageView4, str, 4);
            ViewBindingAdapters.clipView(this.ratingImageView5, str, 4);
        }
    }
}
