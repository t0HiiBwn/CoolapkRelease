package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.UserAvatarView;

public class ItemUserBindingImpl extends ItemUserBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView4;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362385, 10);
        sparseIntArray.put(2131362887, 11);
        sparseIntArray.put(2131362933, 12);
        sparseIntArray.put(2131362222, 13);
    }

    public ItemUserBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (ActionButtonFrameLayout) objArr[8], (LinearLayout) objArr[1], (CheckBox) objArr[13], (CoolapkCardView) objArr[0], (LinearLayout) objArr[10], (UserAvatarView) objArr[2], (TextView) objArr[7], (TextView) objArr[11], (ImageView) objArr[12], (TextView) objArr[6], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.iconView.setTag(null);
        this.introduceView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        this.subtitleView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
            setModel((User) obj);
        } else if (102 == i) {
            setFans((String) obj);
        } else if (211 == i) {
            setOnClick((View.OnClickListener) obj);
        } else if (116 == i) {
            setFollow((String) obj);
        } else if (287 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUserBinding
    public void setModel(User user) {
        this.mModel = user;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUserBinding
    public void setFans(String str) {
        this.mFans = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(102);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUserBinding
    public void setOnClick(View.OnClickListener onClickListener) {
        this.mOnClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(211);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUserBinding
    public void setFollow(String str) {
        this.mFollow = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(116);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUserBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(287);
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
        int i2;
        String str6;
        int i3;
        String str7;
        String str8;
        String str9;
        int i4;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        User user = this.mModel;
        String str10 = this.mFans;
        View.OnClickListener onClickListener = this.mOnClick;
        String str11 = this.mFollow;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        int i5 = 0;
        if ((j & 49) != 0) {
            int i6 = ((j & 33) > 0 ? 1 : ((j & 33) == 0 ? 0 : -1));
            if (i6 != 0) {
                if (user != null) {
                    userInfo = user.getUserInfo();
                    i4 = user.getIsFollow();
                    str9 = user.getUserName();
                    str8 = user.getSubTitle();
                    str7 = user.getBio();
                } else {
                    userInfo = null;
                    str9 = null;
                    str8 = null;
                    str7 = null;
                    i4 = 0;
                }
                if (userInfo != null) {
                    str3 = userInfo.getVerifyStatusIcon();
                } else {
                    str3 = null;
                }
                boolean z = true;
                if (i4 != 1) {
                    z = false;
                }
                if (i6 != 0) {
                    j |= z ? 2048 : 1024;
                }
                i = z ? 2131887093 : 2131887089;
            } else {
                str3 = null;
                str9 = null;
                str8 = null;
                str7 = null;
                i = 0;
            }
            if (user != null) {
                str5 = user.getUserAvatar();
                str4 = str9;
                str2 = str8;
                str = str7;
            } else {
                str4 = str9;
                str2 = str8;
                str = str7;
                str5 = null;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i7 = ((j & 34) > 0 ? 1 : ((j & 34) == 0 ? 0 : -1));
        if (i7 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str10);
            if (i7 != 0) {
                j |= isEmpty ? 512 : 256;
            }
            i2 = isEmpty ? 8 : 0;
        } else {
            i2 = 0;
        }
        int i8 = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
        if (i8 != 0) {
            boolean isEmpty2 = TextUtils.isEmpty(str11);
            if (i8 != 0) {
                j |= isEmpty2 ? 128 : 64;
            }
            if (isEmpty2) {
                i5 = 8;
            }
            str6 = str10;
            i3 = i5;
        } else {
            str6 = str10;
            i3 = 0;
        }
        if ((33 & j) != 0) {
            this.actionButton.setText(i);
            ImageViewBindingAdapters.setVipSignView(this.iconView, str3, null);
            TextViewBindingAdapter.setText(this.introduceView, str);
            TextViewBindingAdapter.setText(this.subtitleView, str2);
            TextViewBindingAdapter.setText(this.titleView, str4);
        }
        if ((32 & j) != 0) {
            ThemeBindingAdapters.setTextColor(this.actionButton, "colorAccent");
            Long l2 = null;
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, "reveal", l2, l2);
        }
        if ((36 & j) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if ((49 & j) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str5, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        }
        if ((j & 40) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str11);
            this.mboundView4.setVisibility(i3);
        }
        if ((j & 34) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str6);
            this.mboundView5.setVisibility(i2);
        }
    }
}
