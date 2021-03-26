package com.github.rubensousa.gravitysnaphelper;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.text.TextUtilsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

public class GravitySnapHelper extends LinearSnapHelper {
    public static final int FLING_DISTANCE_DISABLE = -1;
    public static final float FLING_SIZE_FRACTION_DISABLE = -1.0f;
    private int gravity;
    private OrientationHelper horizontalHelper;
    private boolean isRtl;
    private boolean isScrolling;
    private SnapListener listener;
    private int maxFlingDistance;
    private float maxFlingSizeFraction;
    private int nextSnapPosition;
    private RecyclerView recyclerView;
    private RecyclerView.OnScrollListener scrollListener;
    private float scrollMsPerInch;
    private boolean snapLastItem;
    private boolean snapToPadding;
    private OrientationHelper verticalHelper;

    public interface SnapListener {
        void onSnap(int i);
    }

    public GravitySnapHelper(int i) {
        this(i, false, null);
    }

    public GravitySnapHelper(int i, SnapListener snapListener) {
        this(i, false, snapListener);
    }

    public GravitySnapHelper(int i, boolean z) {
        this(i, z, null);
    }

    public GravitySnapHelper(int i, boolean z, SnapListener snapListener) {
        this.isScrolling = false;
        this.snapToPadding = false;
        this.scrollMsPerInch = 100.0f;
        this.maxFlingDistance = -1;
        this.maxFlingSizeFraction = -1.0f;
        this.scrollListener = new RecyclerView.OnScrollListener() {
            /* class com.github.rubensousa.gravitysnaphelper.GravitySnapHelper.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && GravitySnapHelper.this.listener != null && GravitySnapHelper.this.nextSnapPosition != -1 && GravitySnapHelper.this.isScrolling) {
                    GravitySnapHelper.this.listener.onSnap(GravitySnapHelper.this.nextSnapPosition);
                }
                GravitySnapHelper.this.isScrolling = i != 0;
            }
        };
        if (i == 8388611 || i == 8388613 || i == 80 || i == 48 || i == 17) {
            this.snapLastItem = z;
            this.gravity = i;
            this.listener = snapListener;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView2) throws IllegalStateException {
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.removeOnScrollListener(this.scrollListener);
        }
        if (recyclerView2 != null) {
            recyclerView2.setOnFlingListener(null);
            int i = this.gravity;
            if (i == 8388611 || i == 8388613) {
                boolean z = true;
                if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                    z = false;
                }
                this.isRtl = z;
            }
            recyclerView2.addOnScrollListener(this.scrollListener);
            this.recyclerView = recyclerView2;
        } else {
            this.recyclerView = null;
        }
        super.attachToRecyclerView(recyclerView2);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return findSnapView(layoutManager, true);
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager, boolean z) {
        View view;
        int i = this.gravity;
        if (i != 17) {
            if (i == 48) {
                view = findView(layoutManager, getVerticalHelper(layoutManager), 8388611, z);
            } else if (i == 80) {
                view = findView(layoutManager, getVerticalHelper(layoutManager), 8388613, z);
            } else if (i == 8388611) {
                view = findView(layoutManager, getHorizontalHelper(layoutManager), 8388611, z);
            } else if (i != 8388613) {
                view = null;
            } else {
                view = findView(layoutManager, getHorizontalHelper(layoutManager), 8388613, z);
            }
        } else if (layoutManager.canScrollHorizontally()) {
            view = findView(layoutManager, getHorizontalHelper(layoutManager), 17, z);
        } else {
            view = findView(layoutManager, getVerticalHelper(layoutManager), 17, z);
        }
        if (view != null) {
            this.nextSnapPosition = this.recyclerView.getChildAdapterPosition(view);
        } else {
            this.nextSnapPosition = -1;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        if (this.gravity == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            boolean z = this.isRtl;
            if ((!z || this.gravity != 8388613) && (z || this.gravity != 8388611)) {
                iArr[0] = getDistanceToEnd(view, getHorizontalHelper(linearLayoutManager));
            } else {
                iArr[0] = getDistanceToStart(view, getHorizontalHelper(linearLayoutManager));
            }
        } else if (linearLayoutManager.canScrollVertically()) {
            if (this.gravity == 48) {
                iArr[1] = getDistanceToStart(view, getVerticalHelper(linearLayoutManager));
            } else {
                iArr[1] = getDistanceToEnd(view, getVerticalHelper(linearLayoutManager));
            }
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateScrollDistance(int i, int i2) {
        if (this.recyclerView == null || ((this.verticalHelper == null && this.horizontalHelper == null) || (this.maxFlingDistance == -1 && this.maxFlingSizeFraction == -1.0f))) {
            return super.calculateScrollDistance(i, i2);
        }
        Scroller scroller = new Scroller(this.recyclerView.getContext(), new DecelerateInterpolator());
        int flingDistance = getFlingDistance();
        int i3 = -flingDistance;
        scroller.fling(0, 0, i, i2, i3, flingDistance, i3, flingDistance);
        return new int[]{scroller.getFinalX(), scroller.getFinalY()};
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || this.recyclerView == null) {
            return null;
        }
        return new LinearSmoothScroller(this.recyclerView.getContext()) {
            /* class com.github.rubensousa.gravitysnaphelper.GravitySnapHelper.AnonymousClass2 */

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (GravitySnapHelper.this.recyclerView != null && GravitySnapHelper.this.recyclerView.getLayoutManager() != null) {
                    GravitySnapHelper gravitySnapHelper = GravitySnapHelper.this;
                    int[] calculateDistanceToFinalSnap = gravitySnapHelper.calculateDistanceToFinalSnap(gravitySnapHelper.recyclerView.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return GravitySnapHelper.this.scrollMsPerInch / ((float) displayMetrics.densityDpi);
            }
        };
    }

    public void setSnapListener(SnapListener snapListener) {
        this.listener = snapListener;
    }

    public void setMaxFlingDistance(int i) {
        this.maxFlingDistance = i;
        this.maxFlingSizeFraction = -1.0f;
    }

    public void setMaxFlingSizeFraction(float f) {
        this.maxFlingDistance = -1;
        this.maxFlingSizeFraction = f;
    }

    public void setSnapLastItem(boolean z) {
        this.snapLastItem = z;
    }

    public void setSnapToPadding(boolean z) {
        this.snapToPadding = z;
    }

    public void setScrollMsPerInch(float f) {
        this.scrollMsPerInch = f;
    }

    public void setGravity(int i) {
        setGravity(i, true);
    }

    public void setGravity(int i, Boolean bool) {
        if (this.gravity != i) {
            this.gravity = i;
            updateSnap(bool, false);
        }
    }

    public void updateSnap(Boolean bool, Boolean bool2) {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null && recyclerView2.getLayoutManager() != null && (findSnapView = findSnapView((layoutManager = this.recyclerView.getLayoutManager()), bool2.booleanValue())) != null) {
            int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
            if (bool.booleanValue()) {
                this.recyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
            } else {
                this.recyclerView.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
            }
        }
    }

    public boolean scrollToPosition(int i) {
        if (i == -1) {
            return false;
        }
        return scrollTo(i, false);
    }

    public boolean smoothScrollToPosition(int i) {
        if (i == -1) {
            return false;
        }
        return scrollTo(i, true);
    }

    public int getGravity() {
        return this.gravity;
    }

    public boolean getSnapLastItem() {
        return this.snapLastItem;
    }

    public int getMaxFlingDistance() {
        return this.maxFlingDistance;
    }

    public float getMaxFlingSizeFraction() {
        return this.maxFlingSizeFraction;
    }

    public float getScrollMsPerInch() {
        return this.scrollMsPerInch;
    }

    public boolean getSnapToPadding() {
        return this.snapToPadding;
    }

    public int getCurrentSnappedPosition() {
        View findSnapView;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null || recyclerView2.getLayoutManager() == null || (findSnapView = findSnapView(this.recyclerView.getLayoutManager())) == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(findSnapView);
    }

    private int getFlingDistance() {
        float width;
        float f;
        if (this.maxFlingSizeFraction != -1.0f) {
            if (this.verticalHelper != null) {
                width = (float) this.recyclerView.getHeight();
                f = this.maxFlingSizeFraction;
            } else if (this.horizontalHelper == null) {
                return Integer.MAX_VALUE;
            } else {
                width = (float) this.recyclerView.getWidth();
                f = this.maxFlingSizeFraction;
            }
            return (int) (width * f);
        }
        int i = this.maxFlingDistance;
        if (i != -1) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    private boolean scrollTo(int i, boolean z) {
        if (this.recyclerView.getLayoutManager() != null) {
            if (z) {
                RecyclerView.SmoothScroller createScroller = createScroller(this.recyclerView.getLayoutManager());
                if (createScroller != null) {
                    createScroller.setTargetPosition(i);
                    this.recyclerView.getLayoutManager().startSmoothScroll(createScroller);
                    return true;
                }
            } else {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(i);
                if (findViewHolderForAdapterPosition != null) {
                    int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.recyclerView.getLayoutManager(), findViewHolderForAdapterPosition.itemView);
                    this.recyclerView.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                    return true;
                }
            }
        }
        return false;
    }

    private int getDistanceToStart(View view, OrientationHelper orientationHelper) {
        int i;
        int i2;
        if (!this.snapToPadding) {
            i2 = orientationHelper.getDecoratedStart(view);
            if (i2 < orientationHelper.getStartAfterPadding() / 2) {
                return i2;
            }
            i = orientationHelper.getStartAfterPadding();
        } else {
            i2 = orientationHelper.getDecoratedStart(view);
            i = orientationHelper.getStartAfterPadding();
        }
        return i2 - i;
    }

    private int getDistanceToEnd(View view, OrientationHelper orientationHelper) {
        int i;
        int i2;
        if (!this.snapToPadding) {
            int decoratedEnd = orientationHelper.getDecoratedEnd(view);
            if (decoratedEnd < orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
                return decoratedEnd - orientationHelper.getEndAfterPadding();
            }
            i2 = orientationHelper.getDecoratedEnd(view);
            i = orientationHelper.getEnd();
        } else {
            i2 = orientationHelper.getDecoratedEnd(view);
            i = orientationHelper.getEndAfterPadding();
        }
        return i2 - i;
    }

    private View findView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, boolean z) {
        int i2;
        int i3;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (z && isAtEdgeOfList(linearLayoutManager) && !this.snapLastItem) {
                return null;
            }
            int i4 = Integer.MAX_VALUE;
            if (layoutManager.getClipToPadding()) {
                i2 = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                i2 = orientationHelper.getEnd() / 2;
            }
            boolean z2 = true;
            boolean z3 = (i == 8388611 && !this.isRtl) || (i == 8388613 && this.isRtl);
            if ((i != 8388611 || !this.isRtl) && (i != 8388613 || this.isRtl)) {
                z2 = false;
            }
            for (int i5 = 0; i5 < linearLayoutManager.getChildCount(); i5++) {
                View childAt = linearLayoutManager.getChildAt(i5);
                if (z3) {
                    if (!this.snapToPadding) {
                        i3 = Math.abs(orientationHelper.getDecoratedStart(childAt));
                    } else {
                        i3 = Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                    }
                } else if (!z2) {
                    i3 = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - i2);
                } else if (!this.snapToPadding) {
                    i3 = Math.abs(orientationHelper.getDecoratedEnd(childAt) - orientationHelper.getEnd());
                } else {
                    i3 = Math.abs(orientationHelper.getEndAfterPadding() - orientationHelper.getDecoratedEnd(childAt));
                }
                if (i3 < i4) {
                    view = childAt;
                    i4 = i3;
                }
            }
        }
        return view;
    }

    private boolean isAtEdgeOfList(LinearLayoutManager linearLayoutManager) {
        if ((linearLayoutManager.getReverseLayout() || this.gravity != 8388611) && ((!linearLayoutManager.getReverseLayout() || this.gravity != 8388613) && ((linearLayoutManager.getReverseLayout() || this.gravity != 48) && (!linearLayoutManager.getReverseLayout() || this.gravity != 80)))) {
            if (this.gravity == 17) {
                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
                    return true;
                }
                return false;
            } else if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                return true;
            } else {
                return false;
            }
        } else if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
            return true;
        } else {
            return false;
        }
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.verticalHelper;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.verticalHelper;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.horizontalHelper;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.horizontalHelper;
    }
}
