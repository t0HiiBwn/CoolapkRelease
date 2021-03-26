package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.RatingBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.view.app.AppViewViewModel;

public class ItemAppViewRatingBindingImpl extends ItemAppViewRatingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;

    public ItemAppViewRatingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemAppViewRatingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RatingBar) objArr[2]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        this.ratingBar.setTag(null);
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
        if (309 != i) {
            return false;
        }
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppViewRatingBinding
    public void setViewModel(AppViewViewModel appViewViewModel) {
        updateRegistration(0, appViewViewModel);
        this.mViewModel = appViewViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AppViewViewModel appViewViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i != 203) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        int i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (appViewViewModel != null) {
                i = appViewViewModel.getMyScore();
            } else {
                i = 0;
            }
            z = i != 0;
            if (i2 != 0) {
                j = z ? j | 16 : j | 8;
            }
        } else {
            i = 0;
            z = false;
        }
        String str = null;
        String string = (16 & j) != 0 ? this.mboundView1.getResources().getString(2131886941, Integer.valueOf(i)) : null;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            str = z ? string : this.mboundView1.getResources().getString(2131886952);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str);
            RatingBarBindingAdapter.setRating(this.ratingBar, (float) i);
        }
    }
}
