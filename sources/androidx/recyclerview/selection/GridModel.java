package androidx.recyclerview.selection;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.BandSelectionHelper;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class GridModel<K> {
    private static final int LEFT = 0;
    private static final int LOWER = 1;
    private static final int LOWER_LEFT = 1;
    private static final int LOWER_RIGHT = 3;
    static final int NOT_SET = -1;
    private static final int RIGHT = 2;
    private static final int UPPER = 0;
    private static final int UPPER_LEFT = 0;
    private static final int UPPER_RIGHT = 2;
    private final List<Limits> mColumnBounds = new ArrayList();
    private final SparseArray<SparseIntArray> mColumns = new SparseArray<>();
    private final GridHost<K> mHost;
    private boolean mIsActive;
    private final ItemKeyProvider<K> mKeyProvider;
    private final SparseBooleanArray mKnownPositions = new SparseBooleanArray();
    private final List<SelectionObserver> mOnSelectionChangedListeners = new ArrayList();
    private Point mPointer;
    private int mPositionNearestOrigin = -1;
    private RelativePoint mRelOrigin;
    private RelativePoint mRelPointer;
    private final List<Limits> mRowBounds = new ArrayList();
    private final RecyclerView.OnScrollListener mScrollListener;
    private final Set<K> mSelection = new HashSet();
    private final SelectionTracker.SelectionPredicate<K> mSelectionPredicate;

    public static abstract class SelectionObserver<K> {
        abstract void onSelectionChanged(Set<K> set);
    }

    GridModel(GridHost gridHost, ItemKeyProvider<K> itemKeyProvider, SelectionTracker.SelectionPredicate<K> selectionPredicate) {
        boolean z = true;
        Preconditions.checkArgument(gridHost != null);
        Preconditions.checkArgument(itemKeyProvider != null);
        Preconditions.checkArgument(selectionPredicate == null ? false : z);
        this.mHost = gridHost;
        this.mKeyProvider = itemKeyProvider;
        this.mSelectionPredicate = selectionPredicate;
        AnonymousClass1 r5 = new RecyclerView.OnScrollListener() {
            /* class androidx.recyclerview.selection.GridModel.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                GridModel.this.onScrolled(recyclerView, i, i2);
            }
        };
        this.mScrollListener = r5;
        gridHost.addOnScrollListener(r5);
    }

    void startCapturing(Point point) {
        recordVisibleChildren();
        if (!isEmpty()) {
            this.mIsActive = true;
            Point createAbsolutePoint = this.mHost.createAbsolutePoint(point);
            this.mPointer = createAbsolutePoint;
            this.mRelOrigin = createRelativePoint(createAbsolutePoint);
            this.mRelPointer = createRelativePoint(this.mPointer);
            computeCurrentSelection();
            notifySelectionChanged();
        }
    }

    void stopCapturing() {
        this.mIsActive = false;
    }

    void resizeSelection(Point point) {
        this.mPointer = this.mHost.createAbsolutePoint(point);
        updateModel();
    }

    int getPositionNearestOrigin() {
        return this.mPositionNearestOrigin;
    }

    void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.mIsActive) {
            this.mPointer.x += i;
            this.mPointer.y += i2;
            recordVisibleChildren();
            updateModel();
        }
    }

    private void recordVisibleChildren() {
        for (int i = 0; i < this.mHost.getVisibleChildCount(); i++) {
            int adapterPositionAt = this.mHost.getAdapterPositionAt(i);
            if (this.mHost.hasView(adapterPositionAt) && this.mSelectionPredicate.canSetStateAtPosition(adapterPositionAt, true) && !this.mKnownPositions.get(adapterPositionAt)) {
                this.mKnownPositions.put(adapterPositionAt, true);
                recordItemData(this.mHost.getAbsoluteRectForChildViewAt(i), adapterPositionAt);
            }
        }
    }

    private boolean isEmpty() {
        return this.mColumnBounds.size() == 0 || this.mRowBounds.size() == 0;
    }

    private void recordItemData(Rect rect, int i) {
        if (this.mColumnBounds.size() != this.mHost.getColumnCount()) {
            recordLimits(this.mColumnBounds, new Limits(rect.left, rect.right));
        }
        recordLimits(this.mRowBounds, new Limits(rect.top, rect.bottom));
        SparseIntArray sparseIntArray = this.mColumns.get(rect.left);
        if (sparseIntArray == null) {
            sparseIntArray = new SparseIntArray();
            this.mColumns.put(rect.left, sparseIntArray);
        }
        sparseIntArray.put(rect.top, i);
    }

    private void recordLimits(List<Limits> list, Limits limits) {
        int binarySearch = Collections.binarySearch(list, limits);
        if (binarySearch < 0) {
            list.add(~binarySearch, limits);
        }
    }

    private void updateModel() {
        RelativePoint relativePoint = this.mRelPointer;
        RelativePoint createRelativePoint = createRelativePoint(this.mPointer);
        this.mRelPointer = createRelativePoint;
        if (relativePoint == null || !createRelativePoint.equals(relativePoint)) {
            computeCurrentSelection();
            notifySelectionChanged();
        }
    }

    private void computeCurrentSelection() {
        if (areItemsCoveredByBand(this.mRelPointer, this.mRelOrigin)) {
            updateSelection(computeBounds());
            return;
        }
        this.mSelection.clear();
        this.mPositionNearestOrigin = -1;
    }

    private void notifySelectionChanged() {
        for (SelectionObserver selectionObserver : this.mOnSelectionChangedListeners) {
            selectionObserver.onSelectionChanged(this.mSelection);
        }
    }

    private void updateSelection(Rect rect) {
        int binarySearch = Collections.binarySearch(this.mColumnBounds, new Limits(rect.left, rect.left));
        Preconditions.checkArgument(binarySearch >= 0, "Rect doesn't intesect any known column.");
        int i = binarySearch;
        int i2 = i;
        while (i < this.mColumnBounds.size() && this.mColumnBounds.get(i).lowerLimit <= rect.right) {
            i2 = i;
            i++;
        }
        int binarySearch2 = Collections.binarySearch(this.mRowBounds, new Limits(rect.top, rect.top));
        if (binarySearch2 < 0) {
            this.mPositionNearestOrigin = -1;
            return;
        }
        int i3 = binarySearch2;
        int i4 = i3;
        while (i3 < this.mRowBounds.size() && this.mRowBounds.get(i3).lowerLimit <= rect.bottom) {
            i4 = i3;
            i3++;
        }
        updateSelection(binarySearch, i2, binarySearch2, i4);
    }

    private void updateSelection(int i, int i2, int i3, int i4) {
        this.mSelection.clear();
        for (int i5 = i; i5 <= i2; i5++) {
            SparseIntArray sparseIntArray = this.mColumns.get(this.mColumnBounds.get(i5).lowerLimit);
            for (int i6 = i3; i6 <= i4; i6++) {
                int i7 = sparseIntArray.get(this.mRowBounds.get(i6).lowerLimit, -1);
                if (i7 != -1) {
                    K key = this.mKeyProvider.getKey(i7);
                    if (key != null && canSelect(key)) {
                        this.mSelection.add(key);
                    }
                    if (isPossiblePositionNearestOrigin(i5, i, i2, i6, i3, i4)) {
                        this.mPositionNearestOrigin = i7;
                    }
                }
            }
        }
    }

    private boolean canSelect(K k) {
        return this.mSelectionPredicate.canSetStateForKey(k, true);
    }

    private boolean isPossiblePositionNearestOrigin(int i, int i2, int i3, int i4, int i5, int i6) {
        int computeCornerNearestOrigin = computeCornerNearestOrigin();
        if (computeCornerNearestOrigin == 0) {
            return i == i2 && i4 == i5;
        }
        if (computeCornerNearestOrigin == 1) {
            return i == i2 && i4 == i6;
        }
        if (computeCornerNearestOrigin == 2) {
            return i == i3 && i4 == i5;
        }
        if (computeCornerNearestOrigin == 3) {
            return i4 == i6;
        }
        throw new RuntimeException("Invalid corner type.");
    }

    void addOnSelectionChangedListener(SelectionObserver selectionObserver) {
        this.mOnSelectionChangedListeners.add(selectionObserver);
    }

    void onDestroy() {
        this.mOnSelectionChangedListeners.clear();
        this.mHost.removeOnScrollListener(this.mScrollListener);
    }

    private static class Limits implements Comparable<Limits> {
        public int lowerLimit;
        public int upperLimit;

        Limits(int i, int i2) {
            this.lowerLimit = i;
            this.upperLimit = i2;
        }

        public int compareTo(Limits limits) {
            return this.lowerLimit - limits.lowerLimit;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.lowerLimit ^ this.upperLimit;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof Limits)) {
                return false;
            }
            Limits limits = (Limits) obj;
            if (limits.lowerLimit == this.lowerLimit && limits.upperLimit == this.upperLimit) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            return "(" + this.lowerLimit + ", " + this.upperLimit + ")";
        }
    }

    private static class RelativeCoordinate implements Comparable<RelativeCoordinate> {
        static final int AFTER_LAST_ITEM = 0;
        static final int BEFORE_FIRST_ITEM = 1;
        static final int BETWEEN_TWO_ITEMS = 2;
        static final int WITHIN_LIMITS = 3;
        public Limits limitsAfterCoordinate;
        public Limits limitsBeforeCoordinate;
        public Limits mFirstKnownItem;
        public Limits mLastKnownItem;
        public final int type;

        RelativeCoordinate(List<Limits> list, int i) {
            int binarySearch = Collections.binarySearch(list, new Limits(i, i));
            if (binarySearch >= 0) {
                this.type = 3;
                this.limitsBeforeCoordinate = list.get(binarySearch);
                return;
            }
            int i2 = ~binarySearch;
            if (i2 == 0) {
                this.type = 1;
                this.mFirstKnownItem = list.get(0);
            } else if (i2 == list.size()) {
                Limits limits = list.get(list.size() - 1);
                if (limits.lowerLimit > i || i > limits.upperLimit) {
                    this.type = 0;
                    this.mLastKnownItem = limits;
                    return;
                }
                this.type = 3;
                this.limitsBeforeCoordinate = limits;
            } else {
                int i3 = i2 - 1;
                Limits limits2 = list.get(i3);
                if (limits2.lowerLimit > i || i > limits2.upperLimit) {
                    this.type = 2;
                    this.limitsBeforeCoordinate = list.get(i3);
                    this.limitsAfterCoordinate = list.get(i2);
                    return;
                }
                this.type = 3;
                this.limitsBeforeCoordinate = list.get(i3);
            }
        }

        int toComparisonValue() {
            int i = this.type;
            if (i == 1) {
                return this.mFirstKnownItem.lowerLimit - 1;
            }
            if (i == 0) {
                return this.mLastKnownItem.upperLimit + 1;
            }
            if (i == 2) {
                return this.limitsBeforeCoordinate.upperLimit + 1;
            }
            return this.limitsBeforeCoordinate.lowerLimit;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return ((this.mFirstKnownItem.lowerLimit ^ this.mLastKnownItem.upperLimit) ^ this.limitsBeforeCoordinate.upperLimit) ^ this.limitsBeforeCoordinate.lowerLimit;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if ((obj instanceof RelativeCoordinate) && toComparisonValue() == ((RelativeCoordinate) obj).toComparisonValue()) {
                return true;
            }
            return false;
        }

        public int compareTo(RelativeCoordinate relativeCoordinate) {
            return toComparisonValue() - relativeCoordinate.toComparisonValue();
        }
    }

    RelativePoint createRelativePoint(Point point) {
        return new RelativePoint(new RelativeCoordinate(this.mColumnBounds, point.x), new RelativeCoordinate(this.mRowBounds, point.y));
    }

    private static class RelativePoint {
        final RelativeCoordinate mX;
        final RelativeCoordinate mY;

        RelativePoint(List<Limits> list, List<Limits> list2, Point point) {
            this.mX = new RelativeCoordinate(list, point.x);
            this.mY = new RelativeCoordinate(list2, point.y);
        }

        RelativePoint(RelativeCoordinate relativeCoordinate, RelativeCoordinate relativeCoordinate2) {
            this.mX = relativeCoordinate;
            this.mY = relativeCoordinate2;
        }

        public int hashCode() {
            return this.mX.toComparisonValue() ^ this.mY.toComparisonValue();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof RelativePoint)) {
                return false;
            }
            RelativePoint relativePoint = (RelativePoint) obj;
            if (!this.mX.equals(relativePoint.mX) || !this.mY.equals(relativePoint.mY)) {
                return false;
            }
            return true;
        }
    }

    private Rect computeBounds() {
        Rect rect = new Rect();
        rect.left = getCoordinateValue(min(this.mRelOrigin.mX, this.mRelPointer.mX), this.mColumnBounds, true);
        rect.right = getCoordinateValue(max(this.mRelOrigin.mX, this.mRelPointer.mX), this.mColumnBounds, false);
        rect.top = getCoordinateValue(min(this.mRelOrigin.mY, this.mRelPointer.mY), this.mRowBounds, true);
        rect.bottom = getCoordinateValue(max(this.mRelOrigin.mY, this.mRelPointer.mY), this.mRowBounds, false);
        return rect;
    }

    private int computeCornerNearestOrigin() {
        int i = this.mRelOrigin.mY.equals(min(this.mRelOrigin.mY, this.mRelPointer.mY)) ? 0 : 1;
        return this.mRelOrigin.mX.equals(min(this.mRelOrigin.mX, this.mRelPointer.mX)) ? i | 0 : i | 2;
    }

    private RelativeCoordinate min(RelativeCoordinate relativeCoordinate, RelativeCoordinate relativeCoordinate2) {
        return relativeCoordinate.compareTo(relativeCoordinate2) < 0 ? relativeCoordinate : relativeCoordinate2;
    }

    private RelativeCoordinate max(RelativeCoordinate relativeCoordinate, RelativeCoordinate relativeCoordinate2) {
        return relativeCoordinate.compareTo(relativeCoordinate2) > 0 ? relativeCoordinate : relativeCoordinate2;
    }

    private int getCoordinateValue(RelativeCoordinate relativeCoordinate, List<Limits> list, boolean z) {
        int i = relativeCoordinate.type;
        if (i == 0) {
            return list.get(list.size() - 1).upperLimit;
        }
        if (i == 1) {
            return list.get(0).lowerLimit;
        }
        if (i != 2) {
            if (i == 3) {
                return relativeCoordinate.limitsBeforeCoordinate.lowerLimit;
            }
            throw new RuntimeException("Invalid coordinate value.");
        } else if (z) {
            return relativeCoordinate.limitsAfterCoordinate.lowerLimit;
        } else {
            return relativeCoordinate.limitsBeforeCoordinate.upperLimit;
        }
    }

    private boolean areItemsCoveredByBand(RelativePoint relativePoint, RelativePoint relativePoint2) {
        return doesCoordinateLocationCoverItems(relativePoint.mX, relativePoint2.mX) && doesCoordinateLocationCoverItems(relativePoint.mY, relativePoint2.mY);
    }

    private boolean doesCoordinateLocationCoverItems(RelativeCoordinate relativeCoordinate, RelativeCoordinate relativeCoordinate2) {
        if (relativeCoordinate.type == 1 && relativeCoordinate2.type == 1) {
            return false;
        }
        if (relativeCoordinate.type == 0 && relativeCoordinate2.type == 0) {
            return false;
        }
        return relativeCoordinate.type != 2 || relativeCoordinate2.type != 2 || !relativeCoordinate.limitsBeforeCoordinate.equals(relativeCoordinate2.limitsBeforeCoordinate) || !relativeCoordinate.limitsAfterCoordinate.equals(relativeCoordinate2.limitsAfterCoordinate);
    }

    static abstract class GridHost<K> extends BandSelectionHelper.BandHost<K> {
        abstract Point createAbsolutePoint(Point point);

        abstract Rect getAbsoluteRectForChildViewAt(int i);

        abstract int getAdapterPositionAt(int i);

        abstract int getColumnCount();

        abstract int getVisibleChildCount();

        abstract boolean hasView(int i);

        abstract void removeOnScrollListener(RecyclerView.OnScrollListener onScrollListener);

        GridHost() {
        }
    }
}
