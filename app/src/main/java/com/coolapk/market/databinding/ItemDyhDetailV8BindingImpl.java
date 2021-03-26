package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.widget.AutoLinkTextView;

public class ItemDyhDetailV8BindingImpl extends ItemDyhDetailV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362436, 12);
        sparseIntArray.put(2131362312, 13);
        sparseIntArray.put(2131363251, 14);
        sparseIntArray.put(2131362338, 15);
        sparseIntArray.put(2131362319, 16);
        sparseIntArray.put(2131362483, 17);
        sparseIntArray.put(2131362642, 18);
    }

    public ItemDyhDetailV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private ItemDyhDetailV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[5], (LinearLayout) objArr[0], (LinearLayout) objArr[13], (FrameLayout) objArr[16], (FrameLayout) objArr[15], (LinearLayout) objArr[12], (ImageView) objArr[10], (LinearLayout) objArr[9], (TextView) objArr[17], (TextView) objArr[11], (TextView) objArr[4], (LinearLayout) objArr[18], (TextView) objArr[3], (TextView) objArr[2], (ImageView) objArr[1], (TextView) objArr[6], (FrameLayout) objArr[14], (AutoLinkTextView) objArr[7]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.cardView.setTag(null);
        this.extendIcon.setTag(null);
        this.extendLayout.setTag(null);
        this.extendTitle.setTag(null);
        this.fromWhereView.setTag(null);
        this.headerTimeView.setTag(null);
        this.headerTitleView.setTag(null);
        this.logoView.setTag(null);
        CardView cardView = (CardView) objArr[8];
        this.mboundView8 = cardView;
        cardView.setTag(null);
        this.realTitleView.setTag(null);
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
        if (197 == i) {
            setModel((DyhViewModel) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (263 == i) {
            setSingleImg((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyhDetailV8Binding
    public void setModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mModel = dyhViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhDetailV8Binding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhDetailV8Binding
    public void setSingleImg(String str) {
        this.mSingleImg = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhDetailV8Binding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
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
        } else if (i == 85) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 78) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 101) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i != 100) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ef, code lost:
        if (r30 != false) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0171  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        Long l2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i;
        int i2;
        int i3;
        String str9;
        int i4;
        int i5;
        String str10;
        int i6;
        Long l3;
        String str11;
        int i7;
        int i8;
        String str12;
        String str13;
        int i9;
        Resources resources;
        long j2;
        long j3;
        String str14;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhViewModel dyhViewModel = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        boolean z = false;
        if ((499 & j) != 0) {
            int i10 = 8;
            int i11 = ((j & 289) > 0 ? 1 : ((j & 289) == 0 ? 0 : -1));
            if (i11 != 0) {
                DyhArticle dyhArticle = dyhViewModel != null ? dyhViewModel.getDyhArticle() : null;
                if (dyhArticle != null) {
                    l3 = dyhArticle.getCreatDate();
                    str10 = dyhArticle.getMessage();
                    str14 = dyhArticle.getRawUrl();
                    str11 = dyhArticle.getTitle();
                } else {
                    str11 = null;
                    l3 = null;
                    str10 = null;
                    str14 = null;
                }
                boolean isEmpty = TextUtils.isEmpty(str14);
                boolean isEmpty2 = TextUtils.isEmpty(str11);
                if (i11 != 0) {
                    j |= isEmpty ? 262144 : 131072;
                }
                if ((j & 289) != 0) {
                    j |= isEmpty2 ? 4096 : 2048;
                }
                i6 = isEmpty ? 8 : 0;
                if (isEmpty2) {
                    i5 = 8;
                    String extraPic = ((j & 321) != 0 || dyhViewModel == null) ? null : dyhViewModel.getExtraPic();
                    i7 = ((j & 385) > 0 ? 1 : ((j & 385) == 0 ? 0 : -1));
                    if (i7 == 0) {
                        str5 = dyhViewModel != null ? dyhViewModel.getExtendTitle() : null;
                        boolean isEmpty3 = TextUtils.isEmpty(str5);
                        if (i7 != 0) {
                            j |= isEmpty3 ? 1048576 : 524288;
                        }
                        if (isEmpty3) {
                            i8 = 8;
                            if ((j & 275) != 0) {
                                DyhModel dyhModel = dyhViewModel != null ? dyhViewModel.getDyhModel() : null;
                                str4 = dyhModel != null ? dyhModel.getLogo() : null;
                                int i12 = ((j & 273) > 0 ? 1 : ((j & 273) == 0 ? 0 : -1));
                                if (i12 != 0) {
                                    boolean isEmpty4 = TextUtils.isEmpty(str4);
                                    if (i12 != 0) {
                                        j |= isEmpty4 ? 65536 : 32768;
                                    }
                                }
                                i10 = 0;
                                int i13 = ((j & 273) > 0 ? 1 : ((j & 273) == 0 ? 0 : -1));
                                if (i13 != 0) {
                                    if (dyhModel != null) {
                                        String author = dyhModel.getAuthor();
                                        str12 = dyhModel.getTitle();
                                        z = dyhModel.isDyhFollowed();
                                        str13 = author;
                                    } else {
                                        str13 = null;
                                        str12 = null;
                                    }
                                    if (i13 != 0) {
                                        if (z) {
                                            j3 = j | 1024;
                                            j2 = 16384;
                                        } else {
                                            j3 = j | 512;
                                            j2 = 8192;
                                        }
                                        j = j3 | j2;
                                    }
                                    String str15 = z ? "textColorSecondary" : "white";
                                    if (z) {
                                        resources = this.actionView.getResources();
                                        i9 = 2131886761;
                                    } else {
                                        resources = this.actionView.getResources();
                                        i9 = 2131886760;
                                    }
                                    str9 = resources.getString(i9);
                                    str3 = str13;
                                    str8 = str11;
                                    l2 = l3;
                                    i4 = i10;
                                    i3 = i6;
                                    str2 = str10;
                                    i2 = i5;
                                    str = extraPic;
                                    i = i8;
                                    str7 = str12;
                                    str6 = str15;
                                } else {
                                    str8 = str11;
                                    l2 = l3;
                                    i4 = i10;
                                    i3 = i6;
                                    str9 = null;
                                    str7 = null;
                                    str6 = null;
                                    str3 = null;
                                    str2 = str10;
                                    i2 = i5;
                                    str = extraPic;
                                    i = i8;
                                }
                            } else {
                                str8 = str11;
                                l2 = l3;
                                i3 = i6;
                                str9 = null;
                                str7 = null;
                                str6 = null;
                                str4 = null;
                                str3 = null;
                                str2 = str10;
                                i2 = i5;
                                str = extraPic;
                                i = i8;
                                i4 = 0;
                            }
                        }
                    } else {
                        str5 = null;
                    }
                    i8 = 0;
                    if ((j & 275) != 0) {
                    }
                }
            } else {
                str11 = null;
                l3 = null;
                str10 = null;
                i6 = 0;
            }
            i5 = 0;
            if ((j & 321) != 0) {
            }
            i7 = ((j & 385) > 0 ? 1 : ((j & 385) == 0 ? 0 : -1));
            if (i7 == 0) {
            }
            i8 = 0;
            if ((j & 275) != 0) {
            }
        } else {
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            l2 = null;
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i14 = ((275 & j) > 0 ? 1 : ((275 & j) == 0 ? 0 : -1));
        int i15 = ((264 & j) > 0 ? 1 : ((264 & j) == 0 ? 0 : -1));
        if ((j & 273) != 0) {
            TextViewBindingAdapter.setText(this.actionView, str9);
            ThemeBindingAdapters.setTextColor(this.actionView, str6);
            String str16 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.fromWhereView, str3, null, str16, null, null, str16);
            TextViewBindingAdapter.setText(this.headerTitleView, str7);
            this.logoView.setVisibility(i4);
        }
        if (i15 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.extendLayout, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.logoView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.mboundView8, onClickListener, bool);
        }
        if ((321 & j) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.extendIcon, str, null, 2131231361, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
        }
        if ((j & 289) != 0) {
            this.extendLayout.setVisibility(i3);
            TextViewBindingAdapters.setTime(this.headerTimeView, l2);
            TextViewBindingAdapter.setText(this.realTitleView, str8);
            this.realTitleView.setVisibility(i2);
            TextViewBindingAdapters.setAutoTextViewLinkable(this.titleView, str2, null, null, null);
        }
        if ((j & 385) != 0) {
            this.extendTitle.setVisibility(i);
            String str17 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.extendTitle, str5, null, str17, null, null, str17);
        }
        if (i14 != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str4, null, 2131231271, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        }
    }
}
