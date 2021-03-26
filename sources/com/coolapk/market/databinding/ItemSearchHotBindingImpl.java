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
import com.coolapk.market.model.Entity;

public class ItemSearchHotBindingImpl extends ItemSearchHotBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemSearchHotBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemSearchHotBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemSearchHotBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mEntity;
        int i = 0;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (entity != null) {
                str2 = entity.getTitle();
                str3 = entity.getLogo();
            } else {
                str3 = null;
                str2 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str3);
            if (i2 != 0) {
                j |= isEmpty ? 8 : 4;
            }
            if (isEmpty) {
                i = 8;
            }
            str = str3;
        } else {
            str2 = null;
            str = null;
        }
        if ((2 & j) != 0) {
            ViewBindingAdapters.clipView(this.itemView, "capsule", null);
            ViewBindingAdapters.clipView(this.mboundView1, null, 4);
        }
        if ((j & 3) != 0) {
            this.mboundView1.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.textView, str2);
        }
    }
}
