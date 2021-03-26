package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.widget.ActionButton;

public class AppNodeToolbarContentBindingImpl extends AppNodeToolbarContentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363296, 6);
        sparseIntArray.put(2131363208, 7);
        sparseIntArray.put(2131361877, 8);
    }

    public AppNodeToolbarContentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private AppNodeToolbarContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ActionButton) objArr[8], (ActionButton) objArr[5], (TextView) objArr[4], (RatingBar) objArr[7], (TextView) objArr[3], (LinearLayout) objArr[6], (ImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.followActionView.setTag(null);
        this.hotView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.scoreView.setTag(null);
        this.toolbarLogoView.setTag(null);
        this.toolbarTitleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        setModel((AppNodeViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.AppNodeToolbarContentBinding
    public void setModel(AppNodeViewModel appNodeViewModel) {
        updateRegistration(0, appNodeViewModel);
        this.mModel = appNodeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeModel((AppNodeViewModel) obj, i2);
        }
        if (i == 1) {
            return onChangeModelServiceApp((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeModelAppScore((ObservableFloat) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeModelIsFollow((ObservableBoolean) obj, i2);
    }

    private boolean onChangeModel(AppNodeViewModel appNodeViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeModelServiceApp(ObservableField<ServiceApp> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeModelAppScore(ObservableFloat observableFloat, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeModelIsFollow(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        String str6;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppNodeViewModel appNodeViewModel = this.mModel;
        if ((31 & j) != 0) {
            if ((j & 19) != 0) {
                ObservableField<ServiceApp> serviceApp = appNodeViewModel != null ? appNodeViewModel.getServiceApp() : null;
                updateRegistration(1, serviceApp);
                ServiceApp serviceApp2 = serviceApp != null ? serviceApp.get() : null;
                if (serviceApp2 != null) {
                    str6 = serviceApp2.getLogo();
                    str3 = serviceApp2.getAppName();
                    String appHotNumString = ((j & 17) != 0 || appNodeViewModel == null) ? null : appNodeViewModel.getAppHotNumString();
                    if ((j & 21) == 0) {
                        ObservableFloat appScore = appNodeViewModel != null ? appNodeViewModel.getAppScore() : null;
                        updateRegistration(2, appScore);
                        str5 = "" + (appScore != null ? appScore.get() : 0.0f);
                    } else {
                        str5 = null;
                    }
                    i = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
                    if (i == 0) {
                        ObservableBoolean isFollow = appNodeViewModel != null ? appNodeViewModel.isFollow() : null;
                        updateRegistration(3, isFollow);
                        if (isFollow != null) {
                            z = isFollow.get();
                        } else {
                            z = false;
                        }
                        if (i != 0) {
                            j |= z ? 64 : 32;
                        }
                        str4 = this.followActionView.getResources().getString(z ? 2131887204 : 2131887205);
                        str = str6;
                        str2 = appHotNumString;
                        if ((j & 25) != 0) {
                            TextViewBindingAdapter.setText(this.followActionView, str4);
                            this.followActionView.setSelected(z);
                        }
                        if ((17 & j) != 0) {
                            TextViewBindingAdapter.setText(this.hotView, str2);
                        }
                        if ((j & 21) != 0) {
                            TextViewBindingAdapter.setText(this.scoreView, str5);
                        }
                        if ((19 & j) != 0) {
                            Boolean bool = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.toolbarLogoView, str, null, 2131231374, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
                            TextViewBindingAdapter.setText(this.toolbarTitleView, str3);
                        }
                        if ((j & 16) == 0) {
                            ViewBindingAdapters.clipView(this.toolbarLogoView, null, 6);
                            return;
                        }
                        return;
                    }
                    str = str6;
                    str4 = null;
                    str2 = appHotNumString;
                }
            }
            str3 = null;
            str6 = null;
            if ((j & 17) != 0) {
            }
            if ((j & 21) == 0) {
            }
            i = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
            if (i == 0) {
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        z = false;
        if ((j & 25) != 0) {
        }
        if ((17 & j) != 0) {
        }
        if ((j & 21) != 0) {
        }
        if ((19 & j) != 0) {
        }
        if ((j & 16) == 0) {
        }
    }
}
