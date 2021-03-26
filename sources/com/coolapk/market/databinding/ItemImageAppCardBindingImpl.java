package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.EntityItemModel;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemImageAppCardBindingImpl extends ItemImageAppCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"item_app_inside_image_card"}, new int[]{3}, new int[]{2131558596});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363942, 4);
    }

    public ItemImageAppCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemImageAppCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AspectRatioImageView) objArr[2], (ItemAppInsideImageCardBinding) objArr[3], (Space) objArr[4]);
        this.mDirtyFlags = -1;
        this.imageView.setTag(null);
        setContainedBinding(this.includeApp);
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.includeApp.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.includeApp.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (198 == i) {
            setModel((EntityItemModel) obj);
        } else if (44 != i) {
            return false;
        } else {
            setCard((EntityCard) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemImageAppCardBinding
    public void setModel(EntityItemModel entityItemModel) {
        this.mModel = entityItemModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemImageAppCardBinding
    public void setCard(EntityCard entityCard) {
        this.mCard = entityCard;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeApp.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeIncludeApp((ItemAppInsideImageCardBinding) obj, i2);
    }

    private boolean onChangeIncludeApp(ItemAppInsideImageCardBinding itemAppInsideImageCardBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EntityItemModel entityItemModel = this.mModel;
        int i = 0;
        int i2 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i2 != 0) {
            String displayPicCover = entityItemModel != null ? entityItemModel.getDisplayPicCover() : null;
            boolean isEmpty = TextUtils.isEmpty(displayPicCover);
            if (i2 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            if (isEmpty) {
                i = 8;
            }
            str = displayPicCover;
        } else {
            str = null;
        }
        if ((j & 10) != 0) {
            this.imageView.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231707), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, bool, bool, null, bool);
            this.includeApp.setModel(entityItemModel);
        }
        executeBindingsOn(this.includeApp);
    }
}
