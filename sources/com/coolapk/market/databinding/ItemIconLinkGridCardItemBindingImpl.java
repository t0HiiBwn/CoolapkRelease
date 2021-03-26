package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Entity;

public class ItemIconLinkGridCardItemBindingImpl extends ItemIconLinkGridCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemIconLinkGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemIconLinkGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        this.titleView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemIconLinkGridCardItemBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mEntity;
        boolean z = false;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (entity != null) {
                str2 = entity.getPic();
                str = entity.getTitle();
            } else {
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
            str2 = null;
            str = null;
        }
        if ((8 & j) == 0 || entity == null) {
            str3 = null;
        } else {
            str3 = entity.getLogo();
        }
        int i2 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (z) {
                str2 = str3;
            }
            str4 = str2;
        } else {
            str4 = null;
        }
        if (i2 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str4, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231363), 0, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.titleView, str);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.iconView, null, 6);
        }
    }
}
