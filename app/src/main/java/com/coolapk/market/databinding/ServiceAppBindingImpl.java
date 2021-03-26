package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.ActionButton;

public class ServiceAppBindingImpl extends ServiceAppBinding {
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
        sparseIntArray.put(2131362768, 7);
        sparseIntArray.put(2131362652, 8);
        sparseIntArray.put(2131363182, 9);
        sparseIntArray.put(2131363180, 10);
        sparseIntArray.put(2131363181, 11);
        sparseIntArray.put(2131362065, 12);
        sparseIntArray.put(2131362061, 13);
        sparseIntArray.put(2131362905, 14);
        sparseIntArray.put(2131361886, 15);
        sparseIntArray.put(2131362335, 16);
        sparseIntArray.put(2131362546, 17);
        sparseIntArray.put(2131362054, 18);
        sparseIntArray.put(2131362746, 19);
        sparseIntArray.put(2131362747, 20);
    }

    public ServiceAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private ServiceAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ActionButton) objArr[15], (FrameLayout) objArr[18], (TextView) objArr[13], (TextView) objArr[12], (CoolapkCardView) objArr[0], (TextView) objArr[16], (FrameLayout) objArr[6], (TextView) objArr[5], (TextView) objArr[17], (LinearLayout) objArr[8], (ImageView) objArr[2], (LinearLayout) objArr[19], (TextView) objArr[20], (LinearLayout) objArr[7], (TextView) objArr[14], (TextView) objArr[4], (TextView) objArr[10], (TextView) objArr[11], (LinearLayout) objArr[9], (LinearLayout) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.couponView.setTag(null);
        this.extraTextView.setTag(null);
        this.iconView.setTag(null);
        this.newTagView.setTag(null);
        this.setTopView.setTag(null);
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
        if (27 != i) {
            return false;
        }
        setApp((ServiceApp) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ServiceAppBinding
    public void setApp(ServiceApp serviceApp) {
        this.mApp = serviceApp;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        boolean z;
        boolean z2;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ServiceApp serviceApp = this.mApp;
        int i3 = 0;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (serviceApp != null) {
                z2 = serviceApp.isCollectionTop();
                str3 = serviceApp.getExtraFlag();
                z = serviceApp.getHasCoupon();
                str2 = serviceApp.getAppName();
                str4 = serviceApp.getLogo();
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                z2 = false;
                z = false;
            }
            if (i4 != 0) {
                j |= z2 ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= z ? 128 : 64;
            }
            i = z2 ? 0 : 8;
            boolean isEmpty = TextUtils.isEmpty(str3);
            int i5 = z ? 0 : 8;
            if ((j & 3) != 0) {
                j |= isEmpty ? 8 : 4;
            }
            if (isEmpty) {
                i3 = 8;
            }
            str = str4;
            i2 = i3;
            i3 = i5;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((3 & j) != 0) {
            this.couponView.setVisibility(i3);
            TextViewBindingAdapter.setText(this.extraTextView, str3);
            this.extraTextView.setVisibility(i2);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231363, 0, bool, bool, bool, true, bool, null, null, null, true, bool, bool, null, bool);
            this.setTopView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if ((j & 2) != 0) {
            String str5 = null;
            ViewBindingAdapters.clipView(this.couponView, str5, 4);
            ViewBindingAdapters.clipView(this.extraTextView, str5, 4);
            ViewBindingAdapters.clipView(this.newTagView, str5, 4);
        }
    }
}
