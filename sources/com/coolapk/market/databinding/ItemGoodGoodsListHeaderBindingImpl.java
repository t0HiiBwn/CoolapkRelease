package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.goodsList.FunThingsViewModel;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public class ItemGoodGoodsListHeaderBindingImpl extends ItemGoodGoodsListHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final TextView mboundView4;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(19);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"feed_warning"}, new int[]{10}, new int[]{2131558566});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362102, 11);
        sparseIntArray.put(2131362104, 12);
        sparseIntArray.put(2131362105, 13);
        sparseIntArray.put(2131362101, 14);
        sparseIntArray.put(2131362779, 15);
        sparseIntArray.put(2131362345, 16);
        sparseIntArray.put(2131362920, 17);
        sparseIntArray.put(2131362875, 18);
    }

    public ItemGoodGoodsListHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private ItemGoodGoodsListHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FeedWarningBinding) objArr[10], (UserAvatarView) objArr[5], (View) objArr[14], (LinearLayout) objArr[11], (View) objArr[12], (View) objArr[13], (LinearLayout) objArr[2], (ImageView) objArr[1], (MaxWidthFrameLayout) objArr[16], (TextView) objArr[8], (LinearLayout) objArr[15], (PreventAutoScrollRecyclerView) objArr[18], (View) objArr[17], (View) objArr[3]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.avatarView.setTag(null);
        this.contentView.setTag(null);
        this.coverView.setTag(null);
        this.infoView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.mboundView7 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[9];
        this.mboundView9 = textView4;
        textView4.setTag(null);
        this.spaceHolder.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.alertView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.alertView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((FunThingsViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGoodGoodsListHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodGoodsListHeaderBinding
    public void setViewModel(FunThingsViewModel funThingsViewModel) {
        this.mViewModel = funThingsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeAlertView((FeedWarningBinding) obj, i2);
    }

    private boolean onChangeAlertView(FeedWarningBinding feedWarningBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        String str6;
        String str7;
        String str8;
        int i2;
        boolean z;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        Feed feed;
        String str14;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        FunThingsViewModel funThingsViewModel = this.mViewModel;
        int i3 = 0;
        int i4 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (funThingsViewModel != null) {
                str8 = funThingsViewModel.getInfoText();
                feed = funThingsViewModel.getFeed();
                str13 = funThingsViewModel.getUserName();
                str12 = funThingsViewModel.getFunThingsTitle();
                str11 = funThingsViewModel.getDescription();
                str10 = funThingsViewModel.funThingsUpdateTime();
                str9 = funThingsViewModel.getUserAvatar();
                z = funThingsViewModel.getHasPic();
                str14 = funThingsViewModel.getCoverUrl();
            } else {
                str14 = null;
                str8 = null;
                feed = null;
                str13 = null;
                str12 = null;
                str11 = null;
                str10 = null;
                str9 = null;
                z = false;
            }
            if (i4 != 0) {
                if (z) {
                    j3 = j | 32;
                    j2 = 512;
                } else {
                    j3 = j | 16;
                    j2 = 256;
                }
                j = j3 | j2;
            }
            UserInfo userInfo = feed != null ? feed.getUserInfo() : null;
            boolean isEmpty = TextUtils.isEmpty(str11);
            int i5 = z ? 8 : 0;
            int i6 = z ? 0 : 8;
            if ((j & 12) != 0) {
                j |= isEmpty ? 128 : 64;
            }
            str7 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            if (isEmpty) {
                i3 = 8;
            }
            str6 = str13;
            str4 = str12;
            str3 = str11;
            str2 = str10;
            str = str9;
            i = i5;
            str5 = str14;
            i2 = i3;
            i3 = i6;
        } else {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((12 & j) != 0) {
            Drawable drawable = null;
            Boolean bool = null;
            String str15 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, drawable, 2131231162, 0, bool, bool, bool, bool, bool, str15, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            ImageViewBindingAdapters.setVipSignView(this.avatarView, str7, bool);
            this.coverView.setVisibility(i3);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str5, drawable, 0, 0, bool, bool, bool, bool, bool, str15, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            TextViewBindingAdapter.setText(this.infoView, str8);
            TextViewBindingAdapter.setText(this.mboundView4, str4);
            TextViewBindingAdapter.setText(this.mboundView6, str6);
            TextViewBindingAdapter.setText(this.mboundView7, str2);
            this.mboundView9.setVisibility(i2);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView9, str3, null, str15, bool, null, str15);
            this.spaceHolder.setVisibility(i);
        }
        if ((10 & j) != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.contentView, onClickListener, bool2);
        }
        if ((j & 8) != 0) {
            ViewBindingAdapters.clipView(this.avatarView, "oval", null);
        }
        executeBindingsOn(this.alertView);
    }
}
