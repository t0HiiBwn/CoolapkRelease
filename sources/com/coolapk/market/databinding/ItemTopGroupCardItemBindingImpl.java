package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.ServiceApp;

public class ItemTopGroupCardItemBindingImpl extends ItemTopGroupCardItemBinding {
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
        sparseIntArray.put(2131362568, 5);
        sparseIntArray.put(2131362566, 6);
        sparseIntArray.put(2131362567, 7);
    }

    public ItemTopGroupCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemTopGroupCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (View) objArr[6], (TextView) objArr[7], (FrameLayout) objArr[5], (ImageView) objArr[1], (TextView) objArr[3], (FrameLayout) objArr[0], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.iconView.setTag(null);
        this.infoView.setTag(null);
        this.itemView.setTag(null);
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
        if (242 != i) {
            return false;
        }
        setServiceApp((ServiceApp) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTopGroupCardItemBinding
    public void setServiceApp(ServiceApp serviceApp) {
        this.mServiceApp = serviceApp;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(242);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ServiceApp serviceApp = this.mServiceApp;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (serviceApp != null) {
                str5 = serviceApp.getDownCount();
                str2 = serviceApp.getAppName();
                str4 = serviceApp.getLogo();
            } else {
                str5 = null;
                str2 = null;
                str4 = null;
            }
            str3 = this.infoView.getResources().getString(2131886639, str5);
            str = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.actionButton, "colorAccent");
        }
        if (i != 0) {
            ActionButtonBindingAdapters.setActionText(this.actionButton, serviceApp, true);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231363), 0, 0, bool, bool, bool, true, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.infoView, str3);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
