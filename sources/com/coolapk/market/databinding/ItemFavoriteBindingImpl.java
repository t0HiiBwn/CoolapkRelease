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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.model.Favorite;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemFavoriteBindingImpl extends ItemFavoriteBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView3;
    private final ImageView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFavoriteBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemFavoriteBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (LinearLayout) objArr[0], (TextView) objArr[5], (RoundedImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.descriptionView.setTag(null);
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[4];
        this.mboundView4 = imageView;
        imageView.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (198 != i) {
            return false;
        }
        setModel((Favorite) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFavoriteBinding
    public void setModel(Favorite favorite) {
        this.mModel = favorite;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        int i2;
        int i3;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Favorite favorite = this.mModel;
        int i4 = 0;
        int i5 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (favorite != null) {
                str11 = favorite.getDescription();
                str10 = favorite.getTargetUserAvatar();
                str9 = favorite.getTargetUserName();
                str8 = favorite.getTitle();
                str4 = favorite.getPic();
            } else {
                str11 = null;
                str10 = null;
                str9 = null;
                str8 = null;
                str4 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str11);
            boolean isEmpty2 = TextUtils.isEmpty(str8);
            boolean isEmpty3 = TextUtils.isEmpty(str4);
            int i6 = str4 == null ? 1 : 0;
            if (i5 != 0) {
                j |= isEmpty ? 512 : 256;
            }
            if ((j & 3) != 0) {
                j |= isEmpty2 ? 128 : 64;
            }
            if ((j & 3) != 0) {
                j |= isEmpty3 ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j = i6 != 0 ? j | 32 : j | 16;
            }
            int i7 = isEmpty ? 8 : 0;
            int i8 = isEmpty2 ? 8 : 0;
            if (isEmpty3) {
                i4 = 8;
            }
            str3 = str10;
            i2 = i4;
            str2 = str9;
            str = str8;
            i = i8;
            i4 = i6;
            str5 = str11;
            i3 = i7;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((32 & j) == 0 || favorite == null) {
            str6 = null;
        } else {
            str6 = favorite.getLogo();
        }
        int i9 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i9 != 0) {
            if (i4 != 0) {
                str4 = str6;
            }
            str7 = str4;
        } else {
            str7 = null;
        }
        if (i9 != 0) {
            this.descriptionView.setVisibility(i3);
            String str12 = null;
            Boolean bool = null;
            TextViewBindingAdapters.setTextViewLinkable(this.descriptionView, str5, null, str12, bool, null, str12);
            TextViewBindingAdapters.setDatelineByEntity(this.mboundView3, favorite);
            this.mboundView4.setVisibility(i2);
            Drawable drawable = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView4, str7, drawable, 2131231374, 0, bool, bool, bool, bool, bool, str12, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener, bool);
            TextViewBindingAdapter.setText(this.titleView, str);
            this.titleView.setVisibility(i);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str3, drawable, 2131231162, 0, bool, bool, bool, bool, bool, str12, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener, bool);
            TextViewBindingAdapter.setText(this.userNameView, str2);
        }
    }
}
