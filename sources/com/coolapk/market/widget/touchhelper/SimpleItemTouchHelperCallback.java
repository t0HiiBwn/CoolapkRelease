package com.coolapk.market.widget.touchhelper;

import android.graphics.Canvas;
import android.util.Log;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    public static final float ALPHA_FULL = 1.0f;
    private final ItemTouchHelperAdapter mAdapter;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.mAdapter = itemTouchHelperAdapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i = 3;
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            return makeMovementFlags(3, 0);
        }
        this.mAdapter.canSwipe(viewHolder.getAdapterPosition());
        if (!this.mAdapter.canMove(viewHolder.getAdapterPosition())) {
            i = 0;
        }
        return makeMovementFlags(i, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getAdapterPosition() < 0 || viewHolder2.getAdapterPosition() < 0) {
            Log.e("SimpleCallback", "error! position is less than 0!!! source is " + viewHolder.getAdapterPosition() + "  target is " + viewHolder2.getAdapterPosition());
            return false;
        } else if (!this.mAdapter.canMove(viewHolder.getAdapterPosition()) || !this.mAdapter.canMove(viewHolder2.getAdapterPosition())) {
            return false;
        } else {
            this.mAdapter.onItemMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (i == 2) {
            if (!z) {
                viewHolder.itemView.setAlpha(1.0f);
            } else {
                viewHolder.itemView.setAlpha(0.4f);
            }
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i == 2 && (viewHolder instanceof ItemTouchHelperViewHolder)) {
            ((ItemTouchHelperViewHolder) viewHolder).onItemSelected();
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        if (viewHolder instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder) viewHolder).onItemClear(viewHolder.getAdapterPosition());
        }
    }
}
