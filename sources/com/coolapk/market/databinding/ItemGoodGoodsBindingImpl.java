package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemGoodGoodsBindingImpl extends ItemGoodGoodsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView4;
    private final View mboundView6;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemGoodGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemGoodGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (FrameLayout) objArr[0], (LinearLayout) objArr[1], (ImageView) objArr[2], (CoolEllipsizeTextView) objArr[3], (CoolEllipsizeTextView) objArr[7]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.bgView.setTag(null);
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        View view2 = (View) objArr[6];
        this.mboundView6 = view2;
        view2.setTag(null);
        this.titleView.setTag(null);
        this.versionView.setTag(null);
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
            setModel((GoodsListItem) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGoodGoodsBinding
    public void setModel(GoodsListItem goodsListItem) {
        this.mModel = goodsListItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodGoodsBinding
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
        int i;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        GoodsListItem goodsListItem = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (goodsListItem != null) {
                str4 = goodsListItem.getProductGoodsTitle();
                str5 = goodsListItem.getPrice();
                str2 = goodsListItem.getNote();
                str6 = goodsListItem.getProductGoodsLogo();
            } else {
                str6 = null;
                str4 = null;
                str5 = null;
                str2 = null;
            }
            str3 = "￥" + str5;
            boolean isEmpty = TextUtils.isEmpty(str5);
            boolean isEmpty2 = TextUtils.isEmpty(str2);
            if (i3 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if ((j & 5) != 0) {
                j |= isEmpty2 ? 64 : 32;
            }
            int i4 = isEmpty ? 8 : 0;
            str = str6;
            i2 = isEmpty2 ? 8 : 0;
            i = i4;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((j & 6) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.actionView, "capsule", null);
            String str7 = null;
            ViewBindingAdapters.clipView(this.cardView, str7, 8);
            ViewBindingAdapters.clipView(this.iconView, str7, 8);
        }
        if ((j & 5) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231363, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, true, null, bool2);
            TextViewBindingAdapter.setText(this.mboundView4, str3);
            this.mboundView4.setVisibility(i);
            this.mboundView6.setVisibility(i2);
            TextViewBindingAdapter.setText(this.titleView, str4);
            TextViewBindingAdapter.setText(this.versionView, str2);
            this.versionView.setVisibility(i2);
        }
    }
}
