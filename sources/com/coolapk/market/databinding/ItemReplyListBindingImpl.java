package com.coolapk.market.databinding;

import android.text.Html;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.viewholder.UserReplyViewHolder;
import com.coolapk.market.widget.AutoLinkTextView;
import com.coolapk.market.widget.FeedReplyActionView;
import com.coolapk.market.widget.UserAvatarView;

public class ItemReplyListBindingImpl extends ItemReplyListBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FeedReplyActionView mboundView10;
    private final RelativeLayout mboundView11;
    private final TextView mboundView15;
    private final AutoLinkTextView mboundView16;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final ImageView mboundView8;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(19);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"feed_warning"}, new int[]{17}, new int[]{2131558563});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362490, 18);
    }

    public ItemReplyListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private ItemReplyListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FeedWarningBinding) objArr[17], (LinearLayout) objArr[1], (LinearLayout) objArr[7], (CoolapkCardView) objArr[0], (FrameLayout) objArr[18], (TextView) objArr[6], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[9], (UserAvatarView) objArr[2], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.cardView.setTag(null);
        this.contentView.setTag(null);
        this.coolapkCardView.setTag(null);
        FeedReplyActionView feedReplyActionView = (FeedReplyActionView) objArr[10];
        this.mboundView10 = feedReplyActionView;
        feedReplyActionView.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[11];
        this.mboundView11 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.mboundView15 = textView;
        textView.setTag(null);
        AutoLinkTextView autoLinkTextView = (AutoLinkTextView) objArr[16];
        this.mboundView16 = autoLinkTextView;
        autoLinkTextView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        ImageView imageView = (ImageView) objArr[8];
        this.mboundView8 = imageView;
        imageView.setTag(null);
        this.textView.setTag(null);
        this.textview1.setTag(null);
        this.textview2.setTag(null);
        this.textview3.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048;
        }
        this.alertView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.alertView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (197 == i) {
            setModel((FeedReply) obj);
        } else if (277 == i) {
            setTimeDescription((String) obj);
        } else if (307 == i) {
            setViewHolder((UserReplyViewHolder) obj);
        } else if (160 == i) {
            setInLikeList(((Boolean) obj).booleanValue());
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemReplyListBinding
    public void setModel(FeedReply feedReply) {
        this.mModel = feedReply;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReplyListBinding
    public void setTimeDescription(String str) {
        this.mTimeDescription = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(277);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReplyListBinding
    public void setViewHolder(UserReplyViewHolder userReplyViewHolder) {
        updateRegistration(0, userReplyViewHolder);
        this.mViewHolder = userReplyViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(307);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReplyListBinding
    public void setInLikeList(boolean z) {
        this.mInLikeList = z;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(160);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReplyListBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemReplyListBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewHolder((UserReplyViewHolder) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeAlertView((FeedWarningBinding) obj, i2);
    }

    private boolean onChangeViewHolder(UserReplyViewHolder userReplyViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 260) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 267) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 268) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i != 257) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        }
    }

    private boolean onChangeAlertView(FeedWarningBinding feedWarningBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0129 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015c  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3;
        int i4;
        String str8;
        String str9;
        int i5;
        int i6;
        int i7;
        String str10;
        boolean z;
        int i8;
        int i9;
        int i10;
        String str11;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        boolean z4;
        String str12;
        String str13;
        String str14;
        String str15;
        UserInfo userInfo;
        String str16;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedReply feedReply = this.mModel;
        String str17 = this.mTimeDescription;
        UserReplyViewHolder userReplyViewHolder = this.mViewHolder;
        boolean z5 = this.mInLikeList;
        View.OnClickListener onClickListener = this.mClick;
        int i15 = ((j & 2052) > 0 ? 1 : ((j & 2052) == 0 ? 0 : -1));
        if (i15 != 0) {
            if (feedReply != null) {
                str16 = feedReply.getAdminInfo();
                userInfo = feedReply.getUserInfo();
                str15 = feedReply.getUserName();
                str3 = feedReply.getInfoHtml();
                str14 = feedReply.getUserAvatar();
                str13 = feedReply.getSpamReason();
                str12 = feedReply.getSpamContent();
            } else {
                str16 = null;
                userInfo = null;
                str15 = null;
                str3 = null;
                str14 = null;
                str13 = null;
                str12 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str16);
            boolean isEmpty2 = TextUtils.isEmpty(str13);
            boolean isEmpty3 = TextUtils.isEmpty(str12);
            if (i15 != 0) {
                j |= isEmpty ? 2097152 : 1048576;
            }
            if ((j & 2052) != 0) {
                j |= isEmpty2 ? 131072 : 65536;
            }
            if ((j & 2052) != 0) {
                j |= isEmpty3 ? 32768 : 16384;
            }
            if (userInfo != null) {
                str7 = userInfo.getVerifyStatusIcon();
            } else {
                str7 = null;
            }
            int i16 = isEmpty ? 8 : 0;
            str6 = str15;
            str2 = str14;
            str5 = str13;
            str = str12;
            i2 = isEmpty2 ? 8 : 0;
            i = isEmpty3 ? 8 : 0;
            str4 = str16;
            i3 = i16;
        } else {
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 3969) != 0) {
            int i17 = ((j & 2177) > 0 ? 1 : ((j & 2177) == 0 ? 0 : -1));
            if (i17 != 0) {
                if (userReplyViewHolder != null) {
                    z4 = userReplyViewHolder.isShowTime();
                } else {
                    z4 = false;
                }
                if (i17 != 0) {
                    j |= z4 ? 8388608 : 4194304;
                }
                if (!z4) {
                    i9 = 8;
                    i10 = ((j & 2305) > 0 ? 1 : ((j & 2305) == 0 ? 0 : -1));
                    if (i10 == 0) {
                        str11 = userReplyViewHolder != null ? userReplyViewHolder.getSourcePic() : null;
                        boolean isEmpty4 = TextUtils.isEmpty(str11);
                        if (i10 != 0) {
                            j |= isEmpty4 ? 134217728 : 67108864;
                        }
                        if (isEmpty4) {
                            i11 = 8;
                            String sourceTitle = ((j & 2561) != 0 || userReplyViewHolder == null) ? null : userReplyViewHolder.getSourceTitle();
                            i12 = ((j & 3073) > 0 ? 1 : ((j & 3073) == 0 ? 0 : -1));
                            if (i12 != 0) {
                                if (userReplyViewHolder != null) {
                                    z3 = userReplyViewHolder.isShowSpamInfo();
                                } else {
                                    z3 = false;
                                }
                                if (i12 != 0) {
                                    j |= z3 ? 536870912 : 268435456;
                                }
                                if (!z3) {
                                    i13 = 8;
                                    i14 = ((j & 2049) > 0 ? 1 : ((j & 2049) == 0 ? 0 : -1));
                                    if (i14 == 0) {
                                        if (userReplyViewHolder != null) {
                                            z2 = userReplyViewHolder.isShowContent();
                                        } else {
                                            z2 = false;
                                        }
                                        if (i14 != 0) {
                                            j |= z2 ? 8192 : 4096;
                                        }
                                        i7 = z2 ? 0 : 8;
                                        i6 = i9;
                                        i5 = i11;
                                        str9 = str11;
                                        str8 = sourceTitle;
                                        i4 = i13;
                                    } else {
                                        i6 = i9;
                                        i5 = i11;
                                        str9 = str11;
                                        str8 = sourceTitle;
                                        i4 = i13;
                                        i7 = 0;
                                    }
                                }
                            }
                            i13 = 0;
                            i14 = ((j & 2049) > 0 ? 1 : ((j & 2049) == 0 ? 0 : -1));
                            if (i14 == 0) {
                            }
                        }
                    } else {
                        str11 = null;
                    }
                    i11 = 0;
                    if ((j & 2561) != 0) {
                    }
                    i12 = ((j & 3073) > 0 ? 1 : ((j & 3073) == 0 ? 0 : -1));
                    if (i12 != 0) {
                    }
                    i13 = 0;
                    i14 = ((j & 2049) > 0 ? 1 : ((j & 2049) == 0 ? 0 : -1));
                    if (i14 == 0) {
                    }
                }
            }
            i9 = 0;
            i10 = ((j & 2305) > 0 ? 1 : ((j & 2305) == 0 ? 0 : -1));
            if (i10 == 0) {
            }
            i11 = 0;
            if ((j & 2561) != 0) {
            }
            i12 = ((j & 3073) > 0 ? 1 : ((j & 3073) == 0 ? 0 : -1));
            if (i12 != 0) {
            }
            i13 = 0;
            i14 = ((j & 2049) > 0 ? 1 : ((j & 2049) == 0 ? 0 : -1));
            if (i14 == 0) {
            }
        } else {
            str9 = null;
            str8 = null;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        int i18 = ((j & 2068) > 0 ? 1 : ((j & 2068) == 0 ? 0 : -1));
        if (!(i18 == 0 || i18 == 0)) {
            j = z5 ? j | 524288 : j | 262144;
        }
        if ((j & 262144) != 0) {
            if (feedReply != null) {
                str3 = feedReply.getInfoHtml();
            }
            z = TextUtils.isEmpty(str3);
            str10 = str3;
        } else {
            str10 = str3;
            z = false;
        }
        int i19 = ((j & 2068) > 0 ? 1 : ((j & 2068) == 0 ? 0 : -1));
        if (i19 != 0) {
            if (z5) {
                z = true;
            }
            if (i19 != 0) {
                j |= z ? 33554432 : 16777216;
            }
            i8 = z ? 8 : 0;
        } else {
            i8 = 0;
        }
        if ((j & 2112) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.contentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((j & 2049) != 0) {
            this.contentView.setVisibility(i7);
        }
        if ((2048 & j) != 0) {
            String str18 = null;
            ViewBindingAdapters.clipView(this.contentView, str18, 4);
            ViewBindingAdapters.clipView(this.mboundView8, str18, 2);
        }
        if ((2052 & j) != 0) {
            ViewBindingAdapters.updateFeedReply(this.mboundView10, feedReply);
            TextViewBindingAdapter.setText(this.mboundView15, str);
            this.mboundView16.setVisibility(i3);
            Integer num = null;
            String str19 = null;
            Boolean bool2 = null;
            Html.ImageGetter imageGetter = null;
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView16, str4, num, str19, bool2, imageGetter, str19);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView5, str10, num, str19, bool2, imageGetter, str19);
            TextViewBindingAdapters.replyListReplyTo(this.textView, feedReply);
            this.textview1.setVisibility(i2);
            TextViewBindingAdapter.setText(this.textview2, str5);
            this.textview3.setVisibility(i);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231152, 0, bool2, bool2, bool2, bool2, bool2, str19, null, null, bool2, bool2, bool2, null, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str7, bool2);
            TextViewBindingAdapter.setText(this.userNameView, str6);
        }
        if ((j & 3073) != 0) {
            this.mboundView11.setVisibility(i4);
        }
        if ((2056 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str17);
        }
        if ((j & 2177) != 0) {
            this.mboundView4.setVisibility(i6);
        }
        if ((j & 2068) != 0) {
            this.mboundView5.setVisibility(i8);
        }
        if ((j & 2305) != 0) {
            this.mboundView8.setVisibility(i5);
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView8, str9, null, 2131231691, 0, bool3, bool3, bool3, bool3, bool3, null, null, null, bool3, bool3, bool3, null, bool3);
        }
        if ((j & 2561) != 0) {
            String str20 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.titleView, str8, null, str20, null, null, str20);
        }
        executeBindingsOn(this.alertView);
    }
}
