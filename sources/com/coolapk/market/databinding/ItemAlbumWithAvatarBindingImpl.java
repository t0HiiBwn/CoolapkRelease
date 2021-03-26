package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Album;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.AlbumFeedActionView;
import com.coolapk.market.widget.UserAvatarView;
import com.dinuscxj.ellipsize.EllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemAlbumWithAvatarBindingImpl extends ItemAlbumWithAvatarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView15;
    private final ImageView mboundView16;
    private final ImageView mboundView17;
    private final ImageView mboundView18;
    private final TextView mboundView5;
    private final ImageView mboundView8;
    private final TextView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(29);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"feed_top", "feed_warning"}, new int[]{21, 22}, new int[]{2131558562, 2131558563});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363605, 23);
        sparseIntArray.put(2131362646, 24);
        sparseIntArray.put(2131362321, 25);
        sparseIntArray.put(2131362121, 26);
        sparseIntArray.put(2131362671, 27);
        sparseIntArray.put(2131362677, 28);
    }

    public ItemAlbumWithAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 29, sIncludes, sViewsWithIds));
    }

    private ItemAlbumWithAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (FeedWarningBinding) objArr[22], (ImageView) objArr[13], (ImageView) objArr[26], (LinearLayout) objArr[1], (LinearLayout) objArr[10], (CoolapkCardView) objArr[25], (CoolapkCardView) objArr[0], (AlbumFeedActionView) objArr[20], (EllipsizeTextView) objArr[7], (LinearLayout) objArr[24], (LinearLayout) objArr[27], (RoundedImageView) objArr[28], (TextView) objArr[12], (TextView) objArr[19], (ImageView) objArr[3], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[11], (View) objArr[23], (FeedTopBinding) objArr[21], (UserAvatarView) objArr[2], (TextView) objArr[14]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.avatarView.setTag(null);
        this.cardLayout.setTag(null);
        this.contentLayout.setTag(null);
        this.coolapkCardView.setTag(null);
        this.feedActionView.setTag(null);
        this.fromWhereView.setTag(null);
        this.infoView.setTag(null);
        ImageView imageView = (ImageView) objArr[15];
        this.mboundView15 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[16];
        this.mboundView16 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[17];
        this.mboundView17 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) objArr[18];
        this.mboundView18 = imageView4;
        imageView4.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        ImageView imageView5 = (ImageView) objArr[8];
        this.mboundView8 = imageView5;
        imageView5.setTag(null);
        TextView textView2 = (TextView) objArr[9];
        this.mboundView9 = textView2;
        textView2.setTag(null);
        this.moreCountView5.setTag(null);
        this.moreView.setTag(null);
        this.nameView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
        setContainedBinding(this.topView);
        this.userAvatarView.setTag(null);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 524288;
        }
        this.topView.invalidateAll();
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
        if (!this.topView.hasPendingBindings() && !this.alertView.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (197 == i) {
            setModel((AlbumDetailViewModel) obj);
        } else if (150 == i) {
            setIcon0((String) obj);
        } else if (153 == i) {
            setIcon3((String) obj);
        } else if (300 == i) {
            setVerifyLabel((String) obj);
        } else if (152 == i) {
            setIcon2((String) obj);
        } else if (301 == i) {
            setVerifyStatusIcon((String) obj);
        } else if (250 == i) {
            setShowFromView(((Boolean) obj).booleanValue());
        } else if (154 == i) {
            setIcon5((String) obj);
        } else if (151 == i) {
            setIcon1((String) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(0, albumDetailViewModel);
        this.mModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setIcon0(String str) {
        this.mIcon0 = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(150);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setIcon3(String str) {
        this.mIcon3 = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(153);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setVerifyLabel(String str) {
        this.mVerifyLabel = str;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(300);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setIcon2(String str) {
        this.mIcon2 = str;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(152);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setVerifyStatusIcon(String str) {
        this.mVerifyStatusIcon = str;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setShowFromView(boolean z) {
        this.mShowFromView = z;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(250);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setIcon5(String str) {
        this.mIcon5 = str;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(154);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setIcon1(String str) {
        this.mIcon1 = str;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(151);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumWithAvatarBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.topView.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeModel((AlbumDetailViewModel) obj, i2);
        }
        if (i == 1) {
            return onChangeTopView((FeedTopBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeAlertView((FeedWarningBinding) obj, i2);
    }

    private boolean onChangeModel(AlbumDetailViewModel albumDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 293) {
            synchronized (this) {
                this.mDirtyFlags |= 8192;
            }
            return true;
        } else if (i == 8) {
            synchronized (this) {
                this.mDirtyFlags |= 16384;
            }
            return true;
        } else if (i == 73) {
            synchronized (this) {
                this.mDirtyFlags |= 32768;
            }
            return true;
        } else if (i == 21) {
            synchronized (this) {
                this.mDirtyFlags |= 65536;
            }
            return true;
        } else if (i == 296) {
            synchronized (this) {
                this.mDirtyFlags |= 131072;
            }
            return true;
        } else if (i != 23) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 262144;
            }
            return true;
        }
    }

    private boolean onChangeTopView(FeedTopBinding feedTopBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeAlertView(FeedWarningBinding feedWarningBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x036f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0471  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00dd  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        String str6;
        Album album;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        OnBitmapTransformListener onBitmapTransformListener;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        String str13;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mModel;
        String str14 = this.mIcon0;
        String str15 = this.mIcon3;
        String str16 = this.mVerifyLabel;
        String str17 = this.mIcon2;
        String str18 = this.mVerifyStatusIcon;
        boolean z = this.mShowFromView;
        String str19 = this.mIcon5;
        String str20 = this.mIcon1;
        OnBitmapTransformListener onBitmapTransformListener2 = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        int i14 = 8;
        if ((j & 1040385) != 0) {
            String albumTitle = ((j & 589825) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumTitle();
            String userInfoText = ((j & 655361) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getUserInfoText();
            int i15 = ((j & 557057) > 0 ? 1 : ((j & 557057) == 0 ? 0 : -1));
            if (i15 != 0) {
                str13 = albumDetailViewModel != null ? albumDetailViewModel.getDeviceTitle() : null;
                boolean isEmpty = TextUtils.isEmpty(str13);
                if (i15 != 0) {
                    j |= isEmpty ? 8589934592L : 4294967296L;
                }
                if (isEmpty) {
                    i13 = 8;
                    String albumUserName = ((j & 786433) != 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumUserName();
                    String userAvatar = ((j & 532481) != 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getUserAvatar();
                    if ((j & 540673) == 0) {
                        album = albumDetailViewModel != null ? albumDetailViewModel.getAlbum() : null;
                        if (album != null) {
                            str6 = albumTitle;
                            str5 = userInfoText;
                            str4 = str13;
                            i = i13;
                            str3 = albumUserName;
                            str2 = userAvatar;
                            str = album.getUserName();
                        } else {
                            str6 = albumTitle;
                            str5 = userInfoText;
                            str4 = str13;
                            i = i13;
                            str3 = albumUserName;
                            str2 = userAvatar;
                            str = null;
                        }
                    } else {
                        str6 = albumTitle;
                        str5 = userInfoText;
                        str4 = str13;
                        i = i13;
                        str3 = albumUserName;
                        str2 = userAvatar;
                        album = null;
                        str = null;
                    }
                }
            } else {
                str13 = null;
            }
            i13 = 0;
            if ((j & 786433) != 0) {
            }
            if ((j & 532481) != 0) {
            }
            if ((j & 540673) == 0) {
            }
        } else {
            album = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((j & 526344) == 0 || (j & 524296) == 0) {
            i2 = 0;
        } else {
            boolean isEmpty2 = TextUtils.isEmpty(str14);
            if (i12 != 0) {
                j |= isEmpty2 ? 134217728 : 67108864;
            }
            i2 = isEmpty2 ? 8 : 0;
        }
        if ((j & 526352) == 0 || (j & 524304) == 0) {
            i3 = 0;
        } else {
            boolean isEmpty3 = TextUtils.isEmpty(str15);
            if (i11 != 0) {
                j |= isEmpty3 ? 8388608 : 4194304;
            }
            i3 = isEmpty3 ? 8 : 0;
        }
        int i16 = ((j & 524320) > 0 ? 1 : ((j & 524320) == 0 ? 0 : -1));
        if (i16 != 0) {
            boolean isEmpty4 = TextUtils.isEmpty(str16);
            if (i16 != 0) {
                j |= isEmpty4 ? 33554432 : 16777216;
            }
            i4 = isEmpty4 ? 8 : 0;
        } else {
            i4 = 0;
        }
        if ((j & 526400) == 0 || (j & 524352) == 0) {
            i5 = 0;
        } else {
            boolean isEmpty5 = TextUtils.isEmpty(str17);
            if (i10 != 0) {
                j |= isEmpty5 ? 2097152 : 1048576;
            }
            i5 = isEmpty5 ? 8 : 0;
        }
        int i17 = ((j & 524544) > 0 ? 1 : ((j & 524544) == 0 ? 0 : -1));
        if (i17 != 0) {
            if (i17 != 0) {
                j |= z ? 2147483648L : 1073741824;
            }
            if (!z) {
                i6 = 8;
                if ((j & 527360) != 0 || (j & 525312) == 0) {
                    i7 = 0;
                } else {
                    boolean isEmpty6 = TextUtils.isEmpty(str20);
                    if (i9 != 0) {
                        j |= isEmpty6 ? 536870912 : 268435456;
                    }
                    if (!isEmpty6) {
                        i14 = 0;
                    }
                    i7 = i14;
                }
                int i18 = ((j & 527448) > 0 ? 1 : ((j & 527448) == 0 ? 0 : -1));
                i8 = ((j & 528384) > 0 ? 1 : ((j & 528384) == 0 ? 0 : -1));
                if ((j & 532481) != 0) {
                    Drawable drawable = null;
                    Boolean bool = null;
                    String str21 = null;
                    OnImageLoadListener onImageLoadListener = null;
                    OnBitmapTransformListener onBitmapTransformListener3 = null;
                    View.OnClickListener onClickListener2 = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str2, drawable, 2131231152, 0, bool, bool, bool, bool, bool, str21, onImageLoadListener, onBitmapTransformListener3, bool, bool, bool, onClickListener2, bool);
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, drawable, 2131231152, 0, bool, bool, bool, bool, bool, str21, onImageLoadListener, onBitmapTransformListener3, bool, bool, bool, onClickListener2, bool);
                }
                if (i8 != 0) {
                    Boolean bool2 = null;
                    ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool2);
                    ViewBindingAdapters.clickListener(this.cardLayout, onClickListener, bool2);
                    ViewBindingAdapters.clickListener(this.contentLayout, onClickListener, bool2);
                    ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool2);
                    ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool2);
                    ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool2);
                }
                if ((524288 & j) != 0) {
                    Number number = null;
                    ViewBindingAdapters.clipView(this.avatarView, "oval", number);
                    ViewBindingAdapters.clipView(this.mboundView15, "oval", number);
                    ViewBindingAdapters.clipView(this.mboundView16, "oval", number);
                    ViewBindingAdapters.clipView(this.mboundView17, "oval", number);
                    ViewBindingAdapters.clipView(this.mboundView18, "oval", number);
                }
                if ((j & 540673) != 0) {
                    ViewBindingAdapters.updateAlbum(this.feedActionView, album);
                    TextViewBindingAdapter.setText(this.nameView, str);
                    TextViewBindingAdapters.setDatelineByEntity(this.timeView, album);
                }
                if ((j & 524544) != 0) {
                    this.fromWhereView.setVisibility(i6);
                }
                if ((j & 655361) != 0) {
                    TextViewBindingAdapter.setText(this.infoView, str5);
                }
                if ((j & 524296) != 0) {
                    this.mboundView15.setVisibility(i2);
                }
                if ((j & 526344) == 0) {
                    onBitmapTransformListener = onBitmapTransformListener2;
                    str12 = str20;
                    str9 = str19;
                    Boolean bool3 = null;
                    str8 = str18;
                    str11 = str17;
                    str7 = str16;
                    str10 = str15;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView15, str14, null, 2131231363, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
                } else {
                    onBitmapTransformListener = onBitmapTransformListener2;
                    str12 = str20;
                    str9 = str19;
                    str10 = str15;
                    str7 = str16;
                    str8 = str18;
                    str11 = str17;
                }
                if ((j & 525312) != 0) {
                    this.mboundView16.setVisibility(i7);
                }
                if ((j & 527360) != 0) {
                    Boolean bool4 = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView16, str12, null, 2131231363, 0, bool4, bool4, bool4, bool4, bool4, null, null, onBitmapTransformListener, bool4, bool4, bool4, null, bool4);
                }
                if ((j & 524352) != 0) {
                    this.mboundView17.setVisibility(i5);
                }
                if ((j & 526400) != 0) {
                    Boolean bool5 = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView17, str11, null, 2131231363, 0, bool5, bool5, bool5, bool5, bool5, null, null, onBitmapTransformListener, bool5, bool5, bool5, null, bool5);
                }
                if ((j & 524304) != 0) {
                    this.mboundView18.setVisibility(i3);
                }
                if ((j & 526352) != 0) {
                    Boolean bool6 = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView18, str10, null, 2131231363, 0, bool6, bool6, bool6, bool6, bool6, null, null, onBitmapTransformListener, bool6, bool6, bool6, null, bool6);
                }
                if ((j & 524320) != 0) {
                    TextViewBindingAdapter.setText(this.mboundView5, str7);
                    this.mboundView5.setVisibility(i4);
                }
                if ((j & 557057) != 0) {
                    this.mboundView8.setVisibility(i);
                    TextViewBindingAdapter.setText(this.mboundView9, str4);
                    this.mboundView9.setVisibility(i);
                }
                if ((524800 & j) != 0) {
                    TextViewBindingAdapter.setText(this.moreCountView5, str9);
                }
                if ((j & 589825) != 0) {
                    TextViewBindingAdapter.setText(this.titleView, str6);
                }
                if ((524416 & j) != 0) {
                    ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str8, null);
                }
                if ((j & 786433) != 0) {
                    TextViewBindingAdapter.setText(this.userNameView, str3);
                }
                executeBindingsOn(this.topView);
                executeBindingsOn(this.alertView);
            }
        }
        i6 = 0;
        if ((j & 527360) != 0) {
        }
        i7 = 0;
        int i18 = ((j & 527448) > 0 ? 1 : ((j & 527448) == 0 ? 0 : -1));
        i8 = ((j & 528384) > 0 ? 1 : ((j & 528384) == 0 ? 0 : -1));
        if ((j & 532481) != 0) {
        }
        if (i8 != 0) {
        }
        if ((524288 & j) != 0) {
        }
        if ((j & 540673) != 0) {
        }
        if ((j & 524544) != 0) {
        }
        if ((j & 655361) != 0) {
        }
        if ((j & 524296) != 0) {
        }
        if ((j & 526344) == 0) {
        }
        if ((j & 525312) != 0) {
        }
        if ((j & 527360) != 0) {
        }
        if ((j & 524352) != 0) {
        }
        if ((j & 526400) != 0) {
        }
        if ((j & 524304) != 0) {
        }
        if ((j & 526352) != 0) {
        }
        if ((j & 524320) != 0) {
        }
        if ((j & 557057) != 0) {
        }
        if ((524800 & j) != 0) {
        }
        if ((j & 589825) != 0) {
        }
        if ((524416 & j) != 0) {
        }
        if ((j & 786433) != 0) {
        }
        executeBindingsOn(this.topView);
        executeBindingsOn(this.alertView);
    }
}
