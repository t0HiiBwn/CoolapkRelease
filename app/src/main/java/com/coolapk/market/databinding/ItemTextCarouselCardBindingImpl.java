package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;
import com.gongwen.marqueen.MarqueeView;

public class ItemTextCarouselCardBindingImpl extends ItemTextCarouselCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362906, 2);
    }

    public ItemTextCarouselCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemTextCarouselCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (ImageView) objArr[1], (MarqueeView) objArr[2]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.imageView.setTag(null);
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
        setEntity((EntityCard) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTextCarouselCardBinding
    public void setEntity(EntityCard entityCard) {
        this.mEntity = entityCard;
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
        EntityCard entityCard = this.mEntity;
        boolean z = false;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (entityCard != null) {
                str = entityCard.getPic();
            } else {
                str = null;
            }
            if (str == null) {
                z = true;
            }
            if (i != 0) {
                j = z ? j | 8 : j | 4;
            }
        } else {
            str = null;
        }
        if ((j & 8) == 0 || entityCard == null) {
            str2 = null;
        } else {
            str2 = entityCard.getLogo();
        }
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (z) {
                str = str2;
            }
            str3 = str;
        } else {
            str3 = null;
        }
        if (i2 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str3, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        }
    }
}
