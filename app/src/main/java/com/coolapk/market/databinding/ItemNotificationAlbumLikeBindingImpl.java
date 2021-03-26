package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemNotificationAlbumLikeBindingImpl extends ItemNotificationAlbumLikeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362200, 7);
        sparseIntArray.put(2131362375, 8);
        sparseIntArray.put(2131363435, 9);
        sparseIntArray.put(2131363891, 10);
        sparseIntArray.put(2131363219, 11);
    }

    public ItemNotificationAlbumLikeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemNotificationAlbumLikeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[7], (CoolapkCardView) objArr[0], (TextView) objArr[8], (ImageView) objArr[5], (LinearLayout) objArr[4], (TextView) objArr[11], (LinearLayout) objArr[9], (TextView) objArr[6], (UserAvatarView) objArr[1], (TextView) objArr[2], (TextView) objArr[10]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.iconView.setTag(null);
        this.itemAlbumView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.textView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userName.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
            setModel((Album) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemNotificationAlbumLikeBinding
    public void setModel(Album album) {
        this.mModel = album;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationAlbumLikeBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationAlbumLikeBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        long j2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Album album = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((11 & j) > 0 ? 1 : ((11 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if ((j & 9) != 0) {
                if (album != null) {
                    str7 = album.getIcon();
                    j2 = album.getLikeTime();
                    str3 = album.getLikeUserName();
                    str2 = album.getTitle();
                    userInfo = album.getLikeUserInfo();
                } else {
                    j2 = 0;
                    str7 = null;
                    str3 = null;
                    str2 = null;
                    userInfo = null;
                }
                str6 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            } else {
                j2 = 0;
                str7 = null;
                str3 = null;
                str2 = null;
                str6 = null;
            }
            if (album != null) {
                str5 = album.getLikeAvatar();
                str = str7;
                str4 = str6;
            } else {
                str = str7;
                str4 = str6;
                str5 = null;
            }
        } else {
            j2 = 0;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i2 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((9 & j) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231363), 0, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapters.setTime(this.mboundView3, Long.valueOf(j2));
            TextViewBindingAdapter.setText(this.textView, str2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str4, bool);
            TextViewBindingAdapter.setText(this.userName, str3);
        }
        if ((j & 8) != 0) {
            String str8 = null;
            ViewBindingAdapters.clipView(this.iconView, str8, 2);
            ViewBindingAdapters.clipView(this.itemAlbumView, str8, 8);
        }
        if (i2 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.itemAlbumView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool2);
        }
        if (i != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str5, null, 2131231152, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        }
    }
}
