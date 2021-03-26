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

public class ItemTextTitleScrollChildBindingImpl extends ItemTextTitleScrollChildBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemTextTitleScrollChildBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemTextTitleScrollChildBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (ImageView) objArr[3], (TextView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.imageView.setTag(null);
        this.newTagView.setTag(null);
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
        if (197 != i) {
            return false;
        }
        setModel((Entity) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTextTitleScrollChildBinding
    public void setModel(Entity entity) {
        this.mModel = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mModel;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (entity != null) {
                str3 = entity.getSubTitle();
                str2 = entity.getTitle();
                str4 = entity.getPic();
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean isEmpty2 = TextUtils.isEmpty(str4);
            if (i3 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= isEmpty2 ? 8 : 4;
            }
            i = isEmpty ? 8 : 0;
            if (isEmpty2) {
                i2 = 8;
            }
            str = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((2 & j) != 0) {
            String str5 = null;
            ViewBindingAdapters.clipView(this.cardView, str5, 4);
            ViewBindingAdapters.clipView(this.imageView, str5, 8);
        }
        if ((j & 3) != 0) {
            this.imageView.setVisibility(i2);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str, null, 2131231696, 0, bool, bool, bool, bool, bool, null, null, null, bool, true, bool, null, bool);
            TextViewBindingAdapter.setText(this.newTagView, str2);
            this.newTagView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
    }
}
