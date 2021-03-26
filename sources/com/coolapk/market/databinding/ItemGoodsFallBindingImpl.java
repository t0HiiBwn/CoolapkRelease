package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoodsAction;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.view.ScalingImageView;

public class ItemGoodsFallBindingImpl extends ItemGoodsFallBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;
    private final TextView mboundView12;
    private final TextView mboundView4;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362691, 13);
        sparseIntArray.put(2131363194, 14);
    }

    public ItemGoodsFallBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ItemGoodsFallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (MaxWidthFrameLayout) objArr[13], (ScalingImageView) objArr[2], (LinearLayout) objArr[11], (LinearLayout) objArr[1], (CoolEllipsizeTextView) objArr[7], (BadBadRatingBar) objArr[14], (TextView) objArr[10], (CoolEllipsizeTextView) objArr[3], (UserAvatarView) objArr[9], (LinearLayout) objArr[8]);
        this.mDirtyFlags = -1;
        this.buyTextView.setTag(null);
        this.imageView.setTag(null);
        this.imgUpView.setTag(null);
        this.itemView.setTag(null);
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.mboundView12 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        this.messageView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userInfoView.setTag(null);
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
        } else if (157 == i) {
            setImageUrl((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsFallBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsFallBinding
    public void setImageUrl(String str) {
        this.mImageUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(157);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsFallBinding
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
        int i;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        View.OnClickListener onClickListener;
        int i2;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        UserInfo userInfo;
        String str15;
        int i3;
        FeedGoodsAction feedGoodsAction;
        String str16;
        String str17;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        String str18 = this.mImageUrl;
        View.OnClickListener onClickListener2 = this.mClick;
        int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feed != null) {
                i3 = feed.getLikeNum();
                str15 = feed.getExtraTitle();
                userInfo = feed.getUserInfo();
                str14 = feed.getUserName();
                str13 = feed.getMessage();
                str12 = feed.getUserAvatar();
                feedGoodsAction = feed.getGoodsAction();
            } else {
                feedGoodsAction = null;
                str15 = null;
                userInfo = null;
                str14 = null;
                str13 = null;
                str12 = null;
                i3 = 0;
            }
            String str19 = i3 + "";
            String verifyStatusIcon = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            if (feedGoodsAction != null) {
                str16 = feedGoodsAction.getMallName();
                str17 = feedGoodsAction.getPrice();
            } else {
                str17 = null;
                str16 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str17);
            str8 = "￥" + str17;
            if (i4 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            str7 = str19;
            str6 = str15;
            str5 = str14;
            str2 = str13;
            str = str12;
            i = isEmpty ? 8 : 0;
            str3 = str16;
            str4 = verifyStatusIcon;
        } else {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i5 = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        int i6 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((8 & j) != 0) {
            String str20 = null;
            ViewBindingAdapters.clipView(this.buyTextView, str20, 3);
            ViewBindingAdapters.clipView(this.itemView, str20, 8);
            ViewBindingAdapters.clipView(this.mboundView4, str20, 4);
        }
        if (i5 != 0) {
            str11 = str5;
            Boolean bool = null;
            str10 = str3;
            str9 = str4;
            i2 = i;
            onClickListener = onClickListener2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str18, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231691), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, bool, bool, null, bool);
        } else {
            str11 = str5;
            str9 = str4;
            i2 = i;
            str10 = str3;
            onClickListener = onClickListener2;
        }
        if (i6 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.imgUpView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userInfoView, onClickListener, bool2);
        }
        if ((j & 9) != 0) {
            TextViewBindingAdapter.setText(this.mboundView12, str7);
            TextViewBindingAdapter.setText(this.mboundView4, str10);
            TextViewBindingAdapter.setText(this.mboundView5, str8);
            this.mboundView5.setVisibility(i2);
            String str21 = null;
            Boolean bool3 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.messageView, str2, null, str21, bool3, null, str21);
            TextViewBindingAdapter.setText(this.timeView, str11);
            TextViewBindingAdapter.setText(this.titleView, str6);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231152, 0, bool3, bool3, bool3, bool3, bool3, str21, null, null, bool3, bool3, bool3, null, bool3);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str9, bool3);
        }
    }
}
