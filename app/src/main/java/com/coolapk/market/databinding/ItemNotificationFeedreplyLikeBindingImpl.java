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
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemNotificationFeedreplyLikeBindingImpl extends ItemNotificationFeedreplyLikeBinding {
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
        sparseIntArray.put(2131363533, 8);
    }

    public ItemNotificationFeedreplyLikeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemNotificationFeedreplyLikeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (LinearLayout) objArr[4], (TextView) objArr[7], (TextView) objArr[8], (UserAvatarView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.contentView.setTag(null);
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
            setModel((FeedReply) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemNotificationFeedreplyLikeBinding
    public void setModel(FeedReply feedReply) {
        this.mModel = feedReply;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationFeedreplyLikeBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationFeedreplyLikeBinding
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
        String str3;
        long j2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        UserInfo userInfo;
        String str10;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedReply feedReply = this.mModel;
        boolean z = false;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 11) != 0) {
            int i = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i != 0) {
                if (feedReply != null) {
                    str10 = feedReply.getUserName();
                    str9 = feedReply.getMessage();
                    j2 = feedReply.getLikeTime();
                    str4 = feedReply.getLikeUserName();
                    str3 = feedReply.getPic();
                    userInfo = feedReply.getLikeUserInfo();
                } else {
                    j2 = 0;
                    str10 = null;
                    str9 = null;
                    str4 = null;
                    str3 = null;
                    userInfo = null;
                }
                String str11 = "@" + str10;
                boolean isEmpty = TextUtils.isEmpty(str3);
                if (i != 0) {
                    j = isEmpty ? j | 32 : j | 16;
                }
                if (userInfo != null) {
                    str6 = str11;
                    z = isEmpty;
                    str5 = userInfo.getVerifyStatusIcon();
                } else {
                    str6 = str11;
                    z = isEmpty;
                    str5 = null;
                }
            } else {
                j2 = 0;
                str6 = null;
                str5 = null;
                str9 = null;
                str4 = null;
                str3 = null;
            }
            if (feedReply != null) {
                str2 = feedReply.getLikeAvatar();
                str = str9;
            } else {
                str = str9;
                str2 = null;
            }
        } else {
            j2 = 0;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i2 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((j & 32) == 0 || feedReply == null) {
            str7 = null;
        } else {
            str7 = feedReply.getUserAvatar();
        }
        int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (z) {
                str3 = str7;
            }
            str8 = str3;
        } else {
            str8 = null;
        }
        if (i2 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.contentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if (i3 != 0) {
            Boolean bool2 = null;
            String str12 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str, null, "textColorSecondary", bool2, null, str12);
            TextViewBindingAdapters.setTime(this.mboundView3, Long.valueOf(j2));
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView5, str8, null, 2131231363, 0, bool2, bool2, bool2, bool2, bool2, str12, null, null, true, bool2, bool2, null, bool2);
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
