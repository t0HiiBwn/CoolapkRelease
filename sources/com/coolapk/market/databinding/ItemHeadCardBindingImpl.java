package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.view.ScalingImageView;

public class ItemHeadCardBindingImpl extends ItemHeadCardBinding {
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
        sparseIntArray.put(2131363607, 4);
        sparseIntArray.put(2131362340, 5);
        sparseIntArray.put(2131363568, 6);
        sparseIntArray.put(2131363582, 7);
        sparseIntArray.put(2131363558, 8);
        sparseIntArray.put(2131362417, 9);
    }

    public ItemHeadCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemHeadCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (View) objArr[5], (TextView) objArr[3], (View) objArr[9], (TextView) objArr[8], (LinearLayout) objArr[6], (TextView) objArr[7], (ScalingImageView) objArr[2], (FrameLayout) objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.descriptionView.setTag(null);
        this.topImageView.setTag(null);
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
        if (197 == i) {
            setModel((Entity) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemHeadCardBinding
    public void setModel(Entity entity) {
        this.mModel = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemHeadCardBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemHeadCardBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        String description = (i == 0 || entity == null) ? null : entity.getDescription();
        if ((12 & j) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if (i != 0) {
            String str = null;
            TextViewBindingAdapters.setTextViewLinkable(this.descriptionView, description, null, str, null, null, str);
        }
        if ((j & 8) != 0) {
            String str2 = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.topImageView, str2, null, 0, 0, bool, bool, bool, bool, bool, str2, null, null, bool, true, bool, null, bool);
        }
    }
}
