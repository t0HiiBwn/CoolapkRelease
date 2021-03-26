package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public class ItemDyhArticleHeaderBindingImpl extends ItemDyhArticleHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView3;
    private final FrameLayout mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362443, 10);
    }

    public ItemDyhArticleHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemDyhArticleHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[10], (TextView) objArr[4], (ImageView) objArr[9], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[2], (ImageView) objArr[1], (ProgressBar) objArr[8], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.fromWhereView.setTag(null);
        this.gotoView.setTag(null);
        this.headerActionView.setTag(null);
        this.headerTimeView.setTag(null);
        this.headerTitleView.setTag(null);
        this.logoView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[6];
        this.mboundView6 = frameLayout;
        frameLayout.setTag(null);
        this.progressView.setTag(null);
        this.rootView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16384;
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
        if (93 == i) {
            setEntity((Entity) obj);
        } else if (115 == i) {
            setFoldText((String) obj);
        } else if (184 == i) {
            setListType((String) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (264 == i) {
            setSingleImg((String) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((DyhViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleHeaderBinding
    public void setEntity(Entity entity) {
        this.mEntity = entity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(93);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleHeaderBinding
    public void setFoldText(String str) {
        this.mFoldText = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleHeaderBinding
    public void setListType(String str) {
        this.mListType = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleHeaderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleHeaderBinding
    public void setSingleImg(String str) {
        this.mSingleImg = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleHeaderBinding
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
        } else if (i == 84) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 86) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 126) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 245) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i == 124) {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        } else if (i == 173) {
            synchronized (this) {
                this.mDirtyFlags |= 4096;
            }
            return true;
        } else if (i != 119) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8192;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0111 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0145  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str5;
        int i8;
        String str6;
        int i9;
        int i10;
        int i11;
        int i12;
        long j2;
        int i13;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mEntity;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        DyhViewModel dyhViewModel = this.mViewModel;
        int i14 = 0;
        if ((32657 & j) != 0) {
            int i15 = ((j & 16897) > 0 ? 1 : ((j & 16897) == 0 ? 0 : -1));
            if (i15 != 0) {
                str5 = dyhViewModel != null ? dyhViewModel.getFromInfo() : null;
                boolean isEmpty = TextUtils.isEmpty(str5);
                if (i15 != 0) {
                    j |= isEmpty ? 65536 : 32768;
                }
                if (isEmpty) {
                    i3 = 8;
                    i8 = ((j & 18433) > 0 ? 1 : ((j & 18433) == 0 ? 0 : -1));
                    if (i8 == 0) {
                        if (dyhViewModel != null) {
                            z4 = dyhViewModel.getFollowedDyhHeader();
                        } else {
                            z4 = false;
                        }
                        if (i8 != 0) {
                            j |= z4 ? 262144 : 131072;
                        }
                        str4 = z4 ? this.headerActionView.getResources().getString(2131886823) : this.headerActionView.getResources().getString(2131886822);
                    } else {
                        str4 = null;
                    }
                    if ((j & 16529) == 0) {
                        str6 = dyhViewModel != null ? dyhViewModel.getDyhLogo() : null;
                        int i16 = ((j & 16513) > 0 ? 1 : ((j & 16513) == 0 ? 0 : -1));
                        if (i16 != 0) {
                            boolean isEmpty2 = TextUtils.isEmpty(str6);
                            if (i16 != 0) {
                                j |= isEmpty2 ? 16777216 : 8388608;
                            }
                            if (isEmpty2) {
                                i = 8;
                                i9 = ((j & 24577) > 0 ? 1 : ((j & 24577) == 0 ? 0 : -1));
                                if (i9 != 0) {
                                    if (dyhViewModel != null) {
                                        z3 = dyhViewModel.isFollowDyhLoading();
                                    } else {
                                        z3 = false;
                                    }
                                    if (i9 != 0) {
                                        j |= z3 ? 67108864 : 33554432;
                                    }
                                    if (!z3) {
                                        i10 = 8;
                                        i11 = ((j & 17409) > 0 ? 1 : ((j & 17409) == 0 ? 0 : -1));
                                        if (i11 == 0) {
                                            if (dyhViewModel != null) {
                                                z2 = dyhViewModel.isShowAction();
                                            } else {
                                                z2 = false;
                                            }
                                            if (i11 != 0) {
                                                j |= z2 ? 4194304 : 2097152;
                                            }
                                            i12 = z2 ? 0 : 8;
                                            j2 = 16641;
                                        } else {
                                            j2 = 16641;
                                            i12 = 0;
                                        }
                                        String dyhTitle = ((j & j2) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhTitle();
                                        i13 = ((j & 20481) > 0 ? 1 : ((j & 20481) == 0 ? 0 : -1));
                                        if (i13 == 0) {
                                            if (dyhViewModel != null) {
                                                z = dyhViewModel.getIsShowActionView();
                                            } else {
                                                z = false;
                                            }
                                            if (i13 != 0) {
                                                j |= z ? 1048576 : 524288;
                                            }
                                            if (!z) {
                                                i14 = 8;
                                            }
                                            str = str5;
                                            i4 = i10;
                                            i5 = i14;
                                            str3 = dyhTitle;
                                        } else {
                                            str = str5;
                                            i4 = i10;
                                            str3 = dyhTitle;
                                            i5 = 0;
                                        }
                                        str2 = str6;
                                        i2 = i12;
                                    }
                                }
                                i10 = 0;
                                i11 = ((j & 17409) > 0 ? 1 : ((j & 17409) == 0 ? 0 : -1));
                                if (i11 == 0) {
                                }
                                if ((j & j2) != 0) {
                                }
                                i13 = ((j & 20481) > 0 ? 1 : ((j & 20481) == 0 ? 0 : -1));
                                if (i13 == 0) {
                                }
                                str2 = str6;
                                i2 = i12;
                            }
                        }
                    } else {
                        str6 = null;
                    }
                    i = 0;
                    i9 = ((j & 24577) > 0 ? 1 : ((j & 24577) == 0 ? 0 : -1));
                    if (i9 != 0) {
                    }
                    i10 = 0;
                    i11 = ((j & 17409) > 0 ? 1 : ((j & 17409) == 0 ? 0 : -1));
                    if (i11 == 0) {
                    }
                    if ((j & j2) != 0) {
                    }
                    i13 = ((j & 20481) > 0 ? 1 : ((j & 20481) == 0 ? 0 : -1));
                    if (i13 == 0) {
                    }
                    str2 = str6;
                    i2 = i12;
                }
            } else {
                str5 = null;
            }
            i3 = 0;
            i8 = ((j & 18433) > 0 ? 1 : ((j & 18433) == 0 ? 0 : -1));
            if (i8 == 0) {
            }
            if ((j & 16529) == 0) {
            }
            i = 0;
            i9 = ((j & 24577) > 0 ? 1 : ((j & 24577) == 0 ? 0 : -1));
            if (i9 != 0) {
            }
            i10 = 0;
            i11 = ((j & 17409) > 0 ? 1 : ((j & 17409) == 0 ? 0 : -1));
            if (i11 == 0) {
            }
            if ((j & j2) != 0) {
            }
            i13 = ((j & 20481) > 0 ? 1 : ((j & 20481) == 0 ? 0 : -1));
            if (i13 == 0) {
            }
            str2 = str6;
            i2 = i12;
        } else {
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
        if ((j & 16897) != 0) {
            String str7 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.fromWhereView, str, null, str7, null, null, str7);
            this.mboundView3.setVisibility(i3);
        }
        if ((j & 16448) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.gotoView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.headerActionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.logoView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.rootView, onClickListener, bool);
        }
        if ((j & 18433) != 0) {
            TextViewBindingAdapter.setText(this.headerActionView, str4);
        }
        if ((20481 & j) != 0) {
            this.headerActionView.setVisibility(i5);
        }
        if ((16386 & j) != 0) {
            TextViewBindingAdapters.setDatelineByEntity(this.headerTimeView, entity);
        }
        if ((16641 & j) != 0) {
            TextViewBindingAdapter.setText(this.headerTitleView, str3);
        }
        if ((16513 & j) != 0) {
            this.logoView.setVisibility(i);
        }
        if ((j & 16529) != 0) {
            Boolean bool2 = null;
            i7 = i4;
            i6 = i2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str2, null, 2131231282, 0, bool2, bool2, bool2, bool2, bool2, null, null, onBitmapTransformListener, bool2, bool2, bool2, null, bool2);
        } else {
            i7 = i4;
            i6 = i2;
        }
        if ((j & 17409) != 0) {
            this.mboundView6.setVisibility(i6);
        }
        if ((16384 & j) != 0) {
            ThemeBindingAdapters.setIndeterminateTint(this.progressView, "colorAccent");
        }
        if ((j & 24577) != 0) {
            this.progressView.setVisibility(i7);
        }
    }
}
