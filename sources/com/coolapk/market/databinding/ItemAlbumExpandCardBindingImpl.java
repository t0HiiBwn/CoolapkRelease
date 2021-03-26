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
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemAlbumExpandCardBindingImpl extends ItemAlbumExpandCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView5;
    private final ImageView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362121, 10);
        sparseIntArray.put(2131362312, 11);
        sparseIntArray.put(2131362671, 12);
        sparseIntArray.put(2131362677, 13);
    }

    public ItemAlbumExpandCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemAlbumExpandCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[3], (ImageView) objArr[10], (LinearLayout) objArr[11], (CoolapkCardView) objArr[0], (LinearLayout) objArr[12], (RoundedImageView) objArr[13], (TextView) objArr[2], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.avatarView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.infoView.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.mboundView5 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[6];
        this.mboundView6 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[7];
        this.mboundView7 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) objArr[8];
        this.mboundView8 = imageView4;
        imageView4.setTag(null);
        this.moreCountView5.setTag(null);
        this.titleView.setTag(null);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096;
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
            setModel((AlbumDetailViewModel) obj);
        } else if (150 == i) {
            setIcon0((String) obj);
        } else if (153 == i) {
            setIcon3((String) obj);
        } else if (152 == i) {
            setIcon2((String) obj);
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

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(0, albumDetailViewModel);
        this.mModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setIcon0(String str) {
        this.mIcon0 = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(150);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setIcon3(String str) {
        this.mIcon3 = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(153);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setIcon2(String str) {
        this.mIcon2 = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(152);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setIcon5(String str) {
        this.mIcon5 = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(154);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setIcon1(String str) {
        this.mIcon1 = str;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(151);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumExpandCardBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((AlbumDetailViewModel) obj, i2);
    }

    private boolean onChangeModel(AlbumDetailViewModel albumDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 21) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 296) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 293) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i != 23) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        int i3;
        int i4;
        String str5;
        String str6;
        String str7;
        OnBitmapTransformListener onBitmapTransformListener;
        String str8;
        String str9;
        int i5;
        int i6;
        int i7;
        int i8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mModel;
        String str10 = this.mIcon0;
        String str11 = this.mIcon3;
        String str12 = this.mIcon2;
        String str13 = this.mIcon5;
        String str14 = this.mIcon1;
        OnBitmapTransformListener onBitmapTransformListener2 = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        if ((7937 & j) != 0) {
            String albumTitle = ((j & 4353) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumTitle();
            str3 = ((j & 4609) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getUserInfoText();
            str2 = ((j & 6145) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumUserName();
            if ((j & 5121) == 0 || albumDetailViewModel == null) {
                str4 = albumTitle;
                str = null;
            } else {
                str = albumDetailViewModel.getUserAvatar();
                str4 = albumTitle;
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 4162) == 0 || (j & 4098) == 0) {
            i = 0;
        } else {
            boolean isEmpty = TextUtils.isEmpty(str10);
            if (i8 != 0) {
                j |= isEmpty ? 262144 : 131072;
            }
            i = isEmpty ? 8 : 0;
        }
        if ((j & 4164) == 0 || (j & 4100) == 0) {
            i2 = 0;
        } else {
            boolean isEmpty2 = TextUtils.isEmpty(str11);
            if (i7 != 0) {
                j |= isEmpty2 ? 65536 : 32768;
            }
            i2 = isEmpty2 ? 8 : 0;
        }
        if ((j & 4168) == 0 || (j & 4104) == 0) {
            i3 = 0;
        } else {
            boolean isEmpty3 = TextUtils.isEmpty(str12);
            if (i6 != 0) {
                j |= isEmpty3 ? 16384 : 8192;
            }
            i3 = isEmpty3 ? 8 : 0;
        }
        if ((j & 4192) == 0 || (j & 4128) == 0) {
            i4 = 0;
        } else {
            boolean isEmpty4 = TextUtils.isEmpty(str14);
            if (i5 != 0) {
                j |= isEmpty4 ? 1048576 : 524288;
            }
            i4 = isEmpty4 ? 8 : 0;
        }
        int i9 = ((j & 4206) > 0 ? 1 : ((j & 4206) == 0 ? 0 : -1));
        int i10 = ((j & 4224) > 0 ? 1 : ((j & 4224) == 0 ? 0 : -1));
        if ((j & 5121) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        }
        if (i10 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.coolapkCardView, onClickListener, bool2);
        }
        if ((4096 & j) != 0) {
            Number number = null;
            ViewBindingAdapters.clipView(this.avatarView, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView5, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView6, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView7, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView8, "oval", number);
        }
        if ((j & 4609) != 0) {
            TextViewBindingAdapter.setText(this.infoView, str3);
        }
        if ((j & 4098) != 0) {
            this.mboundView5.setVisibility(i);
        }
        if ((j & 4162) != 0) {
            str9 = str2;
            onBitmapTransformListener = onBitmapTransformListener2;
            Boolean bool3 = null;
            str8 = str14;
            str5 = str13;
            str7 = str12;
            str6 = str11;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView5, str10, null, 2131231363, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        } else {
            str9 = str2;
            onBitmapTransformListener = onBitmapTransformListener2;
            str6 = str11;
            str7 = str12;
            str8 = str14;
            str5 = str13;
        }
        if ((j & 4128) != 0) {
            this.mboundView6.setVisibility(i4);
        }
        if ((j & 4192) != 0) {
            Boolean bool4 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView6, str8, null, 2131231363, 0, bool4, bool4, bool4, bool4, bool4, null, null, onBitmapTransformListener, bool4, bool4, bool4, null, bool4);
        }
        if ((j & 4104) != 0) {
            this.mboundView7.setVisibility(i3);
        }
        if ((j & 4168) != 0) {
            Boolean bool5 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView7, str7, null, 2131231363, 0, bool5, bool5, bool5, bool5, bool5, null, null, onBitmapTransformListener, bool5, bool5, bool5, null, bool5);
        }
        if ((j & 4100) != 0) {
            this.mboundView8.setVisibility(i2);
        }
        if ((j & 4164) != 0) {
            Boolean bool6 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView8, str6, null, 2131231363, 0, bool6, bool6, bool6, bool6, bool6, null, null, onBitmapTransformListener, bool6, bool6, bool6, null, bool6);
        }
        if ((4112 & j) != 0) {
            TextViewBindingAdapter.setText(this.moreCountView5, str5);
        }
        if ((j & 4353) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str4);
        }
        if ((j & 6145) != 0) {
            TextViewBindingAdapter.setText(this.userNameView, str9);
        }
    }
}
