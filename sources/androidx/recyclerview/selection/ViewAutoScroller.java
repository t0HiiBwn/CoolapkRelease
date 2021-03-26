package androidx.recyclerview.selection;

import android.graphics.Point;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

final class ViewAutoScroller extends AutoScroller {
    private static final float DEFAULT_SCROLL_THRESHOLD_RATIO = 0.125f;
    private static final int MAX_SCROLL_STEP = 70;
    private static final String TAG = "ViewAutoScroller";
    private final ScrollHost mHost;
    private Point mLastLocation;
    private Point mOrigin;
    private boolean mPassedInitialMotionThreshold;
    private final Runnable mRunner;
    private final float mScrollThresholdRatio;

    ViewAutoScroller(ScrollHost scrollHost) {
        this(scrollHost, 0.125f);
    }

    ViewAutoScroller(ScrollHost scrollHost, float f) {
        Preconditions.checkArgument(scrollHost != null);
        this.mHost = scrollHost;
        this.mScrollThresholdRatio = f;
        this.mRunner = new Runnable() {
            /* class androidx.recyclerview.selection.ViewAutoScroller.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                ViewAutoScroller.this.runScroll();
            }
        };
    }

    @Override // androidx.recyclerview.selection.AutoScroller
    public void reset() {
        this.mHost.removeCallback(this.mRunner);
        this.mOrigin = null;
        this.mLastLocation = null;
        this.mPassedInitialMotionThreshold = false;
    }

    @Override // androidx.recyclerview.selection.AutoScroller
    public void scroll(Point point) {
        this.mLastLocation = point;
        if (this.mOrigin == null) {
            this.mOrigin = point;
        }
        this.mHost.runAtNextFrame(this.mRunner);
    }

    void runScroll() {
        int i;
        int viewHeight = (int) (((float) this.mHost.getViewHeight()) * this.mScrollThresholdRatio);
        if (this.mLastLocation.y <= viewHeight) {
            i = this.mLastLocation.y - viewHeight;
        } else {
            i = this.mLastLocation.y >= this.mHost.getViewHeight() - viewHeight ? (this.mLastLocation.y - this.mHost.getViewHeight()) + viewHeight : 0;
        }
        if (i != 0) {
            if (this.mPassedInitialMotionThreshold || aboveMotionThreshold(this.mLastLocation)) {
                this.mPassedInitialMotionThreshold = true;
                if (i <= viewHeight) {
                    viewHeight = i;
                }
                this.mHost.scrollBy(computeScrollDistance(viewHeight));
                this.mHost.removeCallback(this.mRunner);
                this.mHost.runAtNextFrame(this.mRunner);
            }
        }
    }

    private boolean aboveMotionThreshold(Point point) {
        float f = this.mScrollThresholdRatio;
        return Math.abs(this.mOrigin.y - point.y) >= ((int) ((((float) this.mHost.getViewHeight()) * f) * (f * 2.0f)));
    }

    int computeScrollDistance(int i) {
        int signum = (int) Math.signum((float) i);
        int smoothOutOfBoundsRatio = (int) (((float) (signum * 70)) * smoothOutOfBoundsRatio(Math.min(1.0f, ((float) Math.abs(i)) / ((float) ((int) (((float) this.mHost.getViewHeight()) * this.mScrollThresholdRatio))))));
        return smoothOutOfBoundsRatio != 0 ? smoothOutOfBoundsRatio : signum;
    }

    private float smoothOutOfBoundsRatio(float f) {
        return (float) Math.pow((double) f, 10.0d);
    }

    static abstract class ScrollHost {
        abstract int getViewHeight();

        abstract void removeCallback(Runnable runnable);

        abstract void runAtNextFrame(Runnable runnable);

        abstract void scrollBy(int i);

        ScrollHost() {
        }
    }

    static ScrollHost createScrollHost(RecyclerView recyclerView) {
        return new RuntimeHost(recyclerView);
    }

    private static final class RuntimeHost extends ScrollHost {
        private final RecyclerView mRecyclerView;

        RuntimeHost(RecyclerView recyclerView) {
            this.mRecyclerView = recyclerView;
        }

        @Override // androidx.recyclerview.selection.ViewAutoScroller.ScrollHost
        void runAtNextFrame(Runnable runnable) {
            ViewCompat.postOnAnimation(this.mRecyclerView, runnable);
        }

        @Override // androidx.recyclerview.selection.ViewAutoScroller.ScrollHost
        void removeCallback(Runnable runnable) {
            this.mRecyclerView.removeCallbacks(runnable);
        }

        @Override // androidx.recyclerview.selection.ViewAutoScroller.ScrollHost
        void scrollBy(int i) {
            this.mRecyclerView.scrollBy(0, i);
        }

        @Override // androidx.recyclerview.selection.ViewAutoScroller.ScrollHost
        int getViewHeight() {
            return this.mRecyclerView.getHeight();
        }
    }
}
