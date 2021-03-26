package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.app.AppDetailViewModel;
import java.util.List;

public class ItemAppDetailBindingImpl extends ItemAppDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363103, 14);
        sparseIntArray.put(2131363108, 15);
        sparseIntArray.put(2131363109, 16);
        sparseIntArray.put(2131363105, 17);
        sparseIntArray.put(2131362218, 18);
        sparseIntArray.put(2131362219, 19);
    }

    public ItemAppDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private ItemAppDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[5], (TextView) objArr[13], (TableRow) objArr[18], (TableRow) objArr[19], (TableRow) objArr[7], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[1], (TableLayout) objArr[14], (TableRow) objArr[17], (TextView) objArr[10], (TextView) objArr[9], (TableRow) objArr[15], (TableRow) objArr[16], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[12], (TextView) objArr[2], (TextView) objArr[11]);
        this.mDirtyFlags = -1;
        this.apkSizeView.setTag(null);
        this.changeHistoryTextView.setTag(null);
        this.developerLayout.setTag(null);
        this.developerView.setTag(null);
        this.languageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.packageNameView.setTag(null);
        this.permissionTextView.setTag(null);
        this.permissionTitleTextView.setTag(null);
        this.romSupportView.setTag(null);
        this.updateDateView.setTag(null);
        this.versionHistoryView.setTag(null);
        this.versionView.setTag(null);
        this.viewAllPermissionView.setTag(null);
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
        if (309 != i) {
            return false;
        }
        setViewModel((AppDetailViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppDetailBinding
    public void setViewModel(AppDetailViewModel appDetailViewModel) {
        updateRegistration(0, appDetailViewModel);
        this.mViewModel = appDetailViewModel;
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
        return onChangeViewModel((AppDetailViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AppDetailViewModel appDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 243) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 180) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i != 220) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        List<String> list;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppDetailViewModel appDetailViewModel = this.mViewModel;
        if ((31 & j) != 0) {
            int i2 = ((j & 19) > 0 ? 1 : ((j & 19) == 0 ? 0 : -1));
            if (i2 != 0) {
                ServiceApp serviceApp = appDetailViewModel != null ? appDetailViewModel.getServiceApp() : null;
                if (serviceApp != null) {
                    list = serviceApp.getPermissions();
                    str16 = serviceApp.getApkRomVersion();
                    str15 = serviceApp.getChangeHistory();
                    str14 = serviceApp.getLanguage();
                    str13 = serviceApp.getDeveloperName();
                    str12 = serviceApp.getApkSizeFormat();
                    str11 = serviceApp.getDisplayVersionName();
                    str18 = serviceApp.getPackageName();
                } else {
                    str18 = null;
                    list = null;
                    str16 = null;
                    str15 = null;
                    str14 = null;
                    str13 = null;
                    str12 = null;
                    str11 = null;
                }
                str17 = StringUtils.titleWithNum(this.permissionTitleTextView.getResources().getString(2131886985), list);
                boolean isEmpty = TextUtils.isEmpty(str13);
                if (i2 != 0) {
                    j |= isEmpty ? 64 : 32;
                }
                i = isEmpty ? 8 : 0;
            } else {
                str18 = null;
                str17 = null;
                i = 0;
                str16 = null;
                str15 = null;
                str14 = null;
                str13 = null;
                str12 = null;
                str11 = null;
            }
            String permissionString = ((j & 25) == 0 || appDetailViewModel == null) ? null : appDetailViewModel.getPermissionString();
            if ((j & 21) == 0 || appDetailViewModel == null) {
                str7 = str18;
                str6 = str17;
                str2 = permissionString;
                str5 = str16;
                str10 = str15;
                str8 = str14;
                str9 = str13;
                str3 = str12;
                str4 = str11;
            } else {
                str = appDetailViewModel.getLastUpdateFormat();
                str7 = str18;
                str6 = str17;
                str2 = permissionString;
                str5 = str16;
                str10 = str15;
                str8 = str14;
                str9 = str13;
                str3 = str12;
                str4 = str11;
                if ((19 & j) != 0) {
                    TextViewBindingAdapter.setText(this.apkSizeView, str3);
                    TextViewBindingAdapter.setText(this.changeHistoryTextView, str10);
                    this.developerLayout.setVisibility(i);
                    TextViewBindingAdapter.setText(this.developerView, str9);
                    TextViewBindingAdapter.setText(this.languageView, str8);
                    TextViewBindingAdapter.setText(this.packageNameView, str7);
                    TextViewBindingAdapter.setText(this.permissionTitleTextView, str6);
                    TextViewBindingAdapter.setText(this.romSupportView, str5);
                    TextViewBindingAdapter.setText(this.versionView, str4);
                }
                if ((16 & j) != 0) {
                    ThemeBindingAdapters.setTextColor(this.developerView, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.versionHistoryView, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.viewAllPermissionView, "colorAccent");
                }
                if ((25 & j) != 0) {
                    TextViewBindingAdapter.setText(this.permissionTextView, str2);
                }
                if ((j & 21) == 0) {
                    TextViewBindingAdapter.setText(this.updateDateView, str);
                    return;
                }
                return;
            }
        } else {
            str10 = null;
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            i = 0;
            str3 = null;
            str2 = null;
        }
        str = null;
        if ((19 & j) != 0) {
        }
        if ((16 & j) != 0) {
        }
        if ((25 & j) != 0) {
        }
        if ((j & 21) == 0) {
        }
    }
}
