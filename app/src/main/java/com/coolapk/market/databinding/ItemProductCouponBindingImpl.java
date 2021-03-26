package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.ProductCoupon;
import com.coolapk.market.widget.DividerView;

public class ItemProductCouponBindingImpl extends ItemProductCouponBinding {
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
        sparseIntArray.put(2131362755, 7);
        sparseIntArray.put(2131362388, 8);
        sparseIntArray.put(2131362756, 9);
        sparseIntArray.put(2131363257, 10);
        sparseIntArray.put(2131361896, 11);
        sparseIntArray.put(2131362389, 12);
        sparseIntArray.put(2131362392, 13);
    }

    public ItemProductCouponBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemProductCouponBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (DividerView) objArr[11], (TextView) objArr[4], (ImageView) objArr[8], (ImageView) objArr[12], (RecyclerView) objArr[13], (TextView) objArr[6], (LinearLayout) objArr[7], (ConstraintLayout) objArr[9], (LinearLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.dateView.setTag(null);
        this.fetchCouponView.setTag(null);
        this.itemView.setTag(null);
        this.moneyView.setTag(null);
        this.priceView.setTag(null);
        this.titleView.setTag(null);
        this.useCouponPriceView.setTag(null);
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
        setCoupon((ProductCoupon) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemProductCouponBinding
    public void setCoupon(ProductCoupon productCoupon) {
        this.mCoupon = productCoupon;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(59);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ProductCoupon productCoupon = this.mCoupon;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (productCoupon != null) {
                str4 = productCoupon.getPrice();
                str3 = productCoupon.getExpireDate();
                str2 = productCoupon.getWorthMoney();
                str = productCoupon.getCouponName();
                str5 = productCoupon.getUseCouponPrice();
            } else {
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            boolean isEmpty = str4 != null ? str4.isEmpty() : false;
            if (str5 != null) {
                z = str5.isEmpty();
            } else {
                z = false;
            }
            boolean z2 = !isEmpty;
            boolean z3 = !z;
            if (i3 != 0) {
                j |= z2 ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j |= z3 ? 32 : 16;
            }
            int i4 = z2 ? 0 : 8;
            if (!z3) {
                i2 = 8;
            }
            i = i2;
            i2 = i4;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((3 & j) != 0) {
            TextViewBindingAdapter.setText(this.dateView, str3);
            TextViewBindingAdapter.setText(this.moneyView, str2);
            TextViewBindingAdapter.setText(this.priceView, str4);
            this.priceView.setVisibility(i2);
            TextViewBindingAdapter.setText(this.titleView, str);
            this.useCouponPriceView.setVisibility(i);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.fetchCouponView, "capsule", null);
        }
    }
}
