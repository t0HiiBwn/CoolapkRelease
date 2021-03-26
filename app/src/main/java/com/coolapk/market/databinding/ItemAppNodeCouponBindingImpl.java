package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.CouponInfo;

public class ItemAppNodeCouponBindingImpl extends ItemAppNodeCouponBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView1;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemAppNodeCouponBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemAppNodeCouponBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (LinearLayout) objArr[3], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.fetchCouponTextView.setTag(null);
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
        if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (59 != i) {
            return false;
        } else {
            setCoupon((CouponInfo) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppNodeCouponBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAppNodeCouponBinding
    public void setCoupon(CouponInfo couponInfo) {
        this.mCoupon = couponInfo;
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
        int i;
        Resources resources;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        boolean z = false;
        CouponInfo couponInfo = this.mCoupon;
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (couponInfo != null) {
                String title = couponInfo.getTitle();
                str = couponInfo.getAdText();
                boolean isClicked = couponInfo.getIsClicked();
                str2 = title;
                z = isClicked;
            } else {
                str2 = null;
                str = null;
            }
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (z) {
                resources = this.fetchCouponTextView.getResources();
                i = 2131886823;
            } else {
                resources = this.fetchCouponTextView.getResources();
                i = 2131886821;
            }
            str3 = resources.getString(i);
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((6 & j) != 0) {
            TextViewBindingAdapter.setText(this.fetchCouponTextView, str3);
            TextViewBindingAdapter.setText(this.mboundView1, str2);
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
        if ((5 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.fetchCouponView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.itemView, null, 8);
        }
    }
}
