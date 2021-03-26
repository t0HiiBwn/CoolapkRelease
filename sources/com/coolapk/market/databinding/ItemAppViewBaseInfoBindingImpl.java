package com.coolapk.market.databinding;

import android.text.Html;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.RatingBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.InteractivePeopleViewBindingAdapters;
import com.coolapk.market.binding.TagViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.InteractivePeopleView;
import com.coolapk.market.widget.TagView;
import com.github.florent37.arclayout.ArcLayout;

public class ItemAppViewBaseInfoBindingImpl extends ItemAppViewBaseInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final LinearLayout mboundView0;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final TextView mboundView12;
    private final LinearLayout mboundView13;
    private final TextView mboundView16;
    private final ImageView mboundView2;
    private final ImageView mboundView24;
    private final TextView mboundView26;
    private final TextView mboundView28;
    private final InteractivePeopleView mboundView29;
    private final LinearLayout mboundView3;
    private final ImageView mboundView30;
    private final ImageView mboundView32;
    private final Space mboundView37;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(50);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_app_view_base_info_gift"}, new int[]{42}, new int[]{2131558605});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362088, 43);
        sparseIntArray.put(2131362344, 44);
        sparseIntArray.put(2131362660, 45);
        sparseIntArray.put(2131362340, 46);
        sparseIntArray.put(2131362051, 47);
        sparseIntArray.put(2131363577, 48);
        sparseIntArray.put(2131362754, 49);
    }

    public ItemAppViewBaseInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 50, sIncludes, sViewsWithIds));
    }

    private ItemAppViewBaseInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[21], (ActionButtonFrameLayout) objArr[20], (TextView) objArr[18], (TextView) objArr[22], (TextView) objArr[19], (LinearLayout) objArr[47], (ArcLayout) objArr[43], (ImageView) objArr[27], (TextView) objArr[36], (LinearLayout) objArr[33], (TextView) objArr[35], (TextView) objArr[34], (ImageView) objArr[38], (LinearLayout) objArr[31], (RecyclerView) objArr[46], (ImageView) objArr[44], (LinearLayout) objArr[6], (TextView) objArr[17], (TagView) objArr[41], (ItemAppViewBaseInfoGiftBinding) objArr[42], (LinearLayout) objArr[45], (FrameLayout) objArr[49], (TextView) objArr[39], (ImageView) objArr[23], (TextView) objArr[40], (TextView) objArr[15], (RatingBar) objArr[14], (RecyclerView) objArr[48], (TextView) objArr[1], (LinearLayout) objArr[25]);
        this.mDirtyFlags = -1;
        this.mDirtyFlags_1 = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.actionFollow.setTag(null);
        this.actionOpenWithPlay.setTag(null);
        this.actionRank.setTag(null);
        this.arrowView.setTag(null);
        this.changeLogContentView.setTag(null);
        this.changeLogLayout.setTag(null);
        this.changeLogTimeView.setTag(null);
        this.changeLogTitleView.setTag(null);
        this.clickToShowChangeLogView.setTag(null);
        this.couponLayout.setTag(null);
        this.detailClickLayout.setTag(null);
        this.extraTextView.setTag(null);
        this.flowLayout.setTag(null);
        setContainedBinding(this.giftLayout);
        this.introduceView.setTag(null);
        this.logoView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[11];
        this.mboundView11 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[12];
        this.mboundView12 = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[13];
        this.mboundView13 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView4 = (TextView) objArr[16];
        this.mboundView16 = textView4;
        textView4.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[24];
        this.mboundView24 = imageView2;
        imageView2.setTag(null);
        TextView textView5 = (TextView) objArr[26];
        this.mboundView26 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[28];
        this.mboundView28 = textView6;
        textView6.setTag(null);
        InteractivePeopleView interactivePeopleView = (InteractivePeopleView) objArr[29];
        this.mboundView29 = interactivePeopleView;
        interactivePeopleView.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout3;
        linearLayout3.setTag(null);
        ImageView imageView3 = (ImageView) objArr[30];
        this.mboundView30 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) objArr[32];
        this.mboundView32 = imageView4;
        imageView4.setTag(null);
        Space space = (Space) objArr[37];
        this.mboundView37 = space;
        space.setTag(null);
        TextView textView7 = (TextView) objArr[4];
        this.mboundView4 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[5];
        this.mboundView5 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[7];
        this.mboundView7 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[8];
        this.mboundView8 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[9];
        this.mboundView9 = textView11;
        textView11.setTag(null);
        this.moreView.setTag(null);
        this.ratingAverage.setTag(null);
        this.ratingBarAverage.setTag(null);
        this.titleView.setTag(null);
        this.xposedPluginLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2097152;
            this.mDirtyFlags_1 = 0;
        }
        this.giftLayout.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0) {
                if (this.mDirtyFlags_1 != 0) {
                }
            }
            return true;
        }
        if (this.giftLayout.hasPendingBindings()) {
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

    @Override // com.coolapk.market.databinding.ItemAppViewBaseInfoBinding
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
        this.giftLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeGiftLayout((ItemAppViewBaseInfoGiftBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeGiftLayout(ItemAppViewBaseInfoGiftBinding itemAppViewBaseInfoGiftBinding, int i) {
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
        } else if (i == 30) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 243) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 117) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 52) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 75) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 179) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 235) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 234) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 116) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i == 203) {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        } else if (i == 204) {
            synchronized (this) {
                this.mDirtyFlags |= 4096;
            }
            return true;
        } else if (i == 190) {
            synchronized (this) {
                this.mDirtyFlags |= 8192;
            }
            return true;
        } else if (i == 206) {
            synchronized (this) {
                this.mDirtyFlags |= 16384;
            }
            return true;
        } else if (i == 145) {
            synchronized (this) {
                this.mDirtyFlags |= 32768;
            }
            return true;
        } else if (i == 291) {
            synchronized (this) {
                this.mDirtyFlags |= 65536;
            }
            return true;
        } else if (i == 246) {
            synchronized (this) {
                this.mDirtyFlags |= 131072;
            }
            return true;
        } else if (i == 263) {
            synchronized (this) {
                this.mDirtyFlags |= 262144;
            }
            return true;
        } else if (i == 162) {
            synchronized (this) {
                this.mDirtyFlags |= 524288;
            }
            return true;
        } else if (i != 163) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 1048576;
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:295:0x04f5, code lost:
        if (r9 == r11) goto L_0x04f9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02cf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0330 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0342 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0354 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0366 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0378 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x05aa  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x05ca  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x05d4  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x06b7  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x06c5  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x06d2  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0730  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x073d  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x074c  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0759  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x076b  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0778  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0783  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x07a0  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x07e0  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x07ef  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x07fc  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0810  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x081f  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0833  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0847  */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0856  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0865  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x0872  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        int i2;
        int i3;
        String str6;
        String str7;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        String str8;
        String str9;
        String str10;
        String str11;
        int i10;
        int i11;
        String str12;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Integer num;
        String str13;
        String str14;
        String str15;
        ServiceApp serviceApp;
        String str16;
        int i12;
        int i13;
        boolean z5;
        long j3;
        long j4;
        int i14;
        float f;
        String str17;
        String str18;
        boolean z6;
        int i15;
        boolean z7;
        String str19;
        int i16;
        int i17;
        long j5;
        int i18;
        int i19;
        int i20;
        float f2;
        int i21;
        int i22;
        String str20;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        int i29;
        int i30;
        String str27;
        Integer num2;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        boolean z8;
        int i40;
        boolean z9;
        boolean z10;
        boolean z11;
        String str28;
        int i41;
        boolean z12;
        long j6;
        long j7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        long j8 = 17592186044416L;
        int i42 = 8;
        if ((4194302 & j) != 0) {
            String logo = ((j & 2105346) == 0 || appViewViewModel == null) ? null : appViewViewModel.getLogo();
            int i43 = ((j & 2359298) > 0 ? 1 : ((j & 2359298) == 0 ? 0 : -1));
            if (i43 != 0) {
                if (appViewViewModel != null) {
                    z12 = appViewViewModel.isShrinkChangeLog();
                } else {
                    z12 = false;
                }
                if (i43 != 0) {
                    if (z12) {
                        j7 = j | 34359738368L;
                        j6 = 2305843009213693952L;
                    } else {
                        j7 = j | 17179869184L;
                        j6 = 1152921504606846976L;
                    }
                    j = j7 | j6;
                }
                i22 = z12 ? 8 : 0;
                if (!z12) {
                    i13 = 8;
                    if ((j & 3145738) == 0) {
                        if (appViewViewModel != null) {
                            serviceApp = appViewViewModel.getServiceApp();
                            num2 = appViewViewModel.getIntroduceMaxWords();
                        } else {
                            serviceApp = null;
                            num2 = null;
                        }
                        int i44 = ((j & 2097162) > 0 ? 1 : ((j & 2097162) == 0 ? 0 : -1));
                        if (i44 != 0) {
                            if (serviceApp != null) {
                                str27 = serviceApp.getVersionName();
                                str28 = serviceApp.getLanguage();
                                int isDownloadApp = serviceApp.getIsDownloadApp();
                                str26 = serviceApp.getApkRomVersion();
                                str25 = serviceApp.getExtraFlag();
                                str24 = serviceApp.getChangeLog();
                                str23 = serviceApp.getApkSizeFormat();
                                str22 = serviceApp.getDisplayVersionName();
                                str21 = serviceApp.getRemark();
                                z11 = serviceApp.getHasCoupon();
                                i41 = isDownloadApp;
                            } else {
                                str27 = null;
                                str28 = null;
                                str26 = null;
                                str25 = null;
                                str24 = null;
                                str23 = null;
                                str22 = null;
                                str21 = null;
                                i41 = 0;
                                z11 = false;
                            }
                            if (i44 != 0) {
                                j |= z11 ? 536870912 : 268435456;
                            }
                            boolean z13 = serviceApp != null;
                            boolean z14 = serviceApp == null;
                            if ((j & 2097162) != 0) {
                                j |= z13 ? 9007199254740992L : 4503599627370496L;
                            }
                            if ((j & 2097162) != 0) {
                                j |= z14 ? 562949953421312L : 281474976710656L;
                            }
                            boolean isEmpty = TextUtils.isEmpty(str28);
                            boolean z15 = i41 == 1;
                            z5 = i41 != 1;
                            boolean z16 = str25 == null;
                            boolean isEmpty2 = TextUtils.isEmpty(str24);
                            z4 = TextUtils.isEmpty(str21);
                            i28 = z11 ? 0 : 8;
                            i29 = z13 ? 0 : 8;
                            i27 = z14 ? 8 : 0;
                            if ((j & 2097162) != 0) {
                                j |= isEmpty ? 33554432 : 16777216;
                            }
                            if ((j & 2097162) != 0) {
                                j |= z15 ? 8589934592L : 4294967296L;
                            }
                            int i45 = ((j & 2097162) > 0 ? 1 : ((j & 2097162) == 0 ? 0 : -1));
                            if (i45 != 0) {
                                j2 = z5 ? j2 | 2 : j2 | 1;
                            }
                            if (i45 != 0) {
                                j |= z16 ? 140737488355328L : 70368744177664L;
                            }
                            if ((j & 2097162) != 0) {
                                j = isEmpty2 ? j | 35184372088832L : j | 17592186044416L;
                            }
                            if ((j & 2097162) != 0) {
                                j = z4 ? j | 2147483648L : j | 1073741824;
                            }
                            i30 = isEmpty ? 8 : 0;
                            i26 = z15 ? 0 : 8;
                            i25 = z16 ? 8 : 0;
                            i24 = isEmpty2 ? 8 : 0;
                            if (z4) {
                                i23 = 8;
                                str20 = serviceApp == null ? serviceApp.getIntroduce() : null;
                            }
                        } else {
                            str27 = null;
                            str26 = null;
                            str25 = null;
                            str24 = null;
                            str23 = null;
                            str22 = null;
                            str21 = null;
                            z5 = false;
                            i30 = 0;
                            i29 = 0;
                            i28 = 0;
                            i27 = 0;
                            i26 = 0;
                            i25 = 0;
                            i24 = 0;
                            z4 = false;
                        }
                        i23 = 0;
                        if (serviceApp == null) {
                        }
                    } else {
                        serviceApp = null;
                        num2 = null;
                        str27 = null;
                        str26 = null;
                        str25 = null;
                        str24 = null;
                        str23 = null;
                        str22 = null;
                        str21 = null;
                        str20 = null;
                        z5 = false;
                        i30 = 0;
                        i29 = 0;
                        i28 = 0;
                        i27 = 0;
                        i26 = 0;
                        i25 = 0;
                        i24 = 0;
                        z4 = false;
                        i23 = 0;
                    }
                    String downloadCount = ((j & 2097218) != 0 || appViewViewModel == null) ? null : appViewViewModel.getDownloadCount();
                    String score = ((j & 2097666) != 0 || appViewViewModel == null) ? null : appViewViewModel.getScore();
                    i31 = ((j & 2129922) > 0 ? 1 : ((j & 2129922) == 0 ? 0 : -1));
                    if (i31 != 0) {
                        if (appViewViewModel != null) {
                            z10 = appViewViewModel.isHasGift();
                        } else {
                            z10 = false;
                        }
                        if (i31 != 0) {
                            j |= z10 ? Long.MIN_VALUE : 4611686018427387904L;
                        }
                        if (!z10) {
                            i32 = 8;
                            i33 = ((j & 2113546) > 0 ? 1 : ((j & 2113546) == 0 ? 0 : -1));
                            if (i33 != 0) {
                                if (appViewViewModel != null) {
                                    z3 = appViewViewModel.isNeedXposedFramework();
                                } else {
                                    z3 = false;
                                }
                                if (i33 != 0) {
                                    j = z3 ? j | 8388608 : j | 4194304;
                                }
                                if ((j & 2113538) != 0) {
                                    j |= z3 ? 144115188075855872L : 72057594037927936L;
                                }
                                z2 = !z3;
                                if ((j & 2113546) != 0) {
                                    j = z2 ? j | 134217728 : j | 67108864;
                                }
                                if ((j & 2113538) != 0 && !z3) {
                                    i34 = 8;
                                    String appName = ((j & 2097158) != 0 || appViewViewModel == null) ? null : appViewViewModel.getAppName();
                                    i35 = ((j & 2228226) > 0 ? 1 : ((j & 2228226) == 0 ? 0 : -1));
                                    if (i35 == 0) {
                                        if (appViewViewModel != null) {
                                            z9 = appViewViewModel.isShowChangeLogAll();
                                        } else {
                                            z9 = false;
                                        }
                                        if (i35 != 0) {
                                            j |= z9 ? 2251799813685248L : 1125899906842624L;
                                        }
                                        i36 = z9 ? Integer.MAX_VALUE : 4;
                                    } else {
                                        i36 = 0;
                                    }
                                    i37 = ((j & 2103298) > 0 ? 1 : ((j & 2103298) == 0 ? 0 : -1));
                                    if (i37 == 0) {
                                        if (appViewViewModel != null) {
                                            i40 = appViewViewModel.getMyScore();
                                        } else {
                                            i40 = 0;
                                        }
                                        z = i40 != 0;
                                        if (i37 != 0) {
                                            j = z ? j | 137438953472L : j | 68719476736L;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    float scoreNum = ((j & 2097410) != 0 || appViewViewModel == null) ? 0.0f : appViewViewModel.getScoreNum();
                                    String language = ((j & 2097282) != 0 || appViewViewModel == null) ? null : appViewViewModel.getLanguage();
                                    String commentCount = ((j & 2097186) != 0 || appViewViewModel == null) ? null : appViewViewModel.getCommentCount();
                                    String followCount = ((j & 2097170) != 0 || appViewViewModel == null) ? null : appViewViewModel.getFollowCount();
                                    String updateTime = ((j & 2162690) != 0 || appViewViewModel == null) ? null : appViewViewModel.getUpdateTime();
                                    i38 = ((j & 2098178) > 0 ? 1 : ((j & 2098178) == 0 ? 0 : -1));
                                    if (i38 == 0) {
                                        if (appViewViewModel != null) {
                                            z8 = appViewViewModel.isFollow();
                                        } else {
                                            z8 = false;
                                        }
                                        if (i38 != 0) {
                                            j2 |= z8 ? 8 : 4;
                                        }
                                        str17 = z8 ? this.actionFollow.getResources().getString(2131886114) : this.actionFollow.getResources().getString(2131886133);
                                    } else {
                                        str17 = null;
                                    }
                                    i39 = ((j & 2621442) > 0 ? 1 : ((j & 2621442) == 0 ? 0 : -1));
                                    if (i39 == 0) {
                                        boolean isEmpty3 = TextUtils.isEmpty(appViewViewModel != null ? appViewViewModel.getIntroduce() : null);
                                        if (i39 != 0) {
                                            j |= isEmpty3 ? 36028797018963968L : 18014398509481984L;
                                        }
                                        i12 = isEmpty3 ? 8 : 0;
                                        str12 = str27;
                                        i11 = i30;
                                        i10 = i29;
                                        str11 = str26;
                                        str10 = str25;
                                        str9 = str23;
                                        str8 = str22;
                                        i9 = i28;
                                        i8 = i27;
                                        i7 = i26;
                                        i6 = i25;
                                        i5 = i24;
                                        i4 = i23;
                                        str13 = str20;
                                        str7 = downloadCount;
                                        str6 = score;
                                        i3 = i32;
                                        i2 = i34;
                                        str5 = appName;
                                        i = i36;
                                        str4 = language;
                                        str3 = commentCount;
                                        str2 = followCount;
                                        str = updateTime;
                                    } else {
                                        str12 = str27;
                                        i11 = i30;
                                        i10 = i29;
                                        str11 = str26;
                                        str10 = str25;
                                        str9 = str23;
                                        str8 = str22;
                                        i9 = i28;
                                        i8 = i27;
                                        i7 = i26;
                                        i6 = i25;
                                        i5 = i24;
                                        i4 = i23;
                                        str13 = str20;
                                        str7 = downloadCount;
                                        str6 = score;
                                        i3 = i32;
                                        i2 = i34;
                                        str5 = appName;
                                        i = i36;
                                        str4 = language;
                                        str3 = commentCount;
                                        str2 = followCount;
                                        str = updateTime;
                                        i12 = 0;
                                    }
                                    str14 = logo;
                                    i14 = i22;
                                    j3 = j2;
                                    f = scoreNum;
                                    str16 = str24;
                                    j4 = j;
                                    num = num2;
                                    str15 = str21;
                                }
                            } else {
                                z3 = false;
                                z2 = false;
                            }
                            i34 = 0;
                            if ((j & 2097158) != 0) {
                            }
                            i35 = ((j & 2228226) > 0 ? 1 : ((j & 2228226) == 0 ? 0 : -1));
                            if (i35 == 0) {
                            }
                            i37 = ((j & 2103298) > 0 ? 1 : ((j & 2103298) == 0 ? 0 : -1));
                            if (i37 == 0) {
                            }
                            if ((j & 2097410) != 0) {
                            }
                            if ((j & 2097282) != 0) {
                            }
                            if ((j & 2097186) != 0) {
                            }
                            if ((j & 2097170) != 0) {
                            }
                            if ((j & 2162690) != 0) {
                            }
                            i38 = ((j & 2098178) > 0 ? 1 : ((j & 2098178) == 0 ? 0 : -1));
                            if (i38 == 0) {
                            }
                            i39 = ((j & 2621442) > 0 ? 1 : ((j & 2621442) == 0 ? 0 : -1));
                            if (i39 == 0) {
                            }
                            str14 = logo;
                            i14 = i22;
                            j3 = j2;
                            f = scoreNum;
                            str16 = str24;
                            j4 = j;
                            num = num2;
                            str15 = str21;
                        }
                    }
                    i32 = 0;
                    i33 = ((j & 2113546) > 0 ? 1 : ((j & 2113546) == 0 ? 0 : -1));
                    if (i33 != 0) {
                    }
                    i34 = 0;
                    if ((j & 2097158) != 0) {
                    }
                    i35 = ((j & 2228226) > 0 ? 1 : ((j & 2228226) == 0 ? 0 : -1));
                    if (i35 == 0) {
                    }
                    i37 = ((j & 2103298) > 0 ? 1 : ((j & 2103298) == 0 ? 0 : -1));
                    if (i37 == 0) {
                    }
                    if ((j & 2097410) != 0) {
                    }
                    if ((j & 2097282) != 0) {
                    }
                    if ((j & 2097186) != 0) {
                    }
                    if ((j & 2097170) != 0) {
                    }
                    if ((j & 2162690) != 0) {
                    }
                    i38 = ((j & 2098178) > 0 ? 1 : ((j & 2098178) == 0 ? 0 : -1));
                    if (i38 == 0) {
                    }
                    i39 = ((j & 2621442) > 0 ? 1 : ((j & 2621442) == 0 ? 0 : -1));
                    if (i39 == 0) {
                    }
                    str14 = logo;
                    i14 = i22;
                    j3 = j2;
                    f = scoreNum;
                    str16 = str24;
                    j4 = j;
                    num = num2;
                    str15 = str21;
                }
            } else {
                i22 = 0;
            }
            i13 = 0;
            if ((j & 3145738) == 0) {
            }
            if ((j & 2097218) != 0) {
            }
            if ((j & 2097666) != 0) {
            }
            i31 = ((j & 2129922) > 0 ? 1 : ((j & 2129922) == 0 ? 0 : -1));
            if (i31 != 0) {
            }
            i32 = 0;
            i33 = ((j & 2113546) > 0 ? 1 : ((j & 2113546) == 0 ? 0 : -1));
            if (i33 != 0) {
            }
            i34 = 0;
            if ((j & 2097158) != 0) {
            }
            i35 = ((j & 2228226) > 0 ? 1 : ((j & 2228226) == 0 ? 0 : -1));
            if (i35 == 0) {
            }
            i37 = ((j & 2103298) > 0 ? 1 : ((j & 2103298) == 0 ? 0 : -1));
            if (i37 == 0) {
            }
            if ((j & 2097410) != 0) {
            }
            if ((j & 2097282) != 0) {
            }
            if ((j & 2097186) != 0) {
            }
            if ((j & 2097170) != 0) {
            }
            if ((j & 2162690) != 0) {
            }
            i38 = ((j & 2098178) > 0 ? 1 : ((j & 2098178) == 0 ? 0 : -1));
            if (i38 == 0) {
            }
            i39 = ((j & 2621442) > 0 ? 1 : ((j & 2621442) == 0 ? 0 : -1));
            if (i39 == 0) {
            }
            str14 = logo;
            i14 = i22;
            j3 = j2;
            f = scoreNum;
            str16 = str24;
            j4 = j;
            num = num2;
            str15 = str21;
        } else {
            j3 = j2;
            str17 = null;
            str16 = null;
            serviceApp = null;
            str15 = null;
            str14 = null;
            str13 = null;
            num = null;
            str12 = null;
            str11 = null;
            str10 = null;
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            z5 = false;
            i13 = 0;
            i12 = 0;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
            i11 = 0;
            i10 = 0;
            i9 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
            j4 = j;
            f = 0.0f;
            i14 = 0;
        }
        if ((j4 & 142606336) == 0 && (j3 & 2) == 0) {
            str18 = str16;
            z7 = false;
            i15 = 0;
            z6 = false;
        } else {
            if (appViewViewModel != null) {
                serviceApp = appViewViewModel.getServiceApp();
            }
            if ((j4 & 8388608) != 0) {
                if (serviceApp != null) {
                    str16 = serviceApp.getChangeLog();
                }
                boolean isEmpty4 = TextUtils.isEmpty(str16);
                if ((j4 & 2097162) != 0) {
                    if (isEmpty4) {
                        j8 = 35184372088832L;
                    }
                    j4 |= j8;
                }
                i15 = 1;
                z6 = !isEmpty4;
            } else {
                i15 = 1;
                z6 = false;
            }
            if ((j3 & 2) != 0) {
                if (serviceApp != null) {
                    i21 = serviceApp.getIsForumApp();
                } else {
                    i21 = 0;
                }
            }
            i15 = 0;
            if ((j4 & 134217728) != 0) {
                if (serviceApp != null) {
                    str15 = serviceApp.getRemark();
                }
                z4 = TextUtils.isEmpty(str15);
                if ((j4 & 2097162) != 0) {
                    j4 = z4 ? j4 | 2147483648L : j4 | 1073741824;
                }
                z7 = !z4;
                str18 = str16;
            } else {
                str18 = str16;
                z7 = false;
            }
        }
        if ((j4 & 137438953472L) == 0 || appViewViewModel == null) {
            str19 = null;
        } else {
            str19 = appViewViewModel.getMyScoreText();
        }
        int i46 = ((j4 & 2113546) > 0 ? 1 : ((j4 & 2113546) == 0 ? 0 : -1));
        if (i46 != 0) {
            if (!z3) {
                z6 = false;
            }
            if (!z2) {
                z7 = false;
            }
            if (i46 != 0) {
                j4 |= z6 ? 576460752303423488L : 288230376151711744L;
            }
            if ((j4 & 2113546) != 0) {
                j4 |= z7 ? 549755813888L : 274877906944L;
            }
            i16 = z7 ? 0 : 8;
        } else {
            i16 = 0;
            z6 = false;
        }
        if ((j4 & 2103298) == 0) {
            str19 = null;
        } else if (!z) {
            str19 = this.actionRank.getResources().getString(2131887010);
        }
        int i47 = ((j4 & 2097162) > 0 ? 1 : ((j4 & 2097162) == 0 ? 0 : -1));
        if (i47 != 0) {
            if (!z5) {
                i15 = 0;
            }
            if (i47 != 0) {
                j4 |= i15 != 0 ? 8796093022208L : 4398046511104L;
            }
            if (i15 == 0) {
                i17 = 8;
                if ((j4 & 576460752303423488L) == 0) {
                    if (appViewViewModel != null) {
                        serviceApp = appViewViewModel.getServiceApp();
                    }
                    if (serviceApp != null) {
                        str15 = serviceApp.getRemark();
                    }
                    z4 = TextUtils.isEmpty(str15);
                    j5 = 0;
                    if ((j4 & 2097162) != 0) {
                        j4 = z4 ? j4 | 2147483648L : j4 | 1073741824;
                    }
                } else {
                    j5 = 0;
                }
                i18 = ((j4 & 2113546) > j5 ? 1 : ((j4 & 2113546) == j5 ? 0 : -1));
                if (i18 == 0) {
                    if (!z6) {
                        z4 = false;
                    }
                    if (i18 != 0) {
                        j4 |= z4 ? 2199023255552L : 1099511627776L;
                    }
                    if (z4) {
                        i42 = 0;
                    }
                    i19 = i42;
                } else {
                    i19 = 0;
                }
                if ((j4 & 2097162) == 0) {
                    ActionButtonBindingAdapters.setActionText(this.actionButton, serviceApp);
                    this.actionContainer.setVisibility(i7);
                    f2 = f;
                    ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, serviceApp, false);
                    this.actionOpenWithPlay.setVisibility(i17);
                    this.actionRank.setVisibility(i7);
                    this.arrowView.setVisibility(i10);
                    Integer num3 = null;
                    String str29 = null;
                    Boolean bool = null;
                    Html.ImageGetter imageGetter = null;
                    TextViewBindingAdapters.setTextViewLinkable(this.changeLogContentView, str18, num3, str29, bool, imageGetter, str29);
                    i20 = i19;
                    this.changeLogLayout.setVisibility(i5);
                    TextViewBindingAdapter.setText(this.changeLogTitleView, str12);
                    this.couponLayout.setVisibility(i9);
                    this.detailClickLayout.setVisibility(i7);
                    TextViewBindingAdapter.setText(this.extraTextView, str10);
                    this.extraTextView.setVisibility(i6);
                    this.flowLayout.setVisibility(i8);
                    TagViewBindingAdapters.setTagListFromServiceApp(this.flowLayout, serviceApp);
                    TextViewBindingAdapter.setText(this.mboundView11, str11);
                    this.mboundView12.setVisibility(i11);
                    this.mboundView13.setVisibility(i7);
                    TextViewBindingAdapter.setText(this.mboundView16, str9);
                    this.mboundView2.setVisibility(i17);
                    this.mboundView28.setVisibility(i4);
                    TextViewBindingAdapters.setTextViewLinkable(this.mboundView28, str15, num3, str29, bool, imageGetter, str29);
                    this.mboundView3.setVisibility(i17);
                    TextViewBindingAdapter.setText(this.mboundView7, str8);
                } else {
                    f2 = f;
                    i20 = i19;
                }
                if ((2098178 & j4) != 0) {
                    TextViewBindingAdapter.setText(this.actionFollow, str17);
                }
                if ((2097152 & j4) != 0) {
                    ThemeBindingAdapters.setTextColor(this.actionFollow, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.actionOpenWithPlay, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.actionRank, "colorAccent");
                    ThemeBindingAdapters.setTintColor(this.arrowView, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.extraTextView, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.mboundView16, "colorAccent");
                    ThemeBindingAdapters.setTintColor(this.mboundView2, "textColorSecondary");
                    ThemeBindingAdapters.setTextColor(this.mboundView26, "colorAccent");
                    InteractivePeopleView interactivePeopleView = this.mboundView29;
                    InteractivePeopleViewBindingAdapters.setTitle(interactivePeopleView, interactivePeopleView.getResources().getString(2131886736));
                    ThemeBindingAdapters.setTextColor(this.moreView, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.titleView, "textColorPrimary");
                }
                if ((j4 & 2103298) != 0) {
                    TextViewBindingAdapter.setText(this.actionRank, str19);
                }
                if ((2228226 & j4) != 0) {
                    this.changeLogContentView.setMaxLines(i);
                }
                if ((2162690 & j4) != 0) {
                    TextViewBindingAdapter.setText(this.changeLogTimeView, str);
                }
                if ((j4 & 2359298) != 0) {
                    this.clickToShowChangeLogView.setVisibility(i13);
                    this.mboundView37.setVisibility(i14);
                }
                if ((2097154 & j4) != 0) {
                    this.giftLayout.setViewModel(appViewViewModel);
                }
                if ((2621442 & j4) != 0) {
                    this.introduceView.setVisibility(i12);
                }
                if ((j4 & 3145738) != 0) {
                    String str30 = null;
                    TextViewBindingAdapters.setTextViewLinkable(this.introduceView, str13, num, str30, null, null, str30);
                }
                if ((j4 & 2105346) != 0) {
                    Boolean bool2 = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str14, null, 2131231374, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
                }
                if ((j4 & 2097218) != 0) {
                    TextViewBindingAdapter.setText(this.mboundView10, str7);
                }
                if ((2097282 & j4) != 0) {
                    TextViewBindingAdapter.setText(this.mboundView12, str4);
                }
                if ((j4 & 2113546) != 0) {
                    this.mboundView24.setVisibility(i16);
                    this.mboundView32.setVisibility(i20);
                }
                if ((2129922 & j4) != 0) {
                    this.mboundView30.setVisibility(i3);
                }
                if ((2097170 & j4) != 0) {
                    TextViewBindingAdapter.setText(this.mboundView4, str2);
                    TextViewBindingAdapter.setText(this.mboundView8, str2);
                }
                if ((2097186 & j4) != 0) {
                    TextViewBindingAdapter.setText(this.mboundView5, str3);
                    TextViewBindingAdapter.setText(this.mboundView9, str3);
                }
                if ((2097666 & j4) != 0) {
                    TextViewBindingAdapter.setText(this.ratingAverage, str6);
                }
                if ((2097410 & j4) != 0) {
                    RatingBarBindingAdapter.setRating(this.ratingBarAverage, f2);
                }
                if ((2097158 & j4) != 0) {
                    TextViewBindingAdapter.setText(this.titleView, str5);
                }
                if ((j4 & 2113538) != 0) {
                    this.xposedPluginLayout.setVisibility(i2);
                }
                executeBindingsOn(this.giftLayout);
            }
        }
        i17 = 0;
        if ((j4 & 576460752303423488L) == 0) {
        }
        i18 = ((j4 & 2113546) > j5 ? 1 : ((j4 & 2113546) == j5 ? 0 : -1));
        if (i18 == 0) {
        }
        if ((j4 & 2097162) == 0) {
        }
        if ((2098178 & j4) != 0) {
        }
        if ((2097152 & j4) != 0) {
        }
        if ((j4 & 2103298) != 0) {
        }
        if ((2228226 & j4) != 0) {
        }
        if ((2162690 & j4) != 0) {
        }
        if ((j4 & 2359298) != 0) {
        }
        if ((2097154 & j4) != 0) {
        }
        if ((2621442 & j4) != 0) {
        }
        if ((j4 & 3145738) != 0) {
        }
        if ((j4 & 2105346) != 0) {
        }
        if ((j4 & 2097218) != 0) {
        }
        if ((2097282 & j4) != 0) {
        }
        if ((j4 & 2113546) != 0) {
        }
        if ((2129922 & j4) != 0) {
        }
        if ((2097170 & j4) != 0) {
        }
        if ((2097186 & j4) != 0) {
        }
        if ((2097666 & j4) != 0) {
        }
        if ((2097410 & j4) != 0) {
        }
        if ((2097158 & j4) != 0) {
        }
        if ((j4 & 2113538) != 0) {
        }
        executeBindingsOn(this.giftLayout);
    }
}
