package com.coolapk.market.databinding;

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
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemReplyLikeListBindingImpl extends ItemReplyLikeListBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView4;
    private final TextView mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363533, 9);
    }

    public ItemReplyLikeListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemReplyLikeListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (LinearLayout) objArr[5], (CoolapkCardView) objArr[0], (ImageView) objArr[6], (TextView) objArr[8], (TextView) objArr[9], (UserAvatarView) objArr[2], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.contentView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.imgView.setTag(null);
        this.infoView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.mboundView7 = textView2;
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

    @Override // com.coolapk.market.databinding.ItemReplyLikeListBinding
    public void setModel(FeedReply feedReply) {
        this.mModel = feedReply;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReplyLikeListBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReplyLikeListBinding
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
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i3;
        String str10;
        UserInfo userInfo;
        String str11;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedReply feedReply = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = 0;
        if ((j & 11) != 0) {
            int i5 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (feedReply != null) {
                    str11 = feedReply.getUserName();
                    str10 = feedReply.getMessage();
                    j2 = feedReply.getLikeTime();
                    str9 = feedReply.getLikeUserName();
                    str3 = feedReply.getPic();
                    userInfo = feedReply.getLikeUserInfo();
                } else {
                    j2 = 0;
                    str11 = null;
                    str10 = null;
                    str9 = null;
                    str3 = null;
                    userInfo = null;
                }
                int i6 = 1;
                boolean z = feedReply == null;
                if (i5 != 0) {
                    j |= z ? 512 : 256;
                }
                str5 = "@" + str11;
                if (str3 != null) {
                    i6 = 0;
                }
                i2 = z ? 8 : 0;
                if ((j & 9) != 0) {
                    if (i6 != 0) {
                        j4 = j | 32;
                        j3 = 128;
                    } else {
                        j4 = j | 16;
                        j3 = 64;
                    }
                    j = j4 | j3;
                }
                str4 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
                if (i6 != 0) {
                    i4 = 8;
                }
                i3 = i4;
                i4 = i6;
            } else {
                j2 = 0;
                str5 = null;
                str4 = null;
                str10 = null;
                str9 = null;
                str3 = null;
                i2 = 0;
                i3 = 0;
            }
            if (feedReply != null) {
                str = str10;
                i = i3;
                str6 = str9;
                str2 = feedReply.getLikeAvatar();
            } else {
                str = str10;
                i = i3;
                str2 = null;
                str6 = str9;
            }
        } else {
            j2 = 0;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        int i7 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((32 & j) == 0 || feedReply == null) {
            str7 = null;
        } else {
            str7 = feedReply.getLogo();
        }
        int i8 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i8 != 0) {
            if (i4 != 0) {
                str3 = str7;
            }
            str8 = str3;
        } else {
            str8 = null;
        }
        if (i7 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.contentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if (i8 != 0) {
            this.contentView.setVisibility(i2);
            this.imgView.setVisibility(i);
            Boolean bool2 = null;
            String str12 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imgView, str8, null, 2131231363, 0, bool2, bool2, bool2, bool2, bool2, str12, null, null, bool2, bool2, bool2, null, bool2);
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str, null, "textColorSecondary", bool2, null, str12);
            TextViewBindingAdapters.setTime(this.mboundView4, Long.valueOf(j2));
            TextViewBindingAdapter.setText(this.mboundView7, str5);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str4, bool2);
            TextViewBindingAdapter.setText(this.userNameView, str6);
        }
        if ((8 & j) != 0) {
            ViewBindingAdapters.clipView(this.contentView, null, 8);
        }
        if ((j & 11) != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231152, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        }
    }
}
