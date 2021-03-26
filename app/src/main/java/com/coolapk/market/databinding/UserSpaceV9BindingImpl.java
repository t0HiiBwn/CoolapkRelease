package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.view.userv9.UserSpaceV9ViewModel;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public class UserSpaceV9BindingImpl extends UserSpaceV9Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView8;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(27);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"user_toolbar"}, new int[]{12}, new int[]{2131559286});
        includedLayouts.setIncludes(6, new String[]{"item_user_info_part"}, new int[]{11}, new int[]{2131558976});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362067, 13);
        sparseIntArray.put(2131362068, 14);
        sparseIntArray.put(2131363934, 15);
        sparseIntArray.put(2131362104, 16);
        sparseIntArray.put(2131362103, 17);
        sparseIntArray.put(2131363396, 18);
        sparseIntArray.put(2131362890, 19);
        sparseIntArray.put(2131361983, 20);
        sparseIntArray.put(2131362735, 21);
        sparseIntArray.put(2131363490, 22);
        sparseIntArray.put(2131363588, 23);
        sparseIntArray.put(2131363223, 24);
        sparseIntArray.put(2131363222, 25);
        sparseIntArray.put(2131362416, 26);
    }

    public UserSpaceV9BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 27, sIncludes, sViewsWithIds));
    }

    private UserSpaceV9BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[3], (LinearLayout) objArr[20], (AppBarLayout) objArr[13], (IgnoreInsetFrameLayout) objArr[14], (ImageView) objArr[17], (FrameLayout) objArr[16], (CoordinatorLayout) objArr[1], (View) objArr[26], (FrameLayout) objArr[21], (ProgressBar) objArr[9], (FrameLayout) objArr[19], (DrawSystemBarFrameLayout) objArr[0], (TextView) objArr[7], (LinearLayout) objArr[6], (ImageView) objArr[4], (TextView) objArr[25], (FrameLayout) objArr[24], (Space) objArr[18], (IgnoreInsetFrameLayout) objArr[2], (TabLayout) objArr[22], (TextView) objArr[10], (Toolbar) objArr[23], (UserAvatarView) objArr[5], (ItemUserInfoPartBinding) objArr[11], (UserToolbarBinding) objArr[12], (ScrollStateViewPager) objArr[15]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.coordinator.setTag(null);
        this.loadingView.setTag(null);
        this.mainContent.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[8];
        this.mboundView8 = linearLayout;
        linearLayout.setTag(null);
        this.nameView.setTag(null);
        this.nameViewContainer.setTag(null);
        this.qrcodeView.setTag(null);
        this.tabContainer.setTag(null);
        this.textView3.setTag(null);
        this.userAvatarView.setTag(null);
        setContainedBinding(this.userInfoView);
        setContainedBinding(this.userToolbar);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048;
        }
        this.userInfoView.invalidateAll();
        this.userToolbar.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.userInfoView.hasPendingBindings() && !this.userToolbar.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((UserSpaceV9ViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.UserSpaceV9Binding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.UserSpaceV9Binding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.UserSpaceV9Binding
    public void setViewModel(UserSpaceV9ViewModel userSpaceV9ViewModel) {
        updateRegistration(2, userSpaceV9ViewModel);
        this.mViewModel = userSpaceV9ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.userInfoView.setLifecycleOwner(lifecycleOwner);
        this.userToolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeUserInfoView((ItemUserInfoPartBinding) obj, i2);
        }
        if (i == 1) {
            return onChangeUserToolbar((UserToolbarBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModel((UserSpaceV9ViewModel) obj, i2);
    }

    private boolean onChangeUserInfoView(ItemUserInfoPartBinding itemUserInfoPartBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeUserToolbar(UserToolbarBinding userToolbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModel(UserSpaceV9ViewModel userSpaceV9ViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 246) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 293) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 299) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 298) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 186) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i != 99) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e0  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        int i4;
        String str4;
        String str5;
        String str6;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        String str7;
        int i10;
        boolean z;
        long j2;
        long j3;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        UserSpaceV9ViewModel userSpaceV9ViewModel = this.mViewModel;
        int i11 = ((j & 2140) > 0 ? 1 : ((j & 2140) == 0 ? 0 : -1));
        int i12 = 0;
        if ((4092 & j) != 0) {
            str3 = ((j & 2180) == 0 || userSpaceV9ViewModel == null) ? null : userSpaceV9ViewModel.getUserVerifyStatusIcon();
            String userAvatar = (i11 == 0 || userSpaceV9ViewModel == null) ? null : userSpaceV9ViewModel.getUserAvatar();
            int i13 = ((j & 2564) > 0 ? 1 : ((j & 2564) == 0 ? 0 : -1));
            if (i13 != 0) {
                if (userSpaceV9ViewModel != null) {
                    z2 = userSpaceV9ViewModel.getLoading();
                } else {
                    z2 = false;
                }
                if (i13 != 0) {
                    j |= z2 ? 131072 : 65536;
                }
                if (!z2) {
                    i5 = 8;
                    i6 = ((j & 2084) > 0 ? 1 : ((j & 2084) == 0 ? 0 : -1));
                    if (i6 == 0) {
                        if (userSpaceV9ViewModel != null) {
                            z = userSpaceV9ViewModel.isShowContent();
                        } else {
                            z = false;
                        }
                        if (i6 != 0) {
                            if (z) {
                                j3 = j | 8192;
                                j2 = 524288;
                            } else {
                                j3 = j | 4096;
                                j2 = 262144;
                            }
                            j = j3 | j2;
                        }
                        i8 = z ? 0 : 8;
                        if (z) {
                            i7 = 8;
                            if ((j & 2308) != 0) {
                                UserProfile userProfile = userSpaceV9ViewModel != null ? userSpaceV9ViewModel.getUserProfile() : null;
                                if (userProfile != null) {
                                    i9 = userProfile.getLevel();
                                    str7 = userProfile.getUserName();
                                    i10 = ((j & 3076) > 0 ? 1 : ((j & 3076) == 0 ? 0 : -1));
                                    if (i10 == 0) {
                                        if (userSpaceV9ViewModel != null) {
                                            str4 = userSpaceV9ViewModel.getErrorMessage();
                                        } else {
                                            str4 = null;
                                        }
                                        boolean z3 = str4 == null;
                                        if (i10 != 0) {
                                            j |= z3 ? 32768 : 16384;
                                        }
                                        if (z3) {
                                            i12 = 8;
                                        }
                                        str2 = userAvatar;
                                        i = i12;
                                        i2 = i5;
                                        i4 = i8;
                                        i3 = i7;
                                        str = str7;
                                        i12 = i9;
                                        if ((j & 2064) != 0) {
                                            Boolean bool = null;
                                            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
                                            ViewBindingAdapters.clickListener(this.qrcodeView, onClickListener, bool);
                                            this.userToolbar.setClick(onClickListener);
                                        }
                                        if ((2048 & j) != 0) {
                                            Number number = null;
                                            ViewBindingAdapters.clipView(this.actionView, "capsule", number);
                                            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
                                            ViewBindingAdapters.clipView(this.qrcodeView, "oval", number);
                                        }
                                        if ((j & 2084) != 0) {
                                            this.coordinator.setVisibility(i4);
                                            this.mboundView8.setVisibility(i3);
                                            this.tabContainer.setVisibility(i4);
                                        }
                                        if ((j & 2564) != 0) {
                                            this.loadingView.setVisibility(i2);
                                        }
                                        if ((2308 & j) != 0) {
                                            TextViewBindingAdapter.setText(this.nameView, str);
                                            this.userInfoView.setLevel(Integer.valueOf(i12));
                                            this.userToolbar.setUserName(str);
                                        }
                                        if ((3076 & j) != 0) {
                                            TextViewBindingAdapter.setText(this.textView3, str4);
                                            this.textView3.setVisibility(i);
                                        }
                                        if ((2140 & j) == 0) {
                                            str5 = str3;
                                            Boolean bool2 = null;
                                            str6 = str2;
                                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str6, null, 2131231152, 0, bool2, bool2, bool2, true, bool2, null, null, onBitmapTransformListener, bool2, true, true, onClickListener, bool2);
                                        } else {
                                            str5 = str3;
                                            str6 = str2;
                                        }
                                        if ((j & 2180) != 0) {
                                            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str5, null);
                                            this.userToolbar.setUserVerifyStatusIcon(str5);
                                        }
                                        if ((j & 2116) != 0) {
                                            this.userToolbar.setUserAvatar(str6);
                                        }
                                        executeBindingsOn(this.userInfoView);
                                        executeBindingsOn(this.userToolbar);
                                    }
                                    str2 = userAvatar;
                                    i2 = i5;
                                    i4 = i8;
                                    str4 = null;
                                    i3 = i7;
                                    str = str7;
                                    i12 = i9;
                                }
                            }
                            str7 = null;
                            i9 = 0;
                            i10 = ((j & 3076) > 0 ? 1 : ((j & 3076) == 0 ? 0 : -1));
                            if (i10 == 0) {
                            }
                        }
                    } else {
                        i8 = 0;
                    }
                    i7 = 0;
                    if ((j & 2308) != 0) {
                    }
                    str7 = null;
                    i9 = 0;
                    i10 = ((j & 3076) > 0 ? 1 : ((j & 3076) == 0 ? 0 : -1));
                    if (i10 == 0) {
                    }
                }
            }
            i5 = 0;
            i6 = ((j & 2084) > 0 ? 1 : ((j & 2084) == 0 ? 0 : -1));
            if (i6 == 0) {
            }
            i7 = 0;
            if ((j & 2308) != 0) {
            }
            str7 = null;
            i9 = 0;
            i10 = ((j & 3076) > 0 ? 1 : ((j & 3076) == 0 ? 0 : -1));
            if (i10 == 0) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        i = 0;
        if ((j & 2064) != 0) {
        }
        if ((2048 & j) != 0) {
        }
        if ((j & 2084) != 0) {
        }
        if ((j & 2564) != 0) {
        }
        if ((2308 & j) != 0) {
        }
        if ((3076 & j) != 0) {
        }
        if ((2140 & j) == 0) {
        }
        if ((j & 2180) != 0) {
        }
        if ((j & 2116) != 0) {
        }
        executeBindingsOn(this.userInfoView);
        executeBindingsOn(this.userToolbar);
    }
}
