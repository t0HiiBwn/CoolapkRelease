package com.coolapk.market.databinding;

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

public class ItemArticleAnswerPreviewTopBindingImpl extends ItemArticleAnswerPreviewTopBinding {
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
        sparseIntArray.put(2131363582, 9);
        sparseIntArray.put(2131362330, 10);
        sparseIntArray.put(2131362417, 11);
    }

    public ItemArticleAnswerPreviewTopBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemArticleAnswerPreviewTopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (LinearLayout) objArr[0], (TextView) objArr[10], (View) objArr[11], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[6], (LinearLayout) objArr[1], (TextView) objArr[9], (UserAvatarView) objArr[4], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.cardView.setTag(null);
        this.fromWhereView.setTag(null);
        this.nameView.setTag(null);
        this.otherView.setTag(null);
        this.timeView.setTag(null);
        this.titleContainer.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemArticleAnswerPreviewTopBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemArticleAnswerPreviewTopBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemArticleAnswerPreviewTopBinding
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
        UserInfo userInfo;
        boolean z;
        String str8;
        String str9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = 0;
        if ((j & 11) != 0) {
            int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (feed != null) {
                    str9 = feed.getUserName();
                    str8 = feed.getInfoHtml();
                    z = feed.showFromView();
                    userInfo = feed.getUserInfo();
                } else {
                    str9 = null;
                    str8 = null;
                    userInfo = null;
                    z = false;
                }
                if (i3 != 0) {
                    j |= z ? 128 : 64;
                }
                boolean isEmpty = TextUtils.isEmpty(str8);
                if (!z) {
                    i2 = 8;
                }
                if (userInfo != null) {
                    str7 = userInfo.getVerifyStatusIcon();
                } else {
                    str7 = null;
                }
                int i4 = !isEmpty ? 1 : 0;
                if ((j & 9) != 0) {
                    j = i4 != 0 ? j | 32 : j | 16;
                }
                i = i2;
                i2 = i4;
                str2 = str8;
                str3 = str9;
            } else {
                str3 = null;
                str2 = null;
                str7 = null;
                i = 0;
            }
            if (feed != null) {
                str4 = str7;
                str = feed.getUserAvatar();
            } else {
                str4 = str7;
                str = null;
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i5 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((16 & j) == 0 || feed == null) {
            str5 = null;
        } else {
            str5 = feed.getInfo();
        }
        int i6 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (i2 == 0) {
                str2 = str5;
            }
            str6 = str2;
        } else {
            str6 = null;
        }
        if ((8 & j) != 0) {
            ThemeBindingAdapters.setBackgroundTint(this.actionView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.actionView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.otherView, "colorAccent");
        }
        if (i5 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.titleContainer, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userViewContainer, onClickListener, bool);
        }
        if (i6 != 0) {
            this.fromWhereView.setVisibility(i);
            String str10 = null;
            Boolean bool2 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.fromWhereView, str6, null, str10, bool2, null, str10);
            TextViewBindingAdapter.setText(this.nameView, str3);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str4, bool2);
        }
        if ((j & 11) != 0) {
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231152, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
        }
    }
}
