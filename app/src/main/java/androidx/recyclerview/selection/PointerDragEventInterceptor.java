package androidx.recyclerview.selection;

import android.view.MotionEvent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

final class PointerDragEventInterceptor implements RecyclerView.OnItemTouchListener {
    private RecyclerView.OnItemTouchListener mDelegate;
    private final OnDragInitiatedListener mDragListener;
    private final ItemDetailsLookup mEventDetailsLookup;

    PointerDragEventInterceptor(ItemDetailsLookup itemDetailsLookup, OnDragInitiatedListener onDragInitiatedListener, RecyclerView.OnItemTouchListener onItemTouchListener) {
        boolean z = true;
        Preconditions.checkArgument(itemDetailsLookup != null);
        Preconditions.checkArgument(onDragInitiatedListener == null ? false : z);
        this.mEventDetailsLookup = itemDetailsLookup;
        this.mDragListener = onDragInitiatedListener;
        this.mDelegate = onItemTouchListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (MotionEvents.isPointerDragEvent(motionEvent) && this.mEventDetailsLookup.inItemDragRegion(motionEvent)) {
            return this.mDragListener.onDragInitiated(motionEvent);
        }
        RecyclerView.OnItemTouchListener onItemTouchListener = this.mDelegate;
        if (onItemTouchListener != null) {
            return onItemTouchListener.onInterceptTouchEvent(recyclerView, motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.OnItemTouchListener onItemTouchListener = this.mDelegate;
        if (onItemTouchListener != null) {
            onItemTouchListener.onTouchEvent(recyclerView, motionEvent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        RecyclerView.OnItemTouchListener onItemTouchListener = this.mDelegate;
        if (onItemTouchListener != null) {
            onItemTouchListener.onRequestDisallowInterceptTouchEvent(z);
        }
    }
}
