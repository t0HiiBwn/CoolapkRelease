package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.List;

public class ItemFeedReplyPartBindingImpl extends ItemFeedReplyPartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final View mboundView1;
    private final View mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362534, 4);
    }

    public ItemFeedReplyPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemFeedReplyPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearAdapterLayout) objArr[4], (TextView) objArr[3], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        View view2 = (View) objArr[1];
        this.mboundView1 = view2;
        view2.setTag(null);
        View view3 = (View) objArr[2];
        this.mboundView2 = view3;
        view3.setTag(null);
        this.moreCommentView.setTag(null);
        this.replayLayout.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemFeedReplyPartBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedReplyPartBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007d, code lost:
        if (r15 != false) goto L_0x007f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        boolean z;
        int i3;
        List<FeedReply> list;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i5 = 8;
        boolean z2 = true;
        int i6 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (feed != null) {
                i2 = feed.getReplyNum();
                list = feed.getReplyRows();
            } else {
                list = null;
                i2 = 0;
            }
            if (list != null) {
                i4 = list.size();
            } else {
                i4 = 0;
            }
            boolean z3 = i4 > 0;
            z = i2 > i4;
            if (i6 != 0) {
                j |= z3 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j = z ? j | 64 : j | 32;
            }
            if (!z3) {
                i = 8;
                if ((64 & j) == 0 || i2 <= 0) {
                    z2 = false;
                }
                i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
                if (i3 != 0) {
                    if (!z) {
                        z2 = false;
                    }
                    if (i3 != 0) {
                        j |= z2 ? 16 : 8;
                    }
                }
                i5 = 0;
                if ((5 & j) != 0) {
                    this.mboundView1.setVisibility(i);
                    this.mboundView2.setVisibility(i5);
                    this.moreCommentView.setVisibility(i5);
                    this.replayLayout.setVisibility(i);
                }
                if ((j & 6) == 0) {
                    Boolean bool = null;
                    ViewBindingAdapters.clickListener(this.moreCommentView, onClickListener, bool);
                    ViewBindingAdapters.clickListener(this.replayLayout, onClickListener, bool);
                    return;
                }
                return;
            }
        } else {
            z = false;
            i2 = 0;
        }
        i = 0;
        z2 = false;
        i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i3 != 0) {
        }
        i5 = 0;
        if ((5 & j) != 0) {
        }
        if ((j & 6) == 0) {
        }
    }
}
