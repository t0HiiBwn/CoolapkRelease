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
import com.coolapk.market.widget.UserAvatarView;

public class ItemAlbumFeedBaseBindingImpl extends ItemAlbumFeedBaseBinding {
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
        sparseIntArray.put(2131362292, 7);
    }

    public ItemAlbumFeedBaseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemAlbumFeedBaseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (ImageView) objArr[7], (TextView) objArr[5], (LinearLayout) objArr[4], (TextView) objArr[6], (TextView) objArr[2], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.commentNum.setTag(null);
        this.commentView.setTag(null);
        this.infoView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
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
        if (198 == i) {
            setModel((FeedReply) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAlbumFeedBaseBinding
    public void setModel(FeedReply feedReply) {
        this.mModel = feedReply;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumFeedBaseBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumFeedBaseBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        UserInfo userInfo;
        int i2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedReply feedReply = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 11) != 0) {
            int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (feedReply != null) {
                    str5 = feedReply.getMessage();
                    userInfo = feedReply.getUserInfo();
                    i2 = feedReply.getReplyNum();
                } else {
                    str5 = null;
                    userInfo = null;
                    i2 = 0;
                }
                str4 = "" + i2;
                boolean z = i2 > 0;
                if (i3 != 0) {
                    j |= z ? 32 : 16;
                }
                str3 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
                if (!z) {
                    i = 8;
                    if (feedReply == null) {
                        str = str5;
                        str2 = feedReply.getUserAvatar();
                    } else {
                        str = str5;
                        str2 = null;
                    }
                }
            } else {
                str4 = null;
                str3 = null;
                str5 = null;
            }
            i = 0;
            if (feedReply == null) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((12 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((j & 9) != 0) {
            this.commentNum.setVisibility(i);
            TextViewBindingAdapter.setText(this.commentNum, str4);
            String str6 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str, null, str6, false, null, str6);
            TextViewBindingAdapters.setDatelineByEntity(this.mboundView3, feedReply);
            Boolean bool2 = null;
            TextViewBindingAdapters.setFeedReplyUserText(this.titleView, feedReply, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
        }
        if ((j & 11) != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231374, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        }
    }
}
