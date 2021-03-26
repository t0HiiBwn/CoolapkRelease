package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.widget.ActionButton;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;

public class ItemUpgradeCardBindingImpl extends ItemUpgradeCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final RoundedImageView mboundView1;
    private final RoundedImageView mboundView2;
    private final RoundedImageView mboundView3;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemUpgradeCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemUpgradeCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ActionButton) objArr[5], (ImageView) objArr[6], (CoolapkCardView) objArr[0]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.deleteView.setTag(null);
        this.itemView.setTag(null);
        RoundedImageView roundedImageView = (RoundedImageView) objArr[1];
        this.mboundView1 = roundedImageView;
        roundedImageView.setTag(null);
        RoundedImageView roundedImageView2 = (RoundedImageView) objArr[2];
        this.mboundView2 = roundedImageView2;
        roundedImageView2.setTag(null);
        RoundedImageView roundedImageView3 = (RoundedImageView) objArr[3];
        this.mboundView3 = roundedImageView3;
        roundedImageView3.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
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
        if (33 == i) {
            setApps((List) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUpgradeCardBinding
    public void setApps(List<MobileApp> list) {
        this.mApps = list;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUpgradeCardBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        MobileApp mobileApp;
        int i2;
        MobileApp mobileApp2;
        MobileApp mobileApp3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        List list = this.mApps;
        View.OnClickListener onClickListener = this.mClick;
        int i3 = 0;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            boolean z = true;
            if (list != null) {
                mobileApp2 = (MobileApp) getFromList(list, 1);
                i2 = list.size();
                mobileApp = (MobileApp) getFromList(list, 0);
                mobileApp3 = (MobileApp) getFromList(list, 2);
            } else {
                mobileApp3 = null;
                mobileApp2 = null;
                i2 = 0;
                mobileApp = null;
            }
            UpgradeInfo upgradeInfo = mobileApp2 != null ? mobileApp2.getUpgradeInfo() : null;
            boolean z2 = mobileApp2 != null;
            str4 = this.mboundView4.getResources().getString(2131887057, Integer.valueOf(i2));
            if (mobileApp3 == null) {
                z = false;
            }
            if (i4 != 0) {
                j |= z2 ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= z ? 16 : 8;
            }
            UpgradeInfo upgradeInfo2 = mobileApp != null ? mobileApp.getUpgradeInfo() : null;
            UpgradeInfo upgradeInfo3 = mobileApp3 != null ? mobileApp3.getUpgradeInfo() : null;
            String logo = upgradeInfo != null ? upgradeInfo.getLogo() : null;
            int i5 = z2 ? 0 : 8;
            if (!z) {
                i3 = 8;
            }
            String logo2 = upgradeInfo2 != null ? upgradeInfo2.getLogo() : null;
            if (upgradeInfo3 != null) {
                str3 = upgradeInfo3.getLogo();
                str2 = logo2;
                str = logo;
                i = i3;
            } else {
                str2 = logo2;
                str = logo;
                i = i3;
                str3 = null;
            }
            i3 = i5;
        } else {
            i = 0;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionButton, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.deleteView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
        }
        if ((j & 5) != 0) {
            DataBindingComponent dataBindingComponent = this.mBindingComponent;
            RoundedImageView roundedImageView = this.mboundView1;
            Boolean bool2 = null;
            String str5 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(dataBindingComponent, roundedImageView, str2, AppCompatResources.getDrawable(roundedImageView.getContext(), 2131231408), 0, 0, bool2, bool2, bool2, bool2, bool2, str5, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
            this.mboundView2.setVisibility(i3);
            DataBindingComponent dataBindingComponent2 = this.mBindingComponent;
            RoundedImageView roundedImageView2 = this.mboundView2;
            ImageViewBindingAdapters.setImageUriWithContext(dataBindingComponent2, roundedImageView2, str, AppCompatResources.getDrawable(roundedImageView2.getContext(), 2131231408), 0, 0, bool2, bool2, bool2, bool2, bool2, str5, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
            this.mboundView3.setVisibility(i);
            DataBindingComponent dataBindingComponent3 = this.mBindingComponent;
            RoundedImageView roundedImageView3 = this.mboundView3;
            ImageViewBindingAdapters.setImageUriWithContext(dataBindingComponent3, roundedImageView3, str3, AppCompatResources.getDrawable(roundedImageView3.getContext(), 2131231408), 0, 0, bool2, bool2, bool2, bool2, bool2, str5, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
            TextViewBindingAdapter.setText(this.mboundView4, str4);
        }
    }
}
