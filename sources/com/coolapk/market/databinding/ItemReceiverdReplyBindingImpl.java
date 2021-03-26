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
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.user.UserReceivedReplyListFragment;
import com.coolapk.market.widget.SquareImageView;
import com.coolapk.market.widget.UserAvatarView;

public class ItemReceiverdReplyBindingImpl extends ItemReceiverdReplyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView3;
    private final ImageView mboundView7;
    private final TextView mboundView8;

    public ItemReceiverdReplyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemReceiverdReplyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[0], (LinearLayout) objArr[6], (SquareImageView) objArr[5], (TextView) objArr[9], (TextView) objArr[4], (UserAvatarView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.contentView.setTag(null);
        this.imageView.setTag(null);
        this.infoView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[7];
        this.mboundView7 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[8];
        this.mboundView8 = textView2;
        textView2.setTag(null);
        this.textView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userNameView.setTag(null);
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
        if (198 == i) {
            setModel((FeedReply) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (308 == i) {
            setViewHolder((UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemReceiverdReplyBinding
    public void setModel(FeedReply feedReply) {
        this.mModel = feedReply;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReceiverdReplyBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReceiverdReplyBinding
    public void setViewHolder(UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder receivedFeedReplyViewHolder) {
        updateRegistration(0, receivedFeedReplyViewHolder);
        this.mViewHolder = receivedFeedReplyViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemReceiverdReplyBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewHolder((UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder) obj, i2);
    }

    private boolean onChangeViewHolder(UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder receivedFeedReplyViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 268) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 269) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i != 266) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00da  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        int i2;
        int i3;
        String str6;
        String str7;
        int i4;
        int i5;
        String str8;
        String sourceTitle;
        boolean z;
        String str9;
        int i6;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedReply feedReply = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder receivedFeedReplyViewHolder = this.mViewHolder;
        View.OnClickListener onClickListener = this.mClick;
        int i7 = 8;
        int i8 = 0;
        if ((j & 134) != 0) {
            int i9 = ((j & 130) > 0 ? 1 : ((j & 130) == 0 ? 0 : -1));
            if (i9 != 0) {
                if (feedReply != null) {
                    str4 = feedReply.getUserName();
                    userInfo = feedReply.getUserInfo();
                    str9 = feedReply.getXsPic();
                } else {
                    str4 = null;
                    userInfo = null;
                    str9 = null;
                }
                if (userInfo != null) {
                    str3 = userInfo.getVerifyStatusIcon();
                } else {
                    str3 = null;
                }
                boolean z2 = str9 == null;
                if (i9 != 0) {
                    j |= z2 ? 2048 : 1024;
                }
                if (z2) {
                    i6 = 8;
                    if (feedReply == null) {
                        i = i6;
                        str = str9;
                        str2 = feedReply.getUserAvatar();
                    } else {
                        i = i6;
                        str2 = null;
                        str = str9;
                    }
                }
            } else {
                str4 = null;
                str3 = null;
                str9 = null;
            }
            i6 = 0;
            if (feedReply == null) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((j & 241) != 0) {
            int i10 = ((j & 129) > 0 ? 1 : ((j & 129) == 0 ? 0 : -1));
            if (i10 != 0) {
                if (receivedFeedReplyViewHolder != null) {
                    z = receivedFeedReplyViewHolder.isShowContent();
                } else {
                    z = false;
                }
                if (i10 != 0) {
                    j |= z ? 8192 : 4096;
                }
                if (!z) {
                    i4 = 8;
                    i5 = ((j & 145) > 0 ? 1 : ((j & 145) == 0 ? 0 : -1));
                    if (i5 == 0) {
                        if (receivedFeedReplyViewHolder != null) {
                            str8 = receivedFeedReplyViewHolder.getSourcePic();
                        } else {
                            str8 = null;
                        }
                        boolean z3 = str8 == null;
                        if (i5 != 0) {
                            j |= z3 ? 512 : 256;
                        }
                        if (!z3) {
                            i7 = 0;
                        }
                        i8 = i7;
                    } else {
                        str8 = null;
                    }
                    sourceTitle = ((j & 161) != 0 || receivedFeedReplyViewHolder == null) ? null : receivedFeedReplyViewHolder.getSourceTitle();
                    if ((j & 193) != 0 || receivedFeedReplyViewHolder == null) {
                        str6 = sourceTitle;
                        i2 = i8;
                        str7 = null;
                    } else {
                        str7 = receivedFeedReplyViewHolder.getSourceMsg();
                        str6 = sourceTitle;
                        i2 = i8;
                    }
                    i3 = i4;
                    str5 = str8;
                }
            }
            i4 = 0;
            i5 = ((j & 145) > 0 ? 1 : ((j & 145) == 0 ? 0 : -1));
            if (i5 == 0) {
            }
            if ((j & 161) != 0) {
            }
            if ((j & 193) != 0) {
            }
            str6 = sourceTitle;
            i2 = i8;
            str7 = null;
            i3 = i4;
            str5 = str8;
        } else {
            str7 = null;
            str6 = null;
            str5 = null;
            i3 = 0;
            i2 = 0;
        }
        if ((j & 136) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.contentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.imageView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((j & 129) != 0) {
            this.contentView.setVisibility(i3);
        }
        if ((130 & j) != 0) {
            this.imageView.setVisibility(i);
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str, null, 2131231374, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            TextViewBindingAdapters.setDatelineByEntity(this.mboundView3, feedReply);
            TextViewBindingAdapters.replyListReplyMe(this.textView, feedReply);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
            TextViewBindingAdapter.setText(this.userNameView, str4);
        }
        if ((j & 193) != 0) {
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str7, null, "textColorSecondary", null, null, null);
        }
        if ((j & 145) != 0) {
            this.mboundView7.setVisibility(i2);
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView7, str5, null, 2131231374, 0, bool3, bool3, bool3, bool3, bool3, null, null, null, bool3, bool3, bool3, null, bool3);
        }
        if ((j & 161) != 0) {
            TextViewBindingAdapter.setText(this.mboundView8, str6);
        }
        if ((j & 134) != 0) {
            Boolean bool4 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231162, 0, bool4, bool4, bool4, bool4, bool4, null, null, onBitmapTransformListener, bool4, bool4, bool4, null, bool4);
        }
    }
}
