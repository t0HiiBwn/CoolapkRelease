package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public class ItemFollowDyhBindingImpl extends ItemFollowDyhBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemFollowDyhBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemFollowDyhBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[6], (CoolapkCardView) objArr[0], (TextView) objArr[5], (ImageView) objArr[2], (LinearLayout) objArr[1], (View) objArr[7], (TextView) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.descriptionView.setTag(null);
        this.logoView.setTag(null);
        this.rootView.setTag(null);
        this.statusView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
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
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFollowDyhBinding
    public void setModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mModel = dyhViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFollowDyhBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFollowDyhBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
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
        } else if (i == 84) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 86) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 277) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 120) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 260) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 87) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 81) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 168) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i != 257) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fe A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0131 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        int i3;
        String str5;
        int i4;
        boolean z;
        String str6;
        String str7;
        String str8;
        String str9;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z3;
        boolean z4;
        long j2;
        long j3;
        boolean z5;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhViewModel dyhViewModel = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        if ((8187 & j) != 0) {
            int i11 = ((j & 5121) > 0 ? 1 : ((j & 5121) == 0 ? 0 : -1));
            if (i11 != 0) {
                if (dyhViewModel != null) {
                    z5 = dyhViewModel.getIsFollowDyh();
                } else {
                    z5 = false;
                }
                if (i11 != 0) {
                    if (z5) {
                        j5 = j | 16384;
                        j4 = 262144;
                    } else {
                        j5 = j | 8192;
                        j4 = 131072;
                    }
                    j = j5 | j4;
                }
                str8 = z5 ? "textColorSecondary" : "white";
                str9 = z5 ? this.actionView.getResources().getString(2131886823) : this.actionView.getResources().getString(2131886822);
            } else {
                str9 = null;
                str8 = null;
            }
            int i12 = ((j & 4929) > 0 ? 1 : ((j & 4929) == 0 ? 0 : -1));
            if (i12 != 0) {
                if (dyhViewModel != null) {
                    z2 = dyhViewModel.isFollowList();
                } else {
                    z2 = false;
                }
                if (i12 != 0) {
                    j = z2 ? j | 1048576 : j | 524288;
                }
                if ((j & 4161) != 0) {
                    if (z2) {
                        j3 = j | 4194304;
                        j2 = 67108864;
                    } else {
                        j3 = j | 2097152;
                        j2 = 33554432;
                    }
                    j = j3 | j2;
                }
                if ((j & 4161) != 0) {
                    i6 = z2 ? 0 : 8;
                    if (z2) {
                        i5 = 8;
                        String dyhTitle = ((j & 4113) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhTitle();
                        i7 = ((j & 6145) > 0 ? 1 : ((j & 6145) == 0 ? 0 : -1));
                        if (i7 != 0) {
                            if (dyhViewModel != null) {
                                z4 = dyhViewModel.isShowRedPoint();
                            } else {
                                z4 = false;
                            }
                            if (i7 != 0) {
                                j |= z4 ? 65536 : 32768;
                            }
                            if (!z4) {
                                i8 = 8;
                                str4 = ((j & 4107) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhLogo();
                                i9 = ((j & 4225) > 0 ? 1 : ((j & 4225) == 0 ? 0 : -1));
                                if (i9 != 0) {
                                    if (dyhViewModel != null) {
                                        z3 = dyhViewModel.isShowSubTile();
                                    } else {
                                        z3 = false;
                                    }
                                    if (i9 != 0) {
                                        j |= z3 ? 16777216 : 8388608;
                                    }
                                    if (!z3) {
                                        i10 = 8;
                                        if ((j & 4129) != 0 || dyhViewModel == null) {
                                            str2 = str8;
                                            str3 = null;
                                        } else {
                                            str3 = dyhViewModel.getTime();
                                            str2 = str8;
                                        }
                                        i2 = i10;
                                        i3 = i6;
                                        i4 = i5;
                                        str = dyhTitle;
                                        i = i8;
                                        str5 = str9;
                                        z = z2;
                                    }
                                }
                                i10 = 0;
                                if ((j & 4129) != 0) {
                                }
                                str2 = str8;
                                str3 = null;
                                i2 = i10;
                                i3 = i6;
                                i4 = i5;
                                str = dyhTitle;
                                i = i8;
                                str5 = str9;
                                z = z2;
                            }
                        }
                        i8 = 0;
                        if ((j & 4107) != 0) {
                        }
                        i9 = ((j & 4225) > 0 ? 1 : ((j & 4225) == 0 ? 0 : -1));
                        if (i9 != 0) {
                        }
                        i10 = 0;
                        if ((j & 4129) != 0) {
                        }
                        str2 = str8;
                        str3 = null;
                        i2 = i10;
                        i3 = i6;
                        i4 = i5;
                        str = dyhTitle;
                        i = i8;
                        str5 = str9;
                        z = z2;
                    }
                    i5 = 0;
                    if ((j & 4113) != 0) {
                    }
                    i7 = ((j & 6145) > 0 ? 1 : ((j & 6145) == 0 ? 0 : -1));
                    if (i7 != 0) {
                    }
                    i8 = 0;
                    if ((j & 4107) != 0) {
                    }
                    i9 = ((j & 4225) > 0 ? 1 : ((j & 4225) == 0 ? 0 : -1));
                    if (i9 != 0) {
                    }
                    i10 = 0;
                    if ((j & 4129) != 0) {
                    }
                    str2 = str8;
                    str3 = null;
                    i2 = i10;
                    i3 = i6;
                    i4 = i5;
                    str = dyhTitle;
                    i = i8;
                    str5 = str9;
                    z = z2;
                }
            } else {
                z2 = false;
            }
            i6 = 0;
            i5 = 0;
            if ((j & 4113) != 0) {
            }
            i7 = ((j & 6145) > 0 ? 1 : ((j & 6145) == 0 ? 0 : -1));
            if (i7 != 0) {
            }
            i8 = 0;
            if ((j & 4107) != 0) {
            }
            i9 = ((j & 4225) > 0 ? 1 : ((j & 4225) == 0 ? 0 : -1));
            if (i9 != 0) {
            }
            i10 = 0;
            if ((j & 4129) != 0) {
            }
            str2 = str8;
            str3 = null;
            i2 = i10;
            i3 = i6;
            i4 = i5;
            str = dyhTitle;
            i = i8;
            str5 = str9;
            z = z2;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            z = false;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i13 = ((j & 4107) > 0 ? 1 : ((j & 4107) == 0 ? 0 : -1));
        int i14 = ((j & 4100) > 0 ? 1 : ((j & 4100) == 0 ? 0 : -1));
        String dyhFollowNum = ((524288 & j) == 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhFollowNum();
        if ((1048576 & j) == 0 || dyhViewModel == null) {
            str6 = null;
        } else {
            str6 = dyhViewModel.getDyhUnreadTitle();
        }
        int i15 = ((j & 4929) > 0 ? 1 : ((j & 4929) == 0 ? 0 : -1));
        if (i15 != 0) {
            if (z) {
                dyhFollowNum = str6;
            }
            str7 = dyhFollowNum;
        } else {
            str7 = null;
        }
        if ((j & 5121) != 0) {
            TextViewBindingAdapter.setText(this.actionView, str5);
            ThemeBindingAdapters.setTextColor(this.actionView, str2);
        }
        if ((j & 4161) != 0) {
            this.actionView.setVisibility(i4);
            this.timeView.setVisibility(i3);
        }
        if (i14 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.rootView, onClickListener, bool);
        }
        if ((4225 & j) != 0) {
            this.descriptionView.setVisibility(i2);
        }
        if (i15 != 0) {
            String str10 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.descriptionView, str7, null, str10, null, null, str10);
        }
        if (i13 != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str4, null, 2131231282, 0, bool2, bool2, bool2, true, bool2, null, null, onBitmapTransformListener, bool2, bool2, bool2, null, bool2);
        }
        if ((j & 6145) != 0) {
            this.statusView.setVisibility(i);
        }
        if ((j & 4129) != 0) {
            TextViewBindingAdapter.setText(this.timeView, str3);
        }
        if ((j & 4113) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str);
        }
    }
}
