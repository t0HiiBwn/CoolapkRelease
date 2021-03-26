package com.coolapk.market.databinding;

import android.text.TextUtils;
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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemTripleCoolPicBindingImpl extends ItemTripleCoolPicBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView11;
    private final TextView mboundView13;
    private final TextView mboundView18;
    private final TextView mboundView20;
    private final TextView mboundView4;
    private final TextView mboundView6;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362785, 22);
        sparseIntArray.put(2131362994, 23);
        sparseIntArray.put(2131362995, 24);
        sparseIntArray.put(2131362996, 25);
    }

    public ItemTripleCoolPicBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private ItemTripleCoolPicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (AspectRatioImageView) objArr[2], (AspectRatioImageView) objArr[9], (AspectRatioImageView) objArr[16], (LinearLayout) objArr[3], (LinearLayout) objArr[10], (LinearLayout) objArr[17], (LinearLayout) objArr[1], (LinearLayout) objArr[8], (LinearLayout) objArr[15], (LinearLayout) objArr[22], (ImageView) objArr[23], (ImageView) objArr[24], (ImageView) objArr[25], (CoolEllipsizeTextView) objArr[7], (CoolEllipsizeTextView) objArr[14], (CoolEllipsizeTextView) objArr[21], (UserAvatarView) objArr[5], (UserAvatarView) objArr[12], (UserAvatarView) objArr[19]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.imageView1.setTag(null);
        this.imageView2.setTag(null);
        this.imageView3.setTag(null);
        this.imgUpView1.setTag(null);
        this.imgUpView2.setTag(null);
        this.imgUpView3.setTag(null);
        this.itemView1.setTag(null);
        this.itemView2.setTag(null);
        this.itemView3.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.mboundView11 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[18];
        this.mboundView18 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[20];
        this.mboundView20 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[4];
        this.mboundView4 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.mboundView6 = textView6;
        textView6.setTag(null);
        this.textView1.setTag(null);
        this.textView2.setTag(null);
        this.textView3.setTag(null);
        this.userAvatarView1.setTag(null);
        this.userAvatarView2.setTag(null);
        this.userAvatarView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (105 == i) {
            setFeed1((Feed) obj);
        } else if (106 == i) {
            setFeed2((Feed) obj);
        } else if (193 == i) {
            setLongClick((View.OnLongClickListener) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (107 == i) {
            setFeed3((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTripleCoolPicBinding
    public void setFeed1(Feed feed) {
        this.mFeed1 = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleCoolPicBinding
    public void setFeed2(Feed feed) {
        this.mFeed2 = feed;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(106);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleCoolPicBinding
    public void setLongClick(View.OnLongClickListener onLongClickListener) {
        this.mLongClick = onLongClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(193);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleCoolPicBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleCoolPicBinding
    public void setFeed3(Feed feed) {
        this.mFeed3 = feed;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(107);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleCoolPicBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        OnBitmapTransformListener onBitmapTransformListener;
        int i3;
        String str9;
        String str10;
        String str11;
        int i4;
        String str12;
        int i5;
        String str13;
        View.OnClickListener onClickListener;
        View.OnLongClickListener onLongClickListener;
        String str14;
        int i6;
        String str15;
        String str16;
        String str17;
        String str18;
        OnBitmapTransformListener onBitmapTransformListener2;
        String str19;
        String str20;
        String str21;
        UserInfo userInfo;
        String str22;
        int i7;
        int i8;
        String str23;
        String str24;
        String str25;
        String str26;
        UserInfo userInfo2;
        int i9;
        String str27;
        String str28;
        String str29;
        UserInfo userInfo3;
        int i10;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mFeed1;
        Feed feed2 = this.mFeed2;
        View.OnLongClickListener onLongClickListener2 = this.mLongClick;
        OnBitmapTransformListener onBitmapTransformListener3 = this.mTransformer;
        Feed feed3 = this.mFeed3;
        View.OnClickListener onClickListener2 = this.mClick;
        int i11 = 8;
        int i12 = 0;
        if ((j & 73) != 0) {
            int i13 = ((j & 65) > 0 ? 1 : ((j & 65) == 0 ? 0 : -1));
            if (i13 != 0) {
                if (feed != null) {
                    str29 = feed.getMessage();
                    str28 = feed.getThumbnailPic();
                    str27 = feed.getUserName();
                    i10 = feed.getLikeNum();
                    userInfo3 = feed.getUserInfo();
                } else {
                    userInfo3 = null;
                    str29 = null;
                    str28 = null;
                    str27 = null;
                    i10 = 0;
                }
                boolean z = feed == null;
                if (i13 != 0) {
                    j |= z ? 262144 : 131072;
                }
                boolean isEmpty = TextUtils.isEmpty(str29);
                str4 = i10 + "";
                i2 = z ? 8 : 0;
                if ((j & 65) != 0) {
                    j |= isEmpty ? 256 : 128;
                }
                str3 = userInfo3 != null ? userInfo3.getVerifyStatusIcon() : null;
                if (isEmpty) {
                    i = 8;
                    if (feed == null) {
                        str5 = feed.getUserAvatar();
                        str = str28;
                        str2 = str27;
                    } else {
                        str = str28;
                        str2 = str27;
                        str5 = null;
                    }
                }
            } else {
                str4 = null;
                str3 = null;
                str28 = null;
                str27 = null;
                i2 = 0;
            }
            i = 0;
            if (feed == null) {
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((j & 74) != 0) {
            int i14 = ((j & 66) > 0 ? 1 : ((j & 66) == 0 ? 0 : -1));
            if (i14 != 0) {
                if (feed2 != null) {
                    str24 = feed2.getThumbnailPic();
                    int likeNum = feed2.getLikeNum();
                    str26 = feed2.getMessage();
                    i9 = likeNum;
                    userInfo2 = feed2.getUserInfo();
                    str23 = feed2.getUserName();
                } else {
                    userInfo2 = null;
                    str24 = null;
                    str23 = null;
                    str26 = null;
                    i9 = 0;
                }
                boolean z2 = feed2 == null;
                if (i14 != 0) {
                    j |= z2 ? 1024 : 512;
                }
                str9 = i9 + "";
                boolean isEmpty2 = TextUtils.isEmpty(str26);
                i8 = z2 ? 8 : 0;
                if ((j & 66) != 0) {
                    j |= isEmpty2 ? 16384 : 8192;
                }
                str25 = userInfo2 != null ? userInfo2.getVerifyStatusIcon() : null;
                i3 = isEmpty2 ? 8 : 0;
            } else {
                str9 = null;
                str25 = null;
                str24 = null;
                str23 = null;
                i3 = 0;
                i8 = 0;
            }
            if (feed2 != null) {
                str6 = str5;
                str7 = feed2.getUserAvatar();
                str8 = str24;
                str11 = str23;
                i4 = i8;
            } else {
                str6 = str5;
                str8 = str24;
                str11 = str23;
                i4 = i8;
                str7 = null;
            }
            onBitmapTransformListener = onBitmapTransformListener3;
            str10 = str25;
        } else {
            str6 = str5;
            onBitmapTransformListener = onBitmapTransformListener3;
            str11 = null;
            str10 = null;
            str9 = null;
            str8 = null;
            str7 = null;
            i4 = 0;
            i3 = 0;
        }
        int i15 = ((j & 91) > 0 ? 1 : ((j & 91) == 0 ? 0 : -1));
        if ((j & 88) != 0) {
            int i16 = ((j & 80) > 0 ? 1 : ((j & 80) == 0 ? 0 : -1));
            if (i16 != 0) {
                boolean z3 = feed3 == null;
                if (i16 != 0) {
                    j |= z3 ? 4096 : 2048;
                }
                if (feed3 != null) {
                    str20 = feed3.getUserName();
                    str19 = feed3.getThumbnailPic();
                    str22 = feed3.getMessage();
                    userInfo = feed3.getUserInfo();
                    onLongClickListener = onLongClickListener2;
                    i7 = feed3.getLikeNum();
                } else {
                    onLongClickListener = onLongClickListener2;
                    str20 = null;
                    str19 = null;
                    str22 = null;
                    userInfo = null;
                    i7 = 0;
                }
                int i17 = z3 ? 8 : 0;
                boolean isEmpty3 = TextUtils.isEmpty(str22);
                onClickListener = onClickListener2;
                str16 = i7 + "";
                if ((j & 80) != 0) {
                    j |= isEmpty3 ? 65536 : 32768;
                }
                str21 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
                if (!isEmpty3) {
                    i11 = 0;
                }
                i12 = i17;
            } else {
                onLongClickListener = onLongClickListener2;
                onClickListener = onClickListener2;
                str16 = null;
                str21 = null;
                str20 = null;
                str19 = null;
                i11 = 0;
            }
            if (feed3 != null) {
                str13 = feed3.getUserAvatar();
                str15 = str20;
                i5 = i11;
                str12 = str19;
            } else {
                str15 = str20;
                i5 = i11;
                str12 = str19;
                str13 = null;
            }
            str14 = str21;
            i6 = i12;
        } else {
            onLongClickListener = onLongClickListener2;
            onClickListener = onClickListener2;
            str16 = null;
            str15 = null;
            str14 = null;
            str13 = null;
            str12 = null;
            i6 = 0;
            i5 = 0;
        }
        int i18 = ((j & 96) > 0 ? 1 : ((j & 96) == 0 ? 0 : -1));
        if ((j & 65) != 0) {
            str18 = str15;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView1, str, null, 2131231691, 0, bool, bool, bool, bool, bool, null, null, null, bool, true, bool, null, bool);
            str17 = str16;
            this.itemView1.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView4, str4);
            TextViewBindingAdapter.setText(this.mboundView6, str2);
            this.textView1.setVisibility(i);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView1, str3, bool);
        } else {
            str17 = str16;
            str18 = str15;
        }
        if ((j & 66) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView2, str8, null, 2131231691, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, true, bool2, null, bool2);
            this.itemView2.setVisibility(i4);
            TextViewBindingAdapter.setText(this.mboundView11, str9);
            TextViewBindingAdapter.setText(this.mboundView13, str11);
            this.textView2.setVisibility(i3);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView2, str10, bool2);
        }
        if ((j & 80) != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView3, str12, null, 2131231691, 0, bool3, bool3, bool3, bool3, bool3, null, null, null, bool3, true, bool3, null, bool3);
            this.itemView3.setVisibility(i6);
            TextViewBindingAdapter.setText(this.mboundView18, str17);
            TextViewBindingAdapter.setText(this.mboundView20, str18);
            this.textView3.setVisibility(i5);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView3, str14, bool3);
        }
        if (i18 != 0) {
            Boolean bool4 = null;
            ViewBindingAdapters.clickListener(this.imgUpView1, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.imgUpView2, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.imgUpView3, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.itemView1, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.itemView2, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.itemView3, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.userAvatarView1, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.userAvatarView2, onClickListener, bool4);
            ViewBindingAdapters.clickListener(this.userAvatarView3, onClickListener, bool4);
        }
        if ((68 & j) != 0) {
            ViewBindingAdapters.setOnLongClickListener(this.itemView1, onLongClickListener);
            ViewBindingAdapters.setOnLongClickListener(this.itemView2, onLongClickListener);
            ViewBindingAdapters.setOnLongClickListener(this.itemView3, onLongClickListener);
        }
        if ((64 & j) != 0) {
            String str30 = null;
            ViewBindingAdapters.clipView(this.itemView1, str30, 2);
            ViewBindingAdapters.clipView(this.itemView2, str30, 2);
            ViewBindingAdapters.clipView(this.itemView3, str30, 2);
        }
        if ((73 & j) != 0) {
            Boolean bool5 = null;
            onBitmapTransformListener2 = onBitmapTransformListener;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView1, str6, null, 0, 0, bool5, bool5, bool5, bool5, bool5, null, null, onBitmapTransformListener, bool5, bool5, bool5, null, bool5);
        } else {
            onBitmapTransformListener2 = onBitmapTransformListener;
        }
        if ((j & 74) != 0) {
            Boolean bool6 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView2, str7, null, 0, 0, bool6, bool6, bool6, bool6, bool6, null, null, onBitmapTransformListener2, bool6, bool6, bool6, null, bool6);
        }
        if ((j & 88) != 0) {
            Boolean bool7 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView3, str13, null, 0, 0, bool7, bool7, bool7, bool7, bool7, null, null, onBitmapTransformListener2, bool7, bool7, bool7, null, bool7);
        }
    }
}
