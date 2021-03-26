package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.NodeTargetInfo;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class NodeRatingFeedLikeViewBindingImpl extends NodeRatingFeedLikeViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView4;
    private final TextView mboundView6;
    private final LinearLayout mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363208, 10);
        sparseIntArray.put(2131363478, 11);
        sparseIntArray.put(2131363296, 12);
        sparseIntArray.put(2131362100, 13);
        sparseIntArray.put(2131362099, 14);
    }

    public NodeRatingFeedLikeViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private NodeRatingFeedLikeViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RatingBar) objArr[14], (TextView) objArr[13], (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (ImageView) objArr[8], (TextView) objArr[3], (RatingBar) objArr[10], (LinearLayout) objArr[12], (TextView) objArr[11], (TextView) objArr[5], (TextView) objArr[9], (UserAvatarView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[7];
        this.mboundView7 = linearLayout;
        linearLayout.setTag(null);
        this.nameView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
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
        if (198 == i) {
            setModel((NodeRating) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.NodeRatingFeedLikeViewBinding
    public void setModel(NodeRating nodeRating) {
        this.mModel = nodeRating;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.NodeRatingFeedLikeViewBinding
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
        String str4;
        String str5;
        String str6;
        NodeTargetInfo nodeTargetInfo;
        UserInfo userInfo;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        NodeRating nodeRating = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (nodeRating != null) {
                userInfo = nodeRating.getUserInfo();
                nodeTargetInfo = nodeRating.getTargetInfo();
            } else {
                userInfo = null;
                nodeTargetInfo = null;
            }
            if (userInfo != null) {
                str9 = userInfo.getUserAvatar();
                str8 = userInfo.getUserName();
                str7 = userInfo.getVerifyStatusIcon();
                str6 = userInfo.getVerifyLabel();
            } else {
                str6 = null;
                str9 = null;
                str8 = null;
                str7 = null;
            }
            if (nodeTargetInfo != null) {
                str10 = nodeTargetInfo.getTitle();
                str11 = nodeTargetInfo.getLogo();
            } else {
                str11 = null;
                str10 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str6);
            if (i2 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if (isEmpty) {
                i = 8;
            }
            str = str9;
            str3 = str7;
            str4 = str10;
            str2 = str11;
            str5 = str8;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 6) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((j & 5) != 0) {
            Drawable drawable = null;
            Boolean bool2 = null;
            String str12 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str2, drawable, 2131231374, 0, bool2, bool2, bool2, bool2, bool2, str12, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
            TextViewBindingAdapter.setText(this.mboundView4, str6);
            this.mboundView4.setVisibility(i);
            TextViewBindingAdapter.setText(this.nameView, str5);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, nodeRating);
            TextViewBindingAdapter.setText(this.titleView, str4);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, drawable, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, str12, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
        }
        if ((j & 4) != 0) {
            String str13 = null;
            ViewBindingAdapters.clipView(this.imageView, str13, 8);
            ViewBindingAdapters.clipView(this.mboundView6, str13, 3);
            ViewBindingAdapters.clipView(this.mboundView7, str13, 8);
        }
    }
}
