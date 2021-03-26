package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemFeedRatingHeaderBindingImpl extends ItemFeedRatingHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final View mboundView2;
    private final ImageView mboundView6;
    private final TextView mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363194, 9);
        sparseIntArray.put(2131363281, 10);
    }

    public ItemFeedRatingHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemFeedRatingHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (TextView) objArr[4], (RatingBar) objArr[9], (TextView) objArr[10], (LinearLayout) objArr[1], (TextView) objArr[5], (UserAvatarView) objArr[3]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[2];
        this.mboundView2 = view2;
        view2.setTag(null);
        ImageView imageView = (ImageView) objArr[6];
        this.mboundView6 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.mboundView7 = textView;
        textView.setTag(null);
        this.moreView.setTag(null);
        this.nameView.setTag(null);
        this.setTopView.setTag(null);
        this.timeView.setTag(null);
        this.userAvatarView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedRatingHeaderBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedRatingHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
        UserInfo userInfo;
        String str6;
        boolean z;
        String str7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = 0;
        int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (feed != null) {
                str4 = feed.getUserName();
                z = feed.isTop();
                str6 = feed.getUserAvatar();
                userInfo = feed.getUserInfo();
                str5 = feed.getDeviceTitle();
            } else {
                str4 = null;
                str6 = null;
                userInfo = null;
                str5 = null;
                z = false;
            }
            if (i3 != 0) {
                j |= z ? 64 : 32;
            }
            int i4 = z ? 0 : 8;
            boolean isEmpty = TextUtils.isEmpty(str5);
            if ((j & 5) != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if (userInfo != null) {
                str7 = userInfo.getVerifyStatusIcon();
            } else {
                str7 = null;
            }
            if (isEmpty) {
                i2 = 8;
            }
            str3 = str5;
            i2 = i4;
            i = i2;
            str = str6;
            str2 = str7;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i5 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((j & 5) != 0) {
            this.mboundView2.setVisibility(i2);
            this.mboundView6.setVisibility(i);
            TextViewBindingAdapter.setText(this.mboundView7, str3);
            this.mboundView7.setVisibility(i);
            TextViewBindingAdapter.setText(this.nameView, str4);
            this.setTopView.setVisibility(i2);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str2, bool);
        }
        if (i5 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool2);
        }
    }
}
