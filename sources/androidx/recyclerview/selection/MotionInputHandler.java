package androidx.recyclerview.selection;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.ItemDetailsLookup;

abstract class MotionInputHandler<K> extends GestureDetector.SimpleOnGestureListener {
    private final FocusDelegate<K> mFocusDelegate;
    private final ItemKeyProvider<K> mKeyProvider;
    protected final SelectionTracker<K> mSelectionTracker;

    MotionInputHandler(SelectionTracker<K> selectionTracker, ItemKeyProvider<K> itemKeyProvider, FocusDelegate<K> focusDelegate) {
        boolean z = true;
        Preconditions.checkArgument(selectionTracker != null);
        Preconditions.checkArgument(itemKeyProvider != null);
        Preconditions.checkArgument(focusDelegate == null ? false : z);
        this.mSelectionTracker = selectionTracker;
        this.mKeyProvider = itemKeyProvider;
        this.mFocusDelegate = focusDelegate;
    }

    final boolean selectItem(ItemDetailsLookup.ItemDetails<K> itemDetails) {
        Preconditions.checkArgument(itemDetails != null);
        Preconditions.checkArgument(hasPosition(itemDetails));
        Preconditions.checkArgument(hasSelectionKey(itemDetails));
        if (this.mSelectionTracker.select(itemDetails.getSelectionKey())) {
            this.mSelectionTracker.anchorRange(itemDetails.getPosition());
        }
        if (this.mSelectionTracker.getSelection().size() == 1) {
            this.mFocusDelegate.focusItem(itemDetails);
        } else {
            this.mFocusDelegate.clearFocus();
        }
        return true;
    }

    protected final boolean focusItem(ItemDetailsLookup.ItemDetails<K> itemDetails) {
        Preconditions.checkArgument(itemDetails != null);
        Preconditions.checkArgument(hasSelectionKey(itemDetails));
        this.mSelectionTracker.clearSelection();
        this.mFocusDelegate.focusItem(itemDetails);
        return true;
    }

    protected final void extendSelectionRange(ItemDetailsLookup.ItemDetails<K> itemDetails) {
        Preconditions.checkState(this.mKeyProvider.hasAccess(0));
        Preconditions.checkArgument(hasPosition(itemDetails));
        Preconditions.checkArgument(hasSelectionKey(itemDetails));
        this.mSelectionTracker.extendRange(itemDetails.getPosition());
        this.mFocusDelegate.focusItem(itemDetails);
    }

    final boolean isRangeExtension(MotionEvent motionEvent) {
        if (!MotionEvents.isShiftKeyPressed(motionEvent) || !this.mSelectionTracker.isRangeActive() || !this.mKeyProvider.hasAccess(0)) {
            return false;
        }
        return true;
    }

    boolean shouldClearSelection(MotionEvent motionEvent, ItemDetailsLookup.ItemDetails<K> itemDetails) {
        return !MotionEvents.isCtrlKeyPressed(motionEvent) && !itemDetails.inSelectionHotspot(motionEvent) && !this.mSelectionTracker.isSelected(itemDetails.getSelectionKey());
    }

    static boolean hasSelectionKey(ItemDetailsLookup.ItemDetails<?> itemDetails) {
        return (itemDetails == null || itemDetails.getSelectionKey() == null) ? false : true;
    }

    static boolean hasPosition(ItemDetailsLookup.ItemDetails<?> itemDetails) {
        return (itemDetails == null || itemDetails.getPosition() == -1) ? false : true;
    }
}
