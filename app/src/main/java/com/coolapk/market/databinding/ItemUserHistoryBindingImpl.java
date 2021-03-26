package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.viewholder.UserHistoryViewHolder;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemUserHistoryBindingImpl extends ItemUserHistoryBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362376, 6);
    }

    public ItemUserHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemUserHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CoolapkCardView) objArr[0], (CoolEllipsizeTextView) objArr[6], (LinearLayout) objArr[1], (ImageView) objArr[2], (TextView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.itemView.setTag(null);
        this.logoView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        this.titleView.setTag(null);
        this.typeView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (294 == i) {
            setUserHistory((UserHistory) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (307 == i) {
            setViewHolder((UserHistoryViewHolder) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUserHistoryBinding
    public void setUserHistory(UserHistory userHistory) {
        this.mUserHistory = userHistory;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(294);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUserHistoryBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemUserHistoryBinding
    public void setViewHolder(UserHistoryViewHolder userHistoryViewHolder) {
        this.mViewHolder = userHistoryViewHolder;
    }

    @Override // com.coolapk.market.databinding.ItemUserHistoryBinding
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
        return onChangeViewHolder((UserHistoryViewHolder) obj, i2);
    }

    private boolean onChangeViewHolder(UserHistoryViewHolder userHistoryViewHolder, int i) {
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
        Long l2;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UserHistory userHistory = this.mUserHistory;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 18) > 0 ? 1 : ((j & 18) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (userHistory != null) {
                str3 = userHistory.getTypeName();
                str5 = userHistory.getLogo();
                str4 = userHistory.getTitle();
                l2 = userHistory.getDateline();
            } else {
                l2 = null;
                str3 = null;
                str5 = null;
                str4 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str3);
            if (i2 != 0) {
                j |= isEmpty ? 64 : 32;
            }
            if (isEmpty) {
                i = 8;
            }
            str = str5;
            str2 = str4;
        } else {
            l2 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((24 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.logoView, onClickListener, bool);
        }
        if ((j & 18) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str, AppCompatResources.getDrawable(this.logoView.getContext(), 2131231363), 0, 0, bool2, bool2, bool2, true, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            TextViewBindingAdapters.setTime(this.mboundView5, l2);
            TextViewBindingAdapter.setText(this.titleView, str2);
            TextViewBindingAdapter.setText(this.typeView, str3);
            this.typeView.setVisibility(i);
        }
        if ((j & 16) != 0) {
            ViewBindingAdapters.clipView(this.logoView, null, 8);
        }
    }
}
