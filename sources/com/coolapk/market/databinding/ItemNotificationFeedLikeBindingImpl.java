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
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemNotificationFeedLikeBindingImpl extends ItemNotificationFeedLikeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView3;
    private final ImageView mboundView5;
    private final TextView mboundView6;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362200, 8);
        sparseIntArray.put(2131363533, 9);
    }

    public ItemNotificationFeedLikeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemNotificationFeedLikeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[8], (LinearLayout) objArr[4], (CoolapkCardView) objArr[0], (TextView) objArr[7], (TextView) objArr[9], (UserAvatarView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.contentView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.infoView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.mboundView5 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        this.userAvatarView.setTag(null);
        this.userNameView.setTag(null);
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
            setModel((Feed) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemNotificationFeedLikeBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationFeedLikeBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationFeedLikeBinding
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
        boolean z;
        String str6;
        boolean z2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        UserInfo userInfo;
        String str12;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 11) != 0) {
            int i = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i != 0) {
                if (feed != null) {
                    str12 = feed.getUserName();
                    str11 = feed.getMessage();
                    str3 = feed.getThumbSquarePic();
                    j2 = feed.getLikeTime();
                    str10 = feed.getLikeUserName();
                    userInfo = feed.getLikeUserInfo();
                } else {
                    j2 = 0;
                    str12 = null;
                    str11 = null;
                    str3 = null;
                    str10 = null;
                    userInfo = null;
                }
                str6 = "@" + str12;
                z = TextUtils.isEmpty(str3);
                if (i != 0) {
                    j = z ? j | 32 : j | 16;
                }
                str5 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            } else {
                j2 = 0;
                str6 = null;
                str5 = null;
                str11 = null;
                str3 = null;
                str10 = null;
                z = false;
            }
            if (feed != null) {
                str2 = feed.getLikeAvatar();
                str = str11;
            } else {
                str = str11;
                str2 = null;
            }
            str4 = str10;
        } else {
            j2 = 0;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            z = false;
        }
        int i2 = ((j & 32) > 0 ? 1 : ((j & 32) == 0 ? 0 : -1));
        if (i2 != 0) {
            str7 = feed != null ? feed.getTpic() : null;
            z2 = TextUtils.isEmpty(str7);
            if (i2 != 0) {
                j = z2 ? j | 128 : j | 64;
            }
        } else {
            str7 = null;
            z2 = false;
        }
        if ((j & 128) == 0 || feed == null) {
            str8 = null;
        } else {
            str8 = feed.getUserAvatar();
        }
        if ((32 & j) == 0) {
            str7 = null;
        } else if (z2) {
            str7 = str8;
        }
        int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (z) {
                str3 = str7;
            }
            str9 = str3;
        } else {
            str9 = null;
        }
        if ((12 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.contentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((8 & j) != 0) {
            String str13 = null;
            ViewBindingAdapters.clipView(this.contentView, str13, 8);
            ViewBindingAdapters.clipView(this.mboundView5, str13, 2);
        }
        if (i3 != 0) {
            Boolean bool2 = null;
            String str14 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str, null, "textColorSecondary", bool2, null, str14);
            TextViewBindingAdapters.setTime(this.mboundView3, Long.valueOf(j2));
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView5, str9, null, 2131231363, 0, bool2, bool2, bool2, bool2, bool2, str14, null, null, true, bool2, bool2, null, bool2);
            TextViewBindingAdapter.setText(this.mboundView6, str6);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str5, bool2);
            TextViewBindingAdapter.setText(this.userNameView, str4);
        }
        if ((j & 11) != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231152, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        }
    }
}
