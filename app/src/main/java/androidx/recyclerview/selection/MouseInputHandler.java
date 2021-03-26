package androidx.recyclerview.selection;

import android.view.MotionEvent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.ItemDetailsLookup;

final class MouseInputHandler<K> extends MotionInputHandler<K> {
    private static final String TAG = "MouseInputDelegate";
    private final ItemDetailsLookup<K> mDetailsLookup;
    private final FocusDelegate<K> mFocusDelegate;
    private boolean mHandledOnDown;
    private boolean mHandledTapUp;
    private final OnContextClickListener mOnContextClickListener;
    private final OnItemActivatedListener<K> mOnItemActivatedListener;

    MouseInputHandler(SelectionTracker<K> selectionTracker, ItemKeyProvider<K> itemKeyProvider, ItemDetailsLookup<K> itemDetailsLookup, OnContextClickListener onContextClickListener, OnItemActivatedListener<K> onItemActivatedListener, FocusDelegate<K> focusDelegate) {
        super(selectionTracker, itemKeyProvider, focusDelegate);
        boolean z = true;
        Preconditions.checkArgument(itemDetailsLookup != null);
        Preconditions.checkArgument(onContextClickListener != null);
        Preconditions.checkArgument(onItemActivatedListener == null ? false : z);
        this.mDetailsLookup = itemDetailsLookup;
        this.mOnContextClickListener = onContextClickListener;
        this.mOnItemActivatedListener = onItemActivatedListener;
        this.mFocusDelegate = focusDelegate;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if ((!MotionEvents.isAltKeyPressed(motionEvent) || !MotionEvents.isPrimaryMouseButtonPressed(motionEvent)) && !MotionEvents.isSecondaryMouseButtonPressed(motionEvent)) {
            return false;
        }
        this.mHandledOnDown = true;
        return onRightClick(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return !MotionEvents.isTouchpadScroll(motionEvent2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.mHandledOnDown) {
            this.mHandledOnDown = false;
            return false;
        } else if (!this.mDetailsLookup.overItemWithSelectionKey(motionEvent)) {
            this.mSelectionTracker.clearSelection();
            this.mFocusDelegate.clearFocus();
            return false;
        } else if (MotionEvents.isTertiaryMouseButtonPressed(motionEvent) || !this.mSelectionTracker.hasSelection()) {
            return false;
        } else {
            onItemClick(motionEvent, this.mDetailsLookup.getItemDetails(motionEvent));
            this.mHandledTapUp = true;
            return true;
        }
    }

    private void onItemClick(MotionEvent motionEvent, ItemDetailsLookup.ItemDetails<K> itemDetails) {
        Preconditions.checkState(this.mSelectionTracker.hasSelection());
        Preconditions.checkArgument(itemDetails != null);
        if (isRangeExtension(motionEvent)) {
            extendSelectionRange(itemDetails);
            return;
        }
        if (shouldClearSelection(motionEvent, itemDetails)) {
            this.mSelectionTracker.clearSelection();
        }
        if (!this.mSelectionTracker.isSelected(itemDetails.getSelectionKey())) {
            selectOrFocusItem(itemDetails, motionEvent);
        } else if (this.mSelectionTracker.deselect(itemDetails.getSelectionKey())) {
            this.mFocusDelegate.clearFocus();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ItemDetailsLookup.ItemDetails<K> itemDetails;
        if (this.mHandledTapUp) {
            this.mHandledTapUp = false;
            return false;
        } else if (this.mSelectionTracker.hasSelection() || !this.mDetailsLookup.overItem(motionEvent) || MotionEvents.isTertiaryMouseButtonPressed(motionEvent) || (itemDetails = this.mDetailsLookup.getItemDetails(motionEvent)) == null || !itemDetails.hasSelectionKey()) {
            return false;
        } else {
            if (!this.mFocusDelegate.hasFocusedItem() || !MotionEvents.isShiftKeyPressed(motionEvent)) {
                selectOrFocusItem(itemDetails, motionEvent);
                return true;
            }
            this.mSelectionTracker.startRange(this.mFocusDelegate.getFocusedPosition());
            this.mSelectionTracker.extendRange(itemDetails.getPosition());
            return true;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        ItemDetailsLookup.ItemDetails<K> itemDetails;
        this.mHandledTapUp = false;
        if (this.mDetailsLookup.overItemWithSelectionKey(motionEvent) && !MotionEvents.isTertiaryMouseButtonPressed(motionEvent) && (itemDetails = this.mDetailsLookup.getItemDetails(motionEvent)) != null && this.mOnItemActivatedListener.onItemActivated(itemDetails, motionEvent)) {
            return true;
        }
        return false;
    }

    private boolean onRightClick(MotionEvent motionEvent) {
        ItemDetailsLookup.ItemDetails<K> itemDetails;
        if (this.mDetailsLookup.overItemWithSelectionKey(motionEvent) && (itemDetails = this.mDetailsLookup.getItemDetails(motionEvent)) != null && !this.mSelectionTracker.isSelected(itemDetails.getSelectionKey())) {
            this.mSelectionTracker.clearSelection();
            selectItem(itemDetails);
        }
        return this.mOnContextClickListener.onContextClick(motionEvent);
    }

    private void selectOrFocusItem(ItemDetailsLookup.ItemDetails<K> itemDetails, MotionEvent motionEvent) {
        if (itemDetails.inSelectionHotspot(motionEvent) || MotionEvents.isCtrlKeyPressed(motionEvent)) {
            selectItem(itemDetails);
        } else {
            focusItem(itemDetails);
        }
    }
}
