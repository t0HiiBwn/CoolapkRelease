package androidx.recyclerview.selection;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.GridModel;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Set;

class BandSelectionHelper<K> implements RecyclerView.OnItemTouchListener {
    static final boolean DEBUG = false;
    static final String TAG = "BandSelectionHelper";
    private final BandPredicate mBandPredicate;
    private Point mCurrentPosition;
    private final FocusDelegate<K> mFocusDelegate;
    private final GridModel.SelectionObserver mGridObserver;
    private final BandHost mHost;
    private final ItemKeyProvider<K> mKeyProvider;
    private final OperationMonitor mLock;
    private GridModel mModel;
    private Point mOrigin;
    private final AutoScroller mScroller;
    final SelectionTracker<K> mSelectionTracker;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    BandSelectionHelper(BandHost bandHost, AutoScroller autoScroller, ItemKeyProvider<K> itemKeyProvider, SelectionTracker<K> selectionTracker, BandPredicate bandPredicate, FocusDelegate<K> focusDelegate, OperationMonitor operationMonitor) {
        boolean z = true;
        Preconditions.checkArgument(bandHost != null);
        Preconditions.checkArgument(autoScroller != null);
        Preconditions.checkArgument(itemKeyProvider != null);
        Preconditions.checkArgument(selectionTracker != null);
        Preconditions.checkArgument(bandPredicate != null);
        Preconditions.checkArgument(focusDelegate != null);
        Preconditions.checkArgument(operationMonitor == null ? false : z);
        this.mHost = bandHost;
        this.mKeyProvider = itemKeyProvider;
        this.mSelectionTracker = selectionTracker;
        this.mBandPredicate = bandPredicate;
        this.mFocusDelegate = focusDelegate;
        this.mLock = operationMonitor;
        bandHost.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class androidx.recyclerview.selection.BandSelectionHelper.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                BandSelectionHelper.this.onScrolled(recyclerView, i, i2);
            }
        });
        this.mScroller = autoScroller;
        this.mGridObserver = new GridModel.SelectionObserver<K>() {
            /* class androidx.recyclerview.selection.BandSelectionHelper.AnonymousClass2 */

            @Override // androidx.recyclerview.selection.GridModel.SelectionObserver
            public void onSelectionChanged(Set<K> set) {
                BandSelectionHelper.this.mSelectionTracker.setProvisionalSelection(set);
            }
        };
    }

    static <K> BandSelectionHelper create(RecyclerView recyclerView, AutoScroller autoScroller, int i, ItemKeyProvider<K> itemKeyProvider, SelectionTracker<K> selectionTracker, SelectionTracker.SelectionPredicate<K> selectionPredicate, BandPredicate bandPredicate, FocusDelegate<K> focusDelegate, OperationMonitor operationMonitor) {
        return new BandSelectionHelper(new DefaultBandHost(recyclerView, i, itemKeyProvider, selectionPredicate), autoScroller, itemKeyProvider, selectionTracker, bandPredicate, focusDelegate, operationMonitor);
    }

    boolean isActive() {
        return this.mModel != null;
    }

    void reset() {
        if (isActive()) {
            this.mHost.hideBand();
            GridModel gridModel = this.mModel;
            if (gridModel != null) {
                gridModel.stopCapturing();
                this.mModel.onDestroy();
            }
            this.mModel = null;
            this.mOrigin = null;
            this.mScroller.reset();
            this.mLock.stop();
        }
    }

    boolean shouldStart(MotionEvent motionEvent) {
        return MotionEvents.isPrimaryMouseButtonPressed(motionEvent) && MotionEvents.isActionMove(motionEvent) && this.mBandPredicate.canInitiate(motionEvent) && !isActive();
    }

    boolean shouldStop(MotionEvent motionEvent) {
        return isActive() && (MotionEvents.isActionUp(motionEvent) || MotionEvents.isActionPointerUp(motionEvent) || MotionEvents.isActionCancel(motionEvent));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (shouldStart(motionEvent)) {
            startBandSelect(motionEvent);
        } else if (shouldStop(motionEvent)) {
            endBandSelect();
        }
        return isActive();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (shouldStop(motionEvent)) {
            endBandSelect();
        } else if (isActive()) {
            Point origin = MotionEvents.getOrigin(motionEvent);
            this.mCurrentPosition = origin;
            this.mModel.resizeSelection(origin);
            resizeBand();
            this.mScroller.scroll(this.mCurrentPosition);
        }
    }

    private void startBandSelect(MotionEvent motionEvent) {
        Preconditions.checkState(!isActive());
        if (!MotionEvents.isCtrlKeyPressed(motionEvent)) {
            this.mSelectionTracker.clearSelection();
        }
        Point origin = MotionEvents.getOrigin(motionEvent);
        GridModel<K> createGridModel = this.mHost.createGridModel();
        this.mModel = createGridModel;
        createGridModel.addOnSelectionChangedListener(this.mGridObserver);
        this.mLock.start();
        this.mFocusDelegate.clearFocus();
        this.mOrigin = origin;
        this.mModel.startCapturing(origin);
    }

    private void resizeBand() {
        this.mHost.showBand(new Rect(Math.min(this.mOrigin.x, this.mCurrentPosition.x), Math.min(this.mOrigin.y, this.mCurrentPosition.y), Math.max(this.mOrigin.x, this.mCurrentPosition.x), Math.max(this.mOrigin.y, this.mCurrentPosition.y)));
    }

    private void endBandSelect() {
        int positionNearestOrigin = this.mModel.getPositionNearestOrigin();
        if (positionNearestOrigin != -1 && this.mSelectionTracker.isSelected(this.mKeyProvider.getKey(positionNearestOrigin))) {
            this.mSelectionTracker.anchorRange(positionNearestOrigin);
        }
        this.mSelectionTracker.mergeProvisionalSelection();
        reset();
    }

    void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (isActive()) {
            this.mOrigin.y -= i2;
            resizeBand();
        }
    }

    static abstract class BandHost<K> {
        abstract void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener);

        abstract GridModel<K> createGridModel();

        abstract void hideBand();

        abstract void showBand(Rect rect);

        BandHost() {
        }
    }
}
