package com.coolapk.market.databinding;

import android.text.TextUtils;
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
import com.coolapk.market.viewholder.GoodsSimpleInfo;

public class ItemFeedGoodsInfoBindingImpl extends ItemFeedGoodsInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView3;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFeedGoodsInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemFeedGoodsInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (LinearLayout) objArr[0], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.itemView.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
            setModel((GoodsSimpleInfo) obj);
        } else if (272 == i) {
            setSubTitle((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedGoodsInfoBinding
    public void setModel(GoodsSimpleInfo goodsSimpleInfo) {
        this.mModel = goodsSimpleInfo;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedGoodsInfoBinding
    public void setSubTitle(String str) {
        this.mSubTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(272);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedGoodsInfoBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        GoodsSimpleInfo goodsSimpleInfo = this.mModel;
        String str6 = this.mSubTitle;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (goodsSimpleInfo != null) {
                str4 = goodsSimpleInfo.getPrice();
                str2 = goodsSimpleInfo.getTitle();
                str5 = goodsSimpleInfo.getPic();
            } else {
                str5 = null;
                str4 = null;
                str2 = null;
            }
            str3 = "￥" + str4;
            boolean isEmpty = TextUtils.isEmpty(str4);
            if (i2 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            i = isEmpty ? 8 : 0;
            str = str5;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i3 = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        if ((12 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
        }
        if ((8 & j) != 0) {
            ViewBindingAdapters.clipView(this.actionView, "capsule", null);
            String str7 = null;
            ViewBindingAdapters.clipView(this.itemView, str7, 8);
            ViewBindingAdapters.clipView(this.mboundView1, str7, 8);
        }
        if ((j & 9) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str, null, 2131231419, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            TextViewBindingAdapter.setText(this.mboundView3, str3);
            this.mboundView3.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str6);
        }
    }
}
