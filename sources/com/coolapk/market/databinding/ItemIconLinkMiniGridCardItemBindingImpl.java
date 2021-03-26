package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Entity;

public class ItemIconLinkMiniGridCardItemBindingImpl extends ItemIconLinkMiniGridCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final Space mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemIconLinkMiniGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemIconLinkMiniGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        Space space = (Space) objArr[2];
        this.mboundView2 = space;
        space.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemIconLinkMiniGridCardItemBinding
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
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mEntity;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (entity != null) {
                str2 = entity.getPic();
                str = entity.getTitle();
            } else {
                str2 = null;
                str = null;
            }
            z = str2 == null;
            if (i3 != 0) {
                j = z ? j | 128 : j | 64;
            }
        } else {
            str2 = null;
            str = null;
            z = false;
        }
        if ((128 & j) == 0 || entity == null) {
            str3 = null;
        } else {
            str3 = entity.getLogo();
        }
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (z) {
                str2 = str3;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (i4 != 0) {
                j |= isEmpty ? 8 : 4;
            }
            i = isEmpty ? 8 : 0;
            z2 = !isEmpty;
            if ((j & 3) != 0) {
                j = z2 ? j | 512 : j | 256;
            }
            str4 = str2;
        } else {
            str4 = null;
            z2 = false;
            i = 0;
        }
        boolean z3 = (j & 512) != 0 ? !TextUtils.isEmpty(str) : false;
        int i5 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (!z2) {
                z3 = false;
            }
            if (i5 != 0) {
                j |= z3 ? 32 : 16;
            }
            if (!z3) {
                i2 = 8;
            }
        }
        if ((j & 3) != 0) {
            this.iconView.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str4, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231363), 0, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            this.mboundView2.setVisibility(i2);
            TextViewBindingAdapter.setText(this.titleView, str);
        }
    }
}
