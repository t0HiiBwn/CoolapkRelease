package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.makeramen.roundedimageview.RoundedImageView;

public class AppNodeCommunityHeaderBindingImpl extends AppNodeCommunityHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final TextView mboundView11;
    private final TextView mboundView13;
    private final TextView mboundView14;
    private final ImageView mboundView15;
    private final TextView mboundView2;
    private final ImageView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362099, 17);
        sparseIntArray.put(2131362101, 18);
        sparseIntArray.put(2131362102, 19);
        sparseIntArray.put(2131362098, 20);
        sparseIntArray.put(2131362768, 21);
        sparseIntArray.put(2131362339, 22);
        sparseIntArray.put(2131362715, 23);
        sparseIntArray.put(2131362908, 24);
        sparseIntArray.put(2131362730, 25);
        sparseIntArray.put(2131362643, 26);
        sparseIntArray.put(2131362054, 27);
        sparseIntArray.put(2131363623, 28);
        sparseIntArray.put(2131362742, 29);
    }

    public AppNodeCommunityHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AppNodeCommunityHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (FrameLayout) objArr[27], (View) objArr[20], (LinearLayout) objArr[17], (View) objArr[18], (View) objArr[19], (MaxWidthFrameLayout) objArr[22], (ActionButton) objArr[7], (TextView) objArr[6], (LinearLayout) objArr[5], (LinearLayout) objArr[26], (ViewPager) objArr[23], (IndicatorView) objArr[25], (LinearLayout) objArr[29], (CoolEllipsizeTextView) objArr[16], (LinearLayout) objArr[12], (LinearLayout) objArr[21], (LinearAdapterLayout) objArr[10], (RoundedImageView) objArr[1], (View) objArr[24], (TextView) objArr[9], (Space) objArr[28]);
        this.mDirtyFlags = -1;
        this.followActionView.setTag(null);
        this.followNumView.setTag(null);
        this.followerLayout.setTag(null);
        this.introduceView.setTag(null);
        this.introductionLayout.setTag(null);
        this.linearView.setTag(null);
        this.logoView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.mboundView11 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[14];
        this.mboundView14 = textView3;
        textView3.setTag(null);
        ImageView imageView = (ImageView) objArr[15];
        this.mboundView15 = imageView;
        imageView.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.mboundView2 = textView4;
        textView4.setTag(null);
        ImageView imageView2 = (ImageView) objArr[3];
        this.mboundView3 = imageView2;
        imageView2.setTag(null);
        TextView textView5 = (TextView) objArr[4];
        this.mboundView4 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[8];
        this.mboundView8 = textView6;
        textView6.setTag(null);
        this.remarkAuthor.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
            setModel((AppNodeViewModel) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AppNodeCommunityHeaderBinding
    public void setModel(AppNodeViewModel appNodeViewModel) {
        updateRegistration(0, appNodeViewModel);
        this.mModel = appNodeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AppNodeCommunityHeaderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.AppNodeCommunityHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeModel((AppNodeViewModel) obj, i2);
        }
        if (i == 1) {
            return onChangeModelServiceApp((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeModelIsFollow((ObservableBoolean) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeModelShowAllIntroduce((ObservableBoolean) obj, i2);
    }

    private boolean onChangeModel(AppNodeViewModel appNodeViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i != 32) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    private boolean onChangeModelServiceApp(ObservableField<ServiceApp> observableField, int i) {
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

    private boolean onChangeModelShowAllIntroduce(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0271, code lost:
        if (r10 == r0) goto L_0x0277;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a2  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        Drawable drawable;
        String str4;
        boolean z;
        String str5;
        int i;
        String str6;
        String str7;
        String str8;
        ServiceApp serviceApp;
        String str9;
        String str10;
        int i2;
        boolean z2;
        String str11;
        int i3;
        int i4;
        int i5;
        int i6;
        String str12;
        int i7;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        Drawable drawable2;
        ServiceApp serviceApp2;
        String str19;
        String str20;
        boolean z3;
        int i8;
        String str21;
        boolean z4;
        int i9;
        boolean z5;
        ObservableBoolean observableBoolean;
        boolean z6;
        long j2;
        String str22;
        long j3;
        long j4;
        ObservableBoolean observableBoolean2;
        boolean z7;
        ObservableField<ServiceApp> observableField;
        String str23;
        String str24;
        int i10;
        boolean z8;
        int i11;
        Resources resources;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppNodeViewModel appNodeViewModel = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i12 = 0;
        if ((239 & j) != 0) {
            String appSubtitle = ((j & 193) == 0 || appNodeViewModel == null) ? null : appNodeViewModel.getAppSubtitle();
            int i13 = ((j & 163) > 0 ? 1 : ((j & 163) == 0 ? 0 : -1));
            if (i13 != 0) {
                if (appNodeViewModel != null) {
                    ObservableField<ServiceApp> serviceApp3 = appNodeViewModel.getServiceApp();
                    z7 = appNodeViewModel.isDarkTheme();
                    observableField = serviceApp3;
                } else {
                    observableField = null;
                    z7 = false;
                }
                updateRegistration(1, observableField);
                if (i13 != 0) {
                    j |= z7 ? 2048 : 1024;
                }
                serviceApp2 = observableField != null ? observableField.get() : null;
                drawable2 = AppCompatResources.getDrawable(this.logoView.getContext(), z7 ? 2131231409 : 2131231408);
                str18 = serviceApp2 != null ? serviceApp2.getLogo() : null;
                int i14 = ((j & 131) > 0 ? 1 : ((j & 131) == 0 ? 0 : -1));
                if (i14 != 0) {
                    if (serviceApp2 != null) {
                        str23 = serviceApp2.getFollowCount();
                        String apkType = serviceApp2.getApkType();
                        String introduce = serviceApp2.getIntroduce();
                        str16 = serviceApp2.getRemark();
                        str15 = serviceApp2.getApkSubTitle();
                        int isDownloadApp = serviceApp2.getIsDownloadApp();
                        String reviewer = serviceApp2.getReviewer();
                        str14 = serviceApp2.getAppName();
                        str24 = apkType;
                        str17 = introduce;
                        i10 = isDownloadApp;
                        str20 = reviewer;
                    } else {
                        str20 = null;
                        str24 = null;
                        str17 = null;
                        str23 = null;
                        str16 = null;
                        str15 = null;
                        str14 = null;
                        i10 = 0;
                    }
                    str13 = appSubtitle;
                    str19 = this.followNumView.getResources().getString(2131886613, str23);
                    z3 = i10 != 1;
                    boolean isEmpty = TextUtils.isEmpty(str20);
                    if (i14 != 0) {
                        j = z3 ? j | 131072 : j | 65536;
                    }
                    if ((j & 131) != 0) {
                        j |= isEmpty ? 524288 : 262144;
                    }
                    if (str24 != null) {
                        z8 = str24.equals("2");
                    } else {
                        z8 = false;
                    }
                    if ((j & 131) != 0) {
                        j |= z8 ? 2097152 : 1048576;
                    }
                    i = isEmpty ? 8 : 0;
                    if (z8) {
                        resources = this.mboundView13.getResources();
                        i11 = 2131886614;
                    } else {
                        resources = this.mboundView13.getResources();
                        i11 = 2131886611;
                    }
                    str7 = resources.getString(i11);
                    i8 = ((j & 133) > 0 ? 1 : ((j & 133) == 0 ? 0 : -1));
                    if (i8 == 0) {
                        if (appNodeViewModel != null) {
                            z = z3;
                            observableBoolean2 = appNodeViewModel.isFollow();
                        } else {
                            z = z3;
                            observableBoolean2 = null;
                        }
                        updateRegistration(2, observableBoolean2);
                        if (observableBoolean2 != null) {
                            z4 = observableBoolean2.get();
                        } else {
                            z4 = false;
                        }
                        if (i8 != 0) {
                            j |= z4 ? 8388608 : 4194304;
                        }
                        str21 = this.followActionView.getResources().getString(z4 ? 2131887142 : 2131887143);
                    } else {
                        z = z3;
                        str21 = null;
                        z4 = false;
                    }
                    i9 = ((j & 137) > 0 ? 1 : ((j & 137) == 0 ? 0 : -1));
                    if (i9 == 0) {
                        if (appNodeViewModel != null) {
                            observableBoolean = appNodeViewModel.getShowAllIntroduce();
                            z5 = z4;
                        } else {
                            z5 = z4;
                            observableBoolean = null;
                        }
                        updateRegistration(3, observableBoolean);
                        if (observableBoolean != null) {
                            z6 = observableBoolean.get();
                        } else {
                            z6 = false;
                        }
                        if (i9 != 0) {
                            if (z6) {
                                j4 = j | 512 | 32768;
                                j3 = 33554432;
                            } else {
                                j4 = j | 256 | 16384;
                                j3 = 16777216;
                            }
                            j = j4 | j3;
                        }
                        int i15 = z6 ? Integer.MAX_VALUE : 4;
                        if (z6) {
                            j2 = j;
                            str22 = this.mboundView14.getResources().getString(2131886612);
                        } else {
                            j2 = j;
                            str22 = this.mboundView14.getResources().getString(2131886615);
                        }
                        i3 = z6 ? 180 : 0;
                        str5 = str15;
                        drawable = drawable2;
                        serviceApp = serviceApp2;
                        str10 = str19;
                        i2 = i15;
                        str11 = str22;
                        j = j2;
                        str = str17;
                        str6 = str16;
                        str4 = str18;
                        str8 = str21;
                        str9 = str14;
                        str3 = str13;
                    } else {
                        z5 = z4;
                        str = str17;
                        str11 = null;
                        str6 = str16;
                        str5 = str15;
                        i3 = 0;
                        drawable = drawable2;
                        str4 = str18;
                        serviceApp = serviceApp2;
                        str8 = str21;
                        str9 = str14;
                        str3 = str13;
                        str10 = str19;
                        i2 = 0;
                    }
                    str2 = str20;
                    z2 = z5;
                } else {
                    str13 = appSubtitle;
                    str20 = null;
                    str19 = null;
                    str7 = null;
                }
            } else {
                str13 = appSubtitle;
                str20 = null;
                str19 = null;
                serviceApp2 = null;
                drawable2 = null;
                str18 = null;
                str7 = null;
            }
            str17 = str7;
            str16 = str17;
            str15 = str16;
            str14 = str15;
            z3 = false;
            i = 0;
            i8 = ((j & 133) > 0 ? 1 : ((j & 133) == 0 ? 0 : -1));
            if (i8 == 0) {
            }
            i9 = ((j & 137) > 0 ? 1 : ((j & 137) == 0 ? 0 : -1));
            if (i9 == 0) {
            }
            str2 = str20;
            z2 = z5;
        } else {
            str11 = null;
            str10 = null;
            str9 = null;
            serviceApp = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            drawable = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            z2 = false;
            i2 = 0;
            i = 0;
            z = false;
        }
        int i16 = ((j & 163) > 0 ? 1 : ((j & 163) == 0 ? 0 : -1));
        if ((j & 131072) == 0) {
            i4 = i3;
        } else if (serviceApp != null) {
            i7 = serviceApp.getIsForumApp();
            i4 = i3;
            i5 = 1;
        } else {
            i4 = i3;
            i5 = 1;
            i7 = 0;
        }
        i5 = 0;
        int i17 = ((j & 131) > 0 ? 1 : ((j & 131) == 0 ? 0 : -1));
        if (i17 != 0) {
            if (!z) {
                i5 = 0;
            }
            if (i17 != 0) {
                j |= i5 != 0 ? 8192 : 4096;
            }
            if (i5 == 0) {
                i12 = 8;
            }
            i6 = i12;
        } else {
            i6 = 0;
        }
        if ((j & 133) != 0) {
            TextViewBindingAdapter.setText(this.followActionView, str8);
            this.followActionView.setSelected(z2);
        }
        if ((160 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.followActionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.followerLayout, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.introductionLayout, onClickListener, bool);
        }
        if ((j & 131) != 0) {
            TextViewBindingAdapter.setText(this.followNumView, str10);
            Integer num = null;
            String str25 = null;
            Boolean bool2 = null;
            Html.ImageGetter imageGetter = null;
            TextViewBindingAdapters.setTextViewLinkable(this.introduceView, str, num, str25, bool2, imageGetter, str25);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView11, str5, num, str25, bool2, imageGetter, str25);
            TextViewBindingAdapter.setText(this.mboundView13, str7);
            TextViewBindingAdapter.setText(this.mboundView2, str9);
            this.mboundView3.setVisibility(i6);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView8, str6, num, str25, bool2, imageGetter, str25);
            this.remarkAuthor.setVisibility(i);
            TextViewBindingAdapters.setTextViewLinkable(this.remarkAuthor, str2, num, "#FFFFFF", bool2, imageGetter, str25);
        }
        if ((137 & j) != 0) {
            this.introduceView.setMaxLines(i2);
            TextViewBindingAdapter.setText(this.mboundView14, str11);
            if (getBuildSdkInt() >= 11) {
                this.mboundView15.setRotation((float) i4);
            }
        }
        if ((128 & j) != 0) {
            ViewBindingAdapters.clipView(this.linearView, null, 8);
        }
        if ((j & 163) != 0) {
            Boolean bool3 = null;
            str12 = str3;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str4, drawable, 0, 0, bool3, bool3, bool3, bool3, bool3, null, null, null, bool3, bool3, bool3, onClickListener, bool3);
        } else {
            str12 = str3;
        }
        if ((j & 193) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str12);
        }
    }
}
