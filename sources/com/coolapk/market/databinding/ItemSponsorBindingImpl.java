package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.view.ADFrameLayout;

public class ItemSponsorBindingImpl extends ItemSponsorBinding {
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
        sparseIntArray.put(2131362779, 1);
    }

    public ItemSponsorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemSponsorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (ADFrameLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (45 == i) {
            setCard1((Entity) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (46 == i) {
            setCard2((Entity) obj);
        } else if (186 != i) {
            return false;
        } else {
            setLoadListener((OnImageLoadListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSponsorBinding
    public void setCard1(Entity entity) {
        this.mCard1 = entity;
    }

    @Override // com.coolapk.market.databinding.ItemSponsorBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // com.coolapk.market.databinding.ItemSponsorBinding
    public void setCard2(Entity entity) {
        this.mCard2 = entity;
    }

    @Override // com.coolapk.market.databinding.ItemSponsorBinding
    public void setLoadListener(OnImageLoadListener onImageLoadListener) {
        this.mLoadListener = onImageLoadListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
