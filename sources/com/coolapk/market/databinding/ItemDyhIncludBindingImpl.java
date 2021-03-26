package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public class ItemDyhIncludBindingImpl extends ItemDyhIncludBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362227, 7);
    }

    public ItemDyhIncludBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemDyhIncludBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[7], (CoolapkCardView) objArr[0], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (ImageView) objArr[2], (LinearLayout) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.descriptionView.setTag(null);
        this.editStatusView.setTag(null);
        this.editTypeView.setTag(null);
        this.logoView.setTag(null);
        this.rootView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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

    @Override // com.coolapk.market.databinding.ItemDyhIncludBinding
    public void setModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mModel = dyhViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhIncludBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhIncludBinding
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
        } else if (i == 244) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 88) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 85) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i != 82) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
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
        View.OnClickListener onClickListener;
        String str5;
        int i4;
        int i5;
        int i6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhViewModel dyhViewModel = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener2 = this.mClick;
        int i7 = 0;
        if ((507 & j) != 0) {
            int i8 = ((j & 321) > 0 ? 1 : ((j & 321) == 0 ? 0 : -1));
            if (i8 != 0) {
                DyhModel dyhModel = dyhViewModel != null ? dyhViewModel.getDyhModel() : null;
                if (dyhModel != null) {
                    i6 = dyhModel.getStatus();
                } else {
                    i6 = 0;
                }
                boolean z = i6 == 1;
                if (i8 != 0) {
                    j |= z ? 4096 : 2048;
                }
                if (z) {
                    i4 = 8;
                    String dyhIncludInfo = ((j & 385) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhIncludInfo();
                    String dyhLogo = ((j & 267) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhLogo();
                    String shortTitle = ((j & 273) != 0 || dyhViewModel == null) ? null : dyhViewModel.getShortTitle();
                    i5 = ((j & 289) > 0 ? 1 : ((j & 289) == 0 ? 0 : -1));
                    if (i5 == 0) {
                        if (dyhViewModel != null) {
                            str4 = dyhViewModel.getEditLevel();
                        } else {
                            str4 = null;
                        }
                        boolean z2 = str4 == null;
                        if (i5 != 0) {
                            j |= z2 ? 1024 : 512;
                        }
                        if (z2) {
                            i7 = 8;
                        }
                        str2 = dyhIncludInfo;
                        str = dyhLogo;
                        str3 = shortTitle;
                        i7 = i4;
                        i = i7;
                        i2 = ((j & 267) > 0 ? 1 : ((j & 267) == 0 ? 0 : -1));
                        i3 = ((j & 260) > 0 ? 1 : ((j & 260) == 0 ? 0 : -1));
                        if ((385 & j) != 0) {
                            String str6 = null;
                            TextViewBindingAdapters.setTextViewLinkable(this.descriptionView, str2, null, str6, null, null, str6);
                        }
                        if ((j & 321) != 0) {
                            this.editStatusView.setVisibility(i7);
                        }
                        if ((289 & j) != 0) {
                            TextViewBindingAdapter.setText(this.editTypeView, str4);
                            this.editTypeView.setVisibility(i);
                        }
                        if (i2 == 0) {
                            Boolean bool = null;
                            str5 = str3;
                            onClickListener = onClickListener2;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str, null, 2131231282, 0, bool, bool, bool, true, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
                        } else {
                            str5 = str3;
                            onClickListener = onClickListener2;
                        }
                        if (i3 != 0) {
                            ViewBindingAdapters.clickListener(this.rootView, onClickListener, null);
                        }
                        if ((j & 273) == 0) {
                            TextViewBindingAdapter.setText(this.titleView, str5);
                            return;
                        }
                        return;
                    }
                    i7 = i4;
                    str2 = dyhIncludInfo;
                    str = dyhLogo;
                    str3 = shortTitle;
                    str4 = null;
                }
            }
            i4 = 0;
            if ((j & 385) != 0) {
            }
            if ((j & 267) != 0) {
            }
            if ((j & 273) != 0) {
            }
            i5 = ((j & 289) > 0 ? 1 : ((j & 289) == 0 ? 0 : -1));
            if (i5 == 0) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        i = 0;
        i2 = ((j & 267) > 0 ? 1 : ((j & 267) == 0 ? 0 : -1));
        i3 = ((j & 260) > 0 ? 1 : ((j & 260) == 0 ? 0 : -1));
        if ((385 & j) != 0) {
        }
        if ((j & 321) != 0) {
        }
        if ((289 & j) != 0) {
        }
        if (i2 == 0) {
        }
        if (i3 != 0) {
        }
        if ((j & 273) == 0) {
        }
    }
}
