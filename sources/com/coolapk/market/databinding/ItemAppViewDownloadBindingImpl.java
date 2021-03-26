package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemAppViewDownloadBindingImpl extends ItemAppViewDownloadBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final ImageView mboundView5;
    private final TextView mboundView6;

    public ItemAppViewDownloadBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemAppViewDownloadBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[8], (ActionButtonFrameLayout) objArr[7], (LinearLayout) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.followView.setTag(null);
        this.historyVersionView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.mboundView5 = imageView;
        imageView.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.mboundView6 = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1024;
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
        if (308 != i) {
            return false;
        }
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppViewDownloadBinding
    public void setViewModel(AppViewViewModel appViewViewModel) {
        updateRegistration(0, appViewViewModel);
        this.mViewModel = appViewViewModel;
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
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AppViewViewModel appViewViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 75) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 264) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 242) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 116) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 1) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 62) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 285) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 3) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        Drawable drawable;
        String str2;
        long j2;
        long j3;
        String str3;
        int i;
        String str4;
        String str5;
        int i2;
        Drawable drawable2;
        String str6;
        ServiceApp serviceApp;
        boolean z;
        int i3;
        Resources resources;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        int i4 = 0;
        String str7 = null;
        if ((2047 & j) != 0) {
            int i5 = ((j & 1041) > 0 ? 1 : ((j & 1041) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (appViewViewModel != null) {
                    z = appViewViewModel.isFollow();
                } else {
                    z = false;
                }
                if (i5 != 0) {
                    if (z) {
                        j5 = j | 16384;
                        j4 = 65536;
                    } else {
                        j5 = j | 8192;
                        j4 = 32768;
                    }
                    j = j5 | j4;
                }
                drawable2 = AppCompatResources.getDrawable(this.mboundView5.getContext(), z ? 2131231256 : 2131231114);
                if (z) {
                    resources = this.mboundView6.getResources();
                    i3 = 2131886114;
                } else {
                    resources = this.mboundView6.getResources();
                    i3 = 2131886133;
                }
                str6 = resources.getString(i3);
            } else {
                str6 = null;
                drawable2 = null;
            }
            int i6 = ((j & 1033) > 0 ? 1 : ((j & 1033) == 0 ? 0 : -1));
            if (i6 != 0) {
                if (appViewViewModel != null) {
                    serviceApp = appViewViewModel.getServiceApp();
                } else {
                    serviceApp = null;
                }
                boolean z2 = serviceApp != null;
                if (i6 != 0) {
                    j |= z2 ? 4096 : 2048;
                }
                if (!z2) {
                    i = 8;
                    if (!((j & 1537) == 0 || appViewViewModel == null)) {
                        i4 = appViewViewModel.getActionButtonTextColor();
                    }
                    if ((j & 1249) != 0 || appViewViewModel == null) {
                        j3 = 0;
                        j2 = 0;
                        str3 = null;
                    } else {
                        j3 = appViewViewModel.getTotalLength();
                        j2 = appViewViewModel.getCurrentLength();
                        str3 = appViewViewModel.getActionButtonBackground();
                    }
                    String size = ((j & 1029) != 0 || appViewViewModel == null) ? null : appViewViewModel.getSize();
                    String actionText = ((j & 1281) != 0 || appViewViewModel == null) ? null : appViewViewModel.getActionText();
                    if (!((j & 1027) == 0 || appViewViewModel == null)) {
                        str7 = appViewViewModel.getDownloadCount();
                    }
                    str = str6;
                    drawable = drawable2;
                    i2 = i4;
                    str4 = str7;
                    str2 = size;
                    str5 = actionText;
                }
            }
            i = 0;
            i4 = appViewViewModel.getActionButtonTextColor();
            if ((j & 1249) != 0) {
            }
            j3 = 0;
            j2 = 0;
            str3 = null;
            if ((j & 1029) != 0) {
            }
            if ((j & 1281) != 0) {
            }
            str7 = appViewViewModel.getDownloadCount();
            str = str6;
            drawable = drawable2;
            i2 = i4;
            str4 = str7;
            str2 = size;
            str5 = actionText;
        } else {
            j3 = 0;
            j2 = 0;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            drawable = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((j & 1281) != 0) {
            TextViewBindingAdapter.setText(this.actionButton, str5);
        }
        if ((j & 1537) != 0) {
            this.actionButton.setTextColor(i2);
        }
        if ((j & 1249) != 0) {
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, str3, Long.valueOf(j2), Long.valueOf(j3));
        }
        if ((j & 1033) != 0) {
            this.followView.setVisibility(i);
        }
        if ((1024 & j) != 0) {
            ThemeBindingAdapters.setTextColor(this.historyVersionView, "colorAccent");
            ThemeBindingAdapters.setTintColor(this.mboundView5, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.mboundView6, "colorAccent");
        }
        if ((1027 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str4);
        }
        if ((1029 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str2);
        }
        if ((j & 1041) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, drawable);
            TextViewBindingAdapter.setText(this.mboundView6, str);
        }
    }
}
