package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public class ItemDyhSimpleHeaderBindingImpl extends ItemDyhSimpleHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final View mboundView2;

    public ItemDyhSimpleHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemDyhSimpleHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout2;
        linearLayout2.setTag(null);
        View view2 = (View) objArr[2];
        this.mboundView2 = view2;
        view2.setTag(null);
        this.rootView.setTag(null);
        this.timeView.setTag(null);
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
        if (309 != i) {
            return false;
        }
        setViewModel((DyhViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyhSimpleHeaderBinding
    public void setViewModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mViewModel = dyhViewModel;
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
        return onChangeViewModel((DyhViewModel) obj, i2);
    }

    private boolean onChangeViewModel(DyhViewModel dyhViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 78) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i != 35) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhViewModel dyhViewModel = this.mViewModel;
        Long l = null;
        int i4 = 0;
        if ((15 & j) != 0) {
            int i5 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
            if (i5 != 0) {
                DyhArticle dyhArticle = dyhViewModel != null ? dyhViewModel.getDyhArticle() : null;
                if (dyhArticle != null) {
                    z2 = dyhArticle.isTop();
                    l = dyhArticle.getCreatDate();
                } else {
                    z2 = false;
                }
                if (i5 != 0) {
                    j |= z2 ? 32 : 16;
                }
                if (!z2) {
                    i2 = 8;
                    i3 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
                    if (i3 == 0) {
                        if (dyhViewModel != null) {
                            z = dyhViewModel.isArticleItemTemplate();
                        } else {
                            z = false;
                        }
                        if (i3 != 0) {
                            j |= z ? 128 : 64;
                        }
                        if (!z) {
                            i4 = 8;
                        }
                        i = i4;
                        i4 = i2;
                        if ((j & 11) != 0) {
                            this.mboundView1.setVisibility(i4);
                            this.mboundView2.setVisibility(i4);
                            TextViewBindingAdapters.setTime(this.timeView, l);
                        }
                        if ((j & 13) == 0) {
                            this.rootView.setVisibility(i);
                            return;
                        }
                        return;
                    }
                    i4 = i2;
                }
            }
            i2 = 0;
            i3 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i3 == 0) {
            }
        }
        i = 0;
        if ((j & 11) != 0) {
        }
        if ((j & 13) == 0) {
        }
    }
}
