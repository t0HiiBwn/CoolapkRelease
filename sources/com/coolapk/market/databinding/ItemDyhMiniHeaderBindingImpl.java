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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleVH;

public class ItemDyhMiniHeaderBindingImpl extends ItemDyhMiniHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final View mboundView2;

    public ItemDyhMiniHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemDyhMiniHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[3], (ImageView) objArr[4], (TextView) objArr[5], (TextView) objArr[6]);
        this.mDirtyFlags = -1;
        this.articleTemplateLayout.setTag(null);
        this.dyhLogoView.setTag(null);
        this.dyhNameView.setTag(null);
        this.dyhTimeView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout2;
        linearLayout2.setTag(null);
        View view2 = (View) objArr[2];
        this.mboundView2 = view2;
        view2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8192;
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
        } else if (115 == i) {
            setFoldText((String) obj);
        } else if (184 == i) {
            setListType((String) obj);
        } else if (147 == i) {
            setHolder((DyhArticleVH) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (264 == i) {
            setSingleImg((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyhMiniHeaderBinding
    public void setModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mModel = dyhViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhMiniHeaderBinding
    public void setFoldText(String str) {
        this.mFoldText = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhMiniHeaderBinding
    public void setListType(String str) {
        this.mListType = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhMiniHeaderBinding
    public void setHolder(DyhArticleVH dyhArticleVH) {
        this.mHolder = dyhArticleVH;
    }

    @Override // com.coolapk.market.databinding.ItemDyhMiniHeaderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhMiniHeaderBinding
    public void setSingleImg(String str) {
        this.mSingleImg = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhMiniHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeModel((DyhViewModel) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeHolder((DyhArticleVH) obj, i2);
    }

    private boolean onChangeModel(DyhViewModel dyhViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 78) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 253) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 85) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 86) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i == 37) {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        } else if (i != 64) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4096;
            }
            return true;
        }
    }

    private boolean onChangeHolder(DyhArticleVH dyhArticleVH, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        Long l;
        int i2;
        int i3;
        int i4;
        Long l2;
        String str3;
        int i5;
        int i6;
        int i7;
        int i8;
        String str4;
        int i9;
        Long l3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhViewModel dyhViewModel = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        int i10 = 0;
        if ((16273 & j) != 0) {
            int i11 = ((j & 14337) > 0 ? 1 : ((j & 14337) == 0 ? 0 : -1));
            if (i11 != 0) {
                if (dyhViewModel != null) {
                    z4 = dyhViewModel.isDatelineVisible();
                    z3 = dyhViewModel.isArticleTemplate();
                } else {
                    z4 = false;
                    z3 = false;
                }
                boolean z5 = z4 & z3;
                if (i11 != 0) {
                    j |= z5 ? 524288 : 262144;
                }
                if (!z5) {
                    i6 = 8;
                    i7 = ((j & 8449) > 0 ? 1 : ((j & 8449) == 0 ? 0 : -1));
                    if (i7 != 0) {
                        if (dyhViewModel != null) {
                            z2 = dyhViewModel.isShowMiniHeader();
                        } else {
                            z2 = false;
                        }
                        if (i7 != 0) {
                            j |= z2 ? 131072 : 65536;
                        }
                        if (!z2) {
                            i8 = 8;
                            if ((j & 8721) != 0) {
                                DyhModel dyhModel = dyhViewModel != null ? dyhViewModel.getDyhModel() : null;
                                if (dyhModel != null) {
                                    str4 = dyhModel.getLogo();
                                    String dyhTitle = ((j & 9217) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhTitle();
                                    i9 = ((j & 8321) > 0 ? 1 : ((j & 8321) == 0 ? 0 : -1));
                                    if (i9 == 0) {
                                        DyhArticle dyhArticle = dyhViewModel != null ? dyhViewModel.getDyhArticle() : null;
                                        if (dyhArticle != null) {
                                            l3 = dyhArticle.getCreatDate();
                                            z = dyhArticle.isTop();
                                        } else {
                                            l3 = null;
                                            z = false;
                                        }
                                        if (i9 != 0) {
                                            j |= z ? 32768 : 16384;
                                        }
                                        if (!z) {
                                            i10 = 8;
                                        }
                                        i = i10;
                                        i2 = i6;
                                        i10 = i8;
                                        str = str4;
                                        str2 = dyhTitle;
                                        l = l3;
                                        i3 = ((8721 & j) > 0 ? 1 : ((8721 & j) == 0 ? 0 : -1));
                                        i4 = ((8256 & j) > 0 ? 1 : ((8256 & j) == 0 ? 0 : -1));
                                        if ((8449 & j) != 0) {
                                            this.articleTemplateLayout.setVisibility(i10);
                                        }
                                        if (i4 != 0) {
                                            ViewBindingAdapters.clickListener(this.articleTemplateLayout, onClickListener, null);
                                        }
                                        if (i3 == 0) {
                                            Boolean bool = null;
                                            i5 = i;
                                            str3 = str2;
                                            l2 = l;
                                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.dyhLogoView, str, null, 2131231162, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
                                        } else {
                                            l2 = l;
                                            str3 = str2;
                                            i5 = i;
                                        }
                                        if ((j & 9217) != 0) {
                                            TextViewBindingAdapter.setText(this.dyhNameView, str3);
                                        }
                                        if ((j & 14337) != 0) {
                                            this.dyhTimeView.setVisibility(i2);
                                        }
                                        if ((j & 8321) == 0) {
                                            TextViewBindingAdapters.setTime(this.dyhTimeView, l2);
                                            this.mboundView1.setVisibility(i5);
                                            this.mboundView2.setVisibility(i5);
                                            return;
                                        }
                                        return;
                                    }
                                    i2 = i6;
                                    i10 = i8;
                                    str = str4;
                                    str2 = dyhTitle;
                                    l = null;
                                }
                            }
                            str4 = null;
                            if ((j & 9217) != 0) {
                            }
                            i9 = ((j & 8321) > 0 ? 1 : ((j & 8321) == 0 ? 0 : -1));
                            if (i9 == 0) {
                            }
                        }
                    }
                    i8 = 0;
                    if ((j & 8721) != 0) {
                    }
                    str4 = null;
                    if ((j & 9217) != 0) {
                    }
                    i9 = ((j & 8321) > 0 ? 1 : ((j & 8321) == 0 ? 0 : -1));
                    if (i9 == 0) {
                    }
                }
            }
            i6 = 0;
            i7 = ((j & 8449) > 0 ? 1 : ((j & 8449) == 0 ? 0 : -1));
            if (i7 != 0) {
            }
            i8 = 0;
            if ((j & 8721) != 0) {
            }
            str4 = null;
            if ((j & 9217) != 0) {
            }
            i9 = ((j & 8321) > 0 ? 1 : ((j & 8321) == 0 ? 0 : -1));
            if (i9 == 0) {
            }
        } else {
            l = null;
            str2 = null;
            str = null;
            i2 = 0;
        }
        i = 0;
        i3 = ((8721 & j) > 0 ? 1 : ((8721 & j) == 0 ? 0 : -1));
        i4 = ((8256 & j) > 0 ? 1 : ((8256 & j) == 0 ? 0 : -1));
        if ((8449 & j) != 0) {
        }
        if (i4 != 0) {
        }
        if (i3 == 0) {
        }
        if ((j & 9217) != 0) {
        }
        if ((j & 14337) != 0) {
        }
        if ((j & 8321) == 0) {
        }
    }
}
