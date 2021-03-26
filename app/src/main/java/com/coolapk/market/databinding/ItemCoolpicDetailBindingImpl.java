package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.wallpaper.coolpic.CoolPicViewPager;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.ImageIndicatorView;

public class ItemCoolpicDetailBindingImpl extends ItemCoolpicDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363934, 16);
        sparseIntArray.put(2131363609, 17);
        sparseIntArray.put(2131362145, 18);
        sparseIntArray.put(2131363604, 19);
        sparseIntArray.put(2131362131, 20);
        sparseIntArray.put(2131362730, 21);
        sparseIntArray.put(2131363367, 22);
        sparseIntArray.put(2131363366, 23);
        sparseIntArray.put(2131361886, 24);
        sparseIntArray.put(2131362843, 25);
        sparseIntArray.put(2131362847, 26);
        sparseIntArray.put(2131362290, 27);
        sparseIntArray.put(2131362517, 28);
        sparseIntArray.put(2131362518, 29);
        sparseIntArray.put(2131363356, 30);
        sparseIntArray.put(2131362285, 31);
    }

    public ItemCoolpicDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 32, sIncludes, sViewsWithIds));
    }

    private ItemCoolpicDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[24], (TextView) objArr[6], (UserAvatarView) objArr[2], (LinearLayout) objArr[20], (View) objArr[18], (FrameLayout) objArr[31], (TextView) objArr[27], (LinearLayout) objArr[13], (TextView) objArr[11], (TextView) objArr[5], (ImageView) objArr[28], (TextView) objArr[29], (LinearLayout) objArr[14], (ImageIndicatorView) objArr[21], (FrameLayout) objArr[0], (ImageView) objArr[25], (TextView) objArr[26], (LinearLayout) objArr[12], (ImageView) objArr[7], (ImageView) objArr[1], (TextView) objArr[30], (LinearLayout) objArr[15], (TextView) objArr[23], (LinearLayout) objArr[22], (LinearLayout) objArr[10], (LinearLayout) objArr[19], (View) objArr[17], (LinearLayout) objArr[3], (TextView) objArr[4], (CoolPicViewPager) objArr[16], (TextView) objArr[9], (TextView) objArr[8]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.avatarView.setTag(null);
        this.commentView.setTag(null);
        this.contentView.setTag(null);
        this.desView.setTag(null);
        this.favoriteView.setTag(null);
        this.itemView.setTag(null);
        this.likeView.setTag(null);
        this.moreView.setTag(null);
        this.navigationView.setTag(null);
        this.shareView.setTag(null);
        this.textContainer.setTag(null);
        this.userInfoView.setTag(null);
        this.usernameView.setTag(null);
        this.wallpaperSetView.setTag(null);
        this.wallpaperSourceView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemCoolpicDetailBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemCoolpicDetailBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemCoolpicDetailBinding
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
        String str4;
        Long l2;
        UserInfo userInfo;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (feed != null) {
                l2 = feed.getDateline();
                userInfo = feed.getUserInfo();
                str3 = feed.getUserName();
                str2 = feed.getMessage();
                str5 = feed.getUserAvatar();
            } else {
                str5 = null;
                l2 = null;
                userInfo = null;
                str3 = null;
                str2 = null;
            }
            if (userInfo != null) {
                str4 = userInfo.getVerifyStatusIcon();
                str = str5;
            } else {
                str = str5;
                str4 = null;
            }
        } else {
            l2 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 12) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.favoriteView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.navigationView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.shareView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.textContainer, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userInfoView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.wallpaperSetView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.wallpaperSourceView, onClickListener, bool);
        }
        if (i != 0) {
            Boolean bool2 = null;
            String str6 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, null, 0, 0, bool2, bool2, bool2, bool2, bool2, str6, null, null, bool2, bool2, bool2, null, bool2);
            ImageViewBindingAdapters.setVipSignView(this.avatarView, str4, bool2);
            TextViewBindingAdapters.setTextViewLinkable(this.contentView, str2, null, str6, bool2, null, str6);
            TextViewBindingAdapters.setTime(this.desView, l2);
            TextViewBindingAdapter.setText(this.usernameView, str3);
        }
    }
}
