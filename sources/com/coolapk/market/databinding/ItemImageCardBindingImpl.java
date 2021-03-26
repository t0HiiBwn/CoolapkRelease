package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemImageCardBindingImpl extends ItemImageCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemImageCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemImageCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AspectRatioImageView) objArr[1], (FrameLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.imageView.setTag(null);
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
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
        if (44 != i) {
            return false;
        }
        setCard((Entity) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemImageCardBinding
    public void setCard(Entity entity) {
        this.mCard = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mCard;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (entity != null) {
                str2 = entity.getTitle();
                str = entity.getPic();
            } else {
                str2 = null;
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            int i4 = str == null ? 1 : 0;
            if (i3 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j = i4 != 0 ? j | 8 : j | 4;
            }
            if (isEmpty) {
                i2 = 8;
            }
            i = i2;
            i2 = i4;
        } else {
            str2 = null;
            str = null;
            i = 0;
        }
        if ((8 & j) == 0 || entity == null) {
            str3 = null;
        } else {
            str3 = entity.getLogo();
        }
        int i5 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (i2 != 0) {
                str = str3;
            }
            str4 = str;
        } else {
            str4 = null;
        }
        if (i5 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str4, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231696), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, true, bool, null, bool);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            this.mboundView2.setVisibility(i);
        }
    }
}
