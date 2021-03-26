package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.viewholder.LargeScrollCardGoodsItemViewHolder;

public class ItemLargeScrollCardGoodsItemBindingImpl extends ItemLargeScrollCardGoodsItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemLargeScrollCardGoodsItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemLargeScrollCardGoodsItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[4], (CardView) objArr[0], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.itemView.setTag(null);
        this.logoView.setTag(null);
        this.subTitleView.setTag(null);
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
            setModel((LargeScrollCardGoodsItemViewHolder) obj);
        } else if (287 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemLargeScrollCardGoodsItemBinding
    public void setModel(LargeScrollCardGoodsItemViewHolder largeScrollCardGoodsItemViewHolder) {
        updateRegistration(0, largeScrollCardGoodsItemViewHolder);
        this.mModel = largeScrollCardGoodsItemViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemLargeScrollCardGoodsItemBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((LargeScrollCardGoodsItemViewHolder) obj, i2);
    }

    private boolean onChangeModel(LargeScrollCardGoodsItemViewHolder largeScrollCardGoodsItemViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LargeScrollCardGoodsItemViewHolder largeScrollCardGoodsItemViewHolder = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        int i2 = 0;
        if ((j & 7) != 0) {
            String logo = largeScrollCardGoodsItemViewHolder != null ? largeScrollCardGoodsItemViewHolder.getLogo() : null;
            int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (largeScrollCardGoodsItemViewHolder != null) {
                    String title = largeScrollCardGoodsItemViewHolder.getTitle();
                    i = largeScrollCardGoodsItemViewHolder.getTitleLine();
                    str2 = largeScrollCardGoodsItemViewHolder.getActionText();
                    str6 = largeScrollCardGoodsItemViewHolder.getSubTitle();
                    i2 = largeScrollCardGoodsItemViewHolder.isFollow();
                    str5 = title;
                } else {
                    str5 = null;
                    str2 = null;
                    str6 = null;
                    i = 0;
                }
                if (i3 != 0) {
                    j |= i2 != 0 ? 16 : 8;
                }
                str3 = i2 != 0 ? "textColorSecondary" : "white";
                str = logo;
                i2 = i;
                str4 = str6;
            } else {
                str = logo;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((5 & j) != 0) {
            TextViewBindingAdapter.setText(this.actionView, str2);
            ThemeBindingAdapters.setTextColor(this.actionView, str3);
            TextViewBindingAdapter.setText(this.subTitleView, str4);
            this.titleView.setLines(i2);
            TextViewBindingAdapter.setText(this.titleView, str5);
        }
        if ((j & 7) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str, AppCompatResources.getDrawable(this.logoView.getContext(), 2131231363), 0, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        }
    }
}
