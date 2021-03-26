package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.CouponInfo;

public class ItemAppViewBaseInfoCouponItemBindingImpl extends ItemAppViewBaseInfoCouponItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView1;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemAppViewBaseInfoCouponItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemAppViewBaseInfoCouponItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (TextView) objArr[3], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.couponFetchedView.setTag(null);
        this.fetchCouponView.setTag(null);
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
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
        if (59 != i) {
            return false;
        }
        setCoupon((CouponInfo) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppViewBaseInfoCouponItemBinding
    public void setCoupon(CouponInfo couponInfo) {
        this.mCoupon = couponInfo;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(59);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        boolean z;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CouponInfo couponInfo = this.mCoupon;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (couponInfo != null) {
                str2 = couponInfo.getTitle();
                str = couponInfo.getAdText();
                z = couponInfo.getIsClicked();
            } else {
                str2 = null;
                str = null;
                z = false;
            }
            if (i3 != 0) {
                if (z) {
                    j3 = j | 8;
                    j2 = 32;
                } else {
                    j3 = j | 4;
                    j2 = 16;
                }
                j = j3 | j2;
            }
            i = z ? 8 : 0;
            if (!z) {
                i2 = 8;
            }
        } else {
            str2 = null;
            str = null;
            i = 0;
        }
        if ((j & 3) != 0) {
            this.couponFetchedView.setVisibility(i2);
            this.fetchCouponView.setVisibility(i);
            TextViewBindingAdapter.setText(this.mboundView1, str2);
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.fetchCouponView, "capsule", null);
        }
    }
}
