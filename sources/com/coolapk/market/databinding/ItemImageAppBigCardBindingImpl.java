package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.EntityItemModel;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemImageAppBigCardBindingImpl extends ItemImageAppBigCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;
    private final TextView mboundView2;
    private final TextView mboundView3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_app_inside_image_card"}, new int[]{4}, new int[]{2131558596});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362920, 5);
    }

    public ItemImageAppBigCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemImageAppBigCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AspectRatioImageView) objArr[1], (ItemAppInsideImageCardBinding) objArr[4], (ImageView) objArr[5]);
        this.mDirtyFlags = -1;
        this.imageView.setTag(null);
        setContainedBinding(this.includeApp);
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemImageAppBigCardBinding
    public void setModel(EntityItemModel entityItemModel) {
        this.mModel = entityItemModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemImageAppBigCardBinding
    public void setCard(EntityCard entityCard) {
        this.mCard = entityCard;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
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
        boolean z;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EntityItemModel entityItemModel = this.mModel;
        EntityCard entityCard = this.mCard;
        boolean z3 = false;
        int i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
        if (i != 0) {
            if (entityItemModel != null) {
                str3 = entityItemModel.getCardTitle();
                str2 = entityItemModel.getCardCover();
                str = entityItemModel.getCardSubTitle();
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            z2 = str3 == null;
            z = str2 == null;
            if (str == null) {
                z3 = true;
            }
            if (i != 0) {
                j = z2 ? j | 32 : j | 16;
            }
            if ((j & 14) != 0) {
                j = z ? j | 512 : j | 256;
            }
            if ((j & 14) != 0) {
                j = z3 ? j | 128 : j | 64;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
            z2 = false;
            z = false;
        }
        if ((j & 672) != 0) {
            str4 = ((128 & j) == 0 || entityCard == null) ? null : entityCard.getSubTitle();
            str5 = ((32 & j) == 0 || entityCard == null) ? null : entityCard.getTitle();
            str6 = ((512 & j) == 0 || entityCard == null) ? null : entityCard.getPic();
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
        }
        int i2 = ((14 & j) > 0 ? 1 : ((14 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (z2) {
                str3 = str5;
            }
            if (z3) {
                str = str4;
            }
            if (z) {
                str2 = str6;
            }
            str7 = str2;
            str8 = str;
        } else {
            str8 = null;
            str3 = null;
            str7 = null;
        }
        if (i2 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str7, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231707), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.mboundView2, str3);
            TextViewBindingAdapter.setText(this.mboundView3, str8);
        }
        if ((j & 10) != 0) {
            this.includeApp.setModel(entityItemModel);
        }
        executeBindingsOn(this.includeApp);
    }
}
