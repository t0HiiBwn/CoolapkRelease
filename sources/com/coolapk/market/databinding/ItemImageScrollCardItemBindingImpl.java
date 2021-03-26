package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemImageScrollCardItemBindingImpl extends ItemImageScrollCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemImageScrollCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemImageScrollCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AspectRatioImageView) objArr[1], (CardView) objArr[0]);
        this.mDirtyFlags = -1;
        this.imageView.setTag(null);
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
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
        if (156 != i) {
            return false;
        }
        setImageCard((Entity) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemImageScrollCardItemBinding
    public void setImageCard(Entity entity) {
        this.mImageCard = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(156);
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
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mImageCard;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (entity != null) {
                str3 = entity.getPic();
                str2 = entity.getTitle();
                str6 = entity.getSubTitle();
            } else {
                str3 = null;
                str2 = null;
                str6 = null;
            }
            int i4 = str3 == null ? 1 : 0;
            boolean isEmpty = TextUtils.isEmpty(str6);
            if (i3 != 0) {
                j = i4 != 0 ? j | 32 : j | 16;
            }
            if ((j & 3) != 0) {
                j |= isEmpty ? 8 : 4;
            }
            if (isEmpty) {
                i2 = 8;
            }
            i = i2;
            str = str6;
            i2 = i4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((32 & j) == 0 || entity == null) {
            str4 = null;
        } else {
            str4 = entity.getLogo();
        }
        int i5 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (i2 != 0) {
                str3 = str4;
            }
            str5 = str3;
        } else {
            str5 = null;
        }
        if (i5 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str5, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231363), 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, true, bool, null, bool);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapter.setText(this.mboundView3, str);
            this.mboundView3.setVisibility(i);
        }
    }
}
