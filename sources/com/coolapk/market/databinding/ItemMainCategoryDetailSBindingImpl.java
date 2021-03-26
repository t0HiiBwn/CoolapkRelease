package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.widget.FlowLayout;

public class ItemMainCategoryDetailSBindingImpl extends ItemMainCategoryDetailSBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;
    private final ImageView mboundView1;
    private final LinearLayout mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362848, 4);
        sparseIntArray.put(2131362238, 5);
        sparseIntArray.put(2131362718, 6);
    }

    public ItemMainCategoryDetailSBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemMainCategoryDetailSBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FlowLayout) objArr[5], (ImageView) objArr[6], (LinearLayout) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout;
        linearLayout.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (29 == i) {
            setAppCategory((AppCategory) obj);
        } else if (288 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemMainCategoryDetailSBinding
    public void setAppCategory(AppCategory appCategory) {
        this.mAppCategory = appCategory;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemMainCategoryDetailSBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
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
        AppCategory appCategory = this.mAppCategory;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (appCategory != null) {
                str2 = appCategory.getTitle();
                str3 = appCategory.getLogo();
            } else {
                str2 = null;
                str3 = null;
            }
            boolean z = appCategory == null;
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (z) {
                i = 4;
            }
            str = str3;
        } else {
            str2 = null;
            str = null;
        }
        if ((j & 5) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str, null, 2131231374, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            this.mboundView2.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
