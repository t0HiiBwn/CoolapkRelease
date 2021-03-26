package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.AppExtensionBarBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.AppExtensionBar;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AppViewBindingImpl extends AppViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView10;
    private final TableLayout mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView14;
    private final FrameLayout mboundView17;
    private final ImageView mboundView22;
    private final TextView mboundView23;
    private final TableLayout mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(36);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(17, new String[]{"item_app_view_download"}, new int[]{25}, new int[]{2131558607});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362346, 26);
        sparseIntArray.put(2131362660, 27);
        sparseIntArray.put(2131362745, 28);
        sparseIntArray.put(2131363610, 29);
        sparseIntArray.put(2131362085, 30);
        sparseIntArray.put(2131362289, 31);
        sparseIntArray.put(2131362296, 32);
        sparseIntArray.put(2131362982, 33);
        sparseIntArray.put(2131361984, 34);
        sparseIntArray.put(2131361904, 35);
    }

    public AppViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 36, sIncludes, sViewsWithIds));
    }

    private AppViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[35], (FloatingActionButton) objArr[24], (FrameLayout) objArr[34], (AppBarLayout) objArr[1], (AppExtensionBar) objArr[21], (ImageView) objArr[4], (ItemAppViewDownloadBinding) objArr[25], (FrameLayout) objArr[30], (ImageView) objArr[15], (FrameLayout) objArr[20], (CollapsingToolbarFixLayout) objArr[2], (LinearLayout) objArr[31], (LinearLayout) objArr[32], (ImageView) objArr[3], (View) objArr[26], (TextView) objArr[19], (Button) objArr[16], (LinearLayout) objArr[27], (LinearLayout) objArr[28], (CoordinatorLayout) objArr[0], (ImageView) objArr[33], (ProgressBar) objArr[18], (TextView) objArr[5], (Toolbar) objArr[29]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.appBar.setTag(null);
        this.appExtensionBar.setTag(null);
        this.appIcon.setTag(null);
        setContainedBinding(this.appViewDownload);
        this.arrowView.setTag(null);
        this.bottomLayout.setTag(null);
        this.collapsingToolbar.setTag(null);
        this.coverView.setTag(null);
        this.emptyTextView.setTag(null);
        this.followView.setTag(null);
        this.mainContent.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TableLayout tableLayout = (TableLayout) objArr[11];
        this.mboundView11 = tableLayout;
        tableLayout.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.mboundView12 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[13];
        this.mboundView13 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[14];
        this.mboundView14 = textView4;
        textView4.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[17];
        this.mboundView17 = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[22];
        this.mboundView22 = imageView;
        imageView.setTag(null);
        TextView textView5 = (TextView) objArr[23];
        this.mboundView23 = textView5;
        textView5.setTag(null);
        TableLayout tableLayout2 = (TableLayout) objArr[6];
        this.mboundView6 = tableLayout2;
        tableLayout2.setTag(null);
        TextView textView6 = (TextView) objArr[7];
        this.mboundView7 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[8];
        this.mboundView8 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[9];
        this.mboundView9 = textView8;
        textView8.setTag(null);
        this.progressBar.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048;
        }
        this.appViewDownload.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.appViewDownload.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (309 != i) {
            return false;
        }
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.AppViewBinding
    public void setViewModel(AppViewViewModel appViewViewModel) {
        updateRegistration(1, appViewViewModel);
        this.mViewModel = appViewViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.appViewDownload.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeAppViewDownload((ItemAppViewDownloadBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeAppViewDownload(ItemAppViewDownloadBinding itemAppViewDownloadBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModel(AppViewViewModel appViewViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 190) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 30) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 243) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 179) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 117) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 52) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 234) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 116) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i != 187) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        boolean z;
        ServiceApp serviceApp;
        int i4;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i5;
        String str10;
        ServiceApp serviceApp2;
        boolean z2;
        int i6;
        int i7;
        String str11;
        int i8;
        int i9;
        String str12;
        String str13;
        int i10;
        long j2;
        boolean z3;
        boolean z4;
        int i11;
        String str14;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        int i12 = 8;
        if ((4094 & j) != 0) {
            String logo = ((j & 2054) == 0 || appViewViewModel == null) ? null : appViewViewModel.getLogo();
            int i13 = ((j & 2066) > 0 ? 1 : ((j & 2066) == 0 ? 0 : -1));
            if (i13 != 0) {
                serviceApp = appViewViewModel != null ? appViewViewModel.getServiceApp() : null;
                if (serviceApp != null) {
                    str13 = serviceApp.getApkRomVersion();
                    str12 = serviceApp.getDisplayVersionName();
                    str14 = serviceApp.getLanguage();
                    i11 = serviceApp.getGiftCount();
                    str11 = serviceApp.getCommentCount();
                } else {
                    str13 = null;
                    str12 = null;
                    str14 = null;
                    str11 = null;
                    i11 = 0;
                }
                boolean z5 = serviceApp != null;
                if (i13 != 0) {
                    if (z5) {
                        j4 = j | 131072;
                        j3 = 8388608;
                    } else {
                        j4 = j | 65536;
                        j3 = 4194304;
                    }
                    j = j4 | j3;
                }
                boolean isEmpty = TextUtils.isEmpty(str14);
                boolean z6 = i11 > 0;
                i8 = z5 ? 0 : 8;
                i7 = z5 ? 0 : 4;
                if ((j & 2066) != 0) {
                    j |= isEmpty ? 32768 : 16384;
                }
                if ((j & 2066) != 0) {
                    j |= z6 ? 524288 : 262144;
                }
                i5 = isEmpty ? 8 : 0;
                i9 = z6 ? 0 : 8;
            } else {
                serviceApp = null;
                str13 = null;
                str12 = null;
                str11 = null;
                i5 = 0;
                i9 = 0;
                i8 = 0;
                i7 = 0;
            }
            if ((j & 2306) != 0) {
                str8 = this.mboundView14.getResources().getString(2131887026, appViewViewModel != null ? appViewViewModel.getScore() : null);
            } else {
                str8 = null;
            }
            str7 = ((j & 2082) == 0 || appViewViewModel == null) ? null : appViewViewModel.getLanguage();
            str6 = ((j & 2178) == 0 || appViewViewModel == null) ? null : appViewViewModel.getCommentCount();
            str5 = ((j & 2114) == 0 || appViewViewModel == null) ? null : appViewViewModel.getFollowCount();
            String appName = ((j & 2058) == 0 || appViewViewModel == null) ? null : appViewViewModel.getAppName();
            if ((j & 3090) != 0) {
                if (appViewViewModel != null) {
                    z4 = appViewViewModel.isLoading();
                } else {
                    z4 = false;
                }
                if ((j & 3074) != 0) {
                    j |= z4 ? 2097152 : 1048576;
                }
                i10 = ((j & 3074) == 0 || z4) ? 0 : 8;
                z = !z4;
                if ((j & 3090) != 0) {
                    j = z ? j | 33554432 : j | 16777216;
                }
                j2 = 2562;
            } else {
                j2 = 2562;
                z = false;
                i10 = 0;
            }
            int i14 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
            if (i14 != 0) {
                if (appViewViewModel != null) {
                    z3 = appViewViewModel.isFollow();
                } else {
                    z3 = false;
                }
                if (i14 != 0) {
                    j |= z3 ? 134217728 : 67108864;
                }
                str9 = this.followView.getResources().getString(z3 ? 2131886114 : 2131886133);
                str3 = logo;
            } else {
                str3 = logo;
                str9 = null;
            }
            str10 = str13;
            str4 = str12;
            i4 = i9;
            i3 = i8;
            str2 = str11;
            i2 = i7;
            str = appName;
            i = i10;
        } else {
            str10 = null;
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            serviceApp = null;
            str3 = null;
            str2 = null;
            str = null;
            i5 = 0;
            i4 = 0;
            z = false;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 33554432) != 0) {
            if (appViewViewModel != null) {
                serviceApp = appViewViewModel.getServiceApp();
            }
            z2 = serviceApp == null;
            serviceApp2 = serviceApp;
        } else {
            serviceApp2 = serviceApp;
            z2 = false;
        }
        int i15 = ((j & 3090) > 0 ? 1 : ((j & 3090) == 0 ? 0 : -1));
        if (i15 != 0) {
            if (!z) {
                z2 = false;
            }
            if (i15 != 0) {
                j |= z2 ? 8192 : 4096;
            }
            if (z2) {
                i12 = 0;
            }
            i6 = i12;
        } else {
            i6 = 0;
        }
        if ((j & 2048) != 0) {
            ThemeBindingAdapters.setBackgroundTint(this.actionView, "colorAccent");
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
            ThemeBindingAdapters.setBackgroundColor(this.collapsingToolbar, "colorPrimary");
            String str15 = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str15, null, 0, 0, bool, bool, bool, bool, bool, str15, null, null, true, bool, bool, null, bool);
            ThemeBindingAdapters.setTintColor(this.mboundView22, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.mboundView23, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.progressBar, "colorAccent");
        }
        if ((j & 2066) != 0) {
            AppExtensionBarBindingAdapters.setViewModel(this.appExtensionBar, serviceApp2);
            this.arrowView.setVisibility(i3);
            this.bottomLayout.setVisibility(i3);
            this.mboundView10.setVisibility(i4);
            this.mboundView11.setVisibility(i2);
            this.mboundView17.setVisibility(i3);
            TextViewBindingAdapter.setText(this.mboundView23, str2);
            this.mboundView6.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView7, str4);
            TextViewBindingAdapter.setText(this.mboundView8, str10);
            this.mboundView9.setVisibility(i5);
        }
        if ((j & 2054) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.appIcon, str3, null, 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, true, true, bool2, null, bool2);
        }
        if ((2050 & j) != 0) {
            this.appViewDownload.setViewModel(appViewViewModel);
        }
        if ((j & 3090) != 0) {
            this.emptyTextView.setVisibility(i6);
        }
        if ((2562 & j) != 0) {
            TextViewBindingAdapter.setText(this.followView, str9);
        }
        if ((2114 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, str5);
        }
        if ((2178 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, str6);
        }
        if ((j & 2306) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str8);
        }
        if ((j & 2082) != 0) {
            TextViewBindingAdapter.setText(this.mboundView9, str7);
        }
        if ((j & 3074) != 0) {
            this.progressBar.setVisibility(i);
        }
        if ((j & 2058) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str);
        }
        executeBindingsOn(this.appViewDownload);
    }
}
