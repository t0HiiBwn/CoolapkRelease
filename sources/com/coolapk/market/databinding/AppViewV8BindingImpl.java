package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.AppExtensionBarBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.AppExtensionBar;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.AlphableAppBarLayout;

public class AppViewV8BindingImpl extends AppViewV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362890, 4);
        sparseIntArray.put(2131362311, 5);
        sparseIntArray.put(2131362085, 6);
        sparseIntArray.put(2131362069, 7);
        sparseIntArray.put(2131363610, 8);
        sparseIntArray.put(2131362893, 9);
    }

    public AppViewV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AppViewV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AlphableAppBarLayout) objArr[7], (AppExtensionBar) objArr[3], (FrameLayout) objArr[6], (FrameLayout) objArr[2], (CoordinatorLayout) objArr[5], (TextView) objArr[1], (ImageView) objArr[4], (ProgressBar) objArr[9], (DrawSystemBarFrameLayout) objArr[0], (Toolbar) objArr[8]);
        this.mDirtyFlags = -1;
        this.appExtensionBar.setTag(null);
        this.bottomLayout.setTag(null);
        this.emptyTextView.setTag(null);
        this.mainContent.setTag(null);
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
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.AppViewV8Binding
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
        } else if (i == 187) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i != 243) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007e, code lost:
        if (r16 != false) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        int i2;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ServiceApp serviceApp = null;
        AppViewViewModel appViewViewModel = this.mViewModel;
        int i3 = 8;
        boolean z3 = true;
        int i4 = ((j & 15) > 0 ? 1 : ((j & 15) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (appViewViewModel != null) {
                z2 = appViewViewModel.isLoading();
            } else {
                z2 = false;
            }
            z = !z2;
            if (i4 != 0) {
                j = z ? j | 32 : j | 16;
            }
            int i5 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (appViewViewModel != null) {
                    serviceApp = appViewViewModel.getServiceApp();
                }
                boolean z4 = serviceApp != null;
                if (i5 != 0) {
                    j |= z4 ? 512 : 256;
                }
                if (!z4) {
                    i = 8;
                    if ((32 & j) != 0) {
                        if (appViewViewModel != null) {
                            serviceApp = appViewViewModel.getServiceApp();
                        }
                    }
                    z3 = false;
                    i2 = ((j & 15) > 0 ? 1 : ((j & 15) == 0 ? 0 : -1));
                    if (i2 != 0) {
                        if (!z) {
                            z3 = false;
                        }
                        if (i2 != 0) {
                            j |= z3 ? 128 : 64;
                        }
                    }
                    i3 = 0;
                    if ((13 & j) != 0) {
                        AppExtensionBarBindingAdapters.setViewModel(this.appExtensionBar, serviceApp);
                        this.bottomLayout.setVisibility(i);
                    }
                    if ((j & 15) == 0) {
                        this.emptyTextView.setVisibility(i3);
                        return;
                    }
                    return;
                }
            }
        } else {
            z = false;
        }
        i = 0;
        if ((32 & j) != 0) {
        }
        z3 = false;
        i2 = ((j & 15) > 0 ? 1 : ((j & 15) == 0 ? 0 : -1));
        if (i2 != 0) {
        }
        i3 = 0;
        if ((13 & j) != 0) {
        }
        if ((j & 15) == 0) {
        }
    }
}
