package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Entity;

public class ItemTextLinkItemBindingImpl extends ItemTextLinkItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemTextLinkItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemTextLinkItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        this.subTitleView.setTag(null);
        this.textView.setTag(null);
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
        if (93 != i) {
            return false;
        }
        setEntity((Entity) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTextLinkItemBinding
    public void setEntity(Entity entity) {
        this.mEntity = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(93);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mEntity;
        boolean z = false;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (entity != null) {
                str3 = entity.getSubTitle();
                str2 = entity.getPic();
                str = entity.getTitle();
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            if (str2 == null) {
                z = true;
            }
            if (i != 0) {
                j = z ? j | 8 : j | 4;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((8 & j) == 0 || entity == null) {
            str4 = null;
        } else {
            str4 = entity.getLogo();
        }
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (z) {
                str2 = str4;
            }
            str5 = str2;
        } else {
            str5 = null;
        }
        if (i2 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str5, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.subTitleView, str3);
            TextViewBindingAdapter.setText(this.textView, str);
        }
    }
}
