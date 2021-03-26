package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.RatingBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemUserRatingBindingImpl extends ItemUserRatingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363067, 5);
        sparseIntArray.put(2131361877, 6);
    }

    public ItemUserRatingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemUserRatingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[6], (ActionButtonFrameLayout) objArr[4], (LinearLayout) objArr[0], (ImageView) objArr[1], (LinearLayout) objArr[5], (RatingBar) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionContainer.setTag(null);
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        this.ratingBar.setTag(null);
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
        if (27 == i) {
            setApp((ServiceApp) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewHolder((BindingViewHolder) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUserRatingBinding
    public void setApp(ServiceApp serviceApp) {
        this.mApp = serviceApp;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUserRatingBinding
    public void setViewHolder(BindingViewHolder bindingViewHolder) {
        updateRegistration(0, bindingViewHolder);
        this.mViewHolder = bindingViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewHolder((BindingViewHolder) obj, i2);
    }

    private boolean onChangeViewHolder(BindingViewHolder bindingViewHolder, int i) {
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
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        float f = 0.0f;
        ServiceApp serviceApp = this.mApp;
        BindingViewHolder bindingViewHolder = this.mViewHolder;
        int i = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (serviceApp != null) {
                str4 = serviceApp.getLoginUserRate();
                str2 = serviceApp.getAppName();
                str3 = serviceApp.getLogo();
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
            }
            f = ViewDataBinding.safeUnbox(Float.valueOf(str4));
            str = str3;
        } else {
            str2 = null;
            str = null;
        }
        if ((5 & j) != 0) {
            ViewBindingAdapters.clickListener(this.actionContainer, bindingViewHolder, true);
            ViewBindingAdapters.clickListener(this.cardView, bindingViewHolder, null);
        }
        if ((j & 4) != 0) {
            Long l = null;
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, "uninstall", l, l);
        }
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231374, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            RatingBarBindingAdapter.setRating(this.ratingBar, f);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
