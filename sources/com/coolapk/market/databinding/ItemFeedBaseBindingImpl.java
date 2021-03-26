package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.List;

public class ItemFeedBaseBindingImpl extends ItemFeedBaseBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView2;
    private final ImageView mboundView3;
    private final View mboundView6;
    private final View mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362538, 9);
        sparseIntArray.put(2131362542, 10);
    }

    public ItemFeedBaseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemFeedBaseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (FrameLayout) objArr[9], (LinearAdapterLayout) objArr[10], (ImageView) objArr[5], (TextView) objArr[4], (TextView) objArr[8], (LinearLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.likeTextIndicator.setTag(null);
        this.likeThumbView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        View view2 = (View) objArr[6];
        this.mboundView6 = view2;
        view2.setTag(null);
        View view3 = (View) objArr[7];
        this.mboundView7 = view3;
        view3.setTag(null);
        this.moreCommentView.setTag(null);
        this.replayLayout.setTag(null);
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
        if (198 == i) {
            setModel((Feed) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (264 == i) {
            setSingleImg((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedBaseBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedBaseBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemFeedBaseBinding
    public void setSingleImg(String str) {
        this.mSingleImg = str;
    }

    @Override // com.coolapk.market.databinding.ItemFeedBaseBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        List<FeedReply> list;
        List<String> list2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i7 = ((j & 17) > 0 ? 1 : ((j & 17) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (feed != null) {
                i3 = feed.getReplyNum();
                list2 = feed.getRecentLikeList();
                list = feed.getReplyRows();
            } else {
                list2 = null;
                list = null;
                i3 = 0;
            }
            int size = list2 != null ? list2.size() : 0;
            if (list != null) {
                i2 = list.size();
            } else {
                i2 = 0;
            }
            z2 = size > 0;
            z = i3 > i2;
            if (i7 != 0) {
                if (z2) {
                    j3 = j | 256 | 16384;
                    j2 = 262144;
                } else {
                    j3 = j | 128 | 8192;
                    j2 = 131072;
                }
                j = j3 | j2;
            }
            if ((j & 17) != 0) {
                j = z ? j | 4096 : j | 2048;
            }
            i = z2 ? 0 : 8;
        } else {
            i3 = 0;
            z2 = false;
            i2 = 0;
            i = 0;
            z = false;
        }
        boolean z3 = (j & 8448) != 0 && i2 > 0;
        boolean z4 = (4096 & j) != 0 && i3 > 0;
        int i8 = ((j & 17) > 0 ? 1 : ((j & 17) == 0 ? 0 : -1));
        if (i8 != 0) {
            boolean z5 = z2 ? z3 : false;
            if (!z) {
                z4 = false;
            }
            boolean z6 = z2 ? true : z3;
            if (i8 != 0) {
                j |= z5 ? 1024 : 512;
            }
            if ((j & 17) != 0) {
                j |= z4 ? 64 : 32;
            }
            if ((j & 17) != 0) {
                j |= z6 ? 65536 : 32768;
            }
            i5 = z5 ? 0 : 8;
            i6 = z4 ? 0 : 8;
            if (!z6) {
                i4 = 8;
                if ((24 & j) != 0) {
                    Boolean bool = null;
                    ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
                    ViewBindingAdapters.clickListener(this.likeTextIndicator, onClickListener, bool);
                    ViewBindingAdapters.clickListener(this.moreCommentView, onClickListener, bool);
                    ViewBindingAdapters.clickListener(this.replayLayout, onClickListener, bool);
                }
                if ((16 & j) != 0) {
                    ThemeBindingAdapters.setTintColor(this.likeTextIndicator, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.likeThumbView, "colorAccent");
                    ThemeBindingAdapters.setTintColor(this.mboundView3, "colorAccent");
                }
                if ((j & 17) == 0) {
                    TextViewBindingAdapters.setFeedLikeText(this.likeThumbView, feed);
                    this.mboundView2.setVisibility(i);
                    this.mboundView6.setVisibility(i5);
                    this.mboundView7.setVisibility(i6);
                    this.moreCommentView.setVisibility(i6);
                    this.replayLayout.setVisibility(i4);
                    return;
                }
                return;
            }
        } else {
            i6 = 0;
            i5 = 0;
        }
        i4 = 0;
        if ((24 & j) != 0) {
        }
        if ((16 & j) != 0) {
        }
        if ((j & 17) == 0) {
        }
    }
}
