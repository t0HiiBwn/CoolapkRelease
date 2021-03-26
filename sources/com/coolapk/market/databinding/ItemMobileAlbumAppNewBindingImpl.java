package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.album.AlbumPickAPKViewModel;
import com.coolapk.market.view.album.pick.NewAlbumPickFragment;

public class ItemMobileAlbumAppNewBindingImpl extends ItemMobileAlbumAppNewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362316, 8);
        sparseIntArray.put(2131363906, 9);
        sparseIntArray.put(2131362941, 10);
    }

    public ItemMobileAlbumAppNewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemMobileAlbumAppNewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[4], (TextView) objArr[5], (LinearLayout) objArr[6], (TextView) objArr[7], (LinearLayout) objArr[0], (LinearLayout) objArr[8], (ImageView) objArr[1], (CheckBox) objArr[10], (TextView) objArr[2], (TableLayout) objArr[9], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.apkSizeView.setTag(null);
        this.apkSystemView.setTag(null);
        this.appCommentView.setTag(null);
        this.appEditText.setTag(null);
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        this.titleView.setTag(null);
        this.versionView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
            setApp((MobileApp) obj);
        } else if (307 == i) {
            setViewHolder((NewAlbumPickFragment.AlbumMobileAPPViewHolder) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((AlbumPickAPKViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemMobileAlbumAppNewBinding
    public void setApp(MobileApp mobileApp) {
        this.mApp = mobileApp;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemMobileAlbumAppNewBinding
    public void setViewHolder(NewAlbumPickFragment.AlbumMobileAPPViewHolder albumMobileAPPViewHolder) {
        updateRegistration(0, albumMobileAPPViewHolder);
        this.mViewHolder = albumMobileAPPViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(307);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemMobileAlbumAppNewBinding
    public void setViewModel(AlbumPickAPKViewModel albumPickAPKViewModel) {
        updateRegistration(1, albumPickAPKViewModel);
        this.mViewModel = albumPickAPKViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewHolder((NewAlbumPickFragment.AlbumMobileAPPViewHolder) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((AlbumPickAPKViewModel) obj, i2);
    }

    private boolean onChangeViewHolder(NewAlbumPickFragment.AlbumMobileAPPViewHolder albumMobileAPPViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModel(AlbumPickAPKViewModel albumPickAPKViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 164) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 223) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z;
        long j2;
        boolean z2;
        String str7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        MobileApp mobileApp = this.mApp;
        NewAlbumPickFragment.AlbumMobileAPPViewHolder albumMobileAPPViewHolder = this.mViewHolder;
        AlbumPickAPKViewModel albumPickAPKViewModel = this.mViewModel;
        int i2 = 0;
        int i3 = ((j & 36) > 0 ? 1 : ((j & 36) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (mobileApp != null) {
                str4 = mobileApp.getAppName();
                str8 = mobileApp.getVersionName();
                str7 = mobileApp.getPackageName();
                z2 = mobileApp.isSystemApp();
                j2 = mobileApp.getApkLength();
            } else {
                j2 = 0;
                str4 = null;
                str8 = null;
                str7 = null;
                z2 = false;
            }
            if (i3 != 0) {
                j |= z2 ? 128 : 64;
            }
            str5 = "点评 " + str4;
            str3 = "v" + str8;
            i = z2 ? 0 : 8;
            str2 = StringUtils.formatSize(j2);
            str = str7;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((j & 58) != 0) {
            int i4 = ((j & 42) > 0 ? 1 : ((j & 42) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (albumPickAPKViewModel != null) {
                    z = albumPickAPKViewModel.getIsCheck();
                } else {
                    z = false;
                }
                if (i4 != 0) {
                    j |= z ? 512 : 256;
                }
                i2 = z ? 0 : 8;
            }
            if (!((j & 50) == 0 || albumPickAPKViewModel == null)) {
                str6 = albumPickAPKViewModel.getPickAppNote();
                if ((36 & j) != 0) {
                    TextViewBindingAdapter.setText(this.apkSizeView, str2);
                    this.apkSystemView.setVisibility(i);
                    this.appEditText.setHint(str5);
                    Boolean bool = null;
                    ImageViewBindingAdapters.setAppIconWithContext(this.mBindingComponent, this.iconView, str, null, null, 2131231363, bool, bool);
                    TextViewBindingAdapter.setText(this.titleView, str4);
                    TextViewBindingAdapter.setText(this.versionView, str3);
                }
                if ((j & 42) != 0) {
                    this.appCommentView.setVisibility(i2);
                }
                if ((j & 50) != 0) {
                    TextViewBindingAdapter.setText(this.appEditText, str6);
                }
                if ((j & 33) == 0) {
                    ViewBindingAdapters.clickListener(this.cardView, albumMobileAPPViewHolder, null);
                    return;
                }
                return;
            }
        }
        str6 = null;
        if ((36 & j) != 0) {
        }
        if ((j & 42) != 0) {
        }
        if ((j & 50) != 0) {
        }
        if ((j & 33) == 0) {
        }
    }
}
