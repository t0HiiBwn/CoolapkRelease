package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.github.florent37.arclayout.ArcLayout;
import com.makeramen.roundedimageview.RoundedImageView;

public class DyhHeaderViewBindingImpl extends DyhHeaderViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362088, 11);
        sparseIntArray.put(2131361982, 12);
    }

    public DyhHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private DyhHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[5], (ActionButtonFrameLayout) objArr[12], (ArcLayout) objArr[11], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[9], (RoundedImageView) objArr[10], (TextView) objArr[2], (ImageView) objArr[8]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.coverView.setTag(null);
        this.descriptionView.setTag(null);
        this.dyhNumView.setTag(null);
        this.editTypeView.setTag(null);
        this.editView.setTag(null);
        this.infoView.setTag(null);
        this.logoView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096;
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
        if (198 == i) {
            setModel((DyhViewModel) obj);
        } else if (288 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.DyhHeaderViewBinding
    public void setModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mModel = dyhViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DyhHeaderViewBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((DyhViewModel) obj, i2);
    }

    private boolean onChangeModel(DyhViewModel dyhViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 86) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 80) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 166) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 3) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 4) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 81) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 88) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 294) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 298) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i != 84) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0121 A[ADDED_TO_REGION] */
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
        int i2;
        int i3;
        int i4;
        int i5;
        String str7;
        String str8;
        String str9;
        int i6;
        int i7;
        int i8;
        String str10;
        int i9;
        int i10;
        String str11;
        int i11;
        int i12;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhViewModel dyhViewModel = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        int i13 = 0;
        if ((8191 & j) != 0) {
            str8 = ((j & 4129) == 0 || dyhViewModel == null) ? null : dyhViewModel.getActionText();
            str7 = ((j & 4225) == 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhFollowNum();
            int i14 = ((j & 4113) > 0 ? 1 : ((j & 4113) == 0 ? 0 : -1));
            if (i14 != 0) {
                if (dyhViewModel != null) {
                    z = dyhViewModel.getIsDyhEditor();
                } else {
                    z = false;
                }
                if (i14 != 0) {
                    j |= z ? 65536 : 32768;
                }
                if (!z) {
                    i6 = 8;
                    String dyhLogo = ((j & 6145) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhLogo();
                    i7 = ((j & 4353) > 0 ? 1 : ((j & 4353) == 0 ? 0 : -1));
                    if (i7 == 0) {
                        if (dyhViewModel != null) {
                            str10 = dyhViewModel.getEditLevel();
                        } else {
                            str10 = null;
                        }
                        boolean z2 = str10 == null;
                        if (i7 != 0) {
                            j |= z2 ? 16384 : 8192;
                        }
                        if (z2) {
                            i8 = 8;
                            i9 = ((j & 5121) > 0 ? 1 : ((j & 5121) == 0 ? 0 : -1));
                            if (i9 != 0) {
                                if (dyhViewModel != null) {
                                    str11 = dyhViewModel.getUserName();
                                } else {
                                    str11 = null;
                                }
                                boolean z3 = str11 == null;
                                if (i9 != 0) {
                                    j |= z3 ? 1048576 : 524288;
                                }
                                if (z3) {
                                    i10 = 8;
                                    if ((j & 4611) == 0) {
                                        if (dyhViewModel != null) {
                                            str4 = dyhViewModel.getUserAvatar();
                                        } else {
                                            str4 = null;
                                        }
                                        int i15 = ((j & 4609) > 0 ? 1 : ((j & 4609) == 0 ? 0 : -1));
                                        if (i15 != 0) {
                                            boolean z4 = str4 == null;
                                            if (i15 != 0) {
                                                j |= z4 ? 4194304 : 2097152;
                                            }
                                            if (z4) {
                                                i11 = 8;
                                                String actionTextColor = ((j & 4161) != 0 || dyhViewModel == null) ? null : dyhViewModel.getActionTextColor();
                                                String dyhTitle = ((j & 4101) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhTitle();
                                                i12 = ((j & 4105) > 0 ? 1 : ((j & 4105) == 0 ? 0 : -1));
                                                if (i12 != 0) {
                                                    str9 = dyhViewModel != null ? dyhViewModel.getDyhDescription() : null;
                                                    boolean isEmpty = TextUtils.isEmpty(str9);
                                                    if (i12 != 0) {
                                                        j |= isEmpty ? 262144 : 131072;
                                                    }
                                                    if (isEmpty) {
                                                        i13 = 8;
                                                    }
                                                    i5 = i13;
                                                    i3 = i6;
                                                    str3 = dyhLogo;
                                                    str6 = str10;
                                                    i4 = i8;
                                                    str2 = str11;
                                                    i2 = i10;
                                                    i = i11;
                                                    str5 = actionTextColor;
                                                    str = dyhTitle;
                                                } else {
                                                    str9 = null;
                                                    i3 = i6;
                                                    str3 = dyhLogo;
                                                    str6 = str10;
                                                    i4 = i8;
                                                    str2 = str11;
                                                    i2 = i10;
                                                    i = i11;
                                                    str5 = actionTextColor;
                                                    str = dyhTitle;
                                                    i5 = 0;
                                                }
                                            }
                                        }
                                    } else {
                                        str4 = null;
                                    }
                                    i11 = 0;
                                    if ((j & 4161) != 0) {
                                    }
                                    if ((j & 4101) != 0) {
                                    }
                                    i12 = ((j & 4105) > 0 ? 1 : ((j & 4105) == 0 ? 0 : -1));
                                    if (i12 != 0) {
                                    }
                                }
                            } else {
                                str11 = null;
                            }
                            i10 = 0;
                            if ((j & 4611) == 0) {
                            }
                            i11 = 0;
                            if ((j & 4161) != 0) {
                            }
                            if ((j & 4101) != 0) {
                            }
                            i12 = ((j & 4105) > 0 ? 1 : ((j & 4105) == 0 ? 0 : -1));
                            if (i12 != 0) {
                            }
                        }
                    } else {
                        str10 = null;
                    }
                    i8 = 0;
                    i9 = ((j & 5121) > 0 ? 1 : ((j & 5121) == 0 ? 0 : -1));
                    if (i9 != 0) {
                    }
                    i10 = 0;
                    if ((j & 4611) == 0) {
                    }
                    i11 = 0;
                    if ((j & 4161) != 0) {
                    }
                    if ((j & 4101) != 0) {
                    }
                    i12 = ((j & 4105) > 0 ? 1 : ((j & 4105) == 0 ? 0 : -1));
                    if (i12 != 0) {
                    }
                }
            }
            i6 = 0;
            if ((j & 6145) != 0) {
            }
            i7 = ((j & 4353) > 0 ? 1 : ((j & 4353) == 0 ? 0 : -1));
            if (i7 == 0) {
            }
            i8 = 0;
            i9 = ((j & 5121) > 0 ? 1 : ((j & 5121) == 0 ? 0 : -1));
            if (i9 != 0) {
            }
            i10 = 0;
            if ((j & 4611) == 0) {
            }
            i11 = 0;
            if ((j & 4161) != 0) {
            }
            if ((j & 4101) != 0) {
            }
            i12 = ((j & 4105) > 0 ? 1 : ((j & 4105) == 0 ? 0 : -1));
            if (i12 != 0) {
            }
        } else {
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i16 = ((j & 4611) > 0 ? 1 : ((j & 4611) == 0 ? 0 : -1));
        if ((j & 4129) != 0) {
            TextViewBindingAdapter.setText(this.actionButton, str8);
        }
        if ((j & 4161) != 0) {
            ThemeBindingAdapters.setTextColor(this.actionButton, str5);
        }
        if ((4096 & j) != 0) {
            String str12 = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str12, null, 0, 0, bool, bool, bool, bool, bool, str12, null, null, true, bool, bool, null, bool);
            ThemeBindingAdapters.setTextColor(this.descriptionView, "textColorSecondary");
            ThemeBindingAdapters.setTextColor(this.editView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.titleView, "textColorPrimary");
        }
        if ((j & 4105) != 0) {
            TextViewBindingAdapter.setText(this.descriptionView, str9);
            this.descriptionView.setVisibility(i5);
        }
        if ((j & 4225) != 0) {
            TextViewBindingAdapter.setText(this.dyhNumView, str7);
        }
        if ((4353 & j) != 0) {
            TextViewBindingAdapter.setText(this.editTypeView, str6);
            this.editTypeView.setVisibility(i4);
        }
        if ((j & 4113) != 0) {
            this.editView.setVisibility(i3);
        }
        if ((5121 & j) != 0) {
            this.infoView.setVisibility(i2);
            String str13 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str2, null, str13, null, null, str13);
        }
        if ((j & 6145) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str3, null, 2131231282, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, true, bool2, null, bool2);
        }
        if ((4101 & j) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str);
        }
        if ((j & 4609) != 0) {
            this.userAvatarView.setVisibility(i);
        }
        if (i16 != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str4, null, 2131231162, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        }
    }
}
