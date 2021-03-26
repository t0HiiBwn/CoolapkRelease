package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Topic;

public class ItemTopicBindingImpl extends ItemTopicBinding {
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
        sparseIntArray.put(2131363634, 4);
        sparseIntArray.put(2131362588, 5);
    }

    public ItemTopicBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[0], (TextView) objArr[2], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.iconView.setTag(null);
        this.ignoreFlag.setTag(null);
        this.itemView.setTag(null);
        this.titleView.setTag(null);
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
            setModel((Topic) obj);
        } else if (288 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTopicBinding
    public void setModel(Topic topic) {
        this.mModel = topic;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTopicBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Topic topic = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        int i3 = 0;
        if ((j & 7) != 0) {
            String logo = topic != null ? topic.getLogo() : null;
            int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (topic != null) {
                    str5 = topic.getTitle();
                    str3 = topic.getDescription();
                } else {
                    str3 = null;
                    str5 = null;
                }
                boolean isEmpty = TextUtils.isEmpty(str3);
                if (i4 != 0) {
                    j |= isEmpty ? 16 : 8;
                }
                if (isEmpty) {
                    i3 = 8;
                }
                str = logo;
                str2 = str5;
                i = i3;
                if ((7 & j) == 0) {
                    Boolean bool = null;
                    str4 = str2;
                    i2 = i;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231374, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
                } else {
                    i2 = i;
                    str4 = str2;
                }
                if ((j & 5) == 0) {
                    TextViewBindingAdapter.setText(this.ignoreFlag, str3);
                    this.ignoreFlag.setVisibility(i2);
                    TextViewBindingAdapter.setText(this.titleView, str4);
                    return;
                }
                return;
            }
            str = logo;
            str3 = null;
            str2 = null;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        i = 0;
        if ((7 & j) == 0) {
        }
        if ((j & 5) == 0) {
        }
    }
}
