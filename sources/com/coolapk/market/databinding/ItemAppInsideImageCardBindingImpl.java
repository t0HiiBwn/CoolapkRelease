package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.EntityItemModel;
import com.coolapk.market.widget.ActionButton;

public class ItemAppInsideImageCardBindingImpl extends ItemAppInsideImageCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362917, 6);
    }

    public ItemAppInsideImageCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemAppInsideImageCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ActionButton) objArr[4], (ImageView) objArr[1], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionArrow.setTag(null);
        this.actionContainer.setTag(null);
        this.iconView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.subtitleView.setTag(null);
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
        if (198 != i) {
            return false;
        }
        setModel((EntityItemModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppInsideImageCardBinding
    public void setModel(EntityItemModel entityItemModel) {
        this.mModel = entityItemModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        int i2;
        ServiceApp serviceApp;
        int i3;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EntityItemModel entityItemModel = this.mModel;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (entityItemModel != null) {
                str4 = entityItemModel.getLogo();
                serviceApp = entityItemModel.getServiceApp();
                str2 = entityItemModel.getTitle();
                str3 = entityItemModel.getSubtitle();
            } else {
                str3 = null;
                str4 = null;
                serviceApp = null;
                str2 = null;
            }
            boolean z = serviceApp == null;
            boolean z2 = serviceApp != null;
            boolean isEmpty = TextUtils.isEmpty(str3);
            if (i4 != 0) {
                j |= z ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= isEmpty ? 128 : 64;
            }
            int i5 = 8;
            int i6 = z ? 0 : 8;
            int i7 = z2 ? 0 : 8;
            if (!isEmpty) {
                i5 = 0;
            }
            i2 = i7;
            str = str4;
            i3 = i5;
            i = i6;
        } else {
            str3 = null;
            serviceApp = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 3) != 0) {
            this.actionArrow.setVisibility(i);
            this.actionContainer.setVisibility(i2);
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, serviceApp, false);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231374), 0, 0, bool, bool, bool, true, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.subtitleView, str3);
            this.subtitleView.setVisibility(i3);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
