package androidx.recyclerview.selection;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

final class GestureSelectionHelper implements RecyclerView.OnItemTouchListener {
    private static final String TAG = "GestureSelectionHelper";
    private final ItemDetailsLookup<?> mDetailsLookup;
    private int mLastStartedItemPos = -1;
    private final OperationMonitor mLock;
    private final AutoScroller mScroller;
    private final SelectionTracker<?> mSelectionMgr;
    private boolean mStarted;
    private final ViewDelegate mView;

    static float getInboundY(float f, float f2) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        return f2 > f ? f : f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    GestureSelectionHelper(SelectionTracker<?> selectionTracker, ItemDetailsLookup<?> itemDetailsLookup, ViewDelegate viewDelegate, AutoScroller autoScroller, OperationMonitor operationMonitor) {
        boolean z = false;
        this.mStarted = false;
        Preconditions.checkArgument(selectionTracker != null);
        Preconditions.checkArgument(itemDetailsLookup != null);
        Preconditions.checkArgument(viewDelegate != null);
        Preconditions.checkArgument(autoScroller != null);
        Preconditions.checkArgument(operationMonitor != null ? true : z);
        this.mSelectionMgr = selectionTracker;
        this.mDetailsLookup = itemDetailsLookup;
        this.mView = viewDelegate;
        this.mScroller = autoScroller;
        this.mLock = operationMonitor;
    }

    void start() {
        Preconditions.checkState(!this.mStarted);
        if (this.mLastStartedItemPos == -1) {
            Log.w("GestureSelectionHelper", "Illegal state. Can't start without valid mLastStartedItemPos.");
            return;
        }
        Preconditions.checkState(this.mSelectionMgr.isRangeActive());
        this.mLock.checkStopped();
        this.mStarted = true;
        this.mLock.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        MotionEvents.isMouseEvent(motionEvent);
        if (motionEvent.getActionMasked() == 0 && this.mDetailsLookup.getItemDetails(motionEvent) != null) {
            this.mLastStartedItemPos = this.mView.getItemUnder(motionEvent);
        }
        return handleTouch(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        handleTouch(motionEvent);
    }

    private boolean handleTouch(MotionEvent motionEvent) {
        if (!this.mStarted) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            handleUpEvent();
            return true;
        } else if (actionMasked == 2) {
            handleMoveEvent(motionEvent);
            return true;
        } else if (actionMasked != 3) {
            return false;
        } else {
            handleCancelEvent();
            return true;
        }
    }

    private void handleUpEvent() {
        this.mSelectionMgr.mergeProvisionalSelection();
        endSelection();
        int i = this.mLastStartedItemPos;
        if (i != -1) {
            this.mSelectionMgr.startRange(i);
        }
    }

    private void handleCancelEvent() {
        this.mSelectionMgr.clearProvisionalSelection();
        endSelection();
    }

    private void endSelection() {
        Preconditions.checkState(this.mStarted);
        this.mLastStartedItemPos = -1;
        this.mStarted = false;
        this.mScroller.reset();
        this.mLock.stop();
    }

    private void handleMoveEvent(MotionEvent motionEvent) {
        Point origin = MotionEvents.getOrigin(motionEvent);
        int lastGlidedItemPosition = this.mView.getLastGlidedItemPosition(motionEvent);
        if (lastGlidedItemPosition != -1) {
            extendSelection(lastGlidedItemPosition);
        }
        this.mScroller.scroll(origin);
    }

    private void extendSelection(int i) {
        this.mSelectionMgr.extendProvisionalRange(i);
    }

    static GestureSelectionHelper create(SelectionTracker<?> selectionTracker, ItemDetailsLookup<?> itemDetailsLookup, RecyclerView recyclerView, AutoScroller autoScroller, OperationMonitor operationMonitor) {
        return new GestureSelectionHelper(selectionTracker, itemDetailsLookup, new RecyclerViewDelegate(recyclerView), autoScroller, operationMonitor);
    }

    static abstract class ViewDelegate {
        abstract int getHeight();

        abstract int getItemUnder(MotionEvent motionEvent);

        abstract int getLastGlidedItemPosition(MotionEvent motionEvent);

        ViewDelegate() {
        }
    }

    static final class RecyclerViewDelegate extends ViewDelegate {
        private final RecyclerView mRecyclerView;

        RecyclerViewDelegate(RecyclerView recyclerView) {
            Preconditions.checkArgument(recyclerView != null);
            this.mRecyclerView = recyclerView;
        }

        @Override // androidx.recyclerview.selection.GestureSelectionHelper.ViewDelegate
        int getHeight() {
            return this.mRecyclerView.getHeight();
        }

        @Override // androidx.recyclerview.selection.GestureSelectionHelper.ViewDelegate
        int getItemUnder(MotionEvent motionEvent) {
            View findChildViewUnder = this.mRecyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                return this.mRecyclerView.getChildAdapterPosition(findChildViewUnder);
            }
            return -1;
        }

        @Override // androidx.recyclerview.selection.GestureSelectionHelper.ViewDelegate
        int getLastGlidedItemPosition(MotionEvent motionEvent) {
            View childAt = this.mRecyclerView.getLayoutManager().getChildAt(this.mRecyclerView.getLayoutManager().getChildCount() - 1);
            boolean isPastLastItem = isPastLastItem(childAt.getTop(), childAt.getLeft(), childAt.getRight(), motionEvent, ViewCompat.getLayoutDirection(this.mRecyclerView));
            float inboundY = GestureSelectionHelper.getInboundY((float) this.mRecyclerView.getHeight(), motionEvent.getY());
            if (isPastLastItem) {
                return this.mRecyclerView.getAdapter().getItemCount() - 1;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView.getChildAdapterPosition(recyclerView.findChildViewUnder(motionEvent.getX(), inboundY));
        }

        static boolean isPastLastItem(int i, int i2, int i3, MotionEvent motionEvent, int i4) {
            if (i4 == 0) {
                return motionEvent.getX() > ((float) i3) && motionEvent.getY() > ((float) i);
            }
            if (motionEvent.getX() >= ((float) i2) || motionEvent.getY() <= ((float) i)) {
                return false;
            }
            return true;
        }
    }
}
