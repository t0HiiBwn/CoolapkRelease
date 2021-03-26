package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.model.Link;

public class ItemMainCategoryChildBindingImpl extends ItemMainCategoryChildBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemMainCategoryChildBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemMainCategoryChildBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
        if (182 != i) {
            return false;
        }
        setLinkCard((Link) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemMainCategoryChildBinding
    public void setLinkCard(Link link) {
        this.mLinkCard = link;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(182);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Link link = this.mLinkCard;
        int i = 0;
        String str = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i2 == 0 || link == null)) {
            i = link.getColorInt();
            str = link.getTitle();
        }
        if (i2 != 0) {
            if (getBuildSdkInt() >= 21) {
                this.mboundView0.setBackgroundTintList(Converters.convertColorToColorStateList(i));
            }
            TextViewBindingAdapter.setText(this.titleView, str);
        }
    }
}
