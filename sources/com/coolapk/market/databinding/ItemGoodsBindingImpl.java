package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Goods;

public class ItemGoodsBindingImpl extends ItemGoodsBinding {
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
        sparseIntArray.put(2131362779, 5);
        sparseIntArray.put(2131362322, 6);
        sparseIntArray.put(2131363519, 7);
        sparseIntArray.put(2131361982, 8);
    }

    public ItemGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[8], (LinearLayout) objArr[6], (CoolapkCardView) objArr[0], (TextView) objArr[3], (TextView) objArr[4], (LinearLayout) objArr[5], (ImageView) objArr[1], (Space) objArr[7], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.discountPriceView.setTag(null);
        this.goShoppingView.setTag(null);
        this.picView.setTag(null);
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
            setModel((Goods) obj);
        } else if (288 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsBinding
    public void setModel(Goods goods) {
        this.mModel = goods;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Goods goods = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if ((j & 5) == 0 || goods == null) {
                str3 = null;
                str2 = null;
                str = null;
            } else {
                str3 = goods.getBuyShowText();
                str2 = goods.getGoodsTitle();
                str = goods.getPromoTitle();
            }
            str4 = goods != null ? goods.getGoodsPic() : null;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.discountPriceView, str);
            TextViewBindingAdapter.setText(this.goShoppingView, str3);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.picView, str4, null, 0, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        }
    }
}
