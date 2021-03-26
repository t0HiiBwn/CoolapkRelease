package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Tips;
import com.coolapk.market.model.UserProfile;

public class ItemAccountTipsBindingImpl extends ItemAccountTipsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemAccountTipsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemAccountTipsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (ImageView) objArr[5], (CoolapkCardView) objArr[0], (ImageView) objArr[2], (LinearLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.buttonView.setTag(null);
        this.closeView.setTag(null);
        this.coolapkCardView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.tipsIconView.setTag(null);
        this.tipsView.setTag(null);
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
        if (198 == i) {
            setModel((UserProfile) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAccountTipsBinding
    public void setModel(UserProfile userProfile) {
        this.mModel = userProfile;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAccountTipsBinding
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
        int i;
        String str2;
        String str3;
        int i2;
        int i3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UserProfile userProfile = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = 0;
        int i5 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i5 != 0) {
            Tips tips = userProfile != null ? userProfile.getTips() : null;
            if (tips != null) {
                str3 = tips.getButtonName();
                str2 = tips.getTitle();
                i3 = tips.getClosable();
                str4 = tips.getLogo();
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                i3 = 0;
            }
            boolean z = true;
            boolean z2 = str3 == null;
            boolean z3 = i3 == 1;
            if (str4 != null) {
                z = false;
            }
            if (i5 != 0) {
                j |= z2 ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= z3 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j |= z ? 16 : 8;
            }
            int i6 = z2 ? 8 : 0;
            i = z3 ? 0 : 8;
            if (z) {
                i4 = 8;
            }
            str = str4;
            i2 = i4;
            i4 = i6;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        int i7 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((5 & j) != 0) {
            TextViewBindingAdapter.setText(this.buttonView, str3);
            this.buttonView.setVisibility(i4);
            this.closeView.setVisibility(i);
            TextViewBindingAdapter.setText(this.mboundView3, str2);
            this.tipsIconView.setVisibility(i2);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.tipsIconView, str, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        }
        if (i7 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.closeView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.tipsView, onClickListener, bool2);
        }
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setTintColor(this.tipsIconView, "accent_red");
        }
    }
}
