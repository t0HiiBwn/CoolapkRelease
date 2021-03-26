package com.coolapk.market.databinding;

import android.text.Html;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.ScalingImageView;

public class ItemArticleFeedPreviewTopBindingImpl extends ItemArticleFeedPreviewTopBinding {
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
        sparseIntArray.put(2131362340, 9);
    }

    public ItemArticleFeedPreviewTopBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemArticleFeedPreviewTopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (LinearLayout) objArr[0], (View) objArr[9], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[2], (ScalingImageView) objArr[1], (UserAvatarView) objArr[4], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.cardView.setTag(null);
        this.fromWhereView.setTag(null);
        this.nameView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
        this.topImageView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userViewContainer.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemArticleFeedPreviewTopBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemArticleFeedPreviewTopBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemArticleFeedPreviewTopBinding
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
        int i;
        String str5;
        String str6;
        String str7;
        String str8;
        int i2;
        String str9;
        UserInfo userInfo;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        int i3 = 0;
        if ((j & 11) != 0) {
            int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (feed != null) {
                    str9 = feed.getMessageTitle();
                    str4 = feed.getUserName();
                    str3 = feed.getInfoHtml();
                    z = feed.showFromView();
                    userInfo = feed.getUserInfo();
                } else {
                    str9 = null;
                    str4 = null;
                    str3 = null;
                    userInfo = null;
                    z = false;
                }
                if (i4 != 0) {
                    j |= z ? 128 : 64;
                }
                boolean isEmpty = TextUtils.isEmpty(str3);
                if (!z) {
                    i3 = 8;
                }
                if (userInfo != null) {
                    str8 = userInfo.getVerifyStatusIcon();
                } else {
                    str8 = null;
                }
                int i5 = !isEmpty ? 1 : 0;
                if ((j & 9) != 0) {
                    j = i5 != 0 ? j | 32 : j | 16;
                }
                i2 = i3;
                i3 = i5;
            } else {
                str9 = null;
                str4 = null;
                str3 = null;
                str8 = null;
                i2 = 0;
            }
            if (feed != null) {
                str = str9;
                i = i2;
                str5 = str8;
                str2 = feed.getUserAvatar();
            } else {
                str = str9;
                i = i2;
                str2 = null;
                str5 = str8;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i6 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((16 & j) == 0 || feed == null) {
            str6 = null;
        } else {
            str6 = feed.getInfo();
        }
        int i7 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (i3 == 0) {
                str3 = str6;
            }
            str7 = str3;
        } else {
            str7 = null;
        }
        if ((8 & j) != 0) {
            ThemeBindingAdapters.setBackgroundTint(this.actionView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.actionView, "colorAccent");
            String str10 = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.topImageView, str10, null, 0, 0, bool, bool, bool, bool, bool, str10, null, null, bool, true, bool, null, bool);
        }
        if (i6 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userViewContainer, onClickListener, bool2);
        }
        if (i7 != 0) {
            this.fromWhereView.setVisibility(i);
            Integer num = null;
            String str11 = null;
            Boolean bool3 = null;
            Html.ImageGetter imageGetter = null;
            TextViewBindingAdapters.setTextViewLinkable(this.fromWhereView, str7, num, str11, bool3, imageGetter, str11);
            TextViewBindingAdapter.setText(this.nameView, str4);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            TextViewBindingAdapters.setTextViewLinkable(this.titleView, str, num, str11, bool3, imageGetter, str11);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str5, bool3);
        }
        if ((j & 11) != 0) {
            Boolean bool4 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231152, 0, bool4, bool4, bool4, bool4, bool4, null, null, onBitmapTransformListener, bool4, bool4, bool4, null, bool4);
        }
    }
}
