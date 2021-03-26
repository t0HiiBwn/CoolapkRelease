package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.RatingBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.percentlayout.widget.PercentFrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.ScaleImageView;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;

public class AppNodeHeaderBindingImpl extends AppNodeHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final FrameLayout mboundView0;
    private final PercentFrameLayout mboundView14;
    private final PercentFrameLayout mboundView16;
    private final PercentFrameLayout mboundView18;
    private final TextView mboundView2;
    private final PercentFrameLayout mboundView20;
    private final PercentFrameLayout mboundView22;
    private final FrameLayout mboundView27;
    private final TextView mboundView28;
    private final ImageView mboundView3;
    private final FrameLayout mboundView31;
    private final TextView mboundView32;
    private final TextView mboundView39;
    private final TextView mboundView4;
    private final TextView mboundView41;
    private final ImageView mboundView42;
    private final TextView mboundView43;
    private final TextView mboundView46;
    private final TextView mboundView47;
    private final ImageView mboundView48;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362102, 51);
        sparseIntArray.put(2131362104, 52);
        sparseIntArray.put(2131362105, 53);
        sparseIntArray.put(2131362101, 54);
        sparseIntArray.put(2131362779, 55);
        sparseIntArray.put(2131362345, 56);
        sparseIntArray.put(2131362726, 57);
        sparseIntArray.put(2131362920, 58);
        sparseIntArray.put(2131362741, 59);
        sparseIntArray.put(2131362651, 60);
        sparseIntArray.put(2131362056, 61);
        sparseIntArray.put(2131363645, 62);
        sparseIntArray.put(2131363214, 63);
        sparseIntArray.put(2131363224, 64);
        sparseIntArray.put(2131363206, 65);
        sparseIntArray.put(2131363205, 66);
        sparseIntArray.put(2131363204, 67);
        sparseIntArray.put(2131363203, 68);
        sparseIntArray.put(2131363202, 69);
        sparseIntArray.put(2131362623, 70);
        sparseIntArray.put(2131362340, 71);
        sparseIntArray.put(2131363576, 72);
        sparseIntArray.put(2131362208, 73);
        sparseIntArray.put(2131362220, 74);
        sparseIntArray.put(2131362753, 75);
        sparseIntArray.put(2131363241, 76);
    }

    public AppNodeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 77, sIncludes, sViewsWithIds));
    }

    private AppNodeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (ActionButton) objArr[5], (ActionButton) objArr[6], (FrameLayout) objArr[61], (UserAvatarView) objArr[38], (View) objArr[54], (LinearLayout) objArr[51], (View) objArr[52], (View) objArr[53], (RecyclerView) objArr[73], (LinearLayout) objArr[74], (LinearLayout) objArr[40], (CoolEllipsizeTextView) objArr[44], (TextView) objArr[13], (TextView) objArr[36], (LinearLayout) objArr[35], (RecyclerView) objArr[71], (MaxWidthFrameLayout) objArr[56], (LinearLayout) objArr[37], (ActionButton) objArr[9], (TextView) objArr[8], (LinearLayout) objArr[7], (TextView) objArr[34], (LinearLayout) objArr[33], (RecyclerView) objArr[70], (LinearLayout) objArr[60], (ViewPager) objArr[57], (IndicatorView) objArr[59], (LinearLayout) objArr[75], (CoolEllipsizeTextView) objArr[49], (LinearLayout) objArr[45], (LinearLayout) objArr[55], (LinearAdapterLayout) objArr[30], (RoundedImageView) objArr[1], (View) objArr[58], (TextView) objArr[69], (TextView) objArr[68], (TextView) objArr[67], (TextView) objArr[66], (TextView) objArr[65], (RatingBar) objArr[12], (ScaleImageView) objArr[63], (ImageView) objArr[23], (ImageView) objArr[21], (ImageView) objArr[19], (ImageView) objArr[17], (ImageView) objArr[15], (LinearLayout) objArr[64], (LinearLayout) objArr[10], (RecyclerView) objArr[76], (LinearLayout) objArr[50], (TextView) objArr[29], (ActionButton) objArr[25], (ActionButton) objArr[26], (TextView) objArr[11], (RecyclerView) objArr[72], (Space) objArr[62], (TextView) objArr[24]);
        this.mDirtyFlags = -1;
        this.mDirtyFlags_1 = -1;
        this.actionButton.setTag(null);
        this.actionButton2.setTag(null);
        this.avatarView.setTag(null);
        this.changeLogLayout.setTag(null);
        this.changeLogView.setTag(null);
        this.countView.setTag(null);
        this.couponAllActionView.setTag(null);
        this.couponLayout.setTag(null);
        this.developerView.setTag(null);
        this.followActionView.setTag(null);
        this.followNumView.setTag(null);
        this.followerLayout.setTag(null);
        this.giftAllActionView.setTag(null);
        this.giftLayout.setTag(null);
        this.introduceView.setTag(null);
        this.introductionLayout.setTag(null);
        this.linearView.setTag(null);
        this.logoView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        PercentFrameLayout percentFrameLayout = (PercentFrameLayout) objArr[14];
        this.mboundView14 = percentFrameLayout;
        percentFrameLayout.setTag(null);
        PercentFrameLayout percentFrameLayout2 = (PercentFrameLayout) objArr[16];
        this.mboundView16 = percentFrameLayout2;
        percentFrameLayout2.setTag(null);
        PercentFrameLayout percentFrameLayout3 = (PercentFrameLayout) objArr[18];
        this.mboundView18 = percentFrameLayout3;
        percentFrameLayout3.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        PercentFrameLayout percentFrameLayout4 = (PercentFrameLayout) objArr[20];
        this.mboundView20 = percentFrameLayout4;
        percentFrameLayout4.setTag(null);
        PercentFrameLayout percentFrameLayout5 = (PercentFrameLayout) objArr[22];
        this.mboundView22 = percentFrameLayout5;
        percentFrameLayout5.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[27];
        this.mboundView27 = frameLayout2;
        frameLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[28];
        this.mboundView28 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        FrameLayout frameLayout3 = (FrameLayout) objArr[31];
        this.mboundView31 = frameLayout3;
        frameLayout3.setTag(null);
        TextView textView3 = (TextView) objArr[32];
        this.mboundView32 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[39];
        this.mboundView39 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[4];
        this.mboundView4 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[41];
        this.mboundView41 = textView6;
        textView6.setTag(null);
        ImageView imageView2 = (ImageView) objArr[42];
        this.mboundView42 = imageView2;
        imageView2.setTag(null);
        TextView textView7 = (TextView) objArr[43];
        this.mboundView43 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[46];
        this.mboundView46 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[47];
        this.mboundView47 = textView9;
        textView9.setTag(null);
        ImageView imageView3 = (ImageView) objArr[48];
        this.mboundView48 = imageView3;
        imageView3.setTag(null);
        this.ratingBar.setTag(null);
        this.ratingImageView1.setTag(null);
        this.ratingImageView2.setTag(null);
        this.ratingImageView3.setTag(null);
        this.ratingImageView4.setTag(null);
        this.ratingImageView5.setTag(null);
        this.ratingViewContainer.setTag(null);
        this.relativeLayout.setTag(null);
        this.remarkAuthor.setTag(null);
        this.scoreActionView.setTag(null);
        this.scoreActionView2.setTag(null);
        this.scoreView.setTag(null);
        this.wishView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 524288;
            this.mDirtyFlags_1 = 0;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0) {
                if (this.mDirtyFlags_1 == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (198 != i) {
            return false;
        } else {
            setModel((AppNodeViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AppNodeHeaderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.AppNodeHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AppNodeHeaderBinding
    public void setModel(AppNodeViewModel appNodeViewModel) {
        updateRegistration(8, appNodeViewModel);
        this.mModel = appNodeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeModelMyScore((ObservableInt) obj, i2);
            case 1:
                return onChangeModelShowAllCoupon((ObservableBoolean) obj, i2);
            case 2:
                return onChangeModelIsFollow((ObservableBoolean) obj, i2);
            case 3:
                return onChangeModelShowAllChangeLog((ObservableBoolean) obj, i2);
            case 4:
                return onChangeModelVoteNum((ObservableInt) obj, i2);
            case 5:
                return onChangeModelRatingStar((ObservableFloat) obj, i2);
            case 6:
                return onChangeModelCouponList((ObservableArrayList) obj, i2);
            case 7:
                return onChangeModelServiceApp((ObservableField) obj, i2);
            case 8:
                return onChangeModel((AppNodeViewModel) obj, i2);
            case 9:
                return onChangeModelAppScore((ObservableFloat) obj, i2);
            case 10:
                return onChangeModelShowAllIntroduce((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeModelMyScore(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeModelShowAllCoupon(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeModelIsFollow(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeModelShowAllChangeLog(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeModelVoteNum(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeModelRatingStar(ObservableFloat observableFloat, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeModelCouponList(ObservableArrayList<CouponInfo> observableArrayList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeModelServiceApp(ObservableField<ServiceApp> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeModel(AppNodeViewModel appNodeViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 32) {
            synchronized (this) {
                this.mDirtyFlags |= 8192;
            }
            return true;
        } else if (i == 249) {
            synchronized (this) {
                this.mDirtyFlags |= 16384;
            }
            return true;
        } else if (i == 68) {
            synchronized (this) {
                this.mDirtyFlags |= 32768;
            }
            return true;
        } else if (i == 72) {
            synchronized (this) {
                this.mDirtyFlags |= 65536;
            }
            return true;
        } else if (i == 70) {
            synchronized (this) {
                this.mDirtyFlags |= 131072;
            }
            return true;
        } else if (i != 47) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 262144;
            }
            return true;
        }
    }

    private boolean onChangeModelAppScore(ObservableFloat observableFloat, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeModelShowAllIntroduce(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04e1  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0519  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x052b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x05a5  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x05b5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x06c9  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x070c  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0717  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0725  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0730  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x07f4  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0841  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x084d  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0895  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x08a6  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x08ce  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x08d7  */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x08e8  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x08f5  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x090b  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x0933  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x09ca  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x09fc  */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0a08  */
    /* JADX WARNING: Removed duplicated region for block: B:429:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0a20  */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x0a2f  */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x0a3c  */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x0a52  */
    /* JADX WARNING: Removed duplicated region for block: B:446:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0192  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        int i;
        int i2;
        float f;
        int i3;
        String str2;
        String str3;
        boolean z;
        String str4;
        boolean z2;
        String str5;
        String str6;
        String str7;
        int i4;
        long j3;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z3;
        Drawable drawable;
        String str12;
        String str13;
        int i5;
        int i6;
        long j4;
        View.OnClickListener onClickListener;
        String str14;
        String str15;
        String str16;
        String str17;
        int i7;
        int i8;
        int i9;
        boolean z4;
        String str18;
        int i10;
        boolean z5;
        int i11;
        String str19;
        String str20;
        int i12;
        ServiceApp serviceApp;
        int i13;
        int i14;
        boolean z6;
        int i15;
        boolean z7;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        View.OnClickListener onClickListener2;
        String str21;
        long j5;
        long j6;
        int i22;
        ObservableBoolean observableBoolean;
        boolean z8;
        String str22;
        String str23;
        boolean z9;
        int i23;
        int i24;
        String str24;
        String str25;
        int i25;
        int i26;
        String str26;
        String str27;
        String str28;
        float f2;
        int i27;
        boolean z10;
        int i28;
        boolean z11;
        String str29;
        String str30;
        int i29;
        int i30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        boolean z12;
        int i31;
        String str36;
        int i32;
        float f3;
        String str37;
        int i33;
        int i34;
        int i35;
        int i36;
        String str38;
        ServiceApp serviceApp2;
        String str39;
        ServiceApp serviceApp3;
        String str40;
        int i37;
        long j7;
        int i38;
        int i39;
        String str41;
        boolean z13;
        long j8;
        long j9;
        ObservableFloat observableFloat;
        boolean z14;
        ObservableField<ServiceApp> observableField;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        List<ServiceApp> list;
        String str48;
        boolean z15;
        String str49;
        int i40;
        int i41;
        boolean z16;
        int i42;
        boolean z17;
        boolean z18;
        long j10;
        long j11;
        int i43;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0;
        }
        View.OnClickListener onClickListener3 = this.mClick;
        AppNodeViewModel appNodeViewModel = this.mModel;
        int i44 = ((j & 528768) > 0 ? 1 : ((j & 528768) == 0 ? 0 : -1));
        if ((1046527 & j) != 0) {
            String changeLogSubtitle = ((j & 786688) == 0 || appNodeViewModel == null) ? null : appNodeViewModel.getChangeLogSubtitle();
            int i45 = ((j & 524545) > 0 ? 1 : ((j & 524545) == 0 ? 0 : -1));
            if (i45 != 0) {
                ObservableInt myScore = appNodeViewModel != null ? appNodeViewModel.getMyScore() : null;
                updateRegistration(0, myScore);
                if (myScore != null) {
                    i43 = myScore.get();
                } else {
                    i43 = 0;
                }
                z8 = i43 != 0;
                if (i45 != 0) {
                    j |= z8 ? 2147483648L : 1073741824;
                }
                str22 = z8 ? this.scoreActionView.getResources().getString(2131886672) : this.scoreActionView.getResources().getString(2131886678);
            } else {
                str22 = null;
                z8 = false;
            }
            String appSubtitle = ((j & 532736) == 0 || appNodeViewModel == null) ? null : appNodeViewModel.getAppSubtitle();
            int i46 = ((j & 524548) > 0 ? 1 : ((j & 524548) == 0 ? 0 : -1));
            if (i46 != 0) {
                ObservableBoolean isFollow = appNodeViewModel != null ? appNodeViewModel.isFollow() : null;
                updateRegistration(2, isFollow);
                if (isFollow != null) {
                    z9 = isFollow.get();
                } else {
                    z9 = false;
                }
                if (i46 != 0) {
                    j |= z9 ? 34359738368L : 17179869184L;
                }
                str23 = this.followActionView.getResources().getString(z9 ? 2131887204 : 2131887205);
            } else {
                str23 = null;
                z9 = false;
            }
            int i47 = ((j & 524552) > 0 ? 1 : ((j & 524552) == 0 ? 0 : -1));
            if (i47 != 0) {
                ObservableBoolean showAllChangeLog = appNodeViewModel != null ? appNodeViewModel.getShowAllChangeLog() : null;
                updateRegistration(3, showAllChangeLog);
                if (showAllChangeLog != null) {
                    z18 = showAllChangeLog.get();
                } else {
                    z18 = false;
                }
                if (i47 != 0) {
                    if (z18) {
                        j11 = j | 8796093022208L | 140737488355328L;
                        j10 = 2251799813685248L;
                    } else {
                        j11 = j | 4398046511104L | 70368744177664L;
                        j10 = 1125899906842624L;
                    }
                    j = j11 | j10;
                }
                i24 = z18 ? Integer.MAX_VALUE : 3;
                i23 = z18 ? 180 : 0;
                str24 = z18 ? this.mboundView41.getResources().getString(2131886674) : this.mboundView41.getResources().getString(2131886677);
            } else {
                str24 = null;
                i24 = 0;
                i23 = 0;
            }
            if ((j & 590080) != 0) {
                UserInfo developerUserInfo = appNodeViewModel != null ? appNodeViewModel.getDeveloperUserInfo() : null;
                if (developerUserInfo != null) {
                    str25 = developerUserInfo.getVerifyStatusIcon();
                    i25 = ((j & 540928) > 0 ? 1 : ((j & 540928) == 0 ? 0 : -1));
                    if (i25 != 0) {
                        if (appNodeViewModel != null) {
                            z17 = appNodeViewModel.isShowDeveloper();
                        } else {
                            z17 = false;
                        }
                        if (i25 != 0) {
                            j |= z17 ? 8589934592L : 4294967296L;
                        }
                        if (!z17) {
                            i26 = 8;
                            if ((j & 524560) != 0) {
                                ObservableInt voteNum = appNodeViewModel != null ? appNodeViewModel.getVoteNum() : null;
                                updateRegistration(4, voteNum);
                                str27 = str24;
                                str26 = changeLogSubtitle;
                                str28 = this.countView.getResources().getString(2131886679, Integer.valueOf(voteNum != null ? voteNum.get() : 0));
                            } else {
                                str27 = str24;
                                str26 = changeLogSubtitle;
                                str28 = null;
                            }
                            if ((524576 & j) != 0) {
                                ObservableFloat ratingStar = appNodeViewModel != null ? appNodeViewModel.getRatingStar() : null;
                                updateRegistration(5, ratingStar);
                                if (ratingStar != null) {
                                    f2 = ratingStar.get();
                                    i27 = ((j & 524610) > 0 ? 1 : ((j & 524610) == 0 ? 0 : -1));
                                    if (i27 == 0) {
                                        ObservableArrayList<CouponInfo> couponList = appNodeViewModel != null ? appNodeViewModel.getCouponList() : null;
                                        updateRegistration(6, couponList);
                                        if (couponList != null) {
                                            i42 = couponList.size();
                                        } else {
                                            i42 = 0;
                                        }
                                        z10 = i42 > 3;
                                        if (i27 != 0) {
                                            j = z10 ? j | 549755813888L : j | 274877906944L;
                                        }
                                    } else {
                                        z10 = false;
                                    }
                                    i28 = ((j & 528768) > 0 ? 1 : ((j & 528768) == 0 ? 0 : -1));
                                    if (i28 == 0) {
                                        if (appNodeViewModel != null) {
                                            z14 = appNodeViewModel.isDarkTheme();
                                            f3 = f2;
                                            str37 = str28;
                                            observableField = appNodeViewModel.getServiceApp();
                                        } else {
                                            str37 = str28;
                                            f3 = f2;
                                            observableField = null;
                                            z14 = false;
                                        }
                                        updateRegistration(7, observableField);
                                        if (i28 != 0) {
                                            j |= z14 ? 2305843009213693952L : 1152921504606846976L;
                                        }
                                        Drawable drawable2 = AppCompatResources.getDrawable(this.logoView.getContext(), z14 ? 2131231420 : 2131231419);
                                        serviceApp2 = observableField != null ? observableField.get() : null;
                                        int i48 = ((j & 524672) > 0 ? 1 : ((j & 524672) == 0 ? 0 : -1));
                                        if (i48 != 0) {
                                            if (serviceApp2 != null) {
                                                z15 = serviceApp2.getHasCoupon();
                                                int giftCount = serviceApp2.getGiftCount();
                                                String changeLog = serviceApp2.getChangeLog();
                                                List<ServiceApp> relatedRows = serviceApp2.getRelatedRows();
                                                int isDownloadApp = serviceApp2.getIsDownloadApp();
                                                str47 = serviceApp2.getFollowCount();
                                                String apkType = serviceApp2.getApkType();
                                                str46 = serviceApp2.getRemark();
                                                str45 = serviceApp2.getReviewer();
                                                str44 = serviceApp2.getIntroduce();
                                                str43 = serviceApp2.getApkSubTitle();
                                                str42 = serviceApp2.getAppName();
                                                drawable = drawable2;
                                                i41 = giftCount;
                                                z3 = z10;
                                                i40 = isDownloadApp;
                                                list = relatedRows;
                                                str48 = changeLog;
                                                z12 = z8;
                                                str49 = apkType;
                                            } else {
                                                drawable = drawable2;
                                                z3 = z10;
                                                z12 = z8;
                                                str49 = null;
                                                str48 = null;
                                                list = null;
                                                str47 = null;
                                                str46 = null;
                                                str45 = null;
                                                str44 = null;
                                                str43 = null;
                                                str42 = null;
                                                i41 = 0;
                                                i40 = 0;
                                                z15 = false;
                                            }
                                            if (i48 != 0) {
                                                j |= z15 ? 8388608 : 4194304;
                                            }
                                            int i49 = z15 ? 0 : 8;
                                            boolean z19 = i41 > 1;
                                            boolean z20 = i41 > 0;
                                            boolean isEmpty = TextUtils.isEmpty(str48);
                                            boolean z21 = i40 != 1;
                                            str30 = appSubtitle;
                                            z11 = z9;
                                            String string = this.followNumView.getResources().getString(2131886675, str47);
                                            boolean isEmpty2 = TextUtils.isEmpty(str46);
                                            boolean isEmpty3 = TextUtils.isEmpty(str45);
                                            boolean isEmpty4 = TextUtils.isEmpty(str44);
                                            if ((j & 524672) != 0) {
                                                j |= z19 ? 576460752303423488L : 288230376151711744L;
                                            }
                                            int i50 = ((j & 524672) > 0 ? 1 : ((j & 524672) == 0 ? 0 : -1));
                                            if (i50 != 0) {
                                                j2 |= z20 ? 8 : 4;
                                            }
                                            if (i50 != 0) {
                                                j2 |= isEmpty ? 128 : 64;
                                            }
                                            if (i50 != 0) {
                                                j = z21 ? j | 134217728 : j | 67108864;
                                            }
                                            if ((j & 524672) != 0) {
                                                if (isEmpty2) {
                                                    j |= 35184372088832L;
                                                    j2 |= 2;
                                                } else {
                                                    j |= 17592186044416L;
                                                    j2 |= 1;
                                                }
                                            }
                                            if ((j & 524672) != 0) {
                                                j |= isEmpty3 ? Long.MIN_VALUE : 4611686018427387904L;
                                            }
                                            if ((j & 524672) != 0) {
                                                j |= isEmpty4 ? 9007199254740992L : 4503599627370496L;
                                            }
                                            int size = list != null ? list.size() : 0;
                                            if (str49 != null) {
                                                z16 = str49.equals("2");
                                            } else {
                                                z16 = false;
                                            }
                                            if ((j & 524672) != 0) {
                                                j |= z16 ? 2097152 : 1048576;
                                            }
                                            int i51 = z19 ? 0 : 8;
                                            int i52 = z20 ? 0 : 8;
                                            int i53 = isEmpty ? 8 : 0;
                                            i30 = isEmpty2 ? 8 : 0;
                                            int i54 = isEmpty3 ? 8 : 0;
                                            i31 = isEmpty4 ? 8 : 0;
                                            boolean z22 = size == 0;
                                            if (z16) {
                                                i29 = i52;
                                                str38 = this.mboundView46.getResources().getString(2131886676);
                                            } else {
                                                i29 = i52;
                                                str38 = this.mboundView46.getResources().getString(2131886673);
                                            }
                                            if ((j & 524672) != 0) {
                                                j |= z22 ? 36028797018963968L : 18014398509481984L;
                                            }
                                            int i55 = z22 ? 8 : 0;
                                            str36 = string;
                                            str29 = str42;
                                            z5 = z21;
                                            i36 = i49;
                                            str31 = str43;
                                            i33 = i54;
                                            str32 = str44;
                                            z4 = isEmpty2;
                                            str33 = str45;
                                            i34 = i51;
                                            str34 = str46;
                                            str35 = str48;
                                            i32 = i53;
                                            i35 = i55;
                                            j2 = j2;
                                        } else {
                                            drawable = drawable2;
                                            z3 = z10;
                                            z12 = z8;
                                            str30 = appSubtitle;
                                            z11 = z9;
                                            str38 = null;
                                            str36 = null;
                                            str35 = null;
                                            str34 = null;
                                            str33 = null;
                                            str32 = null;
                                            str31 = null;
                                            str29 = null;
                                            i36 = 0;
                                            z5 = false;
                                            i35 = 0;
                                            i34 = 0;
                                            z4 = false;
                                            i33 = 0;
                                            i32 = 0;
                                            i31 = 0;
                                            i30 = 0;
                                            i29 = 0;
                                        }
                                        str8 = serviceApp2 != null ? serviceApp2.getLogo() : null;
                                    } else {
                                        str37 = str28;
                                        f3 = f2;
                                        z3 = z10;
                                        z12 = z8;
                                        str30 = appSubtitle;
                                        z11 = z9;
                                        serviceApp2 = null;
                                        str38 = null;
                                        drawable = null;
                                        str36 = null;
                                        str35 = null;
                                        str34 = null;
                                        str33 = null;
                                        str32 = null;
                                        str31 = null;
                                        str29 = null;
                                        str8 = null;
                                        i36 = 0;
                                        z5 = false;
                                        i35 = 0;
                                        i34 = 0;
                                        z4 = false;
                                        i33 = 0;
                                        i32 = 0;
                                        i31 = 0;
                                        i30 = 0;
                                        i29 = 0;
                                    }
                                    if ((j & 525056) == 0) {
                                        if (appNodeViewModel != null) {
                                            str39 = str38;
                                            serviceApp3 = serviceApp2;
                                            observableFloat = appNodeViewModel.getAppScore();
                                        } else {
                                            serviceApp3 = serviceApp2;
                                            str39 = str38;
                                            observableFloat = null;
                                        }
                                        updateRegistration(9, observableFloat);
                                        float f4 = observableFloat != null ? observableFloat.get() : 0.0f;
                                        StringBuilder sb = new StringBuilder();
                                        j3 = j2;
                                        sb.append("");
                                        sb.append(f4);
                                        str40 = sb.toString();
                                    } else {
                                        serviceApp3 = serviceApp2;
                                        str39 = str38;
                                        j3 = j2;
                                        str40 = null;
                                    }
                                    String developerName = ((655616 & j) != 0 || appNodeViewModel == null) ? null : appNodeViewModel.getDeveloperName();
                                    i37 = ((525568 & j) > 0 ? 1 : ((525568 & j) == 0 ? 0 : -1));
                                    if (i37 == 0) {
                                        ObservableBoolean showAllIntroduce = appNodeViewModel != null ? appNodeViewModel.getShowAllIntroduce() : null;
                                        updateRegistration(10, showAllIntroduce);
                                        if (showAllIntroduce != null) {
                                            z13 = showAllIntroduce.get();
                                        } else {
                                            z13 = false;
                                        }
                                        if (i37 != 0) {
                                            if (z13) {
                                                j9 = j | 137438953472L | 2199023255552L;
                                                j8 = 144115188075855872L;
                                            } else {
                                                j9 = j | 68719476736L | 1099511627776L;
                                                j8 = 72057594037927936L;
                                            }
                                            j = j9 | j8;
                                        }
                                        int i56 = z13 ? Integer.MAX_VALUE : 4;
                                        String string2 = this.mboundView47.getResources().getString(z13 ? 2131886674 : 2131886677);
                                        int i57 = z13 ? 180 : 0;
                                        str41 = string2;
                                        i38 = i56;
                                        j7 = 557312;
                                        i39 = i57;
                                        j = j;
                                    } else {
                                        str41 = null;
                                        i39 = 0;
                                        i38 = 0;
                                        j7 = 557312;
                                    }
                                    j4 = 0;
                                    if ((j & j7) != 0 || appNodeViewModel == null) {
                                        str3 = str23;
                                        str2 = str25;
                                        i3 = i24;
                                        i4 = i38;
                                        str = null;
                                        str6 = str22;
                                        i2 = i23;
                                        i = i26;
                                        str7 = str27;
                                        str5 = str26;
                                        f = f3;
                                        z2 = z12;
                                        str13 = str33;
                                        str10 = str32;
                                        str12 = str31;
                                        i9 = i29;
                                        str4 = str30;
                                        z = z11;
                                        str9 = str39;
                                    } else {
                                        str3 = str23;
                                        str2 = str25;
                                        i3 = i24;
                                        i4 = i38;
                                        str6 = str22;
                                        i2 = i23;
                                        i = i26;
                                        str7 = str27;
                                        str5 = str26;
                                        f = f3;
                                        z2 = z12;
                                        str13 = str33;
                                        str10 = str32;
                                        str12 = str31;
                                        i9 = i29;
                                        str4 = str30;
                                        z = z11;
                                        str9 = str39;
                                        str = appNodeViewModel.getDeveloperAvatar();
                                    }
                                    onClickListener = onClickListener3;
                                    str16 = str40;
                                    str17 = developerName;
                                    str15 = str41;
                                    i7 = i39;
                                    i8 = i34;
                                    i6 = i33;
                                    str14 = str37;
                                    str20 = str36;
                                    i13 = i31;
                                    str18 = str35;
                                    str11 = str34;
                                    i12 = i30;
                                    str19 = str29;
                                    serviceApp = serviceApp3;
                                    i5 = i35;
                                    i10 = i36;
                                    i11 = i32;
                                }
                            }
                            f2 = 0.0f;
                            i27 = ((j & 524610) > 0 ? 1 : ((j & 524610) == 0 ? 0 : -1));
                            if (i27 == 0) {
                            }
                            i28 = ((j & 528768) > 0 ? 1 : ((j & 528768) == 0 ? 0 : -1));
                            if (i28 == 0) {
                            }
                            if ((j & 525056) == 0) {
                            }
                            if ((655616 & j) != 0) {
                            }
                            i37 = ((525568 & j) > 0 ? 1 : ((525568 & j) == 0 ? 0 : -1));
                            if (i37 == 0) {
                            }
                            j4 = 0;
                            if ((j & j7) != 0) {
                            }
                            str3 = str23;
                            str2 = str25;
                            i3 = i24;
                            i4 = i38;
                            str = null;
                            str6 = str22;
                            i2 = i23;
                            i = i26;
                            str7 = str27;
                            str5 = str26;
                            f = f3;
                            z2 = z12;
                            str13 = str33;
                            str10 = str32;
                            str12 = str31;
                            i9 = i29;
                            str4 = str30;
                            z = z11;
                            str9 = str39;
                            onClickListener = onClickListener3;
                            str16 = str40;
                            str17 = developerName;
                            str15 = str41;
                            i7 = i39;
                            i8 = i34;
                            i6 = i33;
                            str14 = str37;
                            str20 = str36;
                            i13 = i31;
                            str18 = str35;
                            str11 = str34;
                            i12 = i30;
                            str19 = str29;
                            serviceApp = serviceApp3;
                            i5 = i35;
                            i10 = i36;
                            i11 = i32;
                        }
                    }
                    i26 = 0;
                    if ((j & 524560) != 0) {
                    }
                    if ((524576 & j) != 0) {
                    }
                    f2 = 0.0f;
                    i27 = ((j & 524610) > 0 ? 1 : ((j & 524610) == 0 ? 0 : -1));
                    if (i27 == 0) {
                    }
                    i28 = ((j & 528768) > 0 ? 1 : ((j & 528768) == 0 ? 0 : -1));
                    if (i28 == 0) {
                    }
                    if ((j & 525056) == 0) {
                    }
                    if ((655616 & j) != 0) {
                    }
                    i37 = ((525568 & j) > 0 ? 1 : ((525568 & j) == 0 ? 0 : -1));
                    if (i37 == 0) {
                    }
                    j4 = 0;
                    if ((j & j7) != 0) {
                    }
                    str3 = str23;
                    str2 = str25;
                    i3 = i24;
                    i4 = i38;
                    str = null;
                    str6 = str22;
                    i2 = i23;
                    i = i26;
                    str7 = str27;
                    str5 = str26;
                    f = f3;
                    z2 = z12;
                    str13 = str33;
                    str10 = str32;
                    str12 = str31;
                    i9 = i29;
                    str4 = str30;
                    z = z11;
                    str9 = str39;
                    onClickListener = onClickListener3;
                    str16 = str40;
                    str17 = developerName;
                    str15 = str41;
                    i7 = i39;
                    i8 = i34;
                    i6 = i33;
                    str14 = str37;
                    str20 = str36;
                    i13 = i31;
                    str18 = str35;
                    str11 = str34;
                    i12 = i30;
                    str19 = str29;
                    serviceApp = serviceApp3;
                    i5 = i35;
                    i10 = i36;
                    i11 = i32;
                }
            }
            str25 = null;
            i25 = ((j & 540928) > 0 ? 1 : ((j & 540928) == 0 ? 0 : -1));
            if (i25 != 0) {
            }
            i26 = 0;
            if ((j & 524560) != 0) {
            }
            if ((524576 & j) != 0) {
            }
            f2 = 0.0f;
            i27 = ((j & 524610) > 0 ? 1 : ((j & 524610) == 0 ? 0 : -1));
            if (i27 == 0) {
            }
            i28 = ((j & 528768) > 0 ? 1 : ((j & 528768) == 0 ? 0 : -1));
            if (i28 == 0) {
            }
            if ((j & 525056) == 0) {
            }
            if ((655616 & j) != 0) {
            }
            i37 = ((525568 & j) > 0 ? 1 : ((525568 & j) == 0 ? 0 : -1));
            if (i37 == 0) {
            }
            j4 = 0;
            if ((j & j7) != 0) {
            }
            str3 = str23;
            str2 = str25;
            i3 = i24;
            i4 = i38;
            str = null;
            str6 = str22;
            i2 = i23;
            i = i26;
            str7 = str27;
            str5 = str26;
            f = f3;
            z2 = z12;
            str13 = str33;
            str10 = str32;
            str12 = str31;
            i9 = i29;
            str4 = str30;
            z = z11;
            str9 = str39;
            onClickListener = onClickListener3;
            str16 = str40;
            str17 = developerName;
            str15 = str41;
            i7 = i39;
            i8 = i34;
            i6 = i33;
            str14 = str37;
            str20 = str36;
            i13 = i31;
            str18 = str35;
            str11 = str34;
            i12 = i30;
            str19 = str29;
            serviceApp = serviceApp3;
            i5 = i35;
            i10 = i36;
            i11 = i32;
        } else {
            j4 = 0;
            onClickListener = onClickListener3;
            j3 = j2;
            serviceApp = null;
            str20 = null;
            str19 = null;
            str18 = null;
            str17 = null;
            str16 = null;
            str15 = null;
            str14 = null;
            str13 = null;
            str12 = null;
            drawable = null;
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
            i13 = 0;
            i12 = 0;
            i11 = 0;
            z5 = false;
            i10 = 0;
            z4 = false;
            i9 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            z3 = false;
            i4 = 0;
            z2 = false;
            z = false;
            i3 = 0;
            f = 0.0f;
            i2 = 0;
            i = 0;
        }
        if ((j & 549755813888L) != j4) {
            if (appNodeViewModel != null) {
                observableBoolean = appNodeViewModel.getShowAllCoupon();
                i14 = i12;
            } else {
                i14 = i12;
                observableBoolean = null;
            }
            i15 = 1;
            updateRegistration(1, observableBoolean);
            z6 = !(observableBoolean != null ? observableBoolean.get() : false);
        } else {
            i14 = i12;
            i15 = 1;
            z6 = false;
        }
        boolean z23 = (j3 & 2) != 0 ? !TextUtils.isEmpty(str12) : false;
        if ((j & 134217728) != 0) {
            if (serviceApp != null) {
                i22 = serviceApp.getIsForumApp();
            } else {
                i22 = 0;
            }
            if (i22 == i15) {
                z7 = true;
                i16 = ((j & 524672) > 0 ? 1 : ((j & 524672) == 0 ? 0 : -1));
                if (i16 == 0) {
                    if (!z5) {
                        z7 = false;
                    }
                    if (!z4) {
                        z23 = false;
                    }
                    if (i16 != 0) {
                        if (z7) {
                            j6 = j | 33554432;
                            j5 = 562949953421312L;
                        } else {
                            j6 = j | 16777216;
                            j5 = 281474976710656L;
                        }
                        j = j6 | j5;
                    }
                    if ((j & 524672) != 0) {
                        j |= z23 ? 536870912 : 268435456;
                    }
                    i18 = z7 ? 0 : 8;
                    i19 = z7 ? 8 : 0;
                    if (!z23) {
                        i17 = 8;
                        i20 = ((j & 524610) > 0 ? 1 : ((j & 524610) == 0 ? 0 : -1));
                        if (i20 != 0) {
                            if (!z3) {
                                z6 = false;
                            }
                            i21 = z6 ? 0 : 8;
                        } else {
                            i21 = 0;
                        }
                        if ((j & 524672) != 0) {
                            this.actionButton.setVisibility(i19);
                            this.actionButton2.setVisibility(i18);
                            this.changeLogLayout.setVisibility(i11);
                            TextViewBindingAdapter.setText(this.changeLogView, str18);
                            this.couponLayout.setVisibility(i10);
                            TextViewBindingAdapter.setText(this.followNumView, str20);
                            this.giftAllActionView.setVisibility(i8);
                            this.giftLayout.setVisibility(i9);
                            Integer num = null;
                            String str50 = null;
                            Boolean bool = null;
                            Html.ImageGetter imageGetter = null;
                            TextViewBindingAdapters.setTextViewLinkable(this.introduceView, str10, num, str50, bool, imageGetter, str50);
                            this.introductionLayout.setVisibility(i13);
                            TextViewBindingAdapter.setText(this.mboundView2, str19);
                            this.mboundView27.setVisibility(i14);
                            TextViewBindingAdapters.setTextViewLinkable(this.mboundView28, str11, num, str50, bool, imageGetter, str50);
                            this.mboundView3.setVisibility(i18);
                            this.mboundView31.setVisibility(i17);
                            TextViewBindingAdapters.setTextViewLinkable(this.mboundView32, str12, num, str50, bool, imageGetter, str50);
                            TextViewBindingAdapter.setText(this.mboundView46, str9);
                            this.relativeLayout.setVisibility(i5);
                            this.remarkAuthor.setVisibility(i6);
                            TextViewBindingAdapters.setTextViewLinkable(this.remarkAuthor, str13, num, "#FFFFFF", bool, imageGetter, str50);
                            this.scoreActionView.setVisibility(i19);
                            this.scoreActionView2.setVisibility(i18);
                        }
                        if ((528384 & j) != 0) {
                            Boolean bool2 = null;
                            onClickListener2 = onClickListener;
                            ViewBindingAdapters.clickListener(this.actionButton, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.actionButton2, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.changeLogLayout, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.couponAllActionView, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.developerView, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.followActionView, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.followerLayout, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.giftAllActionView, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.introductionLayout, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.ratingViewContainer, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.relativeLayout, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.scoreActionView, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.scoreActionView2, onClickListener2, bool2);
                            ViewBindingAdapters.clickListener(this.wishView, onClickListener2, bool2);
                        } else {
                            onClickListener2 = onClickListener;
                        }
                        if ((557312 & j) != 0) {
                            Boolean bool3 = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, AppCompatResources.getDrawable(this.avatarView.getContext(), 2131231374), 0, 0, bool3, bool3, bool3, bool3, bool3, null, null, null, bool3, bool3, bool3, null, bool3);
                        }
                        if ((j & 590080) != 0) {
                            ImageViewBindingAdapters.setVipSignView(this.avatarView, str2, null);
                        }
                        if ((j & 524552) != 0) {
                            this.changeLogView.setMaxLines(i3);
                            TextViewBindingAdapter.setText(this.mboundView41, str7);
                            if (getBuildSdkInt() >= 11) {
                                this.mboundView42.setRotation((float) i2);
                            }
                        }
                        if ((524560 & j) != 0) {
                            TextViewBindingAdapter.setText(this.countView, str14);
                        }
                        if (i20 != 0) {
                            this.couponAllActionView.setVisibility(i21);
                        }
                        if ((540928 & j) != 0) {
                            this.developerView.setVisibility(i);
                        }
                        if ((j & 524548) != 0) {
                            TextViewBindingAdapter.setText(this.followActionView, str3);
                            this.followActionView.setSelected(z);
                        }
                        if ((525568 & j) != 0) {
                            this.introduceView.setMaxLines(i4);
                            TextViewBindingAdapter.setText(this.mboundView47, str15);
                            if (getBuildSdkInt() >= 11) {
                                this.mboundView48.setRotation((float) i7);
                            }
                        }
                        if ((524288 & j) != 0) {
                            String str51 = null;
                            ViewBindingAdapters.clipView(this.linearView, str51, 8);
                            ViewBindingAdapters.clipView(this.mboundView14, str51, 4);
                            ViewBindingAdapters.clipView(this.mboundView16, str51, 4);
                            ViewBindingAdapters.clipView(this.mboundView18, str51, 4);
                            ViewBindingAdapters.clipView(this.mboundView20, str51, 4);
                            ViewBindingAdapters.clipView(this.mboundView22, str51, 4);
                            ViewBindingAdapters.clipView(this.ratingImageView1, str51, 4);
                            ViewBindingAdapters.clipView(this.ratingImageView2, str51, 4);
                            ViewBindingAdapters.clipView(this.ratingImageView3, str51, 4);
                            ViewBindingAdapters.clipView(this.ratingImageView4, str51, 4);
                            ViewBindingAdapters.clipView(this.ratingImageView5, str51, 4);
                            ViewBindingAdapters.clipView(this.ratingViewContainer, str51, 8);
                            Number number = null;
                            ViewBindingAdapters.clipView(this.scoreActionView, "capsule", number);
                            this.scoreActionView2.setSelected(true);
                            ViewBindingAdapters.clipView(this.wishView, "capsule", number);
                        }
                        if ((528768 & j) != 0) {
                            Boolean bool4 = null;
                            str21 = str17;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str8, drawable, 0, 0, bool4, bool4, bool4, bool4, bool4, null, null, null, bool4, bool4, bool4, onClickListener2, bool4);
                        } else {
                            str21 = str17;
                        }
                        if ((655616 & j) != 0) {
                            TextViewBindingAdapter.setText(this.mboundView39, str21);
                        }
                        if ((j & 532736) != 0) {
                            TextViewBindingAdapter.setText(this.mboundView4, str4);
                        }
                        if ((j & 786688) != 0) {
                            TextViewBindingAdapter.setText(this.mboundView43, str5);
                        }
                        if ((524576 & j) != 0) {
                            RatingBarBindingAdapter.setRating(this.ratingBar, f);
                        }
                        if ((j & 524545) != 0) {
                            TextViewBindingAdapter.setText(this.scoreActionView, str6);
                            this.scoreActionView.setSelected(z2);
                        }
                        if ((j & 525056) != 0) {
                            TextViewBindingAdapter.setText(this.scoreView, str16);
                            return;
                        }
                        return;
                    }
                } else {
                    i19 = 0;
                    i18 = 0;
                }
                i17 = 0;
                i20 = ((j & 524610) > 0 ? 1 : ((j & 524610) == 0 ? 0 : -1));
                if (i20 != 0) {
                }
                if ((j & 524672) != 0) {
                }
                if ((528384 & j) != 0) {
                }
                if ((557312 & j) != 0) {
                }
                if ((j & 590080) != 0) {
                }
                if ((j & 524552) != 0) {
                }
                if ((524560 & j) != 0) {
                }
                if (i20 != 0) {
                }
                if ((540928 & j) != 0) {
                }
                if ((j & 524548) != 0) {
                }
                if ((525568 & j) != 0) {
                }
                if ((524288 & j) != 0) {
                }
                if ((528768 & j) != 0) {
                }
                if ((655616 & j) != 0) {
                }
                if ((j & 532736) != 0) {
                }
                if ((j & 786688) != 0) {
                }
                if ((524576 & j) != 0) {
                }
                if ((j & 524545) != 0) {
                }
                if ((j & 525056) != 0) {
                }
            }
        }
        z7 = false;
        i16 = ((j & 524672) > 0 ? 1 : ((j & 524672) == 0 ? 0 : -1));
        if (i16 == 0) {
        }
        i17 = 0;
        i20 = ((j & 524610) > 0 ? 1 : ((j & 524610) == 0 ? 0 : -1));
        if (i20 != 0) {
        }
        if ((j & 524672) != 0) {
        }
        if ((528384 & j) != 0) {
        }
        if ((557312 & j) != 0) {
        }
        if ((j & 590080) != 0) {
        }
        if ((j & 524552) != 0) {
        }
        if ((524560 & j) != 0) {
        }
        if (i20 != 0) {
        }
        if ((540928 & j) != 0) {
        }
        if ((j & 524548) != 0) {
        }
        if ((525568 & j) != 0) {
        }
        if ((524288 & j) != 0) {
        }
        if ((528768 & j) != 0) {
        }
        if ((655616 & j) != 0) {
        }
        if ((j & 532736) != 0) {
        }
        if ((j & 786688) != 0) {
        }
        if ((524576 & j) != 0) {
        }
        if ((j & 524545) != 0) {
        }
        if ((j & 525056) != 0) {
        }
    }
}
