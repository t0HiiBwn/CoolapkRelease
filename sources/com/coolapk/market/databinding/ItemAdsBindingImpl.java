package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Ads;
import com.coolapk.market.util.CircleTransform;

public class ItemAdsBindingImpl extends ItemAdsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final ImageView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362779, 7);
    }

    public ItemAdsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemAdsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (FrameLayout) objArr[4], (CoolapkCardView) objArr[0], (ImageView) objArr[1], (LinearLayout) objArr[7]);
        this.mDirtyFlags = -1;
        this.actionText.setTag(null);
        this.actionView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.iconView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.mboundView5 = imageView;
        imageView.setTag(null);
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
        if (44 == i) {
            setCard((Ads) obj);
        } else if (245 == i) {
            setShowAction(((Boolean) obj).booleanValue());
        } else if (49 != i) {
            return false;
        } else {
            setCircleTransform((CircleTransform) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAdsBinding
    public void setCard(Ads ads) {
        this.mCard = ads;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAdsBinding
    public void setShowAction(boolean z) {
        this.mShowAction = z;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(245);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAdsBinding
    public void setCircleTransform(CircleTransform circleTransform) {
        this.mCircleTransform = circleTransform;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(49);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        Drawable drawable;
        String str4;
        int i;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Ads ads = this.mCard;
        boolean z = this.mShowAction;
        CircleTransform circleTransform = this.mCircleTransform;
        if ((j & 13) != 0) {
            int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (ads != null) {
                    str2 = ads.getSubTitle();
                    str = ads.getTitle();
                    i2 = ads.getFollow();
                } else {
                    str2 = null;
                    str = null;
                    i2 = 0;
                }
                boolean z2 = i2 == 1;
                if (i3 != 0) {
                    if (z2) {
                        j3 = j | 32;
                        j2 = 512;
                    } else {
                        j3 = j | 16;
                        j2 = 256;
                    }
                    j = j3 | j2;
                }
                drawable = z2 ? AppCompatResources.getDrawable(this.mboundView5.getContext(), 2131231482) : AppCompatResources.getDrawable(this.mboundView5.getContext(), 2131231480);
                str3 = this.actionText.getResources().getString(z2 ? 2131886114 : 2131886134);
            } else {
                drawable = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            str4 = ads != null ? ads.getLogo() : null;
        } else {
            str4 = null;
            drawable = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i4 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (i4 != 0) {
                j |= z ? 128 : 64;
            }
            i = z ? 0 : 8;
        } else {
            i = 0;
        }
        if ((9 & j) != 0) {
            TextViewBindingAdapter.setText(this.actionText, str3);
            TextViewBindingAdapter.setText(this.mboundView2, str);
            TextViewBindingAdapter.setText(this.mboundView3, str2);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, drawable);
        }
        if ((8 & j) != 0) {
            ThemeBindingAdapters.setTextColor(this.actionText, "colorAccent");
        }
        if ((j & 10) != 0) {
            this.actionView.setVisibility(i);
        }
        if ((j & 13) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str4, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, circleTransform, true, bool, bool, null, bool);
        }
    }
}
