package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.BadBadRatingBar;

public class ItemNodeRatingBindingImpl extends ItemNodeRatingBinding {
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
        sparseIntArray.put(2131363194, 4);
    }

    public ItemNodeRatingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemNodeRatingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (TextView) objArr[3], (BadBadRatingBar) objArr[4], (UserAvatarView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        this.ownerTextView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (197 != i) {
            return false;
        }
        setModel((NodeRating) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemNodeRatingBinding
    public void setModel(NodeRating nodeRating) {
        this.mModel = nodeRating;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        UserInfo userInfo;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        NodeRating nodeRating = this.mModel;
        boolean z = false;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            userInfo = nodeRating != null ? nodeRating.getUserInfo() : null;
            if (userInfo != null) {
                str2 = userInfo.getDisplayUserName();
                str4 = userInfo.getUserAvatar();
            } else {
                str2 = null;
                str4 = null;
            }
            if (str2 == null) {
                z = true;
            }
            if (i != 0) {
                j = z ? j | 8 : j | 4;
            }
            str = str4;
        } else {
            userInfo = null;
            str2 = null;
            str = null;
        }
        if ((j & 8) == 0 || userInfo == null) {
            str3 = null;
        } else {
            str3 = userInfo.getUserName();
        }
        int i2 = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i2 == 0) {
            str2 = null;
        } else if (z) {
            str2 = str3;
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.ownerTextView, null, 3);
        }
        if (i2 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.userNameView, str2);
        }
    }
}
