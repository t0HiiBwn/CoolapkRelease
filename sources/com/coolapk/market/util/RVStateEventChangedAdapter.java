package com.coolapk.market.util;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.event.Event;

public class RVStateEventChangedAdapter extends StateEventChangedAdapter {
    private RecyclerView recyclerView;

    public interface IStateViewHolder {
        boolean onStateEventChanged(Event event);
    }

    public RVStateEventChangedAdapter(RecyclerView recyclerView2) {
        this.recyclerView = recyclerView2;
    }

    @Override // com.coolapk.market.util.StateEventChangedAdapter
    protected void notifyEventChanged(Event event) {
        RecyclerView recyclerView2 = this.recyclerView;
        for (int i = 0; i < recyclerView2.getChildCount(); i++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView2.getChildViewHolder(recyclerView2.getChildAt(i));
            if ((childViewHolder instanceof IStateViewHolder) && ((IStateViewHolder) childViewHolder).onStateEventChanged(event) && childViewHolder.getAdapterPosition() != -1) {
                recyclerView2.getAdapter().notifyItemChanged(childViewHolder.getAdapterPosition());
            }
        }
    }
}
