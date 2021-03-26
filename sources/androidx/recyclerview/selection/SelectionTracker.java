package androidx.recyclerview.selection;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.BandPredicate;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Set;

public abstract class SelectionTracker<K> {
    public static final String SELECTION_CHANGED_MARKER = "Selection-Changed";

    public static abstract class SelectionObserver<K> {
        public void onItemStateChanged(K k, boolean z) {
        }

        public void onSelectionChanged() {
        }

        public void onSelectionRefresh() {
        }

        public void onSelectionRestored() {
        }
    }

    public static abstract class SelectionPredicate<K> {
        public abstract boolean canSelectMultiple();

        public abstract boolean canSetStateAtPosition(int i, boolean z);

        public abstract boolean canSetStateForKey(K k, boolean z);
    }

    public abstract void addObserver(SelectionObserver selectionObserver);

    abstract void anchorRange(int i);

    abstract void clearProvisionalSelection();

    public abstract boolean clearSelection();

    public abstract void copySelection(MutableSelection<K> mutableSelection);

    public abstract boolean deselect(K k);

    abstract void endRange();

    abstract void extendProvisionalRange(int i);

    abstract void extendRange(int i);

    abstract RecyclerView.AdapterDataObserver getAdapterDataObserver();

    public abstract Selection<K> getSelection();

    public abstract boolean hasSelection();

    abstract boolean isRangeActive();

    public abstract boolean isSelected(K k);

    abstract void mergeProvisionalSelection();

    public abstract void onRestoreInstanceState(Bundle bundle);

    public abstract void onSaveInstanceState(Bundle bundle);

    protected abstract void restoreSelection(Selection<K> selection);

    public abstract boolean select(K k);

    public abstract boolean setItemsSelected(Iterable<K> iterable, boolean z);

    abstract void setProvisionalSelection(Set<K> set);

    abstract void startRange(int i);

    public static final class Builder<K> {
        private final RecyclerView.Adapter<?> mAdapter;
        private int mBandOverlayId = R.drawable.selection_band_overlay;
        private BandPredicate mBandPredicate;
        private final Context mContext;
        private ItemDetailsLookup<K> mDetailsLookup;
        private FocusDelegate<K> mFocusDelegate = FocusDelegate.dummy();
        private int[] mGestureToolTypes = {1, 0};
        private ItemKeyProvider<K> mKeyProvider;
        private OperationMonitor mMonitor = new OperationMonitor();
        private OnContextClickListener mOnContextClickListener;
        private OnDragInitiatedListener mOnDragInitiatedListener;
        private OnItemActivatedListener<K> mOnItemActivatedListener;
        private int[] mPointerToolTypes;
        final RecyclerView mRecyclerView;
        private final String mSelectionId;
        SelectionPredicate<K> mSelectionPredicate = SelectionPredicates.createSelectAnything();
        private final StorageStrategy<K> mStorage;

        public Builder(String str, RecyclerView recyclerView, ItemKeyProvider<K> itemKeyProvider, ItemDetailsLookup<K> itemDetailsLookup, StorageStrategy<K> storageStrategy) {
            boolean z = true;
            this.mPointerToolTypes = new int[]{3};
            Preconditions.checkArgument(str != null);
            Preconditions.checkArgument(!str.trim().isEmpty());
            Preconditions.checkArgument(recyclerView != null);
            this.mSelectionId = str;
            this.mRecyclerView = recyclerView;
            this.mContext = recyclerView.getContext();
            RecyclerView.Adapter<?> adapter = recyclerView.getAdapter();
            this.mAdapter = adapter;
            Preconditions.checkArgument(adapter != null);
            Preconditions.checkArgument(itemKeyProvider != null);
            Preconditions.checkArgument(itemDetailsLookup != null);
            Preconditions.checkArgument(storageStrategy == null ? false : z);
            this.mDetailsLookup = itemDetailsLookup;
            this.mKeyProvider = itemKeyProvider;
            this.mStorage = storageStrategy;
            this.mBandPredicate = new BandPredicate.NonDraggableArea(recyclerView, itemDetailsLookup);
        }

        public Builder<K> withSelectionPredicate(SelectionPredicate<K> selectionPredicate) {
            Preconditions.checkArgument(selectionPredicate != null);
            this.mSelectionPredicate = selectionPredicate;
            return this;
        }

        public Builder<K> withOperationMonitor(OperationMonitor operationMonitor) {
            Preconditions.checkArgument(operationMonitor != null);
            this.mMonitor = operationMonitor;
            return this;
        }

        public Builder<K> withFocusDelegate(FocusDelegate<K> focusDelegate) {
            Preconditions.checkArgument(focusDelegate != null);
            this.mFocusDelegate = focusDelegate;
            return this;
        }

        public Builder<K> withOnItemActivatedListener(OnItemActivatedListener<K> onItemActivatedListener) {
            Preconditions.checkArgument(onItemActivatedListener != null);
            this.mOnItemActivatedListener = onItemActivatedListener;
            return this;
        }

        public Builder<K> withOnContextClickListener(OnContextClickListener onContextClickListener) {
            Preconditions.checkArgument(onContextClickListener != null);
            this.mOnContextClickListener = onContextClickListener;
            return this;
        }

        public Builder<K> withOnDragInitiatedListener(OnDragInitiatedListener onDragInitiatedListener) {
            Preconditions.checkArgument(onDragInitiatedListener != null);
            this.mOnDragInitiatedListener = onDragInitiatedListener;
            return this;
        }

        public Builder<K> withGestureTooltypes(int... iArr) {
            this.mGestureToolTypes = iArr;
            return this;
        }

        public Builder<K> withBandOverlay(int i) {
            this.mBandOverlayId = i;
            return this;
        }

        public Builder<K> withBandPredicate(BandPredicate bandPredicate) {
            Preconditions.checkArgument(bandPredicate != null);
            this.mBandPredicate = bandPredicate;
            return this;
        }

        public Builder<K> withPointerTooltypes(int... iArr) {
            this.mPointerToolTypes = iArr;
            return this;
        }

        public SelectionTracker<K> build() {
            DefaultSelectionTracker defaultSelectionTracker = new DefaultSelectionTracker(this.mSelectionId, this.mKeyProvider, this.mSelectionPredicate, this.mStorage);
            EventBridge.install(this.mAdapter, defaultSelectionTracker, this.mKeyProvider);
            ViewAutoScroller viewAutoScroller = new ViewAutoScroller(ViewAutoScroller.createScrollHost(this.mRecyclerView));
            GestureRouter gestureRouter = new GestureRouter();
            TouchEventRouter touchEventRouter = new TouchEventRouter(new GestureDetector(this.mContext, gestureRouter));
            final GestureSelectionHelper create = GestureSelectionHelper.create(defaultSelectionTracker, this.mDetailsLookup, this.mRecyclerView, viewAutoScroller, this.mMonitor);
            this.mRecyclerView.addOnItemTouchListener(touchEventRouter);
            OnDragInitiatedListener onDragInitiatedListener = this.mOnDragInitiatedListener;
            if (onDragInitiatedListener == null) {
                onDragInitiatedListener = new OnDragInitiatedListener() {
                    /* class androidx.recyclerview.selection.SelectionTracker.Builder.AnonymousClass1 */

                    @Override // androidx.recyclerview.selection.OnDragInitiatedListener
                    public boolean onDragInitiated(MotionEvent motionEvent) {
                        return false;
                    }
                };
            }
            this.mOnDragInitiatedListener = onDragInitiatedListener;
            OnItemActivatedListener<K> onItemActivatedListener = this.mOnItemActivatedListener;
            if (onItemActivatedListener == null) {
                onItemActivatedListener = new OnItemActivatedListener<K>() {
                    /* class androidx.recyclerview.selection.SelectionTracker.Builder.AnonymousClass2 */

                    @Override // androidx.recyclerview.selection.OnItemActivatedListener
                    public boolean onItemActivated(ItemDetailsLookup.ItemDetails<K> itemDetails, MotionEvent motionEvent) {
                        return false;
                    }
                };
            }
            this.mOnItemActivatedListener = onItemActivatedListener;
            OnContextClickListener onContextClickListener = this.mOnContextClickListener;
            if (onContextClickListener == null) {
                onContextClickListener = new OnContextClickListener() {
                    /* class androidx.recyclerview.selection.SelectionTracker.Builder.AnonymousClass3 */

                    @Override // androidx.recyclerview.selection.OnContextClickListener
                    public boolean onContextClick(MotionEvent motionEvent) {
                        return false;
                    }
                };
            }
            this.mOnContextClickListener = onContextClickListener;
            TouchInputHandler touchInputHandler = new TouchInputHandler(defaultSelectionTracker, this.mKeyProvider, this.mDetailsLookup, this.mSelectionPredicate, new Runnable() {
                /* class androidx.recyclerview.selection.SelectionTracker.Builder.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    if (Builder.this.mSelectionPredicate.canSelectMultiple()) {
                        create.start();
                    }
                }
            }, this.mOnDragInitiatedListener, this.mOnItemActivatedListener, this.mFocusDelegate, new Runnable() {
                /* class androidx.recyclerview.selection.SelectionTracker.Builder.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    Builder.this.mRecyclerView.performHapticFeedback(0);
                }
            });
            int[] iArr = this.mGestureToolTypes;
            for (int i : iArr) {
                gestureRouter.register(i, touchInputHandler);
                touchEventRouter.register(i, create);
            }
            MouseInputHandler mouseInputHandler = new MouseInputHandler(defaultSelectionTracker, this.mKeyProvider, this.mDetailsLookup, this.mOnContextClickListener, this.mOnItemActivatedListener, this.mFocusDelegate);
            for (int i2 : this.mPointerToolTypes) {
                gestureRouter.register(i2, mouseInputHandler);
            }
            BandSelectionHelper bandSelectionHelper = null;
            if (this.mKeyProvider.hasAccess(0) && this.mSelectionPredicate.canSelectMultiple()) {
                bandSelectionHelper = BandSelectionHelper.create(this.mRecyclerView, viewAutoScroller, this.mBandOverlayId, this.mKeyProvider, defaultSelectionTracker, this.mSelectionPredicate, this.mBandPredicate, this.mFocusDelegate, this.mMonitor);
            }
            PointerDragEventInterceptor pointerDragEventInterceptor = new PointerDragEventInterceptor(this.mDetailsLookup, this.mOnDragInitiatedListener, bandSelectionHelper);
            for (int i3 : this.mPointerToolTypes) {
                touchEventRouter.register(i3, pointerDragEventInterceptor);
            }
            return defaultSelectionTracker;
        }
    }
}
