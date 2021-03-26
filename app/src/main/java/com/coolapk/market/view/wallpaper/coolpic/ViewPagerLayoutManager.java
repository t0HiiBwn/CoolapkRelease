package com.coolapk.market.view.wallpaper.coolpic;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fH\u0016J(\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000fR\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/ViewPagerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "mChildAttachStateChangeListener", "com/coolapk/market/view/wallpaper/coolpic/ViewPagerLayoutManager$mChildAttachStateChangeListener$1", "Lcom/coolapk/market/view/wallpaper/coolpic/ViewPagerLayoutManager$mChildAttachStateChangeListener$1;", "mDrift", "mOnViewPagerListener", "Lcom/coolapk/market/view/wallpaper/coolpic/OnViewPagerListener;", "mPagerSnapHelper", "Landroidx/recyclerview/widget/PagerSnapHelper;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "findSnapPosition", "init", "", "onAttachedToWindow", "view", "onScrollStateChanged", "state", "scrollHorizontallyBy", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "setOnViewPagerListener", "listener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewPagerLayoutManager.kt */
public final class ViewPagerLayoutManager extends LinearLayoutManager {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ViewPagerLayoutManager";
    private final ViewPagerLayoutManager$mChildAttachStateChangeListener$1 mChildAttachStateChangeListener = new ViewPagerLayoutManager$mChildAttachStateChangeListener$1(this);
    private int mDrift;
    private OnViewPagerListener mOnViewPagerListener;
    private PagerSnapHelper mPagerSnapHelper;
    private RecyclerView mRecyclerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewPagerLayoutManager(Context context, int i) {
        super(context, i, false);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewPagerLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    private final void init() {
        this.mPagerSnapHelper = new PagerSnapHelper();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        PagerSnapHelper pagerSnapHelper = this.mPagerSnapHelper;
        Intrinsics.checkNotNull(pagerSnapHelper);
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.addOnChildAttachStateChangeListener(this.mChildAttachStateChangeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            PagerSnapHelper pagerSnapHelper = this.mPagerSnapHelper;
            Intrinsics.checkNotNull(pagerSnapHelper);
            View findSnapView = pagerSnapHelper.findSnapView(this);
            if (findSnapView != null) {
                int position = getPosition(findSnapView);
                getChildCount();
                if (this.mOnViewPagerListener != null && getChildCount() <= 2) {
                    OnViewPagerListener onViewPagerListener = this.mOnViewPagerListener;
                    Intrinsics.checkNotNull(onViewPagerListener);
                    boolean z = true;
                    if (position != getItemCount() - 1) {
                        z = false;
                    }
                    onViewPagerListener.onPageSelected(position, z);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = i;
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = i;
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public final int findSnapPosition() {
        PagerSnapHelper pagerSnapHelper = this.mPagerSnapHelper;
        Intrinsics.checkNotNull(pagerSnapHelper);
        View findSnapView = pagerSnapHelper.findSnapView(this);
        if (findSnapView != null) {
            return getPosition(findSnapView);
        }
        return -1;
    }

    public final void setOnViewPagerListener(OnViewPagerListener onViewPagerListener) {
        Intrinsics.checkNotNullParameter(onViewPagerListener, "listener");
        this.mOnViewPagerListener = onViewPagerListener;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/ViewPagerLayoutManager$Companion;", "", "()V", "TAG", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ViewPagerLayoutManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
